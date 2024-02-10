package com.bytedance.sdk.openadsdk.component.f;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.component.h.a;

/* compiled from: TTAppOpenAdTopLayoutHelper */
public class b {
    /* access modifiers changed from: private */
    public final a a;
    private a b;
    /* access modifiers changed from: private */
    public int c = 0;
    private float d = 5.0f;
    private int e = 0;
    private ValueAnimator f;
    private boolean g;

    public b(a aVar) {
        this.a = aVar;
    }

    public void a() {
        int i = (int) (this.d * 1000.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i});
        this.f = ofInt;
        ofInt.setDuration((long) i);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.a.a((long) b.this.c);
                b.this.a(intValue);
            }
        });
    }

    public void a(int i) {
        this.c = i;
        float f2 = (((float) i) * 1.0f) / 1000.0f;
        int ceil = (int) Math.ceil((double) (this.d - f2));
        boolean z = true;
        if (ceil <= 0) {
            a aVar = this.b;
            if (aVar != null && !this.g) {
                aVar.b();
                this.g = true;
            }
            ceil = 0;
        }
        if (f2 < ((float) this.e)) {
            z = false;
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(ceil, i, z);
        }
    }

    public void a(float f2) {
        this.d = f2;
        if (f2 <= 0.0f) {
            this.d = 5.0f;
        }
        a();
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public ValueAnimator b() {
        return this.f;
    }

    public int c() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }
}
