package huangshun.it.com.androiddesignpattern.suanfa.tree;

/**
 * Created by hs on 2017/11/18.
 * 二叉树
 */

public class Tree {
    //根节点
    public Node rootNode;

    //插入节点
    public void insert(long value, String name) {
        //要插入的节点
        Node newNode = new Node(value, name);
        Node currentNode = rootNode;//当前的节点
        Node parentNode;//当前节点的父亲
        //如果树为空
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            while (true) {
                //父亲节指向当前节点
                parentNode = currentNode;
                if (value < currentNode.data) {//如果小于当前的节点,向左边走
                    currentNode = parentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else {//如果大于当前的节点,向右走
                    currentNode = parentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }

                }
            }
        }

    }


    //查询节点
    public Node select(long value) {
        if (rootNode == null) {
            return null;
        }
        Node currentNode = rootNode;
        while (currentNode.data != value) {
            if (value < currentNode.data) {//在左边
                currentNode = currentNode.leftChild;
            } else {//在右边
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * 遍历二叉树
     * 用到了递归
     * 前序遍历
     */

    public void frontOrderNode(Node currentNode) {
        if (currentNode != null) {
            System.out.println("data:" + currentNode.data + "");
            frontOrderNode(currentNode.leftChild);//前序遍历左子树
            frontOrderNode(currentNode.rightChild);//前序遍历右子树
        }
    }

    /**
     * 中序遍历
     *
     * @param currentNode
     */
    public void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.leftChild);
            System.out.println("data:" + currentNode.data + "");
            inOrder(currentNode.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param currentNode
     */
    public void afterOrder(Node currentNode) {
        if (currentNode != null) {
            afterOrder(currentNode.leftChild);
            afterOrder(currentNode.rightChild);
            System.out.println("data:" + currentNode.data + "");
        }

    }

    /**
     * 1.删除叶子节点的
     */
    public void delete(long value) {
        if (rootNode == null) {
            return;
        }
        Node currentNode = rootNode;
        Node parentNode = rootNode;//当前节点的父节点
        boolean isLeftChild = true;
        while (currentNode.data != value) {
            parentNode = currentNode;
            if (value < currentNode.data) {//左子树
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {//右子树
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
            if (currentNode == null) {
                return;
            }
        }
        //叶子节点
        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (currentNode.rightChild == null) {//如果右孩子为null
            if (currentNode == rootNode) {
                rootNode = currentNode.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.leftChild;
            } else {
                parentNode.rightChild = currentNode.leftChild;
            }
        } else if (currentNode.leftChild == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.rightChild;
            } else {
                parentNode.rightChild = currentNode.rightChild;
            }
        } else {//如果要删除的当前节点有左右孩子,需要先找到中序后继节点
            Node successNode = findAfterNode(currentNode);
            if (currentNode == rootNode) {
                rootNode = successNode;
            } else if (isLeftChild) {
                //如果删除的是左节点
                parentNode.leftChild = successNode;
            } else {
                parentNode.rightChild = successNode;
            }
            successNode.leftChild = currentNode.leftChild;

        }

    }

    /**
     * i
     * 寻找中序后继节点
     *
     * @param delNode
     */
    private Node findAfterNode(Node delNode) {
        Node successNode = delNode;//需要找的中序后继节点
        Node successParentNode = delNode;//需要的找的中序后继节点的父亲节点
        Node currentNode = delNode.rightChild;
        while (currentNode != null) {
            successParentNode = successNode;
            successNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        if (successNode != delNode.rightChild) {//如果要找的中序后继节点不是当前节点的直接孩子
            successParentNode.leftChild = successNode.rightChild;
            successNode.rightChild = delNode.rightChild;
        }

        return successNode;
    }
}
