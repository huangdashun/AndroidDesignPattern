package huangshun.it.com.androiddesignpattern.unit8_1;

/**
 * Created by hs on 2017/6/29.
 * 电视遥控器
 */

public class TvController implements PowerController {
    private TvState mTvState;

    public void setTvState(TvState tvState) {
        mTvState = tvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机");
    }

    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void prevChannel() {
        mTvState.prevChannel();
    }

    public void turnUp() {
        mTvState.turnUp();
    }

    public void turnDown() {
        mTvState.turnDown();
    }
}
