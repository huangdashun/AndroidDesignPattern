package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 */

public class CDDevice extends Colleague {
    private String data;

    public CDDevice(Mediator mediator) {
        super(mediator);
    }

    public String read() {
        return data;
    }

    public void load() {
        data = "视频,音频数据";
        mMediator.changed(this);
    }
}
