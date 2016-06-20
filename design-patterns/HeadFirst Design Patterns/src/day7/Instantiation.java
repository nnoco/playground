package day7;

public class Instantiation extends SuperClass{
	{
		// 인스턴스 블럭
		System.out.println("여기는 인스턴스 블럭입니다.1");
	}
	static {
		// static 블럭
		System.out.println("여기는 Static 블럭입니다.1");
	}
	
	public static TestClass staticTestClass = new TestClass("Static 변수");
	public TestClass testClass = new TestClass("멤버 변수");
	
	static {
		// static 블럭
		System.out.println("여기는 Static 블럭입니다.2");
	}
	
	{
		// 인스턴스 블럭
		System.out.println("여기는 인스턴스 블럭입니다.2");
	}
	
	
	public Instantiation() {
		System.out.println("생성자 호출");
	}
	
	public void test(String str, int number) {
		System.out.println(str + " 메서드 호출 " + number);
	}
}
