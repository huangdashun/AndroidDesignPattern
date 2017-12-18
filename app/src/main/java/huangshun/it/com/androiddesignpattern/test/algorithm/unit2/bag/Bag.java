package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.bag;

import android.support.annotation.NonNull;

import java.util.Iterator;

import huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList.Node;

/**
 * Created by hs on 2017/12/14.
 * 包数据结构
 * 不支持删除
 */

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Item item) {
        if (isEmpty()) {
            first = new Node<>();
            first.item = item;
        } else {
            Node oldFirst = first;
            first = new Node<>();
            first.item = item;
            first.next = oldFirst;
        }
        size++;

    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
