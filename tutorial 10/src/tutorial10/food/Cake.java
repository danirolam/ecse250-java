package tutorial10.food;

import tutorial10.Caterpillar;

public class Cake extends FoodItem{
	private int energyProvided;
	
	public Cake(int energy) {
		this.energyProvided = energy;
	}
	
	public int getEnergyProvided() {
		return this.energyProvided;
	}
	
	public void accept(Caterpillar c) {
		c.eat(this);
	}

}
