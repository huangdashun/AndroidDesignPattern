package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 */

public class Handler1 extends AbstractHandler {
    @Override
    protected int getHandlerLevel() {
        return 1;
    }

    @Override
    protected void handler(AbstractRequest request) {
        System.out.println("Handler" + request.getRequestLevel());
    }
}
