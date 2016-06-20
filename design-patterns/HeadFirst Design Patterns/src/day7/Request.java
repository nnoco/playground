package day7;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
	public String url() default "http://www.naver.com";
	public String method();
}
