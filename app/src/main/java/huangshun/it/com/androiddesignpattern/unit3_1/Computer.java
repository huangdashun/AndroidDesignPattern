package huangshun.it.com.androiddesignpattern.unit3_1;

/**
 * Created by hs on 2017/6/3.
 */

public abstract class Computer {
    protected String mBoard;//主机
    protected String mDisplay;//显示器
    protected String mOs;//操作系统

    public void setBoard(String board) {
        mBoard = board;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public abstract void setOs();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
