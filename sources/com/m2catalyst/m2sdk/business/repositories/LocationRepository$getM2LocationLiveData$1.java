package com.m2catalyst.m2sdk.business.repositories;

import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationRepository.kt */
public /* synthetic */ class LocationRepository$getM2LocationLiveData$1 extends FunctionReferenceImpl implements Function0<MutableLiveData<M2Location>> {
    public LocationRepository$getM2LocationLiveData$1(Object obj) {
        super(0, obj, LocationRepository.class, "getM2LocationLiveData", "getM2LocationLiveData()Landroidx/lifecycle/MutableLiveData;", 0);
    }

    public final MutableLiveData<M2Location> invoke() {
        return ((LocationRepository) this.receiver).getM2LocationLiveData();
    }
}
