package com.iab.omid.library.startio.adsession;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: Sta */
public enum Owner {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    NONE("none");
    
    private final String owner;

    /* access modifiers changed from: public */
    Owner(String str) {
        this.owner = str;
    }

    public String toString() {
        return this.owner;
    }
}
