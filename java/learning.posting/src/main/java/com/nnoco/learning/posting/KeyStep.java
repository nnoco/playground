package com.nnoco.learning.posting;

public interface KeyStep {
	OperationStep key(String secret, String iv);
	OperationStep key(byte[] secret, byte[] iv);
	OperationStep key(String secret);
	OperationStep key(byte[] secret);
}
