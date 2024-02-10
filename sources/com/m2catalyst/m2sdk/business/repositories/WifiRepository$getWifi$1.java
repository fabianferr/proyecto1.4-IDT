package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.WifiRepository", f = "WifiRepository.kt", i = {}, l = {70}, m = "getWifi", n = {}, s = {})
/* compiled from: WifiRepository.kt */
public final class WifiRepository$getWifi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiRepository$getWifi$1(WifiRepository wifiRepository, Continuation<? super WifiRepository$getWifi$1> continuation) {
        super(continuation);
        this.this$0 = wifiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getWifi(0, 0, this);
    }
}
