package com.wortise.ads;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/wortise/ads/AdFormat;", "", "isThirdParty", "", "(Ljava/lang/String;IZ)V", "()Z", "GOOGLE", "HTML", "IMAGE", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdFormat.kt */
public enum AdFormat {
    GOOGLE(true),
    HTML(false),
    IMAGE(false);
    
    private final boolean isThirdParty;

    private AdFormat(boolean z) {
        this.isThirdParty = z;
    }

    public final boolean isThirdParty() {
        return this.isThirdParty;
    }
}
