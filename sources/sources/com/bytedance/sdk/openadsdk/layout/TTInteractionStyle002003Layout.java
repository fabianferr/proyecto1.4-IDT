package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTInteractionStyle002003Layout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle002003Layout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTInteractionStyle002003Layout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle002003Layout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGLinearLayout.setOrientation(1);
        addView(pAGLinearLayout);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 337.0f;
        pAGFrameLayout.setLayoutParams(layoutParams);
        pAGLinearLayout.addView(pAGFrameLayout);
        this.a = e(context);
        this.a.setId(i.aA);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(this.a);
        this.b = f(context);
        this.b.setId(i.az);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(this.b);
        TTBackUpAdImageView h = h(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int b = ad.b(context, 10.0f);
        layoutParams2.leftMargin = b;
        layoutParams2.topMargin = b;
        layoutParams2.bottomMargin = b;
        h.setLayoutParams(layoutParams2);
        pAGFrameLayout.addView(h);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 263.0f;
        pAGLinearLayout2.setLayoutParams(layoutParams3);
        pAGLinearLayout2.setOrientation(1);
        pAGLinearLayout2.setGravity(81);
        int b2 = ad.b(context, 16.0f);
        pAGLinearLayout2.setPadding(b2, b2, b2, b2);
        pAGLinearLayout.addView(pAGLinearLayout2);
        this.c = g(context);
        this.c.setId(i.as);
        int b3 = ad.b(context, 45.0f);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(b3, b3));
        pAGLinearLayout2.addView(this.c);
        this.d = b(context);
        this.d.setId(i.ax);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = ad.b(context, 4.0f);
        this.d.setLayoutParams(layoutParams4);
        pAGLinearLayout2.addView(this.d);
        this.e = c(context);
        this.e.setId(i.ay);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = b;
        layoutParams5.bottomMargin = ad.b(context, 25.0f);
        this.e.setLayoutParams(layoutParams5);
        pAGLinearLayout2.addView(this.e);
        this.f = d(context);
        this.f.setId(i.at);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, ad.b(context, 32.0f));
        layoutParams6.topMargin = b2;
        this.f.setLayoutParams(layoutParams6);
        pAGLinearLayout2.addView(this.f);
    }

    /* access modifiers changed from: protected */
    public PAGTextView b(Context context) {
        PAGTextView b = super.b(context);
        b.setTextColor(-1);
        return b;
    }
}
