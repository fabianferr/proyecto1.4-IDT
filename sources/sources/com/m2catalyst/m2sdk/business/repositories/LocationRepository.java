package com.m2catalyst.m2sdk.business.repositories;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.a2;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceBatteryLogsResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.VerifyApiKeyResponseMessage;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.u1;
import com.m2catalyst.m2sdk.w2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\bK\u0010LJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J#\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015\"\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0017J\u0012\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001dH\u0017J'\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J=\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0013\u0010(\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010/\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*H\u0000¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b0\u0010)J\u0015\u00102\u001a\u0004\u0018\u000101H@ø\u0001\u0000¢\u0006\u0004\b2\u0010)J\u0013\u00103\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b3\u0010)J\u0013\u00104\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b4\u0010)R\u0014\u00106\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020+8\u0002XD¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u0004\u0018\u00010F8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010J\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/LocationRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$LocationDataAvailability;", "", "deleteLocationFilesAfterTwoWeeks", "setUnitTestMode", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiResponseMessage;", "returnDummyResponseForUnitTesting", "Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;", "data", "", "addLocationEntry", "(Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "entries", "addLocationList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "locationId", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "getM2LocationById", "", "addM2Locations", "([Lcom/m2catalyst/m2sdk/business/models/M2Location;)V", "startDate", "endDate", "getLocations", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getM2Locations", "Landroidx/lifecycle/MutableLiveData;", "getM2LocationLiveData", "startId", "endId", "markLocationAsTransmitted", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "transmitted", "limit", "getLocationsWithLimit", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitLocationLogs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "", "getLocationFiles$m2sdk_release", "()Ljava/util/Map;", "getLocationFiles", "buildAndSubmit", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiRequestMessage;", "buildLocationLogsPacket", "deleteLocationEntries", "clearLocationEntries", "Lcom/m2catalyst/m2sdk/database/daos/LocationDao;", "locationDao", "Lcom/m2catalyst/m2sdk/database/daos/LocationDao;", "Lcom/m2catalyst/m2sdk/u1;", "locationApiClient", "Lcom/m2catalyst/m2sdk/u1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "transmitLogger", "Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "TAG", "Ljava/lang/String;", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "Lcom/m2catalyst/m2sdk/r2;", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "locationPacketBeingCreated", "Z", "<init>", "(Lcom/m2catalyst/m2sdk/database/daos/LocationDao;Lcom/m2catalyst/m2sdk/u1;Landroid/content/Context;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: LocationRepository.kt */
public final class LocationRepository extends BaseRepository implements DataAvailability.LocationDataAvailability {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG_LOCATION_LOGS = "LOCATION_LOGS";
    private static boolean unitTestMode;
    private final String TAG = "LocationRepository";
    private final l2 accessComponent;
    private final r2 configuration = r2.a.a();
    private final Context context;
    private final u1 locationApiClient;
    /* access modifiers changed from: private */
    public final LocationDao locationDao;
    private boolean locationPacketBeingCreated;
    private final M2SDKLogger transmitLogger = M2SDKLogger.Companion.getLogger("TRANSMISSION");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/LocationRepository$Companion;", "", "()V", "TAG_LOCATION_LOGS", "", "unitTestMode", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LocationRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0036, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRepository(com.m2catalyst.m2sdk.database.daos.LocationDao r2, com.m2catalyst.m2sdk.u1 r3, android.content.Context r4) {
        /*
            r1 = this;
            java.lang.String r0 = "locationDao"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "locationApiClient"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r1.<init>()
            r1.locationDao = r2
            r1.locationApiClient = r3
            r1.context = r4
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "TRANSMISSION"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r3)
            r1.transmitLogger = r2
            java.lang.String r2 = "LocationRepository"
            r1.TAG = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            r1.configuration = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            if (r2 == 0) goto L_0x0041
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0041
            com.m2catalyst.m2sdk.l2 r2 = r2.b()
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            r1.accessComponent = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.<init>(com.m2catalyst.m2sdk.database.daos.LocationDao, com.m2catalyst.m2sdk.u1, android.content.Context):void");
    }

    private final void deleteLocationFilesAfterTwoWeeks() {
        a2.a(this.context, TAG_LOCATION_LOGS);
    }

    public static /* synthetic */ Object getLocationsWithLimit$default(LocationRepository locationRepository, Long l, Boolean bool, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        return locationRepository.getLocationsWithLimit(l, bool, num, continuation);
    }

