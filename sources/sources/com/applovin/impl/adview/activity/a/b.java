package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

public class b extends a {
    public b(e eVar, Activity activity, m mVar) {
        super(eVar, activity, mVar);
    }

    public void a(com.applovin.impl.adview.m mVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.d.addView(appLovinAdView);
        if (mVar != null) {
            a(this.c.X(), (this.c.ab() ? 3 : 5) | 48, mVar);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.d);
        } else {
            this.b.setContentView(this.d);
        }
    }
}
