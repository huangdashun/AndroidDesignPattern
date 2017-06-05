package huangshun.it.com.androiddesignpattern.unit3_8;

import huangshun.it.com.androiddesignpattern.unit1_2.unit1_2_ocp.MemoryCache;

/**
 * Created by hs on 2017/6/3.
 */

public class Test {
    public static void main(String[] args) {
        ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig.Builder()
                .setCache(new MemoryCache())
                .setThreadCount(4)
                .setLoadingPlaceholder(3)
                .setNotFoundPlaceholder(5)
                .create();
        ImageLoader.getInstance().init(imageLoaderConfig);
    }

}
