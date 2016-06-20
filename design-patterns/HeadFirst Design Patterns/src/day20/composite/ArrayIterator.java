package day20.composite;

import java.util.Iterator;

/**
 * 배열을 반복할 수 있는 반복자이다.
 * @author 이준영
 *
 */
public class ArrayIterator<T> implements Iterator<T> {
	private Object[] arr;
	private int position;
	
	public ArrayIterator(Object[] arr) {
		this.arr = arr;
	}

	@Override
	public boolean hasNext() {
		if (position >= arr.length || arr[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public T next() {
		return (T)arr[position++];
	}

}
