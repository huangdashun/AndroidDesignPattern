package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 * 主板中介者
 */

public class MainBoard extends Mediator {
    private CDDevice mCDDevice;//光驱设备
    private CpuDevice mCpuDevice;//cpu
    private SoundCard mSoundCard;//声卡设备
    private GraphicsCard mGraphicsCard;//显卡设备

    public void setCDDevice(CDDevice CDDevice) {
        mCDDevice = CDDevice;
    }

    public void setCpuDevice(CpuDevice cpuDevice) {
        mCpuDevice = cpuDevice;
    }

    public void setSoundCard(SoundCard soundCard) {
        mSoundCard = soundCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        mGraphicsCard = graphicsCard;
    }

    @Override
    public void changed(Colleague colleague) {
        if (colleague == mCDDevice) {//如果是光驱读取了数据
            handleCd((CDDevice) colleague);
        }else if(colleague == mCpuDevice){
            handleCPU((CpuDevice) colleague);
        }
    }

    private void handleCPU(CpuDevice colleague) {
        String dataSound = colleague.getDataSound();
        String dataVideo = colleague.getDataVideo();
        mSoundCard.soundPlay(dataSound);
        mGraphicsCard.videoPlay(dataVideo);
    }

    //处理光驱读取数据后与其他设备的交互
    private void handleCd(CDDevice colleague) {
        mCpuDevice.decodeData(colleague.read());
    }
}
