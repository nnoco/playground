package com.nnoco.playground.java7.ch1;

public class AutoCloseableResourceTest {
	public static void main(String[] args) {
		try(FirstAutoCloseableResource resource1 = new FirstAutoCloseableResource();
				SecondAutoCloseableResource resource2 = new SecondAutoCloseableResource()) {
			resource1.manipulateResource();
			resource2.manipulateResource();
		} catch(Exception e) {
			e.printStackTrace();
			for (Throwable throwable : e.getSuppressed()) {
				System.out.println(throwable);
			}
		}
	}
}
