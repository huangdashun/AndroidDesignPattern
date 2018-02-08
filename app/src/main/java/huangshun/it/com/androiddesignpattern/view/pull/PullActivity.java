package huangshun.it.com.androiddesignpattern.view.pull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

public class PullActivity extends AppCompatActivity {

    private static final String TAG = "PullActivity";
    @BindView(R.id.expandable_view)
    ExpandableListView mExpandableView;
    //    @BindView(R.id.iv_bg)
//    ImageView mIvBg;
//    @BindView(R.id.my_click)
//    Button mMyClick;
//    @BindView(R.id.my_transView)
//    TransView mMyTransView;
//    @BindView(R.id.ll_content)
//    LinearLayout mLlContent;
//    @BindView(R.id.button_one)
//    Button mButtonOne;
    private Map<String, List<String>> dataset = new HashMap<>();
    private List<String> parentList = new ArrayList<>();
    private List<String> childrenList1 = new ArrayList<>();
    private List<String> childrenList2 = new ArrayList<>();
    private List<String> childrenList3 = new ArrayList<>();
//    private MyExpandableListViewAdapter mMyExpandableListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        initData();
        initAdapter();
    }

    private void initAdapter() {
//        mMyExpandableListViewAdapter = new MyExpandableListViewAdapter(this, dataset, parentList);
//        mExpandableView.setAdapter(mMyExpandableListViewAdapter);

    }

    private void initData() {
        parentList.add("first");
        parentList.add("second");
        parentList.add("third");
        childrenList1.add(parentList.get(0) + "-" + "first");
        childrenList1.add(parentList.get(0) + "-" + "second");
        childrenList1.add(parentList.get(0) + "-" + "third");
        childrenList2.add(parentList.get(1) + "-" + "first");
        childrenList2.add(parentList.get(1) + "-" + "second");
        childrenList2.add(parentList.get(1) + "-" + "third");
        childrenList3.add(parentList.get(2) + "-" + "first");
        childrenList3.add(parentList.get(2) + "-" + "second");
        childrenList3.add(parentList.get(2) + "-" + "third");
        dataset.put(parentList.get(0), childrenList1);
        dataset.put(parentList.get(1), childrenList2);
        dataset.put(parentList.get(2), childrenList3);
    }

}
