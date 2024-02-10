package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView {
    public AppLovinVideoView(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public void setVideoSize(int i, int i2) {
        getHolder().setFixedSize(i, i2);
        requestLayout();
        invalidate();
    }
}
