package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class PAGAppOpenIconOnlyLayout extends PAGAppOpenBaseLayout {
    public PAGAppOpenIconOnlyLayout(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{Color.parseColor("#324045"), Color.parseColor("#403747"), Color.parseColor("#2F3446")}));
        this.a = new PAGImageView(context);
        this.a.setId(520093754);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f = new PAGLinearLayout(context);
        this.f.setId(520093758);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ad.b(context, 24.0f));
        layoutParams.leftMargin = ad.b(context, 16.0f);
        layoutParams.topMargin = ad.b(context, 64.0f);
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(0);
        this.f.setClickable(false);
        this.f.setGravity(15);
        this.f.setOrientation(0);
        this.g = new TTRoundRectImageView(context);
        this.g.setId(520093759);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(ad.b(context, 24.0f), ad.b(context, 24.0f)));
        this.h = new PAGTextView(context);
        this.h.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = ad.b(context, 4.0f);
        this.h.setLayoutParams(layoutParams2);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setMaxLines(2);
        this.h.setTextColor(Color.parseColor("#FFFFFF"));
        this.h.setTextSize(12.0f);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        pAGRelativeLayout.setLayoutParams(layoutParams3);
        this.j = new TTRoundRectImageView(context);
        this.j.setId(i.bv);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ad.b(context, 152.0f), ad.b(context, 152.0f));
        layoutParams4.addRule(14);
        this.j.setLayoutParams(layoutParams4);
        this.k = new PAGTextView(context);
        this.k.setId(i.bw);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, i.bv);
        layoutParams5.topMargin = ad.b(context, 20.0f);
        layoutParams5.leftMargin = ad.b(context, 45.0f);
        layoutParams5.rightMargin = ad.b(context, 45.0f);
        layoutParams5.addRule(14);
        this.k.setLayoutParams(layoutParams5);
        this.k.setTextSize(24.0f);
        this.k.setTextColor(Color.parseColor("#FFFFFF"));
        this.k.setGravity(17);
        this.k.setMaxLines(1);
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.l = new PAGTextView(context);
        this.l.setId(i.bx);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(3, i.bw);
        layoutParams6.topMargin = ad.b(context, 12.0f);
        layoutParams6.leftMargin = ad.b(context, 45.0f);
        layoutParams6.rightMargin = ad.b(context, 45.0f);
        layoutParams6.addRule(14);
        this.l.setLayoutParams(layoutParams6);
        this.l.setTextSize(14.0f);
        this.l.setTextColor(855638015);
        this.l.setGravity(17);
        this.l.setMaxLines(3);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.e = new ButtonFlash(context);
        this.e.setId(520093717);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(ad.b(context, 236.0f), ad.b(context, 48.0f));
        layoutParams7.addRule(3, i.bx);
        layoutParams7.topMargin = ad.b(context, 45.0f);
        layoutParams7.addRule(14);
        this.e.setLayoutParams(layoutParams7);
        this.e.setBackground(s.c(context, "tt_button_blue_back"));
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setLines(1);
        this.e.setText("DOWNLOAD");
        this.e.setGravity(17);
        this.e.setTextColor(Color.parseColor("#FFFFFF"));
        this.e.setTextSize(18.0f);
        this.e.setTag("open_ad_click_button_tag");
        this.d = new PAGTextView(context);
        this.d.setId(520093757);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(ad.b(context, 31.0f), ad.b(context, 14.0f));
        layoutParams8.leftMargin = ad.b(context, 10.0f);
        layoutParams8.bottomMargin = ad.b(context, 10.0f);
        layoutParams8.addRule(12);
        this.d.setLayoutParams(layoutParams8);
        this.d.setBackground(s.c(context, "tt_ad_logo_new"));
        this.d.setGravity(17);
        addView(this.i);
        addView(this.a);
        this.f.addView(this.g);
        this.f.addView(this.h);
        addView(this.f);
        pAGRelativeLayout.addView(this.j);
        pAGRelativeLayout.addView(this.k);
        pAGRelativeLayout.addView(this.l);
        pAGRelativeLayout.addView(this.e);
        addView(pAGRelativeLayout);
        addView(this.d);
    }
}
