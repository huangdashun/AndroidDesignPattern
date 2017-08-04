package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 */

public class CpuDevice extends Colleague {
    private String dataVideo, dataSound;//视频和音频数据

    public CpuDevice(Mediator mediator) {
        super(mediator);
    }

    public String getDataVideo() {
        return dataVideo;
    }

    public String getDataSound() {
        return dataSound;
    }

    public void decodeData(String read) {
        String[] tmp = read.split(",");
        dataVideo = tmp[0];
        dataSound = tmp[1];
        mMediator.changed(this);

    }
}
