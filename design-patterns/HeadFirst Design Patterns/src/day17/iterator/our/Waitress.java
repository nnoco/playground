package day17.iterator.our;


public class Waitress {
	반복가능한<MenuItem> pancakeHouseMenu;
	반복가능한<MenuItem> dinerMenu;
	반복가능한<MenuItem> cafeMenu;
	
	public Waitress(반복가능한<MenuItem> pancakeHouseMenu, 반복가능한<MenuItem> dinerMenu, 반복가능한<MenuItem> cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		// 각 메뉴들의 반복자들을 얻어온다.
		반복자<MenuItem> pancakeIterator = pancakeHouseMenu.iterator();
		반복자<MenuItem> dinerIterator = dinerMenu.iterator();
		
		
		printAll(pancakeIterator);
		printAll(dinerIterator);
	}
	
	private void printAll(반복자<MenuItem> items) {
		// 반복자를 통해서 메뉴들을 반복하여 출력한다.
		while(items.hasNext()) {
			MenuItem menuItem = items.next();
			System.out.print(menuItem.getName() + " " );
			System.out.println(menuItem.getPrice() + " ");
			System.out.println(menuItem.getDescription());
		}
	}
}
