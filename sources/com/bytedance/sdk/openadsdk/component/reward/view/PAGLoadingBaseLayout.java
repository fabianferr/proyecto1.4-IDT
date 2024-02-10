package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.utils.ad;

public class PAGLoadingBaseLayout extends PAGRelativeLayout {
    TTRoundRectImageView a;
    PAGTextView b;
    PAGProgressBar c;
    PAGTextView d;
    PAGTextView e;
    PAGLinearLayout f;
    TwoSemicirclesView g;
    TwoSemicirclesView h;

    public PAGLoadingBaseLayout(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(Color.parseColor("#161823"));
    }

    public void a(Context context) {
        this.e = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ad.b(context, 32.0f), ad.b(context, 14.0f));
        layoutParams.setMarginStart(ad.b(context, 20.0f));
        layoutParams.leftMargin = ad.b(context, 20.0f);
        layoutParams.bottomMargin = ad.b(context, 20.0f);
        layoutParams.addRule(12);
        this.e.setLayoutParams(layoutParams);
        this.e.setBackground(s.c(context, "tt_ad_logo_new"));
    }

    public TTRoundRectImageView getLoadingIcon() {
        return this.a;
    }

    public PAGTextView getLoadingAppName() {
        return this.b;
    }

    public PAGProgressBar getLoadingProgressBar() {
        return this.c;
    }

    public PAGTextView getLoadingProgressNumber() {
        return this.d;
    }

    public PAGTextView getLoadingLogo() {
        return this.e;
    }

    public PAGLinearLayout getWaveContainer() {
        return this.f;
    }

    public TwoSemicirclesView getInnerCircle() {
        return this.g;
    }

    public TwoSemicirclesView getOuterCircle() {
        return this.h;
    }
}
