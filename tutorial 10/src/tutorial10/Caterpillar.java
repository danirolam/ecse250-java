package tutorial10;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tutorial10.food.*;


public class Caterpillar {
	// All the fields have been declared public for testing purposes
	public Segment head;
	public Segment tail;
	public int length;
	private LinkedList<Segment> segments = new LinkedList<>();
	public EvolutionStage stage;

	public MyStack<Position> positionsPreviouslyOccupied;
	public int goal;
	public int turnsNeededToDigest;


	public static Random randNumGenerator = new Random(1);

	// Creates a Caterpillar with one Segment. It is up to students to decide how to implement this. 
	public Caterpillar(Position p, Color c, int goal) {
			Segment first = new Segment(p, c);
			this.segments.add(first);

			this.head = first;
			this.tail = first;
			this.length = 1;
			this.goal = goal;
			this.stage = EvolutionStage.FEEDING_STAGE;
			positionsPreviouslyOccupied = new MyStack<>();
	}

	private void syncEnds() {
			this.head = segments.getFirst();
			this.tail = segments.getLast();
			this.length = segments.size();
	}

	public EvolutionStage getEvolutionStage() {
		return this.stage;
	}

	public Position getHeadPosition() {
		return this.head.position;
	}

	public int getLength() {
		return this.length;
	}


	// returns the color of the segment in position p. Returns null if such segment does not exist
	public Color getSegmentColor(Position p) {
			for (Segment s : segments) {
					if (s.position.equals(p)) return s.color;
			}
			return null;
	}


	// Methods that need to be added for the game to work
	public Color[] getColors() {
			Color[] cs = new Color[segments.size()];
			int i = 0;
			for (Segment s : segments) cs[i++] = s.color;
			return cs;
	}

	public Position[] getPositions() {
			Position[] ps = new Position[segments.size()];
			int i = 0;
			for (Segment s : segments) ps[i++] = s.position;
			return ps;
	}


	// shift all Segments to the previous Position while maintaining the old color
	// the length of the caterpillar is not affected by this
	public void move(Position p) {
			if (Position.getDistance(p, this.head.position) != 1) {
					throw new IllegalArgumentException("The position " + p + " is not reachable by this caterpillar " + this);
			}

			if (this.isEntangled(p)) {
					this.stage = EvolutionStage.ENTANGLED;
					return;
			}

			// remember old tail position
			Position oldTail = segments.getLast().position;

			// shift body forward
			for (int i = segments.size() - 1; i > 0; i--) {
					segments.get(i).position = segments.get(i - 1).position;
			}
			// move head
			segments.getFirst().position = p;

			this.positionsPreviouslyOccupied.push(oldTail);

			if (this.turnsNeededToDigest > 0) {
					if (addRandomLastSegment()) {
							this.turnsNeededToDigest--;
					}
			} else if (this.stage == EvolutionStage.GROWING_STAGE) {
					this.stage = EvolutionStage.FEEDING_STAGE;
			}

			syncEnds();
	}

	private boolean isEntangled(Position p) {
			if (p.equals(segments.getLast().position)) return false;
			for (Segment s : segments) {
					if (s.position.equals(p)) return true;
			}
			return false;
	}

	private boolean addLast(Position p, Color c) {
			segments.addLast(new Segment(p, c));
			syncEnds();
			if (this.length == this.goal) this.stage = EvolutionStage.BUTTERFLY;
			return true;
	}

	private boolean addRandomLastSegment() {
			if (this.positionsPreviouslyOccupied.empty()) return false;

			Position p = this.positionsPreviouslyOccupied.peek();
			if (this.getSegmentColor(p) != null) return false;

			p = this.positionsPreviouslyOccupied.pop();

			int i = Caterpillar.randNumGenerator.nextInt(GameColors.SEGMENT_COLORS.length);
			Color c = GameColors.SEGMENT_COLORS[i];

			return addLast(p, c);
	}

	public void eat(Fruit f) {
        if (positionsPreviouslyOccupied.empty()) {
        System.out.println("Previously occupied space is empty");
        }

        Color color = f.getColor();
        Position previousOccupied = positionsPreviouslyOccupied.pop();      // when moves, positionPreviouslyOccupied = old tail
        addLast(previousOccupied, color);

	}

	public void eat(Pickle p) {
        if (positionsPreviouslyOccupied.empty()) {
            System.out.println("Previously occupied space is empty");
        }


        // reverse the head
        for (int i = 0; i < segments.size() -1; i ++){
            segments.get(i).position = segments.get(i + 1).position;

        }
        Position newTail = positionsPreviouslyOccupied.pop();
        segments.getLast().position = newTail;
        syncEnds();

	}

