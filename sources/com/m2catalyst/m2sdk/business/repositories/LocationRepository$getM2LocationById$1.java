package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationRepository.kt */
public /* synthetic */ class LocationRepository$getM2LocationById$1 extends FunctionReferenceImpl implements Function1<Integer, M2Location> {
    public LocationRepository$getM2LocationById$1(Object obj) {
        super(1, obj, LocationRepository.class, "getM2LocationById", "getM2LocationById(I)Lcom/m2catalyst/m2sdk/business/models/M2Location;", 0);
    }

    public final M2Location invoke(int i) {
        return ((LocationRepository) this.receiver).getM2LocationById(i);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
