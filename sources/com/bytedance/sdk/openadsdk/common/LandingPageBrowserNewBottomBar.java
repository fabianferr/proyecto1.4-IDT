package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class LandingPageBrowserNewBottomBar extends LinearLayout {
    public LandingPageBrowserNewBottomBar(Context context) {
        super(context);
        a();
    }

    private static ImageView a(Context context, float f, float f2, float f3, float f4) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setPadding(ad.b(context, f3), ad.b(context, f4), ad.b(context, f3), ad.b(context, f4));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ad.b(context, 40.0f), ad.b(context, 44.0f));
        if (f > 0.0f) {
            layoutParams.leftMargin = ad.b(context, f);
        }
        if (f2 > 0.0f) {
            layoutParams.rightMargin = ad.b(context, f2);
        }
        pAGImageView.setLayoutParams(layoutParams);
        return pAGImageView;
    }

    private void a() {
        Context context = getContext();
        setId(i.ah);
        setLayoutParams(new ViewGroup.LayoutParams(-1, ad.b(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, ad.b(context, 0.5f)));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(0);
        addView(pAGLinearLayout, new LinearLayout.LayoutParams(-1, ad.b(context, 44.0f)));
        ImageView a = a(context, 16.0f, 0.0f, 14.75f, 12.5f);
        a.setId(i.ai);
        a.setImageResource(s.d(context, "tt_ad_arrow_backward_wrapper"));
        pAGLinearLayout.addView(a);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(view2, layoutParams);
        ImageView a2 = a(context, 8.0f, 0.0f, 14.75f, 12.5f);
        a2.setId(i.aj);
        a2.setImageResource(s.d(context, "tt_ad_arrow_forward_wrapper"));
        pAGLinearLayout.addView(a2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        pAGLinearLayout.addView(view3, layoutParams2);
        ImageView a3 = a(context, 8.0f, 0.0f, 10.0f, 12.0f);
        a3.setId(i.ak);
        a3.setImageResource(s.d(context, "tt_ad_refresh"));
        pAGLinearLayout.addView(a3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        pAGLinearLayout.addView(view4, layoutParams3);
        ImageView a4 = a(context, 0.0f, 16.0f, 9.0f, 11.0f);
        a4.setId(i.al);
        a4.setImageResource(s.d(context, "tt_ad_link"));
        pAGLinearLayout.addView(a4);
    }
}
