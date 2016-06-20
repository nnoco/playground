package day23.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CsbInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Request request = method.getAnnotation(Request.class);
		System.out.println(method.getName() + "을 호출하였습니다.");
		
		System.out.println("요청 주소는 : " + request.url());
		System.out.println("HTTP Method는 : " + request.value());
		return null;
	}
	
}
