package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.NoSignalData;
import com.m2catalyst.m2sdk.c6;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.w2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%JK\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0012\"\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0016J!\u0010\u0019\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/NoSignalMNSIRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NoSignalAvailability;", "", "startDate", "endDate", "", "simSlot", "", "transmitted", "limit", "", "Lcom/m2catalyst/m2sdk/business/models/NoSignalData;", "getNoSignalRecords$m2sdk_release", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNoSignalRecords", "getNoSignals", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", "", "noSignalRecord", "", "addNoSignalRecord", "([Lcom/m2catalyst/m2sdk/business/models/NoSignalData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNoSignal", "entries", "markNoSignalEntityTransmitted", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearNoSignalTable$m2sdk_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearNoSignalTable", "Lcom/m2catalyst/m2sdk/database/daos/NoSignalMNSIDao;", "noSignalDao", "Lcom/m2catalyst/m2sdk/database/daos/NoSignalMNSIDao;", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "<init>", "(Lcom/m2catalyst/m2sdk/database/daos/NoSignalMNSIDao;)V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: NoSignalMNSIRepository.kt */
public final class NoSignalMNSIRepository extends BaseRepository implements DataAvailability.NoSignalAvailability {
    private final l2 accessComponent;
    /* access modifiers changed from: private */
    public final NoSignalMNSIDao noSignalDao;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NoSignalMNSIRepository(com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r2) {
        /*
            r1 = this;
            java.lang.String r0 = "noSignalDao"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.noSignalDao = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            if (r2 == 0) goto L_0x001f
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x001f
            com.m2catalyst.m2sdk.l2 r2 = r2.d()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            r1.accessComponent = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository.<init>(com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao):void");
    }

    public void addNoSignal(NoSignalData noSignalData) {
        Intrinsics.checkNotNullParameter(noSignalData, "noSignalRecord");
        if (M2SDK.INSTANCE.isAccessible(new NoSignalMNSIRepository$addNoSignal$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NoSignalMNSIRepository$addNoSignal$2(this, noSignalData, (Continuation<? super NoSignalMNSIRepository$addNoSignal$2>) null), 1, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addNoSignalRecord(com.m2catalyst.m2sdk.business.models.NoSignalData[] r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$addNoSignalRecord$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$addNoSignalRecord$1 r1 = (com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$addNoSignalRecord$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$addNoSignalRecord$1 r1 = new com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$addNoSignalRecord$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x004d
            if (r4 != r5) goto L_0x0045
            int r4 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$2
            com.m2catalyst.m2sdk.business.models.NoSignalData[] r7 = (com.m2catalyst.m2sdk.business.models.NoSignalData[]) r7
            java.lang.Object r8 = r1.L$1
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r1.L$0
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository r9 = (com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r6
            r6 = r4
            r4 = r7
            r7 = r16
            goto L_0x0078
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r4 = r18
            int r6 = r4.length
            r7 = 0
            r8 = r0
            r9 = r2
        L_0x005b:
            if (r7 >= r6) goto L_0x008b
            r0 = r4[r7]
            com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r10 = r9.noSignalDao
            com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity r0 = r0.toNoSignalEntity$m2sdk_release()
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r4
            r1.I$0 = r7
            r1.I$1 = r6
            r1.label = r5
            java.lang.Object r0 = r10.insertNoSignalEntry(r0, r1)
            if (r0 != r3) goto L_0x0078
            return r3
        L_0x0078:
            java.lang.Number r0 = (java.lang.Number) r0
            long r10 = r0.longValue()
            r12 = -1
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            int r0 = r8.element
            int r0 = r0 + r5
            r8.element = r0
        L_0x0089:
            int r7 = r7 + r5
            goto L_0x005b
        L_0x008b:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r10 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r11 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NO_SIGNAL_DATA_COLLECTED
            int r0 = r8.element
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r13 = 0
            r14 = 4
            r15 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r10, r11, r12, r13, r14, r15)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository.addNoSignalRecord(com.m2catalyst.m2sdk.business.models.NoSignalData[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object clearNoSignalTable$m2sdk_release(Continuation<? super Unit> continuation) {
        Object clearNoSignalTable = this.noSignalDao.clearNoSignalTable(continuation);
        return clearNoSignalTable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearNoSignalTable : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011a A[LOOP:0: B:60:0x0114->B:62:0x011a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNoSignalRecords$m2sdk_release(java.lang.Long r7, java.lang.Long r8, java.lang.Integer r9, java.lang.Boolean r10, java.lang.Integer r11, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.business.models.NoSignalData>> r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignalRecords$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignalRecords$1 r0 = (com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignalRecords$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignalRecords$1 r0 = new com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignalRecords$1
            r0.<init>(r6, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00fd
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00e9
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = 0
            if (r7 == 0) goto L_0x0045
            java.lang.String r7 = r7.toString()
            goto L_0x0046
        L_0x0045:
            r7 = r12
        L_0x0046:
            java.lang.String r2 = ""
            java.lang.String r5 = "timeStamp >="
            java.lang.String r7 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r7)
            if (r8 == 0) goto L_0x0056
            java.lang.String r8 = r8.toString()
            goto L_0x0057
        L_0x0056:
            r8 = r12
        L_0x0057:
            java.lang.String r2 = "timeStamp <="
            java.lang.String r7 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r8)
            if (r10 == 0) goto L_0x0070
            boolean r8 = r10.booleanValue()
            int r8 = com.m2catalyst.m2sdk.o1.a((boolean) r8)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.lang.String r12 = r8.toString()
        L_0x0070:
            java.lang.String r8 = "transmitted ="
            java.lang.String r7 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r12)
            if (r9 == 0) goto L_0x0082
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "simSlot ="
            com.m2catalyst.m2sdk.c6.a((java.lang.String) r7, (java.lang.String) r9, (java.lang.String) r8)
        L_0x0082:
            r8 = 0
            if (r11 == 0) goto L_0x008d
            int r9 = r11.intValue()
            if (r9 <= 0) goto L_0x008d
            r9 = 1
            goto L_0x008e
        L_0x008d:
            r9 = 0
        L_0x008e:
            int r10 = r7.length()
            if (r10 <= 0) goto L_0x0096
            r10 = 1
            goto L_0x0097
        L_0x0096:
            r10 = 0
        L_0x0097:
            if (r10 != 0) goto L_0x009b
            if (r9 == 0) goto L_0x00ac
        L_0x009b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            java.lang.String r7 = " ORDER BY id ASC"
            r10.append(r7)
            java.lang.String r7 = r10.toString()
        L_0x00ac:
            if (r9 == 0) goto L_0x00c2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r7 = " LIMIT "
            r9.append(r7)
            r9.append(r11)
            java.lang.String r7 = r9.toString()
        L_0x00c2:
            int r9 = r7.length()
            if (r9 <= 0) goto L_0x00c9
            r8 = 1
        L_0x00c9:
            if (r8 == 0) goto L_0x00f2
            com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r8 = r6.noSignalDao
            androidx.sqlite.db.SimpleSQLiteQuery r9 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "SELECT * FROM no_network_signal_tbl WHERE "
            r10.<init>(r11)
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r9.<init>(r7)
            r0.label = r4
            java.lang.Object r12 = r8.getEntriesWithWhereClause(r9, r0)
            if (r12 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            java.util.List r12 = (java.util.List) r12
            if (r12 != 0) goto L_0x0105
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0105
        L_0x00f2:
            com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r7 = r6.noSignalDao
            r0.label = r3
            java.lang.Object r12 = r7.getEntries(r0)
            if (r12 != r1) goto L_0x00fd
            return r1
        L_0x00fd:
            java.util.List r12 = (java.util.List) r12
            if (r12 != 0) goto L_0x0105
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0105:
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r12, r8)
            r7.<init>(r8)
            java.util.Iterator r8 = r12.iterator()
        L_0x0114:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0129
            java.lang.Object r9 = r8.next()
            com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity r9 = (com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity) r9
            com.m2catalyst.m2sdk.business.models.NoSignalData r10 = new com.m2catalyst.m2sdk.business.models.NoSignalData
            r10.<init>(r9)
            r7.add(r10)
            goto L_0x0114
        L_0x0129:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository.getNoSignalRecords$m2sdk_release(java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Boolean, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @w2
    public List<NoSignalData> getNoSignals(Long l, Long l2, Integer num) {
        if (M2SDK.INSTANCE.isAccessible(new NoSignalMNSIRepository$getNoSignals$1(this), this.accessComponent) || getTesting()) {
            return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new NoSignalMNSIRepository$getNoSignals$2(this, l, l2, num, (Continuation<? super NoSignalMNSIRepository$getNoSignals$2>) null), 1, (Object) null);
        }
        return new ArrayList();
    }

    public final Object markNoSignalEntityTransmitted(List<Integer> list, Continuation<? super Unit> continuation) {
        Object a = c6.a(list, new NoSignalMNSIRepository$markNoSignalEntityTransmitted$2(this, (Continuation<? super NoSignalMNSIRepository$markNoSignalEntityTransmitted$2>) null), (Continuation<? super Integer>) continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }
}
