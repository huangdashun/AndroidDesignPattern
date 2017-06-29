package huangshun.it.com.androiddesignpattern.unit8_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import huangshun.it.com.androiddesignpattern.R;

public class LoginActivity extends AppCompatActivity {
    private Button mBtnSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnSuccess = (Button) findViewById(R.id.btn_success);
        mBtnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginContext.getLoginContext().setUserState(new LoginedState());
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
