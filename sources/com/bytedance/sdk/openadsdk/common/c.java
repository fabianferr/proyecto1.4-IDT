package com.bytedance.sdk.openadsdk.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: LandingPageLoadingDefaultStyle */
public class c extends e {
    ObjectAnimator a;
    private AnimatorSet h;
    private LinearLayout i;

    public void a(int i2) {
    }

    public c(Context context, String str, String[] strArr, n nVar, p pVar) {
        super(context, str, strArr, nVar, pVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.e = f();
    }

    private View f() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this.f);
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setOrientation(1);
        this.i = new LinearLayout(this.f);
        this.i.setLayoutDirection(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ad.b(this.f, 60.0f));
        this.i.setGravity(17);
        this.i.setOrientation(0);
        pAGLinearLayout.addView(this.i, layoutParams);
        int b = ad.b(this.f, 17.0f);
        int b2 = ad.b(this.f, 35.0f);
        int b3 = ad.b(this.f, 1.5f);
        View view = new View(this.f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b2);
        int i2 = -b3;
        layoutParams2.rightMargin = i2;
        view.setBackgroundResource(s.d(this.f, "tt_ad_landing_loading_three_left"));
        this.i.addView(view, layoutParams2);
        View view2 = new View(this.f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(b, b2);
        layoutParams3.rightMargin = i2;
        view2.setBackgroundResource(s.d(this.f, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view2, layoutParams3);
        View view3 = new View(this.f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(b, b2);
        view3.setBackgroundResource(s.d(this.f, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view3, layoutParams4);
        View view4 = new View(this.f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(b, b2);
        layoutParams5.leftMargin = i2;
        view4.setBackgroundResource(s.d(this.f, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view4, layoutParams5);
        View view5 = new View(this.f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(b, b2);
        layoutParams6.leftMargin = i2;
        view5.setBackgroundResource(s.d(this.f, "tt_ad_landing_loading_three_right"));
        this.i.addView(view5, layoutParams6);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this.f);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = ad.b(this.f, 10.0f);
        pAGLinearLayout2.setGravity(17);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams7);
        PAGTextView pAGTextView = new PAGTextView(this.f);
        pAGTextView.setId(i.bt);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 17;
        pAGTextView.setGravity(17);
        pAGTextView.setPadding(ad.b(this.f, 10.0f), 0, 0, 0);
        pAGTextView.setText(s.a(this.f, "tt_loading_language"));
        pAGTextView.setTextColor(Color.parseColor("#80161823"));
        pAGTextView.setTextSize(14.0f);
        pAGLinearLayout2.addView(pAGTextView, layoutParams8);
        if (this.g != null) {
            pAGTextView.setText(this.g.c());
        }
        return pAGLinearLayout;
    }

    public void b() {
        this.h = new AnimatorSet();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", new float[]{-9.0f, 9.0f}).setDuration(300);
            this.a = duration;
            duration.setRepeatMode(2);
            this.a.setRepeatCount(-1);
            AnimatorSet.Builder play = this.h.play(this.a);
            for (int i2 = 1; i2 < this.i.getChildCount(); i2++) {
                float f = i2 % 2 == 0 ? 9.0f : -9.0f;
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.i.getChildAt(i2), "translationY", new float[]{-f, f}).setDuration(300);
                duration2.setRepeatMode(2);
                duration2.setRepeatCount(-1);
                play = play.with(duration2);
            }
            this.h.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void d() {
        super.d();
    }
}
