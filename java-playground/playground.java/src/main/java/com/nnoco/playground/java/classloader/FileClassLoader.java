package com.nnoco.playground.java.classloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class FileClassLoader {
	public static void main(String[] args) {
		File cpList = new File("classpath.properties");
		FileClassLoader fcl = new FileClassLoader();
		
		try(BufferedReader br = new BufferedReader(new FileReader(cpList));) {
			URL[] urlList = fcl.getUrl(br);
			
			URLClassLoader ucl = new URLClassLoader(urlList);
			ucl.loadClass("com.nnoco.playground.java.classloader.Hello").newInstance();
			ucl.close();
		} catch (InstantiationException |
				IllegalAccessException |
				ClassNotFoundException |
				IOException e) {
			e.printStackTrace();
		}
	}
	
	private URL[] getUrl(BufferedReader br) throws MalformedURLException, IOException {
		String line = null;
		URL[] urlList = null;
		
		while((line = br.readLine()) != null) {
			File cp = new File(line);
			if (cp.exists()) {
				URL[] temp;
				int length = 0;
				if (urlList != null) {
					length = urlList.length;
					temp = new URL[length + 1];
					System.arraycopy(urlList, 0, temp, 0, length);
				} else {
					temp = new URL[1];
				}
				
				temp[length] = cp.toURI().toURL();
				urlList = temp;
			}
		}
		
		return urlList;
	}
}
