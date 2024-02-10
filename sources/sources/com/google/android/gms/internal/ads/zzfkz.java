package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public enum zzfkz {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String zze;

    private zzfkz(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
