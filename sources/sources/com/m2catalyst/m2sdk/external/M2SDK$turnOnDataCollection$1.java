package com.m2catalyst.m2sdk.external;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.external.M2SDK$turnOnDataCollection$1", f = "M2SDK.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"$this$queueMNSIJob"}, s = {"L$0"})
/* compiled from: M2SDK.kt */
public final class M2SDK$turnOnDataCollection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2SDK$turnOnDataCollection$1(Context context, Continuation<? super M2SDK$turnOnDataCollection$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        M2SDK$turnOnDataCollection$1 m2SDK$turnOnDataCollection$1 = new M2SDK$turnOnDataCollection$1(this.$context, continuation);
        m2SDK$turnOnDataCollection$1.L$0 = obj;
        return m2SDK$turnOnDataCollection$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((M2SDK$turnOnDataCollection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "M2SDK"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 != r4) goto L_0x001b
            java.lang.Object r0 = r12.L$1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00b0
        L_0x001b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.String r6 = "start job queued"
            r1.i(r2, r6, r5)
            com.m2catalyst.m2sdk.external.M2SDK r5 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            r5.setStartAttempt$m2sdk_release(r4)
            boolean r5 = r5.isMonitoring()
            if (r5 == 0) goto L_0x0049
            java.lang.String[] r13 = new java.lang.String[r3]
            java.lang.String r0 = "SDK already collecting, skip Start()"
            r1.i(r2, r0, r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0049:
            com.m2catalyst.m2sdk.s5 r1 = com.m2catalyst.m2sdk.s5.i
            if (r1 != 0) goto L_0x0054
            com.m2catalyst.m2sdk.s5 r1 = new com.m2catalyst.m2sdk.s5
            r1.<init>()
            com.m2catalyst.m2sdk.s5.i = r1
        L_0x0054:
            com.m2catalyst.m2sdk.s5 r1 = com.m2catalyst.m2sdk.s5.i
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.m2catalyst.m2sdk.external.M2SDKConfiguration r5 = r1.a()
            if (r5 == 0) goto L_0x00e2
            android.content.Context r5 = r12.$context
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r6 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r7 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.SDK_START
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r9 = 0
            r10 = 4
            r11 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r6, r7, r8, r9, r10, r11)
            com.m2catalyst.m2sdk.r2 r6 = com.m2catalyst.m2sdk.r2.j
            if (r6 != 0) goto L_0x007a
            com.m2catalyst.m2sdk.r2 r6 = new com.m2catalyst.m2sdk.r2
            r6.<init>()
            com.m2catalyst.m2sdk.r2.j = r6
        L_0x007a:
            com.m2catalyst.m2sdk.r2 r6 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            com.m2catalyst.m2sdk.z5 r6 = r6.a()
            com.m2catalyst.m2sdk.a6 r7 = com.m2catalyst.m2sdk.a6.SDK_PERSISTENT_DATA_COLLECTION_ON
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r6.a(r7, r8)
            com.m2catalyst.m2sdk.r2 r1 = r1.a
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x00da
            com.m2catalyst.m2sdk.u0 r1 = com.m2catalyst.m2sdk.u0.e
            if (r1 != 0) goto L_0x009d
            com.m2catalyst.m2sdk.u0 r1 = new com.m2catalyst.m2sdk.u0
            r1.<init>()
            com.m2catalyst.m2sdk.u0.e = r1
        L_0x009d:
            com.m2catalyst.m2sdk.u0 r1 = com.m2catalyst.m2sdk.u0.e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r12.L$0 = r13
            r12.L$1 = r5
            r12.label = r4
            java.lang.Object r13 = r1.a(r5, r12)
            if (r13 != r0) goto L_0x00af
            return r0
        L_0x00af:
            r0 = r5
        L_0x00b0:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00d9
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r13 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r1 = new java.lang.String[r3]
            java.lang.String r3 = "Collection is on"
            r13.i(r2, r3, r1)
            java.util.List r13 = com.m2catalyst.m2sdk.external.M2SDK.lifecycleListeners
            java.util.Iterator r13 = r13.iterator()
        L_0x00c9:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r13.next()
            com.m2catalyst.m2sdk.external.M2LifecycleListener r1 = (com.m2catalyst.m2sdk.external.M2LifecycleListener) r1
            r1.onSDKCollectionStarted()
            goto L_0x00c9
        L_0x00d9:
            r5 = r0
        L_0x00da:
            com.m2catalyst.m2sdk.external.M2SDK r13 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            r13.checkPermissionsAndRestartCollection$m2sdk_release(r5)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L_0x00e3
        L_0x00e2:
            r13 = 0
        L_0x00e3:
            if (r13 == 0) goto L_0x00e8
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00e8:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r0 = "M2 must be initialized before starting it "
            r13.<init>(r0)
            goto L_0x00f1
        L_0x00f0:
            throw r13
        L_0x00f1:
            goto L_0x00f0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.external.M2SDK$turnOnDataCollection$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
