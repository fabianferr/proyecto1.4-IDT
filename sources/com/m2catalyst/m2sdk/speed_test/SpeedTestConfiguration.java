package com.m2catalyst.m2sdk.speed_test;

import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00103\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010J\u001a\u000207J\u0015\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bNR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010*\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001e\u0010-\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00103\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006O"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/SpeedTestConfiguration;", "", "()V", "accuracy", "", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "algorithm", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestServingAlgorithm;", "getAlgorithm$m2sdk_release", "()Lcom/m2catalyst/m2sdk/speed_test/SpeedTestServingAlgorithm;", "setAlgorithm$m2sdk_release", "(Lcom/m2catalyst/m2sdk/speed_test/SpeedTestServingAlgorithm;)V", "latitude", "", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "longitude", "getLongitude", "setLongitude", "maxDataSize", "", "getMaxDataSize", "()J", "setMaxDataSize", "(J)V", "maxDataSizePermitted", "getMaxDataSizePermitted", "setMaxDataSizePermitted", "mcc", "", "getMcc", "()Ljava/lang/Integer;", "setMcc", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mnc", "getMnc", "setMnc", "mnsiId", "getMnsiId", "()Ljava/lang/Long;", "setMnsiId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "networkType", "getNetworkType", "setNetworkType", "requiresMNSI", "", "getRequiresMNSI", "()Z", "setRequiresMNSI", "(Z)V", "testType", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestType;", "getTestType", "()Lcom/m2catalyst/m2sdk/speed_test/SpeedTestType;", "setTestType", "(Lcom/m2catalyst/m2sdk/speed_test/SpeedTestType;)V", "trigger", "getTrigger", "()I", "setTrigger", "(I)V", "addContextualData", "networkMnc", "networkMcc", "canRunSpeedTest", "merge", "ndtConfig", "Lcom/m2catalyst/m2sdk/speed_test/NDTConfig;", "merge$m2sdk_release", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpeedTestConfiguration.kt */
public final class SpeedTestConfiguration {
    private Float accuracy;
    private SpeedTestServingAlgorithm algorithm = SpeedTestServingAlgorithm.M2_INTERNAL;
    private Double latitude;
    private Double longitude;
    private long maxDataSize;
    private long maxDataSizePermitted = ThroughputConfigUtil.DEFAULT_DATA_LIMIT;
    private Integer mcc;
    private Integer mnc;
    private Long mnsiId;
    private Integer networkType;
    private boolean requiresMNSI;
    private SpeedTestType testType = SpeedTestType.LEGACY;
    private int trigger;

    public final SpeedTestConfiguration addContextualData(int i, int i2, double d, double d2, float f, int i3, long j) {
        this.mnc = Integer.valueOf(i);
        this.mcc = Integer.valueOf(i2);
        this.latitude = Double.valueOf(d);
        this.longitude = Double.valueOf(d2);
        this.accuracy = Float.valueOf(f);
        this.networkType = Integer.valueOf(i3);
        this.mnsiId = Long.valueOf(j);
        return this;
    }

    public final boolean canRunSpeedTest() {
        return true;
    }

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final SpeedTestServingAlgorithm getAlgorithm$m2sdk_release() {
        return this.algorithm;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final long getMaxDataSize() {
        return this.maxDataSize;
    }

    public final long getMaxDataSizePermitted() {
        return this.maxDataSizePermitted;
    }

    public final Integer getMcc() {
        return this.mcc;
    }

    public final Integer getMnc() {
        return this.mnc;
    }

    public final Long getMnsiId() {
        return this.mnsiId;
    }

    public final Integer getNetworkType() {
        return this.networkType;
    }

    public final boolean getRequiresMNSI() {
        return this.requiresMNSI;
    }

    public final SpeedTestType getTestType() {
        return this.testType;
    }

    public final int getTrigger() {
        return this.trigger;
    }

    public final SpeedTestConfiguration merge$m2sdk_release(NDTConfig nDTConfig) {
        Intrinsics.checkNotNullParameter(nDTConfig, "ndtConfig");
        this.maxDataSize = nDTConfig.getMaxDataLimit();
        return this;
    }

    public final void setAccuracy(Float f) {
        this.accuracy = f;
    }

    public final void setAlgorithm$m2sdk_release(SpeedTestServingAlgorithm speedTestServingAlgorithm) {
        Intrinsics.checkNotNullParameter(speedTestServingAlgorithm, "<set-?>");
        this.algorithm = speedTestServingAlgorithm;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final void setMaxDataSize(long j) {
        this.maxDataSize = j;
    }

    public final void setMaxDataSizePermitted(long j) {
        this.maxDataSizePermitted = j;
    }

    public final void setMcc(Integer num) {
        this.mcc = num;
    }

    public final void setMnc(Integer num) {
        this.mnc = num;
    }

    public final void setMnsiId(Long l) {
        this.mnsiId = l;
    }

    public final void setNetworkType(Integer num) {
        this.networkType = num;
    }

    public final void setRequiresMNSI(boolean z) {
        this.requiresMNSI = z;
    }

    public final void setTestType(SpeedTestType speedTestType) {
        Intrinsics.checkNotNullParameter(speedTestType, "<set-?>");
        this.testType = speedTestType;
    }

    public final void setTrigger(int i) {
        this.trigger = i;
    }
}
