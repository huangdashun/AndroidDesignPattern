package huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp;

import android.graphics.Bitmap;

/**
 * Created by hs on 2017/5/26.
 */

public interface ImageCache {
    void put(String url, Bitmap bitmap);

    Bitmap get(String url);
}
