package day16;

import day17.Menu;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;
	
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		java.util.Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		java.util.Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		java.util.Iterator<MenuItem> cafeMenuIterator = cafeMenu.createIterator();
		
		
		printAll(pancakeIterator);
		printAll(dinerIterator);
		printAll(cafeMenuIterator);
	}
	
	private void printAll(java.util.Iterator<MenuItem> items) {
		while(items.hasNext()) {
			MenuItem menuItem = items.next();
			System.out.print(menuItem.getName() + " " );
			System.out.println(menuItem.getPrice() + " ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public boolean isItemVegetarian(String name) {
		return false;
	}
}
