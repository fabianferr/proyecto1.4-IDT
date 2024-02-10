package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTInteractionStyle001001Layout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle001001Layout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTInteractionStyle001001Layout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle001001Layout(Context context, AttributeSet attributeSet, int i) {
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
        int b2 = ad.b(context, 16.0f);
        pAGLinearLayout2.setPadding(b2, b2, b2, b2);
        pAGLinearLayout.addView(pAGLinearLayout2);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        pAGLinearLayout2.addView(pAGRelativeLayout);
        this.c = g(context);
        this.c.setId(i.as);
        int b3 = ad.b(context, 45.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(b3, b3);
        layoutParams4.rightMargin = b;
        layoutParams4.setMarginEnd(b);
        this.c.setLayoutParams(layoutParams4);
        pAGRelativeLayout.addView(this.c);
        this.d = b(context);
        this.d.setId(i.ax);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.c.getId());
        layoutParams5.addRule(17, this.c.getId());
        this.d.setLayoutParams(layoutParams5);
        pAGRelativeLayout.addView(this.d);
        this.e = c(context);
        this.e.setId(i.ay);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(3, this.d.getId());
        layoutParams6.addRule(1, this.c.getId());
        layoutParams6.addRule(17, this.c.getId());
        this.e.setLayoutParams(layoutParams6);
        pAGRelativeLayout.addView(this.e);
        this.f = d(context);
        this.f.setId(i.at);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, ad.b(context, 32.0f));
        layoutParams7.topMargin = b2;
        this.f.setLayoutParams(layoutParams7);
        pAGLinearLayout2.addView(this.f);
    }
}
