package huangshun.it.com.androiddesignpattern.unit11_1;

/**
 * Created by hs on 2017/7/9.
 */

public class Invoker {
    private Command mCommand;//持有一个对相对命令对象的引用

    public Invoker(Command command) {
        mCommand = command;
    }

    //调用具体命令对象的相关方法,执行具体的命令
    public void action() {
        mCommand.execute();
    }
}
