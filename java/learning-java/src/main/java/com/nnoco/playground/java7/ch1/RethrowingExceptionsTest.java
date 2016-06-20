package com.nnoco.playground.java7.ch1;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * catch 구문에서 예외ㅏ를 처리할 때, 예외를 다시 던져야 하는 경우가 있다.
 * 이렇게 하면 예외를 현재 메서드뿐만 아니라, 이 메서드를 호출한 메서드에서도 처리하게 할 수 있다.
 * 
 * 자바  이전에는 기본 클래스에 대한 예외만 다시 던질 수 있었다. 그래서 여러 예외를
 * 다시 던지려면 메서드를 선언할 때 공통 기본 클래스를 선언해야만 했다. 자바 7부터는 이렇게 번거롭게 작성하지 않고도
 * 좀 더 구체적인 예외를 다시 던질 수 있다.
 * @author nnoco
 *
 */
public class RethrowingExceptionsTest {
	public static void main(String[] args) {
		try {
			deleteFile(Paths.get("tmp.txt"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteFile(Path path) throws NoSuchFileException, DirectoryNotEmptyException {
		try {
			Files.delete(path);
		} catch(IOException e) {
			if(path.toFile().isDirectory()) {
				throw new DirectoryNotEmptyException(path.toString());
			} else {
				throw new NoSuchFileException(path.toString() + " is not exist");
			}
		}
	}
}
