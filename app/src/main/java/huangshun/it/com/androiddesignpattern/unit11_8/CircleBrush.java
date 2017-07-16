package huangshun.it.com.androiddesignpattern.unit11_8;

import android.graphics.Path;

/**
 * Created by hs on 2017/7/9.
 */

public class CircleBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x, y, 10, Path.Direction.CW);//clockwise 顺时针
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
