package huangshun.it.com.androiddesignpattern.play.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2017/8/2.
 */

public class CategoryFragment extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Typeface fromAsset = Typeface.createFromAsset(getActivity().getAssets(), "iconfont.ttf");
        mTextView = (TextView) view.findViewById(R.id.yunshu);
        mTextView.setTypeface(fromAsset);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}

