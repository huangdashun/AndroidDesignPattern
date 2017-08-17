package huangshun.it.com.androiddesignpattern.play.presenter;

/**
 * Created by hs on 2017/8/5.
 */

public class BasePresenter<M, V extends BaseView> {
    M mModel;
    V mView;

    public BasePresenter(M model, V view) {
        this.mModel = model;
        this.mView = view;
    }
}
