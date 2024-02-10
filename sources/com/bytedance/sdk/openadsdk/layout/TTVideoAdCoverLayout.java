package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTVideoAdCoverLayout extends PAGRelativeLayout {
    public TTVideoAdCoverLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTVideoAdCoverLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTVideoAdCoverLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setId(i.aD);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        PAGImageView pAGImageView = new PAGImageView(getContext());
        pAGImageView.setId(i.aF);
        pAGImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (Build.VERSION.SDK_INT >= 21) {
            pAGImageView.setImageTintMode(PorterDuff.Mode.SRC_OVER);
            pAGImageView.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        }
        pAGImageView.setBackgroundColor(Color.parseColor("#7f000000"));
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(pAGImageView);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(i.aE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        pAGRelativeLayout.setLayoutParams(layoutParams);
        addView(pAGRelativeLayout);
        int b = ad.b(context, 44.0f);
        CornerIV cornerIV = new CornerIV(context);
        cornerIV.setId(i.K);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b, b);
        layoutParams2.addRule(14);
        cornerIV.setLayoutParams(layoutParams2);
        cornerIV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        pAGRelativeLayout.addView(cornerIV);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(i.L);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b, b);
        layoutParams3.addRule(8, i.K);
        layoutParams3.addRule(19, i.K);
        layoutParams3.addRule(5, i.K);
        layoutParams3.addRule(7, i.K);
        layoutParams3.addRule(18, i.K);
        layoutParams3.addRule(6, i.K);
        layoutParams3.addRule(14);
        pAGTextView.setLayoutParams(layoutParams3);
        pAGTextView.setBackgroundResource(s.d(context, "tt_circle_solid_mian"));
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 19.0f);
        pAGTextView.setTypeface(Typeface.defaultFromStyle(1));
        pAGTextView.setVisibility(8);
        pAGRelativeLayout.addView(pAGTextView);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(i.M);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, i.K);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = ad.b(context, 6.0f);
        pAGTextView2.setLayoutParams(layoutParams4);
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView2.setMaxLines(1);
        pAGTextView2.setTextColor(-1);
        pAGTextView2.setTextSize(2, 12.0f);
        pAGRelativeLayout.addView(pAGTextView2);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        pAGTextView3.setId(i.N);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ad.b(context, 100.0f), ad.b(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, i.M);
        layoutParams5.topMargin = ad.b(context, 20.0f);
        pAGTextView3.setLayoutParams(layoutParams5);
        pAGTextView3.setMinWidth(ad.b(context, 72.0f));
        pAGTextView3.setMaxLines(1);
        pAGTextView3.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView3.setTextColor(-1);
        pAGTextView3.setTextSize(2, 14.0f);
        pAGTextView3.setBackgroundResource(s.d(context, "tt_ad_cover_btn_begin_bg"));
        pAGTextView3.setGravity(17);
        int b2 = ad.b(context, 10.0f);
        int b3 = ad.b(context, 2.0f);
        pAGTextView3.setPadding(b2, b3, b2, b3);
        pAGTextView3.setVisibility(8);
        pAGRelativeLayout.addView(pAGTextView3);
    }
}
