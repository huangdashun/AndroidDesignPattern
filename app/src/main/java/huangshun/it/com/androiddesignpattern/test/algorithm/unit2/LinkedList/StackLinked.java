package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList;

import android.support.annotation.NonNull;

import java.util.Iterator;

import huangshun.it.com.androiddesignpattern.test.algorithm.unit2.CommonIterator;

/**
 * Created by hs on 2017/12/14.
 * 下压式堆栈，用链表实现
 */

public class StackLinked<Item> implements Iterable<Item> {
    int size;//链表元素的个数
    private Node<Item> firstNode;

    /**
     * 弹出栈
     *
     * @return
     */
    public Item pop() {
        size--;
        Item item = firstNode.item;
        firstNode = firstNode.next;
        return item;
    }

    /**
     * 入栈
     *
     * @param
     * @return
     */
    public void push(Item newItem) {
        size++;
        Node oldNodeFirst = firstNode;
        firstNode = new Node<>();
        firstNode.next = oldNodeFirst;
        firstNode.item = newItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return new CommonIterator(firstNode);
    }
}
