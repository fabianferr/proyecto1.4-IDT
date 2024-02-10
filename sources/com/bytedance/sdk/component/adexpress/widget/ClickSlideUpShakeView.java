package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicHandShake;

public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView a;

    public ClickSlideUpShakeView(Context context, int i, int i2, int i3) {
        super(context);
        a(context, i, i2, i3);
    }

    private void a(Context context, int i, int i2, int i3) {
        ShakeClickView shakeClickView = new ShakeClickView(context, new TTDynamicHandShake(context), i, i2, i3);
        this.a = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.a.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.a;
    }

    public void setShakeText(String str) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str)) {
                this.a.setShakeText("");
            } else {
                this.a.setShakeText(str);
            }
        }
    }
}
