package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.ad;

public class PAGAppOpenTopBarView extends PAGRelativeLayout {
    private final PAGTextView a;
    private final PAGTextView b;

    public PAGAppOpenTopBarView(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int b2 = ad.b(context, 12.0f);
        int b3 = ad.b(context, 16.0f);
        int b4 = ad.b(context, 20.0f);
        int b5 = ad.b(context, 24.0f);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.a = pAGTextView;
        pAGTextView.setId(520093713);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, b5);
        layoutParams.topMargin = b4;
        layoutParams.leftMargin = b3;
        layoutParams.setMarginStart(b3);
        pAGTextView.setLayoutParams(layoutParams);
        pAGTextView.setBackground(s.c(context, "tt_app_open_top_bg"));
        pAGTextView.setGravity(17);
        pAGTextView.setPadding(b2, 0, b2, 0);
        pAGTextView.setText(s.a(context, "tt_reward_feedback"));
        pAGTextView.setTextColor(Color.parseColor("#ffffff"));
        pAGTextView.setTextSize(1, 14.0f);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.b = pAGTextView2;
        pAGTextView2.setId(520093714);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, b5);
        layoutParams2.topMargin = b4;
        layoutParams2.rightMargin = b3;
        layoutParams2.setMarginEnd(b3);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        pAGTextView2.setLayoutParams(layoutParams2);
        pAGTextView2.setBackground(s.c(context, "tt_app_open_top_bg"));
        pAGTextView2.setGravity(17);
        pAGTextView2.setPadding(b2, 0, b2, 0);
        pAGTextView2.setText(s.b(context, "tt_txt_skip"));
        pAGTextView2.setTextColor(Color.parseColor("#ffffff"));
        pAGTextView2.setTextSize(1, 14.0f);
        addView(pAGTextView);
        addView(pAGTextView2);
    }

    public PAGTextView getTopDislike() {
        return this.a;
    }

    public PAGTextView getTopSkip() {
        return this.b;
    }
}
