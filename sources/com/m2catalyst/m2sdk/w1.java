package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.y6;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@DebugMetadata(c = "com.m2catalyst.m2sdk.business.IngestionManager", f = "IngestionManager.kt", i = {0}, l = {61, 62}, m = "executeAfterVerification", n = {"block"}, s = {"L$0"})
/* compiled from: IngestionManager.kt */
public final class w1 extends ContinuationImpl {
    public Function1 a;
    public /* synthetic */ Object b;
    public final /* synthetic */ x1 c;
    public int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w1(x1 x1Var, Continuation<? super w1> continuation) {
        super(continuation);
        this.c = x1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((y6.a) null, this);
    }
}
