package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationRepository.kt */
public /* synthetic */ class LocationRepository$getM2Locations$1 extends FunctionReferenceImpl implements Function2<Long, Long, List<? extends M2Location>> {
    public LocationRepository$getM2Locations$1(Object obj) {
        super(2, obj, LocationRepository.class, "getM2Locations", "getM2Locations(JJ)Ljava/util/List;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
    }

    public final List<M2Location> invoke(long j, long j2) {
        return ((LocationRepository) this.receiver).getM2Locations(j, j2);
    }
}
