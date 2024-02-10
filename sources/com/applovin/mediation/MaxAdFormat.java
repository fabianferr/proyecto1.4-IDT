package com.applovin.mediation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.wortise.ads.events.modules.c;

public class MaxAdFormat {
    public static final MaxAdFormat BANNER = new MaxAdFormat(AdPreferences.TYPE_BANNER, IronSourceConstants.BANNER_AD_UNIT);
    public static final MaxAdFormat CROSS_PROMO = new MaxAdFormat("XPROMO", "Cross Promo");
    public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER", IronSourceConstants.INTERSTITIAL_AD_UNIT);
    public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER", "Leader");
    public static final MaxAdFormat MREC = new MaxAdFormat("MREC", "MREC");
    public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE", "Native");
    public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED", "Rewarded");
    public static final MaxAdFormat REWARDED_INTERSTITIAL = new MaxAdFormat("REWARDED_INTER", "Rewarded Interstitial");
    private final String a;
    private final String b;

    private MaxAdFormat(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static MaxAdFormat formatFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("banner")) {
            return BANNER;
        }
        if (str.equalsIgnoreCase("mrec")) {
            return MREC;
        }
        if (str.equalsIgnoreCase("xpromo")) {
            return CROSS_PROMO;
        }
        if (str.equalsIgnoreCase(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            return NATIVE;
        }
        if (str.equalsIgnoreCase("leaderboard") || str.equalsIgnoreCase("leader")) {
            return LEADER;
        }
        if (str.equalsIgnoreCase(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE) || str.equalsIgnoreCase("inter")) {
            return INTERSTITIAL;
        }
        if (str.equalsIgnoreCase("rewarded") || str.equalsIgnoreCase(c.EXTRA_REWARD)) {
            return REWARDED;
        }
        if (str.equalsIgnoreCase("rewarded_inter") || str.equalsIgnoreCase("rewarded_interstitial")) {
            return REWARDED_INTERSTITIAL;
        }
        if (u.a()) {
            u.i("AppLovinSdk", "Unknown ad format: " + str);
        }
        return null;
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(int i, Context context) {
        return (this == BANNER || this == LEADER) ? com.applovin.impl.mediation.d.c.a(i, this, context) : getSize();
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(Activity activity) {
        return getAdaptiveSize(-1, activity);
    }

    @Deprecated
    public String getDisplayName() {
        return this.b;
    }

    public String getLabel() {
        return this.a;
    }

    public AppLovinSdkUtils.Size getSize() {
        return this == BANNER ? new AppLovinSdkUtils.Size(320, 50) : this == LEADER ? new AppLovinSdkUtils.Size(728, 90) : this == MREC ? new AppLovinSdkUtils.Size(300, 250) : this == CROSS_PROMO ? new AppLovinSdkUtils.Size(-1, -1) : new AppLovinSdkUtils.Size(0, 0);
    }

    public boolean isAdViewAd() {
        return this == BANNER || this == MREC || this == LEADER || this == CROSS_PROMO;
    }

    public boolean isFullscreenAd() {
        return this == INTERSTITIAL || this == REWARDED || this == REWARDED_INTERSTITIAL;
    }

    public String toString() {
        return "MaxAdFormat{label='" + this.a + "'}";
    }
}
