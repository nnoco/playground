package day7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstantiationTest {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		System.out.println("메인 메서드");
		
//		new Instantiation();
		
		Class<?> clazz = Class.forName("day7.Instantiation");
		
		Method[] methods = clazz.getDeclaredMethods();
		
		Object instance = clazz.newInstance();
		
		for(Method m : methods) {
			System.out.println(m.getName());
			
			Object arg2 = "123";
			Class<?>[] types = m.getParameterTypes();
			for(Class<?> t : types) {
				System.out.println("파라미터 타입은? " + t.getName());
				
				if (t.isPrimitive() && t.getName().equals("int")) {
					arg2 = Integer.parseInt(String.valueOf(arg2));
				}
			}
			m.invoke(instance, "Ohdoking", arg2);
			
			
			
		}
		
//		instance.test();
	}
}
