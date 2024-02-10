package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNetworkDiagnosticById$2", f = "NDTRepository.kt", i = {1}, l = {154, 155}, m = "invokeSuspend", n = {"ndtResult"}, s = {"L$0"})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$getNetworkDiagnosticById$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DiagnosticsResults>, Object> {
    final /* synthetic */ long $testId;
    Object L$0;
    int label;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$getNetworkDiagnosticById$2(NDTRepository nDTRepository, long j, Continuation<? super NDTRepository$getNetworkDiagnosticById$2> continuation) {
        super(2, continuation);
        this.this$0 = nDTRepository;
        this.$testId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NDTRepository$getNetworkDiagnosticById$2(this.this$0, this.$testId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DiagnosticsResults> continuation) {
        return ((NDTRepository$getNetworkDiagnosticById$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r6.L$0
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r0 = (com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0059
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0036
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r7 = r6.this$0
            com.m2catalyst.m2sdk.database.daos.NDTDao r7 = r7.diagnosticsDao
            long r4 = r6.$testId
            r6.label = r3
            java.lang.Object r7 = r7.getTestById(r4, r6)
            if (r7 != r0) goto L_0x0036
            return r0
        L_0x0036:
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r7 = (com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity) r7
            if (r7 == 0) goto L_0x0063
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r1 = r6.this$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r1 = r1.getMnsiRepository()
            java.lang.Integer r3 = r7.getMnsiID()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.intValue()
            long r3 = (long) r3
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r1 = r1.getMNSIById(r3, r6)
            if (r1 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r0 = r7
            r7 = r1
        L_0x0059:
            com.m2catalyst.m2sdk.business.models.MNSI r7 = (com.m2catalyst.m2sdk.business.models.MNSI) r7
            if (r7 == 0) goto L_0x0063
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r1 = new com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults
            r1.<init>(r0, r7)
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNetworkDiagnosticById$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
