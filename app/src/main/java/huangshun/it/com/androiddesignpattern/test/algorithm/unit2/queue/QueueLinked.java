package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.queue;

import huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList.Node;

/**
 * Created by hs on 2017/12/14.
 * 用链表实现的队列
 */

public class QueueLinked<Item> {
    private Node<Item> firstNode;
    private Node<Item> lastNode;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        //将新节点添加到最后
        Node oldNode = lastNode;
        lastNode = new Node<>();
        lastNode.item = item;
        lastNode.next = null;
        if (isEmpty()) {//如果队列为空,即lastNode为null
            firstNode = lastNode;
        } else {
            oldNode.next = lastNode;
        }
        size++;
    }

    public Item dequeue() {
        //从表头删除节点
        if (isEmpty()) {
            return null;
        }
        Item oldFirstItem = firstNode.item;
        firstNode = firstNode.next;
        size--;
        return oldFirstItem;
    }
}
