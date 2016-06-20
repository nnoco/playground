package day14;

public class MorningList<T> implements MyList<T>{
	private Element<T> head = null;
	
	public static void main(String[] args) {
		MyList<String> strings = new MorningList<String>();
		
		strings.add("ddd");
		strings.add("hello");
		strings.add("world");
		strings.add("pg");
		
		((MorningList<String>)strings).printAll();
	}
	
	public MorningList() {
		System.out.println("리스트 만들어짐");
	}
	

	@Override
	public void add(T value) {
		if (null == head) {
			head = new Element<T>(value);
		} else {
			Element<T> temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = new Element<T>(value);
		}
	}
	
	public void printAll() {
		Element<T> temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generatzed method stub
		
	}

	@Override
	public int find(T value) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class Element<T> {
		T value;
		Element<T> next;
		
		public Element(T value) {
			this.value = value;
		}
	}
}


interface MyList <T>{
	void add(T value);
	void remove(int index);
	
	/**
	 * 이 메서드는 값을 넘겨줘서 몇번째에 있는지 찾는 메서드입니다.
	 * @param value 찾을 값
	 * @return 찾은 인덱스, 찾을 값이 없다면 -1 리턴
	 */
	int find(T value);
}
