package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzh extends zzb {
    private final String appState;
    private final String eventId;
    private final long nativeTime;
    private final zzau nativeViewBounds;
    private final boolean nativeViewHidden;
    private final zzau nativeViewVisibleBounds;
    private final double nativeVolume;
    private final String queryId;

    private zzh(String str, String str2, String str3, long j, double d, boolean z, zzau zzau, zzau zzau2) {
        this.queryId = str;
        this.eventId = str2;
        this.appState = str3;
        this.nativeTime = j;
        this.nativeVolume = d;
        this.nativeViewHidden = z;
        this.nativeViewBounds = zzau;
        this.nativeViewVisibleBounds = zzau2;
    }

    public String appState() {
        return this.appState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzb) {
            zzb zzb = (zzb) obj;
            return this.queryId.equals(zzb.queryId()) && this.eventId.equals(zzb.eventId()) && this.appState.equals(zzb.appState()) && this.nativeTime == zzb.nativeTime() && Double.doubleToLongBits(this.nativeVolume) == Double.doubleToLongBits(zzb.nativeVolume()) && this.nativeViewHidden == zzb.nativeViewHidden() && this.nativeViewBounds.equals(zzb.nativeViewBounds()) && this.nativeViewVisibleBounds.equals(zzb.nativeViewVisibleBounds());
        }
    }

    public String eventId() {
        return this.eventId;
    }

    public int hashCode() {
        int hashCode = ((((this.queryId.hashCode() ^ 1000003) * 1000003) ^ this.eventId.hashCode()) * 1000003) ^ this.appState.hashCode();
        long j = this.nativeTime;
        return (((((((((hashCode * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.nativeVolume) >>> 32) ^ Double.doubleToLongBits(this.nativeVolume)))) * 1000003) ^ (true != this.nativeViewHidden ? 1237 : 1231)) * 1000003) ^ this.nativeViewBounds.hashCode()) * 1000003) ^ this.nativeViewVisibleBounds.hashCode();
    }

    public long nativeTime() {
        return this.nativeTime;
    }

    public zzau nativeViewBounds() {
        return this.nativeViewBounds;
    }

    public boolean nativeViewHidden() {
        return this.nativeViewHidden;
    }

    public zzau nativeViewVisibleBounds() {
        return this.nativeViewVisibleBounds;
    }

    public double nativeVolume() {
        return this.nativeVolume;
    }

    public String queryId() {
        return this.queryId;
    }

    public String toString() {
        String str = this.queryId;
        String str2 = this.eventId;
        String str3 = this.appState;
        long j = this.nativeTime;
        double d = this.nativeVolume;
        boolean z = this.nativeViewHidden;
        String valueOf = String.valueOf(this.nativeViewBounds);
        String valueOf2 = String.valueOf(this.nativeViewVisibleBounds);
        return "ActivityMonitorData{queryId=" + str + ", eventId=" + str2 + ", appState=" + str3 + ", nativeTime=" + j + ", nativeVolume=" + d + ", nativeViewHidden=" + z + ", nativeViewBounds=" + valueOf + ", nativeViewVisibleBounds=" + valueOf2 + "}";
    }
}
