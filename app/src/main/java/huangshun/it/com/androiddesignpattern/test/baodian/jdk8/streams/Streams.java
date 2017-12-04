package huangshun.it.com.androiddesignpattern.test.baodian.jdk8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by hs on 2017/12/4.
 */

public class Streams {
    private enum Status {
        OPEN, CLOSED
    }

    static class Task {

        private Status mStatus;
        private Integer number;

        public Task(Status status, Integer number) {
            mStatus = status;
            this.number = number;
        }

        public Status getStatus() {
            return mStatus;
        }

        public Integer getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return "TASK:" + String.format("[%s,%d]", mStatus, number);
        }
    }

    public static void main(String[] args) {
//        streamTest();
//        intStreamTest();
        flatMapTest();
    }

    private static void flatMapTest() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6));
        listStream.flatMap(list -> list.stream())
                .filter(integer -> integer > 3)
                .forEach(System.out::println);
    }

    private static void intStreamTest() {
        IntStream.of(new int[]{1, 2, 3})
                .forEach(System.out::println);
        IntStream.range(1, 3)
                .forEach(System.out::println);
        IntStream.rangeClosed(1, 3)
                .forEach(System.out::println);
    }

    private static void streamTest() {
        List<Task> tasks = Arrays.asList(new Task(Status.OPEN, 10), new Task(Status.OPEN, 15)
                , new Task(Status.CLOSED, 20));
        int sum = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getNumber)
                .sum();
//        System.out.println("Total:" + sum);
        Integer integer = tasks.stream().parallel()
                .map(task -> task.getNumber())
                .reduce(0, Integer::sum);
        System.out.println(integer);
    }

    /**
     * 构造流的方式
     */
    private static void constructStream() {
        //1.individual values
        Stream<String> stream = Stream.of("a", "b", "c");
        //2.Arrays
        String[] strArr = new String[]{"a", "b", "c"};
        //3.Collections
        Stream<String> ListStream = Arrays.asList(strArr).stream();

        //流转换为其它数据结构
        //1.Array
        String[] strings = stream.toArray(String[]::new);
        //2.Collection
        List<String> collectList = stream.collect(Collectors.toList());
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        //3.String
        String str = stream.collect(Collectors.joining()).toString();
    }
}
