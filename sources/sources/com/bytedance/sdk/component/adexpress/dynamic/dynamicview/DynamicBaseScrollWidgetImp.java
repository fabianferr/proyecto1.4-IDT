package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements e {
    ObjectAnimator a;
    ObjectAnimator b;
    private int t = 0;
    private Runnable u = new Runnable() {
        public void run() {
            DynamicBaseScrollWidgetImp.this.a();
        }
    };

    /* access modifiers changed from: private */
    public void a() {
        final View childAt = getChildAt(this.t);
        final View childAt2 = getChildAt((this.t + 1) % getChildCount());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{0.0f, (float) ((-(this.h + getChildAt(this.t).getHeight())) / 2)});
        this.a = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.a.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", new float[]{(float) ((this.h + childAt2.getHeight()) / 2), 0.0f});
        this.b = ofFloat2;
        ofFloat2.setInterpolator(new LinearInterpolator());
        this.b.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.a.setDuration(500);
        this.b.setDuration(500);
        this.a.start();
        this.b.start();
        int i = this.t + 1;
        this.t = i;
        this.t = i % getChildCount();
        postDelayed(this.u, 2000);
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
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
        postDelayed(this.u, 2500);
    }

    public void b() {
        removeCallbacks(this.u);
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
