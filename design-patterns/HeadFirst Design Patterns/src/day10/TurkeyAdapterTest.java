package day10;

public class TurkeyAdapterTest {
	public static void main(String[] args) {
		Duck turkeyDuck = new TurkeyAdapter(new WildTurkey());
		
		turkeyDuck.quack();
		turkeyDuck.fly();
	}
}
