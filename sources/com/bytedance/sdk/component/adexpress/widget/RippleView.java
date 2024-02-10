package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class RippleView extends View {
    private float a;
    private float b;
    private ValueAnimator c;
    private ValueAnimator d;
    private Paint e;
    private long f = 300;
    /* access modifiers changed from: private */
    public float g = 0.0f;
    private float h;
    private Animator.AnimatorListener i;
    private int j;

    public RippleView(Context context, int i2) {
        super(context);
        this.j = i2;
        a();
    }

    public void a() {
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setColor(this.j);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = ((float) i2) / 2.0f;
        this.b = ((float) i3) / 2.0f;
        this.h = (float) (Math.hypot((double) i2, (double) i3) / 2.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.a, this.b, this.g, this.e);
    }

    public void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.h});
        this.c = ofFloat;
        ofFloat.setDuration(this.f);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = RippleView.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.c.start();
    }

    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.h, 0.0f});
        this.d = ofFloat;
        ofFloat.setDuration(this.f);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = RippleView.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.i;
        if (animatorListener != null) {
            this.d.addListener(animatorListener);
        }
        this.d.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.i = animatorListener;
    }
}
