package huangshun.it.com.androiddesignpattern.arouter.model;

/**
 * Created by GB347998 on 18/6/20.
 * 使用@Autowired要求
 * 第一种
 * 1.成员变量使用Public
 * 2.无参数构造
 * 3.要有空构造方法
 * 第二种
 * 成员变量使用private，但是要提供set,get方法
 * 第三种
 * 没有构造函数，但是要提供set,get方法
 */
public class ARouterTest2 {
    public String name;
    public String like;

    public ARouterTest2() {
    }

    public ARouterTest2(String name, String like) {
        this.name = name;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
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
