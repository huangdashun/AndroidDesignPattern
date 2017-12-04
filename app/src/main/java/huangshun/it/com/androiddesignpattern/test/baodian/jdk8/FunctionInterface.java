package huangshun.it.com.androiddesignpattern.test.baodian.jdk8;

/**
 * Created by hs on 2017/12/4.
 */

@FunctionalInterface
public interface FunctionInterface {
    void getName();

    default void method() {
        System.out.println("我是默认方法");
    }
}