	public void eat(IceCream gelato) {
        // reverse the linked list
        LinkedList<Segment> reverseLinkedList = new LinkedList<>();
        for (int i = 0; i < segments.size(); i++) {     // same as Segment s : this.segments
            reverseLinkedList.addFirst(segments.get(i));

        }
        this.segments = reverseLinkedList;
        syncEnds();

        this.head.color = GameColors.BLUE;
        this.positionsPreviouslyOccupied = new MyStack<Position>();     // losing track of previous occupied positions

    }


	public void eat(SwissCheese cheese) {
        LinkedList<Segment> newLinkedList = new LinkedList<>();

        int newLength;
        if (this.length % 2 == 1){
            newLength = this.length / 2 + 1;
        }
        else{
            newLength = this.length / 2;
        }
        for (int i = 0; i < newLength; i = i + 1){
            Position newPosition = this.segments.get(i).position;
            Color keepColors = this.segments.get(i * 2).color;        // take the colors for every second segment
            newLinkedList.add(new Segment(newPosition, keepColors));
        }
        this.segments = newLinkedList;
        syncEnds();

	}

	public void eat(Lollipop lolly) {
			if (segments.size() <= 1) return;

			Color[] cs = new Color[segments.size()];
			for (int i = 0; i < segments.size(); i++) cs[i] = segments.get(i).color;

			for (int i = cs.length - 1; i > 0; i--) {
					int j = Caterpillar.randNumGenerator.nextInt(i + 1);
					Color tmp = cs[j]; cs[j] = cs[i]; cs[i] = tmp;
			}

			for (int i = 0; i < segments.size(); i++) segments.get(i).color = cs[i];
	}
	
	public void eat(Cake cake) {
		if (positionsPreviouslyOccupied.empty()) {
			System.out.println("Previously occupied space is empty");
		}

		this.stage = EvolutionStage.GROWING_STAGE;
		this.turnsNeededToDigest = cake.getEnergyProvided();

		while (!this.positionsPreviouslyOccupied.empty() && this.turnsNeededToDigest > 0) {
			boolean success = addRandomLastSegment();
			if (!success || this.stage == EvolutionStage.BUTTERFLY) {
				break;
			}
			this.turnsNeededToDigest--;
		}
		if (this.turnsNeededToDigest == 0 && this.stage != EvolutionStage.BUTTERFLY)
			this.stage = EvolutionStage.FEEDING_STAGE;
	}


	// This nested class was declared public for testing purposes
	public class Segment {
			private Position position;
			private Color color;

			public Segment(Position p, Color c) {
					this.position = p;
					this.color = c;
			}
	}


	public String toString() {
			String snake = "";
			for (Segment s : segments) {
					String coloredPosition = GameColors.colorToANSIColor(s.color) +
									s.position.toString() + GameColors.colorToANSIColor(Color.WHITE);
					snake = coloredPosition + " " + snake;
			}
			return snake;
	}

	public static void main(String[] args) {
		test_fruit() ;

		Position startingPoint = new Position(3, 2);
		Caterpillar gus = new Caterpillar(startingPoint, GameColors.GREEN, 10);

		System.out.println("1) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

		gus.move(new Position(3, 1));
		gus.eat(new Fruit(GameColors.RED));
		gus.move(new Position(2, 1));
		gus.move(new Position(1, 1));
		gus.eat(new Fruit(GameColors.YELLOW));


		System.out.println("\n2) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

		gus.move(new Position(1, 2));
		gus.eat(new IceCream());

		System.out.println("\n3) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

		gus.move(new Position(3, 1));
		gus.move(new Position(3, 2));
		gus.eat(new Fruit(GameColors.ORANGE));


		System.out.println("\n4) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

		gus.move(new Position(2, 2));
		gus.eat(new SwissCheese());

		System.out.println("\n5) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

		gus.move(new Position(2, 3));
		gus.eat(new Cake(4));

		System.out.println("\n6) Gus: " + gus);
		System.out.println("Stack of previously occupied positions: " + gus.positionsPreviouslyOccupied);

	}

	public static void test_fruit() {

		Caterpillar gus = new Caterpillar(new Position(1, 1), Color.BLACK, 1);

		Position new_position = new Position(1,0) ;
		gus.positionsPreviouslyOccupied.push(new_position);
		Fruit fruit = new Fruit(GameColors.RED);
		gus.eat(fruit);

		Color[] gus_color = gus.getColors() ;
		Position[] gus_position = gus.getPositions() ;

		for ( int i = 0 ; i< gus_color.length ; i++ ) {
			System.out.println(gus_color[i]) ;
			System.out.println(gus_position[i]) ;
		}

	}
}
