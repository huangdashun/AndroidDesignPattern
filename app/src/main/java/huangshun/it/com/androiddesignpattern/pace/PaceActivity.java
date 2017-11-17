package huangshun.it.com.androiddesignpattern.pace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;

public class PaceActivity extends AppCompatActivity {
//    private ProPaceChart mProPaceChart;
    private List<Long> paceTimeList = new ArrayList<>();
    private Long mAvg;
    private Long mMax;
    private Long mMin;
    private int mNoKmTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);
//        mProPaceChart = (ProPaceChart) findViewById(R.id.pace_chart);

        //initData();

        initData();

        initListener();
    }

    private void initListener() {
//        Button btn = (Button) findViewById(R.id.btn_click);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                paceTimeList = paceTimeList.subList(0, paceTimeList.size() - 1);
//                mProPaceChart.refreshView(paceTimeList, mAvg, mMax, mMin, mNoKmTime);
//            }
//        });
    }

    private void initData() {
        //绘制图表,需要:平均值,存放每公里配速的集合,最后不足一公里用时的时间
        //模拟每公里配速的集合
        paceTimeList.add((long) 8.12);
        paceTimeList.add((long) 5.12);
        paceTimeList.add((long) 8.12);
        paceTimeList.add((long) 13.12);
        paceTimeList.add((long) 2.12);
        paceTimeList.add((long) 4.12);
        paceTimeList.add((long) 5.12);
        paceTimeList.add((long) 6.12);
        paceTimeList.add((long) 3.12);
        //平均值
        mAvg = (long) 9.12;
        //最大值
        mMax = (long) 13.12;
        //最小值
        mMin = (long) 2.12;

        //时间
//        String nokmTime = "00:04:23";
        mNoKmTime = 1100;
//        mProPaceChart.refreshView(paceTimeList, mAvg, mMax, mMin, mNoKmTime);

    }
}
