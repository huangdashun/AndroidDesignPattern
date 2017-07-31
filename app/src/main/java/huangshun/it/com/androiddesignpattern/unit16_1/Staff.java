package huangshun.it.com.androiddesignpattern.unit16_1;

import java.util.Random;

/**
 * Created by hs on 2017/7/31.
 * 员工基类
 */

public abstract class Staff {
    public String name;
    public int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }
    //接受visitor的访问
    public abstract void accept(Visitor visitor);
}
