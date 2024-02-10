package com.startapp;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.startapp.sdk.ads.list3d.List3DView;

/* compiled from: Sta */
public class q4 implements Runnable {
    public final /* synthetic */ List3DView a;

    public q4(List3DView list3DView) {
        this.a = list3DView;
    }

    public void run() {
        float f;
        List3DView list3DView = this.a;
        if (list3DView.l != null) {
            boolean z = false;
            View childAt = list3DView.getChildAt(0);
            if (childAt != null) {
                List3DView list3DView2 = this.a;
                int d = list3DView2.d(childAt);
                List3DView list3DView3 = this.a;
                list3DView2.e = d - list3DView3.g;
                b2 b2Var = list3DView3.l;
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j = b2Var.e;
                if (j != 0) {
                    int i = (int) (currentAnimationTimeMillis - j);
                    if (i > 50) {
                        i = 50;
                    }
                    v7 v7Var = (v7) b2Var;
                    float f2 = v7Var.b;
                    float f3 = v7Var.a;
                    float f4 = v7Var.c;
                    if (f3 <= f4) {
                        f4 = v7Var.d;
                        if (f3 >= f4) {
                            f = 0.0f;
                            float f5 = (f * v7Var.g) + f2;
                            v7Var.b = f5;
                            v7Var.a = ((((float) i) * f5) / 1000.0f) + f3;
                            v7Var.b = f5 * v7Var.f;
                        }
                    }
                    f = f4 - f3;
                    float f52 = (f * v7Var.g) + f2;
                    v7Var.b = f52;
                    v7Var.a = ((((float) i) * f52) / 1000.0f) + f3;
                    v7Var.b = f52 * v7Var.f;
                }
                b2Var.e = currentAnimationTimeMillis;
                List3DView list3DView4 = this.a;
                list3DView4.a(((int) list3DView4.l.a) - list3DView4.e);
            }
            b2 b2Var2 = this.a.l;
            boolean z2 = Math.abs(b2Var2.b) < 0.5f;
            float f6 = b2Var2.a;
            boolean z3 = f6 - 0.4f < b2Var2.c && f6 + 0.4f > b2Var2.d;
            if (z2 && z3) {
                z = true;
            }
            if (!z) {
                this.a.postDelayed(this, 16);
            }
        }
    }
}
