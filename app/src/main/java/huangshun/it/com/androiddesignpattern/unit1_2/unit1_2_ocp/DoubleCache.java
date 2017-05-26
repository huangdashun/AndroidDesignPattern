package huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp;

import android.graphics.Bitmap;

import huangshun.it.com.androiddesignpattern.unit1_2.ImageCache;

/**
 * Created by hs on 2017/5/25.
 * 双缓存.获取图片时先从内存缓存中获取,如果内存中没有缓存该图片,再从SD卡中获取.
 * 缓存图片也是在内存和SD卡中都缓存一份
 */

public class DoubleCache implements huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.ImageCache {
    huangshun.it.com.androiddesignpattern.unit1_2.ImageCache mImageCache = new ImageCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存缓存中获取图片,如果没有,再从SD卡中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和SD卡中
    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
