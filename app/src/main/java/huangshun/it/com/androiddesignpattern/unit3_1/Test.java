package huangshun.it.com.androiddesignpattern.unit3_1;

/**
 * Created by hs on 2017/6/3.
 */

public class Test {
    public static void main(String[] args) {
        Builder builder = new MacbookBuilder();
        Director director = new Director(builder);
        director.construct("英特尔主板", "苹果显示器");
        System.out.println(builder.create().toString());
    }
}
