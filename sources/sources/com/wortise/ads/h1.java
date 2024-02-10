package com.wortise.ads;

import android.telephony.CellSignalStrength;
import com.wortise.ads.network.models.CellNetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/wortise/ads/h1;", "", "Landroid/telephony/CellSignalStrength;", "strength", "Lcom/wortise/ads/network/models/CellNetworkType;", "networkType", "Lcom/wortise/ads/g1;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellSignalFactory.kt */
public final class h1 {
    public static final h1 a = new h1();

    private h1() {
    }

    public final g1 a(CellSignalStrength cellSignalStrength, CellNetworkType cellNetworkType) {
        Integer num;
        Intrinsics.checkNotNullParameter(cellSignalStrength, "strength");
        Integer valueOf = Integer.valueOf(cellSignalStrength.getAsuLevel());
        Integer a2 = i1.a(cellSignalStrength);
        Integer b = i1.b(cellSignalStrength);
        if (cellNetworkType == null) {
            num = null;
        } else {
            num = i1.a(cellSignalStrength, cellNetworkType);
        }
        return new g1(valueOf, a2, b, num, i1.c(cellSignalStrength), Integer.valueOf(cellSignalStrength.getLevel()), i1.d(cellSignalStrength), i1.e(cellSignalStrength), Integer.valueOf(cellSignalStrength.getDbm()), i1.f(cellSignalStrength), i1.g(cellSignalStrength));
    }
}
