package huangshun.it.com.androiddesignpattern.test.genericity;

/**
 * Created by hs on 2017/7/31.
 */

public class LinkedStackForString {
    public static class NodeString {
        private String item;
        private NodeString next;

        public NodeString() {
            item = null;
            next = null;
        }

        public NodeString(String item, NodeString next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

    private NodeString top = new NodeString();


    public void push(String s) {
        top = new NodeString(s, top);
    }

    public String pop() {
        String item = top.item;
        if (item == null) {
            System.out.println("item为null");
        } else {
            System.out.println("item不为null");
        }
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStackForString linkedStackForString = new LinkedStackForString();
        linkedStackForString.push("bbb");
        linkedStackForString.push("ccc");
        linkedStackForString.push("ddd");
        String s;
        while ((s = linkedStackForString.pop()) != null) {
            System.out.println(s);
        }
    }
}
