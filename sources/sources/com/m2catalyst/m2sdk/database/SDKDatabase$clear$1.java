package com.m2catalyst.m2sdk.database;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.database.SDKDatabase$clear$1", f = "SDKDatabase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SDKDatabase.kt */
public final class SDKDatabase$clear$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SDKDatabase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SDKDatabase$clear$1(SDKDatabase sDKDatabase, Continuation<? super SDKDatabase$clear$1> continuation) {
        super(2, continuation);
        this.this$0 = sDKDatabase;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SDKDatabase$clear$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SDKDatabase$clear$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.clearAllTables();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
