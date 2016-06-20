package com.nnoco.playground.java7.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * {@Code @SafeVarags}는 생성자와 메서드를 대상으로 하는 애너테이션으로 다음과 같은 단계에따라 사용한다.
 * 1. 파라미터 수가 일정하지 않은 제네릭타입의 파라미터를 사용하는 메서드 또는 생성자를 작성한다.
 * 2. 메서드를 선언하기 전에 @SafeVarargs를 적어준다.
 * 
 * 자바 7에서는 제네 타입의 인자를 가진 메서드나 생성자에 대해 기본적으로 경고 메시지를 출력한다. 이럴 때 {@Code @SafeVarargs} 애너테이션을 적어주면
 * 이렇게 작성된메서드나 생성자가 안전하다고 간주하고 경고 메시지를 출력하지 않는다.
 * 
 * @author nnoco
 *
 */
public class UsingTheSafeVarargsAnnotation {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(new Integer(1));
		list1.add(2);
		
		List<Float> list2 = new ArrayList<>();
		list2.add(new Float(3.0));
		list2.add(new Float(4.0));
		displayElements(list1, list2, 12);
		
	}
	
	@SafeVarargs
	public static <T> void displayElements(T... array) {
		for (T element : array) {
			System.out.println(element.getClass().getName() + ": " + element);
		}
	}
}
