package day6;

import day6.ingredient.Cheese;
import day6.ingredient.Clams;
import day6.ingredient.Dough;
import day6.ingredient.FreshClams;
import day6.ingredient.Garlic;
import day6.ingredient.MarinaraSauce;
import day6.ingredient.Mushroom;
import day6.ingredient.Onion;
import day6.ingredient.Pepperoni;
import day6.ingredient.RedPepper;
import day6.ingredient.ReggianoCheese;
import day6.ingredient.Sauce;
import day6.ingredient.SlicedPepperoni;
import day6.ingredient.ThinCrustDough;
import day6.ingredient.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[]{
				new Garlic(),
				new Onion(),
				new Mushroom(),
				new RedPepper()
		};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
