package huangshun.it.com.androiddesignpattern.unit13_7;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by hs on 2017/7/20.
 */

public class MemEditText extends EditText {
    public MemEditText(Context context) {
        this(context, null);
    }

    public MemEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MemEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.text = getText().toString();
        memoto.cursor = getSelectionStart();
        return memoto;
    }

    public void restore(Memoto memoto) {
        setText(memoto.text);
        setSelection(memoto.cursor);
    }

}
