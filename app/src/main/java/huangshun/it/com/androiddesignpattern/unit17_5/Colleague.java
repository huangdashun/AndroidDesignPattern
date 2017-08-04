package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 */

public abstract class Colleague {
    protected Mediator mMediator ;

    public Colleague(Mediator mediator) {
        mMediator = mediator;
    }


}
