package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 */

public class Client {
    public static void main(String[] args) {
        AbstractHandler handler1 = new Handler1();
        AbstractHandler handler2 = new Handler2();
        AbstractHandler handler3 = new Handler3();
        AbstractRequest request1 = new Request1("request1");
        AbstractRequest request2 = new Request2("request2");
        AbstractRequest request3 = new Request3("request3");
        handler1.nextHandler = handler2;
        handler2.nextHandler = handler3;
        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
    }
}
