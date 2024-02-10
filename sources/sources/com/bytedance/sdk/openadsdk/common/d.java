package com.bytedance.sdk.openadsdk.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.Locale;

/* compiled from: LandingPageLoadingFirstStyle */
public class d extends e {
    AnimatorSet a;
    /* access modifiers changed from: private */
    public TextView h;
    /* access modifiers changed from: private */
    public TextView i;
    private PAGProgressBar j;
    private TextView k;
    /* access modifiers changed from: private */
    public FrameLayout l;
    private int m = 0;

    public d(Context context, String str, String[] strArr, n nVar, p pVar) {
        super(context, str, strArr, nVar, pVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f != null) {
            this.e = f();
            if (this.d == null || this.d.length <= 0) {
                FrameLayout frameLayout = this.l;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setText(this.d[0]);
            }
        }
    }

    private View f() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this.f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        int b = ad.b(this.f, 68.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(this.f);
        pAGLinearLayout.addView(tTRoundRectImageView, new LinearLayout.LayoutParams(b, b));
        PAGTextView pAGTextView = new PAGTextView(this.f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ad.b(this.f, 170.0f), -2);
        layoutParams2.topMargin = ad.b(this.f, 8.0f);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(17);
        pAGTextView.setMaxWidth(ad.b(this.f, 150.0f));
        pAGTextView.setMaxLines(2);
        pAGTextView.setTextColor(Color.parseColor("#222222"));
        pAGTextView.setTextSize(18.0f);
        pAGLinearLayout.addView(pAGTextView, layoutParams2);
        this.l = new PAGFrameLayout(this.f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = ad.b(this.f, 244.0f);
        layoutParams3.height = ad.b(this.f, 24.0f);
        layoutParams3.topMargin = ad.b(this.f, 16.0f);
        pAGLinearLayout.addView(this.l, layoutParams3);
        this.h = new PAGTextView(this.f);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setVisibility(4);
        layoutParams4.gravity = 17;
        int d = s.d(this.f, "tt_landingpage_loading_text_rect");
        this.h.setBackgroundResource(d);
        this.h.setGravity(17);
        this.h.setMaxLines(1);
        int b2 = ad.b(this.f, 12.0f);
        int b3 = ad.b(this.f, 4.0f);
        this.h.setPadding(b2, b3, b2, b3);
        int parseColor = Color.parseColor("#1A73E8");
        this.h.setTextColor(parseColor);
        this.h.setTextSize(12.0f);
        this.l.addView(this.h, layoutParams4);
        this.i = new PAGTextView(this.f);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -1);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams5.gravity = 17;
        this.i.setBackgroundResource(d);
        this.i.setGravity(17);
        this.i.setMaxLines(1);
        this.i.setPadding(b2, b3, b2, b3);
        this.i.setTextColor(parseColor);
        this.i.setTextSize(12.0f);
        this.l.addView(this.i, layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this.f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        int b4 = ad.b(this.f, 21.0f);
        int b5 = ad.b(this.f, 43.0f);
        layoutParams6.topMargin = b4;
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setPadding(b5, 0, 0, 0);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams6);
        this.j = new PAGProgressBar(this.f, (AttributeSet) null, 16973855);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ad.b(this.f, 160.0f), b2);
        layoutParams7.gravity = 16;
        this.j.setMax(100);
        this.j.setProgress(1);
        this.j.setProgressDrawable(s.c(this.f, "tt_full_reward_loading_progress_style"));
        pAGLinearLayout2.addView(this.j, layoutParams7);
        this.k = new PAGTextView(this.f);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(ad.b(this.f, 35.0f), -2);
        this.k.setMaxLines(1);
        layoutParams8.leftMargin = ad.b(this.f, 8.0f);
        this.k.setTextColor(Color.parseColor("#161823"));
        this.k.setTextSize(14.0f);
        pAGLinearLayout2.addView(this.k, layoutParams8);
        if (!TextUtils.isEmpty(this.c)) {
            pAGTextView.setText(this.c);
        } else {
            pAGTextView.setVisibility(8);
        }
        if (this.b == null || TextUtils.isEmpty(this.b.a())) {
            tTRoundRectImageView.setVisibility(8);
        } else {
            c.a().a(this.b, (ImageView) tTRoundRectImageView, (q) null);
        }
        return pAGLinearLayout;
    }

    public void b() {
        b(0);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        FrameLayout frameLayout = this.l;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.l.postDelayed(new Runnable() {
                public void run() {
                    if (d.this.a == null) {
                        d.this.a = new AnimatorSet();
                        AnimatorSet animatorSet = d.this.a;
                        d dVar = d.this;
                        AnimatorSet.Builder play = animatorSet.play(dVar.a(dVar.h));
                        d dVar2 = d.this;
                        play.with(dVar2.b(dVar2.i));
                        d.this.a.setDuration(500);
                    }
                    d.this.a.start();
                }
            }, (long) i2);
        }
    }

    public void c() {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* access modifiers changed from: private */
    public ObjectAnimator a(TextView textView) {
        return ObjectAnimator.ofFloat(textView, "translationY", new float[]{0.0f, (float) (-this.l.getHeight())});
    }

    /* access modifiers changed from: private */
    public ObjectAnimator b(final TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", new float[]{(float) (this.l.getHeight() + ad.b(this.f, 10.0f)), 0.0f});
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                TextView textView = textView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (d.this.d != null && d.this.d.length >= 2 && d.this.l != null) {
                    d.this.b(2000);
                    d.this.g();
                }
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.d != null) {
            int i2 = 0;
            if (this.m >= this.d.length) {
                this.m = 0;
            }
            TextView textView = this.h;
            if (textView != null) {
                if (textView.getVisibility() != 0) {
                    this.h.setVisibility(0);
                }
                this.h.setText(this.d[this.m]);
                this.h.setY(0.0f);
            }
            if (this.i != null) {
                int i3 = this.m + 1;
                if (i3 < this.d.length) {
                    i2 = i3;
                }
                this.i.setText(this.d[i2]);
                this.i.setVisibility(4);
            }
            this.m++;
        }
    }

    public void a(int i2) {
        PAGProgressBar pAGProgressBar = this.j;
        if (pAGProgressBar != null) {
            pAGProgressBar.setProgress(i2);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf(i2)}));
        }
    }

    public void d() {
        super.d();
    }
}
