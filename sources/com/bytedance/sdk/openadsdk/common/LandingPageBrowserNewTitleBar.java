package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class LandingPageBrowserNewTitleBar extends RelativeLayout {
    public LandingPageBrowserNewTitleBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        setId(i.ac);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, ad.b(context, 44.0f)));
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(i.ad);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setPadding(ad.b(context, 12.0f), ad.b(context, 14.0f), ad.b(context, 12.0f), ad.b(context, 14.0f));
        pAGImageView.setImageResource(s.d(context, "tt_ad_xmark"));
        addView(pAGImageView, new RelativeLayout.LayoutParams(ad.b(context, 40.0f), ad.b(context, 44.0f)));
        PAGImageView pAGImageView2 = new PAGImageView(context);
        pAGImageView2.setId(i.af);
        pAGImageView2.setPadding(ad.b(context, 8.0f), ad.b(context, 10.0f), ad.b(context, 8.0f), ad.b(context, 10.0f));
        pAGImageView2.setImageResource(s.d(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ad.b(context, 40.0f), ad.b(context, 44.0f));
        layoutParams.addRule(11);
        addView(pAGImageView2, layoutParams);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(i.ae);
        pAGTextView.setSingleLine(true);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(Color.parseColor("#222222"));
        pAGTextView.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ad.b(context, 191.0f), ad.b(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, i.af);
        layoutParams2.addRule(1, i.ad);
        int b = ad.b(context, 10.0f);
        layoutParams2.leftMargin = b;
        layoutParams2.rightMargin = b;
        addView(pAGTextView, layoutParams2);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(context, (AttributeSet) null, 16973855);
        pAGProgressBar.setId(i.ag);
        pAGProgressBar.setProgress(1);
        pAGProgressBar.setProgressDrawable(s.c(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, ad.b(context, 2.0f));
        layoutParams3.addRule(12);
        addView(pAGProgressBar, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, ad.b(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
