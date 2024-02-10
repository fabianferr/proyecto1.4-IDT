package com.m2catalyst.m2sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.m2catalyst.m2sdk.coroutines.MNSICoroutineUtilsKt$queueMNSIJob$job$1", f = "MNSICoroutineUtils.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MNSICoroutineUtils.kt */
public final class k3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k3(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super k3> continuation) {
        super(2, continuation);
        this.c = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        k3 k3Var = new k3(this.c, continuation);
        k3Var.b = obj;
        return k3Var;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((k3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.c;
            this.a = 1;
            if (function2.invoke((CoroutineScope) this.b, this) == coroutine_suspended) {
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
