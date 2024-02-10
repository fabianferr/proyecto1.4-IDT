package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzh.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzb {
    public static zza builder() {
        return new zzf();
    }

    public abstract String appState();

    public abstract String eventId();

    public abstract long nativeTime();

    public abstract zzau nativeViewBounds();

    public abstract boolean nativeViewHidden();

    public abstract zzau nativeViewVisibleBounds();

    public abstract double nativeVolume();

    public abstract String queryId();
}
