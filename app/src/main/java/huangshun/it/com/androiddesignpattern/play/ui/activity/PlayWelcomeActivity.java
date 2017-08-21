package huangshun.it.com.androiddesignpattern.play.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

public class PlayWelcomeActivity extends AppCompatActivity {

    @BindView(R.id.pathView)
    PathView mPathView;
    @BindView(R.id.rl_content)
    RelativeLayout mRlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_welcome);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        mPathView.getPathAnimator()
                .delay(10)
                .duration(1000)
                .listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {

                    }
                })
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        startActivity(new Intent(PlayWelcomeActivity.this, PlayGuideActivity.class));
                        finish();
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

    }
}
