package com.nnoco.learning.posting;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.function.Function;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherCodec implements AlgorithmStep, KeyStep, OperationStep {
	private String algorithm;
	private int keyLength;
	private int mode;
	private byte[] secret;
	private byte[] iv;
	private Cipher cipher;
	
	public CipherCodec(CipherAlgorithm cipherAlgorithm, int mode) {
		algorithm(cipherAlgorithm, mode);
	}

	@Override
	public KeyStep algorithm(CipherAlgorithm algorithm, int mode) {
		this.algorithm = algorithm.getAlgorithm();
		this.keyLength = algorithm.getKeyLength();
		this.mode = mode;
		
		return this;
	}

	@Override
	public OperationStep key(String secret, String iv) {
		return key(secret.getBytes(), iv.getBytes());
	}

	@Override
	public OperationStep key(byte[] secret, byte[] iv) {
		this.secret = secret;
		this.iv = iv;
		return this;
	}

	@Override
	public OperationStep key(String secret) {
		return key(secret.getBytes());
	}

	@Override
	public OperationStep key(byte[] secret) {
		return key(secret);
	}
	
	@Override
	public OperationStep processSecret(Function<byte[], byte[]> processor) {
		secret = processor.apply(secret);
		return this;
	}

	@Override
	public OperationStep processIv(Function<byte[], byte[]> processor) {
		iv = processor.apply(iv);
		return this;
	}
	
	@Override
	public OperationStep sha1Key() {
		return processSecret(this::sha1)
				.processIv(this::sha1);
	}
	
	private byte[] sha1(byte[] source) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(source);
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	private void initCipher() {
		secret = Arrays.copyOf(secret, keyLength);
		SecretKey keySpec = new SecretKeySpec(secret, "AES");
		
		try {
			cipher = Cipher.getInstance(algorithm);
			
			if(null != iv) {
				iv = Arrays.copyOf(iv, keyLength);
				IvParameterSpec ivSpec = new IvParameterSpec(iv);
				cipher.init(mode, keySpec, ivSpec);
			} else {
				cipher.init(mode, keySpec);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public CryptoResult doFinal(byte[] source) {
		initCipher();
		
		try {
			return new CryptoResult(cipher.doFinal(source));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new RuntimeException(e);
		}
	}
	

}
