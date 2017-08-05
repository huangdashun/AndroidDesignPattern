package huangshun.it.com.androiddesignpattern.play.presenter.contract;

import java.util.List;

import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.presenter.BasePresenter;
import huangshun.it.com.androiddesignpattern.play.ui.BaseView;

/**
 * Created by hs on 2017/8/5.
 */

public interface RecommendContract {
    interface view extends BaseView<presenter> {
        void showError(String msg);

        void displayView(List<PageBean.DatasBean> datas);

        void showNoData();
    }

    interface presenter extends BasePresenter {
        void getResult();
    }
}
