package huangshun.it.com.androiddesignpattern.test.baodian.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by hs on 2017/12/4.
 */

public class Lambda {
    public static void main(String[] args) {
//        collectTest();
        sendEmail(() -> System.out.println("哈哈哈"));
        sendEmail(new Runnable() {
            @Override
            public void run() {

            }
        });
        comparator();
        functionTest();
        staticFunTest();
        instanceFunTest();
    }

    private static void instanceFunTest() {
        BiFunction<String, String, String> biFunction = String::concat;
        String result = biFunction.apply("哈哈", "啊");
    }

    private static void staticFunTest() {
        Function<List<Integer>, Integer> maxFn = Collections::max;

        Function<List<Integer>, Integer> maxFnComplex = (numbers) -> Collections.max(numbers);

        maxFn.apply(Arrays.asList(1, 2));

        maxFnComplex.apply(Arrays.asList(1, 2));
    }

    private static void functionTest() {
        Function<String, Integer> strToLenght = str -> str.length();
        Function<String, Integer> easyFun = String::length;//String是目标引用，::是定界符，length是目标引用要调用的方法
        Function<String, Integer> oldFun = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };
    }

    private static void comparator() {
        Comparator<String> comparator = (first, second) -> (first.length() - second.length());
    }

    private static void sendEmail(Runnable runnable) {
        runnable.run();
    }

    private static void collectTest() {
        List<String> list = Arrays.asList("hss", "as", "dsff");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Collections.sort(list, (first, second) -> first.length() - second.length());
        System.out.println(list);
    }
}
