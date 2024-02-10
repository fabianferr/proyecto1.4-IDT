package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinSdkUtils;

public class d extends a {
    public d(e eVar, Activity activity, m mVar) {
        super(eVar, activity, mVar);
    }

    public void a(ImageView imageView, com.applovin.impl.adview.m mVar, com.applovin.impl.adview.m mVar2, a aVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.d.addView(appLovinAdView);
        int i = 3;
        if (mVar != null) {
            a(this.c.X(), (this.c.ac() ? 3 : 5) | 48, mVar);
        }
        if (mVar2 != null) {
            if (!this.c.ab()) {
                i = 5;
            }
            a(this.c.X(), i | 48, mVar2);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.a.a(b.cw)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.a.a(b.cy)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.a.a(b.cx)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.d.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.d.addView(aVar, this.e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.d);
        } else {
            this.b.setContentView(this.d);
        }
    }
}
