package huangshun.it.com.androiddesignpattern.test.baodian;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hs on 2017/11/15.
 */

public class BaoDianTest1 {
    public static void main(String[] args) {
        String str[] = new String[]{"啊", "哦", "饿"};
        List<String> strList = Arrays.asList(str);
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()) {
            String result = iterator.next();
            result = "修改啊";
            System.out.println(result);
        }
        System.out.println(strList);
    }
}
