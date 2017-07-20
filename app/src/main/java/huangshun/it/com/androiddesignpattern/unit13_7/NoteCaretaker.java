package huangshun.it.com.androiddesignpattern.unit13_7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/20.
 * 负责管理Memoto对象
 */

public class NoteCaretaker {
    //最大存储数量
    private static final int MAX = 30;
    List<Memoto> mMemotos = new ArrayList<Memoto>();//存储数据30条记录

    int mIndex = 0;

    /**
     * 保存备忘录到记录列表中
     *
     * @param memoto
     */
    public void saveMemoto(Memoto memoto) {
        if (mMemotos.size() > MAX) {
            mMemotos.remove(0);
        }
        mMemotos.add(memoto);
        mIndex = mMemotos.size() - 1;
    }

    /**
     * 获取上一个存档信息,相当于撤销功能
     */
    public Memoto getPrevMemoto() {
        if (mMemotos != null && mMemotos.size() > 0) {
            mIndex = mIndex > 0 ? --mIndex : mIndex;
            return mMemotos.get(mIndex);
        }
        return null;
    }

    //获取下一个存档信息,相当于重做功能
    public Memoto getNextMemoto() {
        mIndex = mIndex < mMemotos.size() - 1 ? ++mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

}
