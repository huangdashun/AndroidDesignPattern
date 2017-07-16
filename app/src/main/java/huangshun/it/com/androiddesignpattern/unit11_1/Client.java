package huangshun.it.com.androiddesignpattern.unit11_1;

/**
 * Created by hs on 2017/7/9.
 */

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command concreteCommand = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(concreteCommand);
        invoker.action();
    }
}
