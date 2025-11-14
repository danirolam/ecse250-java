package tutorial10.food;

import tutorial10.Caterpillar;


public class IceCream extends FoodItem{
	
	public void accept(Caterpillar c) {
		c.eat(this);
	}

}
