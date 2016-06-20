package day20.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent implements Iterable<MenuComponent>{
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
		
		java.util.Iterator<MenuComponent> iterator = menuComponents.iterator();
		while(iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}

	@Override
	public Iterator<MenuComponent> iterator() {
		return new CompositeIterator(menuComponents.iterator());
	}

}
