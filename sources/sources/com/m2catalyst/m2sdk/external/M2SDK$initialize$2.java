package com.m2catalyst.m2sdk.external;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.external.M2SDK", f = "M2SDK.kt", i = {0}, l = {84}, m = "initialize$m2sdk_release", n = {"context"}, s = {"L$0"})
/* compiled from: M2SDK.kt */
public final class M2SDK$initialize$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ M2SDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2SDK$initialize$2(M2SDK m2sdk, Continuation<? super M2SDK$initialize$2> continuation) {
        super(continuation);
        this.this$0 = m2sdk;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initialize$m2sdk_release((Context) null, this);
    }
}
