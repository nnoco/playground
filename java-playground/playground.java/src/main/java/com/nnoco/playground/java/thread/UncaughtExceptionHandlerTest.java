package com.nnoco.playground.java.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerTest {
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.err.println("처리되지 않은 예외");
				
				e.printStackTrace();
			}
		});
		
		throw new RuntimeException("임의로 발생 시킨 예외");
	}
}
