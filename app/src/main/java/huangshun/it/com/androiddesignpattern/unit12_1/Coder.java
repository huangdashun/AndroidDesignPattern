package huangshun.it.com.androiddesignpattern.unit12_1;

/**
 * Created by hs on 2017/7/16.
 * 具体的观察者
 */

public class Coder extends Observer {
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    void update(String content) {
        System.out.println("通知" + name + "----" + content + "更新啦");
    }
}
