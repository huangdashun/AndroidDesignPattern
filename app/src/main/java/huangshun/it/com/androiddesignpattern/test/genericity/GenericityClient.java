package huangshun.it.com.androiddesignpattern.test.genericity;

/**
 * Created by hs on 2017/7/4.
 */

public class GenericityClient {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setDataK("123");
        Box<Integer> intBox = new Box<>();
        intBox.setDataK(123);
        test1();
    }

    private static void test1() {
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        getData(stringBox);
        getData(intBox);
    }

    public static void getData(Box<?> data) {
        System.out.println("data:" + data.getData());
    }
}
