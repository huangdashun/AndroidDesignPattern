package huangshun.it.com.androiddesignpattern.unit4_9;


/**
 * Created by hs on 2017/6/6.
 * 用户实体类
 */

public class User implements Cloneable {
    public int age;
    public String name;
    public String phoneNum;
    public Address address;

    @Override
    protected User clone()  {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address=" + address +
                '}';
    }
}
