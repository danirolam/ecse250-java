package tutorial10.food;

import tutorial10.Caterpillar;


public class SwissCheese extends FoodItem{
	
	public void accept(Caterpillar c) {
		c.eat(this);
	}

}
