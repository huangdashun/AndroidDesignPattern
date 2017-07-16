package huangshun.it.com.androiddesignpattern.unit11_1;

/**
 * Created by hs on 2017/7/9.
 * 具体命令类
 */

public class ConcreteCommand implements Command {
    private Receiver mReceiver;//持有一个对接收者对象的引用

    public ConcreteCommand(Receiver receiver) {
        mReceiver = receiver;
    }

    //调用接收者的相关方法来执行具体逻辑
    @Override
    public void execute() {
        mReceiver.action();
    }
}
