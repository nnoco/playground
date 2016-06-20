package day17.iterator.our;

/**
 * Iterable 이란 "반복할 수 있는"이라는 의미를 가지고 있고,
 * Iterable을 구현한 구상(Concrete, 추상의 반대)클래스는 
 * Iterable 인터페이스의 iterator() 메서드를 구현하여 해당 구상클래스의
 * 컬렉션을 탐색하기 위한 이터레이터를 반환하도록 한다.
 * 
 * 참고 : Iterable은 헤드퍼스트 디자인 패턴 책에서의 Menu 인터페이스의 역할과 같다.
 * @author 이준영
 *
 */
public interface 반복가능한<T> { // 반복가능한 == Iterable
	public 반복자<T> iterator();
}
