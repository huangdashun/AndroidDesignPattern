package huangshun.it.com.androiddesignpattern.file;

/**
 * Created by hs on 2017/9/8.
 */

public abstract class HttpCallback<T> {
    public abstract void onSuccess(T t);

    public abstract void onFail(Exception e);

    public abstract void onFinish();

    public abstract void inProgress(float progress, long total, int id);
}
