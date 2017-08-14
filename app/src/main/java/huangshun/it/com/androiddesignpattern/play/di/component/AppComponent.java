package huangshun.it.com.androiddesignpattern.play.di.component;

import javax.inject.Singleton;

import dagger.Component;
import huangshun.it.com.androiddesignpattern.play.data.http.ApiService;
import huangshun.it.com.androiddesignpattern.play.di.module.AppModule;
import huangshun.it.com.androiddesignpattern.play.di.module.HttpModule;

/**
 * Created by hs on 2017/8/14.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    ApiService getApiService();
}
