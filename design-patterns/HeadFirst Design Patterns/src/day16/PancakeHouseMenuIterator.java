package day16;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
	private List<MenuItem> items;
	private int position;
	
	public PancakeHouseMenuIterator(List<MenuItem> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		return position < items.size();
	}

	@Override
	public MenuItem next() {
		MenuItem item = items.get(position++);
		
		return item;
	}

}
