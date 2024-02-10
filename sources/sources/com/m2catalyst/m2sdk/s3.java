package com.m2catalyst.m2sdk;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {}, l = {281, 281}, m = "storeCellInfo", n = {}, s = {})
/* compiled from: NetworkCollectionManager.kt */
public final class s3 extends ContinuationImpl {
    public c3 a;
    public q3 b;
    public /* synthetic */ Object c;
    public final /* synthetic */ q3 d;
    public int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s3(q3 q3Var, Continuation<? super s3> continuation) {
        super(continuation);
        this.d = q3Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((List) null, 0, (Continuation) this);
    }
}
