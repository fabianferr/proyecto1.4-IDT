package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTInteractionStyle016009HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle016009HLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTInteractionStyle016009HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle016009HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        int b = ad.b(context, 10.0f);
        int b2 = ad.b(context, 16.0f);
        int b3 = ad.b(context, 15.0f);
        int b4 = ad.b(context, 20.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ad.b(context, 60.0f));
        layoutParams2.addRule(12);
        layoutParams2.rightMargin = b3;
        layoutParams2.leftMargin = b3;
        layoutParams2.bottomMargin = b3;
        layoutParams2.setMarginEnd(b3);
        layoutParams2.setMarginStart(b3);
        pAGRelativeLayout2.setBackgroundColor(Color.parseColor("#26000000"));
        pAGRelativeLayout2.setLayoutParams(layoutParams2);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        this.c = g(context);
        this.c.setId(i.as);
        int b5 = ad.b(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b5, b5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.c.setLayoutParams(layoutParams3);
        pAGRelativeLayout2.addView(this.c);
        this.d = b(context);
        this.d.setId(i.ax);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = b4;
        layoutParams4.setMarginStart(b4);
        layoutParams4.addRule(1, i.as);
        layoutParams4.addRule(17, i.as);
        this.d.setLayoutParams(layoutParams4);
        pAGRelativeLayout2.addView(this.d);
        this.f = d(context);
        this.f.setId(i.at);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ad.b(context, 100.0f), ad.b(context, 30.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = b;
        layoutParams5.setMarginEnd(b);
        this.f.setLayoutParams(layoutParams5);
        pAGRelativeLayout2.addView(this.f);
        TTBackUpAdImageView h = h(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, i.ar);
        layoutParams6.leftMargin = b2;
        layoutParams6.bottomMargin = b;
        h.setLayoutParams(layoutParams6);
        pAGRelativeLayout.addView(h);
    }

    /* access modifiers changed from: protected */
    public PAGTextView d(Context context) {
        PAGTextView d = super.d(context);
        d.setBackgroundResource(s.d(context, "tt_download_corner_bg"));
        d.setTextSize(2, 15.0f);
        return d;
    }

    /* access modifiers changed from: protected */
    public PAGTextView b(Context context) {
        PAGTextView b = super.b(context);
        b.setGravity(16);
        b.setMaxWidth(ad.b(context, 250.0f));
        b.setTextColor(-1);
        b.setTextSize(2, 17.0f);
        b.setText("APP NAME");
        return b;
    }
}
