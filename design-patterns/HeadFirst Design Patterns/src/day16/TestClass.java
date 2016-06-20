package day16;

import java.util.HashSet;
import java.util.Set;

public class TestClass {
	public static void main(String[] args) {
		Set<String> inPocket = new HashSet<String>();
		inPocket.add("열쇠");
		inPocket.add("스마트폰");
		inPocket.add("돈");
		inPocket.add("지갑");
		inPocket.add("이어폰");
		inPocket.add("동전");

		java.util.Iterator<String> iterator = inPocket.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
