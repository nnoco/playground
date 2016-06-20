package com.nnoco.playground.java7.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollutionExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("One");
		list1.add("Two");
		list1.add("Three");
		List<String> list2 = new ArrayList<>();
		list2.add("Four");
		list2.add("Five");
		list2.add("Six");
		
		merge(list1, list2);
		
	}
	
	@SafeVarargs // 실제로는 안전하지 않은 코드.
	static void merge(List<String>... stringLists) {
		Object[] array = stringLists;
		List<Integer> tmpList = Arrays.asList(42);
		array[0] = tmpList;	// 컴파일 시점에 아무런 경고도 뜨지 않지만,
							// 의미상 잘못된 코드.
		
		String element = stringLists[0].get(0);
		// 런타임에 ClassCastException이 발생
	}
}
