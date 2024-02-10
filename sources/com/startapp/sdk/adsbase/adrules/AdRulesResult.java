package com.startapp.sdk.adsbase.adrules;

import java.io.Serializable;

/* compiled from: Sta */
public class AdRulesResult implements Serializable {
    private static final long serialVersionUID = 6038458956238784052L;
    private String reason;
    private boolean shouldDisplayAd;

    public AdRulesResult(boolean z, String str) {
        this.shouldDisplayAd = z;
        this.reason = str;
    }

    public String a() {
        String str = this.reason;
        return str != null ? str.split(" ")[0] : "";
    }

    public boolean b() {
        return this.shouldDisplayAd;
    }
}
