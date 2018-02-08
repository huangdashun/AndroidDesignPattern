package huangshun.it.com.androiddesignpattern.view;

/**
 * Created by hs on 2018/1/10.
 */

public class GroupInfo {
    private int mGroupID;//组号
    private String mTitle;//Header的title;
    private int mPosition;//ItemView在组内的位置
    private int mGourpLength;//组的成员个数

    public GroupInfo(int groupID, String title) {
        mGroupID = groupID;
        mTitle = title;
    }

    public boolean isFirstViewInGroup() {
        return mPosition == 0;
    }

    public boolean isLastViewInGroup() {
        return mPosition == mGourpLength - 1 && mPosition >= 0;
    }

    public int getGroupID() {
        return mGroupID;
    }

    public void setGroupID(int groupID) {
        mGroupID = groupID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }

    public int getGourpLength() {
        return mGourpLength;
    }

    public void setGourpLength(int gourpLength) {
        mGourpLength = gourpLength;
    }

    @Override
    public String toString() {
        return "GroupInfo{" +
                "mGroupID=" + mGroupID +
                ", mTitle='" + mTitle + '\'' +
                ", mPosition=" + mPosition +
                ", mGourpLength=" + mGourpLength +
                '}';
    }
}
