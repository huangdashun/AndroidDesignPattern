package huangshun.it.com.androiddesignpattern.test.baodian.await;

/**
 * Created by hs on 2017/12/8.
 */

public class SubtractThread extends Thread {
    private Subtract mSubtract;

    public SubtractThread(Subtract subtract, String name) {
        mSubtract = subtract;
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        mSubtract.subtract();
    }
}
