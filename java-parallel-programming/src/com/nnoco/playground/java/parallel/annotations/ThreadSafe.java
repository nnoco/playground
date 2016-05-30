package com.nnoco.playground.java.parallel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 해당 클래스가 스레드 안전성을 보장함
 * @author nnoco
 *
 */
@Target(ElementType.TYPE)
public @interface ThreadSafe {

}
