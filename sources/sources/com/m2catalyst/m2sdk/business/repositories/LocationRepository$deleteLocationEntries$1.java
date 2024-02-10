package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.LocationRepository", f = "LocationRepository.kt", i = {}, l = {262}, m = "deleteLocationEntries", n = {}, s = {})
/* compiled from: LocationRepository.kt */
public final class LocationRepository$deleteLocationEntries$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRepository$deleteLocationEntries$1(LocationRepository locationRepository, Continuation<? super LocationRepository$deleteLocationEntries$1> continuation) {
        super(continuation);
        this.this$0 = locationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteLocationEntries(this);
    }
}
