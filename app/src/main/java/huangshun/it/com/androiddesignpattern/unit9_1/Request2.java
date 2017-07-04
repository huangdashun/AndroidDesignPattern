package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 */

public class Request2 extends AbstractRequest {
    public Request2(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }

}
