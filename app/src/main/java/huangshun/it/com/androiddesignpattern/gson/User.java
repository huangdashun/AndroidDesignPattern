package huangshun.it.com.androiddesignpattern.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hs on 2017/12/20.
 */

public class User {
    public String name;
    public int age;
    @SerializedName(value = "email", alternate = {"emailAddress", "email_address" })
    public String email;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
