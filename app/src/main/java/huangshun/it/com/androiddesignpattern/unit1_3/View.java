package huangshun.it.com.androiddesignpattern.unit1_3;

/**
 * Created by hs on 2017/5/26.
 * 建立视图春晖凑想,测量视图的宽高为公用代码,绘制实现交给具体的子类
 */

public abstract class View {
    public void measure(int width, int height) {//测量视图大小

    }

    abstract void draw();//
}
