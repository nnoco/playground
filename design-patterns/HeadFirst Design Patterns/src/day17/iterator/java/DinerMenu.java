package day17.iterator.java;

import java.util.Iterator;

/**
 * DinerMenu 클래스가 '반복가능한' 인터페이스를 구현(implements)함으로써
 * 반복할 수 있는 능력을 가지게 됨.
 * 
 * 자바에 내장되어 있는 Iterable(반복가능한) 인터페이스를 구현한다.
 * @author 이준영
 *
 */
public class DinerMenu implements Iterable<MenuItem>{
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("채식주의자용 BLT", "통밀 위에 (식물성) 베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99);
		addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
		addItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29);
		addItem("핫도그", "샤워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
	}

	public void addItem(String name, String description, boolean vegetarian,
			double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	
	/**
	 * '반복가능한' 인터페이스의 iterator() 메서드를 구현하는 부분
	 * 여기서는 DinerMenu가 가지고 있는 menuItems 배열을 반복할 수 있는
	 * 반복자만 반환해주면 된다. 반복자가 해야하는 구체적인 내용은 배열반복자에서 구현한다.
	 */
	@Override
	public Iterator<MenuItem> iterator() { // 헤드퍼스트에서는 createIterator 메서드였음
		return new 배열반복자<MenuItem>(menuItems);
	}
}
