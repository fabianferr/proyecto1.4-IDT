package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class LandingPageBrowserTitleBarForDark extends RelativeLayout {
    public LandingPageBrowserTitleBarForDark(Context context) {
        super(context);
        a();
    }

    private void a() {
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, ad.b(context, 44.0f)));
        setBackgroundColor(Color.parseColor("#46000000"));
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(520093720);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setImageResource(s.d(context, "tt_leftbackicon_selector_for_dark"));
        pAGImageView.setPadding(ad.b(context, 12.0f), ad.b(context, 5.0f), ad.b(context, 10.0f), ad.b(context, 5.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        addView(pAGImageView, layoutParams);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        pAGImageView2.setId(520093716);
        pAGImageView2.setClickable(true);
        pAGImageView2.setFocusable(true);
        pAGImageView2.setPadding(ad.b(context, 12.0f), ad.b(context, 5.0f), ad.b(context, 10.0f), ad.b(context, 5.0f));
        pAGImageView2.setImageResource(s.d(context, "tt_titlebar_close_seletor_for_dark"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(pAGImageView2, layoutParams2);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(i.an);
        pAGTextView.setPadding(ad.b(context, 12.0f), ad.b(context, 5.0f), ad.b(context, 10.0f), ad.b(context, 5.0f));
        pAGTextView.setText(s.b(context, "tt_reward_feedback"));
        pAGTextView.setTextColor(Color.parseColor("#222222"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        addView(pAGTextView, layoutParams3);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(i.ao);
        pAGTextView2.setSingleLine(true);
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        pAGTextView2.setGravity(17);
        pAGTextView2.setTextColor(Color.parseColor("#222222"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ad.b(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, i.an);
        int b = ad.b(context, 25.0f);
        layoutParams4.rightMargin = b;
        layoutParams4.leftMargin = b;
        addView(pAGTextView2, layoutParams4);
    }
}
