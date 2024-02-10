package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public final class zzjq {
    static final zzjq zza = new zzjq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzjq zzd;
    private final Map zze;

    zzjq() {
        this.zze = new HashMap();
    }

    public final zzkc zzb(zzll zzll, int i) {
        return (zzkc) this.zze.get(new zzjp(zzll, i));
    }

    zzjq(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzjq zza() {
        zzjq zzjq = zzd;
        if (zzjq != null) {
            return zzjq;
        }
        synchronized (zzjq.class) {
            zzjq zzjq2 = zzd;
            if (zzjq2 != null) {
                return zzjq2;
            }
            zzjq zzb2 = zzjy.zzb(zzjq.class);
            zzd = zzb2;
            return zzb2;
        }
    }
}
