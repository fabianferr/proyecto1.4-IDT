package com.wortise.ads;

import com.facebook.internal.AnalyticsEvents;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/k3;", "", "", "id", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "APP_OPEN", "BANNER", "INTERSTITIAL", "NATIVE", "REWARDED", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleAdType.kt */
public enum k3 {
    APP_OPEN("app open"),
    c("banner"),
    INTERSTITIAL(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    REWARDED("rewarded");
    
    private final String a;

    private k3(String str) {
        this.a = str;
    }

    public final String b() {
        return this.a;
    }
}
