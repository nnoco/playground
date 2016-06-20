package day1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	BookServiceImpl service = new BookServiceImpl();

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("Service:: 책 정보 탐색 시작");
		Object obj = method.invoke(service, args);
		System.out.println("Service:: 책 정보 탐색 종료");
		return obj;
	}
	

}
