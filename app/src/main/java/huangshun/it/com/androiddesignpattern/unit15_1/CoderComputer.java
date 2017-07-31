package huangshun.it.com.androiddesignpattern.unit15_1;

/**
 * Created by hs on 2017/7/25.
 */

public class CoderComputer extends AbstractComputer {
    @Override
    protected void login() {
        System.out.println("程序员输入账号和密码");
    }
}
