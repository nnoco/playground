package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberTest {
	
	public static void main(String[] args) {
		List<Member> contacts = new ArrayList<Member>();
		contacts.add(new Member("이준영", "010-6637-3707", "EMS Team"));
		contacts.add(new Member("오도근", "010-3668-7952", "EMS Team"));
		contacts.add(new Member("최평강", "010-3113-2359", "EMS Team"));
		Collections.sort(contacts);
		
		// For each 구문. Iterable한 컬렉션을 탐색
		for(Member member : contacts) {
			System.out.println(member);
			
			System.out.println(member.toString());
			
			// 129381@Member 
		}
	}
}
