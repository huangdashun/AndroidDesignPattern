package huangshun.it.com.androiddesignpattern.unit11_8;

import android.graphics.Path;

/**
 * Created by hs on 2017/7/9.
 * 正常的笔触
 */

public class NormalBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x, y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x, y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
