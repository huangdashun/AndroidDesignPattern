package huangshun.it.com.androiddesignpattern.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by hs on 2017/6/27.
 */

public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;

    /**
     * 建立关联
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 获取View
     *
     * @return
     */
    protected T getView() {
        return mViewRef.get();
    }

    /**
     * 判断是否与View建立了关联
     *
     * @return
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解除关联
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
