package huangshun.it.com.androiddesignpattern.unit17_1;

/**
 * Created by hs on 2017/8/3.
 * 抽象同事A
 */

public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ColleagueA将信息递交给中介者处理");
    }
}
