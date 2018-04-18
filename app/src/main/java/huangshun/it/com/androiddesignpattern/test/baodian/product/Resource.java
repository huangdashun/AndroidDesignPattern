package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2018/3/15.
 */

public class Resource {

    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);

        flag = true;
        this.notifyAll();
    }

    public synchronized void get() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        this.notifyAll();
    }

    static class Producer implements Runnable {
        private Resource mResource;

        public Producer(Resource resource) {
            mResource = resource;
        }

        @Override
        public void run() {
            while (true) {
                mResource.set("商品");
            }
        }
    }

    static class Consumer implements Runnable {
        private Resource mResource;

        public Consumer(Resource resource) {
            mResource = resource;
        }

        @Override
        public void run() {
            while (true) {
                mResource.get();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        new Thread(producer).start();
        new Thread(consumer).start();


    }

}
