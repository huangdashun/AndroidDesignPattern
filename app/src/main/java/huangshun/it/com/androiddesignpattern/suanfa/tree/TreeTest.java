package huangshun.it.com.androiddesignpattern.suanfa.tree;

/**
 * Created by hs on 2017/11/18.
 */

public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(30, "小1");
        tree.insert(10, "小2");
        tree.insert(40, "小3");
        tree.insert(5, "小4");
        tree.insert(15, "小5");
        tree.insert(35, "小5");
        tree.insert(45, "小5");
        tree.insert(32, "小5");
        tree.insert(37, "小5");
        tree.insert(42, "小5");
        tree.insert(47, "小5");

//        System.out.println(tree.rootNode.data);
//        System.out.println(tree.rootNode.leftChild.data);
//        System.out.println(tree.rootNode.leftChild.leftChild.data);
//
//        System.out.println(tree.rootNode.rightChild.data);
//        System.out.println(tree.rootNode.rightChild.rightChild.data);
//
//        Node selectNode = tree.select(15);
//        if (selectNode == null) {
//            System.out.println("查找不到name");
//        } else {
//            System.out.println("name:" + selectNode.name);
//        }

        //前序遍历
//        tree.frontOrderNode(tree.rootNode);
        //中序遍历
//        tree.inOrder(tree.rootNode);
        //后序遍历
//        tree.afterOrder(tree.rootNode);
//        tree.delete(45);
//        tree.inOrder(tree.rootNode);
        meth1();
        meth2();
    }

    public static void meth1() {
        System.out.println("1");
        return;
    }

    public static void meth2() {
        System.out.println(2);
    }
}
