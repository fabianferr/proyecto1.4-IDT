package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.Wifi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.WifiRepository", f = "WifiRepository.kt", i = {0, 0, 0}, l = {96}, m = "addWifi", n = {"this", "accepted", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: WifiRepository.kt */
public final class WifiRepository$addWifi$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiRepository$addWifi$1(WifiRepository wifiRepository, Continuation<? super WifiRepository$addWifi$1> continuation) {
        super(continuation);
        this.this$0 = wifiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addWifi((Wifi[]) null, this);
    }
}
