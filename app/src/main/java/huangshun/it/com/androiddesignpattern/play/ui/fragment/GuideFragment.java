package huangshun.it.com.androiddesignpattern.play.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2017/8/19.
 */

public class GuideFragment extends Fragment {

    @BindView(R.id.imgView)
    ImageView mImgView;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.rootView)
    LinearLayout mRootView;

    private static final String IMG_RES = "IMG";
    private static final String BG_RES = "BG";
    private static final String TEXT_RES = "TEXT";

    public static GuideFragment newInstance(int imgResId, int bgColorResId, int textResId) {
        GuideFragment guideFragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IMG_RES, imgResId);
        bundle.putInt(BG_RES, bgColorResId);
        bundle.putInt(TEXT_RES, textResId);
        guideFragment.setArguments(bundle);

        return guideFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();

        mImgView.setImageResource(arguments.getInt(IMG_RES));
        mRootView.setBackgroundColor(ContextCompat.getColor(getActivity(), arguments.getInt(BG_RES)));
        mText.setText(getResources().getString(arguments.getInt(TEXT_RES)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
