package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.queue;

/**
 * Created by hs on 2017/12/21.
 * 算法1.3.14
 */

public class ResizingArrayQueueOfStrings {
    private int size;//数组的大小
    private String[] datas = new String[1];

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (size > 0 && size == datas.length / 4) {
            resize(datas.length / 2);
        }
        String first = datas[0];
        for (int i = 0; i < size; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
        return first;
    }

    /**
     * 入队
     *
     * @param data
     */
    public void enqueue(String data) {
        if (size == datas.length) {//扩大数组容量
            resize(2 * size);
        }
        if (size < datas.length) {
            datas[size++] = data;
        }
    }

    /**
     * 扩容
     *
     * @param size
     */
    private void resize(int size) {
        String[] temp = new String[size];
        for (int i = 0; i < datas.length; i++) {
            temp[i] = datas[i];
        }
    }

    public int getSize() {
        return size;
    }
}

