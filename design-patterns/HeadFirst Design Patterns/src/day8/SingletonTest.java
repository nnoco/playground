package day8;


public class SingletonTest {
	public static void main(String[] args) {
		AdvancedSingleton.print();
		
		AdvancedSingleton.getInstance();
		
//		new Thread(() -> {
//			System.out.println("Hello");
//		});
	}
	
	/**
	 * 
		
		new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				
				Singleton singleton = null;
				for(int i = 0; i < 10000000; i++) {
					singleton = Singleton.getInstance();
					singleton.toString();
				}
				
				
				long end = System.currentTimeMillis();
				
				System.out.println((end-start) / 1000.0);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				
				Singleton singleton = null;
				for(int i = 0; i < 10000000; i++) {
					singleton = Singleton.getInstance();
					singleton.toString();
				}
				
				
				long end = System.currentTimeMillis();
				
				System.out.println((end-start) / 1000.0);
			}
		}).start();
	 */
}
