package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import dagger.Component;

/**
 * Created by hs on 2017/7/20.
 */


@ForActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActiviityModule.class})
public interface ActivityComponent {

    void inject(DaggerComponentActivity activity);

    void inject(DaggerComponentActivity.OtherClass otherClass);
}
