package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.c6;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.n2;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.w2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b7\u00108JU\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\fH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0017J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u001b\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0015J\u0016\u0010%\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u0003H\u0017J!\u0010)\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020(0\fH@ø\u0001\u0000¢\u0006\u0004\b)\u0010\u0015J\u0013\u0010*\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0017R\u0014\u0010,\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NetworkDiagnosticsAvailability;", "", "startTime", "endTime", "", "testTrigger", "testType", "", "transmitted", "limit", "", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "getNDTResults", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetworkDiagnosticsResults", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Ljava/util/List;", "entries", "", "markDiagnosticsTransmittedEntries", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNDTCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetworkDiagnosticCount", "id", "getNetworkDiagnosticsMNSI", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ndt", "addNDT", "(Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNetworkDiagnosticResult", "", "cellId", "isCellIdUniqueForNetworkTest", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNDTList", "addNetworkDiagnosticList", "testId", "getNetworkDiagnosticById", "Lcom/m2catalyst/m2sdk/database/entities/NetworkDiagnosticsEntity;", "deleteEntries", "clearNDTTable", "Lcom/m2catalyst/m2sdk/database/daos/NDTDao;", "diagnosticsDao", "Lcom/m2catalyst/m2sdk/database/daos/NDTDao;", "Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;", "mnsiRepository$delegate", "Lkotlin/Lazy;", "getMnsiRepository", "()Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;", "mnsiRepository", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "<init>", "(Lcom/m2catalyst/m2sdk/database/daos/NDTDao;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: NDTRepository.kt */
public final class NDTRepository extends BaseRepository implements DataAvailability.NetworkDiagnosticsAvailability {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NETWORK_DIAGNOSTICS_LOGS = "NETWORK_DIAGNOSTICS_LOGS";
    private final l2 accessComponent;
    /* access modifiers changed from: private */
    public final NDTDao diagnosticsDao;
    private final Lazy mnsiRepository$delegate = KoinJavaComponent.inject$default(MNSIRepository.class, (Qualifier) null, (Function0) null, 6, (Object) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository$Companion;", "", "()V", "NETWORK_DIAGNOSTICS_LOGS", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NDTRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NDTRepository(NDTDao nDTDao) {
        n2 dataAccess;
        Intrinsics.checkNotNullParameter(nDTDao, "diagnosticsDao");
        this.diagnosticsDao = nDTDao;
        l2 l2Var = null;
        M2Configuration c = r2.a.a().c();
        if (!(c == null || (dataAccess = c.getDataAccess()) == null)) {
            l2Var = dataAccess.f();
        }
        this.accessComponent = l2Var;
    }

    /* access modifiers changed from: private */
    public final MNSIRepository getMnsiRepository() {
        return (MNSIRepository) this.mnsiRepository$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addNDT(com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r11, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDT$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDT$1 r0 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDT$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDT$1 r0 = new com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDT$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r12)
            com.m2catalyst.m2sdk.database.daos.NDTDao r12 = r10.diagnosticsDao
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r11 = r11.toEntity$m2sdk_release()
            r0.label = r3
            java.lang.Object r12 = r12.insertNetworkDiagnosticsEntry(r11, r0)
            if (r12 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.Number r12 = (java.lang.Number) r12
            long r11 = r12.longValue()
            r0 = -1
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x005d
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_COLLECTED
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
        L_0x005d:
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NDTRepository.addNDT(com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addNDTList(java.util.List<com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDTList$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDTList$1 r0 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDTList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDTList$1 r0 = new com.m2catalyst.m2sdk.business.repositories.NDTRepository$addNDTList$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r12 = r0.L$2
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r4 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006c
        L_0x0035:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef
            r13.<init>()
            java.util.Iterator r12 = r12.iterator()
            r4 = r11
            r2 = r13
        L_0x004b:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x007e
            java.lang.Object r13 = r12.next()
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r13 = (com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults) r13
            com.m2catalyst.m2sdk.database.daos.NDTDao r5 = r4.diagnosticsDao
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r13 = r13.toEntity$m2sdk_release()
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r12
            r0.label = r3
            java.lang.Object r13 = r5.insertNetworkDiagnosticsEntry(r13, r0)
            if (r13 != r1) goto L_0x006c
            return r1
        L_0x006c:
            java.lang.Number r13 = (java.lang.Number) r13
            long r5 = r13.longValue()
            r7 = -1
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x004b
            int r13 = r2.element
            int r13 = r13 + r3
            r2.element = r13
            goto L_0x004b
        L_0x007e:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r5 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r6 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_COLLECTED
            int r12 = r2.element
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r8 = 0
            r9 = 4
            r10 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NDTRepository.addNDTList(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void addNetworkDiagnosticList(List<DiagnosticsResults> list) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (M2SDK.INSTANCE.isAccessible(new NDTRepository$addNetworkDiagnosticList$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NDTRepository$addNetworkDiagnosticList$2(this, list, (Continuation<? super NDTRepository$addNetworkDiagnosticList$2>) null), 1, (Object) null);
        }
    }

    public long addNetworkDiagnosticResult(DiagnosticsResults diagnosticsResults) {
        Intrinsics.checkNotNullParameter(diagnosticsResults, "ndt");
        if (M2SDK.INSTANCE.isAccessible(new NDTRepository$addNetworkDiagnosticResult$1(this), this.accessComponent) || getTesting()) {
            return ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NDTRepository$addNetworkDiagnosticResult$2(this, diagnosticsResults, (Continuation<? super NDTRepository$addNetworkDiagnosticResult$2>) null), 1, (Object) null)).longValue();
        }
        return -1;
    }

    public final Object clearNDTTable(Continuation<? super Unit> continuation) {
        Object clearNDTTable = this.diagnosticsDao.clearNDTTable(continuation);
        return clearNDTTable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearNDTTable : Unit.INSTANCE;
    }

    public final Object deleteEntries(List<NetworkDiagnosticsEntity> list, Continuation<? super Unit> continuation) {
        Object deleteEntries = this.diagnosticsDao.deleteEntries(list, continuation);
        return deleteEntries == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteEntries : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNDTCount(kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTCount$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTCount$1 r0 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTCount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTCount$1 r0 = new com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTCount$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.m2catalyst.m2sdk.database.daos.NDTDao r5 = r4.diagnosticsDao
            r0.label = r3
            java.lang.Object r5 = r5.getDiagnosticsTestCount(r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            java.lang.Number r5 = (java.lang.Number) r5
            long r0 = r5.longValue()
            int r5 = (int) r0
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NDTRepository.getNDTCount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNDTResults(java.lang.Long r19, java.lang.Long r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.Boolean r23, java.lang.Integer r24, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults>> r25) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            boolean r8 = r7 instanceof com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTResults$1
            if (r8 == 0) goto L_0x0023
            r8 = r7
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTResults$1 r8 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTResults$1) r8
            int r9 = r8.label
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = r9 & r10
            if (r11 == 0) goto L_0x0023
            int r9 = r9 - r10
            r8.label = r9
            goto L_0x0028
        L_0x0023:
            com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTResults$1 r8 = new com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNDTResults$1
            r8.<init>(r0, r7)
        L_0x0028:
            java.lang.Object r7 = r8.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r10 = r8.label
            r11 = 3
            r12 = 2
            r13 = 1
            if (r10 == 0) goto L_0x00d7
            if (r10 == r13) goto L_0x00a8
            if (r10 == r12) goto L_0x0079
            if (r10 != r11) goto L_0x0071
            java.lang.Object r1 = r8.L$11
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r2 = r8.L$10
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r2 = (com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity) r2
            java.lang.Object r3 = r8.L$9
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r8.L$8
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r8.L$7
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r8.L$6
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Object r10 = r8.L$5
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            java.lang.Object r12 = r8.L$4
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r13 = r8.L$3
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r14 = r8.L$2
            java.lang.Long r14 = (java.lang.Long) r14
            java.lang.Object r15 = r8.L$1
            java.lang.Long r15 = (java.lang.Long) r15
            java.lang.Object r11 = r8.L$0
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r11 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository) r11
            kotlin.ResultKt.throwOnFailure(r7)
            r0 = 3
            goto L_0x0245
        L_0x0071:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0079:
            java.lang.Object r1 = r8.L$7
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r8.L$6
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r8.L$5
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            java.lang.Object r4 = r8.L$4
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r5 = r8.L$3
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r6 = r8.L$2
            java.lang.Long r6 = (java.lang.Long) r6
            java.lang.Object r10 = r8.L$1
            java.lang.Long r10 = (java.lang.Long) r10
            java.lang.Object r11 = r8.L$0
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r11 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository) r11
            kotlin.ResultKt.throwOnFailure(r7)
            r16 = r6
            r6 = r2
            r2 = r16
            r17 = r5
            r5 = r3
            r3 = r17
            goto L_0x01db
        L_0x00a8:
            java.lang.Object r1 = r8.L$7
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r8.L$6
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r8.L$5
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            java.lang.Object r4 = r8.L$4
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r5 = r8.L$3
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r6 = r8.L$2
            java.lang.Long r6 = (java.lang.Long) r6
            java.lang.Object r10 = r8.L$1
            java.lang.Long r10 = (java.lang.Long) r10
            java.lang.Object r11 = r8.L$0
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r11 = (com.m2catalyst.m2sdk.business.repositories.NDTRepository) r11
            kotlin.ResultKt.throwOnFailure(r7)
            r16 = r6
            r6 = r2
            r2 = r16
            r17 = r5
            r5 = r3
            r3 = r17
            goto L_0x01b0
        L_0x00d7:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            if (r1 == 0) goto L_0x00e2
            java.lang.String r10 = r19.toString()
            goto L_0x00e3
        L_0x00e2:
            r10 = r7
        L_0x00e3:
            java.lang.String r11 = ""
            java.lang.String r14 = "startTest >="
            java.lang.String r10 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r11, (java.lang.String) r14, (java.lang.String) r10)
            if (r2 == 0) goto L_0x00f3
            java.lang.String r11 = r20.toString()
            goto L_0x00f4
        L_0x00f3:
            r11 = r7
        L_0x00f4:
            java.lang.String r14 = "startTest <="
            java.lang.String r10 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r10, (java.lang.String) r14, (java.lang.String) r11)
            if (r3 == 0) goto L_0x0102
            java.lang.String r11 = r21.toString()
            goto L_0x0103
        L_0x0102:
            r11 = r7
        L_0x0103:
            java.lang.String r14 = "testTrigger <="
            java.lang.String r10 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r10, (java.lang.String) r14, (java.lang.String) r11)
            if (r4 == 0) goto L_0x0111
            java.lang.String r11 = r22.toString()
            goto L_0x0112
        L_0x0111:
            r11 = r7
        L_0x0112:
            java.lang.String r14 = "testType <="
            java.lang.String r10 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r10, (java.lang.String) r14, (java.lang.String) r11)
            if (r5 == 0) goto L_0x012b
            boolean r7 = r23.booleanValue()
            int r7 = com.m2catalyst.m2sdk.o1.a((boolean) r7)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.String r7 = r7.toString()
        L_0x012b:
            java.lang.String r11 = "transmitted ="
            java.lang.String r7 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r7)
            r10 = 0
            if (r6 == 0) goto L_0x013d
            int r11 = r24.intValue()
            if (r11 <= 0) goto L_0x013d
            r11 = 1
            goto L_0x013e
        L_0x013d:
            r11 = 0
        L_0x013e:
            int r14 = r7.length()
            if (r14 <= 0) goto L_0x0146
            r14 = 1
            goto L_0x0147
        L_0x0146:
            r14 = 0
        L_0x0147:
            if (r14 != 0) goto L_0x014b
            if (r11 == 0) goto L_0x015c
        L_0x014b:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r7)
            java.lang.String r7 = " ORDER BY id ASC"
            r14.append(r7)
            java.lang.String r7 = r14.toString()
        L_0x015c:
            if (r11 == 0) goto L_0x0172
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r7)
            java.lang.String r7 = " LIMIT "
            r11.append(r7)
            r11.append(r6)
            java.lang.String r7 = r11.toString()
        L_0x0172:
            int r11 = r7.length()
            if (r11 <= 0) goto L_0x0179
            r10 = 1
        L_0x0179:
            if (r10 == 0) goto L_0x01b9
            com.m2catalyst.m2sdk.database.daos.NDTDao r10 = r0.diagnosticsDao
            androidx.sqlite.db.SimpleSQLiteQuery r11 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "SELECT * FROM diagnostics_tbl WHERE "
            r12.<init>(r14)
            r12.append(r7)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            r8.L$0 = r0
            r8.L$1 = r1
            r8.L$2 = r2
            r8.L$3 = r3
            r8.L$4 = r4
            r8.L$5 = r5
            r8.L$6 = r6
            r8.L$7 = r7
            r8.label = r13
            java.lang.Object r10 = r10.getDiagnosticsWhereClause(r11, r8)
            if (r10 != r9) goto L_0x01a9
            return r9
        L_0x01a9:
            r11 = r0
            r16 = r10
            r10 = r1
            r1 = r7
            r7 = r16
        L_0x01b0:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L_0x01e3
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x01e3
        L_0x01b9:
            com.m2catalyst.m2sdk.database.daos.NDTDao r10 = r0.diagnosticsDao
            r8.L$0 = r0
            r8.L$1 = r1
            r8.L$2 = r2
            r8.L$3 = r3
            r8.L$4 = r4
            r8.L$5 = r5
            r8.L$6 = r6
            r8.L$7 = r7
            r8.label = r12
            java.lang.Object r10 = r10.getDiagnostics(r8)
            if (r10 != r9) goto L_0x01d4
            return r9
        L_0x01d4:
            r11 = r0
            r16 = r10
            r10 = r1
            r1 = r7
            r7 = r16
        L_0x01db:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L_0x01e3
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01e3:
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r13)
            r12.<init>(r13)
            java.util.Iterator r7 = r7.iterator()
            r14 = r2
            r13 = r3
            r3 = r7
            r15 = r10
            r10 = r5
            r5 = r1
            r1 = r12
            r12 = r4
        L_0x01fa:
            boolean r2 = r3.hasNext()
            if (r2 == 0) goto L_0x0253
            java.lang.Object r2 = r3.next()
            com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity r2 = (com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity) r2
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r4 = r11.getMnsiRepository()
            java.lang.Integer r7 = r2.getMnsiID()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.intValue()
            r20 = r2
            r19 = r3
            long r2 = (long) r7
            r8.L$0 = r11
            r8.L$1 = r15
            r8.L$2 = r14
            r8.L$3 = r13
            r8.L$4 = r12
            r8.L$5 = r10
            r8.L$6 = r6
            r8.L$7 = r5
            r8.L$8 = r1
            r7 = r19
            r8.L$9 = r7
            r0 = r20
            r8.L$10 = r0
            r8.L$11 = r1
            r0 = 3
            r8.label = r0
            java.lang.Object r2 = r4.getMNSIById(r2, r8)
            if (r2 != r9) goto L_0x0240
            return r9
        L_0x0240:
            r4 = r1
            r3 = r7
            r7 = r2
            r2 = r20
        L_0x0245:
            com.m2catalyst.m2sdk.business.models.MNSI r7 = (com.m2catalyst.m2sdk.business.models.MNSI) r7
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r0 = new com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults
            r0.<init>(r2, r7)
            r1.add(r0)
            r0 = r18
            r1 = r4
            goto L_0x01fa
        L_0x0253:
            java.util.List r1 = (java.util.List) r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r2 = r1.size()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Network diagnostics query for startTime="
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r4 = ", endTime="
            r3.append(r4)
            r3.append(r14)
            java.lang.String r4 = ", testTrigger="
            r3.append(r4)
            r3.append(r13)
            java.lang.String r4 = ", testType="
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = ", transmitted="
            r3.append(r4)
            r3.append(r10)
            java.lang.String r4 = ", limit="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " returned "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " entries\nClause: "
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "NETWORK_DIAGNOSTICS_LOGS"
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r19 = r0
            r20 = r3
            r21 = r2
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r19, r20, r21, r22, r23, r24, r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NDTRepository.getNDTResults(java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @w2
    public DiagnosticsResults getNetworkDiagnosticById(long j) {
        if (M2SDK.INSTANCE.isAccessible(new NDTRepository$getNetworkDiagnosticById$1(this), this.accessComponent) || getTesting()) {
            return (DiagnosticsResults) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NDTRepository$getNetworkDiagnosticById$2(this, j, (Continuation<? super NDTRepository$getNetworkDiagnosticById$2>) null), 1, (Object) null);
        }
        return null;
    }

    @w2
    public int getNetworkDiagnosticCount() {
        if (M2SDK.INSTANCE.isAccessible(new NDTRepository$getNetworkDiagnosticCount$1(this), this.accessComponent) || getTesting()) {
            return ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NDTRepository$getNetworkDiagnosticCount$2(this, (Continuation<? super NDTRepository$getNetworkDiagnosticCount$2>) null), 1, (Object) null)).intValue();
        }
        return Integer.MIN_VALUE;
    }

    public final Object getNetworkDiagnosticsMNSI(int i, Continuation<? super Integer> continuation) {
        return this.diagnosticsDao.getNetworkDiagnosticsMNSI(i, continuation);
    }

    @w2
    public List<DiagnosticsResults> getNetworkDiagnosticsResults(Long l, Long l2, Integer num, Integer num2, Boolean bool, Integer num3) {
        if (M2SDK.INSTANCE.isAccessible(new NDTRepository$getNetworkDiagnosticsResults$1(this), this.accessComponent) || getTesting()) {
            return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NDTRepository$getNetworkDiagnosticsResults$2(this, l, l2, num, num2, bool, num3, (Continuation<? super NDTRepository$getNetworkDiagnosticsResults$2>) null), 1, (Object) null);
        }
        return new ArrayList();
    }

    public final Object isCellIdUniqueForNetworkTest(String str, Continuation<? super Integer> continuation) {
        return NDTDao.DefaultImpls.isCellIdUniqueForNetworkTest$default(this.diagnosticsDao, str, 0, continuation, 2, (Object) null);
    }

    public final Object markDiagnosticsTransmittedEntries(List<Integer> list, Continuation<? super Unit> continuation) {
        Object a = c6.a(list, new NDTRepository$markDiagnosticsTransmittedEntries$2(this, (Continuation<? super NDTRepository$markDiagnosticsTransmittedEntries$2>) null), (Continuation<? super Integer>) continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }
}
