package huangshun.it.com.androiddesignpattern;

import android.app.Application;
import android.util.Log;

import com.mikepenz.iconics.Iconics;

import javax.inject.Inject;

import huangshun.it.com.androiddesignpattern.dagger2.demo2.ApplicationBean;
import huangshun.it.com.androiddesignpattern.dagger2.demo2.ApplicationComponent;
import huangshun.it.com.androiddesignpattern.dagger2.demo2.DaggerApplicationComponent;
import huangshun.it.com.androiddesignpattern.play.typeface.Iconfont;

/**
 * Created by hs on 2017/7/19.
 */

public class DaggerApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Inject
    ApplicationBean mBean1;

    @Inject
    ApplicationBean mBean2;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.create();
        }

        mApplicationComponent.inject(this);

        Log.d("Dagger", "Application mAppBean1:" + mBean1);
        Log.d("Dagger", "Application mAppBean2:" + mBean2);

        Iconics.init(getApplicationContext());
        Iconics.registerFont(new Iconfont());
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
