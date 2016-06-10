package com.nnoco.playground.java.classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 사용자 정의 클래스 로더
 * @author nnoco
 *
 */
public class CustomClassLoader extends ClassLoader {
	public static void main(String[] args) {
		CustomClassLoader ccl = new CustomClassLoader();
		try {
			ccl.loadClass("com.nnoco.playground.java.classloader.Hello").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public CustomClassLoader() {
		super(CustomClassLoader.class.getClassLoader());
	}
	
	public CustomClassLoader(ClassLoader parent) {
		super(parent);
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String path = "test.jar";
		
		try(InputStream input = new FileInputStream(path)) {
			byte[] classByte = new byte[input.available()];
			input.read(classByte);
			
			return defineClass(name, classByte, 0, classByte.length);
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
		
	}
}
