package huangshun.it.com.androiddesignpattern.test.baodian.await;

/**
 * Created by hs on 2017/12/7.
 */

public class Subtract {
    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName:" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName:" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("List size = " + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
