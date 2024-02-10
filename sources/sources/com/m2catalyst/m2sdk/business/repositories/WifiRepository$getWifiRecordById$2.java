package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
import com.m2catalyst.m2sdk.database.entities.WifiEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiRecordById$2", f = "WifiRepository.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WifiRepository.kt */
public final class WifiRepository$getWifiRecordById$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Wifi>, Object> {
    final /* synthetic */ long $id;
    int label;
    final /* synthetic */ WifiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiRepository$getWifiRecordById$2(WifiRepository wifiRepository, long j, Continuation<? super WifiRepository$getWifiRecordById$2> continuation) {
        super(2, continuation);
        this.this$0 = wifiRepository;
        this.$id = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiRepository$getWifiRecordById$2(this.this$0, this.$id, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Wifi> continuation) {
        return ((WifiRepository$getWifiRecordById$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WifiDao access$getWifiDao$p = this.this$0.wifiDao;
            long j = this.$id;
            this.label = 1;
            obj = access$getWifiDao$p.getWifiInfo(j, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        WifiEntity wifiEntity = (WifiEntity) obj;
        if (wifiEntity != null) {
            return new Wifi(wifiEntity);
        }
        return null;
    }
}
