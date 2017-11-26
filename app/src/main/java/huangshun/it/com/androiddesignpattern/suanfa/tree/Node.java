package huangshun.it.com.androiddesignpattern.suanfa.tree;

/**
 * Created by hs on 2017/11/18.
 * 树的节点
 */

public class Node {
    public Long data;
    public String name;
    public Node leftChild;
    public Node rightChild;

    public Node(Long data,String name) {
        this.data = data;
        this.name = name;
    }
}
