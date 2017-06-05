package huangshun.it.com.androiddesignpattern.unit3_8;

import android.widget.ImageView;

/**
 * Created by hs on 2017/6/3.
 */

public class ImageLoader {
    private static ImageLoader mImageLoader;
    private ImageLoaderConfig mConfig;

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = new ImageLoader();
                }
            }
        }
        return mImageLoader;
    }

    public void init(ImageLoaderConfig config) {
        mConfig = config;
//        checkConfig();
    }

    public void displayImage(String imageUrl, ImageView imageView) {

    }
}
