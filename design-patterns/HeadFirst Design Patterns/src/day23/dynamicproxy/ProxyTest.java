package day23.dynamicproxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		CsbServer server = (CsbServer) Proxy.newProxyInstance(CsbServer.class.getClassLoader(), new Class<?>[]{
			CsbServer.class
		}, new CsbInvocationHandler());
		
		server.getAvailableVirtualMachines();
	}
}
