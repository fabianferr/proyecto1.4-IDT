package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagh {
    private static final zzagh zza = new zzagh();
    private final zzagt zzb = new zzafr();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzagh() {
    }

    public static zzagh zza() {
        return zza;
    }

    public final zzags zzb(Class cls) {
        zzafa.zzc(cls, "messageType");
        zzags zzags = (zzags) this.zzc.get(cls);
        if (zzags == null) {
            zzags = this.zzb.zza(cls);
            zzafa.zzc(cls, "messageType");
            zzafa.zzc(zzags, "schema");
            zzags zzags2 = (zzags) this.zzc.putIfAbsent(cls, zzags);
            return zzags2 == null ? zzags : zzags2;
        }
    }
}
