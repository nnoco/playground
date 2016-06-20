package com.nnoco.playground.java.parallel.ch02;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.nnoco.playground.java.parallel.annotations.ThreadSafe;
import com.nnoco.playground.java.parallel.dummies.Servlet;
import com.nnoco.playground.java.parallel.dummies.ServletRequest;
import com.nnoco.playground.java.parallel.dummies.ServletResponse;

@ThreadSafe
public class CountingFactorizer implements Servlet {
	private final AtomicLong count = new AtomicLong(0);
	
	public long getCount() { return count.get(); }
	
	public void service(ServletRequest req, ServletResponse res) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encodeIntoResponse(res, factors);
	}
}
