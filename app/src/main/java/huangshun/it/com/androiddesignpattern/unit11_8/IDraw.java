package huangshun.it.com.androiddesignpattern.unit11_8;

import android.graphics.Canvas;

/**
 * Created by hs on 2017/7/9.
 * 抽象的命令
 */

public interface IDraw {
    void draw(Canvas canvas);

    void undo();
}
