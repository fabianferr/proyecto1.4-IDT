package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.DeviceRepository", f = "DeviceRepository.kt", i = {0}, l = {219}, m = "syncDevice", n = {"this"}, s = {"L$0"})
/* compiled from: DeviceRepository.kt */
public final class DeviceRepository$syncDevice$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceRepository$syncDevice$1(DeviceRepository deviceRepository, Continuation<? super DeviceRepository$syncDevice$1> continuation) {
        super(continuation);
        this.this$0 = deviceRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.syncDevice((byte[]) null, this);
    }
}
