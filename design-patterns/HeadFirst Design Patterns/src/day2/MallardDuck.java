package day2;

public class MallardDuck extends Duck implements Quackable, Flyable{
	
	@Override
	public void display() {
		System.out.println("청둥오리");
	}

	@Override
	public void fly() {
		System.out.println("MallardDuck이 날고 이쪙!");
		
	}

	@Override
	public void quack() {
		System.out.println("MallardDuck은 말라드 말라드하고 웁니다.");
		
	}
}
