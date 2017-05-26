package huangshun.it.com.androiddesignpattern.unit1_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hs on 2017/5/25.
 * 图片加载类
 */

public class ImageLoader {
    //内存缓存
    ImageCache mImageCache = new ImageCache();
    //SD卡缓存
    DiskCache mDiskCache = new DiskCache();
    //双缓存
    DoubleCache mDoubleCache = new DoubleCache();
    //是否使用SD卡缓存
    boolean isUseDiskCache = false;
    //是否使用双缓存
    boolean isUseDoubleCache = false;

    //线程池,线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //设置是否使用SD卡缓存
    public void setUseDiskCache(boolean useDiskCache) {
        isUseDiskCache = useDiskCache;
    }

    public void setUseDoubleCache(boolean isUseDoubleCache) {
        this.isUseDoubleCache = isUseDoubleCache;
    }

    public void displayImage(final String url, final ImageView imageViw) {
        //判断使用哪种缓存
        Bitmap bitmap = null;
        if (isUseDiskCache) {//使用SD卡缓存
            bitmap = mDiskCache.get(url);
        } else if (isUseDoubleCache) {//使用双缓存
            bitmap = mDoubleCache.get(url);
        } else {
            bitmap = mImageCache.get(url);
        }
        if (bitmap != null) {
            imageViw.setImageBitmap(bitmap);
            return;
        }
        imageViw.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                //没有缓存教给线程池进行下载
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageViw.getTag().equals(url)) {
                    imageViw.setImageBitmap(bitmap);
                }
                mImageCache.put(url, bitmap);
            }
        });
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
