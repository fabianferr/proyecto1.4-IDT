package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicClickSlideUp2;

public class ClickSlideUpView2 extends SlideUpView {
    private TextView a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private int e;
    private AnimatorSet f = new AnimatorSet();

    /* access modifiers changed from: protected */
    public void a(Context context) {
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        TTDynamicClickSlideUp2 tTDynamicClickSlideUp2 = new TTDynamicClickSlideUp2(context);
        addView(tTDynamicClickSlideUp2);
        this.b = tTDynamicClickSlideUp2.getIv1();
        this.c = tTDynamicClickSlideUp2.getIv2();
        this.d = tTDynamicClickSlideUp2.getIv3();
        this.a = tTDynamicClickSlideUp2.getTvButText();
    }

    public void setButtonText(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
    }

    private void d() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "alphaColor", new int[]{0, 60});
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(2000);
        ofInt.setRepeatCount(-1);
        ofInt.start();
    }

    public float getAlphaColor() {
        return (float) this.e;
    }

    public void setAlphaColor(int i) {
        if (i >= 0 && i <= 60) {
            int i2 = i + 195;
            this.d.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
            int i3 = ((i + 20) % 60) + 195;
            this.c.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
            int i4 = ((i + 40) % 60) + 195;
            this.b.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
        }
    }

    public void a() {
        d();
    }

    public void b() {
        this.f.cancel();
    }
}
