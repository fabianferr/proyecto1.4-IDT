package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateError", f = "InitializeStateError.kt", i = {}, l = {24}, m = "doWork", n = {}, s = {})
/* compiled from: InitializeStateError.kt */
final class InitializeStateError$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateError$doWork$1(InitializeStateError initializeStateError, Continuation<? super InitializeStateError$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateError;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork((InitializeStateError.Params) null, (Continuation<? super Unit>) this);
    }
}
