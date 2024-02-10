package com.m2catalyst.m2sdk.external;

import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.b3;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NoSignalData;
import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.business.repositories.MNSI_TYPE;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalTimeRange;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.speed_test.legacy.TestBaseEvent;
import com.m2catalyst.m2sdk.t4;
import com.m2catalyst.m2sdk.w2;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\t\u0019\u001a\u001b\u001c\u001d\u001e\u001f !J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001a\u0010\u0018\u001a\u00020\u0017*\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\""}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability;", "", "Lcom/m2catalyst/m2sdk/external/DataAvailability$ConfigurationAvailability;", "getConfiguration", "Lcom/m2catalyst/m2sdk/external/DataAvailability$LocationDataAvailability;", "getLocationData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$RFNetworkDataAvailability;", "getRFNetworkData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NoSignalAvailability;", "getNoSignalData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$WifiAvailability;", "getWifiData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NetworkDiagnosticsAvailability;", "getNetworkDiagnosticsData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$BadSignalAvailability;", "getBadSignalsData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$DeviceInfoAvailability;", "getDeviceInfoData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$SDKStateAvailability;", "getSDKState", "Lkotlin/reflect/KFunction;", "Lcom/m2catalyst/m2sdk/l2;", "component", "", "isAccessible", "BadSignalAvailability", "ConfigurationAvailability", "DeviceInfoAvailability", "LocationDataAvailability", "NetworkDiagnosticsAvailability", "NoSignalAvailability", "RFNetworkDataAvailability", "SDKStateAvailability", "WifiAvailability", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: DataAvailability.kt */
public interface DataAvailability {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$BadSignalAvailability;", "", "addEntries", "", "entries", "", "Lcom/m2catalyst/m2sdk/database/entities/BadSignal;", "getBadSignalCounts", "", "time", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface BadSignalAvailability {
        void addEntries(List<BadSignal> list);

        int[] getBadSignalCounts(BadSignalTimeRange badSignalTimeRange);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$ConfigurationAvailability;", "", "getM2Uuid", "", "getSDKVersion", "isCollectionRunning", "", "()Ljava/lang/Boolean;", "isTransmitting", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface ConfigurationAvailability {
        String getM2Uuid();

        String getSDKVersion();

        Boolean isCollectionRunning();

