package huangshun.it.com.androiddesignpattern.unit3_1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.ImageCache;
import huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.MemoryCache;

/**
 * Created by hs on 2017/6/3.
 */

public class ImageLoader {
    //图片缓存
    ImageCache mImageCache = new MemoryCache();
    //图片加载中显示的图片id
    int mLoadingImageId;
    //加载失败时显示的图片id
    int mErrorImageid;
    //线程池,线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.
            newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static ImageLoader mImageLoader = null;

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

    public void setImageCache(ImageCache imageCache) {
        mImageCache = imageCache;
    }

    public void setLoadingImageId(int loadingImageId) {
        mLoadingImageId = loadingImageId;
    }

    public void setErrorImageid(int errorImageid) {
        mErrorImageid = errorImageid;
    }

    public void setThreadCount(int count) {
        mExecutorService.shutdown();
        mExecutorService = null;
        mExecutorService = Executors.newFixedThreadPool(count);
    }

    public void displayImage(String imageUrl, ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //提交图片加载请求
        submitLoadRequest(imageUrl, imageView);
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        //设置等待加载时的图片
        imageView.setImageResource(mLoadingImageId);
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap downloadimgae = downloadimgae(imageUrl);
                if (downloadimgae == null) {
                    imageView.setImageResource(mErrorImageid);
                    return;
                }
                imageView.setImageBitmap(downloadimgae);
            }
        });
    }

    private Bitmap downloadimgae(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
