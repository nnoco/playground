package com.nnoco.learning.posting;

import javax.crypto.Cipher;

public enum CipherAlgorithm {
	AES_CBC_PKCS5Padding("AES/CBC/PKCS5Padding", 16)
	
	;
	
	private String algorithm;
	private int keyLength;
	
	private CipherAlgorithm(String algorithm, int keyLength) {
		this.algorithm = algorithm;
		this.keyLength = keyLength;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public int getKeyLength() {
		return keyLength;
	}
	
	public KeyStep encryptor() {
		return new CipherCodec(this, Cipher.ENCRYPT_MODE);
	}
	
	public KeyStep decryptor() {
		return new CipherCodec(this, Cipher.DECRYPT_MODE);
	}
	
	public OperationStep encryptor(String secret, String iv) {
		return new CipherCodec(this, Cipher.ENCRYPT_MODE)
				.key(secret, iv);
	}
	
	public OperationStep decryptor(String secret, String iv) {
		return new CipherCodec(this, Cipher.DECRYPT_MODE)
				.key(secret, iv);
	}
}
