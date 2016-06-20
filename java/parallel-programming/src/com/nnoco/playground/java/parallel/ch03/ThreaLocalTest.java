package com.nnoco.playground.java.parallel.ch03;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreaLocalTest {
	static final AtomicInteger count = new AtomicInteger(0);
	
	private static ThreadLocal<String> name = new ThreadLocal<>();
	
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		public Connection initialValue() {
			return new Connection(){
				private int mine = 0;
				@Override
				public String toString() {
					return count.getAndIncrement() + " " + (mine+1);
				}
				
			};
		}
	};
	
	public static Connection getConnection() {
		return connectionHolder.get();
	}
	
	public static void main(String[] args) {
		name.set("main");
		new Thread(() -> {
			System.out.println(getConnection());
			System.out.println(name.get());
			name.set("Thread 1");
			System.out.println(name.get());
		}).start();
		
		new Thread(() -> {
			
			System.out.println(getConnection());
			System.out.println(name.get());
			name.set("Thread 2");
			System.out.println(name.get());
		}).start();
		
		
		
		
		
	}
}

interface Connection {
	
}
