package com.iab.omid.library.startio.adsession;

/* compiled from: Sta */
public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    VIEWABLE("viewable");
    
    private final String impressionType;

    /* access modifiers changed from: public */
    ImpressionType(String str) {
        this.impressionType = str;
    }

    public String toString() {
        return this.impressionType;
    }
}
