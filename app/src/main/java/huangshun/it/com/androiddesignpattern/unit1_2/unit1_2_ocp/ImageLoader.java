package huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp;

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
    huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.ImageCache mImageCache = new MemoryCache();
    //线程池,线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void setImageCache(ImageCache imageCache) {
        mImageCache = imageCache;
    }

    public void displayImage(final String url, final ImageView imageViw) {
        Bitmap bitmap = mImageCache.get(url);

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
