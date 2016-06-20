package com.nnoco.playground.java.parallel.ch02;

import com.nnoco.playground.java.parallel.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance() {
		if (instance == null) 
			instance = new ExpensiveObject();
		return instance;
	}
	
	class ExpensiveObject {}
}
