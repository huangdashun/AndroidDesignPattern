package huangshun.it.com.androiddesignpattern.Dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import huangshun.it.com.androiddesignpattern.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    public void onClick(View view) {
        CenterDialog centerDialog = new CenterDialog();
        centerDialog.show(getSupportFragmentManager(), "我是dialog");
    }
}
