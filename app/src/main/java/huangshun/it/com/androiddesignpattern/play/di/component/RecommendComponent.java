package huangshun.it.com.androiddesignpattern.play.di.component;

import dagger.Component;
import huangshun.it.com.androiddesignpattern.play.di.FragmentScope;
import huangshun.it.com.androiddesignpattern.play.di.module.RecommendModule;
import huangshun.it.com.androiddesignpattern.play.ui.fragment.RecommendFragment;

/**
 * Created by hs on 2017/8/8.
 */

@FragmentScope
@Component(modules = {RecommendModule.class}, dependencies = {AppComponent.class})
public interface RecommendComponent {
    void inject(RecommendFragment fragment);
}
