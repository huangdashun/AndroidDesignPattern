package huangshun.it.com.androiddesignpattern.unit15_1;

/**
 * Created by hs on 2017/7/25.
 */

public class Test {
    public static void main(String[] args) {
        AbstractComputer coderComputer = new CoderComputer();

        coderComputer.startUp();
        AbstractComputer militaryComputer = new MilitaryComputer();
        militaryComputer.startUp();
    }
}
