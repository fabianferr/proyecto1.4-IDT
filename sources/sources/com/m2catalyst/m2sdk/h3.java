package com.m2catalyst.m2sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@DebugMetadata(c = "com.m2catalyst.m2sdk.coroutines.MNSICoroutineUtilsKt$executeMNSIJob$1", f = "MNSICoroutineUtils.kt", i = {0}, l = {71, 74}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: MNSICoroutineUtils.kt */
public final class h3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> d;
    public final /* synthetic */ Function1<Throwable, Unit> e;
    public final /* synthetic */ Ref.ObjectRef<Job> f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h3(Long l, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Function1<? super Throwable, Unit> function1, Ref.ObjectRef<Job> objectRef, Continuation<? super h3> continuation) {
        super(2, continuation);
        this.c = l;
        this.d = function2;
        this.e = function1;
        this.f = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h3 h3Var = new h3(this.c, this.d, this.e, this.f, continuation);
        h3Var.b = obj;
        return h3Var;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((h3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.a
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x004e }
            goto L_0x0074
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            java.lang.Object r1 = r7.b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0041
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.b
            r1 = r8
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Long r8 = r7.c
            if (r8 == 0) goto L_0x0041
            r8.longValue()
            long r5 = r8.longValue()
            r7.b = r1
            r7.a = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
            if (r8 != r0) goto L_0x0041
            return r0
        L_0x0041:
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r7.d     // Catch:{ Exception -> 0x004e }
            r7.b = r3     // Catch:{ Exception -> 0x004e }
            r7.a = r2     // Catch:{ Exception -> 0x004e }
            java.lang.Object r8 = r8.invoke(r1, r7)     // Catch:{ Exception -> 0x004e }
            if (r8 != r0) goto L_0x0074
            return r0
        L_0x004e:
            r8 = move-exception
            kotlin.ExceptionsKt.stackTraceToString(r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger()
            java.lang.String r1 = kotlin.ExceptionsKt.stackTraceToString(r8)
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r5 = "executeMNSIJob TRYBLOCK EXCEPTION "
            r0.e(r5, r1, r2)
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r0 = r7.e
            if (r0 == 0) goto L_0x0074
            java.lang.Throwable r8 = r8.fillInStackTrace()
            java.lang.String r1 = "e.fillInStackTrace()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r0.invoke(r8)
        L_0x0074:
            kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r8 = r7.f
            T r8 = r8.element
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            if (r8 == 0) goto L_0x007f
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r8, (java.util.concurrent.CancellationException) r3, (int) r4, (java.lang.Object) r3)
        L_0x007f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.h3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
