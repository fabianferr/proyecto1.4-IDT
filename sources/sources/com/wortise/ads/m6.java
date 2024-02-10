package com.wortise.ads;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/wortise/ads/l6;", "", "a", "(Lcom/wortise/ads/l6;)Z", "hasRequiredPurposes", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: TcfString.kt */
public final class m6 {
    private static final j6[] a = {j6.STORE_INFORMATION, j6.SELECT_BASIC_ADS, j6.CREATE_PERSONALISED_ADS, j6.SELECT_PERSONALISED_ADS, j6.MEASURE_AD_PERFORMANCE};

    public static final boolean a(l6 l6Var) {
        Intrinsics.checkNotNullParameter(l6Var, "<this>");
        j6[] j6VarArr = a;
        return l6Var.a((j6[]) Arrays.copyOf(j6VarArr, j6VarArr.length));
    }
}
