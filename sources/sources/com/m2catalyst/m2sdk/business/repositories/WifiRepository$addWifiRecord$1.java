package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.Wifi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiRepository.kt */
public /* synthetic */ class WifiRepository$addWifiRecord$1 extends FunctionReferenceImpl implements Function1<Wifi, Unit> {
    public WifiRepository$addWifiRecord$1(Object obj) {
        super(1, obj, WifiRepository.class, "addWifiRecord", "addWifiRecord(Lcom/m2catalyst/m2sdk/business/models/Wifi;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Wifi) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Wifi wifi) {
        Intrinsics.checkNotNullParameter(wifi, "p0");
        ((WifiRepository) this.receiver).addWifiRecord(wifi);
    }
}
