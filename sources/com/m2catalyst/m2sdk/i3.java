package com.m2catalyst.m2sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

@DebugMetadata(c = "com.m2catalyst.m2sdk.coroutines.MNSICoroutineUtilsKt$executeMutex$1", f = "MNSICoroutineUtils.kt", i = {0, 0, 1, 2}, l = {146, 122, 123}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0"})
/* compiled from: MNSICoroutineUtils.kt */
public final class i3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public Object b;
    public Object c;
    public String d;
    public Function1 e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ Mutex h;
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> i;
    public final /* synthetic */ Long j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Function1<Throwable, Unit> l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i3(Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Long l2, String str, Function1<? super Throwable, Unit> function1, Continuation<? super i3> continuation) {
        super(2, continuation);
        this.h = mutex;
        this.i = function2;
        this.j = l2;
        this.k = str;
        this.l = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i3 i3Var = new i3(this.h, this.i, this.j, this.k, this.l, continuation);
        i3Var.g = obj;
        return i3Var;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((i3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a7 A[SYNTHETIC, Splitter:B:28:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0064
            if (r1 == r4) goto L_0x004b
            if (r1 == r3) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            java.lang.Object r0 = r10.b
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r1 = r10.a
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r10.g
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            goto L_0x00c0
        L_0x0023:
            r11 = move-exception
            goto L_0x00ff
        L_0x0026:
            r11 = move-exception
            goto L_0x00c8
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0031:
            java.lang.Object r1 = r10.c
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r3 = r10.b
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r10.a
            java.lang.Long r4 = (java.lang.Long) r4
            java.lang.Object r6 = r10.g
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            goto L_0x00a5
        L_0x0045:
            r11 = move-exception
            goto L_0x00bc
        L_0x0048:
            r11 = move-exception
            goto L_0x00cf
        L_0x004b:
            kotlin.jvm.functions.Function1 r1 = r10.e
            java.lang.String r4 = r10.d
            java.lang.Object r6 = r10.c
            java.lang.Long r6 = (java.lang.Long) r6
            java.lang.Object r7 = r10.b
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r10.a
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r9 = r10.g
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r6
            goto L_0x008d
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.g
            r9 = r11
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlinx.coroutines.sync.Mutex r8 = r10.h
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r10.i
            java.lang.Long r11 = r10.j
            java.lang.String r1 = r10.k
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r6 = r10.l
            r10.g = r9
            r10.a = r8
            r10.b = r7
            r10.c = r11
            r10.d = r1
            r10.e = r6
            r10.f = r4
            java.lang.Object r4 = r8.lock(r5, r10)
            if (r4 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r4 = r1
            r1 = r6
        L_0x008d:
            r10.g = r8     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.a = r11     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.b = r4     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.c = r1     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.d = r5     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.e = r5     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r10.f = r3     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.Object r3 = r7.invoke(r9, r10)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            if (r3 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r3 = r4
            r6 = r8
            r4 = r11
        L_0x00a5:
            if (r4 == 0) goto L_0x00be
            long r7 = r4.longValue()     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r10.g = r6     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r10.a = r3     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r10.b = r1     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r10.c = r5     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r10.f = r2     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r10)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            if (r11 != r0) goto L_0x00be
            return r0
        L_0x00bc:
            r8 = r6
            goto L_0x0100
        L_0x00be:
            r0 = r1
            r1 = r6
        L_0x00c0:
            java.lang.Thread r11 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r11.getName()     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            goto L_0x00f3
        L_0x00c8:
            r6 = r1
            r1 = r0
            goto L_0x00cf
        L_0x00cb:
            r11 = move-exception
            goto L_0x0100
        L_0x00cd:
            r11 = move-exception
            r6 = r8
        L_0x00cf:
            kotlin.ExceptionsKt.stackTraceToString(r11)     // Catch:{ all -> 0x00fd }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x00fd }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger()     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = "executeMutex TRYBLOCK EXCEPTION "
            java.lang.String r3 = kotlin.ExceptionsKt.stackTraceToString(r11)     // Catch:{ all -> 0x00fd }
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x00fd }
            r0.e(r2, r3, r4)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x00f2
            java.lang.Throwable r11 = r11.fillInStackTrace()     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = "e.fillInStackTrace()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ all -> 0x00fd }
            r1.invoke(r11)     // Catch:{ all -> 0x00fd }
        L_0x00f2:
            r1 = r6
        L_0x00f3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fb }
            r1.unlock(r5)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00fb:
            r11 = move-exception
            goto L_0x0103
        L_0x00fd:
            r11 = move-exception
            r1 = r6
        L_0x00ff:
            r8 = r1
        L_0x0100:
            throw r11     // Catch:{ all -> 0x0101 }
        L_0x0101:
            r11 = move-exception
            r1 = r8
        L_0x0103:
            r1.unlock(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.i3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
