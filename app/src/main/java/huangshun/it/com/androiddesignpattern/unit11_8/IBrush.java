package huangshun.it.com.androiddesignpattern.unit11_8;

import android.graphics.Path;

/**
 * Created by hs on 2017/7/9.
 * 抽象的笔触
 */

public interface IBrush {
    void down(Path path, float x, float y);

    void move(Path path, float x, float y);

    void up(Path path, float x, float y);
}
