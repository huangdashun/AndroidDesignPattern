package huangshun.it.com.androiddesignpattern.play.di.module;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hs on 2017/8/14.
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }
    @Singleton
    @Provides
    public Application providerApplication() {
        return mApplication;
    }
    @Singleton
    @Provides
    public Gson providerGson() {
        return new Gson();
    }
}
