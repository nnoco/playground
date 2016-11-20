package com.nnoco.learning.posting;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.function.Function;

public interface OperationStep {
	OperationStep processSecret(Function<byte[], byte[]> processor);
	OperationStep processIv(Function<byte[], byte[]> processor);
	OperationStep sha1Key();
	
	CryptoResult doFinal(byte[] source);
	
	default CryptoResult doFinal(String source) {
		return doFinal(source.getBytes());
	}
	
	default CryptoResult doFinalBase64(String source) {
		return doFinal(Base64.getDecoder().decode(source));
	}
	
	default CryptoResult doFinal(String source, String charsetName) {
		try {
			return doFinal(source.getBytes(charsetName));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	default CryptoResult doFinal(String source, Charset charset) {
		return doFinal(source.getBytes(charset));
	}
}
