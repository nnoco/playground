package day17;

import java.util.Hashtable;
import java.util.Iterator;

import day16.MenuItem;

public class CafeMenu implements Menu{
	Hashtable<String, MenuItem> menuItems = new Hashtable<String, MenuItem>();
	
	public CafeMenu() {
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}

}
