package com.iab.omid.library.startio.adsession;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: Sta */
public enum AdSessionContextType {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    /* access modifiers changed from: public */
    AdSessionContextType(String str) {
        this.typeString = str;
    }

    public String toString() {
        return this.typeString;
    }
}
