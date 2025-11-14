package tutorial10.food;

import java.awt.Color;
import tutorial10.Caterpillar;


public class Fruit extends FoodItem {
	private Color color;
	
	public Fruit(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return this.color;
	}

	
	public void accept(Caterpillar c) {
		c.eat(this);
	}
}
