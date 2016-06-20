package day15;

public class Member implements Comparable<Member>{
	private String name;
	private String phoneNumber;
	private String teamName;
	

	public Member(String name, String phoneNumber, String teamName) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.teamName = teamName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return name;
	}

}
