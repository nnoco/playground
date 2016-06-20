package day6;

public abstract class PizzaStore {
	public void orderPizza(String type) {
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.box();
	}
	
	public abstract Pizza createPizza(String type);
}
