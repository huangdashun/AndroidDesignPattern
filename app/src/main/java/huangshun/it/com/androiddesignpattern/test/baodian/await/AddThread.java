package huangshun.it.com.androiddesignpattern.test.baodian.await;

/**
 * Created by hs on 2017/12/8.
 */

public class AddThread extends Thread {
    private Add mAdd;

    public AddThread(Add add, String name) {
        mAdd = add;
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        mAdd.add();
    }
}
