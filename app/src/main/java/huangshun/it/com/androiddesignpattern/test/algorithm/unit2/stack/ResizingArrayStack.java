package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.stack;

import android.support.annotation.NonNull;

import java.util.Iterator;

/**
 * Created by hs on 2017/12/13.
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0;//元素数量

    public Boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == a.length) {//需要扩容
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    private void resize(int capcity) {
        Item[] temp = (Item[]) new Object[capcity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;

    }

    public Item pop() {
        if (N != 0) {
            Item item = a[--N];
            a[N] = null;//避免对象游离
            if (N > 0 && N == a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }
        return null;

    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator<>(a, N);
    }
}
