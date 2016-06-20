package com.nnoco.playground.java.collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.nnoco.playground.java.Student;

public class LearningList {
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		/**
		 * List 인터페이스의 주요 메서드
		 * 
		 * add(E)
		 * add(int, E)
		 * addAll(int, Collection<? extends E>)
		 * addAll(Collection<? extends E>)
		 * clear()
		 * contains(Object)
		 * containsAll(Collection<?>)
		 * get(int)
		 * indexOf(Object)
		 * remove()
		 * sort()
		 * subList(int, int)
		 * toArray()
		 * toArray(T[])
		 */
		
		new LearningList().arrayList();
	}
	
	void arrayList() {
		Student s1 = new Student("1111111", "마틴 파울러", "컴퓨터공학과");
		Student s2 = new Student("2222222", "켄트 벡", "컴퓨터공학과");
		Student s3 = new Student("3333333", "에릭 감마", "컴퓨터공학과");
		
		Student notInList = new Student("0", "리스트에 추가하지 않음", "컴공");
		
		List<Student> students = new ArrayList<>();
		
		// 리스트에 추가
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s1); // 리스트는 중복해서 같은 요소를 넣을 수 있습니다.
		students.add(s1);
		// students.add(null); // null도 리스트에 추가할 수 있습니다.
		
		// 탐색 - forEach 구문
		for(Student student : students) {
			System.out.println(student.getName() + ", " + student.getNumber());
		}
		// 탐색 - Iterator
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getName() + ", " + student.getNumber());
		}
		// 탐색 - forEach 디폴트 메서드 & 람다 표현식(Java 8)
		students.forEach(student -> System.out.println(student.getName() + ", " + student.getNumber()));
		
		
		/* 기본 연산 */
		// 어떻게 객체가 같은 지 판단할까요? Object 클래스의 equals와 hashCode
		
		// 리스트안에 있는지 확인
		System.out.println(students.contains(s1)); // true 출력
		System.out.println(students.contains(notInList)); // false 출력
		
		
		// ~번 째에 위치한 요소 가져오기
		Student found = students.get(0);
		System.out.println(found.getName()); // 마틴 파울러 출력
		//found = students.get(100); // IndexOutOfBounds 예외 발생
		
		
		// 전달하는 객체가 몇 번째에 위치해 있는지 찾기
		int where = students.indexOf(s1); // 앞에서부터 탐색, 0 반환
		where = students.lastIndexOf(s1); // 뒤에서부터 탐색, 4 반환
		where = students.indexOf(notInList); // 리스트에 없으면 -1 반환
		
		
		// 삭제 - 삭제되면 true를 반환합니다.
		students.remove(1); // 전달한 인덱스에 위치한 요소를 삭제
		students.remove(s1); // 전달한 객체와 동일한 요소를 삭제
		// 현재 리스트의 상태 [s3],[s1],[s1]
		
		
		// 서브리스트 - ~번 째부터 ~ 번 째 앞까지 잘라서 새로운 리스트를 생성 
		List<Student> sublist = students.subList(2, students.size());
		// subList의 상태 : [s1],[null]
		// students의 상태 : [s3], [s1], [s1] (서브리스트와는 상관없이 그대로 유지)
		
		
		// 정렬(학번으로 오름차순 정렬)
		// Comaprator<T> 활용
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(null == o1) return 1; // 우선순위를 뒤로
				else if(null == o2) return -1;
				else return o1.getNumber().compareTo(o2.getNumber());
			}
		});
		// Java 8 람다로 작성
		students.sort((o1, o2) -> {
			if(null == o1) return 1; // 우선순위를 뒤로
			else if(null == o2) return -1;
			else return o1.getNumber().compareTo(o2.getNumber());	
		});
		
		// Collections 클래스의 sort 메서드
		Collections.sort(students);
		// students의 상태 : [s1], [s1], [s3], [null] 
		
		// 배열로 변환하기
		Student[] studentArray = new Student[students.size()];
		students.toArray(studentArray);
		// ArrayList는 내부적으로 Object 배열에 요소를 저장하고 있음
		
		// 리스트 비우기 - 모든 요소 삭제
		students.clear();
		System.out.println(students.size()); // 0 출력
		
		// 많이 헷갈려하시는 부분
		// add는 객체를 복사하는 것이 아니라 참조만 추가됩니다.
		List<Student> list1 = new ArrayList<>();
		List<Student> list2 = new ArrayList<>();
		
		Student bill = new Student("1", "빌 게이츠", "응용수학");
		list1.add(bill);
		list1.add(bill);
	}
	
	
	void linkedList() {
		List<Student> linkedList = new LinkedList<>();
	}
	
	void vector() {
		Vector<Student> vector = new Vector<>();
	}
	
}
