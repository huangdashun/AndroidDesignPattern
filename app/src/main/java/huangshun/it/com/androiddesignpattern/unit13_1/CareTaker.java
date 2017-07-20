package huangshun.it.com.androiddesignpattern.unit13_1;

/**
 * Created by hs on 2017/7/19.
 * 负责存储备忘录不能对备忘录的内容进行操作和访问,只能够将备忘录传递给其他对象.
 */

public class CareTaker {
    private Memoto mMemoto;

    public void archive(Memoto memoto) {
        this.mMemoto = memoto;
    }

    public Memoto getMemoto() {
        return mMemoto;
    }
}
