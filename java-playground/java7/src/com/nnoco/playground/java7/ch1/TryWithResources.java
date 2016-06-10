package com.nnoco.playground.java7.ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 리소스를 자동으로 열고 닫아주는 try-with-resources
 * 1. try 구문을 만들고 여기서 관리할 리소스를 선언한다.
 * 2. try 구문 안에서 선언한 리소스를 사용한다.
 * 
 * @author nnoco
 *
 */
public class TryWithResources {
	public static void main(String[] args) {
		try (BufferedReader inputReader = Files.newBufferedReader(
					Paths.get("users.txt"),
					Charset.defaultCharset());
			BufferedWriter outputWriter = Files.newBufferedWriter(
					Paths.get("users.bak"), 
					Charset.defaultCharset())) {
			String inputLine;
			while ((inputLine = inputReader.readLine()) != null) {
				outputWriter.write(inputLine);
				outputWriter.newLine();
			}
			
			System.out.println("Copy complete!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
