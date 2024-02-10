package com.appnext.nativeads.designed_native_ads;

public class AppnextDesignedNativeAdData {
    private String fs;
    private String ft;
    private long fu;

    public AppnextDesignedNativeAdData(String str, String str2, long j) {
        this.fs = str;
        this.ft = str2;
        this.fu = j;
    }

    public String getAdPackageName() {
        return this.fs;
    }

    public String getAdTitle() {
        return this.ft;
    }

    public long getAdClickedTime() {
        return this.fu;
    }
}
