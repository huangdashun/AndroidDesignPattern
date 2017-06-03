package huangshun.it.com.androiddesignpattern.unit3_1;

/**
 * Created by hs on 2017/6/3.
 */

public class MacbookBuilder extends Builder {
    private Computer mComputer = new MacBook();

    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOs();
    }

    @Override
    public Computer create() {
        return mComputer;
    }

}
