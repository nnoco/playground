package day20.composite;

/**
 * 리스트(ArrayList 등)의 요소들을 탐색할 수 있는 반복자이다.
 */
import java.util.Iterator;
import java.util.List;

public class ListIterator<T> implements Iterator<T> {
	private List<T> list;
	private int position;
	
	public ListIterator(List<T> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (position < list.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T next() {
		return list.get(position++);
	}

}