        Boolean isTransmitting();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public static final class DefaultImpls {
        public static boolean isAccessible(DataAvailability dataAvailability, KFunction<?> kFunction, l2 l2Var) {
            T t;
            T t2;
            Intrinsics.checkNotNullParameter(kFunction, "$receiver");
            if (l2Var == null) {
                return false;
            }
            Iterator<T> it = kFunction.getAnnotations().iterator();
            while (true) {
                t = null;
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (((Annotation) t2) instanceof w2) {
                    break;
                }
            }
            boolean areEqual = ((Annotation) t2) != null ? Intrinsics.areEqual((Object) l2Var.a, (Object) Boolean.TRUE) : true;
            Iterator<T> it2 = kFunction.getAnnotations().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (((Annotation) next) instanceof b3) {
                    t = next;
                    break;
                }
            }
            boolean areEqual2 = ((Annotation) t) != null ? Intrinsics.areEqual((Object) l2Var.b, (Object) Boolean.TRUE) : true;
            if (areEqual && areEqual2) {
                return true;
            }
            M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Component", "Missing required access", (Exception) null, false, 12, (Object) null);
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$DeviceInfoAvailability;", "", "getDeviceId", "", "()Ljava/lang/Integer;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface DeviceInfoAvailability {
        Integer getDeviceId();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\fH&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$LocationDataAvailability;", "", "addM2Locations", "", "entries", "", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "([Lcom/m2catalyst/m2sdk/business/models/M2Location;)V", "getM2LocationById", "locationId", "", "getM2LocationLiveData", "Landroidx/lifecycle/MutableLiveData;", "getM2Locations", "", "startDate", "", "endDate", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface LocationDataAvailability {
        void addM2Locations(M2Location... m2LocationArr);

        M2Location getM2LocationById(int i);

        MutableLiveData<M2Location> getM2LocationLiveData();

        List<M2Location> getM2Locations(long j, long j2);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\rH&J[\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$NetworkDiagnosticsAvailability;", "", "addNetworkDiagnosticList", "", "ndt", "", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "addNetworkDiagnosticResult", "", "entry", "getNetworkDiagnosticById", "testId", "getNetworkDiagnosticCount", "", "getNetworkDiagnosticsResults", "startTime", "endTime", "testTrigger", "testType", "transmitted", "", "limit", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Ljava/util/List;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface NetworkDiagnosticsAvailability {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DataAvailability.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ List getNetworkDiagnosticsResults$default(NetworkDiagnosticsAvailability networkDiagnosticsAvailability, Long l, Long l2, Integer num, Integer num2, Boolean bool, Integer num3, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        l = null;
                    }
                    if ((i & 2) != 0) {
                        l2 = null;
                    }
                    if ((i & 4) != 0) {
                        num = null;
                    }
                    if ((i & 8) != 0) {
                        num2 = null;
                    }
                    if ((i & 16) != 0) {
                        bool = null;
                    }
                    if ((i & 32) != 0) {
                        num3 = null;
                    }
                    return networkDiagnosticsAvailability.getNetworkDiagnosticsResults(l, l2, num, num2, bool, num3);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNetworkDiagnosticsResults");
            }
        }

        void addNetworkDiagnosticList(List<DiagnosticsResults> list);

        long addNetworkDiagnosticResult(DiagnosticsResults diagnosticsResults);

        DiagnosticsResults getNetworkDiagnosticById(long j);

        int getNetworkDiagnosticCount();

        List<DiagnosticsResults> getNetworkDiagnosticsResults(Long l, Long l2, Integer num, Integer num2, Boolean bool, Integer num3);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$NoSignalAvailability;", "", "addNoSignal", "", "noSignalRecord", "Lcom/m2catalyst/m2sdk/business/models/NoSignalData;", "getNoSignals", "", "startDate", "", "endDate", "simSlot", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface NoSignalAvailability {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DataAvailability.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ List getNoSignals$default(NoSignalAvailability noSignalAvailability, Long l, Long l2, Integer num, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        l = null;
                    }
                    if ((i & 2) != 0) {
                        l2 = null;
                    }
                    if ((i & 4) != 0) {
                        num = null;
                    }
                    return noSignalAvailability.getNoSignals(l, l2, num);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNoSignals");
            }
        }

        void addNoSignal(NoSignalData noSignalData);

        List<NoSignalData> getNoSignals(Long l, Long l2, Integer num);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH&J1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u0015J[\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$RFNetworkDataAvailability;", "", "addMNSIRecord", "", "mnsi", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "([Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", "getMNSILiveData", "Landroidx/lifecycle/MutableLiveData;", "type", "Lcom/m2catalyst/m2sdk/business/repositories/MNSI_TYPE;", "getMNSIRecordById", "id", "", "getMNSIRecords", "", "startDate", "stopDate", "sub", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", "getMNSIRecordsInBoundries", "upperLeftLat", "", "upperLeftLong", "lowerRightLat", "lowerRightLong", "startTime", "endTime", "networkType", "", "limit", "(DDDDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface RFNetworkDataAvailability {
        void addMNSIRecord(MNSI... mnsiArr);

        MutableLiveData<MNSI> getMNSILiveData(MNSI_TYPE mnsi_type);

        MNSI getMNSIRecordById(long j);

        List<MNSI> getMNSIRecords(Long l, Long l2, Integer num);

        List<MNSI> getMNSIRecordsInBoundries(double d, double d2, double d3, double d4, Long l, Long l2, String str, Integer num);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001e\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$SDKStateAvailability;", "", "", "getFineLocationPermissionGranted", "()Ljava/lang/Boolean;", "getCoarseLocationPermissionGranted", "getBackgroundLocationPermissionGranted", "getReadPhoneStatePermissionGranted", "getPackageUsageStatsPermissionGranted", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsis", "Lcom/m2catalyst/m2sdk/t4;", "getReportOnMNSIList", "", "sim", "Landroidx/lifecycle/MutableLiveData;", "", "getCellLogBySimLiveData", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "getCurrentNDTTest", "Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", "getLastNDTEvent", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
    /* compiled from: DataAvailability.kt */
    public interface SDKStateAvailability {
        Boolean getBackgroundLocationPermissionGranted();

        MutableLiveData<List<String>> getCellLogBySimLiveData(int i);

        Boolean getCoarseLocationPermissionGranted();

        DiagnosticsResults getCurrentNDTTest();

        Boolean getFineLocationPermissionGranted();

        TestBaseEvent getLastNDTEvent();

        Boolean getPackageUsageStatsPermissionGranted();

        Boolean getReadPhoneStatePermissionGranted();

        t4 getReportOnMNSIList(List<? extends MNSI> list);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lcom/m2catalyst/m2sdk/external/DataAvailability$WifiAvailability;", "", "addWifiRecord", "", "wifi", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "getWifiConnectedLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getWifiLiveData", "getWifiRecordById", "id", "", "getWifiRecords", "", "startDate", "endDate", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataAvailability.kt */
    public interface WifiAvailability {
        void addWifiRecord(Wifi wifi);

        MutableLiveData<Boolean> getWifiConnectedLiveData();

        MutableLiveData<Wifi> getWifiLiveData();

        Wifi getWifiRecordById(long j);

        List<Wifi> getWifiRecords(long j, long j2);
    }

    BadSignalAvailability getBadSignalsData();

    ConfigurationAvailability getConfiguration();

    DeviceInfoAvailability getDeviceInfoData();

    LocationDataAvailability getLocationData();

    NetworkDiagnosticsAvailability getNetworkDiagnosticsData();

    NoSignalAvailability getNoSignalData();

    RFNetworkDataAvailability getRFNetworkData();

    SDKStateAvailability getSDKState();

    WifiAvailability getWifiData();

    boolean isAccessible(KFunction<?> kFunction, l2 l2Var);
}
