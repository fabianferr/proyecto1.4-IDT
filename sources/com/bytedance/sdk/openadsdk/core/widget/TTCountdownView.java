package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;

public class TTCountdownView extends View {
    public static final String a = s.a(o.a(), "tt_count_down_view");
    private float b;
    private float c;
    private int d;
    private float e;
    private float f;
    private final String g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    private RectF n;
    private a o;
    private AnimatorSet p;
    private ValueAnimator q;
    private ValueAnimator r;
    private ValueAnimator s;

    public interface a {
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i2) {
        return ((float) i2) * f2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            size = b();
        }
        if (mode2 != 1073741824) {
            size2 = b();
        }
        setMeasuredDimension(size, size2);
    }

    private int b() {
        return (int) ((((this.b / 2.0f) + this.c) * 2.0f) + ((float) ad.b(getContext(), 4.0f)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f);
        b(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
        String str = a;
        String str2 = this.g;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.k);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        canvas.save();
        float a2 = a(this.l, 360);
        float f2 = (float) this.d;
        canvas.drawCircle(0.0f, 0.0f, this.c, this.i);
        canvas.drawCircle(0.0f, 0.0f, this.c, this.j);
        canvas.drawArc(this.n, f2, a2, false, this.h);
        canvas.restore();
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.q = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.m, 0.0f});
        this.q = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.q.setDuration((long) (a(this.m, this.f) * 1000.0f));
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = TTCountdownView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.q;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.l, 0.0f});
        this.r = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.r.setDuration((long) (a(this.l, this.e) * 1000.0f));
        this.r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = TTCountdownView.this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.r;
    }

    public void a() {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.p = null;
        }
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        ValueAnimator valueAnimator2 = this.q;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.q = null;
        }
        ValueAnimator valueAnimator3 = this.r;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.r = null;
        }
        this.l = 1.0f;
        this.m = 1.0f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    public void setCountDownTime(int i2) {
        float f2 = (float) i2;
        this.f = f2;
        this.e = f2;
        a();
    }

    public a getCountdownListener() {
        return this.o;
    }

    public void setCountdownListener(a aVar) {
        this.o = aVar;
    }
}
