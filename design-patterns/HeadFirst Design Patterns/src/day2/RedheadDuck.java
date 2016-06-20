package day2;

public class RedheadDuck extends Duck implements Quackable, Flyable{
	@Override
	public void display() {
		System.out.println("빨간 머리 오리");
	}
	
	@Override
	public void fly() {
		System.out.println("RedheadDuck이 날고 이쪙!");
		
	}

	@Override
	public void quack() {
		System.out.println("RedheadDuck은 빨강 빨강하고 웁니다.");
		
	}
}
