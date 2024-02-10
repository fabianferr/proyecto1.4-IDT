package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.database.entities.LocationEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.LocationRepository$getM2LocationById$2", f = "LocationRepository.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationRepository.kt */
public final class LocationRepository$getM2LocationById$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super M2Location>, Object> {
    final /* synthetic */ int $locationId;
    int label;
    final /* synthetic */ LocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRepository$getM2LocationById$2(LocationRepository locationRepository, int i, Continuation<? super LocationRepository$getM2LocationById$2> continuation) {
        super(2, continuation);
        this.this$0 = locationRepository;
        this.$locationId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationRepository$getM2LocationById$2(this.this$0, this.$locationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super M2Location> continuation) {
        return ((LocationRepository$getM2LocationById$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocationDao access$getLocationDao$p = this.this$0.locationDao;
            int i2 = this.$locationId;
            this.label = 1;
            obj = access$getLocationDao$p.getLocationById(i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocationEntity locationEntity = (LocationEntity) obj;
        if (locationEntity != null) {
            return locationEntity.toBusiness();
        }
        return null;
    }
}
