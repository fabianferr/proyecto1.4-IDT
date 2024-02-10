package com.m2catalyst.m2sdk.speed_test;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0000HÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/NDTConfig;", "", "version", "", "maxDataLimit", "", "time", "Lcom/m2catalyst/m2sdk/speed_test/NDTConfigTime;", "roaming", "frequency", "latency", "(IJLcom/m2catalyst/m2sdk/speed_test/NDTConfigTime;IILcom/m2catalyst/m2sdk/speed_test/NDTConfig;)V", "getFrequency", "()I", "getLatency", "()Lcom/m2catalyst/m2sdk/speed_test/NDTConfig;", "getMaxDataLimit", "()J", "getRoaming", "getTime", "()Lcom/m2catalyst/m2sdk/speed_test/NDTConfigTime;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpeedTestNDTApiClient.kt */
public final class NDTConfig {
    private final int frequency;
    private final NDTConfig latency;
    private final long maxDataLimit;
    private final int roaming;
    private final NDTConfigTime time;
    private final int version;

    public NDTConfig(int i, long j, NDTConfigTime nDTConfigTime, int i2, int i3, NDTConfig nDTConfig) {
        this.version = i;
        this.maxDataLimit = j;
        this.time = nDTConfigTime;
        this.roaming = i2;
        this.frequency = i3;
        this.latency = nDTConfig;
    }

    public static /* synthetic */ NDTConfig copy$default(NDTConfig nDTConfig, int i, long j, NDTConfigTime nDTConfigTime, int i2, int i3, NDTConfig nDTConfig2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = nDTConfig.version;
        }
        if ((i4 & 2) != 0) {
            j = nDTConfig.maxDataLimit;
        }
        long j2 = j;
        if ((i4 & 4) != 0) {
            nDTConfigTime = nDTConfig.time;
        }
        NDTConfigTime nDTConfigTime2 = nDTConfigTime;
        if ((i4 & 8) != 0) {
            i2 = nDTConfig.roaming;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = nDTConfig.frequency;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            nDTConfig2 = nDTConfig.latency;
        }
        return nDTConfig.copy(i, j2, nDTConfigTime2, i5, i6, nDTConfig2);
    }

    public final int component1() {
        return this.version;
    }

    public final long component2() {
        return this.maxDataLimit;
    }

    public final NDTConfigTime component3() {
        return this.time;
    }

    public final int component4() {
        return this.roaming;
    }

    public final int component5() {
        return this.frequency;
    }

    public final NDTConfig component6() {
        return this.latency;
    }

    public final NDTConfig copy(int i, long j, NDTConfigTime nDTConfigTime, int i2, int i3, NDTConfig nDTConfig) {
        return new NDTConfig(i, j, nDTConfigTime, i2, i3, nDTConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NDTConfig)) {
            return false;
        }
        NDTConfig nDTConfig = (NDTConfig) obj;
        return this.version == nDTConfig.version && this.maxDataLimit == nDTConfig.maxDataLimit && Intrinsics.areEqual((Object) this.time, (Object) nDTConfig.time) && this.roaming == nDTConfig.roaming && this.frequency == nDTConfig.frequency && Intrinsics.areEqual((Object) this.latency, (Object) nDTConfig.latency);
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final NDTConfig getLatency() {
        return this.latency;
    }

    public final long getMaxDataLimit() {
        return this.maxDataLimit;
    }

    public final int getRoaming() {
        return this.roaming;
    }

    public final NDTConfigTime getTime() {
        return this.time;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int m = (UByte$$ExternalSyntheticBackport0.m(this.maxDataLimit) + (this.version * 31)) * 31;
        NDTConfigTime nDTConfigTime = this.time;
        int i = 0;
        int hashCode = nDTConfigTime == null ? 0 : nDTConfigTime.hashCode();
        int i2 = (this.frequency + ((this.roaming + ((m + hashCode) * 31)) * 31)) * 31;
        NDTConfig nDTConfig = this.latency;
        if (nDTConfig != null) {
            i = nDTConfig.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        int i = this.version;
        long j = this.maxDataLimit;
        NDTConfigTime nDTConfigTime = this.time;
        int i2 = this.roaming;
        int i3 = this.frequency;
        NDTConfig nDTConfig = this.latency;
        return "NDTConfig(version=" + i + ", maxDataLimit=" + j + ", time=" + nDTConfigTime + ", roaming=" + i2 + ", frequency=" + i3 + ", latency=" + nDTConfig + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NDTConfig(int i, long j, NDTConfigTime nDTConfigTime, int i2, int i3, NDTConfig nDTConfig, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? 50000000 : j, nDTConfigTime, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 1 : i3, nDTConfig);
    }
}
