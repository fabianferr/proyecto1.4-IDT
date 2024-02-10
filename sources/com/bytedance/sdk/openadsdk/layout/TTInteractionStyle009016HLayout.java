package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTInteractionStyle009016HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle009016HLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTInteractionStyle009016HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle009016HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        int b = ad.b(context, 10.0f);
        int b2 = ad.b(context, 5.0f);
        int b3 = ad.b(context, 6.0f);
        int b4 = ad.b(context, 16.0f);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGRelativeLayout.setLayoutParams(layoutParams);
        addView(pAGRelativeLayout);
        this.a = e(context);
        this.a.setId(i.aA);
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.addView(this.a);
        this.b = f(context);
        this.b.setId(i.az);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.addView(this.b);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        pAGRelativeLayout2.setId(i.ar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ad.b(context, 48.0f));
        layoutParams2.setMargins(b2, b2, b2, b2);
        layoutParams2.addRule(12);
        pAGRelativeLayout2.setBackgroundResource(s.d(context, "center_vertical"));
        pAGRelativeLayout2.setGravity(16);
        pAGRelativeLayout2.setLayoutParams(layoutParams2);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        this.c = g(context);
        this.c.setId(i.as);
        int b5 = ad.b(context, 25.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b5, b5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.c.setLayoutParams(layoutParams3);
        pAGRelativeLayout2.addView(this.c);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, i.as);
        layoutParams4.addRule(1, i.as);
        pAGLinearLayout.setLayoutParams(layoutParams4);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        pAGRelativeLayout2.addView(pAGLinearLayout);
        this.d = b(context);
        this.d.setId(i.ax);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = b3;
        layoutParams5.setMarginStart(b3);
        this.d.setLayoutParams(layoutParams5);
        pAGLinearLayout.addView(this.d);
        this.e = c(context);
        this.e.setId(i.ay);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = b3;
        layoutParams6.setMarginStart(b3);
        this.e.setLayoutParams(layoutParams6);
        pAGLinearLayout.addView(this.e);
        this.f = d(context);
        this.f.setId(i.at);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        this.f.setLayoutParams(layoutParams7);
        int b6 = ad.b(context, 4.0f);
        this.f.setPadding(b6, b6, b6, b6);
        pAGRelativeLayout2.addView(this.f);
        TTBackUpAdImageView h = h(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i.ar);
        layoutParams8.leftMargin = b4;
        layoutParams8.bottomMargin = b;
        h.setLayoutParams(layoutParams8);
        pAGRelativeLayout.addView(h);
    }

    /* access modifiers changed from: protected */
    public PAGTextView d(Context context) {
        PAGTextView d = super.d(context);
        d.setBackgroundResource(s.d(context, "tt_download_corner_bg"));
        d.setTextSize(2, 8.0f);
        return d;
    }

    /* access modifiers changed from: protected */
    public PAGTextView b(Context context) {
        PAGTextView b = super.b(context);
        b.setGravity(16);
        b.setMaxWidth(ad.b(context, 53.0f));
        b.setTextColor(-1);
        b.setTextSize(2, 10.0f);
        return b;
    }

    /* access modifiers changed from: protected */
    public PAGTextView c(Context context) {
        PAGTextView c = super.c(context);
        c.setGravity(16);
        c.setMaxWidth(ad.b(context, 53.0f));
        c.setTextColor(-1);
        c.setTextSize(2, 8.0f);
        return c;
    }
}
