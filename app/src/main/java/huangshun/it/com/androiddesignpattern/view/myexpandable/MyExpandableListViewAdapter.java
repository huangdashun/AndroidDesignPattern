package huangshun.it.com.androiddesignpattern.view.myexpandable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2018/2/6.
 */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Map<String, List<String>> mDatas;

    private List<String> mParentList;//父项
    private Context mContext;

    public MyExpandableListViewAdapter(Context context, Map<String, List<String>> datas, List<String> parentList) {
        mContext = context;
        mDatas = datas;
        mParentList = parentList;
    }

    /**
     * 获取父项的数据
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        if (mDatas != null) {
            return mDatas.size();
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
        if (mDatas != null) {
            return mDatas.get(mParentList.get(groupPosition)).size();
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
        return mDatas.get(mParentList.get(groupPosition));
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
        return mDatas.get(mParentList.get(groupPosition)).get(childPosition);
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
        return 0;
    }

    /**
     * 是否具有稳定的id
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return false;
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
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_parent_view, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.parent_title);
        text.setText(mParentList.get(groupPosition));
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
        if (convertView == null) {

            convertView = View.inflate(mContext, R.layout.item_child_view, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.child_title);
        text.setText(mDatas.get(mParentList.get(groupPosition)).get(childPosition));
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "点到了内置的textview", Toast.LENGTH_SHORT).show();
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
        return false;
    }
}
