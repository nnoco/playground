package com.nnoco.learning.posting;

import java.util.function.Function;

public interface AlgorithmStep {
	KeyStep algorithm(CipherAlgorithm algorithm, int mode);
}
