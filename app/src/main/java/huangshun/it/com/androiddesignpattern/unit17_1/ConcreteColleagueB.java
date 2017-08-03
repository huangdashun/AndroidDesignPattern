package huangshun.it.com.androiddesignpattern.unit17_1;

/**
 * Created by hs on 2017/8/3.
 * 抽象同事B
 */

public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ColleagueB将信息交给中介者处理");
    }
}
