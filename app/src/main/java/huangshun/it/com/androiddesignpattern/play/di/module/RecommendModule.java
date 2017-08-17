package huangshun.it.com.androiddesignpattern.play.di.module;

import android.app.ProgressDialog;

import dagger.Module;
import dagger.Provides;
import huangshun.it.com.androiddesignpattern.play.data.RecommendModel;
import huangshun.it.com.androiddesignpattern.play.data.http.ApiService;
import huangshun.it.com.androiddesignpattern.play.di.FragmentScope;
import huangshun.it.com.androiddesignpattern.play.presenter.RecommendPresenter;
import huangshun.it.com.androiddesignpattern.play.presenter.contract.RecommendContract;
import huangshun.it.com.androiddesignpattern.play.ui.fragment.RecommendFragment;

/**
 * Created by hs on 2017/8/8.
 */

@Module
public class RecommendModule {
    private RecommendContract.view mView;

    public RecommendModule(RecommendContract.view view) {
        mView = view;
    }

    @Provides
    public RecommendPresenter providerRecommendPresenter(RecommendContract.view view, RecommendModel model) {
        return new RecommendPresenter(model, view);
    }

    @Provides
    public RecommendContract.view providerView() {
        return mView;
    }

    @Provides
    public ProgressDialog providerProgressDialog() {
        return new ProgressDialog(((RecommendFragment) mView).getActivity());
    }

    @Provides
    @FragmentScope
    public RecommendModel providerModel(ApiService apiService) {
        return new RecommendModel(apiService);
    }
}
