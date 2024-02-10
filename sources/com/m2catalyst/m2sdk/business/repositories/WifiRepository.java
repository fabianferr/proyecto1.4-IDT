package com.m2catalyst.m2sdk.business.repositories;

import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.c6;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.w2;
import com.m2catalyst.m2sdk.y3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b+\u0010,J=\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0003H\u0017J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0017J\u0013\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\tH@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u00020\u00132\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0019\"\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0012\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001dH\u0017J\u0012\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001dH\u0017J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0015R\u0014\u0010&\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u0004\u0018\u00010(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/WifiRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$WifiAvailability;", "", "startDate", "", "transmitted", "", "limit", "", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "getWifiWithLimit", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "getWifiRecordById", "endDate", "getWifi", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWifiRecords", "", "deleteWIfiEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entries", "markWifiEntryTransmitted", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "addWifi", "([Lcom/m2catalyst/m2sdk/business/models/Wifi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addWifiRecord", "Landroidx/lifecycle/MutableLiveData;", "getWifiLiveData", "getWifiConnectedLiveData", "Lcom/m2catalyst/m2sdk/y3;", "wifiDataUsage", "updatePrevRecordDataUsage", "(Lcom/m2catalyst/m2sdk/y3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastWifiEntry", "Lcom/m2catalyst/m2sdk/database/daos/WifiDao;", "wifiDao", "Lcom/m2catalyst/m2sdk/database/daos/WifiDao;", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "<init>", "(Lcom/m2catalyst/m2sdk/database/daos/WifiDao;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: WifiRepository.kt */
public final class WifiRepository extends BaseRepository implements DataAvailability.WifiAvailability {
    private static final String CONNECTIVITY_LOGS = "CONNECTIVITY_LOGS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final l2 accessComponent;
    /* access modifiers changed from: private */
    public final WifiDao wifiDao;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/WifiRepository$Companion;", "", "()V", "CONNECTIVITY_LOGS", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WifiRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WifiRepository(com.m2catalyst.m2sdk.database.daos.WifiDao r2) {
        /*
            r1 = this;
            java.lang.String r0 = "wifiDao"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.wifiDao = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            if (r2 == 0) goto L_0x0020
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0020
            com.m2catalyst.m2sdk.l2 r2 = r2.g()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r1.accessComponent = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.WifiRepository.<init>(com.m2catalyst.m2sdk.database.daos.WifiDao):void");
    }

    public static /* synthetic */ Object getWifiWithLimit$default(WifiRepository wifiRepository, Long l, Boolean bool, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        return wifiRepository.getWifiWithLimit(l, bool, num, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addWifi(com.m2catalyst.m2sdk.business.models.Wifi[] r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.WifiRepository$addWifi$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$addWifi$1 r1 = (com.m2catalyst.m2sdk.business.repositories.WifiRepository$addWifi$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$addWifi$1 r1 = new com.m2catalyst.m2sdk.business.repositories.WifiRepository$addWifi$1
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
            com.m2catalyst.m2sdk.business.models.Wifi[] r7 = (com.m2catalyst.m2sdk.business.models.Wifi[]) r7
            java.lang.Object r8 = r1.L$1
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r1.L$0
            com.m2catalyst.m2sdk.business.repositories.WifiRepository r9 = (com.m2catalyst.m2sdk.business.repositories.WifiRepository) r9
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
            com.m2catalyst.m2sdk.database.daos.WifiDao r10 = r9.wifiDao
            com.m2catalyst.m2sdk.database.entities.WifiEntity r0 = r0.getEntity$m2sdk_release()
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r4
            r1.I$0 = r7
            r1.I$1 = r6
            r1.label = r5
            java.lang.Object r0 = r10.addWifiEntry(r0, r1)
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
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r11 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.WIFI_COLLECTED
            int r0 = r8.element
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r13 = 0
            r14 = 4
            r15 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r10, r11, r12, r13, r14, r15)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.WifiRepository.addWifi(com.m2catalyst.m2sdk.business.models.Wifi[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void addWifiRecord(Wifi wifi) {
        Intrinsics.checkNotNullParameter(wifi, "entries");
        if (M2SDK.INSTANCE.isAccessible(new WifiRepository$addWifiRecord$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new WifiRepository$addWifiRecord$2(this, wifi, (Continuation<? super WifiRepository$addWifiRecord$2>) null), 1, (Object) null);
        }
    }

    public final Object deleteWIfiEntries(Continuation<? super Unit> continuation) {
        Object deleteWifiEntries = this.wifiDao.deleteWifiEntries(continuation);
        return deleteWifiEntries == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteWifiEntries : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLastWifiEntry(kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.Wifi> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.m2catalyst.m2sdk.business.repositories.WifiRepository$getLastWifiEntry$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getLastWifiEntry$1 r0 = (com.m2catalyst.m2sdk.business.repositories.WifiRepository$getLastWifiEntry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getLastWifiEntry$1 r0 = new com.m2catalyst.m2sdk.business.repositories.WifiRepository$getLastWifiEntry$1
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
            com.m2catalyst.m2sdk.database.daos.WifiDao r5 = r4.wifiDao
            r0.label = r3
            java.lang.Object r5 = r5.getLastWifiInfo(r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.database.entities.WifiEntity r5 = (com.m2catalyst.m2sdk.database.entities.WifiEntity) r5
            if (r5 == 0) goto L_0x0049
            com.m2catalyst.m2sdk.business.models.Wifi r0 = new com.m2catalyst.m2sdk.business.models.Wifi
            r0.<init>(r5)
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.WifiRepository.getLastWifiEntry(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getWifi(long r5, long r7, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.business.models.Wifi>> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifi$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifi$1 r0 = (com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifi$1 r0 = new com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifi$1
            r0.<init>(r4, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r9)
            com.m2catalyst.m2sdk.database.daos.WifiDao r9 = r4.wifiDao
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = java.lang.String.valueOf(r7)
            r0.label = r3
            java.lang.Object r9 = r9.getWifiInfoEntries(r5, r6, r0)
            if (r9 != r1) goto L_0x0047
            return r1
        L_0x0047:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x006f
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r6)
            r5.<init>(r6)
            java.util.Iterator r6 = r9.iterator()
        L_0x005a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0074
            java.lang.Object r7 = r6.next()
            com.m2catalyst.m2sdk.database.entities.WifiEntity r7 = (com.m2catalyst.m2sdk.database.entities.WifiEntity) r7
            com.m2catalyst.m2sdk.business.models.Wifi r8 = new com.m2catalyst.m2sdk.business.models.Wifi
            r8.<init>(r7)
            r5.add(r8)
            goto L_0x005a
        L_0x006f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0074:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.WifiRepository.getWifi(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @w2
    public MutableLiveData<Boolean> getWifiConnectedLiveData() {
        if (M2SDK.INSTANCE.isAccessible(new WifiRepository$getWifiConnectedLiveData$1(this), this.accessComponent)) {
            return SDKState.Companion.getInstance().getWifiConnectedLiveData$m2sdk_release();
        }
        return null;
    }

    @w2
    public MutableLiveData<Wifi> getWifiLiveData() {
        if (M2SDK.INSTANCE.isAccessible(new WifiRepository$getWifiLiveData$1(this), this.accessComponent)) {
            return SDKState.Companion.getInstance().getCompleteWifiLiveData$m2sdk_release();
        }
        return null;
    }

    @w2
    public Wifi getWifiRecordById(long j) {
        if (M2SDK.INSTANCE.isAccessible(new WifiRepository$getWifiRecordById$1(this), this.accessComponent) || getTesting()) {
            return (Wifi) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new WifiRepository$getWifiRecordById$2(this, j, (Continuation<? super WifiRepository$getWifiRecordById$2>) null), 1, (Object) null);
        }
        return null;
    }

    @w2
    public List<Wifi> getWifiRecords(long j, long j2) {
        if (M2SDK.INSTANCE.isAccessible(new WifiRepository$getWifiRecords$1(this), this.accessComponent) || getTesting()) {
            return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new WifiRepository$getWifiRecords$2(this, j, j2, (Continuation<? super WifiRepository$getWifiRecords$2>) null), 1, (Object) null);
        }
        return new ArrayList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0150 A[LOOP:0: B:53:0x014a->B:55:0x0150, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getWifiWithLimit(java.lang.Long r19, java.lang.Boolean r20, java.lang.Integer r21, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.business.models.Wifi>> r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            boolean r5 = r4 instanceof com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiWithLimit$1
            if (r5 == 0) goto L_0x001d
            r5 = r4
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiWithLimit$1 r5 = (com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiWithLimit$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.label = r6
            goto L_0x0022
        L_0x001d:
            com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiWithLimit$1 r5 = new com.m2catalyst.m2sdk.business.repositories.WifiRepository$getWifiWithLimit$1
            r5.<init>(r0, r4)
        L_0x0022:
            java.lang.Object r4 = r5.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r7 = r5.label
            r8 = 2
            r9 = 1
            if (r7 == 0) goto L_0x007a
            if (r7 == r9) goto L_0x005a
            if (r7 != r8) goto L_0x0052
            java.lang.Object r1 = r5.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.L$2
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r5.L$1
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            java.lang.Object r5 = r5.L$0
            java.lang.Long r5 = (java.lang.Long) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r16 = r4
            r4 = r1
            r1 = r5
            r5 = r16
            r17 = r3
            r3 = r2
            r2 = r17
            goto L_0x0133
        L_0x0052:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x005a:
            java.lang.Object r1 = r5.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.L$2
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r5.L$1
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            java.lang.Object r5 = r5.L$0
            java.lang.Long r5 = (java.lang.Long) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r16 = r4
            r4 = r1
            r1 = r5
            r5 = r16
            r17 = r3
            r3 = r2
            r2 = r17
            goto L_0x0117
        L_0x007a:
            kotlin.ResultKt.throwOnFailure(r4)
            r4 = 0
            if (r1 == 0) goto L_0x0085
            java.lang.String r7 = r19.toString()
            goto L_0x0086
        L_0x0085:
            r7 = r4
        L_0x0086:
            java.lang.String r10 = ""
            java.lang.String r11 = "time_stamp >="
            java.lang.String r7 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r7)
            if (r2 == 0) goto L_0x00a1
            boolean r4 = r20.booleanValue()
            int r4 = com.m2catalyst.m2sdk.o1.a((boolean) r4)
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r4 = r4.toString()
        L_0x00a1:
            java.lang.String r10 = "transmitted ="
            java.lang.String r4 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r7, (java.lang.String) r10, (java.lang.String) r4)
            r7 = 0
            if (r3 == 0) goto L_0x00b3
            int r10 = r21.intValue()
            if (r10 <= 0) goto L_0x00b3
            r10 = 1
            goto L_0x00b4
        L_0x00b3:
            r10 = 0
        L_0x00b4:
            int r11 = r4.length()
            if (r11 <= 0) goto L_0x00bc
            r11 = 1
            goto L_0x00bd
        L_0x00bc:
            r11 = 0
        L_0x00bd:
            if (r11 != 0) goto L_0x00c1
            if (r10 == 0) goto L_0x00d2
        L_0x00c1:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            java.lang.String r4 = " ORDER BY id ASC"
            r11.append(r4)
            java.lang.String r4 = r11.toString()
        L_0x00d2:
            if (r10 == 0) goto L_0x00e8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            java.lang.String r4 = " LIMIT "
            r10.append(r4)
            r10.append(r3)
            java.lang.String r4 = r10.toString()
        L_0x00e8:
            int r10 = r4.length()
            if (r10 <= 0) goto L_0x00ef
            r7 = 1
        L_0x00ef:
            if (r7 == 0) goto L_0x0120
            com.m2catalyst.m2sdk.database.daos.WifiDao r7 = r0.wifiDao
            androidx.sqlite.db.SimpleSQLiteQuery r8 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "SELECT * FROM wifi_tbl WHERE "
            r10.<init>(r11)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            r8.<init>(r10)
            r5.L$0 = r1
            r5.L$1 = r2
            r5.L$2 = r3
            r5.L$3 = r4
            r5.label = r9
            java.lang.Object r5 = r7.getWifiInfoWhereClause(r8, r5)
            if (r5 != r6) goto L_0x0117
            return r6
        L_0x0117:
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x013b
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x013b
        L_0x0120:
            com.m2catalyst.m2sdk.database.daos.WifiDao r7 = r0.wifiDao
            r5.L$0 = r1
            r5.L$1 = r2
            r5.L$2 = r3
            r5.L$3 = r4
            r5.label = r8
            java.lang.Object r5 = r7.getWifiInfo(r5)
            if (r5 != r6) goto L_0x0133
            return r6
        L_0x0133:
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x013b
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L_0x013b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r7)
            r6.<init>(r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x014a:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x015f
            java.lang.Object r7 = r5.next()
            com.m2catalyst.m2sdk.database.entities.WifiEntity r7 = (com.m2catalyst.m2sdk.database.entities.WifiEntity) r7
            com.m2catalyst.m2sdk.business.models.Wifi r8 = new com.m2catalyst.m2sdk.business.models.Wifi
            r8.<init>(r7)
            r6.add(r8)
            goto L_0x014a
        L_0x015f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r9 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r5 = r6.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Connectivity Wifi query for startDate="
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r1 = ", transmitted="
            r7.append(r1)
            r7.append(r2)
            java.lang.String r1 = ", limit="
            r7.append(r1)
            r7.append(r3)
            java.lang.String r1 = " returned "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = " entries\nClause: "
            r7.append(r1)
            r7.append(r4)
            java.lang.String r11 = r7.toString()
            java.lang.String r10 = "CONNECTIVITY_LOGS"
            r12 = 0
            r13 = 0
            r14 = 12
            r15 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r9, r10, r11, r12, r13, r14, r15)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.WifiRepository.getWifiWithLimit(java.lang.Long, java.lang.Boolean, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object markWifiEntryTransmitted(List<Integer> list, Continuation<? super Unit> continuation) {
        Object a = c6.a(list, new WifiRepository$markWifiEntryTransmitted$2(this, (Continuation<? super WifiRepository$markWifiEntryTransmitted$2>) null), (Continuation<? super Integer>) continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    public final Object updatePrevRecordDataUsage(y3 y3Var, Continuation<? super Unit> continuation) {
        Object updateLastRecordsDataUsage = this.wifiDao.updateLastRecordsDataUsage(y3Var.c, y3Var.b, continuation);
        return updateLastRecordsDataUsage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateLastRecordsDataUsage : Unit.INSTANCE;
    }
}
