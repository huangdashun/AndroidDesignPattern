package huangshun.it.com.androiddesignpattern.unit17_1;

/**
 * Created by hs on 2017/8/3.
 * 抽象同事
 */

public abstract class Colleague {
    protected Mediator mMediator;

    public Colleague(Mediator mediator) {
        mMediator = mediator;
    }

    public abstract void action();
}
