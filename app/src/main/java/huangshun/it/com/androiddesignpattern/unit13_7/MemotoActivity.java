package huangshun.it.com.androiddesignpattern.unit13_7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import huangshun.it.com.androiddesignpattern.R;

public class MemotoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mUndo;
    private Button mSave;
    private Button mRedo;
    private MemEditText mMemotoEditText;

    private NoteCaretaker mNoteCaretaker = new NoteCaretaker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoto);
        initView();
        initListener();
    }

    private void initListener() {
        mUndo.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mRedo.setOnClickListener(this);
    }

    private void initView() {
        mUndo = (Button) findViewById(R.id.btn_undo);
        mSave = (Button) findViewById(R.id.btn_save);
        mRedo = (Button) findViewById(R.id.btn_redo);
        mMemotoEditText = (MemEditText) findViewById(R.id.et_content);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_undo:
                mMemotoEditText.restore(mNoteCaretaker.getPrevMemoto());
                Toast.makeText(getApplicationContext(), "撤销", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_save:
                mNoteCaretaker.saveMemoto(mMemotoEditText.createMemoto());
                Toast.makeText(getApplicationContext(), "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_redo:
                Memoto nextMemoto = mNoteCaretaker.getNextMemoto();
                mMemotoEditText.restore(nextMemoto);
                Toast.makeText(getApplicationContext(), "重做", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
