package tutorial10.food;

import tutorial10.Caterpillar;


public class Pickle extends FoodItem{
	
	public void accept(Caterpillar c) {
		c.eat(this);
	}

}
