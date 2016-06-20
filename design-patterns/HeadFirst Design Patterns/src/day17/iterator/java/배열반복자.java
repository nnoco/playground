package day17.iterator.java;

import java.util.Iterator;

/**
 * 배열을 반복할 수 있는 반복자이다.
 * 자바에 내장되어 있는 Iterator 반복자를 사용
 * @author 이준영
 *
 */
public class 배열반복자<T> implements Iterator<T> {
	private Object[] arr;
	private int position;
	
	public 배열반복자(Object[] arr) {
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
