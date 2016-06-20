package day7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RequestInvocationHandler implements InvocationHandler {
	HttpClient client;

	public RequestInvocationHandler(HttpClient client) {
		this.client = client;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Request request = RequestResolver.resolve(RequestInfo.class,
				method.getName());
		return client.request(request.url(), request.method());
	}

}
