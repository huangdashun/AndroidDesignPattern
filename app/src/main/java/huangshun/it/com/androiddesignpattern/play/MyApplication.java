package huangshun.it.com.androiddesignpattern.play;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import huangshun.it.com.androiddesignpattern.BuildConfig;
import huangshun.it.com.androiddesignpattern.play.di.component.AppComponent;
import huangshun.it.com.androiddesignpattern.play.di.component.DaggerAppComponent;
import huangshun.it.com.androiddesignpattern.play.di.module.AppModule;
import huangshun.it.com.androiddesignpattern.play.di.module.HttpModule;

/**
 * Created by hs on 2017/8/14.
 */

public class MyApplication extends MultiDexApplication implements Thread.UncaughtExceptionHandler {
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
        Thread.setDefaultUncaughtExceptionHandler(this);
        //初始化ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        Log.i("Test", "这句话是用来测试代码的");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
