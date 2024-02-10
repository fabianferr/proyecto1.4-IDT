package com.unity3d.services.core.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.extensions.TaskExtensionsKt", f = "TaskExtensions.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {17, 30}, m = "withRetry", n = {"fallbackException", "block", "nextDelay", "retryDelay", "retries", "scalingFactor", "attempt", "fallbackException", "block", "nextDelay", "retryDelay", "retries", "scalingFactor"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "D$0", "I$2", "L$0", "L$1", "L$2", "J$0", "I$0", "D$0"})
/* compiled from: TaskExtensions.kt */
final class TaskExtensionsKt$withRetry$1<T> extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    TaskExtensionsKt$withRetry$1(Continuation<? super TaskExtensionsKt$withRetry$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TaskExtensionsKt.withRetry(0, 0, 0.0d, (Exception) null, (Function2) null, this);
    }
}
