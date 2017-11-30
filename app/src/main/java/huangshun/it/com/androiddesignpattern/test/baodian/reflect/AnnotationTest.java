package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import java.lang.reflect.Method;

/**
 * Created by hs on 2017/11/27.
 */

public class AnnotationTest {
    @MyAnnotation(age = 18)
    public static void main(String[] args) {
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;
        Method[] methods = annotationTestClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = methods[i].getAnnotation(MyAnnotation.class);
                System.out.println(annotation.name());
                System.out.println(annotation.desc());
                System.out.println(annotation.age());

            }
        }
        double v = 1 + 2.5;
    }

    @MyAnnotation(name = "大顺子")
    public static void method() {

    }
}
