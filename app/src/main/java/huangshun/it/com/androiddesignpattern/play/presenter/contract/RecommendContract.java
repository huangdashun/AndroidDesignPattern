package huangshun.it.com.androiddesignpattern.play.presenter.contract;

import java.util.List;

import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.presenter.BaseView;

/**
 * Created by hs on 2017/8/5.
 */

public interface RecommendContract {
    interface view extends BaseView {
        void showError(String msg);

        void displayView(List<PageBean.DatasBean> datas);

        void showNoData();
    }

}
