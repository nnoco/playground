package day13;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTest {
	Gson gson = GsonSingleton.getInstance();
	
	public static void main(String[] args) {
		new GsonTest().gsonTest();
	}
	public void gsonTest() {
		User 이준영 =  new User("준영", "06");
		User 최평강 = new User("평강", "11");
		
		Map<String, String> map = new HashMap<String, String>();
//		map.put
//		System.out.println(gson.toJson(이준영));
	}
}

class GsonSingleton {
	private static Gson gson;	
	
	public static Gson getInstance() {
		if (null == gson) {
			gson = new Gson();
		}
		
		return gson;
	}
}

class PGClient {
	Gson gson = GsonSingleton.getInstance();
}

 class JsonConverter {
	 Gson gson = GsonSingleton.getInstance();
 }
