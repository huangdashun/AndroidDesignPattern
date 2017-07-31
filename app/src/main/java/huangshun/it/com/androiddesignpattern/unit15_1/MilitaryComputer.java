package huangshun.it.com.androiddesignpattern.unit15_1;

/**
 * Created by hs on 2017/7/25.
 */

public class MilitaryComputer extends AbstractComputer {
    @Override
    protected void checkHardware() {
        System.out.println("监测防火墙");
    }

    @Override
    protected void login() {
        System.out.println("指纹登录");
    }
}
