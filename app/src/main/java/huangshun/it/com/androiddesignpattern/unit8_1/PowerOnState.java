package huangshun.it.com.androiddesignpattern.unit8_1;

/**
 * Created by hs on 2017/6/29.
 * 开机状态
 */

public class PowerOnState implements TvState {

    @Override
    public void nextChannel() {
        System.out.println("下一个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一个频道");
    }

    @Override
    public void turnUp() {
        System.out.println("调高音量");
    }

    @Override
    public void turnDown() {
        System.out.println("调低音量");
    }
}
