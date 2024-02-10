package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements e {
    ObjectAnimator a;
    ObjectAnimator b;
    private int t = 0;
    private boolean u = false;
    private Runnable v = new Runnable() {
        public void run() {
            DynamicBaseInternalScrollWidgetImp.this.a();
        }
    };

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            int r0 = r10.t
            android.view.View r0 = r10.getChildAt(r0)
            int r1 = r10.t
            r2 = 0
            if (r1 != 0) goto L_0x000d
            r10.u = r2
        L_0x000d:
            r3 = 1
            int r1 = r1 + r3
            int r4 = r10.getChildCount()
            r5 = 0
            java.lang.String r6 = "translationX"
            r7 = 2
            if (r1 >= r4) goto L_0x0050
            int r1 = r10.t
            int r1 = r1 + r3
            android.view.View r1 = r10.getChildAt(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r4 = r1
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            int r1 = r1.getChildCount()
            if (r1 > 0) goto L_0x002c
            goto L_0x0050
        L_0x002c:
            int r1 = r10.t
            int r1 = r1 + r3
            android.view.View r1 = r10.getChildAt(r1)
            float[] r4 = new float[r7]
            r4[r2] = r5
            int r8 = r10.g
            int r9 = r10.t
            android.view.View r9 = r10.getChildAt(r9)
            int r9 = r9.getWidth()
            int r8 = r8 + r9
            int r8 = -r8
            int r8 = r8 / r7
            float r8 = (float) r8
            r4[r3] = r8
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r0, r6, r4)
            r10.a = r4
            goto L_0x0074
        L_0x0050:
            r10.u = r3
            int r1 = r10.t
            int r1 = r1 - r3
            android.view.View r1 = r10.getChildAt(r1)
            float[] r4 = new float[r7]
            r4[r2] = r5
            int r8 = r10.g
            int r9 = r10.t
            android.view.View r9 = r10.getChildAt(r9)
            int r9 = r9.getWidth()
            int r8 = r8 + r9
            int r8 = r8 / r7
            float r8 = (float) r8
            r4[r3] = r8
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r0, r6, r4)
            r10.a = r4
        L_0x0074:
            android.animation.ObjectAnimator r4 = r10.a
            android.view.animation.LinearInterpolator r8 = new android.view.animation.LinearInterpolator
            r8.<init>()
            r4.setInterpolator(r8)
            android.animation.ObjectAnimator r4 = r10.a
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp$2 r8 = new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp$2
            r8.<init>(r0)
            r4.addListener(r8)
            boolean r0 = r10.u
            if (r0 == 0) goto L_0x00a3
            float[] r0 = new float[r7]
            int r4 = r10.g
            int r8 = r1.getWidth()
            int r4 = r4 + r8
            int r4 = -r4
            int r4 = r4 / r7
            float r4 = (float) r4
            r0[r2] = r4
            r0[r3] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r1, r6, r0)
            r10.b = r0
            goto L_0x00b8
        L_0x00a3:
            float[] r0 = new float[r7]
            int r4 = r10.g
            int r8 = r1.getWidth()
            int r4 = r4 + r8
            int r4 = r4 / r7
            float r4 = (float) r4
            r0[r2] = r4
            r0[r3] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r1, r6, r0)
            r10.b = r0
        L_0x00b8:
            android.animation.ObjectAnimator r0 = r10.b
            android.view.animation.LinearInterpolator r2 = new android.view.animation.LinearInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            android.animation.ObjectAnimator r0 = r10.b
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp$3 r2 = new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp$3
            r2.<init>(r1)
            r0.addListener(r2)
            android.animation.ObjectAnimator r0 = r10.a
            r1 = 500(0x1f4, double:2.47E-321)
            r0.setDuration(r1)
            android.animation.ObjectAnimator r0 = r10.b
            r0.setDuration(r1)
            android.animation.ObjectAnimator r0 = r10.a
            r0.start()
            android.animation.ObjectAnimator r0 = r10.b
            r0.start()
            boolean r0 = r10.u
            if (r0 == 0) goto L_0x00ec
            int r0 = r10.t
            int r0 = r0 - r3
            r10.t = r0
            goto L_0x00f1
        L_0x00ec:
            int r0 = r10.t
            int r0 = r0 + r3
            r10.t = r0
        L_0x00f1:
            java.lang.Runnable r0 = r10.v
            r1 = 2000(0x7d0, double:9.88E-321)
            r10.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.a():void");
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
