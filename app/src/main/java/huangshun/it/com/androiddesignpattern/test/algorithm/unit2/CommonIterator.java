package huangshun.it.com.androiddesignpattern.test.algorithm.unit2;

import java.util.Iterator;

import huangshun.it.com.androiddesignpattern.test.algorithm.unit2.LinkedList.Node;

/**
 * Created by hs on 2017/12/14.
 */

public class CommonIterator<Item> implements Iterator<Item> {
    private Node<Item> currentNode;

    public CommonIterator(Node<Item> currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Item next() {
        Node oldFirst = currentNode;
        currentNode = currentNode.next;
        return (Item) oldFirst.item;
    }
}
