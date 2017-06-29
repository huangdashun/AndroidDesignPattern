package huangshun.it.com.androiddesignpattern.unit6_5;

/**
 * Created by hs on 2017/6/16.
 */

public class Client {
    public static void main(String args[]) {
        //构造一个生产Q3的工厂
        CarFactory q3Factory = new Q3Factory();
        q3Factory.createTire().tire();
        q3Factory.createEngine().engine();
        q3Factory.createBrake().brake();

        //构造一个生产Q7的工厂
        CarFactory q7Factory = new Q7Factory();
        q7Factory.createTire().tire();
        q7Factory.createEngine().engine();
        q7Factory.createBrake().brake();
    }
}
