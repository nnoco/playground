package day17.iterator.java;

import java.util.ArrayList;
import java.util.Iterator;

import day17.Menu;

public class PancakeHouseMenu implements Iterable<MenuItem>{
// "반복가능한<MenuItem>"을 우리말로 표현해보자면 MenuItem타입에 대해서 반복할 수 있는 이라고 볼 수 있다.
	ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("K&B 팬케이크 세트",
				"스크램블드 에그와 토스트가 곁들여진 팬케이크",
				true,
				2.99);
		
		addItem("레귤러 팬케이크 세트",
				"달걀 후라이와 소시지가 곁들여진 팬케이크",
				false,
				2.99);
		
		addItem("블루베리 팬케이크",
				"신선한 블루베리와 블루베리 시럽으로 만든 팬케이크",
				true,
				3.49);
		
		addItem("와플",
				"와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.",
				true,
				3.59);
	}
	
	public void addItem(String name, String description, boolean vegitarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegitarian, price);
		menuItems.add(menuItem);
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * DinerMenu와 마찬가지로 '반복가능한'인터페이스의 iterator()를 구현한다.
	 * iterator() 메서드의 역할은 PancakeHouseMenu의 menuItems의 요소들을 반복할 수 있는
	 * 반복자를 생성해서 반환하는 것뿐이다. 반복에 대한 구체적인 구현은 반복자 내에서 이뤄진다.
	 * 
	 * ! 정말로 얘는 반복자만 어디서 구하든 생성하든 "반환만" 해주면 된다.
	 */
	@Override
	public Iterator<MenuItem> iterator() {
		// 자바의 ArrayList 클래스의 구현을 보면 Iterable 인터페이스를 구현하고 있다.
		// 따라서 ArrayList는 iterator 메서드를 가지고 있으므로
		// 그대로 ArrayList의 iterator()를 호출하여 반환하면 된다.
		// 반면 그냥 배열을 반복하는 Iterator는 자바에 내장되어 있지 않으므로
		// DinerMenu에서는 '배열반복자'를 구현하여 사용함
		
		return menuItems.iterator();
	}
}
