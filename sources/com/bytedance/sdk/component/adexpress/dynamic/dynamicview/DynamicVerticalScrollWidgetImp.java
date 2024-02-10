package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements e {
    ObjectAnimator a;
    ObjectAnimator b;
    private int t = 0;
    private boolean u = false;
    private Runnable v = new Runnable() {
        public void run() {
            DynamicVerticalScrollWidgetImp.this.a();
        }
    };

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r11 = this;
            int r0 = r11.t
            android.view.View r0 = r11.getChildAt(r0)
            int r1 = r11.t
            r2 = 0
            if (r1 != 0) goto L_0x000d
            r11.u = r2
        L_0x000d:
            r3 = 1
            int r1 = r1 + r3
            int r4 = r11.getChildCount()
            if (r1 >= r4) goto L_0x002a
            int r1 = r11.t
            int r1 = r1 + r3
            android.view.View r1 = r11.getChildAt(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r4 = r1
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            int r1 = r1.getChildCount()
            if (r1 > 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = 0
            goto L_0x002b
        L_0x002a:
            r1 = 1
        L_0x002b:
            com.bytedance.sdk.component.adexpress.dynamic.b.h r4 = r11.m
            com.bytedance.sdk.component.adexpress.dynamic.b.e r4 = r4.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r4 = r4.e()
            boolean r4 = r4.a()
            r5 = 0
            java.lang.String r6 = "translationY"
            r7 = 2
            if (r4 != 0) goto L_0x0066
            if (r1 == 0) goto L_0x0066
            r11.u = r3
            int r1 = r11.t
            int r1 = r1 - r3
            android.view.View r1 = r11.getChildAt(r1)
            float[] r4 = new float[r7]
            r4[r2] = r5
            int r8 = r11.h
            int r9 = r11.t
            android.view.View r9 = r11.getChildAt(r9)
            int r9 = r9.getHeight()
            int r8 = r8 + r9
            int r8 = r8 / r7
            float r8 = (float) r8
            r4[r3] = r8
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r0, r6, r4)
            r11.a = r4
            goto L_0x00a5
        L_0x0066:
            if (r1 == 0) goto L_0x0075
            int r4 = r11.t
            int r4 = r4 + r7
            int r8 = r11.getChildCount()
            int r4 = r4 % r8
            android.view.View r4 = r11.getChildAt(r4)
            goto L_0x0081
        L_0x0075:
            int r4 = r11.t
            int r4 = r4 + r3
            int r8 = r11.getChildCount()
            int r4 = r4 % r8
            android.view.View r4 = r11.getChildAt(r4)
        L_0x0081:
            float[] r8 = new float[r7]
            r8[r2] = r5
            int r9 = r11.h
            int r10 = r11.t
            android.view.View r10 = r11.getChildAt(r10)
            int r10 = r10.getHeight()
            int r9 = r9 + r10
            int r9 = -r9
            int r9 = r9 / r7
            float r9 = (float) r9
            r8[r3] = r9
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r0, r6, r8)
            r11.a = r8
            if (r1 == 0) goto L_0x00a4
            int r1 = r11.t
            int r1 = r1 + r3
            r11.t = r1
        L_0x00a4:
            r1 = r4
        L_0x00a5:
            android.animation.ObjectAnimator r4 = r11.a
            android.view.animation.LinearInterpolator r8 = new android.view.animation.LinearInterpolator
            r8.<init>()
            r4.setInterpolator(r8)
            android.animation.ObjectAnimator r4 = r11.a
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp$2 r8 = new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp$2
            r8.<init>(r0)
            r4.addListener(r8)
            boolean r0 = r11.u
            if (r0 == 0) goto L_0x00d4
            float[] r0 = new float[r7]
            int r4 = r11.h
            int r8 = r1.getHeight()
            int r4 = r4 + r8
            int r4 = -r4
            int r4 = r4 / r7
            float r4 = (float) r4
            r0[r2] = r4
            r0[r3] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r1, r6, r0)
            r11.b = r0
            goto L_0x00e9
        L_0x00d4:
            float[] r0 = new float[r7]
            int r4 = r11.h
            int r8 = r1.getHeight()
            int r4 = r4 + r8
            int r4 = r4 / r7
            float r4 = (float) r4
            r0[r2] = r4
            r0[r3] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r1, r6, r0)
            r11.b = r0
        L_0x00e9:
            android.animation.ObjectAnimator r0 = r11.b
            android.view.animation.LinearInterpolator r2 = new android.view.animation.LinearInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            android.animation.ObjectAnimator r0 = r11.b
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp$3 r2 = new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp$3
            r2.<init>(r1)
            r0.addListener(r2)
            android.animation.ObjectAnimator r0 = r11.a
            r1 = 500(0x1f4, double:2.47E-321)
            r0.setDuration(r1)
            android.animation.ObjectAnimator r0 = r11.b
            r0.setDuration(r1)
            android.animation.ObjectAnimator r0 = r11.a
            r0.start()
            android.animation.ObjectAnimator r0 = r11.b
            r0.start()
            boolean r0 = r11.u
            if (r0 == 0) goto L_0x011d
            int r0 = r11.t
            int r0 = r0 - r3
            r11.t = r0
            goto L_0x0129
        L_0x011d:
            int r0 = r11.t
            int r0 = r0 + r3
            r11.t = r0
            int r1 = r11.getChildCount()
            int r0 = r0 % r1
            r11.t = r0
        L_0x0129:
            java.lang.Runnable r0 = r11.v
            r1 = 3000(0xbb8, double:1.482E-320)
            r11.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.a():void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.h - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.v, 2500);
    }

    public void b() {
        removeCallbacks(this.v);
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.a.cancel();
        }
        ObjectAnimator objectAnimator2 = this.b;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.b.cancel();
        }
        super.b();
    }
}
