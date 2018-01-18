package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by hs on 2017/12/10.
 */

public class QueueTest {
    public static void main(String[] args) {
//        int[] arrayData = getArrayData();
//        System.out.println(arrayData.length);

//        queueLinkedTest();
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        int size = queue.getSize();
        for (int i = 0; i < size - 7; i++) {
            String item = queue.dequeue();
            if (i == size - 7) {
                System.out.println(item);
            }
        }
    }

    private static void queueLinkedTest() {
        QueueLinked<Integer> queueLinked = new QueueLinked<>();
        queueLinked.enqueue(1);
        queueLinked.enqueue(2);
        queueLinked.enqueue(3);
        while (!queueLinked.isEmpty()) {
            System.out.println(queueLinked.dequeue());
        }
    }

    private static int[] getArrayData() {
        In in = new In("/Users/huangshun/Desktop/test/new1");
        Queue<Integer> queue = new Queue<>();
        while (!in.isEmpty()) {
            int number = in.readInt();
            queue.enqueue(number);
        }
        int[] numbers = new int[queue.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = queue.dequeue();
        }
        return numbers;
    }
}
