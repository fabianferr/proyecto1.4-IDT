package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.M2Location;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.LocationRepository$addM2Locations$2", f = "LocationRepository.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationRepository.kt */
public final class LocationRepository$addM2Locations$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ M2Location[] $entries;
    int label;
    final /* synthetic */ LocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRepository$addM2Locations$2(LocationRepository locationRepository, M2Location[] m2LocationArr, Continuation<? super LocationRepository$addM2Locations$2> continuation) {
        super(2, continuation);
        this.this$0 = locationRepository;
        this.$entries = m2LocationArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationRepository$addM2Locations$2(this.this$0, this.$entries, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocationRepository$addM2Locations$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocationRepository locationRepository = this.this$0;
            M2Location[] m2LocationArr = this.$entries;
            ArrayList arrayList = new ArrayList(m2LocationArr.length);
            for (M2Location entity$m2sdk_release : m2LocationArr) {
                arrayList.add(entity$m2sdk_release.toEntity$m2sdk_release());
            }
            this.label = 1;
            if (locationRepository.addLocationList(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
