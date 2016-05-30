package com.nnoco.playground.java.parallel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * 해당 클래스는 스레드 안정성을 보장하지 않음
 * @author nnoco
 *
 */
@Target(ElementType.TYPE)
public @interface NotThreadSafe {

}
