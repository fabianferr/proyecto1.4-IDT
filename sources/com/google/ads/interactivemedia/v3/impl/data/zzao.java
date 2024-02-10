package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzao extends zzbr {
    private final long currentTime;
    private final long duration;
    private final String timeUnit = "ms";

    zzao(long j, long j2, String str) {
        this.currentTime = j;
        this.duration = j2;
    }

    public long currentTime() {
        return this.currentTime;
    }

    public long duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbr) {
            zzbr zzbr = (zzbr) obj;
            return this.currentTime == zzbr.currentTime() && this.duration == zzbr.duration() && this.timeUnit.equals(zzbr.timeUnit());
        }
    }

    public int hashCode() {
        long j = this.currentTime;
        long j2 = this.duration;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.timeUnit.hashCode();
    }

    public String timeUnit() {
        return this.timeUnit;
    }

    public String toString() {
        long j = this.currentTime;
        long j2 = this.duration;
        String str = this.timeUnit;
        return "TimeUpdateData{currentTime=" + j + ", duration=" + j2 + ", timeUnit=" + str + "}";
    }
}
