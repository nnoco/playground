package day7;

import java.lang.reflect.Proxy;

public class ReflectionTest {
	public static void main(String[] args) {
		RequestInfo requestInfo = (RequestInfo) Proxy.newProxyInstance(
				RequestInfo.class.getClassLoader(), 
				new Class<?>[]{RequestInfo.class}, 
				new RequestInvocationHandler(new HttpClient()));
		
		int responseCode = requestInfo.requestName();
		System.out.println("응답 코드: " + responseCode);
		
		responseCode = requestInfo.postVirtualMachine();
		System.out.println("응답 코드: " + responseCode);
	}
}
