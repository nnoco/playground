package com.nnoco.learning.posting;


public class CipherTest {
	public static void main(String[] args) {
		String encrypted = CipherAlgorithm.AES_CBC_PKCS5Padding
				.encryptor("key", "iv")
				.sha1Key()
				.doFinal("안녕하세요..")
				.base64();
		
		System.out.println(encrypted);
		
		System.out.println(CipherAlgorithm.AES_CBC_PKCS5Padding
				.decryptor("key", "iv")
				.sha1Key()
				.doFinalBase64(encrypted)
				.string());
	}
}
