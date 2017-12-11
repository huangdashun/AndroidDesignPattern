package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2017/12/8.
 * 生产者
 */

public class Product {
    private String lock;

    public Product(String lock) {
        this.lock = lock;
    }

    public void productValue() {
        try {
            synchronized (lock) {
                System.out.println("生产者拿到锁");
                if (!StringObject.value.equals("")) {
                    //有值不生产，等待消费者取
                    System.out.println("生产者开始等待");
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "" + System.nanoTime();
                System.out.println("set的值是：" + value);
                StringObject.value = value;
                //通知消费者来取
                System.out.println("生产者通知消费者");
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
