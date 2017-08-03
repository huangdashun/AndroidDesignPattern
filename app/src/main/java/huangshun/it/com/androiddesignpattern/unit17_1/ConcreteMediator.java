package huangshun.it.com.androiddesignpattern.unit17_1;

/**
 * Created by hs on 2017/8/3.
 * 具体的中介者
 */

public class ConcreteMediator extends Mediator {
    @Override
    public void method() {
        mColleagueA.action();
        mColleagueB.action();
    }
}
