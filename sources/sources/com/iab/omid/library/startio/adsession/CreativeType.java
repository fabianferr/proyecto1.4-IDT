package com.iab.omid.library.startio.adsession;

/* compiled from: Sta */
public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    d("video");
    
    private final String creativeType;

    /* access modifiers changed from: public */
    CreativeType(String str) {
        this.creativeType = str;
    }

    public String toString() {
        return this.creativeType;
    }
}
