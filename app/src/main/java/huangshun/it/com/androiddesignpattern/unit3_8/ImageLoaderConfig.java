package huangshun.it.com.androiddesignpattern.unit3_8;

import huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.ImageCache;
import huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.MemoryCache;

/**
 * Created by hs on 2017/6/3.
 * 图片加载配置对象
 */

public class ImageLoaderConfig {
    //图片缓存配置对象
    ImageCache imageCache = new MemoryCache();
    //加载图片时的loading和加载失败的图片配置对象
    DisplayConfig displayConfig = new DisplayConfig();
    //线程数量
    int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    private ImageLoaderConfig() {

    }

    public static class Builder {
        //图片缓存对象
        ImageCache imageCache = new MemoryCache();
        DisplayConfig displayConfig = new DisplayConfig();
        int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        //设置线程数量
        public Builder setThreadCount(int count) {
            threadCount = count;
            return this;
        }

        //设置缓存
        public Builder setCache(ImageCache imageCache) {
            this.imageCache = imageCache;
            return this;
        }

        //设置图片加载中显示的图片
        public Builder setLoadingPlaceholder(int resId) {
            displayConfig.loadingResId = resId;
            return this;
        }

        //设置图片加载错误显示的图片
        public Builder setNotFoundPlaceholder(int resId) {
            displayConfig.failedResId = resId;
            return this;
        }

        void applyConfig(ImageLoaderConfig imageLoaderConfig) {
            imageLoaderConfig.imageCache = this.imageCache;
            imageLoaderConfig.displayConfig = this.displayConfig;
            imageLoaderConfig.threadCount = this.threadCount;
        }

        public ImageLoaderConfig create() {
            ImageLoaderConfig config = new ImageLoaderConfig();
            applyConfig(config);
            return config;
        }
    }

}
