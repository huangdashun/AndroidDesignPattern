package huangshun.it.com.androiddesignpattern.view.myexpandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.view.expandble.Group;
import huangshun.it.com.androiddesignpattern.view.expandble.People;

/**
 * Created by hs on 2018/2/6.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    private List<Group> mGroupList;
    private List<List<People>> mChildList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyExpandableAdapter(Context context, List<Group> groupList, List<List<People>> childList) {
        mContext = context;
        mGroupList = groupList;
        mChildList = childList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 获取父项的数据
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        if (mGroupList != null) {
            return mGroupList.size();
        } else {
            return 0;
        }

    }

    /**
     * 获取某个父项的子项数据
     *
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        if (mChildList != null) {
            return mChildList.get(groupPosition).size();
        }
        return 0;
    }

    /**
     * 获取某个父项的列表
     *
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    /**
     * 获取某个孩子
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildList.get(groupPosition).get(childPosition);
    }

    /**
     * 获取某个父项的id
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取某个父项的某个子项的id
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * 是否具有稳定的id
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 获得父项显示的view
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            groupHolder = new GroupHolder();
            convertView = mLayoutInflater.inflate(R.layout.group, null);
            groupHolder.textView = (TextView) convertView
                    .findViewById(R.id.group);
            groupHolder.imageView = (ImageView) convertView
                    .findViewById(R.id.image);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }

        groupHolder.textView.setText(((Group) getGroup(groupPosition))
                .getTitle());
        if (isExpanded)// ture is Expanded or false is not isExpanded
            groupHolder.imageView.setImageResource(R.drawable.expanded);
        else
            groupHolder.imageView.setImageResource(R.drawable.collapse);
        return convertView;
    }

    /**
     * 获得子项显示的view
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            childHolder = new ChildHolder();
            convertView = mLayoutInflater.inflate(R.layout.child, null);

            childHolder.textName = (TextView) convertView
                    .findViewById(R.id.name);
            childHolder.textAge = (TextView) convertView
                    .findViewById(R.id.age);
            childHolder.textAddress = (TextView) convertView
                    .findViewById(R.id.address);
            childHolder.imageView = (ImageView) convertView
                    .findViewById(R.id.image);
            childHolder.button =
                    (Button) convertView
                            .findViewById(R.id.button1);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        childHolder.textName.setText(((People) getChild(groupPosition,
                childPosition)).getName());
        childHolder.textAge.setText(String.valueOf(((People) getChild(
                groupPosition, childPosition)).getAge()));
        childHolder.textAddress.setText(((People) getChild(groupPosition,
                childPosition)).getAddress());
        childHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "groupPosition:" + groupPosition + "childPosition：" + childPosition, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    /**
     * 设置子项是否可选中，如果需要设置子项的点击事件，需要返回true
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder {
        TextView textView;
        ImageView imageView;
    }

    class ChildHolder {
        TextView textName;
        TextView textAge;
        TextView textAddress;
        ImageView imageView;
        Button button;
    }
}
