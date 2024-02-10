package com.google.ads.interactivemedia.omid.library.adsession;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public enum zzf {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    zzd("video"),
    AUDIO("audio");
    
    private final String zzg;

    private zzf(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
