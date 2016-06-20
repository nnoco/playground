package day13;

public class User {
	private String name;

	private String 학번;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String get학번() {
		return 학번;
	}

	public void set학번(String 학번) {
		this.학번 = 학번;
	}

	public User(String name, String 학번) {
		this.name = name;
		this.학번 = 학번;
	}

}