    public static /* synthetic */ Object markLocationAsTransmitted$default(LocationRepository locationRepository, int i, Integer num, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return locationRepository.markLocationAsTransmitted(i, num, continuation);
    }

    private final ApiResponseMessage returnDummyResponseForUnitTesting() {
        Boolean bool = Boolean.TRUE;
        return new ApiResponseMessage(bool, "Message", (SyncDeviceResponseMessage) null, (VerifyApiKeyResponseMessage) null, 123456L, bool, 42, (DeviceBatteryLogsResponseMessage) null, (LocationInfoResponseMessage) null, (NetworkInfoResponseMessage) null);
    }

    private final void setUnitTestMode() {
        unitTestMode = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addLocationEntry(com.m2catalyst.m2sdk.database.entities.LocationEntity r11, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationEntry$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationEntry$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationEntry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationEntry$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationEntry$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r12)
            com.m2catalyst.m2sdk.database.daos.LocationDao r12 = r10.locationDao
            r0.label = r3
            java.lang.Object r12 = r12.addLocationEntry(r11, r0)
            if (r12 != r1) goto L_0x003f
            return r1
        L_0x003f:
            java.lang.Number r12 = (java.lang.Number) r12
            long r11 = r12.longValue()
            r0 = -1
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0059
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.LOCATION_COLLECTED
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
        L_0x0059:
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.addLocationEntry(com.m2catalyst.m2sdk.database.entities.LocationEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addLocationList(java.util.List<com.m2catalyst.m2sdk.database.entities.LocationEntity> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationList$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationList$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationList$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$addLocationList$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r2 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Iterator r5 = r5.iterator()
            r2 = r4
        L_0x0041:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005a
            java.lang.Object r6 = r5.next()
            com.m2catalyst.m2sdk.database.entities.LocationEntity r6 = (com.m2catalyst.m2sdk.database.entities.LocationEntity) r6
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.addLocationEntry(r6, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x005a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.addLocationList(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void addM2Locations(M2Location... m2LocationArr) {
        Intrinsics.checkNotNullParameter(m2LocationArr, "entries");
        if (M2SDK.INSTANCE.isAccessible(new LocationRepository$addM2Locations$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LocationRepository$addM2Locations$2(this, m2LocationArr, (Continuation<? super LocationRepository$addM2Locations$2>) null), 1, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildAndSubmit(kotlin.coroutines.Continuation<? super java.lang.Long> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildAndSubmit$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildAndSubmit$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildAndSubmit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildAndSubmit$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildAndSubmit$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006d
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r2 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0061
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r9 = r8.transmitLogger
            java.lang.String r2 = r8.TAG
            java.lang.String[] r6 = new java.lang.String[r4]
            java.lang.String r7 = "buildAndSubmit()"
            r9.i(r2, r7, r6)
            boolean r9 = r8.locationPacketBeingCreated
            if (r9 != 0) goto L_0x0078
            r8.locationPacketBeingCreated = r5
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r8.buildLocationLogsPacket(r0)
            if (r9 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r2 = r8
        L_0x0061:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r2.submitLocationLogs(r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r0 = r2
        L_0x006d:
            r0.locationPacketBeingCreated = r4
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            goto L_0x0079
        L_0x0078:
            r9 = 0
        L_0x0079:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.buildAndSubmit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.m2catalyst.m2sdk.business.repositories.LocationRepository} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildLocationLogsPacket(kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage> r23) {
        /*
            r22 = this;
            r8 = r22
            r0 = r23
            java.lang.String r9 = " and saved into file named "
            java.lang.String r10 = " were converted into byte array size "
            boolean r1 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildLocationLogsPacket$1
            if (r1 == 0) goto L_0x001b
            r1 = r0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildLocationLogsPacket$1 r1 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildLocationLogsPacket$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001b
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x0020
        L_0x001b:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildLocationLogsPacket$1 r1 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$buildLocationLogsPacket$1
            r1.<init>(r8, r0)
        L_0x0020:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r12 = 2
            r13 = 1
            r14 = 0
            if (r2 == 0) goto L_0x0059
            if (r2 == r13) goto L_0x004d
            if (r2 != r12) goto L_0x0045
            java.lang.Object r2 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r2 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage) r2
            java.lang.Object r0 = r0.L$0
            r3 = r0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r3 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r3
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ Exception -> 0x0040 }
            goto L_0x01b1
        L_0x0040:
            r0 = move-exception
            r18 = r0
            goto L_0x0187
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            java.lang.Object r2 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage$Builder r2 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage.Builder) r2
            java.lang.Object r3 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r3 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x007c
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.r2 r1 = r8.configuration
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage$Builder r15 = com.m2catalyst.m2sdk.n3.a(r1)
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            r0.L$0 = r8
            r0.L$1 = r15
            r0.label = r13
            r2 = 0
            r4 = 0
            r6 = 5
            r7 = 0
            r1 = r22
            r5 = r0
            java.lang.Object r1 = getLocationsWithLimit$default(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != r11) goto L_0x007a
            return r11
        L_0x007a:
            r3 = r8
            r2 = r15
        L_0x007c:
            java.util.List r1 = (java.util.List) r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = r3.TAG
            int r6 = r1.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r15 = "buildLocationLogsPacket with "
            r7.<init>(r15)
            r7.append(r6)
            java.lang.String r6 = " logs"
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r12 = new java.lang.String[r14]
            r4.d(r5, r7, r12)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r3.transmitLogger
            java.lang.String r5 = r3.TAG
            int r7 = r1.size()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r15)
            r12.append(r7)
            r12.append(r6)
            java.lang.String r6 = r12.toString()
            java.lang.String[] r7 = new java.lang.String[r14]
            r4.d(r5, r6, r7)
            boolean r4 = r1.isEmpty()
            r4 = r4 ^ r13
            if (r4 == 0) goto L_0x01b2
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoMessage$Builder r4 = new com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoMessage$Builder
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)
            r5.<init>(r6)
            java.util.Iterator r6 = r1.iterator()
        L_0x00d5:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00e9
            java.lang.Object r7 = r6.next()
            com.m2catalyst.m2sdk.database.entities.LocationEntity r7 = (com.m2catalyst.m2sdk.database.entities.LocationEntity) r7
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationLogMessage r7 = r7.toMessage()
            r5.add(r7)
            goto L_0x00d5
        L_0x00e9:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoMessage$Builder r4 = r4.location_logs(r5)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoMessage r4 = r4.build()
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage$Builder r2 = r2.location_info(r4)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r2 = r2.build()
            com.squareup.wire.ProtoAdapter<com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage> r4 = com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage.ADAPTER
            byte[] r4 = r4.encode(r2)
            android.content.Context r5 = r3.context     // Catch:{ Exception -> 0x0040 }
            java.lang.String r6 = "LOCATION_LOGS"
            java.lang.String r5 = com.m2catalyst.m2sdk.a2.a(r4, r5, r6, new java.util.Random().nextInt(100000), 0)     // Catch:{ Exception -> 0x0040 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r6 = r3.transmitLogger     // Catch:{ Exception -> 0x0040 }
            java.lang.String r7 = r3.TAG     // Catch:{ Exception -> 0x0040 }
            int r12 = r1.size()     // Catch:{ Exception -> 0x0040 }
            int r13 = r4.length     // Catch:{ Exception -> 0x0040 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r15.<init>()     // Catch:{ Exception -> 0x0040 }
            r15.append(r12)     // Catch:{ Exception -> 0x0040 }
            r15.append(r10)     // Catch:{ Exception -> 0x0040 }
            r15.append(r13)     // Catch:{ Exception -> 0x0040 }
            r15.append(r9)     // Catch:{ Exception -> 0x0040 }
            r15.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r12 = r15.toString()     // Catch:{ Exception -> 0x0040 }
            java.lang.String[] r13 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0040 }
            r6.i(r7, r12, r13)     // Catch:{ Exception -> 0x0040 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ Exception -> 0x0040 }
            java.lang.String r16 = "LOCATION_LOGS"
            int r6 = r1.size()     // Catch:{ Exception -> 0x0040 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0040 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r7.<init>()     // Catch:{ Exception -> 0x0040 }
            r7.append(r6)     // Catch:{ Exception -> 0x0040 }
            r7.append(r10)     // Catch:{ Exception -> 0x0040 }
            r7.append(r4)     // Catch:{ Exception -> 0x0040 }
            r7.append(r9)     // Catch:{ Exception -> 0x0040 }
            r7.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r17 = r7.toString()     // Catch:{ Exception -> 0x0040 }
            r18 = 0
            r19 = 0
            r20 = 12
            r21 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r1)     // Catch:{ Exception -> 0x0040 }
            com.m2catalyst.m2sdk.database.entities.LocationEntity r4 = (com.m2catalyst.m2sdk.database.entities.LocationEntity) r4     // Catch:{ Exception -> 0x0040 }
            if (r4 == 0) goto L_0x0166
            int r4 = r4.getId()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0167
        L_0x0166:
            r4 = 0
        L_0x0167:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.lastOrNull(r1)     // Catch:{ Exception -> 0x0040 }
            com.m2catalyst.m2sdk.database.entities.LocationEntity r1 = (com.m2catalyst.m2sdk.database.entities.LocationEntity) r1     // Catch:{ Exception -> 0x0040 }
            if (r1 == 0) goto L_0x0174
            int r1 = r1.getId()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0175
        L_0x0174:
            r1 = 0
        L_0x0175:
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)     // Catch:{ Exception -> 0x0040 }
            r0.L$0 = r3     // Catch:{ Exception -> 0x0040 }
            r0.L$1 = r2     // Catch:{ Exception -> 0x0040 }
            r5 = 2
            r0.label = r5     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r0 = r3.markLocationAsTransmitted(r4, r1, r0)     // Catch:{ Exception -> 0x0040 }
            if (r0 != r11) goto L_0x01b1
            return r11
        L_0x0187:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r3.transmitLogger
            java.lang.String r1 = r3.TAG
            java.lang.String r3 = r18.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Error writing Location Logs packet to file "
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String[] r4 = new java.lang.String[r14]
            r0.e(r1, r3, r4)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r16 = "Save file to filesystem"
            java.lang.String r17 = "Error writing Location Logs packet to file"
            r19 = 0
            r20 = 8
            r21 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r15, r16, r17, r18, r19, r20, r21)
        L_0x01b1:
            return r2
        L_0x01b2:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r9 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r10 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.BUILD_LOCATION_PACKET_COUNT_RECORDS
            int r0 = r1.size()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r12 = 0
            r13 = 4
            r14 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r9, r10, r11, r12, r13, r14)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.buildLocationLogsPacket(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearLocationEntries(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$clearLocationEntries$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$clearLocationEntries$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$clearLocationEntries$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$clearLocationEntries$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$clearLocationEntries$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            com.m2catalyst.m2sdk.database.daos.LocationDao r10 = r9.locationDao
            r0.label = r3
            java.lang.Object r10 = r10.clearLocationTable(r0)
            if (r10 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "LOCATION_LOGS"
            java.lang.String r4 = "Clearing location entries from database"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.clearLocationEntries(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteLocationEntries(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$deleteLocationEntries$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$deleteLocationEntries$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$deleteLocationEntries$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$deleteLocationEntries$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$deleteLocationEntries$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            com.m2catalyst.m2sdk.database.daos.LocationDao r10 = r9.locationDao
            r0.label = r3
            java.lang.Object r10 = r10.deleteLocationEntries(r0)
            if (r10 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "LOCATION_LOGS"
            java.lang.String r4 = "Deleting location entries from database"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.deleteLocationEntries(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Map<String, byte[]> getLocationFiles$m2sdk_release() {
        return a2.b(this.context, TAG_LOCATION_LOGS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLocations(long r9, long r11, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.business.models.M2Location>> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocations$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocations$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocations$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocations$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocations$1
            r0.<init>(r8, r13)
        L_0x0018:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            long r11 = r6.J$1
            long r9 = r6.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x004a
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r13)
            com.m2catalyst.m2sdk.database.daos.LocationDao r1 = r8.locationDao
            r6.J$0 = r9
            r6.J$1 = r11
            r6.label = r2
            r2 = r9
            r4 = r11
            java.lang.Object r13 = r1.getLocationsBetweenDates(r2, r4, r6)
            if (r13 != r0) goto L_0x004a
            return r0
        L_0x004a:
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x0071
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r1)
            r0.<init>(r1)
            java.util.Iterator r13 = r13.iterator()
        L_0x005d:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0075
            java.lang.Object r1 = r13.next()
            com.m2catalyst.m2sdk.database.entities.LocationEntity r1 = (com.m2catalyst.m2sdk.database.entities.LocationEntity) r1
            com.m2catalyst.m2sdk.business.models.M2Location r1 = r1.toBusiness()
            r0.add(r1)
            goto L_0x005d
        L_0x0071:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0075:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r13 = r0.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Location query for params startdate="
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = ", endDate="
            r2.append(r9)
            r2.append(r11)
            java.lang.String r9 = " returned "
            r2.append(r9)
            r2.append(r13)
            java.lang.String r9 = " entries"
            r2.append(r9)
            java.lang.String r3 = r2.toString()
            java.lang.String r2 = "LOCATION_LOGS"
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.getLocations(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLocationsWithLimit(java.lang.Long r8, java.lang.Boolean r9, java.lang.Integer r10, kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.database.entities.LocationEntity>> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocationsWithLimit$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocationsWithLimit$1 r0 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocationsWithLimit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocationsWithLimit$1 r0 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$getLocationsWithLimit$1
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r8 = r0.L$2
            r10 = r8
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            java.lang.Object r8 = r0.L$0
            java.lang.Long r8 = (java.lang.Long) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x010b
        L_0x003b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0043:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            java.lang.Object r8 = r0.L$0
            java.lang.Long r8 = (java.lang.Long) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00f1
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            if (r8 == 0) goto L_0x0061
            java.lang.String r2 = r8.toString()
            goto L_0x0062
        L_0x0061:
            r2 = r11
        L_0x0062:
            java.lang.String r5 = ""
            java.lang.String r6 = "timeStamp >="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r2)
            if (r9 == 0) goto L_0x007d
            boolean r11 = r9.booleanValue()
            int r11 = com.m2catalyst.m2sdk.o1.a((boolean) r11)
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            java.lang.String r11 = r11.toString()
        L_0x007d:
            java.lang.String r5 = "transmitted ="
            java.lang.String r11 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r11)
            r2 = 0
            if (r10 == 0) goto L_0x008f
            int r5 = r10.intValue()
            if (r5 <= 0) goto L_0x008f
            r5 = 1
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            int r6 = r11.length()
            if (r6 <= 0) goto L_0x0098
            r6 = 1
            goto L_0x0099
        L_0x0098:
            r6 = 0
        L_0x0099:
            if (r6 != 0) goto L_0x009d
            if (r5 == 0) goto L_0x00ae
        L_0x009d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            java.lang.String r11 = " ORDER BY id ASC"
            r6.append(r11)
            java.lang.String r11 = r6.toString()
        L_0x00ae:
            if (r5 == 0) goto L_0x00c4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            java.lang.String r11 = " LIMIT "
            r5.append(r11)
            r5.append(r10)
            java.lang.String r11 = r5.toString()
        L_0x00c4:
            int r5 = r11.length()
            if (r5 <= 0) goto L_0x00cb
            r2 = 1
        L_0x00cb:
            if (r2 == 0) goto L_0x00fa
            androidx.sqlite.db.SimpleSQLiteQuery r2 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "SELECT * FROM location_tbl WHERE "
            r3.<init>(r5)
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            r2.<init>(r11)
            com.m2catalyst.m2sdk.database.daos.LocationDao r11 = r7.locationDao
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r11.getLocationWithWHereClause(r2, r0)
            if (r11 != r1) goto L_0x00f1
            return r1
        L_0x00f1:
            java.util.List r11 = (java.util.List) r11
            if (r11 != 0) goto L_0x0113
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0113
        L_0x00fa:
            com.m2catalyst.m2sdk.database.daos.LocationDao r11 = r7.locationDao
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r11 = r11.getLocations(r0)
            if (r11 != r1) goto L_0x010b
            return r1
        L_0x010b:
            java.util.List r11 = (java.util.List) r11
            if (r11 != 0) goto L_0x0113
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0113:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r1 = r11.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Location query for params startdate="
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r8 = ", transmitted="
            r2.append(r8)
            r2.append(r9)
            java.lang.String r8 = ", limit="
            r2.append(r8)
            r2.append(r10)
            java.lang.String r8 = " returned "
            r2.append(r8)
            r2.append(r1)
            java.lang.String r8 = " entries"
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = "LOCATION_LOGS"
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r0, r1, r2, r3, r4, r5, r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.getLocationsWithLimit(java.lang.Long, java.lang.Boolean, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @w2
    public M2Location getM2LocationById(int i) {
        if (M2SDK.INSTANCE.isAccessible(new LocationRepository$getM2LocationById$1(this), this.accessComponent) || getTesting()) {
            return (M2Location) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LocationRepository$getM2LocationById$2(this, i, (Continuation<? super LocationRepository$getM2LocationById$2>) null), 1, (Object) null);
        }
        return null;
    }

    @w2
    public MutableLiveData<M2Location> getM2LocationLiveData() {
        if (M2SDK.INSTANCE.isAccessible(new LocationRepository$getM2LocationLiveData$1(this), this.accessComponent)) {
            return SDKState.Companion.getInstance().getM2LocationLiveData$m2sdk_release();
        }
        return null;
    }

    @w2
    public List<M2Location> getM2Locations(long j, long j2) {
        if (M2SDK.INSTANCE.isAccessible(new LocationRepository$getM2Locations$1(this), this.accessComponent) || getTesting()) {
            return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LocationRepository$getM2Locations$2(this, j, j2, (Continuation<? super LocationRepository$getM2Locations$2>) null), 1, (Object) null);
        }
        return new ArrayList();
    }

    public final Object markLocationAsTransmitted(int i, Integer num, Continuation<? super Unit> continuation) {
        Object markLocationAsTransmitted = this.locationDao.markLocationAsTransmitted(i, num != null ? num.intValue() : i, continuation);
        return markLocationAsTransmitted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? markLocationAsTransmitted : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0117 A[Catch:{ all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a A[Catch:{ all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0121 A[Catch:{ all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0183 A[Catch:{ all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitLocationLogs(kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            java.lang.String r2 = "Submitted location packet, with packets accepted: "
            java.lang.String r3 = "Error submitting location logs packet - "
            java.lang.String r4 = "response "
            boolean r5 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.LocationRepository$submitLocationLogs$1
            if (r5 == 0) goto L_0x001d
            r5 = r0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$submitLocationLogs$1 r5 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository$submitLocationLogs$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.label = r6
            goto L_0x0022
        L_0x001d:
            com.m2catalyst.m2sdk.business.repositories.LocationRepository$submitLocationLogs$1 r5 = new com.m2catalyst.m2sdk.business.repositories.LocationRepository$submitLocationLogs$1
            r5.<init>(r1, r0)
        L_0x0022:
            java.lang.Object r0 = r5.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r7 = r5.label
            r8 = 1
            java.lang.String r9 = "LOCATION_LOGS"
            r10 = 0
            if (r7 == 0) goto L_0x0051
            if (r7 != r8) goto L_0x0049
            java.lang.Object r7 = r5.L$3
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r11 = r5.L$2
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r5.L$1
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r5.L$0
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r13 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0046 }
            goto L_0x00a8
        L_0x0046:
            r0 = move-exception
            goto L_0x01b9
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r0)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r1.transmitLogger
            java.lang.String r7 = r1.TAG
            java.lang.String[] r11 = new java.lang.String[r10]
            java.lang.String r12 = "submitLocationLogs"
            r0.i(r7, r12, r11)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r7 = new java.lang.String[r10]
            r0.d(r9, r12, r7)
            r23.deleteLocationFilesAfterTwoWeeks()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Map r7 = r23.getLocationFiles$m2sdk_release()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
            r12 = r0
            r13 = r1
            r11 = r7
        L_0x007e:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01f1
            java.lang.Object r0 = r11.next()
            r7 = r0
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            boolean r0 = unitTestMode     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x00ba
            com.m2catalyst.m2sdk.u1 r0 = r13.locationApiClient     // Catch:{ all -> 0x0046 }
            java.lang.Object r14 = r7.getValue()     // Catch:{ all -> 0x0046 }
            byte[] r14 = (byte[]) r14     // Catch:{ all -> 0x0046 }
            r5.L$0 = r13     // Catch:{ all -> 0x0046 }
            r5.L$1 = r12     // Catch:{ all -> 0x0046 }
            r5.L$2 = r11     // Catch:{ all -> 0x0046 }
            r5.L$3 = r7     // Catch:{ all -> 0x0046 }
            r5.label = r8     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.a(r14, r5)     // Catch:{ all -> 0x0046 }
            if (r0 != r6) goto L_0x00a8
            return r6
        L_0x00a8:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r0     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r14 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r15 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_LOCATION_PACKET_SENT     // Catch:{ all -> 0x0046 }
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0046 }
            goto L_0x00be
        L_0x00ba:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = r13.returnDummyResponseForUnitTesting()     // Catch:{ all -> 0x0046 }
        L_0x00be:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r14 = r13.transmitLogger     // Catch:{ all -> 0x0046 }
            java.lang.String r15 = r13.TAG     // Catch:{ all -> 0x0046 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r10.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "entry "
            r10.append(r1)     // Catch:{ all -> 0x0046 }
            r10.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = r10.toString()     // Catch:{ all -> 0x0046 }
            r8 = 0
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ all -> 0x0046 }
            r14.d(r15, r1, r10)     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r13.transmitLogger     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r13.TAG     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage r10 = r0.location_info_response     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r14.<init>()     // Catch:{ all -> 0x0046 }
            r14.append(r4)     // Catch:{ all -> 0x0046 }
            r14.append(r10)     // Catch:{ all -> 0x0046 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x0046 }
            r14 = 0
            java.lang.String[] r15 = new java.lang.String[r14]     // Catch:{ all -> 0x0046 }
            r1.d(r8, r10, r15)     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r13.transmitLogger     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r13.TAG     // Catch:{ all -> 0x0046 }
            java.lang.String r10 = r0.details     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r14.<init>()     // Catch:{ all -> 0x0046 }
            r14.append(r4)     // Catch:{ all -> 0x0046 }
            r14.append(r10)     // Catch:{ all -> 0x0046 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x0046 }
            r14 = 0
            java.lang.String[] r15 = new java.lang.String[r14]     // Catch:{ all -> 0x0046 }
            r1.d(r8, r10, r15)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r1 = r0.success     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x011a
            r1 = 0
        L_0x0118:
            r8 = 1
            goto L_0x011f
        L_0x011a:
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0046 }
            goto L_0x0118
        L_0x011f:
            if (r1 != r8) goto L_0x0183
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r13.transmitLogger     // Catch:{ all -> 0x0046 }
            java.lang.String r10 = r13.TAG     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage r14 = r0.location_info_response     // Catch:{ all -> 0x0046 }
            if (r14 == 0) goto L_0x012c
            java.lang.Integer r14 = r14.location_logs_accepted     // Catch:{ all -> 0x0046 }
            goto L_0x012d
        L_0x012c:
            r14 = 0
        L_0x012d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r8.<init>()     // Catch:{ all -> 0x0046 }
            r8.append(r2)     // Catch:{ all -> 0x0046 }
            r8.append(r14)     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0046 }
            r14 = 0
            java.lang.String[] r15 = new java.lang.String[r14]     // Catch:{ all -> 0x0046 }
            r1.i(r10, r8, r15)     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage r8 = r0.location_info_response     // Catch:{ all -> 0x0046 }
            if (r8 == 0) goto L_0x014b
            java.lang.Integer r15 = r8.location_logs_accepted     // Catch:{ all -> 0x0046 }
            goto L_0x014c
        L_0x014b:
            r15 = 0
        L_0x014c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r8.<init>()     // Catch:{ all -> 0x0046 }
            r8.append(r2)     // Catch:{ all -> 0x0046 }
            r8.append(r15)     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0046 }
            r10 = 0
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ all -> 0x0046 }
            r1.d(r9, r8, r14)     // Catch:{ all -> 0x0046 }
            java.lang.Object r1 = r7.getKey()     // Catch:{ all -> 0x0046 }
            r12.add(r1)     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage r0 = r0.location_info_response     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x01b7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r17 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r18 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_LOCATION_RECORDS_ACCEPTED     // Catch:{ all -> 0x0046 }
            java.lang.Integer r0 = r0.location_logs_accepted     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "locationInfoResponse.location_logs_accepted"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x0046 }
            r20 = 0
            r21 = 4
            r22 = 0
            r19 = r0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0046 }
            goto L_0x01b7
        L_0x0183:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r13.transmitLogger     // Catch:{ all -> 0x0046 }
            java.lang.String r7 = r13.TAG     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r0.details     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r10.<init>()     // Catch:{ all -> 0x0046 }
            r10.append(r3)     // Catch:{ all -> 0x0046 }
            r10.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0046 }
            r10 = 0
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ all -> 0x0046 }
            r1.i(r7, r8, r14)     // Catch:{ all -> 0x0046 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r0.details     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r7.<init>()     // Catch:{ all -> 0x0046 }
            r7.append(r3)     // Catch:{ all -> 0x0046 }
            r7.append(r0)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0046 }
            r7 = 0
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ all -> 0x0046 }
            r1.e((java.lang.String) r9, (java.lang.String) r0, (java.lang.String[]) r8)     // Catch:{ all -> 0x0046 }
        L_0x01b7:
            r10 = 0
            goto L_0x01ec
        L_0x01b9:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r13.transmitLogger
            java.lang.String r7 = r13.TAG
            java.lang.String r8 = r0.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r14 = "Error submitting location logs packet - exception: "
            r10.<init>(r14)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r10 = 0
            java.lang.String[] r15 = new java.lang.String[r10]
            r1.e(r7, r8, r15)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r14)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[r10]
            r1.e((java.lang.String) r9, (java.lang.String) r0, (java.lang.String[]) r7)
        L_0x01ec:
            r1 = r23
            r8 = 1
            goto L_0x007e
        L_0x01f1:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r13.transmitLogger
            java.lang.String r1 = r13.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "deleteFiles "
            r2.<init>(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r3 = new java.lang.String[r10]
            r0.d(r1, r2, r3)
            android.content.Context r0 = r13.context
            com.m2catalyst.m2sdk.a2.a((android.content.Context) r0, (java.util.List<java.lang.String>) r12)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.LocationRepository.submitLocationLogs(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
