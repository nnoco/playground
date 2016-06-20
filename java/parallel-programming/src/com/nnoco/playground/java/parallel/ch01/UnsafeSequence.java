package com.nnoco.playground.java.parallel.ch01;

import com.nnoco.playground.java.parallel.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
	private int value;
	
	/** 유일한 값을 리턴 */
	public int getNext() {
		return value++;
	}
}
