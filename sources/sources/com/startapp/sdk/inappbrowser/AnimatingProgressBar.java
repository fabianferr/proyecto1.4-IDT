package com.startapp.sdk.inappbrowser;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

/* compiled from: Sta */
public class AnimatingProgressBar extends ProgressBar {
    public static final Interpolator c = new AccelerateDecelerateInterpolator();
    public ValueAnimator a;
    public boolean b;

    /* compiled from: Sta */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimatingProgressBar.super.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public AnimatingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.b = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setProgress(int i) {
        if (!this.b) {
            super.setProgress(i);
            return;
        }
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            if (getProgress() >= i) {
                return;
            }
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getProgress(), i});
            this.a = ofInt;
            ofInt.setInterpolator(c);
            this.a.addUpdateListener(new a());
        }
        this.a.setIntValues(new int[]{getProgress(), i});
        this.a.start();
    }

    public void a() {
        super.setProgress(0);
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
