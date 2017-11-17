package huangshun.it.com.androiddesignpattern.test.baodian;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hs on 2017/11/16.
 */

public class ListTest {
    public static void main(String[] args) {
        String str[] = new String[]{"你好", "哈喽", "大家好才是真的好"};
        List<String> dataList = Arrays.asList(str);
        //先找到哈喽的index
        int index = dataList.indexOf("哈喽");
        //利用set修改指定索引的值
        dataList.set(index, "你好");
        System.out.println(dataList);
    }

}
