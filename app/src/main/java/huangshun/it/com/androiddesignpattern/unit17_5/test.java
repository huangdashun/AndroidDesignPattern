package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 */

public class test {
    public static void main(String[] args) {
        MainBoard mainBoard = new MainBoard();
        CDDevice cdDevice = new CDDevice(mainBoard);
        CpuDevice cpuDevice = new CpuDevice(mainBoard);
        SoundCard soundCard = new SoundCard(mainBoard);
        GraphicsCard graphicsCard = new GraphicsCard(mainBoard);

        mainBoard.setCDDevice(cdDevice);
        mainBoard.setCpuDevice(cpuDevice);
        mainBoard.setGraphicsCard(graphicsCard);
        mainBoard.setSoundCard(soundCard);
        cdDevice.load();
    }
}
