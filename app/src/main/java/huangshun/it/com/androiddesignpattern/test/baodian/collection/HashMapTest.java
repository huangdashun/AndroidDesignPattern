package huangshun.it.com.androiddesignpattern.test.baodian.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hs on 2018/3/14.
 */

public class HashMapTest {

    public static void main(String[] args) {

//        ageSort();

        simulateStack();
    }

    /**
     * 使用两个队列模拟堆栈
     */
    private static void simulateStack() {
        //首先有两个队列
        Queue<String> firstQueue = new LinkedList<>();
        Queue<String> secondQueue = new LinkedList<>();

        firstQueue.offer("a");
        firstQueue.offer("b");
        firstQueue.offer("c");
        firstQueue.offer("d");
        firstQueue.offer("e");
        List<String> tempList = new ArrayList<>(firstQueue);
        Collections.reverse(tempList);
        for (int i = 0; i < tempList.size(); i++) {
            String s = tempList.get(i);
//            System.out.println(s);
            secondQueue.offer(s);

        }
        System.out.println("size:" + secondQueue.size());
        Iterator<String> iterator = secondQueue.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    private static void ageSort() {
        HashMap<Integer, User> hashMap = new HashMap<>();
        User user1 = new User(13, "张三");
        User user2 = new User(15, "李四");
        User user3 = new User(14, "王二麻子");

        hashMap.put(1, user1);
        hashMap.put(2, user2);
        hashMap.put(3, user3);

        System.out.println(hashMap);
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();

        List<Map.Entry<Integer, User>> list = new ArrayList<>(entries);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        HashMap<Integer, User> hashMap1 = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            hashMap1.put(list.get(i).getKey(), list.get(i).getValue());
        }

        System.out.println(hashMap1);
    }
}
