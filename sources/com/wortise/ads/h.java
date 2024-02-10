package com.wortise.ads;

import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/ads/admanager/AdManagerAdRequest$Builder;", "", "key", "", "value", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: AdManagerAdRequest.kt */
public final class h {
    public static final void a(AdManagerAdRequest.Builder builder, String str, Object obj) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            builder.addCustomTargeting(str, obj.toString());
        }
    }
}
