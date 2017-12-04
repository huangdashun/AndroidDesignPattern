package huangshun.it.com.androiddesignpattern.test.baodian.jdk8.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hs on 2017/12/4.
 * 重复注解
 */

public class RepeatingAnnotations {
    public static void main(String[] args) {
        Filter[] annotationsByType = Fileterable.class.getAnnotationsByType(Filter.class);
        for (Filter filter : annotationsByType) {
            System.out.println(filter.value());
        }

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    interface Fileterable {

    }
}
