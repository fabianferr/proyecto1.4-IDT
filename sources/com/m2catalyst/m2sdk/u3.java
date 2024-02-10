package com.m2catalyst.m2sdk;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionOrchestrator$initialize$2", f = "NetworkCollectionOrchestrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkCollectionOrchestrator.kt */
public final class u3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ v3 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u3(v3 v3Var, Continuation<? super u3> continuation) {
        super(2, continuation);
        this.a = v3Var;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u3(this.a, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((u3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        v3 v3Var = this.a;
        v3Var.e = ((w) v3Var.a.getValue()).b();
        v3 v3Var2 = this.a;
        v3Var2.f = ((w) v3Var2.a.getValue()).a();
        this.a.d();
        v3 v3Var3 = this.a;
        if (v3Var3.h == null) {
            Context a2 = v3Var3.a();
            v3Var3.h = BuildersKt__Builders_commonKt.launch$default(j3.b, (CoroutineContext) null, (CoroutineStart) null, new w3(v3Var3, 5000, a2, (Continuation<? super w3>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
