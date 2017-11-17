package huangshun.it.com.androiddesignpattern.test.baodian;

/**
 * Created by hs on 2017/11/15.
 */

public class StringTest {
    public static void main(String[] args) {
//        String a = "哈喽";
//        String b = a;
//        b = "你好";
//        System.out.println(a);
//        System.out.println(b);
        StringBuffer a = new StringBuffer("Hello");
        StringBuffer b = a;
        b.append(", World");
        System.out.println("a is " + a);
    }
}
