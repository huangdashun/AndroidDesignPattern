package huangshun.it.com.androiddesignpattern.unit17_1;

/**
 * Created by hs on 2017/8/3.
 * 抽象中介者
 */

public abstract class Mediator {
    protected ConcreteColleagueA mColleagueA;
    protected ConcreteColleagueB mColleagueB;

    public abstract void method();

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        mColleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        mColleagueB = colleagueB;
    }
}
