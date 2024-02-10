package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;

public class ShakeAnimationView extends LinearLayout {
    private TextView a;
    /* access modifiers changed from: private */
    public ImageView b;
    private t c;
    private TextView d;
    private a e;
    private LinearLayout f;
    private int g;
    private int h;
    private int i;

    public interface a {
    }

    public ShakeAnimationView(Context context, View view, int i2, int i3, int i4) {
        super(context);
        this.g = i2;
        this.h = i3;
        this.i = i4;
        a(context, view);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view) {
        addView(view);
        if (view instanceof com.bytedance.sdk.component.adexpress.layout.a) {
            com.bytedance.sdk.component.adexpress.layout.a aVar = (com.bytedance.sdk.component.adexpress.layout.a) view;
            this.f = aVar.getHandContainer();
            this.b = aVar.getRockImg();
            this.a = aVar.getRockTopText();
            this.d = aVar.getRockText();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        this.d.setText(str);
    }

    public LinearLayout getShakeLayout() {
        return this.f;
    }

    public void setOnShakeViewListener(a aVar) {
        this.e = aVar;
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
        postDelayed(new Runnable() {
            public void run() {
                if (ShakeAnimationView.this.b != null) {
                    final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                    rotateAnimation.setInterpolator(new b());
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            ShakeAnimationView.this.postDelayed(new Runnable() {
                                public void run() {
                                    ShakeAnimationView.this.b.startAnimation(rotateAnimation);
                                }
                            }, 250);
                        }
                    });
                    ShakeAnimationView.this.b.startAnimation(rotateAnimation);
                }
            }
        }, 500);
    }

    private static class b implements Interpolator {
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * -2.0f) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * -4.0f) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private b() {
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.c == null) {
                this.c = new t(getContext().getApplicationContext());
            }
            this.c.a((t.a) new t.a() {
            });
            this.c.a((float) this.g);
            this.c.c((float) this.h);
            this.c.a(this.i);
            this.c.a();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        t tVar = this.c;
        if (tVar == null) {
            return;
        }
        if (z) {
            tVar.a();
        } else {
            tVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t tVar = this.c;
        if (tVar != null) {
            tVar.b();
        }
    }
}
