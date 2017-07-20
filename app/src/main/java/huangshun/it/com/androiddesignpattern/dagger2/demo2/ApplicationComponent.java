package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import javax.inject.Singleton;

import dagger.Component;
import huangshun.it.com.androiddesignpattern.DaggerApplication;

/**
 * Created by hs on 2017/7/20.
 * App级别的Component对戏
 */


@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(DaggerApplication daggerApplication);

    //将ApplicationBean开放给其他Component使用
    ApplicationBean providerAppBean();
}
