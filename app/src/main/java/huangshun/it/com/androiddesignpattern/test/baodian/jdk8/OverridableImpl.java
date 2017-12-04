package huangshun.it.com.androiddesignpattern.test.baodian.jdk8;

/**
 * Created by hs on 2017/12/4.
 */

public class OverridableImpl implements Defaultable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
