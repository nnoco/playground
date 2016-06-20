package day2;


public class DuckTest {
	
	public static void main(String[] args) {
		new DuckTest().test();
	}

	public void test() {
		Duck md = new MallardDuck();
		Duck rd = new RedheadDuck();
		Duck rubber = new RubberDuck();
		
		md.display();
		rd.display();
		
		Flyable flyableDuck1 = (Flyable)md;
		Flyable flyableDuck2 = (Flyable)rd;
		Flyable flyableDuck3 = (Flyable)rubber;
		
		flyableDuck1.fly();
		flyableDuck2.fly();
		flyableDuck3.fly();
		
	}

}
