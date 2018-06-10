package huangshun.it.com.androiddesignpattern.Dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 18/6/10.
 */
public class CenterDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_center, container, false);
        return view;
    }
}
