package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaef {
    static final zzaef zza = new zzaef(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzaef zzd;
    private final Map zze;

    zzaef() {
        this.zze = new HashMap();
    }

    public static zzaef zza() {
        return zza;
    }

    public final zzaer zzc(zzafz zzafz, int i) {
        return (zzaer) this.zze.get(new zzaee(zzafz, i));
    }

    zzaef(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzaef zzb() {
        zzaef zzaef = zzd;
        if (zzaef != null) {
            return zzaef;
        }
        synchronized (zzaef.class) {
            zzaef zzaef2 = zzd;
            if (zzaef2 != null) {
                return zzaef2;
            }
            zzaef zzb2 = zzaen.zzb(zzaef.class);
            zzd = zzb2;
            return zzb2;
        }
    }
}
