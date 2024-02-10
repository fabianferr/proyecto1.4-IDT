package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/vungle/ads/InternalError;", "Lcom/vungle/ads/VungleError;", "errorCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "equals", "", "other", "", "hashCode", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class InternalError extends VungleError {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InternalError(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public InternalError(int i, String str) {
        super(Integer.valueOf(i), (Sdk.SDKError.Reason) null, str, (String) null, (String) null, (String) null, 58, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        int code = getCode();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.vungle.ads.InternalError");
        if (code == ((InternalError) obj).getCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
