package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicHandShake;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;

public class ShakeClickView extends ShakeAnimationView {
    private TextView a;

    public ShakeClickView(Context context, View view, int i, int i2, int i3) {
        super(context, view, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view) {
        addView(view);
        if (view instanceof TTDynamicHandShake) {
            this.a = ((TTDynamicHandShake) view).getTvButText();
        }
    }

    public void setShakeText(String str) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str)) {
                try {
                    this.a.setText(s.b(this.a.getContext(), "tt_splash_default_click_shake"));
                } catch (Exception e) {
                    l.e("shakeClickView", e.getMessage());
                }
            } else {
                this.a.setText(str);
            }
        }
    }
}
