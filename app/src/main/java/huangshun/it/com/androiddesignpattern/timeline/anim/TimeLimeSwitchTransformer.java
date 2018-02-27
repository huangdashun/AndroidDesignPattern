package huangshun.it.com.androiddesignpattern.timeline.anim;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by hs on 2018/2/26.
 */

public class TimeLimeSwitchTransformer implements ViewPager.PageTransformer {
    private static final String TAG = "TimeLimeSwitchTransformer";
    private float mMaxRotation = 90.0f;

    @Override
    public void transformPage(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
//            ViewCompat.setPivotX(view, view.getMeasuredWidth());
//            ViewCompat.setPivotY(view, view.getMeasuredHeight() * 0.5f);
//            ViewCompat.setRotationY(view, 0);
        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setPivotX(0);
            view.setPivotY(view.getMeasuredHeight() * 0.5f);
            view.setRotationY(-mMaxRotation * position);
            view.setTranslationX(0);
            view.setAlpha(1 + position);
        } else if (position <= 1) { // (0,1]
            float angel = -((45 * (position))) / 2;
            view.setPivotX(view.getMeasuredWidth());
            view.setPivotY(view.getMeasuredHeight() * 0.5f);
            view.setRotationY(angel);
            view.setTranslationX(-view.getMeasuredWidth() * position);
            view.setAlpha(1 - position);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            ViewCompat.setPivotX(view, view.getMeasuredWidth());
//            ViewCompat.setPivotY(view, view.getMeasuredHeight() * 0.5f);
//            ViewCompat.setRotationY(view, -mMaxRotation);
        }
    }
}
