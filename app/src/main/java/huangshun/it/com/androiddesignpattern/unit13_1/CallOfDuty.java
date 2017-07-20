package huangshun.it.com.androiddesignpattern.unit13_1;

/**
 * Created by hs on 2017/7/19.
 * Originator:负责创建一个备忘录,可以记录、恢复自身的内部状态.同时Originator还可以根据需要决定Memento
 */

public class CallOfDuty {
    private int mCheckPoint = 1;
    private int mLifeValue = 100;
    private String mWeapon = "沙漠之鹰";

    public void play() {
        System.out.println("打游戏:" + String.format("第%d关", mCheckPoint) + "奋战杀敌中");
        mLifeValue -= 10;
        System.out.println("进度升级啦");
        mCheckPoint++;
        System.out.println("到达" + String.format("第%d关", mCheckPoint));
    }

    //退出游戏
    public void quit() {
        System.out.println("-----------");
        System.out.println("退出之前的游戏属性:" + this.toString());
        System.out.println("退出游戏");
        System.out.println("-----------");
    }

    @Override
    public String toString() {
        return "CallOfDuty{" +
                "mCheckPoint=" + mCheckPoint +
                ", mLifeValue=" + mLifeValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }

    /**
     * 创建备忘录
     */
    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckPoint = mCheckPoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    /**
     * 恢复游戏
     */
    public void restoreMemoto(Memoto memoto) {
        this.mCheckPoint = memoto.mCheckPoint;
        this.mLifeValue = memoto.mLifeValue;
        this.mWeapon = memoto.mWeapon;
        System.out.println("恢复后的游戏属性:" + this.toString());
    }
}
