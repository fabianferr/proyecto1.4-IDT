package com.bytedance.sdk.openadsdk.core.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

public class PAGProgressBar extends FrameLayout {
    private int a = 100;
    private int b;
    private Drawable c;
    private Drawable d;
    private Drawable e;
    private boolean f;
    private ValueAnimator g;

    public void setProgress(int i) {
        this.b = i;
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setLevel((int) ((((float) i) * 10000.0f) / ((float) this.a)));
        }
    }

    public void setMax(int i) {
        this.a = i;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.d = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.d;
        if (drawable2 instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable2;
            LayerDrawable layerDrawable2 = layerDrawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                LayerDrawable layerDrawable3 = (LayerDrawable) this.d;
                LayerDrawable layerDrawable4 = layerDrawable3;
                Drawable drawable3 = layerDrawable3.getDrawable(i);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.c = drawable3;
                }
            }
        }
        Drawable drawable4 = this.d;
        if (drawable4 instanceof RotateDrawable) {
            this.c = drawable4;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.e = drawable;
        setProgressDrawable(drawable);
        if (this.f && this.g == null) {
            a();
        }
    }

    public PAGProgressBar(Context context) {
        super(context);
    }

    public PAGProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a.a(layoutParams);
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = true;
        if (this.e != null) {
            a();
        }
    }

    private void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 10000});
        this.g = ofInt;
        ofInt.setDuration(2000);
        this.g.setRepeatCount(-1);
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setRepeatMode(1);
        this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PAGProgressBar.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.g.start();
        setMax(10000);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = false;
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.g.removeAllUpdateListeners();
            this.g = null;
        }
    }
}
