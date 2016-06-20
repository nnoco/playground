package day1;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Class[] clazz = {BookService.class};
		
		BookService service = (BookService)Proxy.newProxyInstance(BookService.class.getClassLoader(), clazz, new MyInvocationHandler());
		
		
		service.getBookInfo("1");
	}
}
