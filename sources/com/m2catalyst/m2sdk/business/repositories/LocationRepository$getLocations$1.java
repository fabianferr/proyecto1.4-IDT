package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.LocationRepository", f = "LocationRepository.kt", i = {0, 0}, l = {84}, m = "getLocations", n = {"startDate", "endDate"}, s = {"J$0", "J$1"})
/* compiled from: LocationRepository.kt */
public final class LocationRepository$getLocations$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRepository$getLocations$1(LocationRepository locationRepository, Continuation<? super LocationRepository$getLocations$1> continuation) {
        super(continuation);
        this.this$0 = locationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLocations(0, 0, this);
    }
}
