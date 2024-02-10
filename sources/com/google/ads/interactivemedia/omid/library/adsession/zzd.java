package com.google.ads.interactivemedia.omid.library.adsession;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public enum zzd {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String zze;

    private zzd(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
