package com.vungle.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/AssetFailedStatusCodeError;", "Lcom/vungle/ads/VungleError;", "url", "", "code", "", "placementId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class AssetFailedStatusCodeError extends VungleError {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AssetFailedStatusCodeError(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AssetFailedStatusCodeError(java.lang.String r11, java.lang.Integer r12, java.lang.String r13) {
        /*
            r10 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 117(0x75, float:1.64E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r3 = com.vungle.ads.internal.protos.Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Asset fail to download: "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = ", Error code:"
            r0.append(r11)
            r0.append(r12)
            java.lang.String r4 = r0.toString()
            r6 = 0
            r7 = 0
            r8 = 48
            r9 = 0
            r1 = r10
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.AssetFailedStatusCodeError.<init>(java.lang.String, java.lang.Integer, java.lang.String):void");
    }
}
