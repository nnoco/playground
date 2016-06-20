package day13;

public class ConcretePyeongGang implements PyeongGang {

	@Override
	public User getUser() {
		System.out.println("Rest 통신을 함.");
		
		// 실제로 통신을 함
		return new User("최평강", "11학번");
	}

	@Override
	public void postUser(User user) {
		System.out.println(user.getName() + "을 전송함!");
	}

}
