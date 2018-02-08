package huangshun.it.com.androiddesignpattern.view.myexpandable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.view.expandble.Group;
import huangshun.it.com.androiddesignpattern.view.expandble.People;

public class MyPinnedActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    private static final String TAG = "MyPinnedActivity";
    @BindView(R.id.my_pinned_view)
    PinnedHeaderExpandableListView mMyPinnedView;
    @BindView(R.id.imageView1)
    ImageView mImageView1;
    @BindView(R.id.sticky_header)
    LinearLayout mStickyHeader;
    @BindView(R.id.sticky_content)
    LinearLayout mStickyContent;
    @BindView(R.id.sticky_layout)
    MyStickyLayout mStickyLayout;
    private List<Group> mGroupList = new ArrayList<>();
    private List<List<People>> mChildList = new ArrayList<>();
    private MyExpandableAdapter mMyExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pinned);
        ButterKnife.bind(this);
        initData();
        initAdapter();
        initListener();
    }

    private void initListener() {
        mMyPinnedView.setOnChildClickListener(this);
        mMyPinnedView.setOnGroupClickListener(this);
        //设置接口回调
        mMyPinnedView.setOnHeaderUpdateListener(new PinnedHeaderExpandableListView.OnHeaderUpdateListener() {
            @Override
            public View getPinnedHeader() {
                View headerView = getLayoutInflater().inflate(R.layout.group, null);
                headerView.setLayoutParams(new AbsListView.LayoutParams(
                        AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
                return headerView;
            }

            @Override
            public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
                Group firstVisibleGroup = (Group) mMyExpandableAdapter.getGroup(firstVisibleGroupPos);
                TextView textView = (TextView) headerView.findViewById(R.id.group);
                textView.setText(firstVisibleGroup.getTitle());

            }
        });
        mStickyLayout.setOnGiveUpTouchEventListener(new MyStickyLayout.OnGiveUpTouchEventListener() {
            @Override
            public boolean intercept(MotionEvent event) {
                //是否拦截
                if (mMyPinnedView.getFirstVisiblePosition() == 0) {
                    View childView = mMyPinnedView.getChildAt(0);
                    if (childView != null && childView.getTop() >= 0) {//拦截
                        Log.i(TAG, "外层拦截");
                        return true;
                    }
                }
                Log.i(TAG, "外层不拦截，内层拦截");
                return false;
            }
        });

    }

    private void initAdapter() {
        mMyExpandableAdapter = new MyExpandableAdapter(this, mGroupList, mChildList);
        mMyPinnedView.setAdapter(mMyExpandableAdapter);
        // 展开所有group
        for (int i = 0, count = mMyPinnedView.getCount(); i < count; i++) {
            mMyPinnedView.expandGroup(i);
        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //设置组数据
        for (int i = 0; i < 3; i++) {
            Group group = new Group();
            group.setTitle("group-" + i);
            mGroupList.add(group);
        }
        //设置组内孩子数据
        for (int i = 0; i < mGroupList.size(); i++) {
            ArrayList<People> childTemp;
            if (i == 0) {
                childTemp = new ArrayList<People>();
                for (int j = 0; j < 13; j++) {
                    People people = new People();
                    people.setName("yy-" + j);
                    people.setAge(30);
                    people.setAddress("sh-" + j);

                    childTemp.add(people);
                }
            } else if (i == 1) {
                childTemp = new ArrayList<People>();
                for (int j = 0; j < 8; j++) {
                    People people = new People();
                    people.setName("ff-" + j);
                    people.setAge(40);
                    people.setAddress("sh-" + j);

                    childTemp.add(people);
                }
            } else {
                childTemp = new ArrayList<People>();
                for (int j = 0; j < 23; j++) {
                    People people = new People();
                    people.setName("hh-" + j);
                    people.setAge(20);
                    people.setAddress("sh-" + j);

                    childTemp.add(people);
                }
            }
            mChildList.add(childTemp);
        }
    }

    /**
     * child点击事件
     *
     * @param parent
     * @param v
     * @param groupPosition
     * @param childPosition
     * @param id
     * @return
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//        Toast.makeText(this,
//                mChildList.get(groupPosition).get(childPosition).getName(), Toast.LENGTH_SHORT)
//                .show();

        return true;
    }

    /**
     * group点击事件
     *
     * @param parent
     * @param v
     * @param groupPosition
     * @param id
     * @return
     */
    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//        Toast.makeText(this,
//                mGroupList.get(groupPosition).getTitle(), Toast.LENGTH_SHORT)
//                .show();
        return false;
    }
}
