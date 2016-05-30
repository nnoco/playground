package com.nnoco.playground.java.parallel.ch02;

import java.math.BigInteger;

import com.nnoco.playground.java.parallel.annotations.ThreadSafe;
import com.nnoco.playground.java.parallel.dummies.Servlet;
import com.nnoco.playground.java.parallel.dummies.ServletRequest;
import com.nnoco.playground.java.parallel.dummies.ServletResponse;

@ThreadSafe
public class StatelessFactorizer implements Servlet {
	public void service(ServletRequest req, ServletResponse res) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		encodeIntoResponse(res, factors);
	}
	
	BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}
	
	BigInteger[] factor(BigInteger i) {
		return null;
	}
	
	void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
		
	}
}

