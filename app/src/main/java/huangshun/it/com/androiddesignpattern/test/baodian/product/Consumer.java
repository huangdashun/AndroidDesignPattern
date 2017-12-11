package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2017/12/8.
 * 消费者
 */

public class Consumer {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void consumerProduct() {
        try {
            synchronized (lock) {
                System.out.println("消费者拿到锁");
                if (StringObject.value.equals("")) {
                    System.out.println("消费者开始等待");
                    //没有值不消费
                    lock.wait();
                }
                System.out.println("get的值是：" + StringObject.value);
                StringObject.value = "";
                System.out.println("消费者通知生产者");
                //唤醒生产者
                lock.notify();

            }
        } catch (InterruptedException e) {

        }
    }
}
