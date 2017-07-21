package huangshun.it.com.androiddesignpattern.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by hs on 2017/7/21.
 * 在泛型为Integer的ArrayList中存放一个String类型的对象。
 */

public class TestReflect9 {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(22);
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list, "黄顺");
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}
