package huangshun.it.com.androiddesignpattern.unit14_1;

/**
 * Created by hs on 2017/7/21.
 * 迭代器接口
 * 迭代器接口负责定义,访问和遍历元素的接口
 */

public interface Iterator<T> {
    boolean hasNext();

    T next();
}
