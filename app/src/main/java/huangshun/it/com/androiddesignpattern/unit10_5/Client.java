package huangshun.it.com.androiddesignpattern.unit10_5;

/**
 * Created by hs on 2017/7/4.
 */

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("1 + 3 + 4");
        int calculate = calculator.calculate();
        System.out.println(calculate);
    }
}
