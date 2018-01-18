package huangshun.it.com.androiddesignpattern.play;

import android.support.multidex.MultiDexApplication;

import huangshun.it.com.androiddesignpattern.play.di.component.AppComponent;
import huangshun.it.com.androiddesignpattern.play.di.component.DaggerAppComponent;
import huangshun.it.com.androiddesignpattern.play.di.module.AppModule;
import huangshun.it.com.androiddesignpattern.play.di.module.HttpModule;

/**
 * Created by hs on 2017/8/14.
 */

public class MyApplication extends MultiDexApplication {
    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();
    }
}
