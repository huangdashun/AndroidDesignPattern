package huangshun.it.com.androiddesignpattern.unit4_9;

/**
 * Created by hs on 2017/6/6.
 * 用户地址类
 */

public class Address {
    //城市
    public String city;
    //区
    public String district;
    //街道
    public String street;

    public Address(String city, String district, String street) {
        this.city = city;
        this.district = district;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
