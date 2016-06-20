package day17.iterator.our;

/**
 * 이터레이터는 객체들이 집합되어 있는 자료구조에서 객체들을 탐색할 수 있도록 하는 패턴이다.
 * 이터레이터는 요소가 있는지 확인을 위한 boolean hasNext() 메서드와
 * 요소를 가져오는 next() 메서드로 구성되어 있다.
 * 
 *  참고 : iterator는 반복자를 의미한다.
 * @author 이준영
 *
 */
public interface 반복자<T> { // 반복자 = Iterator
	/**
	 * 반복할 요소(컬렉션의 Element)가 더 존재하는지 확인을 위한 메서드
	 * @return 반복할 요소가 있으면 true, 없으면 false를 반환
	 */
	public boolean hasNext();
	
	/**
	 * 반복할 요소가 있는 경우에 해당 요소를 가져온다.
	 * @return
	 */
	public T next();
}
