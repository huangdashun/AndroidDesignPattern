package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 */

public class Request1 extends AbstractRequest {
    public Request1(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }

}
