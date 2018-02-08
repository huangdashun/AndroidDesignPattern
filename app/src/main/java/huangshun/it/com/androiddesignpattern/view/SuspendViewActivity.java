package huangshun.it.com.androiddesignpattern.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.R;

/**
 * 悬浮view
 */
public class SuspendViewActivity extends AppCompatActivity {


    @BindView(R.id.divider_recycleview)
    RecyclerView mDividerRecycleview;

    List<String> data;
    @BindView(R.id.add)
    Button mAdd;
    @BindView(R.id.delete)
    Button mDelete;
    @BindView(R.id.move)
    Button mMove;
    @BindView(R.id.addmore)
    Button mAddmore;
    private DivideAdapter mDivideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend_view);
        ButterKnife.bind(this);
        initDatas();
        mDivideAdapter = new DivideAdapter(data);
        mDividerRecycleview.setAdapter(mDivideAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDividerRecycleview.setLayoutManager(linearLayoutManager);
//        mDividerRecycleview.addItemDecoration(new TimeLineDecoration(this));
//        mDividerRecycleview.addItemDecoration(new DividerItemDecoration());
        ((SimpleItemAnimator) mDividerRecycleview.getItemAnimator()).setSupportsChangeAnimations(false);
        RecyclerView.ItemAnimator itemAnimator = mDividerRecycleview.getItemAnimator();
        itemAnimator.setChangeDuration(0);
        itemAnimator.setMoveDuration(0);
        itemAnimator.setRemoveDuration(0);
        itemAnimator.setAddDuration(0);
        mDividerRecycleview.addItemDecoration(new HeaderDecoration(this, new HeaderDecoration.GroupInfoCallback() {
            @Override
            public GroupInfo getGroupInfo(int position) {
                int groupId = position / 5;
                int index = position % 5;
                GroupInfo groupInfo = new GroupInfo(groupId, groupId + "");
                groupInfo.setPosition(index);
                groupInfo.setGourpLength(5);
                return groupInfo;
            }
        }));
        mDividerRecycleview.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

    @OnClick({R.id.add, R.id.delete, R.id.move, R.id.addmore})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                data.add("我是新增的");
                mDivideAdapter.notifyItemInserted(0);
                break;
            case R.id.delete:
                mDivideAdapter.notifyItemRemoved(0);
                break;
            case R.id.move:
                mDivideAdapter.notifyItemMoved(1, 2);
                break;
            case R.id.addmore:
                data.add(0, "我是新增的1");
                data.add(0, "我是新增的2");
                data.add(0, "我是新增的3");
                data.add(0, "我是新增的4");
                mDivideAdapter.notifyItemRangeInserted(0, 4);
                break;
            default:
                break;
        }
    }

    private void initDatas() {
        data = new ArrayList<>();
        for (int i = 0; i < 56; i++) {
            data.add("test" + i);
        }
    }
}
