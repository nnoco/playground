package day11;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
	public static void main(String[] args) {
		Button button = new Button();
		button.setOnClickListener(() -> {
				System.out.println("버튼이 클릭됨!");
			});
		
		button.performClick();
		
		
		Display display = new Display();
		
		display.showSomething(button,
				b -> b != null
		, () -> { System.out.println(button.getName());});
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		list.forEach(i -> {
			System.out.println(i);
		});
		
		display.genericTest("String");
		display.genericTest(1);
		
		display.<Integer>genericTest(9385739);
		
		int i = 1_000_000;
		
		System.out.println(i);
		
	}
}

class Display {
	public void showSomething(Button b, Predicate p, Something s) {
		if(p.testIsNotNull(b)) {
			s.show();
		}
	}
	
	public <T> void genericTest(T t) {
		System.out.println(t.getClass().getName());
	}
}

interface Predicate {
	public boolean testIsNotNull(Button b);
}

interface Something {
	public void show();
}

class Button {
	OnClickListener listener;
	
	String name;
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void performClick() {
		listener.onClick();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

interface OnClickListener {
	public void onClick();
}
