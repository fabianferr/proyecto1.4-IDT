package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.Wifi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiRepository.kt */
public /* synthetic */ class WifiRepository$getWifiRecords$1 extends FunctionReferenceImpl implements Function2<Long, Long, List<? extends Wifi>> {
    public WifiRepository$getWifiRecords$1(Object obj) {
        super(2, obj, WifiRepository.class, "getWifiRecords", "getWifiRecords(JJ)Ljava/util/List;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
    }

    public final List<Wifi> invoke(long j, long j2) {
        return ((WifiRepository) this.receiver).getWifiRecords(j, j2);
    }
}
