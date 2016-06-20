package day18.serialize;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -5667610743560189648L;
	private String name;
	private transient String phone;

	public Student(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
