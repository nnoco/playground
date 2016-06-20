package day8;

public class Singleton {
	private volatile static Singleton uniqueInstance;
	
	private Singleton() {
		
	}
	
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		
		return uniqueInstance;
	}
	
	public static Singleton getInstanceByDcl() {
		if (uniqueInstance == null) {
			synchronized(Singleton.class){
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		
		return uniqueInstance;
	}
}
