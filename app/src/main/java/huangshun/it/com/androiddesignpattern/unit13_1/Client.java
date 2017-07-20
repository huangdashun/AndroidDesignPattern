package huangshun.it.com.androiddesignpattern.unit13_1;

/**
 * Created by hs on 2017/7/19.
 */

public class Client {
    public static void main(String[] args) {
        //创建一个游戏
        CallOfDuty callOfDuty = new CallOfDuty();
        callOfDuty.play();
        CareTaker careTaker = new CareTaker();
        careTaker.archive(callOfDuty.createMemoto());//存档
        //结束游戏
        callOfDuty.quit();
        CallOfDuty newGame = new CallOfDuty();
        newGame.restoreMemoto(careTaker.getMemoto());


    }
}
