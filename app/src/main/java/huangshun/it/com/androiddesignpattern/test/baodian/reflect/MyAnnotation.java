package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hs on 2017/11/27.
 */

@Documented //会保存到JavaDoc文档中
@Inherited //用它修饰的类，该类的子类也自动被该注解修饰
@Retention(RetentionPolicy.RUNTIME)//SOURCE源码时 CLASS编译时 RUNTIME运行时JVM中
@Target(ElementType.METHOD)//TYPE,METHOD,CONSTRUCTOR,FIELD,PARAMETER
public @interface MyAnnotation {
    String name() default "黄顺";

    String desc() default "come on";

    int age() default 22;
}
