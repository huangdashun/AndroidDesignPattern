package huangshun.it.com.androiddesignpattern.play.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.ui.adapter.GuideFragmentAdapter;
import huangshun.it.com.androiddesignpattern.play.ui.fragment.GuideFragment;

public class PlayGuideActivity extends AppCompatActivity {
    private static final String TAG = "PlayGuideActivity";
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.btn_enter)
    Button mBtnEnter;
    @BindView(R.id.ll_indicator)
    LinearLayout mLlIndicator;
    @BindView(R.id.activity_guide)
    RelativeLayout mActivityGuide;
    @BindView(R.id.img_1)
    ImageView mImg1;
    @BindView(R.id.img_2)
    ImageView mImg2;
    @BindView(R.id.img_3)
    ImageView mImg3;
    private GuideFragmentAdapter mGuideFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mImg1.setBackgroundColor(Color.RED);
                        mImg2.setBackgroundColor(Color.WHITE);
                        mImg3.setBackgroundColor(Color.WHITE);
                        mBtnEnter.setVisibility(View.GONE);
                        break;
                    case 1:
                        mImg1.setBackgroundColor(Color.WHITE);
                        mImg2.setBackgroundColor(Color.RED);
                        mImg3.setBackgroundColor(Color.WHITE);
                        mBtnEnter.setVisibility(View.GONE);
                        break;
                    case 2:
                        mImg1.setBackgroundColor(Color.WHITE);
                        mImg2.setBackgroundColor(Color.WHITE);
                        mImg3.setBackgroundColor(Color.RED);
                        mBtnEnter.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayGuideActivity.this, PlayMainActivity.class));
                finish();
            }
        });
    }

    private static final float MIN_SCALE = 0.75f;

    private void initData() {


        mGuideFragmentAdapter = new GuideFragmentAdapter(getSupportFragmentManager());
        List<Fragment> mListFragment = new ArrayList<>();

        mListFragment.add(GuideFragment.newInstance(R.drawable.guide_1, R.color.color_bg_guide1, R.string.guide_1));
        mListFragment.add(GuideFragment.newInstance(R.drawable.guide_2, R.color.color_bg_guide2, R.string.guide_2));
        mListFragment.add(GuideFragment.newInstance(R.drawable.guide_3, R.color.color_bg_guide3, R.string.guide_3));
        mGuideFragmentAdapter.setFragmentList(mListFragment);

        mViewpager.setCurrentItem(mGuideFragmentAdapter.getCount());
        mViewpager.setOffscreenPageLimit(mGuideFragmentAdapter.getCount());
        mViewpager.setAdapter(mGuideFragmentAdapter);

        mViewpager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
//                Log.d(TAG, "transformPage() called with " + "view = [" + view + "], position = [" + position + "]");
                int pageWidth = view.getWidth();
                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.setAlpha(0);
                } else if (position <= 0) { // [-1,0]
                    // Use the default slide transition when moving to the left page
                    view.setAlpha(1);
                    view.setTranslationX(0);
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else if (position <= 1) { // (0,1]
                    // Fade the page out.
                    view.setAlpha(1 - position);
                    // Counteract the default slide transition
                    view.setTranslationX(pageWidth * -position);
                    // Scale the page down (between MIN_SCALE and 1)
                    float scaleFactor = MIN_SCALE
                            + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.setAlpha(0);
                }
            }
        });

    }
}
