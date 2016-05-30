package com.nnoco.playground.java.parallel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 해당 필드나 메서드를 사용하려면 반드시 지정된 락을 확보한 상태에서 사용해야 한다는 점을 의미한다. <br>
 * lock 인자는해당 필드나 메서드를 사용하려 할 때 반드시 확보해야 할 락을 의미한다. <br>
 * lock 인자로 지정할 수 있는 값에는 아래와 같은 것들이 있다.<br>
 * <br>
 * <ul>
 * 	<li>@GuardBy("this") 애너테이션은 해당 필드나 메서드가 들어있는 객체에 대한 암묵적인 락을 확보해야 뜻한다.
 *  <li>@GuardBy("fieldName") 애너테이션은 지정된 이름의 필드가 가리키는 객체에 의한 암묵적인 락(Lock 클래스가 아닌 모든 객체)이나 또는 명시적인 Lock 객체를 통해 락을 확보해야 함을 의미한다.</li>
 *  <li>@GuardBy("Classname.fieldName") 애너테이션은 @GuardBy("fieldName")과 동일하지만 지정한 클래스의 static 필드를 대상으로 한다.</li>
 *  <li>@GuardBy("methodName()") 애너테이션은 지정한 이름의 메서드를 호출한 결과로 받아온 객체에 대한 암묵적인 락을 확보해야 한다는 의미이다.</li>
 *  <li>@GuardBy("ClassName.class") 애너테이션은 지정한 이름의 클래스 자체에 대한 락을 확보해야 한다는 의미이다.</li>
 * </ul>
 * - @GuardBy("this);
 * @author nnoco
 *
 */
@Target({
	ElementType.FIELD,
	ElementType.METHOD
})
public @interface GuardBy {
	String lock();
}
