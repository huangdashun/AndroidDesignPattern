package huangshun.it.com.androiddesignpattern.unit14_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/21.
 */

public class ConcreateIterator<T> implements Iterator {
    private List<T> mList = new ArrayList<>();
    private int cursor = 0;

    public ConcreateIterator(List<T> list) {
        mList = list;
    }

    @Override
    public boolean hasNext() {
        return (mList != null) && (mList.size() != cursor);
    }

    @Override
    public T next() {
        if (hasNext()) {
            return mList.get(cursor++);
        }
        return null;
    }
}
