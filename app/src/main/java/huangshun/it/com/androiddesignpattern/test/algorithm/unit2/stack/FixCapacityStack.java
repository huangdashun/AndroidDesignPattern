package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.stack;

/**
 * Created by hs on 2017/12/11.
 */

public class FixCapacityStack<Item> {
    private int N;//size
    private Item[] mDataS;
    private int Max = 100;//最大值

    public FixCapacityStack(int cap) {
        mDataS = (Item[]) new Object[cap];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == Max) {//已经达到了最大值
            throw new RuntimeException("已经达到了最大值");
        }
        //先元素压入栈顶
        if (N == mDataS.length) {//说明空间没了，需要扩展数组
            resize(mDataS.length * 2);
        }
        mDataS[N++] = item;
    }

    public Item pop() {
        //从栈顶删除元素
        String item = (String) mDataS[--N];
        mDataS[N] = null;//避免对象游离，保存一个不需要的对象的引用称为游离
        if (N > 0 && N == mDataS.length / 4) {
            resize(mDataS.length / 2);
        }
        return (Item) item;
    }

    /**
     * 增加数组的存储空间
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < N; i++) {
            temp[i] = mDataS[i];
        }
        mDataS = temp;
    }

}
