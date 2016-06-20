package day17.iterator.java;

import java.util.Iterator;


public class Waitress {
	Iterable<MenuItem> pancakeHouseMenu;
	Iterable<MenuItem> dinerMenu;
	Iterable<MenuItem> cafeMenu;
	
	public Waitress(Iterable<MenuItem> pancakeHouseMenu, Iterable<MenuItem> dinerMenu, Iterable<MenuItem> cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		// 각 메뉴들의 Iterator들을 얻어온다.
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.iterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.iterator();
		
		
		printAll(pancakeIterator);
		printAll(dinerIterator);
	}
	
	private void printAll(Iterator<MenuItem> items) {
		// Iterator를 통해서 메뉴들을 반복하여 출력한다.
		while(items.hasNext()) {
			MenuItem menuItem = items.next();
			System.out.print(menuItem.getName() + " " );
			System.out.println(menuItem.getPrice() + " ");
			System.out.println(menuItem.getDescription());
		}
	}
}
