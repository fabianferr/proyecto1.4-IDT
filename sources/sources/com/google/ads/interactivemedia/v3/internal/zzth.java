package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzth implements Comparator {
    protected zzth() {
    }

    public static zzth zzb() {
        return zztf.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzth zza() {
        return new zztr(this);
    }

    public final zzth zzc(zzrc zzrc) {
        return new zzru(zzrc, this);
    }
}
