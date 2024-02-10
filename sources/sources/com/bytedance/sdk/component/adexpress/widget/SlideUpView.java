package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.b.b;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.a;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashSlideUp;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashSlideUp5;
import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class SlideUpView extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    /* access modifiers changed from: private */
    public ImageView c;
    private TextView d;
    private TextView e;
    /* access modifiers changed from: private */
    public AnimatorSet f = new AnimatorSet();
    private AnimatorSet g = new AnimatorSet();
    private AnimatorSet h = new AnimatorSet();
    private AnimatorSet i = new AnimatorSet();
    private String j;
    private int k = 100;

    public SlideUpView(Context context) {
        super(context);
        a(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        setClipChildren(false);
        this.j = str;
        a(context);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        if (context == null) {
            context = d.a();
        }
        if (CampaignEx.CLICKMODE_ON.equals(this.j)) {
            addView(new TTDynamicSplashSlideUp5(context));
            double d2 = (double) this.k;
            Double.isNaN(d2);
            this.k = (int) (d2 * 1.25d);
        } else {
            addView(new TTDynamicSplashSlideUp(context));
        }
        this.a = (ImageView) findViewById(a.o);
        this.b = (ImageView) findViewById(a.n);
        this.d = (TextView) findViewById(a.s);
        this.c = (ImageView) findViewById(a.p);
        this.e = (TextView) findViewById(a.r);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f;
    }

    public void a() {
        c();
        this.f.start();
        this.f.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() {
                    public void run() {
                        SlideUpView.this.f.start();
                    }
                }, 200);
            }
        });
    }

    public void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{0.0f, e.a(getContext(), (float) (-this.k))});
        ofFloat3.setInterpolator(b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (int) e.a(getContext(), (float) this.k)});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.c.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SlideUpView.this.c.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f, e.a(getContext(), (float) (-this.k))});
        ofFloat10.setInterpolator(b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimator = ofInt;
        this.g.setDuration(50);
        this.i.setDuration(1500);
        this.h.setDuration(50);
        this.g.playTogether(new Animator[]{ofFloat2, ofFloat7, ofFloat5});
        this.h.playTogether(new Animator[]{ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4});
        this.i.playTogether(new Animator[]{ofFloat3, valueAnimator, ofFloat10});
        this.f.playSequentially(new Animator[]{this.h, this.i, this.g});
    }

    public void b() {
        try {
            AnimatorSet animatorSet = this.f;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.h;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.g;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.i;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e2) {
            l.d(e2.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.e == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.e.setText("");
        } else {
            this.e.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }
}
