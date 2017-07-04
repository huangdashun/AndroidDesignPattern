package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 * 抽象请求者
 */

public abstract class AbstractRequest {
    private Object obj;//处理对象

    public AbstractRequest(Object obj) {
        this.obj = obj;
    }

    public Object getContent() {
        return obj;
    }

    public abstract int getRequestLevel();
}
