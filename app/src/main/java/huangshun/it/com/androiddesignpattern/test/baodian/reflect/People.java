package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

/**
 * Created by hs on 2017/11/21.
 */

public class People {
    private String name;
    private String desc;
    private int age;
    public int id;

    public People() {
    }

    public People(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getAge() {
        return age;
    }

}
