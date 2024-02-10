package com.appnext.ads.fullscreen;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public final class a extends Animation {
    private Circle d;
    private float e;
    private float f;

    public a(Circle circle, float f2) {
        setInterpolator(new LinearInterpolator());
        this.e = circle.getAngle();
        this.f = f2;
        this.d = circle;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        try {
            float f3 = this.e;
            this.d.setAngle(f3 - ((f3 - this.f) * f2));
            this.d.invalidate();
            this.d.requestLayout();
        } catch (Throwable th) {
            com.appnext.base.a.a("CircleAngleAnimation$applyTransformation", th);
        }
    }
}
