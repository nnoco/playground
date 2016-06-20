package day13;

public class AndroidTestClient {
	public static void main(String[] args) {
		PyeongGang pg = PyeongGangFactory.create();
		
		User user = pg.getUser();
		System.out.println(user.getName() + "을 받아왔다.");
	}
}
