package day18.serialize;

import java.io.IOException;

public class SerializeTestDrive {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Student studentOrgin = new Student("OpenPaaS", "123123");
		ObjectStreamHandler.write(studentOrgin, "openpaas.obj");
		
		Student student = ObjectStreamHandler.read("openpaas.obj");
		System.out.println(student.getName());
		System.out.println(student.getPhone());
	}
}
