package day8;

public class AdvancedSingleton {
	public static AdvancedSingleton getInstance() {
		return SingletonHolder.instance;
	}
	
	public static void print() {
		System.out.println("AdvancedSingleton!");
	}
	
	private static class SingletonHolder {
		static {
			System.out.println("SingletonHolder 클래스가 로딩되었음!");
		}
		
		static AdvancedSingleton instance = new AdvancedSingleton();
	}
}
