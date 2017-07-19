package huangshun.it.com.androiddesignpattern.dagger2.demo;

import dagger.Component;

/**
 * Created by hs on 2017/7/19.
 */

@Component(modules = {UserModule.class, OkhttpModule.class})
public interface UserComponent {
    void inject(DaggerDifInsActivity activity);

}
