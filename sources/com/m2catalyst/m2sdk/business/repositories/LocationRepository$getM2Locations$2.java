package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.LocationRepository$getM2Locations$2", f = "LocationRepository.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationRepository.kt */
public final class LocationRepository$getM2Locations$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends M2Location>>, Object> {
    final /* synthetic */ long $endDate;
    final /* synthetic */ long $startDate;
    int label;
    final /* synthetic */ LocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRepository$getM2Locations$2(LocationRepository locationRepository, long j, long j2, Continuation<? super LocationRepository$getM2Locations$2> continuation) {
        super(2, continuation);
        this.this$0 = locationRepository;
        this.$startDate = j;
        this.$endDate = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationRepository$getM2Locations$2(this.this$0, this.$startDate, this.$endDate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<M2Location>> continuation) {
        return ((LocationRepository$getM2Locations$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocationRepository locationRepository = this.this$0;
            long j = this.$startDate;
            long j2 = this.$endDate;
            this.label = 1;
            obj = locationRepository.getLocations(j, j2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
