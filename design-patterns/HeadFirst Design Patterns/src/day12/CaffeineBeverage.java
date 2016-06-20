package day12;

public abstract class CaffeineBeverage {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	public void boilWater() {
		System.out.println("물 끓이는 중");
		
	}
	
	abstract void brew();
	
	public void pourInCup() {
		System.out.println("컵에 따르는 중");
		
	}
	
	abstract void addCondiments();

}
