package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationRepository.kt */
public /* synthetic */ class LocationRepository$addM2Locations$1 extends FunctionReferenceImpl implements Function1<M2Location[], Unit> {
    public LocationRepository$addM2Locations$1(Object obj) {
        super(1, obj, LocationRepository.class, "addM2Locations", "addM2Locations([Lcom/m2catalyst/m2sdk/business/models/M2Location;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((M2Location[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(M2Location[] m2LocationArr) {
        Intrinsics.checkNotNullParameter(m2LocationArr, "p0");
        ((LocationRepository) this.receiver).addM2Locations(m2LocationArr);
    }
}
