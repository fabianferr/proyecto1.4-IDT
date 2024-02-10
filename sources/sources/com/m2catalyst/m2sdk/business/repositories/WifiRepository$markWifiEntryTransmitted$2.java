package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.database.daos.WifiDao;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.WifiRepository$markWifiEntryTransmitted$2", f = "WifiRepository.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WifiRepository.kt */
public final class WifiRepository$markWifiEntryTransmitted$2 extends SuspendLambda implements Function2<List<? extends Integer>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WifiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiRepository$markWifiEntryTransmitted$2(WifiRepository wifiRepository, Continuation<? super WifiRepository$markWifiEntryTransmitted$2> continuation) {
        super(2, continuation);
        this.this$0 = wifiRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WifiRepository$markWifiEntryTransmitted$2 wifiRepository$markWifiEntryTransmitted$2 = new WifiRepository$markWifiEntryTransmitted$2(this.this$0, continuation);
        wifiRepository$markWifiEntryTransmitted$2.L$0 = obj;
        return wifiRepository$markWifiEntryTransmitted$2;
    }

    public final Object invoke(List<Integer> list, Continuation<? super Unit> continuation) {
        return ((WifiRepository$markWifiEntryTransmitted$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WifiDao access$getWifiDao$p = this.this$0.wifiDao;
            this.label = 1;
            if (access$getWifiDao$p.markWifiTransmittedEntries((List) this.L$0, this) == coroutine_suspended) {
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
