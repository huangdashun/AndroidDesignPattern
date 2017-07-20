package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hs on 2017/7/20.
 */

@Module
public class ActiviityModule {
    @Provides
    ActivityBean providerActivityBean() {
        return new ActivityBean();
    }
}
