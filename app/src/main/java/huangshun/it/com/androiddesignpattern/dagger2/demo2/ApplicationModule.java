package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hs on 2017/7/20.
 * App纪的Moudle对象
 */

@Module
public class ApplicationModule {
    //作为单例模式注入app
    @Singleton
    @Provides
    ApplicationBean providerAppBean() {
        return new ApplicationBean();
    }
}
