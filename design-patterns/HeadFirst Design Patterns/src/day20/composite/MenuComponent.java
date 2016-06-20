package day20.composite;

public abstract class MenuComponent implements Iterable<MenuComponent>{
	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public boolean isVegitarian() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}

	public void add(MenuComponent component) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent component) {
		throw new UnsupportedOperationException();
	}

	public MenuComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}
}
