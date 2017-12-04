package huangshun.it.com.androiddesignpattern.test.baodian.jdk8;

/**
 * Created by hs on 2017/12/4.
 */

public interface Defaultable {
    default String notRequired() {
        return "Default implementation";
    }
}
