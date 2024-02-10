package com.m2catalyst.m2sdk.speed_test;

import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient", f = "SpeedTestNDTApiClient.kt", i = {}, l = {21}, m = "getServers", n = {}, s = {})
/* compiled from: SpeedTestNDTApiClient.kt */
public final class SpeedTestNDTApiClient$getServers$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeedTestNDTApiClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeedTestNDTApiClient$getServers$1(SpeedTestNDTApiClient speedTestNDTApiClient, Continuation<? super SpeedTestNDTApiClient$getServers$1> continuation) {
        super(continuation);
        this.this$0 = speedTestNDTApiClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getServers((MNSI) null, this);
    }
}
