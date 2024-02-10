package com.wortise.ads;

import android.os.Build;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¨\u0006\u0002"}, d2 = {"Landroidx/work/Constraints$Builder;", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Constraints.kt */
public final class z1 {
    public static final Constraints.Builder a(Constraints.Builder builder) {
        NetworkType networkType;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (Build.VERSION.SDK_INT <= 22) {
            networkType = NetworkType.NOT_REQUIRED;
        } else {
            networkType = NetworkType.CONNECTED;
        }
        Constraints.Builder requiredNetworkType = builder.setRequiredNetworkType(networkType);
        Intrinsics.checkNotNullExpressionValue(requiredNetworkType, "setRequiredNetworkType(type)");
        return requiredNetworkType;
    }
}
