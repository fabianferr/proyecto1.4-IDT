package com.applovin.impl.mediation.d;

import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

public class a implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private final a.C0011a a;

    public a(a.C0011a aVar) {
        this.a = aVar;
    }

    public void onAdClicked(MaxAd maxAd) {
        j.d(this.a, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        j.h(this.a, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        j.a((MaxAdListener) this.a, maxAd, maxError);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        j.b((MaxAdListener) this.a, maxAd);
    }

    public void onAdExpanded(MaxAd maxAd) {
        j.g(this.a, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        j.c(this.a, maxAd);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        j.a((MaxAdListener) this.a, str, maxError);
    }

    public void onAdLoaded(MaxAd maxAd) {
        j.a((MaxAdListener) this.a, maxAd);
    }

    public void onAdRequestStarted(String str) {
        j.a((MaxAdRequestListener) this.a, str);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        j.a((MaxAdRevenueListener) this.a, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        j.f(this.a, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        j.e(this.a, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        j.a((MaxAdListener) this.a, maxAd, maxReward);
    }
}
