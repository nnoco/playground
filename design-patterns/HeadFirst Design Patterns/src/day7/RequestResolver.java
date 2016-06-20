package day7;

public class RequestResolver {
	public static Request resolve(Class<?> clazz, String name) {
		try {
			return clazz.getDeclaredMethod(name).getAnnotation(Request.class);
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
}
