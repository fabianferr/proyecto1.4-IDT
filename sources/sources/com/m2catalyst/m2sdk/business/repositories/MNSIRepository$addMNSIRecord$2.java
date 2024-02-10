package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository$addMNSIRecord$2", f = "MNSIRepository.kt", i = {0, 0}, l = {596}, m = "invokeSuspend", n = {"accepted", "$this$forEach$iv"}, s = {"L$0", "L$1"})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$addMNSIRecord$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MNSI[] $mnsi;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$addMNSIRecord$2(MNSI[] mnsiArr, MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$addMNSIRecord$2> continuation) {
        super(2, continuation);
        this.$mnsi = mnsiArr;
        this.this$0 = mNSIRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MNSIRepository$addMNSIRecord$2(this.$mnsi, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MNSIRepository$addMNSIRecord$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r5 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r5
            java.lang.Object r6 = r0.L$1
            com.m2catalyst.m2sdk.business.models.MNSI[] r6 = (com.m2catalyst.m2sdk.business.models.MNSI[]) r6
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref.IntRef) r7
            kotlin.ResultKt.throwOnFailure(r16)
            r9 = r16
            r8 = r0
            goto L_0x005d
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r16)
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            com.m2catalyst.m2sdk.business.models.MNSI[] r4 = r0.$mnsi
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r5 = r0.this$0
            int r6 = r4.length
            r7 = 0
            r8 = r0
            r7 = r2
            r2 = r6
            r6 = r4
            r4 = 0
        L_0x003e:
            if (r4 >= r2) goto L_0x0070
            r9 = r6[r4]
            com.m2catalyst.m2sdk.database.daos.MNSIDao r10 = r5.mnsiDao
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r9 = r9.toEntity$m2sdk_release()
            r8.L$0 = r7
            r8.L$1 = r6
            r8.L$2 = r5
            r8.I$0 = r4
            r8.I$1 = r2
            r8.label = r3
            java.lang.Object r9 = r10.insertMNSIEntry(r9, r8)
            if (r9 != r1) goto L_0x005d
            return r1
        L_0x005d:
            java.lang.Number r9 = (java.lang.Number) r9
            long r9 = r9.longValue()
            r11 = -1
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x006e
            int r9 = r7.element
            int r9 = r9 + r3
            r7.element = r9
        L_0x006e:
            int r4 = r4 + r3
            goto L_0x003e
        L_0x0070:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r9 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r10 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.MNSI_COLLECTED
            int r1 = r7.element
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r12 = 0
            r13 = 4
            r14 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r9, r10, r11, r12, r13, r14)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository$addMNSIRecord$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
