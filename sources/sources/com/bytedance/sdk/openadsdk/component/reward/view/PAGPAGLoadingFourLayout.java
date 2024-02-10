package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.utils.ad;

public class PAGPAGLoadingFourLayout extends PAGLoadingBaseLayout {
    public PAGPAGLoadingFourLayout(Context context) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        this.d = new PAGTextView(context);
        this.d.setId(520093749);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ad.b(context, 15.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextColor(Color.parseColor("#FFFFFF"));
        this.d.setTextSize(1, 30.0f);
        PAGTextView pAGTextView = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ad.b(context, 15.0f);
        pAGTextView.setLayoutParams(layoutParams3);
        pAGTextView.setTextColor(Color.parseColor("#FFFFFF"));
        pAGTextView.setTextSize(1, 30.0f);
        pAGTextView.setText("%");
        linearLayout2.addView(this.d);
        linearLayout2.addView(pAGTextView);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.bottomMargin = ad.b(context, 15.0f);
        pAGTextView2.setLayoutParams(layoutParams4);
        pAGTextView2.setAlpha(0.34f);
        pAGTextView2.setText("loading");
        pAGTextView2.setTextColor(Color.parseColor("#FFFFFF"));
        pAGTextView2.setTextSize(1, 19.0f);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(pAGTextView2);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.g = new TwoSemicirclesView(context, (AttributeSet) null);
        this.g.setId(520093751);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.h = new TwoSemicirclesView(context, (AttributeSet) null);
        this.h.setId(520093752);
        this.h.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        pAGFrameLayout.addView(this.g);
        pAGFrameLayout.addView(this.h);
        a(context);
        addView(linearLayout);
        addView(pAGFrameLayout);
        addView(this.e);
    }
}
