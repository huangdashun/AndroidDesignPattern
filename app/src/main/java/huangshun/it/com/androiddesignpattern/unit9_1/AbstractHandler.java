package huangshun.it.com.androiddesignpattern.unit9_1;

/**
 * Created by hs on 2017/6/30.
 * 抽象矗立着
 */

public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;//下一节点上的处理者对象

    /**
     * 处理请求
     *
     * @param request 请求对象
     */
    public final void handleRequest(AbstractRequest request) {
        if (getHandlerLevel() == request.getRequestLevel()) {
            handler(request);
        } else {
            if (nextHandler != null) {
                nextHandler.handler(request);
            } else {
                System.out.println("不能处理");
            }
        }
    }

    /**
     * 获取处理者对象的处理级别
     *
     * @return
     */
    protected abstract int getHandlerLevel();

    /**
     * 每个处理者对象的具体处理方式
     *
     * @param request
     */
    protected abstract void handler(AbstractRequest request);
}
