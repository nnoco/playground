package day6;

import day6.ingredient.Cheese;
import day6.ingredient.Clams;
import day6.ingredient.Dough;
import day6.ingredient.Pepperoni;
import day6.ingredient.Sauce;
import day6.ingredient.Veggies;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

}
