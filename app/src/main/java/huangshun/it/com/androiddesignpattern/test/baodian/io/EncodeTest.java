package huangshun.it.com.androiddesignpattern.test.baodian.io;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by hs on 2017/11/28.
 */

public class EncodeTest {
    public static void main(String[] args) {
//        String str = "我要加油Hello";
//        byte[] bytes = str.getBytes();
//        System.out.println("字节长度：" + bytes.length);
//        System.out.println("字符长度：" + str.length());
//        //获取系统的默认编码格式
//        System.out.println(System.getProperty("file.encoding"));
//        int length = str.length();
//        for (int i = 0; i < length; i++) {
//            if (i + 1 <= length) {
//                String temp = str.substring(i, i + 1);
//                System.out.println("每个字符占的字节数：" + temp.getBytes().length);
//            }
//        }
//        String str = "Hello World";

//        System.out.println(String.format("%14.4s", str));

        File file = new File("/Users/huangshun/Desktop/test");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
        File[] new1s = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals("new1");
            }
        });
    }
}
