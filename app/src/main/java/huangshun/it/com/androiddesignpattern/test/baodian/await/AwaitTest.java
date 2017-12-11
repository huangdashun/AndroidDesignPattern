package huangshun.it.com.androiddesignpattern.test.baodian.await;

/**
 * Created by hs on 2017/12/7.
 */

public class AwaitTest {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("l");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        SubtractThread subtractThread = new SubtractThread(subtract, "subtract");
        subtractThread.start();

        SubtractThread subtract2 = new SubtractThread(subtract, "subtract2");
        subtract2.start();
        Thread.sleep(1000);
        AddThread addThread = new AddThread(add, "add");
        addThread.start();

    }
}
