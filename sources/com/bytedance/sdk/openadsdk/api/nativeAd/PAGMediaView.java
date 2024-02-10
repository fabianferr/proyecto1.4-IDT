package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class PAGMediaView extends FrameLayout {
    protected Integer a;

    public void close() {
    }

    public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
    }

    public PAGMediaView(Context context) {
        super(context);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMrcTrackerKey(Integer num) {
        this.a = num;
    }
}
