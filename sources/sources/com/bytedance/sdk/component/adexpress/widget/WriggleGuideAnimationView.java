package com.bytedance.sdk.component.adexpress.widget;

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
import com.bytedance.sdk.component.adexpress.layout.TTHandWriggleGuide;
import com.bytedance.sdk.component.utils.t;

public class WriggleGuideAnimationView extends LinearLayout {
    private TextView a;
    /* access modifiers changed from: private */
    public ImageView b;
    private t c;
    private TextView d;
    private a e;
    private LinearLayout f;
    private WriggleGuideView g;
    private int h;

    public interface a {
    }

    public WriggleGuideAnimationView(Context context, View view, int i) {
        super(context);
        this.h = i;
        a(context, view);
    }

    private void a(Context context, View view) {
        setClipChildren(false);
        addView(view);
        if (view instanceof TTHandWriggleGuide) {
            TTHandWriggleGuide tTHandWriggleGuide = (TTHandWriggleGuide) view;
            this.f = tTHandWriggleGuide.getWriggleLayout();
            this.b = tTHandWriggleGuide.getTopImage();
            this.g = tTHandWriggleGuide.getProgressImg();
            this.a = tTHandWriggleGuide.getTopText();
            this.d = tTHandWriggleGuide.getBarText();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        this.d.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.f;
    }

    public WriggleGuideView getWriggleProgressIv() {
        return this.g;
    }

    public TextView getTopTextView() {
        return this.a;
    }

    public void setOnShakeViewListener(a aVar) {
        this.e = aVar;
    }

    public void a() {
        postDelayed(new Runnable() {
            public void run() {
                if (WriggleGuideAnimationView.this.b != null) {
                    final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -35.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setInterpolator(new b());
                    rotateAnimation.setDuration(1500);
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            WriggleGuideAnimationView.this.postDelayed(new Runnable() {
                                public void run() {
                                    WriggleGuideAnimationView.this.b.startAnimation(rotateAnimation);
                                }
                            }, 300);
                        }
                    });
                    WriggleGuideAnimationView.this.b.startAnimation(rotateAnimation);
                }
            }
        }, 500);
    }

    private static class b implements Interpolator {
        public float getInterpolation(float f) {
            return f <= 0.4f ? f * 2.5f : f <= 0.8f ? (f * -2.2f) + 1.86f : (f * -0.7f) + 0.7f;
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
            this.c.b((float) this.h);
            this.c.a();
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
}
