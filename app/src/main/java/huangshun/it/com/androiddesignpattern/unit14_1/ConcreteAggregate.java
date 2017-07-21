package huangshun.it.com.androiddesignpattern.unit14_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/21.
 */

public class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> mList = new ArrayList<>();

    @Override
    public void add(T t) {
        mList.add(t);
    }

    @Override
    public void remove(T t) {
        mList.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreateIterator<>(mList);
    }
}
