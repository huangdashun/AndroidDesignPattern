package huangshun.it.com.androiddesignpattern.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.R;

public class EventActivity extends AppCompatActivity {

    @BindView(R.id.ll_one)
    LinearLayout mLlOne;
    @BindView(R.id.ll_two)
    LinearLayout mLlTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

//        findViewById(R.id.view2).setClickable(false);
    }

    @OnClick({R.id.ll_one, R.id.ll_two, R.id.view2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_one:
                Toast.makeText(getApplicationContext(), "one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_two:
                Toast.makeText(getApplicationContext(), "two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view2:
                Toast.makeText(getApplicationContext(), "view2", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //默认情况： 从ActivityA--->ViewGroup B--->View C 从上往下调用dispatchTouchEvent
    //在由View C -->ViewGroup B --> Activity A,从下往上调用onTouchEvent()


    //onInterceptTouchEvent方法，一旦返回true，就再也不会被调用了
}
