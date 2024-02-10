package com.m2catalyst.m2sdk.ndt.models;

import android.content.Context;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkDiagnosticTestResultsMessage;
import com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.o4;
import com.m2catalyst.m2sdk.s1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_J\u0010\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020\u0003H\u0002J\u0012\u0010b\u001a\u00020]2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010c\u001a\u00020]2\u0006\u0010a\u001a\u00020\u0003H\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010a\u001a\u00020\u0003H\u0002J\u0010\u0010e\u001a\u00020]2\u0006\u0010a\u001a\u00020\u0003H\u0002J\r\u0010f\u001a\u00020\u0003H\u0000¢\u0006\u0002\bgJ\u0006\u0010h\u001a\u00020iJ\b\u0010j\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00102\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010<\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR\u001e\u0010D\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bE\u0010.\"\u0004\bF\u00100R\u001e\u0010G\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R\u001e\u0010J\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010\u0019R\u001e\u0010M\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\bN\u0010\u0017\"\u0004\bO\u0010\u0019R\u001a\u0010P\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0012\"\u0004\bR\u0010\u0014R\u001c\u0010S\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R\u001c\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006k"}, d2 = {"Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "", "networkDiagnostics", "Lcom/m2catalyst/m2sdk/database/entities/NetworkDiagnosticsEntity;", "mnsiRecord", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "(Lcom/m2catalyst/m2sdk/database/entities/NetworkDiagnosticsEntity;Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", "()V", "TEST_COUNTER", "", "cellId", "", "getCellId", "()Ljava/lang/String;", "setCellId", "(Ljava/lang/String;)V", "cellIdChanged", "getCellIdChanged", "()I", "setCellIdChanged", "(I)V", "connectionType", "getConnectionType", "()Ljava/lang/Integer;", "setConnectionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "debugTestNumber", "getDebugTestNumber", "setDebugTestNumber", "distanceChange", "", "getDistanceChange", "()Ljava/lang/Double;", "setDistanceChange", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "downloadTestResults", "Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults;", "getDownloadTestResults", "()Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults;", "setDownloadTestResults", "(Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults;)V", "endTime", "", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "id", "getId", "setId", "latencyResults", "Lcom/m2catalyst/m2sdk/ndt/models/LatencyTestResults;", "getLatencyResults", "()Lcom/m2catalyst/m2sdk/ndt/models/LatencyTestResults;", "setLatencyResults", "(Lcom/m2catalyst/m2sdk/ndt/models/LatencyTestResults;)V", "value", "mnsi", "getMnsi", "()Lcom/m2catalyst/m2sdk/business/models/MNSI;", "setMnsi", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", "permissions", "getPermissions", "setPermissions", "startTime", "getStartTime", "setStartTime", "testTrigger", "getTestTrigger", "setTestTrigger", "testType", "getTestType", "setTestType", "timeOffset", "getTimeOffset", "setTimeOffset", "transmitted", "getTransmitted", "setTransmitted", "uploadTestResults", "getUploadTestResults", "setUploadTestResults", "wifi", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "getWifi", "()Lcom/m2catalyst/m2sdk/business/models/Wifi;", "setWifi", "(Lcom/m2catalyst/m2sdk/business/models/Wifi;)V", "addPermissionValues", "", "context", "Landroid/content/Context;", "generalSetup", "entity", "mnsiSetup", "setupDownloadResults", "setupLatency", "setupUploadResults", "toEntity", "toEntity$m2sdk_release", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/NetworkDiagnosticTestResultsMessage;", "toString", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTModels.kt */
public final class DiagnosticsResults {
    private int TEST_COUNTER;
    private String cellId;
    private int cellIdChanged;
    private Integer connectionType;
    private int debugTestNumber;
    private Double distanceChange;
    private BandwidthTestResults downloadTestResults;
    private Long endTime;
    private Long id;
    private LatencyTestResults latencyResults;
    private MNSI mnsi;
    private String permissions;
    private Long startTime;
    private Integer testTrigger;
    private Integer testType;
    private Integer timeOffset;
    private int transmitted;
    private BandwidthTestResults uploadTestResults;
    private Wifi wifi;

    public DiagnosticsResults() {
        this.startTime = Long.valueOf(System.currentTimeMillis());
    }

    private final void generalSetup(NetworkDiagnosticsEntity networkDiagnosticsEntity) {
        int i = this.TEST_COUNTER + 1;
        this.TEST_COUNTER = i;
        this.debugTestNumber = i;
        this.id = Long.valueOf(networkDiagnosticsEntity.getId());
        this.transmitted = networkDiagnosticsEntity.getTransmitted();
        this.startTime = Long.valueOf(networkDiagnosticsEntity.getStartTest());
        this.endTime = Long.valueOf(networkDiagnosticsEntity.getEndTest());
        this.timeOffset = networkDiagnosticsEntity.getTimeOffset();
        this.connectionType = networkDiagnosticsEntity.getConnectionType();
        this.cellId = networkDiagnosticsEntity.getCellID();
        Integer cellIDChanged = networkDiagnosticsEntity.getCellIDChanged();
        this.cellIdChanged = cellIDChanged != null ? cellIDChanged.intValue() : 0;
        this.distanceChange = networkDiagnosticsEntity.getLocationDiff();
        this.testTrigger = networkDiagnosticsEntity.getTestTrigger();
        this.testType = networkDiagnosticsEntity.getTestType();
    }

    private final void mnsiSetup(MNSI mnsi2) {
        if (mnsi2 != null) {
            setMnsi(new MNSI(mnsi2.toEntity$m2sdk_release()));
            MNSI mnsi3 = this.mnsi;
            Intrinsics.checkNotNull(mnsi3);
            mnsi3.setId(mnsi2.getId());
            MNSI mnsi4 = this.mnsi;
            Intrinsics.checkNotNull(mnsi4);
            mnsi4.getUniqueCellIdentifier();
        }
    }

    private final void setupDownloadResults(NetworkDiagnosticsEntity networkDiagnosticsEntity) {
        BandwidthTestResults bandwidthTestResults = new BandwidthTestResults();
        this.downloadTestResults = bandwidthTestResults;
        bandwidthTestResults.setType(1);
        Double downloadMin = networkDiagnosticsEntity.getDownloadMin();
        Long l = null;
        bandwidthTestResults.setMin(downloadMin != null ? Float.valueOf((float) downloadMin.doubleValue()) : null);
        Double downloadMax = networkDiagnosticsEntity.getDownloadMax();
        bandwidthTestResults.setMax(downloadMax != null ? Float.valueOf((float) downloadMax.doubleValue()) : null);
        Double downloadAvg = networkDiagnosticsEntity.getDownloadAvg();
        bandwidthTestResults.setAvg(downloadAvg != null ? Float.valueOf((float) downloadAvg.doubleValue()) : null);
        Integer downloadDataUsed = networkDiagnosticsEntity.getDownloadDataUsed();
        if (downloadDataUsed != null) {
            l = Long.valueOf((long) downloadDataUsed.intValue());
        }
        bandwidthTestResults.setDataSize(l);
        Integer downloadAlgorithm = networkDiagnosticsEntity.getDownloadAlgorithm();
        bandwidthTestResults.setAlgorithm(downloadAlgorithm != null ? downloadAlgorithm.intValue() : 0);
    }

    private final void setupLatency(NetworkDiagnosticsEntity networkDiagnosticsEntity) {
        LatencyTestResults latencyTestResults = new LatencyTestResults();
        this.latencyResults = latencyTestResults;
        Double latencyMin = networkDiagnosticsEntity.getLatencyMin();
        Float f = null;
        latencyTestResults.setMinimum(latencyMin != null ? Float.valueOf((float) latencyMin.doubleValue()) : null);
        Double latencyMax = networkDiagnosticsEntity.getLatencyMax();
        latencyTestResults.setMaximum(latencyMax != null ? Float.valueOf((float) latencyMax.doubleValue()) : null);
        Double latencyAvg = networkDiagnosticsEntity.getLatencyAvg();
        latencyTestResults.setAverage(latencyAvg != null ? Float.valueOf((float) latencyAvg.doubleValue()) : null);
        Double latencyDev = networkDiagnosticsEntity.getLatencyDev();
        if (latencyDev != null) {
            f = Float.valueOf((float) latencyDev.doubleValue());
        }
        latencyTestResults.setMDev(f);
        latencyTestResults.setJitter(networkDiagnosticsEntity.getJitter());
        latencyTestResults.setServerIP(networkDiagnosticsEntity.getServerIP());
        int latencyAlgorithm = networkDiagnosticsEntity.getLatencyAlgorithm();
        if (latencyAlgorithm == null) {
            latencyAlgorithm = 0;
        }
        latencyTestResults.setAlgorithm(latencyAlgorithm);
    }

    private final void setupUploadResults(NetworkDiagnosticsEntity networkDiagnosticsEntity) {
        BandwidthTestResults bandwidthTestResults = new BandwidthTestResults();
        this.uploadTestResults = bandwidthTestResults;
        bandwidthTestResults.setType(2);
        Double uploadMin = networkDiagnosticsEntity.getUploadMin();
        Long l = null;
        bandwidthTestResults.setMin(uploadMin != null ? Float.valueOf((float) uploadMin.doubleValue()) : null);
        Double uploadMax = networkDiagnosticsEntity.getUploadMax();
        bandwidthTestResults.setMax(uploadMax != null ? Float.valueOf((float) uploadMax.doubleValue()) : null);
        Double uploadAvg = networkDiagnosticsEntity.getUploadAvg();
        bandwidthTestResults.setAvg(uploadAvg != null ? Float.valueOf((float) uploadAvg.doubleValue()) : null);
        Integer uploadDataUsed = networkDiagnosticsEntity.getUploadDataUsed();
        if (uploadDataUsed != null) {
            l = Long.valueOf((long) uploadDataUsed.intValue());
        }
        bandwidthTestResults.setDataSize(l);
        Integer uploadAlgorithm = networkDiagnosticsEntity.getUploadAlgorithm();
        bandwidthTestResults.setAlgorithm(uploadAlgorithm != null ? uploadAlgorithm.intValue() : 0);
    }

    public final void addPermissionValues(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.permissions = o4.a(SDKState.Companion.getInstance(), context, "ndt");
    }

    public final String getCellId() {
        return this.cellId;
    }

    public final int getCellIdChanged() {
        return this.cellIdChanged;
    }

    public final Integer getConnectionType() {
        return this.connectionType;
    }

    public final int getDebugTestNumber() {
        return this.debugTestNumber;
    }

    public final Double getDistanceChange() {
        return this.distanceChange;
    }

    public final BandwidthTestResults getDownloadTestResults() {
        return this.downloadTestResults;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getId() {
        return this.id;
    }

    public final LatencyTestResults getLatencyResults() {
        return this.latencyResults;
    }

    public final MNSI getMnsi() {
        return this.mnsi;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getTestTrigger() {
        return this.testTrigger;
    }

    public final Integer getTestType() {
        return this.testType;
    }

    public final Integer getTimeOffset() {
        return this.timeOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final BandwidthTestResults getUploadTestResults() {
        return this.uploadTestResults;
    }

    public final Wifi getWifi() {
        return this.wifi;
    }

    public final void setCellId(String str) {
        this.cellId = str;
    }

    public final void setCellIdChanged(int i) {
        this.cellIdChanged = i;
    }

    public final void setConnectionType(Integer num) {
        this.connectionType = num;
    }

    public final void setDebugTestNumber(int i) {
        this.debugTestNumber = i;
    }

    public final void setDistanceChange(Double d) {
        this.distanceChange = d;
    }

    public final void setDownloadTestResults(BandwidthTestResults bandwidthTestResults) {
        this.downloadTestResults = bandwidthTestResults;
    }

    public final void setEndTime(Long l) {
        this.endTime = l;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final void setLatencyResults(LatencyTestResults latencyTestResults) {
        this.latencyResults = latencyTestResults;
    }

    public final void setMnsi(MNSI mnsi2) {
        this.mnsi = mnsi2;
    }

    public final void setPermissions(String str) {
        this.permissions = str;
    }

    public final void setStartTime(Long l) {
        this.startTime = l;
    }

    public final void setTestTrigger(Integer num) {
        this.testTrigger = num;
    }

    public final void setTestType(Integer num) {
        this.testType = num;
    }

    public final void setTimeOffset(Integer num) {
        this.timeOffset = num;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final void setUploadTestResults(BandwidthTestResults bandwidthTestResults) {
        this.uploadTestResults = bandwidthTestResults;
    }

    public final void setWifi(Wifi wifi2) {
        this.wifi = wifi2;
    }

    public final NetworkDiagnosticsEntity toEntity$m2sdk_release() {
        NetworkDiagnosticsEntity networkDiagnosticsEntity = new NetworkDiagnosticsEntity();
        Long l = this.id;
        Set<String> set = s1.a;
        long j = 0;
        networkDiagnosticsEntity.setId(l != null ? l.longValue() : 0);
        Long l2 = this.startTime;
        networkDiagnosticsEntity.setStartTest(l2 != null ? l2.longValue() : 0);
        Long l3 = this.endTime;
        if (l3 != null) {
            j = l3.longValue();
        }
        networkDiagnosticsEntity.setEndTest(j);
        networkDiagnosticsEntity.setPermissions(this.permissions);
        LatencyTestResults latencyTestResults = this.latencyResults;
        Double d = null;
        if (latencyTestResults != null) {
            networkDiagnosticsEntity.setServerIP(latencyTestResults.getServerIP());
            Float minimum = latencyTestResults.getMinimum();
            networkDiagnosticsEntity.setLatencyMin(minimum != null ? Double.valueOf((double) minimum.floatValue()) : null);
            Float maximum = latencyTestResults.getMaximum();
            networkDiagnosticsEntity.setLatencyMax(maximum != null ? Double.valueOf((double) maximum.floatValue()) : null);
            Float average = latencyTestResults.getAverage();
            networkDiagnosticsEntity.setLatencyAvg(average != null ? Double.valueOf((double) average.floatValue()) : null);
            Float mDev = latencyTestResults.getMDev();
            networkDiagnosticsEntity.setLatencyDev(mDev != null ? Double.valueOf((double) mDev.floatValue()) : null);
            networkDiagnosticsEntity.setJitter(latencyTestResults.getJitter());
            networkDiagnosticsEntity.setLatencyAlgorithm(latencyTestResults.getAlgorithm());
        }
        networkDiagnosticsEntity.setTimeOffset(this.timeOffset);
        networkDiagnosticsEntity.setConnectionType(this.connectionType);
        BandwidthTestResults bandwidthTestResults = this.uploadTestResults;
        int i = -1;
        if (bandwidthTestResults != null) {
            Long dataSize = bandwidthTestResults.getDataSize();
            Integer valueOf = dataSize != null ? Integer.valueOf((int) dataSize.longValue()) : null;
            networkDiagnosticsEntity.setUploadDataUsed(Integer.valueOf(valueOf != null ? valueOf.intValue() : -1));
            networkDiagnosticsEntity.setUploadAlgorithm(Integer.valueOf(bandwidthTestResults.getAlgorithm()));
            Float min = bandwidthTestResults.getMin();
            networkDiagnosticsEntity.setUploadMin(min != null ? Double.valueOf((double) min.floatValue()) : null);
            Float max = bandwidthTestResults.getMax();
            networkDiagnosticsEntity.setUploadMax(max != null ? Double.valueOf((double) max.floatValue()) : null);
            Float avg = bandwidthTestResults.getAvg();
            networkDiagnosticsEntity.setUploadAvg(avg != null ? Double.valueOf((double) avg.floatValue()) : null);
        }
        BandwidthTestResults bandwidthTestResults2 = this.downloadTestResults;
        if (bandwidthTestResults2 != null) {
            Long dataSize2 = bandwidthTestResults2.getDataSize();
            Integer valueOf2 = dataSize2 != null ? Integer.valueOf((int) dataSize2.longValue()) : null;
            if (valueOf2 != null) {
                i = valueOf2.intValue();
            }
            networkDiagnosticsEntity.setDownloadDataUsed(Integer.valueOf(i));
            networkDiagnosticsEntity.setDownloadAlgorithm(Integer.valueOf(bandwidthTestResults2.getAlgorithm()));
            Float min2 = bandwidthTestResults2.getMin();
            networkDiagnosticsEntity.setDownloadMin(min2 != null ? Double.valueOf((double) min2.floatValue()) : null);
            Float max2 = bandwidthTestResults2.getMax();
            networkDiagnosticsEntity.setDownloadMax(max2 != null ? Double.valueOf((double) max2.floatValue()) : null);
            Float avg2 = bandwidthTestResults2.getAvg();
            if (avg2 != null) {
                d = Double.valueOf((double) avg2.floatValue());
            }
            networkDiagnosticsEntity.setDownloadAvg(d);
        }
        networkDiagnosticsEntity.setTransmitted(this.transmitted);
        networkDiagnosticsEntity.setCellID(this.cellId);
        networkDiagnosticsEntity.setCellIDChanged(Integer.valueOf(this.cellIdChanged));
        MNSI mnsi2 = this.mnsi;
        if (mnsi2 != null) {
            networkDiagnosticsEntity.setMnsiID(Integer.valueOf(mnsi2.getId()));
        }
        networkDiagnosticsEntity.setTestTrigger(this.testTrigger);
        networkDiagnosticsEntity.setTestType(this.testType);
        Wifi wifi2 = this.wifi;
        if (wifi2 != null) {
            networkDiagnosticsEntity.setWifiNetworkInfoID(Integer.valueOf((int) wifi2.getId()));
        }
        networkDiagnosticsEntity.setLocationDiff(this.distanceChange);
        return networkDiagnosticsEntity;
    }

    public final NetworkDiagnosticTestResultsMessage toMessage() {
        NetworkDiagnosticTestResultsMessage.Builder builder = new NetworkDiagnosticTestResultsMessage.Builder();
        builder.startTime(this.startTime).endTime(this.endTime).timeOffset(this.timeOffset).connectionType(this.connectionType).cellIdChanged(Integer.valueOf(this.cellIdChanged)).testTrigger(this.testTrigger).testType(this.testType);
        LatencyTestResults latencyTestResults = this.latencyResults;
        if (latencyTestResults != null) {
            builder.latencyResults(latencyTestResults.toMessage());
        }
        BandwidthTestResults bandwidthTestResults = this.downloadTestResults;
        if (bandwidthTestResults != null) {
            builder.downloadTestResults(bandwidthTestResults.toMessage());
        }
        BandwidthTestResults bandwidthTestResults2 = this.uploadTestResults;
        if (bandwidthTestResults2 != null) {
            builder.uploadTestResults(bandwidthTestResults2.toMessage());
        }
        MNSI mnsi2 = this.mnsi;
        if (mnsi2 != null) {
            builder.mnsi(mnsi2.toMessage());
        }
        Wifi wifi2 = this.wifi;
        if (wifi2 != null) {
            builder.wifiNetworkInfo(wifi2.toMessage());
        }
        NetworkDiagnosticTestResultsMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("--Latency Results--");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        LatencyTestResults latencyTestResults = this.latencyResults;
        if (latencyTestResults != null) {
            Intrinsics.checkNotNull(latencyTestResults);
            String serverIP = latencyTestResults.getServerIP();
            sb.append("Server IP: " + serverIP);
            sb.append(System.getProperty("line.separator"));
            LatencyTestResults latencyTestResults2 = this.latencyResults;
            Intrinsics.checkNotNull(latencyTestResults2);
            Float minimum = latencyTestResults2.getMinimum();
            sb.append("Minimum: " + minimum);
            sb.append(System.getProperty("line.separator"));
            LatencyTestResults latencyTestResults3 = this.latencyResults;
            Intrinsics.checkNotNull(latencyTestResults3);
            Float maximum = latencyTestResults3.getMaximum();
            sb.append("Maximum: " + maximum);
            sb.append(System.getProperty("line.separator"));
            LatencyTestResults latencyTestResults4 = this.latencyResults;
            Intrinsics.checkNotNull(latencyTestResults4);
            Float average = latencyTestResults4.getAverage();
            sb.append("Average: " + average);
            sb.append(System.getProperty("line.separator"));
            LatencyTestResults latencyTestResults5 = this.latencyResults;
            Intrinsics.checkNotNull(latencyTestResults5);
            Float mDev = latencyTestResults5.getMDev();
            sb.append("MDev: " + mDev);
            sb.append(System.getProperty("line.separator"));
            LatencyTestResults latencyTestResults6 = this.latencyResults;
            Intrinsics.checkNotNull(latencyTestResults6);
            Double jitter = latencyTestResults6.getJitter();
            sb.append("Jitter: " + jitter);
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
        }
        if (this.downloadTestResults != null) {
            sb.append("--Download Results--");
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults = this.downloadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults);
            Float min = bandwidthTestResults.getMin();
            Intrinsics.checkNotNull(min);
            float f = (float) 1024;
            float f2 = (float) 8;
            sb.append("Download min: " + (((min.floatValue() / f) / f) * f2) + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults2 = this.downloadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults2);
            Float max = bandwidthTestResults2.getMax();
            Intrinsics.checkNotNull(max);
            sb.append("Download max: " + (((max.floatValue() / f) / f) * f2) + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults3 = this.downloadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults3);
            Float avg = bandwidthTestResults3.getAvg();
            Intrinsics.checkNotNull(avg);
            sb.append("Download avg: " + (((avg.floatValue() / f) / f) * f2) + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults4 = this.downloadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults4);
            if (bandwidthTestResults4.getDataSize() != null) {
                BandwidthTestResults bandwidthTestResults5 = this.downloadTestResults;
                Intrinsics.checkNotNull(bandwidthTestResults5);
                Long dataSize = bandwidthTestResults5.getDataSize();
                Intrinsics.checkNotNull(dataSize);
                long j = (long) 1024;
                sb.append("Download data size: " + ((dataSize.longValue() / j) / j) + " MB");
            } else {
                sb.append("Download data size: Null MB");
            }
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
        }
        if (this.uploadTestResults != null) {
            sb.append("--Upload Results--");
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults6 = this.uploadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults6);
            Float min2 = bandwidthTestResults6.getMin();
            Intrinsics.checkNotNull(min2);
            float f3 = (float) 1024;
            float f4 = (float) 8;
            sb.append("Upload min: " + (((min2.floatValue() / f3) / f3) * f4) + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults7 = this.uploadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults7);
            Float max2 = bandwidthTestResults7.getMax();
            Intrinsics.checkNotNull(max2);
            sb.append("Upload max: " + (((max2.floatValue() / f3) / f3) * f4) + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults8 = this.uploadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults8);
            Float avg2 = bandwidthTestResults8.getAvg();
            Intrinsics.checkNotNull(avg2);
            float floatValue = ((avg2.floatValue() / f3) / f3) * f4;
            sb.append("Upload avg: " + floatValue + " Mbs");
            sb.append(System.getProperty("line.separator"));
            BandwidthTestResults bandwidthTestResults9 = this.uploadTestResults;
            Intrinsics.checkNotNull(bandwidthTestResults9);
            if (bandwidthTestResults9.getDataSize() != null) {
                BandwidthTestResults bandwidthTestResults10 = this.uploadTestResults;
                Intrinsics.checkNotNull(bandwidthTestResults10);
                Long dataSize2 = bandwidthTestResults10.getDataSize();
                Intrinsics.checkNotNull(dataSize2);
                long j2 = (long) 1024;
                long longValue = (dataSize2.longValue() / j2) / j2;
                sb.append("Upload data size: " + longValue + " MB");
            } else {
                sb.append("Upload data size: Null MB");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DiagnosticsResults(NetworkDiagnosticsEntity networkDiagnosticsEntity, MNSI mnsi2) {
        this();
        Intrinsics.checkNotNullParameter(networkDiagnosticsEntity, "networkDiagnostics");
        generalSetup(networkDiagnosticsEntity);
        mnsiSetup(mnsi2);
        setupLatency(networkDiagnosticsEntity);
        setupDownloadResults(networkDiagnosticsEntity);
        setupUploadResults(networkDiagnosticsEntity);
    }
}
