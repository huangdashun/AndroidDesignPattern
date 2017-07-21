package huangshun.it.com.androiddesignpattern.unit14_1;

/**
 * Created by hs on 2017/7/21.
 * 容器接口
 * 容器接口负责提供创建具体迭代器角色的接口
 */

public interface Aggregate<T> {
    void add(T t);

    void remove(T t);

    Iterator<T> iterator();

}
