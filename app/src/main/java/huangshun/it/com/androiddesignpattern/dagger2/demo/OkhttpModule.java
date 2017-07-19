package huangshun.it.com.androiddesignpattern.dagger2.demo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by hs on 2017/7/19.
 */

@Module
public class OkhttpModule {

    @Provides
    public OkHttpClient providerOkHttpClient() {
        return new OkHttpClient();
    }
}
