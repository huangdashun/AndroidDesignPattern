package huangshun.it.com.androiddesignpattern.unit8_7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import huangshun.it.com.androiddesignpattern.R;

public class ZhuangTaiActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mTransmit;//转发
    private Button mComment;//评论
    private Button mLogout;//注销

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuang_tai);
        initView();
        initListener();
    }


    private void initView() {
        mTransmit = (Button) findViewById(R.id.btn_transmit);
        mLogout = (Button) findViewById(R.id.btn_logout);
        mComment = (Button) findViewById(R.id.btn_comment);
    }

    private void initListener() {
        mTransmit.setOnClickListener(this);
        mLogout.setOnClickListener(this);
        mComment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_transmit:
                LoginContext.getLoginContext().foward(ZhuangTaiActivity.this);
                break;
            case R.id.btn_comment:
                LoginContext.getLoginContext().comment(this);
                break;
            case R.id.btn_logout:
                LoginContext.getLoginContext().setUserState(new LogoutState());
                break;
        }
    }
}
