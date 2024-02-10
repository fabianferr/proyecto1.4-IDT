package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.Wifi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiRepository.kt */
public /* synthetic */ class WifiRepository$getWifiRecordById$1 extends FunctionReferenceImpl implements Function1<Long, Wifi> {
    public WifiRepository$getWifiRecordById$1(Object obj) {
        super(1, obj, WifiRepository.class, "getWifiRecordById", "getWifiRecordById(J)Lcom/m2catalyst/m2sdk/business/models/Wifi;", 0);
    }

    public final Wifi invoke(long j) {
        return ((WifiRepository) this.receiver).getWifiRecordById(j);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
