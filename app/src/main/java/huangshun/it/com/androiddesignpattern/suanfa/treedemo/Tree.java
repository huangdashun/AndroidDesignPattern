package huangshun.it.com.androiddesignpattern.suanfa.treedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2018/4/1.
 */

public class Tree<T> {
    private Node<T> root;//根，也就是老大

    public Tree(T rootData) {
        root = new Node<>();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    public Node<T> getRoot() {
        return root;
    }

    public static class Node<T> {
        private T data;//自己的相关信息
        private Node<T> parent;//上级
        private List<Node<T>> children;//下级

        public void setData(T data) {
            this.data = data;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public void setChildren(List<Node<T>> children) {
            this.children = children;
        }

        public T getData() {
            return data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }
    }
}
