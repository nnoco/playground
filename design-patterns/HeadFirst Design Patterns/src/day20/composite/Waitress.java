package day20.composite;

import java.util.Iterator;


public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
	
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.iterator();
		System.out.println("\nVEGETERIAN MENU\n----");
		while(iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			
			try {
				if(menuComponent.isVegitarian()) {
					menuComponent.print();
				}
			} catch(UnsupportedOperationException e) {}
		}
	}
}
