package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CuePoint;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzew implements CuePoint {
    private final double zza;
    private final double zzb;
    private final boolean zzc;

    zzew(double d, double d2, boolean z) {
        this.zza = d;
        this.zzb = d2;
        this.zzc = z;
    }

    public final double getEndTime() {
        return this.zzb;
    }

    public final long getEndTimeMs() {
        return (long) Math.floor(this.zzb * 1000.0d);
    }

    public final double getStartTime() {
        return this.zza;
    }

    public final long getStartTimeMs() {
        return (long) Math.floor(this.zza * 1000.0d);
    }

    public final boolean isPlayed() {
        return this.zzc;
    }
}
