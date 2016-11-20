package com.nnoco.learning.posting;

import java.util.Base64;
import java.util.function.Function;

public class CryptoResult {
	private byte[] result;
	
	public CryptoResult(byte[] encrypted) {
		this.result = encrypted;
	}
	
	<T> T as(Function<byte[], T> function) {
		return function.apply(result);
	}
	
	byte[] bytes() {
		return result;
	}
	
	String base64() {
		return as(Base64.getEncoder()::encodeToString);
	}
	
	String string() {
		return new String(result);
	}
}
