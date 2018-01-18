package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList;

import android.support.annotation.NonNull;

import java.util.NoSuchElementException;

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
     * 返回当前item，但是不弹出
     *
     * @return
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return firstNode.item;
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

    /**
     * 复制stack
     *
     * @param stack
     * @param <T>
     */
    public static <T> StackLinked<T> Copy(StackLinked<T> stack) {
        StackLinked<T> tempStack = new StackLinked<T>();
        StackLinked<T> resultStack = new StackLinked<T>();
        if (!stack.isEmpty()) {
            CommonIterator<T> iterator = stack.iterator();
            while (iterator.hasNext()) {
                tempStack.push(iterator.next());
            }
            iterator = tempStack.iterator();
            while (iterator.hasNext()) {
                resultStack.push(iterator.next());
            }
        }
        return resultStack;
    }

    @NonNull
    @Override
    public CommonIterator<Item> iterator() {
        return new CommonIterator(firstNode);
    }
}
