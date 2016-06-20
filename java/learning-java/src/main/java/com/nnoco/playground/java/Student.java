package com.nnoco.playground.java;


public class Student implements Comparable<Student>{
	private String number;
	private String name;
	private String department;

	public Student(String number, String name, String department) {
		this.number = number;
		this.name = name;
		this.department = department;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int compareTo(Student o) {
		if(null == o) return -1;
		else return getNumber().compareTo(o.getNumber());	
	}

}
