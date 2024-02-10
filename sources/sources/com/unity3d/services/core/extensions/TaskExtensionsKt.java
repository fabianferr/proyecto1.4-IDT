package com.unity3d.services.core.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001at\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"withRetry", "T", "retryDelay", "", "retries", "", "scalingFactor", "", "fallbackException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "attempt", "Lkotlin/coroutines/Continuation;", "", "(JIDLjava/lang/Exception;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TaskExtensions.kt */
public final class TaskExtensionsKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084 A[SYNTHETIC, Splitter:B:19:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withRetry(long r20, int r22, double r23, java.lang.Exception r25, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r26, kotlin.coroutines.Continuation<? super T> r27) {
        /*
            r0 = r27
            boolean r1 = r0 instanceof com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1 r1 = (com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1 r1 = new com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x0069
            if (r3 == r5) goto L_0x004c
            if (r3 != r4) goto L_0x0044
            int r3 = r1.I$1
            double r6 = r1.D$0
            int r8 = r1.I$0
            long r9 = r1.J$0
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r13 = r1.L$0
            java.lang.Exception r13 = (java.lang.Exception) r13
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0130
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            int r3 = r1.I$2
            int r6 = r1.I$1
            double r7 = r1.D$0
            int r9 = r1.I$0
            long r10 = r1.J$0
            java.lang.Object r12 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r1.L$1
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            java.lang.Object r14 = r1.L$0
            java.lang.Exception r14 = (java.lang.Exception) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x00b6
        L_0x0066:
            r0 = move-exception
            goto L_0x00cf
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
            r0.<init>()
            r6 = r20
            r0.element = r6
            r3 = 0
            r8 = r25
            r9 = r26
            r13 = r0
            r10 = r1
            r11 = r2
            r12 = 0
            r1 = r22
            r2 = r23
        L_0x0082:
            if (r12 >= r1) goto L_0x0159
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00bb }
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)     // Catch:{ all -> 0x00bb }
            r10.L$0 = r8     // Catch:{ all -> 0x00bb }
            r10.L$1 = r9     // Catch:{ all -> 0x00bb }
            r10.L$2 = r13     // Catch:{ all -> 0x00bb }
            r10.J$0 = r6     // Catch:{ all -> 0x00bb }
            r10.I$0 = r1     // Catch:{ all -> 0x00bb }
            r10.D$0 = r2     // Catch:{ all -> 0x00bb }
            r10.I$1 = r12     // Catch:{ all -> 0x00bb }
            r10.I$2 = r12     // Catch:{ all -> 0x00bb }
            r10.label = r5     // Catch:{ all -> 0x00bb }
            java.lang.Object r0 = r9.invoke(r0, r10)     // Catch:{ all -> 0x00bb }
            if (r0 != r11) goto L_0x00a3
            return r11
        L_0x00a3:
            r14 = r8
            r16 = r9
            r9 = r1
            r1 = r10
            r17 = r13
            r13 = r16
            r18 = r2
            r2 = r11
            r10 = r6
            r3 = r12
            r6 = r3
            r12 = r17
            r7 = r18
        L_0x00b6:
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x00d9
        L_0x00bb:
            r0 = move-exception
            r14 = r8
            r16 = r9
            r9 = r1
            r1 = r10
            r17 = r13
            r13 = r16
            r18 = r2
            r2 = r11
            r10 = r6
            r3 = r12
            r6 = r3
            r12 = r17
            r7 = r18
        L_0x00cf:
            kotlin.Result$Companion r15 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
        L_0x00d9:
            r16 = r6
            r6 = r3
            r3 = r16
            boolean r15 = kotlin.Result.m2351isSuccessimpl(r0)
            if (r15 == 0) goto L_0x00e8
            kotlin.ResultKt.throwOnFailure(r0)
            return r0
        L_0x00e8:
            boolean r15 = kotlin.Result.m2350isFailureimpl(r0)
            if (r15 == 0) goto L_0x0149
            java.lang.Throwable r0 = kotlin.Result.m2347exceptionOrNullimpl(r0)
            boolean r15 = r0 instanceof com.unity3d.services.core.extensions.AbortRetryException
            if (r15 != 0) goto L_0x0148
            int r6 = r6 + r5
            if (r6 == r9) goto L_0x0147
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "Unity Ads init: retrying in "
            r0.<init>(r6)
            long r5 = r12.element
            r0.append(r5)
            java.lang.String r5 = " milliseconds"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r0)
            long r5 = r12.element
            r1.L$0 = r14
            r1.L$1 = r13
            r1.L$2 = r12
            r1.J$0 = r10
            r1.I$0 = r9
            r1.D$0 = r7
            r1.I$1 = r3
            r1.label = r4
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r5, r1)
            if (r0 != r2) goto L_0x012a
            return r2
        L_0x012a:
            r6 = r7
            r8 = r9
            r9 = r10
            r11 = r12
            r12 = r13
            r13 = r14
        L_0x0130:
            double r14 = (double) r9
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r6
            long r14 = (long) r14
            r11.element = r14
            r0 = r3
            r5 = 1
            r16 = r9
            r10 = r1
            r1 = r8
            r9 = r12
            r8 = r13
            r13 = r11
            r11 = r2
            r2 = r6
            r6 = r16
            goto L_0x0155
        L_0x0147:
            throw r14
        L_0x0148:
            throw r0
        L_0x0149:
            r0 = r3
            r16 = r10
            r10 = r1
            r11 = r2
            r2 = r7
            r1 = r9
            r6 = r16
            r9 = r13
            r8 = r14
            r13 = r12
        L_0x0155:
            int r12 = r0 + 1
            goto L_0x0082
        L_0x0159:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unknown exception from withRetry"
            r0.<init>(r1)
            goto L_0x0162
        L_0x0161:
            throw r0
        L_0x0162:
            goto L_0x0161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(long, int, double, java.lang.Exception, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object withRetry$default(long j, int i, double d, Exception exc, Function2 function2, Continuation continuation, int i2, Object obj) {
        return withRetry((i2 & 1) != 0 ? 5000 : j, (i2 & 2) != 0 ? 6 : i, (i2 & 4) != 0 ? 2.0d : d, exc, function2, continuation);
    }
}
