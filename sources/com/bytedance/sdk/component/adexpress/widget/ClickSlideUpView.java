package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicClickSlideUp;

public class ClickSlideUpView extends SlideUpView {
    private TextView a;
    private TTDynamicClickSlideUp b;
    private AnimatorSet c = new AnimatorSet();

    /* access modifiers changed from: protected */
    public void a(Context context) {
    }

    public ClickSlideUpView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.b = new TTDynamicClickSlideUp(context);
        setClipChildren(false);
        addView(this.b);
        this.a = this.b.getTvButText();
    }

    public void setButtonText(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
    }

    private void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.getBgContainer(), "translationY", new float[]{0.0f, e.a(getContext(), -3.0f)});
        ofFloat.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat.setDuration(1000);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b.getBgContainer(), "alpha", new float[]{1.0f, 0.8f});
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat2.setRepeatCount(-1);
        this.c.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.c.setDuration(1000);
        this.c.start();
    }

    public void setSlideText(String str) {
        if (this.b.getTvButText() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.b.getTvButText().setText("");
        } else {
            this.b.getTvButText().setText(str);
        }
    }

    public void a() {
        d();
    }

    public void b() {
        this.c.cancel();
    }
}
