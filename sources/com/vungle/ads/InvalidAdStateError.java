package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/vungle/ads/InvalidAdStateError;", "Lcom/vungle/ads/VungleError;", "errorCode", "", "loggableReason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "errorMessage", "", "placementId", "creativeId", "eventId", "(ILcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class InvalidAdStateError extends VungleError {
    public InvalidAdStateError() {
        this(0, (Sdk.SDKError.Reason) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InvalidAdStateError(int r5, com.vungle.ads.internal.protos.Sdk.SDKError.Reason r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            r5 = 10042(0x273a, float:1.4072E-41)
        L_0x0006:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto L_0x000d
            r12 = r0
            goto L_0x000e
        L_0x000d:
            r12 = r6
        L_0x000e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0014
            java.lang.String r7 = "Ad state is invalid"
        L_0x0014:
            r1 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.InvalidAdStateError.<init>(int, com.vungle.ads.internal.protos.Sdk$SDKError$Reason, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidAdStateError(int i, Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        super(Integer.valueOf(i), reason, str, str2, str3, str4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorMessage");
    }
}
