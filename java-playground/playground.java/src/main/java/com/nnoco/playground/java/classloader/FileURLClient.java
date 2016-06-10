package com.nnoco.playground.java.classloader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class FileURLClient {
	public static void main(String[] args) throws Exception {
		URL[] urlArray = {
				new File("subdir/").toURI().toURL()
		};
		
		URLClassLoader ucl = new URLClassLoader(urlArray);
		Object obj = ucl.loadClass("Hello").newInstance();
	}
}
