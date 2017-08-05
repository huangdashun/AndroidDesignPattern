package huangshun.it.com.androiddesignpattern.play.ui;

/**
 * Created by hs on 2017/8/5.
 */

public interface BaseView<T> {
    void setPresenter(T t);

    void showLoading();

    void dismissLoading();
}
