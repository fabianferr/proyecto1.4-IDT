package com.m2catalyst.m2sdk.business.repositories;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.a2;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NoSignalData;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceBatteryLogsResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkSignalInfoMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkDiagnosticTestResultsMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NoNetworkSignalInfoMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.VerifyApiKeyResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.s1;
import com.m2catalyst.m2sdk.v1;
import com.m2catalyst.m2sdk.w2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001BA\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010t\u001a\u00020s¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0005J\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\u001b\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0005J\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0015\u0010#\u001a\u0004\u0018\u00010\"H@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0005J\u0013\u0010$\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u0013\u0010%\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005J\u001d\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010&\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u00142\u0006\u0010&\u001a\u00020\"H\u0017JK\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\b\u0010*\u001a\u0004\u0018\u00010\"2\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010,H@ø\u0001\u0000¢\u0006\u0004\b0\u00101JA\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\b\u0010*\u001a\u0004\u0018\u00010\"2\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010,H@ø\u0001\u0000¢\u0006\u0004\b2\u00103J7\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\b\u0010*\u001a\u0004\u0018\u00010\"2\b\u00104\u001a\u0004\u0018\u00010\"2\b\u0010/\u001a\u0004\u0018\u00010,H@ø\u0001\u0000¢\u0006\u0004\b5\u00106J3\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\b\u0010*\u001a\u0004\u0018\u00010\"2\b\u00104\u001a\u0004\u0018\u00010\"2\b\u0010/\u001a\u0004\u0018\u00010,H\u0017¢\u0006\u0004\b7\u00108J)\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010*\u001a\u00020\"2\u0006\u00109\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J!\u0010=\u001a\u00020\u00032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020,0\nH@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0013\u0010?\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0005J#\u0010C\u001a\u00020\u00032\u0006\u0010@\u001a\u00020,2\u0006\u0010B\u001a\u00020AH@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001b\u0010G\u001a\u00020\"2\u0006\u0010F\u001a\u00020EH@ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ+\u0010K\u001a\u00020\u00032\u0006\u0010&\u001a\u00020,2\u0006\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ]\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020M2\b\u0010R\u001a\u0004\u0018\u00010\"2\b\u0010S\u001a\u0004\u0018\u00010\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010.\u001a\u0004\u0018\u00010,H\u0017¢\u0006\u0004\bT\u0010UJ\n\u0010W\u001a\u0004\u0018\u00010VH\u0007J\u001a\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010Z2\u0006\u0010Y\u001a\u00020XH\u0016J#\u0010^\u001a\u00020\u00032\u0012\u0010]\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\\\"\u00020\u0014H\u0016¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b`\u0010\u0005R\u0014\u0010b\u001a\u00020a8\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020y8\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020,0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020,0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010}R\u001c\u0010\u001a\b\u0012\u0004\u0012\u00020,0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010}R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020,0\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010}R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$RFNetworkDataAvailability;", "", "markDataTransmitted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/NetworkInfoMessage$Builder;", "message", "", "hasInfo", "", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/NetworkDiagnosticTestResultsMessage;", "handleNetworkTestDiagnostics", "Lcom/m2catalyst/m2sdk/business/models/NoSignalData;", "noSignalLogsEntries", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/NoNetworkSignalInfoMessage;", "handleNoSignalLogs", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/WifiNetworkInfoMessage;", "handleWifiLogs", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsiEntries", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/MobileNetworkSignalInfoMessage;", "handleMNSI", "", "networkType", "getNetworkType", "", "", "getNetworkFiles", "deleteNetworkFilesAfterTwoWeeks", "setUnitTestMode", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiResponseMessage;", "returnDummyResponseForUnitTesting", "", "buildAndSubmit", "buildNetworkLogsPacket", "submitNetworkLogs", "id", "getMNSIById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMNSIRecordById", "startDate", "transmitted", "", "lastId", "limit", "simSlot", "getMNSIWithLastIdLimitAndTransmittedFilter", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMNSIWithLastIdAndLimit", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopDate", "getMNSI", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMNSIRecords", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", "endDate", "getMNSIWithNoSub", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entriesIds", "markMNSITransmitted", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMNSIEntries", "mnsiId", "Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;", "diagnostics", "updateLocationDataFromNetworkDiagnostics", "(ILcom/m2catalyst/m2sdk/database/entities/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/database/entities/MNSIEntity;", "entry", "insertMNSIEntry", "(Lcom/m2catalyst/m2sdk/database/entities/MNSIEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dataRX", "dataTX", "updateMobileSignalRxTx", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "upperLeftLat", "upperLeftLong", "lowerRightLat", "lowerRightLong", "startTime", "endTime", "getMNSIRecordsInBoundries", "(DDDDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "Lcom/m2catalyst/m2sdk/external/SDKState;", "getStateForLiveData", "Lcom/m2catalyst/m2sdk/business/repositories/MNSI_TYPE;", "type", "Landroidx/lifecycle/MutableLiveData;", "getMNSILiveData", "", "mnsi", "addMNSIRecord", "([Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", "clearMNSIEntries", "Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;", "ndtRepository", "Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/NoSignalMNSIRepository;", "noSignalMNSI", "Lcom/m2catalyst/m2sdk/business/repositories/NoSignalMNSIRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/WifiRepository;", "wifiRepository", "Lcom/m2catalyst/m2sdk/business/repositories/WifiRepository;", "Lcom/m2catalyst/m2sdk/database/daos/MNSIDao;", "mnsiDao", "Lcom/m2catalyst/m2sdk/database/daos/MNSIDao;", "Lcom/m2catalyst/m2sdk/v1;", "mnsiClient", "Lcom/m2catalyst/m2sdk/v1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalsRepository;", "badSignalsRepository", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalsRepository;", "Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "transmitLogger", "Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "Lcom/m2catalyst/m2sdk/r2;", "wifiIds", "Ljava/util/List;", "noSignalIds", "diagnosticsIds", "mnsiIds", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "mnsiPacketBeingCreated", "Z", "<init>", "(Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;Lcom/m2catalyst/m2sdk/business/repositories/NoSignalMNSIRepository;Lcom/m2catalyst/m2sdk/business/repositories/WifiRepository;Lcom/m2catalyst/m2sdk/database/daos/MNSIDao;Lcom/m2catalyst/m2sdk/v1;Landroid/content/Context;Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalsRepository;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository extends BaseRepository implements DataAvailability.RFNetworkDataAvailability {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG_NETWORK_LOGS = "NETWORK_LOGS";
    private static boolean unitTestMode;
    private final l2 accessComponent;
    private final BadSignalsRepository badSignalsRepository;
    private final r2 configuration = r2.a.a();
    private final Context context;
    private List<Integer> diagnosticsIds = CollectionsKt.emptyList();
    private final v1 mnsiClient;
    /* access modifiers changed from: private */
    public final MNSIDao mnsiDao;
    private List<Integer> mnsiIds = CollectionsKt.emptyList();
    private boolean mnsiPacketBeingCreated;
    private final NDTRepository ndtRepository;
    private List<Integer> noSignalIds = CollectionsKt.emptyList();
    private final NoSignalMNSIRepository noSignalMNSI;
    private final M2SDKLogger transmitLogger = M2SDKLogger.Companion.getLogger("TRANSMISSION");
    private List<Integer> wifiIds = CollectionsKt.emptyList();
    private final WifiRepository wifiRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository$Companion;", "", "()V", "TAG_NETWORK_LOGS", "", "unitTestMode", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MNSIRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0067, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MNSIRepository(com.m2catalyst.m2sdk.business.repositories.NDTRepository r2, com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository r3, com.m2catalyst.m2sdk.business.repositories.WifiRepository r4, com.m2catalyst.m2sdk.database.daos.MNSIDao r5, com.m2catalyst.m2sdk.v1 r6, android.content.Context r7, com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository r8) {
        /*
            r1 = this;
            java.lang.String r0 = "ndtRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "noSignalMNSI"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "wifiRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "mnsiDao"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "mnsiClient"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "badSignalsRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r1.<init>()
            r1.ndtRepository = r2
            r1.noSignalMNSI = r3
            r1.wifiRepository = r4
            r1.mnsiDao = r5
            r1.mnsiClient = r6
            r1.context = r7
            r1.badSignalsRepository = r8
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "TRANSMISSION"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r3)
            r1.transmitLogger = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            r1.configuration = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r1.wifiIds = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r1.noSignalIds = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r1.diagnosticsIds = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r1.mnsiIds = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            if (r2 == 0) goto L_0x0072
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0072
            com.m2catalyst.m2sdk.l2 r2 = r2.c()
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            r1.accessComponent = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.<init>(com.m2catalyst.m2sdk.business.repositories.NDTRepository, com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository, com.m2catalyst.m2sdk.business.repositories.WifiRepository, com.m2catalyst.m2sdk.database.daos.MNSIDao, com.m2catalyst.m2sdk.v1, android.content.Context, com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository):void");
    }

    private final void deleteNetworkFilesAfterTwoWeeks() {
        a2.a(this.context, TAG_NETWORK_LOGS);
    }

    private final Map<String, byte[]> getNetworkFiles() {
        return a2.b(this.context, TAG_NETWORK_LOGS);
    }

    /* access modifiers changed from: private */
    public final String getNetworkType(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 1621) {
            if (hashCode != 1652) {
                if (hashCode == 1683 && str.equals("4G")) {
                    return " AND (networkTypeString == 'LTE' ) ";
                }
            } else if (str.equals("3G")) {
                return " AND (networkTypeString == 'HSPA' OR networkTypeString == 'HSPAP' OR networkTypeString == 'EHRPD' OR networkTypeString == 'EVDO'_A OR networkTypeString == 'EVDO_B' OR networkTypeString == 'EVDO_0' OR networkTypeString == 'HSUPA' OR networkTypeString == 'HSDPA' OR networkTypeString == 'UMTS' ) ";
            }
        } else if (str.equals("2G")) {
            return " AND (networkTypeString == 'CDMA' OR networkTypeString == 'EDGE' OR networkTypeString == 'IDEN' OR networkTypeString == 'GPRS' OR networkTypeString == '1xRTT' ) ";
        }
        return " AND (networkTypeString == '" + str + "' ) ";
    }

    private final List<MobileNetworkSignalInfoMessage> handleMNSI(List<MNSI> list) {
        ArrayList arrayList;
        List<MNSI> list2 = list;
        MNSI mnsi = (MNSI) CollectionsKt.lastOrNull(list);
        if (mnsi != null && mnsi.getDataRx() == null) {
            CollectionsKt.removeLast(list);
        }
        Integer num = null;
        if (!list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (MNSI id : list) {
                arrayList2.add(Integer.valueOf(id.getId()));
            }
            this.mnsiIds = arrayList2;
            if (!list.isEmpty()) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (MNSI message : list) {
                    arrayList.add(message.toMessage());
                }
            } else {
                arrayList = null;
            }
            this.transmitLogger.d("MNSIRepository", "While building the MNSI packet, " + (arrayList != null ? arrayList.size() : 0) + " MNSI entries were added to the packet", new String[0]);
            M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, TAG_NETWORK_LOGS, "While building the MNSI packet, " + (arrayList != null ? arrayList.size() : 0) + " MNSI entries were added to the packet", (Map) null, false, 12, (Object) null);
        } else {
            arrayList = null;
        }
        MonitorStatsLogger monitorStatsLogger = MonitorStatsLogger.INSTANCE;
        LoggingEvents loggingEvents = LoggingEvents.BUILD_MNSI_PACKET_COUNT_RECORDS;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        MonitorStatsLogger.increment$default(monitorStatsLogger, loggingEvents, Integer.valueOf(s1.a(num, 0)), false, 4, (Object) null);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091 A[LOOP:1: B:26:0x008b->B:28:0x0091, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleNetworkTestDiagnostics(kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkDiagnosticTestResultsMessage>> r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r1 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleNetworkTestDiagnostics$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleNetworkTestDiagnostics$1 r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleNetworkTestDiagnostics$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleNetworkTestDiagnostics$1 r2 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleNetworkTestDiagnostics$1
            r2.<init>(r0, r1)
        L_0x001c:
            r10 = r2
            java.lang.Object r1 = r10.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r10.label
            r11 = 1
            r12 = 0
            if (r3 == 0) goto L_0x003b
            if (r3 != r11) goto L_0x0033
            java.lang.Object r2 = r10.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0055
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r3 = r0.ndtRepository
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            r10.L$0 = r0
            r10.label = r11
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            java.lang.Object r1 = r3.getNDTResults(r4, r5, r6, r7, r8, r9, r10)
            if (r1 != r2) goto L_0x0054
            return r2
        L_0x0054:
            r2 = r0
        L_0x0055:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r1.iterator()
        L_0x0060:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r6 = (com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults) r6
            java.lang.Long r6 = r6.getId()
            if (r6 == 0) goto L_0x0075
            r6 = 1
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r6 == 0) goto L_0x0060
            r3.add(r5)
            goto L_0x0060
        L_0x007c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r4.<init>(r6)
            java.util.Iterator r3 = r3.iterator()
        L_0x008b:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00ab
            java.lang.Object r6 = r3.next()
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r6 = (com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults) r6
            java.lang.Long r6 = r6.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            long r6 = r6.longValue()
            int r7 = (int) r6
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            r4.add(r6)
            goto L_0x008b
        L_0x00ab:
            r2.diagnosticsIds = r4
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r11
            r4 = 0
            if (r3 == 0) goto L_0x00d6
            java.util.ArrayList r3 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r3.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x00c2:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00d7
            java.lang.Object r5 = r1.next()
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r5 = (com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults) r5
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkDiagnosticTestResultsMessage r5 = r5.toMessage()
            r3.add(r5)
            goto L_0x00c2
        L_0x00d6:
            r3 = r4
        L_0x00d7:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r2.transmitLogger
            if (r3 == 0) goto L_0x00e0
            int r2 = r3.size()
            goto L_0x00e1
        L_0x00e0:
            r2 = 0
        L_0x00e1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "While building the MNSI packet, "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " TEST DIAGNOSTICS entries were added to the packet"
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String[] r7 = new java.lang.String[r12]
            java.lang.String r8 = "MNSIRepository"
            r1.d(r8, r5, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r13 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r14 = "NETWORK_LOGS"
            if (r3 == 0) goto L_0x0106
            int r1 = r3.size()
            goto L_0x0107
        L_0x0106:
            r1 = 0
        L_0x0107:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r1)
            r5.append(r2)
            java.lang.String r15 = r5.toString()
            r16 = 0
            r17 = 0
            r18 = 12
            r19 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r13, r14, r15, r16, r17, r18, r19)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r5 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r6 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.BUILD_NDT_PACKET_COUNT_RECORDS
            if (r3 == 0) goto L_0x012f
            int r1 = r3.size()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
        L_0x012f:
            int r1 = com.m2catalyst.m2sdk.s1.a(r4, r12)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r8 = 0
            r9 = 4
            r10 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r5, r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.handleNetworkTestDiagnostics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<NoNetworkSignalInfoMessage> handleNoSignalLogs(List<NoSignalData> list) {
        ArrayList arrayList;
        List<NoSignalData> list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NoSignalData id : list) {
            arrayList2.add(Integer.valueOf(id.getId()));
        }
        this.noSignalIds = arrayList2;
        Integer num = null;
        if (!list.isEmpty()) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (NoSignalData noSignalMessage : list) {
                arrayList.add(noSignalMessage.toNoSignalMessage());
            }
        } else {
            arrayList = null;
        }
        this.transmitLogger.d("MNSIRepository", "While building the MNSI packet, " + (arrayList != null ? arrayList.size() : 0) + " NO SIGNAL entries were added to the packet", new String[0]);
        M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, TAG_NETWORK_LOGS, "While building the MNSI packet, " + (arrayList != null ? arrayList.size() : 0) + " NO SIGNAL entries were added to the packet", (Map) null, false, 12, (Object) null);
        MonitorStatsLogger monitorStatsLogger = MonitorStatsLogger.INSTANCE;
        LoggingEvents loggingEvents = LoggingEvents.BUILD_NO_SIGNAL_PACKET_COUNT_RECORDS;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        MonitorStatsLogger.increment$default(monitorStatsLogger, loggingEvents, Integer.valueOf(s1.a(num, 0)), false, 4, (Object) null);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleWifiLogs(kotlin.coroutines.Continuation<? super java.util.List<com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage>> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleWifiLogs$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleWifiLogs$1 r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleWifiLogs$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleWifiLogs$1 r2 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$handleWifiLogs$1
            r2.<init>(r0, r1)
        L_0x001c:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r7.label
            r10 = 1
            r11 = 0
            if (r3 == 0) goto L_0x003b
            if (r3 != r10) goto L_0x0033
            java.lang.Object r2 = r7.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0054
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.business.repositories.WifiRepository r3 = r0.wifiRepository
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            r7.L$0 = r0
            r7.label = r10
            r4 = 0
            r6 = 0
            r8 = 5
            r9 = 0
            java.lang.Object r1 = com.m2catalyst.m2sdk.business.repositories.WifiRepository.getWifiWithLimit$default(r3, r4, r5, r6, r7, r8, r9)
            if (r1 != r2) goto L_0x0053
            return r2
        L_0x0053:
            r2 = r0
        L_0x0054:
            java.util.List r1 = (java.util.List) r1
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r10
            r4 = 0
            if (r3 == 0) goto L_0x00fb
            java.util.ArrayList r3 = new java.util.ArrayList
            r5 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r3.<init>(r6)
            java.util.Iterator r6 = r1.iterator()
        L_0x006d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0086
            java.lang.Object r7 = r6.next()
            com.m2catalyst.m2sdk.business.models.Wifi r7 = (com.m2catalyst.m2sdk.business.models.Wifi) r7
            long r7 = r7.getId()
            int r8 = (int) r7
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r3.add(r7)
            goto L_0x006d
        L_0x0086:
            r2.wifiIds = r3
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r10
            if (r3 == 0) goto L_0x00b0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r3.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x009c:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00b1
            java.lang.Object r5 = r1.next()
            com.m2catalyst.m2sdk.business.models.Wifi r5 = (com.m2catalyst.m2sdk.business.models.Wifi) r5
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage r5 = r5.toMessage()
            r3.add(r5)
            goto L_0x009c
        L_0x00b0:
            r3 = r4
        L_0x00b1:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r2.transmitLogger
            if (r3 == 0) goto L_0x00ba
            int r2 = r3.size()
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "While building the MNSI packet, "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " CONNECTIVITY WIFI entries were added to the packet"
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String[] r7 = new java.lang.String[r11]
            java.lang.String r8 = "MNSIRepository"
            r1.d(r8, r5, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r12 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r13 = "NETWORK_LOGS"
            if (r3 == 0) goto L_0x00e0
            int r1 = r3.size()
            goto L_0x00e1
        L_0x00e0:
            r1 = 0
        L_0x00e1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r1)
            r5.append(r2)
            java.lang.String r14 = r5.toString()
            r15 = 0
            r16 = 0
            r17 = 12
            r18 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x00fc
        L_0x00fb:
            r3 = r4
        L_0x00fc:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r5 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r6 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.BUILD_WIFI_PACKET_COUNT_RECORDS
            if (r3 == 0) goto L_0x010a
            int r1 = r3.size()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
        L_0x010a:
            int r1 = com.m2catalyst.m2sdk.s1.a(r4, r11)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r8 = 0
            r9 = 4
            r10 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r5, r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.handleWifiLogs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean hasInfo(NetworkInfoMessage.Builder builder) {
        List<MobileNetworkSignalInfoMessage> list = builder.mobileNetworkSignalInfoLogs;
        Intrinsics.checkNotNullExpressionValue(list, "message.mobileNetworkSignalInfoLogs");
        if (!list.isEmpty()) {
            return true;
        }
        List<WifiNetworkInfoMessage> list2 = builder.wifi_network_info;
        Intrinsics.checkNotNullExpressionValue(list2, "message.wifi_network_info");
        if (!list2.isEmpty()) {
            return true;
        }
        List<NoNetworkSignalInfoMessage> list3 = builder.noNetworkSignalInfoLogs;
        Intrinsics.checkNotNullExpressionValue(list3, "message.noNetworkSignalInfoLogs");
        if (!list3.isEmpty()) {
            return true;
        }
        List<NetworkDiagnosticTestResultsMessage> list4 = builder.networkDiagnosticTestResults;
        Intrinsics.checkNotNullExpressionValue(list4, "message.networkDiagnosticTestResults");
        if (!list4.isEmpty()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object markDataTransmitted(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markDataTransmitted$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markDataTransmitted$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markDataTransmitted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markDataTransmitted$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markDataTransmitted$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r6) goto L_0x0051
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r0 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0125
        L_0x0037:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x003f:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0107
        L_0x0048:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e8
        L_0x0051:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00c7
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r15)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r14.transmitLogger
            r2 = 0
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r8 = "markDataTransmitted()"
            java.lang.String r9 = "MNSIRepository"
            r15.i(r9, r8, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r14.transmitLogger
            java.util.List<java.lang.Integer> r7 = r14.wifiIds
            int r7 = r7.size()
            java.util.List<java.lang.Integer> r8 = r14.noSignalIds
            int r8 = r8.size()
            java.util.List<java.lang.Integer> r10 = r14.diagnosticsIds
            int r10 = r10.size()
            java.util.List<java.lang.Integer> r11 = r14.mnsiIds
            int r11 = r11.size()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "wifiIds.size "
            r12.<init>(r13)
            r12.append(r7)
            java.lang.String r7 = " noSignalIds.size "
            r12.append(r7)
            r12.append(r8)
            java.lang.String r7 = " diagnosticsIds.size "
            r12.append(r7)
            r12.append(r10)
            java.lang.String r7 = " mnsiIds.size "
            r12.append(r7)
            r12.append(r11)
            java.lang.String r7 = r12.toString()
            java.lang.String[] r2 = new java.lang.String[r2]
            r15.d(r9, r7, r2)
            java.util.List<java.lang.Integer> r15 = r14.wifiIds
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x00cf
            com.m2catalyst.m2sdk.business.repositories.WifiRepository r15 = r14.wifiRepository
            java.util.List<java.lang.Integer> r2 = r14.wifiIds
            r0.L$0 = r14
            r0.label = r6
            java.lang.Object r15 = r15.markWifiEntryTransmitted(r2, r0)
            if (r15 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            r2 = r14
        L_0x00c7:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r2.wifiIds = r15
            goto L_0x00d0
        L_0x00cf:
            r2 = r14
        L_0x00d0:
            java.util.List<java.lang.Integer> r15 = r2.noSignalIds
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x00ef
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository r15 = r2.noSignalMNSI
            java.util.List<java.lang.Integer> r7 = r2.noSignalIds
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r15 = r15.markNoSignalEntityTransmitted(r7, r0)
            if (r15 != r1) goto L_0x00e8
            return r1
        L_0x00e8:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r2.noSignalIds = r15
        L_0x00ef:
            java.util.List<java.lang.Integer> r15 = r2.diagnosticsIds
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x010e
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r15 = r2.ndtRepository
            java.util.List<java.lang.Integer> r5 = r2.diagnosticsIds
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r15 = r15.markDiagnosticsTransmittedEntries(r5, r0)
            if (r15 != r1) goto L_0x0107
            return r1
        L_0x0107:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r2.diagnosticsIds = r15
        L_0x010e:
            java.util.List<java.lang.Integer> r15 = r2.mnsiIds
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x012c
            java.util.List<java.lang.Integer> r15 = r2.mnsiIds
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r15 = r2.markMNSITransmitted(r15, r0)
            if (r15 != r1) goto L_0x0124
            return r1
        L_0x0124:
            r0 = r2
        L_0x0125:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0.mnsiIds = r15
        L_0x012c:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.markDataTransmitted(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ApiResponseMessage returnDummyResponseForUnitTesting() {
        Boolean bool = Boolean.TRUE;
        return new ApiResponseMessage(bool, "Message", (SyncDeviceResponseMessage) null, (VerifyApiKeyResponseMessage) null, 123456L, bool, 42, (DeviceBatteryLogsResponseMessage) null, (LocationInfoResponseMessage) null, (NetworkInfoResponseMessage) null);
    }

    private final void setUnitTestMode() {
        unitTestMode = true;
    }

    public void addMNSIRecord(MNSI... mnsiArr) {
        Intrinsics.checkNotNullParameter(mnsiArr, "mnsi");
        if (M2SDK.INSTANCE.isAccessible(new MNSIRepository$addMNSIRecord$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MNSIRepository$addMNSIRecord$2(mnsiArr, this, (Continuation<? super MNSIRepository$addMNSIRecord$2>) null), 1, (Object) null);
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
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildAndSubmit$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildAndSubmit$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildAndSubmit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildAndSubmit$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildAndSubmit$1
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
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006d
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0061
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r9 = r8.transmitLogger
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r6 = "MNSIRepository"
            java.lang.String r7 = "buildAndSubmit()"
            r9.i(r6, r7, r2)
            boolean r9 = r8.mnsiPacketBeingCreated
            if (r9 != 0) goto L_0x0078
            r8.mnsiPacketBeingCreated = r5
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r8.buildNetworkLogsPacket(r0)
            if (r9 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r2 = r8
        L_0x0061:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r2.submitNetworkLogs(r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r0 = r2
        L_0x006d:
            r0.mnsiPacketBeingCreated = r4
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            goto L_0x0079
        L_0x0078:
            r9 = 0
        L_0x0079:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.buildAndSubmit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: com.m2catalyst.m2sdk.business.repositories.MNSIRepository} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00de, code lost:
        r1 = kotlin.collections.CollectionsKt.toMutableList((java.util.Collection) r1);
        r10 = r3.noSignalMNSI;
        r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
        r0.L$0 = r3;
        r0.L$1 = r2;
        r0.L$2 = r1;
        r0.label = 2;
        r5 = null;
        r6 = "MNSIRepository";
        r19 = true;
        r14 = r4;
        r4 = r15;
        r10 = r10.getNoSignalRecords$m2sdk_release((java.lang.Long) null, (java.lang.Long) null, (java.lang.Integer) null, r14, (java.lang.Integer) null, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x010b, code lost:
        if (r10 != r4) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010e, code lost:
        r27 = r2;
        r2 = r1;
        r1 = r10;
        r10 = r3;
        r3 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0115, code lost:
        r1 = (java.util.List) r1;
        r0.L$0 = r10;
        r0.L$1 = r3;
        r0.L$2 = r2;
        r0.L$3 = r1;
        r0.label = 3;
        r11 = r10.handleNetworkTestDiagnostics(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0126, code lost:
        if (r11 != r4) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0128, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0129, code lost:
        r27 = r2;
        r2 = r1;
        r1 = r11;
        r11 = r10;
        r10 = r3;
        r3 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0131, code lost:
        r1 = (java.util.List) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0133, code lost:
        if (r1 == null) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0135, code lost:
        r10.networkDiagnosticTestResults(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0138, code lost:
        r1 = r11.handleNoSignalLogs(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x013c, code lost:
        if (r1 == null) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x013e, code lost:
        r10.noNetworkSignalInfoLogs(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0141, code lost:
        r0.L$0 = r11;
        r0.L$1 = r10;
        r0.L$2 = r3;
        r0.L$3 = r2;
        r0.label = 4;
        r1 = r11.handleWifiLogs(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0150, code lost:
        if (r1 != r4) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0152, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0153, code lost:
        r27 = r3;
        r3 = r2;
        r2 = r11;
        r11 = r10;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x015a, code lost:
        r1 = (java.util.List) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015c, code lost:
        if (r1 == null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015e, code lost:
        r11.wifi_network_info(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0161, code lost:
        r1 = r2.handleMNSI(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0165, code lost:
        if (r1 == null) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0167, code lost:
        r11.mobileNetworkSignalInfoLogs(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016a, code lost:
        r13 = 0;
        r2.transmitLogger.d(r6, "mnsiEntries.size " + r10.size() + " noSignalLogsEntires.size " + r3.size(), new java.lang.String[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0194, code lost:
        if (r2.hasInfo(r11) == false) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0196, code lost:
        r1 = com.m2catalyst.m2sdk.n3.a(r2.configuration);
        r1.network_info = r11.build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r1 = com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage.ADAPTER.encode(r1.build());
        r11 = com.m2catalyst.m2sdk.a2.a(r1, r2.context);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b2, code lost:
        if (r11 == null) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b4, code lost:
        r2.transmitLogger.i(r6, "The FULL NETWORK LOGS packet was populated, converted into byte array size " + r1.length + " and saved into file named " + r11, new java.lang.String[0]);
        com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion, TAG_NETWORK_LOGS, "The FULL NETWORK LOGS packet was populated, converted into byte array size " + r1.length + " and saved into file named " + r11, (java.util.Map) null, false, 12, (java.lang.Object) null);
        r1 = r2.configuration.a();
        r8 = com.m2catalyst.m2sdk.a6.CROWDSOURCE_SHARING_ENABLED;
        r9 = r8.b();
        r8 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x020c, code lost:
        if (r1.a().getAll().containsKey(r8) != false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x020f, code lost:
        r9 = r1.a().getAll().get(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0223, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r19)) == false) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0225, code lost:
        r1 = r2.badSignalsRepository;
        r3 = r3.size();
        r0.L$0 = r2;
        r0.L$1 = r5;
        r0.L$2 = r5;
        r0.L$3 = r5;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x023a, code lost:
        if (r1.addBadSignalCount(r10, r3, r0) != r4) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x023c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x023d, code lost:
        r0.L$0 = r2;
        r0.L$1 = r5;
        r0.L$2 = r5;
        r0.L$3 = r5;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x024c, code lost:
        if (r2.markDataTransmitted(r0) != r4) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x024e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x024f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0250, code lost:
        r17 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0252, code lost:
        r2.transmitLogger.e(r6, "Error writing packet to file " + r17.getMessage(), new java.lang.String[r13]);
        com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion, TAG_NETWORK_LOGS, "Error writing packet to file", r17, false, 8, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x027c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildNetworkLogsPacket(kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            r28 = this;
            r7 = r28
            r0 = r29
            java.lang.String r8 = " and saved into file named "
            java.lang.String r9 = "The FULL NETWORK LOGS packet was populated, converted into byte array size "
            boolean r1 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildNetworkLogsPacket$1
            if (r1 == 0) goto L_0x001b
            r1 = r0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildNetworkLogsPacket$1 r1 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildNetworkLogsPacket$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001b
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x0020
        L_0x001b:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildNetworkLogsPacket$1 r1 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$buildNetworkLogsPacket$1
            r1.<init>(r7, r0)
        L_0x0020:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r14 = 1
            java.lang.String r13 = "MNSIRepository"
            r12 = 0
            r11 = 0
            switch(r2) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x00a8;
                case 2: goto L_0x0091;
                case 3: goto L_0x0075;
                case 4: goto L_0x0057;
                case 5: goto L_0x0043;
                case 6: goto L_0x0039;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r0 = r0.L$0
            r2 = r0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x027a
        L_0x0043:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ Exception -> 0x0050 }
            r5 = r12
            r6 = r13
            r4 = r15
            r13 = 0
            goto L_0x023d
        L_0x0050:
            r0 = move-exception
            r17 = r0
            r6 = r13
            r13 = 0
            goto L_0x0252
        L_0x0057:
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$2
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder r4 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage.Builder) r4
            java.lang.Object r5 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r5 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r3
            r11 = r4
            r6 = r13
            r4 = r15
            r19 = 1
            r3 = r2
            r2 = r5
            r5 = r12
            goto L_0x015a
        L_0x0075:
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$2
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder r4 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage.Builder) r4
            java.lang.Object r5 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r5 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r4
            r11 = r5
            r5 = r12
            r6 = r13
            r4 = r15
            r19 = 1
            goto L_0x0131
        L_0x0091:
            java.lang.Object r2 = r0.L$2
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder r3 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage.Builder) r3
            java.lang.Object r4 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r4 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r4
            r5 = r12
            r6 = r13
            r4 = r15
            r19 = 1
            goto L_0x0115
        L_0x00a8:
            java.lang.Object r2 = r0.L$1
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder r2 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage.Builder) r2
            java.lang.Object r3 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r3 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00de
        L_0x00b4:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r7.transmitLogger
            java.lang.String[] r2 = new java.lang.String[r11]
            java.lang.String r3 = "buildNetworkLogsPacket()"
            r1.d(r13, r3, r2)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder r10 = new com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage$Builder
            r10.<init>()
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.label = r14
            r2 = 0
            r4 = 0
            r5 = 0
            r1 = r28
            r6 = r0
            java.lang.Object r1 = r1.getMNSIWithLastIdAndLimit(r2, r3, r4, r5, r6)
            if (r1 != r15) goto L_0x00dc
            return r15
        L_0x00dc:
            r3 = r7
            r2 = r10
        L_0x00de:
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r1)
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository r10 = r3.noSignalMNSI
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            r0.L$0 = r3
            r0.L$1 = r2
            r0.L$2 = r1
            r5 = 2
            r0.label = r5
            r5 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r11 = r5
            r5 = r12
            r12 = r6
            r6 = r13
            r13 = r16
            r19 = 1
            r14 = r4
            r4 = r15
            r15 = r17
            r16 = r0
            java.lang.Object r10 = r10.getNoSignalRecords$m2sdk_release(r11, r12, r13, r14, r15, r16)
            if (r10 != r4) goto L_0x010e
            return r4
        L_0x010e:
            r27 = r2
            r2 = r1
            r1 = r10
            r10 = r3
            r3 = r27
        L_0x0115:
            java.util.List r1 = (java.util.List) r1
            r0.L$0 = r10
            r0.L$1 = r3
            r0.L$2 = r2
            r0.L$3 = r1
            r11 = 3
            r0.label = r11
            java.lang.Object r11 = r10.handleNetworkTestDiagnostics(r0)
            if (r11 != r4) goto L_0x0129
            return r4
        L_0x0129:
            r27 = r2
            r2 = r1
            r1 = r11
            r11 = r10
            r10 = r3
            r3 = r27
        L_0x0131:
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0138
            r10.networkDiagnosticTestResults(r1)
        L_0x0138:
            java.util.List r1 = r11.handleNoSignalLogs(r2)
            if (r1 == 0) goto L_0x0141
            r10.noNetworkSignalInfoLogs(r1)
        L_0x0141:
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r3
            r0.L$3 = r2
            r1 = 4
            r0.label = r1
            java.lang.Object r1 = r11.handleWifiLogs(r0)
            if (r1 != r4) goto L_0x0153
            return r4
        L_0x0153:
            r27 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r27
        L_0x015a:
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0161
            r11.wifi_network_info(r1)
        L_0x0161:
            java.util.List r1 = r2.handleMNSI(r10)
            if (r1 == 0) goto L_0x016a
            r11.mobileNetworkSignalInfoLogs(r1)
        L_0x016a:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r2.transmitLogger
            int r12 = r10.size()
            int r13 = r3.size()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "mnsiEntries.size "
            r14.<init>(r15)
            r14.append(r12)
            java.lang.String r12 = " noSignalLogsEntires.size "
            r14.append(r12)
            r14.append(r13)
            java.lang.String r12 = r14.toString()
            r13 = 0
            java.lang.String[] r14 = new java.lang.String[r13]
            r1.d(r6, r12, r14)
            boolean r1 = r2.hasInfo(r11)
            if (r1 == 0) goto L_0x027a
            com.m2catalyst.m2sdk.r2 r1 = r2.configuration
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage$Builder r1 = com.m2catalyst.m2sdk.n3.a(r1)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage r11 = r11.build()
            r1.network_info = r11
            com.squareup.wire.ProtoAdapter<com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage> r11 = com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage.ADAPTER     // Catch:{ Exception -> 0x024f }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r1 = r1.build()     // Catch:{ Exception -> 0x024f }
            byte[] r1 = r11.encode(r1)     // Catch:{ Exception -> 0x024f }
            android.content.Context r11 = r2.context     // Catch:{ Exception -> 0x024f }
            java.lang.String r11 = com.m2catalyst.m2sdk.a2.a((byte[]) r1, (android.content.Context) r11)     // Catch:{ Exception -> 0x024f }
            if (r11 == 0) goto L_0x027a
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r2.transmitLogger     // Catch:{ Exception -> 0x024f }
            int r14 = r1.length     // Catch:{ Exception -> 0x024f }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024f }
            r15.<init>(r9)     // Catch:{ Exception -> 0x024f }
            r15.append(r14)     // Catch:{ Exception -> 0x024f }
            r15.append(r8)     // Catch:{ Exception -> 0x024f }
            r15.append(r11)     // Catch:{ Exception -> 0x024f }
            java.lang.String r14 = r15.toString()     // Catch:{ Exception -> 0x024f }
            java.lang.String[] r15 = new java.lang.String[r13]     // Catch:{ Exception -> 0x024f }
            r12.i(r6, r14, r15)     // Catch:{ Exception -> 0x024f }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r20 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ Exception -> 0x024f }
            java.lang.String r21 = "NETWORK_LOGS"
            int r1 = r1.length     // Catch:{ Exception -> 0x024f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024f }
            r12.<init>(r9)     // Catch:{ Exception -> 0x024f }
            r12.append(r1)     // Catch:{ Exception -> 0x024f }
            r12.append(r8)     // Catch:{ Exception -> 0x024f }
            r12.append(r11)     // Catch:{ Exception -> 0x024f }
            java.lang.String r22 = r12.toString()     // Catch:{ Exception -> 0x024f }
            r23 = 0
            r24 = 0
            r25 = 12
            r26 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x024f }
            com.m2catalyst.m2sdk.r2 r1 = r2.configuration     // Catch:{ Exception -> 0x024f }
            com.m2catalyst.m2sdk.z5 r1 = r1.a()     // Catch:{ Exception -> 0x024f }
            com.m2catalyst.m2sdk.a6 r8 = com.m2catalyst.m2sdk.a6.CROWDSOURCE_SHARING_ENABLED     // Catch:{ Exception -> 0x024f }
            java.lang.Object r9 = r8.b()     // Catch:{ Exception -> 0x024f }
            java.lang.String r8 = r8.c()     // Catch:{ Exception -> 0x024f }
            android.content.SharedPreferences r11 = r1.a()     // Catch:{ Exception -> 0x024f }
            java.util.Map r11 = r11.getAll()     // Catch:{ Exception -> 0x024f }
            boolean r11 = r11.containsKey(r8)     // Catch:{ Exception -> 0x024f }
            if (r11 != 0) goto L_0x020f
            goto L_0x021b
        L_0x020f:
            android.content.SharedPreferences r1 = r1.a()     // Catch:{ Exception -> 0x024f }
            java.util.Map r1 = r1.getAll()     // Catch:{ Exception -> 0x024f }
            java.lang.Object r9 = r1.get(r8)     // Catch:{ Exception -> 0x024f }
        L_0x021b:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r19)     // Catch:{ Exception -> 0x024f }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r1)     // Catch:{ Exception -> 0x024f }
            if (r1 == 0) goto L_0x023d
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository r1 = r2.badSignalsRepository     // Catch:{ Exception -> 0x024f }
            int r3 = r3.size()     // Catch:{ Exception -> 0x024f }
            r0.L$0 = r2     // Catch:{ Exception -> 0x024f }
            r0.L$1 = r5     // Catch:{ Exception -> 0x024f }
            r0.L$2 = r5     // Catch:{ Exception -> 0x024f }
            r0.L$3 = r5     // Catch:{ Exception -> 0x024f }
            r8 = 5
            r0.label = r8     // Catch:{ Exception -> 0x024f }
            java.lang.Object r1 = r1.addBadSignalCount(r10, r3, r0)     // Catch:{ Exception -> 0x024f }
            if (r1 != r4) goto L_0x023d
            return r4
        L_0x023d:
            r0.L$0 = r2     // Catch:{ Exception -> 0x024f }
            r0.L$1 = r5     // Catch:{ Exception -> 0x024f }
            r0.L$2 = r5     // Catch:{ Exception -> 0x024f }
            r0.L$3 = r5     // Catch:{ Exception -> 0x024f }
            r1 = 6
            r0.label = r1     // Catch:{ Exception -> 0x024f }
            java.lang.Object r0 = r2.markDataTransmitted(r0)     // Catch:{ Exception -> 0x024f }
            if (r0 != r4) goto L_0x027a
            return r4
        L_0x024f:
            r0 = move-exception
            r17 = r0
        L_0x0252:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r2.transmitLogger
            java.lang.String r1 = r17.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error writing packet to file "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String[] r2 = new java.lang.String[r13]
            r0.e(r6, r1, r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r15 = "NETWORK_LOGS"
            java.lang.String r16 = "Error writing packet to file"
            r18 = 0
            r19 = 8
            r20 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r14, r15, r16, r17, r18, r19, r20)
        L_0x027a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.buildNetworkLogsPacket(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearMNSIEntries(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$clearMNSIEntries$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$clearMNSIEntries$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$clearMNSIEntries$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$clearMNSIEntries$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$clearMNSIEntries$1
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
            com.m2catalyst.m2sdk.database.daos.MNSIDao r10 = r9.mnsiDao
            r0.label = r3
            java.lang.Object r10 = r10.clearMNSITable(r0)
            if (r10 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "NETWORK_LOGS"
            java.lang.String r4 = "Clearing mnsi entries from database"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.clearMNSIEntries(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteMNSIEntries(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$deleteMNSIEntries$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$deleteMNSIEntries$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$deleteMNSIEntries$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$deleteMNSIEntries$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$deleteMNSIEntries$1
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
            com.m2catalyst.m2sdk.database.daos.MNSIDao r10 = r9.mnsiDao
            r0.label = r3
            java.lang.Object r10 = r10.deleteMNSIEntries(r0)
            if (r10 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "NETWORK_LOGS"
            java.lang.String r4 = "Deleting MSNI entries from database"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.deleteMNSIEntries(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Long} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd A[LOOP:0: B:46:0x00f7->B:48:0x00fd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMNSI(java.lang.Long r11, java.lang.Long r12, java.lang.Integer r13, kotlin.coroutines.Continuation<? super java.util.List<? extends com.m2catalyst.m2sdk.business.models.MNSI>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSI$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSI$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSI$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSI$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r11 = r0.L$2
            r13 = r11
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r11 = r0.L$1
            r12 = r11
            java.lang.Long r12 = (java.lang.Long) r12
            java.lang.Object r11 = r0.L$0
            java.lang.Long r11 = (java.lang.Long) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e0
        L_0x003b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0043:
            java.lang.Object r11 = r0.L$2
            r13 = r11
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r11 = r0.L$1
            r12 = r11
            java.lang.Long r12 = (java.lang.Long) r12
            java.lang.Object r11 = r0.L$0
            java.lang.Long r11 = (java.lang.Long) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00c6
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r14)
            if (r11 == 0) goto L_0x005f
            java.lang.String r14 = r11.toString()
            goto L_0x0060
        L_0x005f:
            r14 = 0
        L_0x0060:
            java.lang.String r2 = ""
            java.lang.String r5 = "timeStamp >="
            java.lang.String r14 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r14)
            if (r13 == 0) goto L_0x007c
            int r2 = r13.intValue()
            r5 = -1
            if (r2 == r5) goto L_0x007c
            java.lang.String r2 = r13.toString()
            java.lang.String r5 = "simSlot ="
            java.lang.String r14 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r14, (java.lang.String) r5, (java.lang.String) r2)
        L_0x007c:
            int r2 = r14.length()
            r5 = 0
            if (r2 <= 0) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            if (r2 == 0) goto L_0x0099
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r14 = " ORDER BY timeStamp ASC"
            r2.append(r14)
            java.lang.String r14 = r2.toString()
        L_0x0099:
            int r2 = r14.length()
            if (r2 <= 0) goto L_0x00a0
            r5 = 1
        L_0x00a0:
            if (r5 == 0) goto L_0x00cf
            com.m2catalyst.m2sdk.database.daos.MNSIDao r2 = r10.mnsiDao
            androidx.sqlite.db.SimpleSQLiteQuery r3 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "SELECT * FROM mnsi_tbl WHERE "
            r5.<init>(r6)
            r5.append(r14)
            java.lang.String r14 = r5.toString()
            r3.<init>(r14)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.label = r4
            java.lang.Object r14 = r2.getMNSIWithWhereClause(r3, r0)
            if (r14 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x00e8
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x00e8
        L_0x00cf:
            com.m2catalyst.m2sdk.database.daos.MNSIDao r14 = r10.mnsiDao
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.label = r3
            java.lang.Object r14 = r14.getMNSI(r0)
            if (r14 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x00e8
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00e8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r1)
            r0.<init>(r1)
            java.util.Iterator r14 = r14.iterator()
        L_0x00f7:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x010c
            java.lang.Object r1 = r14.next()
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r1 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r1
            com.m2catalyst.m2sdk.business.models.MNSI r2 = new com.m2catalyst.m2sdk.business.models.MNSI
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x00f7
        L_0x010c:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r14 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "MNS Query for startDate="
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = ", stopDate="
            r1.append(r11)
            r1.append(r12)
            java.lang.String r11 = ", simSlot="
            r1.append(r11)
            r1.append(r13)
            java.lang.String r11 = " returned "
            r1.append(r11)
            r1.append(r14)
            java.lang.String r11 = " entries"
            r1.append(r11)
            java.lang.String r5 = r1.toString()
            java.lang.String r4 = "NETWORK_LOGS"
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.getMNSI(java.lang.Long, java.lang.Long, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMNSIById(long r5, kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.MNSI> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIById$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIById$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIById$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIById$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.database.daos.MNSIDao r7 = r4.mnsiDao
            r0.label = r3
            java.lang.Object r7 = r7.getMNSIEntry(r5, r0)
            if (r7 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r7 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r7
            if (r7 == 0) goto L_0x0049
            com.m2catalyst.m2sdk.business.models.MNSI r5 = new com.m2catalyst.m2sdk.business.models.MNSI
            r5.<init>(r7)
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.getMNSIById(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public MutableLiveData<MNSI> getMNSILiveData(MNSI_TYPE mnsi_type) {
        Intrinsics.checkNotNullParameter(mnsi_type, "type");
        SDKState stateForLiveData = getStateForLiveData();
        if (mnsi_type == MNSI_TYPE.COMPLETE) {
            if (stateForLiveData != null) {
                return stateForLiveData.getCompleteMNSILiveData();
            }
        } else if (stateForLiveData != null) {
            return stateForLiveData.getRawMNSILiveData();
        }
        return null;
    }

    @w2
    public MNSI getMNSIRecordById(long j) {
        if (M2SDK.INSTANCE.isAccessible(new MNSIRepository$getMNSIRecordById$1(this), this.accessComponent) || getTesting()) {
            return (MNSI) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MNSIRepository$getMNSIRecordById$2(this, j, (Continuation<? super MNSIRepository$getMNSIRecordById$2>) null), 1, (Object) null);
        }
        return null;
    }

    @w2
    public List<MNSI> getMNSIRecords(Long l, Long l2, Integer num) {
        if (M2SDK.INSTANCE.isAccessible(new MNSIRepository$getMNSIRecords$1(this), this.accessComponent) || getTesting()) {
            return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MNSIRepository$getMNSIRecords$2(this, l, l2, num, (Continuation<? super MNSIRepository$getMNSIRecords$2>) null), 1, (Object) null);
        }
        return new ArrayList();
    }

    @w2
    public List<MNSI> getMNSIRecordsInBoundries(double d, double d2, double d3, double d4, Long l, Long l2, String str, Integer num) {
        if (!M2SDK.INSTANCE.isAccessible(new MNSIRepository$getMNSIRecordsInBoundries$1(this), this.accessComponent) && !getTesting()) {
            return new ArrayList();
        }
        MNSIRepository$getMNSIRecordsInBoundries$2 mNSIRepository$getMNSIRecordsInBoundries$2 = r0;
        MNSIRepository$getMNSIRecordsInBoundries$2 mNSIRepository$getMNSIRecordsInBoundries$22 = new MNSIRepository$getMNSIRecordsInBoundries$2(d2, d4, d, d3, l, l2, str, this, num, (Continuation<? super MNSIRepository$getMNSIRecordsInBoundries$2>) null);
        return (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, mNSIRepository$getMNSIRecordsInBoundries$2, 1, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0144 A[LOOP:0: B:57:0x013e->B:59:0x0144, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMNSIWithLastIdAndLimit(java.lang.Long r11, java.lang.Boolean r12, java.lang.Integer r13, java.lang.Integer r14, kotlin.coroutines.Continuation<? super java.util.List<? extends com.m2catalyst.m2sdk.business.models.MNSI>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdAndLimit$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdAndLimit$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdAndLimit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdAndLimit$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdAndLimit$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0060
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r11 = r0.L$3
            r14 = r11
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r11 = r0.L$2
            r13 = r11
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r11 = r0.L$1
            r12 = r11
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            java.lang.Object r11 = r0.L$0
            java.lang.Long r11 = (java.lang.Long) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0127
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0048:
            java.lang.Object r11 = r0.L$3
            r14 = r11
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r11 = r0.L$2
            r13 = r11
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r11 = r0.L$1
            r12 = r11
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            java.lang.Object r11 = r0.L$0
            java.lang.Long r11 = (java.lang.Long) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x010b
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            if (r11 == 0) goto L_0x006b
            java.lang.String r2 = r11.toString()
            goto L_0x006c
        L_0x006b:
            r2 = r15
        L_0x006c:
            java.lang.String r5 = ""
            java.lang.String r6 = "timeStamp >="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r2)
            if (r12 == 0) goto L_0x0088
            boolean r5 = r12.booleanValue()
            int r5 = com.m2catalyst.m2sdk.o1.a((boolean) r5)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r5 = r5.toString()
            goto L_0x0089
        L_0x0088:
            r5 = r15
        L_0x0089:
            java.lang.String r6 = "transmitted ="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r6, (java.lang.String) r5)
            if (r13 == 0) goto L_0x0096
            java.lang.String r15 = r13.toString()
        L_0x0096:
            java.lang.String r5 = "id <="
            java.lang.String r15 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r15)
            r2 = 0
            if (r14 == 0) goto L_0x00a7
            int r5 = r14.intValue()
            if (r5 <= 0) goto L_0x00a7
            r5 = 1
            goto L_0x00a8
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            int r6 = r15.length()
            if (r6 <= 0) goto L_0x00b0
            r6 = 1
            goto L_0x00b1
        L_0x00b0:
            r6 = 0
        L_0x00b1:
            if (r6 != 0) goto L_0x00b5
            if (r5 == 0) goto L_0x00c6
        L_0x00b5:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r15)
            java.lang.String r15 = " ORDER BY timeStamp ASC"
            r6.append(r15)
            java.lang.String r15 = r6.toString()
        L_0x00c6:
            if (r5 == 0) goto L_0x00dc
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r15)
            java.lang.String r15 = " LIMIT "
            r5.append(r15)
            r5.append(r14)
            java.lang.String r15 = r5.toString()
        L_0x00dc:
            int r5 = r15.length()
            if (r5 <= 0) goto L_0x00e3
            r2 = 1
        L_0x00e3:
            if (r2 == 0) goto L_0x0114
            com.m2catalyst.m2sdk.database.daos.MNSIDao r2 = r10.mnsiDao
            androidx.sqlite.db.SimpleSQLiteQuery r3 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "SELECT * FROM mnsi_tbl WHERE "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r15 = r5.toString()
            r3.<init>(r15)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r14
            r0.label = r4
            java.lang.Object r15 = r2.getMNSIWithWhereClause(r3, r0)
            if (r15 != r1) goto L_0x010b
            return r1
        L_0x010b:
            java.util.List r15 = (java.util.List) r15
            if (r15 != 0) goto L_0x012f
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x012f
        L_0x0114:
            com.m2catalyst.m2sdk.database.daos.MNSIDao r15 = r10.mnsiDao
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r14
            r0.label = r3
            java.lang.Object r15 = r15.getMNSI(r0)
            if (r15 != r1) goto L_0x0127
            return r1
        L_0x0127:
            java.util.List r15 = (java.util.List) r15
            if (r15 != 0) goto L_0x012f
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
        L_0x012f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r1)
            r0.<init>(r1)
            java.util.Iterator r15 = r15.iterator()
        L_0x013e:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0153
            java.lang.Object r1 = r15.next()
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r1 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r1
            com.m2catalyst.m2sdk.business.models.MNSI r2 = new com.m2catalyst.m2sdk.business.models.MNSI
            r2.<init>(r1)
            r0.add(r2)
            goto L_0x013e
        L_0x0153:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r15 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "MNS Query for startDate="
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = ", transmitted="
            r1.append(r11)
            r1.append(r12)
            java.lang.String r11 = ", lastId="
            r1.append(r11)
            r1.append(r13)
            java.lang.String r11 = ", limit="
            r1.append(r11)
            r1.append(r14)
            java.lang.String r11 = " returned "
            r1.append(r11)
            r1.append(r15)
            java.lang.String r11 = " entries"
            r1.append(r11)
            java.lang.String r5 = r1.toString()
            java.lang.String r4 = "NETWORK_LOGS"
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.getMNSIWithLastIdAndLimit(java.lang.Long, java.lang.Boolean, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0157 A[LOOP:0: B:62:0x0151->B:64:0x0157, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMNSIWithLastIdLimitAndTransmittedFilter(java.lang.Long r10, java.lang.Boolean r11, java.lang.Integer r12, java.lang.Integer r13, java.lang.Integer r14, kotlin.coroutines.Continuation<? super java.util.List<? extends com.m2catalyst.m2sdk.business.models.MNSI>> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1
            r0.<init>(r9, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0060
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r10 = r0.L$3
            r13 = r10
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r10 = r0.L$2
            r12 = r10
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            java.lang.Object r10 = r0.L$0
            java.lang.Long r10 = (java.lang.Long) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x013a
        L_0x0040:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0048:
            java.lang.Object r10 = r0.L$3
            r13 = r10
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r10 = r0.L$2
            r12 = r10
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            java.lang.Object r10 = r0.L$0
            java.lang.Long r10 = (java.lang.Long) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x011e
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            if (r10 == 0) goto L_0x006b
            java.lang.String r2 = r10.toString()
            goto L_0x006c
        L_0x006b:
            r2 = r15
        L_0x006c:
            java.lang.String r5 = ""
            java.lang.String r6 = "timeStamp >="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r2)
            if (r11 == 0) goto L_0x0088
            boolean r5 = r11.booleanValue()
            int r5 = com.m2catalyst.m2sdk.o1.a((boolean) r5)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r5 = r5.toString()
            goto L_0x0089
        L_0x0088:
            r5 = r15
        L_0x0089:
            java.lang.String r6 = "transmitted ="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r6, (java.lang.String) r5)
            if (r12 == 0) goto L_0x0096
            java.lang.String r15 = r12.toString()
        L_0x0096:
            java.lang.String r5 = "id <="
            java.lang.String r15 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r15)
            if (r14 == 0) goto L_0x00af
            int r2 = r14.intValue()
            r5 = -1
            if (r2 == r5) goto L_0x00af
            java.lang.String r14 = r14.toString()
            java.lang.String r2 = "simSlot ="
            java.lang.String r15 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r15, (java.lang.String) r2, (java.lang.String) r14)
        L_0x00af:
            r14 = 0
            if (r13 == 0) goto L_0x00ba
            int r2 = r13.intValue()
            if (r2 <= 0) goto L_0x00ba
            r2 = 1
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            int r5 = r15.length()
            if (r5 <= 0) goto L_0x00c3
            r5 = 1
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            if (r5 != 0) goto L_0x00c8
            if (r2 == 0) goto L_0x00d9
        L_0x00c8:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r15)
            java.lang.String r15 = " ORDER BY timeStamp ASC"
            r5.append(r15)
            java.lang.String r15 = r5.toString()
        L_0x00d9:
            if (r2 == 0) goto L_0x00ef
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r15)
            java.lang.String r15 = " LIMIT "
            r2.append(r15)
            r2.append(r13)
            java.lang.String r15 = r2.toString()
        L_0x00ef:
            int r2 = r15.length()
            if (r2 <= 0) goto L_0x00f6
            r14 = 1
        L_0x00f6:
            if (r14 == 0) goto L_0x0127
            com.m2catalyst.m2sdk.database.daos.MNSIDao r14 = r9.mnsiDao
            androidx.sqlite.db.SimpleSQLiteQuery r2 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "SELECT * FROM mnsi_tbl WHERE "
            r3.<init>(r5)
            r3.append(r15)
            java.lang.String r15 = r3.toString()
            r2.<init>(r15)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.label = r4
            java.lang.Object r15 = r14.getMNSIWithWhereClause(r2, r0)
            if (r15 != r1) goto L_0x011e
            return r1
        L_0x011e:
            java.util.List r15 = (java.util.List) r15
            if (r15 != 0) goto L_0x0142
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0142
        L_0x0127:
            com.m2catalyst.m2sdk.database.daos.MNSIDao r14 = r9.mnsiDao
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.label = r3
            java.lang.Object r15 = r14.getMNSI(r0)
            if (r15 != r1) goto L_0x013a
            return r1
        L_0x013a:
            java.util.List r15 = (java.util.List) r15
            if (r15 != 0) goto L_0x0142
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0142:
            java.util.ArrayList r14 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r0)
            r14.<init>(r0)
            java.util.Iterator r15 = r15.iterator()
        L_0x0151:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0166
            java.lang.Object r0 = r15.next()
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r0 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r0
            com.m2catalyst.m2sdk.business.models.MNSI r1 = new com.m2catalyst.m2sdk.business.models.MNSI
            r1.<init>(r0)
            r14.add(r1)
            goto L_0x0151
        L_0x0166:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r15 = r14.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "MNS Query for startDate="
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r10 = ", transmitted="
            r0.append(r10)
            r0.append(r11)
            java.lang.String r10 = ", lastId="
            r0.append(r10)
            r0.append(r12)
            java.lang.String r10 = ", limit="
            r0.append(r10)
            r0.append(r13)
            java.lang.String r10 = " returned "
            r0.append(r10)
            r0.append(r15)
            java.lang.String r10 = " entries"
            r0.append(r10)
            java.lang.String r4 = r0.toString()
            java.lang.String r3 = "NETWORK_LOGS"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.getMNSIWithLastIdLimitAndTransmittedFilter(java.lang.Long, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMNSIWithNoSub(long r8, long r10, kotlin.coroutines.Continuation<? super java.util.List<? extends com.m2catalyst.m2sdk.business.models.MNSI>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithNoSub$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithNoSub$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithNoSub$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithNoSub$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIWithNoSub$1
            r0.<init>(r7, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            com.m2catalyst.m2sdk.database.daos.MNSIDao r1 = r7.mnsiDao
            r6.label = r2
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.getMNSIEntries(r2, r4, r6)
            if (r12 != r0) goto L_0x0042
            return r0
        L_0x0042:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x006a
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r12, r9)
            r8.<init>(r9)
            java.util.Iterator r9 = r12.iterator()
        L_0x0055:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x006e
            java.lang.Object r10 = r9.next()
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r10 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r10
            com.m2catalyst.m2sdk.business.models.MNSI r11 = new com.m2catalyst.m2sdk.business.models.MNSI
            r11.<init>(r10)
            r8.add(r11)
            goto L_0x0055
        L_0x006a:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x006e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.getMNSIWithNoSub(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @w2
    public final SDKState getStateForLiveData() {
        if (M2SDK.INSTANCE.isAccessible(new MNSIRepository$getStateForLiveData$1(this), this.accessComponent)) {
            return SDKState.Companion.getInstance();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertMNSIEntry(com.m2catalyst.m2sdk.database.entities.MNSIEntity r11, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$insertMNSIEntry$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$insertMNSIEntry$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$insertMNSIEntry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$insertMNSIEntry$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$insertMNSIEntry$1
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
            com.m2catalyst.m2sdk.database.daos.MNSIDao r12 = r10.mnsiDao
            r0.label = r3
            java.lang.Object r12 = r12.insertMNSIEntry(r11, r0)
            if (r12 != r1) goto L_0x003f
            return r1
        L_0x003f:
            java.lang.Number r12 = (java.lang.Number) r12
            long r11 = r12.longValue()
            r0 = -1
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0059
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.MNSI_COLLECTED
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
        L_0x0059:
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.insertMNSIEntry(com.m2catalyst.m2sdk.database.entities.MNSIEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object markMNSITransmitted(java.util.List<java.lang.Integer> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r12 = r0.L$1
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r0 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0050
        L_0x0031:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r13)
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$operations$1 r13 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$markMNSITransmitted$operations$1
            r2 = 0
            r13.<init>(r11, r2)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r13 = com.m2catalyst.m2sdk.c6.a(r12, r13, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r13 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r11
        L_0x0050:
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.transmitLogger
            int r1 = r12.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "markMNSITransmitted Marking "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = r2.toString()
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "MNSIRepository"
            r0.d(r3, r1, r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r12 = r12.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Marking "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = " as ready to transmit (packet already built and saved into file) in "
            r0.append(r12)
            r0.append(r13)
            java.lang.String r12 = " operations "
            r0.append(r12)
            java.lang.String r6 = r0.toString()
            java.lang.String r5 = "NETWORK_LOGS"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.markMNSITransmitted(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0111 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0114 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0215 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitNetworkLogs(kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            java.lang.String r2 = "Error submitting network logs packet "
            boolean r3 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$submitNetworkLogs$1
            if (r3 == 0) goto L_0x0019
            r3 = r0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$submitNetworkLogs$1 r3 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$submitNetworkLogs$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$submitNetworkLogs$1 r3 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$submitNetworkLogs$1
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            java.lang.String r7 = "MNSIRepository"
            r8 = 0
            if (r5 == 0) goto L_0x004e
            if (r5 != r6) goto L_0x0046
            java.lang.Object r5 = r3.L$3
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r9 = r3.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r3.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r3.L$0
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r11 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x00b8
        L_0x0043:
            r0 = move-exception
            goto L_0x024f
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r0)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r1.transmitLogger
            java.lang.String[] r5 = new java.lang.String[r8]
            java.lang.String r9 = "submitNetworkLogs()"
            r0.d(r7, r9, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r25.deleteNetworkFilesAfterTwoWeeks()
            java.util.Map r5 = r25.getNetworkFiles()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
            r10 = r0
            r11 = r1
            r9 = r5
        L_0x0072:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x028c
            java.lang.Object r0 = r9.next()
            r5 = r0
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r11.transmitLogger     // Catch:{ all -> 0x0043 }
            java.lang.Object r12 = r5.getValue()     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r13.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r14 = "entry.value "
            r13.append(r14)     // Catch:{ all -> 0x0043 }
            r13.append(r12)     // Catch:{ all -> 0x0043 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            r0.d(r7, r12, r13)     // Catch:{ all -> 0x0043 }
            boolean r0 = unitTestMode     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x00cb
            com.m2catalyst.m2sdk.v1 r0 = r11.mnsiClient     // Catch:{ all -> 0x0043 }
            java.lang.Object r12 = r5.getValue()     // Catch:{ all -> 0x0043 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0043 }
            r3.L$0 = r11     // Catch:{ all -> 0x0043 }
            r3.L$1 = r10     // Catch:{ all -> 0x0043 }
            r3.L$2 = r9     // Catch:{ all -> 0x0043 }
            r3.L$3 = r5     // Catch:{ all -> 0x0043 }
            r3.label = r6     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r0.a(r12, r3)     // Catch:{ all -> 0x0043 }
            if (r0 != r4) goto L_0x00b8
            return r4
        L_0x00b8:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r0     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r12 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r13 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_NETWORK_PACKET_SENT     // Catch:{ all -> 0x0043 }
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0043 }
            r15 = 0
            r16 = 4
            r17 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0043 }
            goto L_0x00cf
        L_0x00cb:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = r11.returnDummyResponseForUnitTesting()     // Catch:{ all -> 0x0043 }
        L_0x00cf:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.transmitLogger     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r13 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r14.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r15 = "response "
            r14.append(r15)     // Catch:{ all -> 0x0043 }
            r14.append(r13)     // Catch:{ all -> 0x0043 }
            java.lang.String r13 = r14.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String[] r14 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            r12.d(r7, r13, r14)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.transmitLogger     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r13 = r0.success     // Catch:{ all -> 0x0043 }
            java.lang.String r14 = r0.details     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r15.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " success="
            r15.append(r6)     // Catch:{ all -> 0x0043 }
            r15.append(r13)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " response "
            r15.append(r6)     // Catch:{ all -> 0x0043 }
            r15.append(r14)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r15.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            r12.i(r7, r6, r13)     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r6 = r0.success     // Catch:{ all -> 0x0043 }
            if (r6 != 0) goto L_0x0114
            r6 = 0
        L_0x0112:
            r12 = 1
            goto L_0x0119
        L_0x0114:
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0043 }
            goto L_0x0112
        L_0x0119:
            if (r6 != r12) goto L_0x0215
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r6 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x0122
            java.lang.Integer r6 = r6.mobile_network_signal_info_logs_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x0123
        L_0x0122:
            r6 = 0
        L_0x0123:
            int r6 = com.m2catalyst.m2sdk.s1.a(r6, r8)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r14 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r14 == 0) goto L_0x012e
            java.lang.Integer r14 = r14.network_diagnostic_test_results_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x012f
        L_0x012e:
            r14 = 0
        L_0x012f:
            int r14 = com.m2catalyst.m2sdk.s1.a(r14, r8)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r15 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r15 == 0) goto L_0x013a
            java.lang.Integer r15 = r15.no_network_signal_info_logs_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x013b
        L_0x013a:
            r15 = 0
        L_0x013b:
            int r15 = com.m2catalyst.m2sdk.s1.a(r15, r8)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r12 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r12 == 0) goto L_0x0146
            java.lang.Integer r12 = r12.wifi_network_info_logs_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x0147
        L_0x0146:
            r12 = 0
        L_0x0147:
            int r12 = com.m2catalyst.m2sdk.s1.a(r12, r8)     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r13.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r8 = "Submitted network logs packet, with packets accepted \nMOBILE_NETWORK_SIGNAL: "
            r13.append(r8)     // Catch:{ all -> 0x0043 }
            r13.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " \nTEST_DIAGNOSTICS: "
            r13.append(r6)     // Catch:{ all -> 0x0043 }
            r13.append(r14)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " \nNO_NETWORK: "
            r13.append(r6)     // Catch:{ all -> 0x0043 }
            r13.append(r15)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " \nCONNECTIVITY_WIFI: "
            r13.append(r6)     // Catch:{ all -> 0x0043 }
            r13.append(r12)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = "\n"
            r13.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r11.transmitLogger     // Catch:{ all -> 0x0043 }
            r12 = 0
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ all -> 0x0043 }
            r8.d(r7, r6, r13)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r18 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x0043 }
            java.lang.String r19 = "NETWORK_LOGS"
            r21 = 0
            r22 = 0
            r23 = 12
            r24 = 0
            r20 = r6
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0043 }
            java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x0043 }
            r10.add(r5)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r5 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r19 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_NO_SIGNAL_RECORDS_ACCEPTED     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r6 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x01a4
            java.lang.Integer r6 = r6.no_network_signal_info_logs_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x01a5
        L_0x01a4:
            r6 = 0
        L_0x01a5:
            r8 = 0
            int r6 = com.m2catalyst.m2sdk.s1.a(r6, r8)     // Catch:{ all -> 0x0043 }
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0043 }
            r21 = 0
            r22 = 4
            r23 = 0
            r18 = r5
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r19 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_NDT_RECORDS_ACCEPTED     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r6 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x01c2
            java.lang.Integer r6 = r6.network_diagnostic_test_results_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x01c3
        L_0x01c2:
            r6 = 0
        L_0x01c3:
            r8 = 0
            int r6 = com.m2catalyst.m2sdk.s1.a(r6, r8)     // Catch:{ all -> 0x0043 }
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0043 }
            r21 = 0
            r22 = 4
            r23 = 0
            r18 = r5
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r19 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_WIFI_RECORDS_ACCEPTED     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r6 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x01e0
            java.lang.Integer r6 = r6.wifi_network_info_logs_accepted     // Catch:{ all -> 0x0043 }
            goto L_0x01e1
        L_0x01e0:
            r6 = 0
        L_0x01e1:
            r8 = 0
            int r6 = com.m2catalyst.m2sdk.s1.a(r6, r8)     // Catch:{ all -> 0x0043 }
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0043 }
            r21 = 0
            r22 = 4
            r23 = 0
            r18 = r5
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r19 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.TRANSMIT_DATA_SUBMITTED_MNSI_RECORDS_ACCEPTED     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage r0 = r0.network_info_response     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x01ff
            java.lang.Integer r13 = r0.mobile_network_signal_info_logs_accepted     // Catch:{ all -> 0x0043 }
            r6 = 0
            goto L_0x0201
        L_0x01ff:
            r6 = 0
            r13 = 0
        L_0x0201:
            int r0 = com.m2catalyst.m2sdk.s1.a(r13, r6)     // Catch:{ all -> 0x0043 }
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch:{ all -> 0x0043 }
            r21 = 0
            r22 = 4
            r23 = 0
            r18 = r5
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0043 }
            goto L_0x0288
        L_0x0215:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r5 = r11.transmitLogger     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r0.details     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r8.<init>()     // Catch:{ all -> 0x0043 }
            r8.append(r2)     // Catch:{ all -> 0x0043 }
            r8.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0043 }
            r8 = 0
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            r5.i(r7, r6, r12)     // Catch:{ all -> 0x0043 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r18 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x0043 }
            java.lang.String r19 = "NETWORK_LOGS"
            java.lang.String r0 = r0.details     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r5.<init>()     // Catch:{ all -> 0x0043 }
            r5.append(r2)     // Catch:{ all -> 0x0043 }
            r5.append(r0)     // Catch:{ all -> 0x0043 }
            java.lang.String r20 = r5.toString()     // Catch:{ all -> 0x0043 }
            r21 = 0
            r22 = 0
            r23 = 12
            r24 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0043 }
            goto L_0x0288
        L_0x024f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r5 = r11.transmitLogger
            java.lang.String r6 = r0.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r12 = "Error submitting network logs packet - exception: "
            r8.<init>(r12)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r8 = 0
            java.lang.String[] r13 = new java.lang.String[r8]
            r5.e(r7, r6, r13)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r18 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r12)
            r5.append(r0)
            java.lang.String r20 = r5.toString()
            java.lang.String r19 = "NETWORK_LOGS"
            r21 = 0
            r22 = 0
            r23 = 12
            r24 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r18, r19, r20, r21, r22, r23, r24)
        L_0x0288:
            r6 = 1
            r8 = 0
            goto L_0x0072
        L_0x028c:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r11.transmitLogger
            int r2 = r10.size()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "deleteFiles filesToDelete="
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = " "
            r3.append(r2)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]
            r0.d(r7, r2, r3)
            android.content.Context r0 = r11.context
            com.m2catalyst.m2sdk.a2.a((android.content.Context) r0, (java.util.List<java.lang.String>) r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.submitNetworkLogs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateLocationDataFromNetworkDiagnostics(int r11, com.m2catalyst.m2sdk.database.entities.LocationEntity r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.m2catalyst.m2sdk.business.repositories.MNSIRepository$updateLocationDataFromNetworkDiagnostics$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$updateLocationDataFromNetworkDiagnostics$1 r0 = (com.m2catalyst.m2sdk.business.repositories.MNSIRepository$updateLocationDataFromNetworkDiagnostics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository$updateLocationDataFromNetworkDiagnostics$1 r0 = new com.m2catalyst.m2sdk.business.repositories.MNSIRepository$updateLocationDataFromNetworkDiagnostics$1
            r0.<init>(r10, r13)
        L_0x0018:
            r9 = r0
            java.lang.Object r13 = r9.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            int r11 = r9.I$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006b
        L_0x002c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r13)
            com.m2catalyst.m2sdk.database.daos.MNSIDao r1 = r10.mnsiDao
            java.lang.Long r3 = r12.getTimeStamp()
            java.lang.String r4 = r12.getProvider()
            java.lang.Double r5 = r12.getLatitude()
            java.lang.Double r6 = r12.getLongitude()
            java.lang.Float r7 = r12.getAccuracy()
            java.lang.Double r12 = r12.getIndoorOutdoorWeight()
            if (r12 == 0) goto L_0x005d
            double r12 = r12.doubleValue()
            float r12 = (float) r12
            java.lang.Float r12 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
            goto L_0x005e
        L_0x005d:
            r12 = 0
        L_0x005e:
            r8 = r12
            r9.I$0 = r11
            r9.label = r2
            r2 = r11
            java.lang.Object r12 = r1.updateMNSILocationEntryFromNetworkDiagnostics(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r12 != r0) goto L_0x006b
            return r0
        L_0x006b:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Updating diagnostics information in MNSI entry with id "
            r12.<init>(r13)
            r12.append(r11)
            java.lang.String r2 = r12.toString()
            java.lang.String r1 = "NETWORK_LOGS"
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository.updateLocationDataFromNetworkDiagnostics(int, com.m2catalyst.m2sdk.database.entities.LocationEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object updateMobileSignalRxTx(int i, long j, long j2, Continuation<? super Unit> continuation) {
        Object updateMobileSignalRxTx = this.mnsiDao.updateMobileSignalRxTx(i, j, j2, continuation);
        return updateMobileSignalRxTx == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateMobileSignalRxTx : Unit.INSTANCE;
    }
}
