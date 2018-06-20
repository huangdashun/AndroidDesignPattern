package huangshun.it.com.androiddesignpattern.arouter.model;

import java.io.Serializable;

/**
 * Created by GB347998 on 18/6/20.
 */
public class ARouterTest implements Serializable {
    private String name;
    private String like;

    public ARouterTest(String name, String like) {
        this.name = name;
        this.like = like;
    }

    @Override
    public String toString() {
        return "ARouterTest{" +
                "name='" + name + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
