package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/UnknownExceptionCode;", "Lcom/vungle/ads/VungleError;", "errorMessage", "", "(Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class UnknownExceptionCode extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnknownExceptionCode(String str) {
        super(Integer.valueOf(VungleError.UNKNOWN_EXCEPTION_CODE), Sdk.SDKError.Reason.UNKNOWN_ERROR, str, (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorMessage");
    }
}
