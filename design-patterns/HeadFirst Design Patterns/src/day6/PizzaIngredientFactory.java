package day6;

import day6.ingredient.Cheese;
import day6.ingredient.Clams;
import day6.ingredient.Dough;
import day6.ingredient.Pepperoni;
import day6.ingredient.Sauce;
import day6.ingredient.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
