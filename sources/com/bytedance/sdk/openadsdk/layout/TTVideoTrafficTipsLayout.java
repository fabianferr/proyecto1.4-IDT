package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class TTVideoTrafficTipsLayout extends PAGRelativeLayout {
    public TTVideoTrafficTipsLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTVideoTrafficTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTVideoTrafficTipsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setId(i.ba);
        setBackgroundColor(Color.parseColor("#00000000"));
        setGravity(16);
        setVisibility(8);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(i.bb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        pAGTextView.setLayoutParams(layoutParams);
        pAGTextView.setIncludeFontPadding(false);
        pAGTextView.setText(s.b(context, "tt_video_without_wifi_tips"));
        pAGTextView.setTextColor(Color.parseColor("#cacaca"));
        pAGTextView.setTextSize(2, 14.0f);
        addView(pAGTextView);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(i.bc);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, i.bb);
        layoutParams2.addRule(13);
        pAGRelativeLayout.setLayoutParams(layoutParams2);
        addView(pAGRelativeLayout);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(i.bd);
        int b = ad.b(context, 44.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b, b);
        layoutParams3.addRule(15);
        pAGImageView.setLayoutParams(layoutParams3);
        pAGImageView.setImageDrawable(s.c(context, "tt_new_play_video"));
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        pAGRelativeLayout.addView(pAGImageView);
    }
}
