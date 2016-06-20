package com.nnoco.playground.java.classloader;

public class ClassLoaderTest {
	public static void main(String[] args) {
		System.out.println(ClassLoaderTest.class.getClassLoader());
		// -> sun.misc.Launcher$AppClassLoader@2a139a55 : AppClassLoader...?
	}
	
	public final void temp() {
		
	}
}