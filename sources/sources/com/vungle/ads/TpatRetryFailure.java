package com.vungle.ads;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/TpatRetryFailure;", "Lcom/vungle/ads/VungleError;", "url", "", "(Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class TpatRetryFailure extends VungleError {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TpatRetryFailure(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 137(0x89, float:1.92E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r3 = com.vungle.ads.internal.protos.Sdk.SDKError.Reason.TPAT_RETRY_FAILED
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Pinging Tpat did not succeed during all allowed reries. Failed url is "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r4 = r0.toString()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 56
            r9 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.TpatRetryFailure.<init>(java.lang.String):void");
    }
}
