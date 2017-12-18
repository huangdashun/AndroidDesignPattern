package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.stack;

import java.util.Iterator;

/**
 * Created by hs on 2017/12/11.
 */

public class ReverseArrayIterator<Item> implements Iterator<Item> {
    private int N;
    private Item[] mDatas;

    public ReverseArrayIterator(Item[] a, int N) {
        mDatas = a;
        this.N = N;
    }

    @Override
    public boolean hasNext() {
        return N != 0;
    }

    @Override
    public Item next() {
        return mDatas[--N];
    }
}
