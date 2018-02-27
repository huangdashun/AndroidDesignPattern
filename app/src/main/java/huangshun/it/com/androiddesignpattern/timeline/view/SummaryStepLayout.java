package huangshun.it.com.androiddesignpattern.timeline.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by hs on 2018/2/26.
 * TimeLine步数摘要
 */

public class SummaryStepLayout extends FrameLayout {
    public SummaryStepLayout(@NonNull Context context) {
        this(context, null);
    }

    public SummaryStepLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SummaryStepLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
