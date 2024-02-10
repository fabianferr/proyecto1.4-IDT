package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashInteractUnlock;

public class DynamicUnlockView extends FrameLayout {
    private final TextView a;
    /* access modifiers changed from: private */
    public final ImageView b;
    /* access modifiers changed from: private */
    public final FlowLightView c;
    /* access modifiers changed from: private */
    public final RotateAnimation d;

    public DynamicUnlockView(Context context) {
        super(context);
        TTDynamicSplashInteractUnlock tTDynamicSplashInteractUnlock = new TTDynamicSplashInteractUnlock(context);
        addView(tTDynamicSplashInteractUnlock);
        this.a = tTDynamicSplashInteractUnlock.getUnlockText();
        this.b = tTDynamicSplashInteractUnlock.getUnlockGo();
        this.c = tTDynamicSplashInteractUnlock.getFlowLightView();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.d = rotateAnimation;
        rotateAnimation.setDuration(300);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a() {
        postDelayed(getHaloAnimation(), 300);
    }

    public void b() {
        this.d.cancel();
    }

    /* access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() {
            public void run() {
                DynamicUnlockView.this.b.startAnimation(DynamicUnlockView.this.d);
                DynamicUnlockView.this.postDelayed(new Runnable() {
                    public void run() {
                        DynamicUnlockView.this.c.a(4);
                    }
                }, 100);
                DynamicUnlockView.this.postDelayed(new Runnable() {
                    public void run() {
                        DynamicUnlockView.this.c.a(4);
                    }
                }, 300);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200);
            }
        };
    }
}
