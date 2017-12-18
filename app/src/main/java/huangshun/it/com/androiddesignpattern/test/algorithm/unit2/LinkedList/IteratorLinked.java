package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList;

import huangshun.it.com.androiddesignpattern.test.algorithm.unit2.CommonIterator;

/**
 * Created by hs on 2017/12/14.
 */

public class IteratorLinked {
    public static void main(String[] args) {
//        Iterator1();
        iterator3();

    }

    private static void iterator3() {
        StackLinked<Integer> integerStackLinked = new StackLinked<>();
        integerStackLinked.push(1);
        integerStackLinked.push(2);
        integerStackLinked.push(3);
        CommonIterator<Integer> iterator = (CommonIterator<Integer>) integerStackLinked.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    private static void Iterator1() {
        Node<Integer> nodeFirst = new Node<>();
        nodeFirst.item = 1;
        Node<Integer> nodeSecond = new Node<>();
        nodeSecond.item = 2;
        nodeFirst.next = nodeSecond;
        Node<Integer> nodeThird = new Node<>();
        nodeThird.item = 3;
        nodeSecond.next = nodeThird;

        for (Node<Integer> current = nodeFirst; current != null; current = current.next) {
            System.out.println(current.item);

        }
    }

    private static void iterator2() {
        StackLinked<Integer> integerStackLinked = new StackLinked<>();
        integerStackLinked.push(1);
        integerStackLinked.push(2);
        integerStackLinked.push(3);
        while (!integerStackLinked.isEmpty()) {
            System.out.println(integerStackLinked.pop());
        }
    }
}
