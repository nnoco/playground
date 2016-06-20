package day18.serialize;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 객체를 파일로 출력하는 객체
 * @author 이준영
 *
 */
public class ObjectStreamHandler {
	public static void write(Object object, String fileName) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(fileName)));
		out.writeObject(object);
		out.flush();
		out.close();
	}
	
	public static <T> T read(String fileName) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(fileName)));
		
		T t = (T)in.readObject();
		in.close();
		
		return t;
	}
}
