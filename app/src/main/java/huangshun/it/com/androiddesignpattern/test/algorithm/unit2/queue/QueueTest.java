package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by hs on 2017/12/10.
 */

public class QueueTest {
    public static void main(String[] args) {
        int[] arrayData = getArrayData();
        System.out.println(arrayData.length);
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
