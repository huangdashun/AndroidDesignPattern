package huangshun.it.com.androiddesignpattern.test.genericity;

/**
 * Created by hs on 2017/7/31.
 * 自己实现的链式存储装置
 */

public class LinkedStack<T> {
    public static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        stringLinkedStack.push("abc");
        stringLinkedStack.push("aaa");
        stringLinkedStack.push("bbb");
        String s;
        while ((s = stringLinkedStack.pop()) != null) {
            System.out.println(s);
        }
    }
}
