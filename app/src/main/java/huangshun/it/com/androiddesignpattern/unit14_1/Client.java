package huangshun.it.com.androiddesignpattern.unit14_1;

/**
 * Created by hs on 2017/7/21.
 */

public class Client {
    public static void main(String[] args) {
        Aggregate a = new ConcreteAggregate<>();
        a.add("小明");
        a.add("小噶");
        a.add("小sdf");
        a.add("小水电费");
        Iterator iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
