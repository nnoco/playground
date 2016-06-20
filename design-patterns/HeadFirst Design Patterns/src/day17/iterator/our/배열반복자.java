package day17.iterator.our;

/**
 * 배열을 반복할 수 있는 반복자이다.
 * @author 이준영
 *
 */
public class 배열반복자<T> implements 반복자<T> {
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
