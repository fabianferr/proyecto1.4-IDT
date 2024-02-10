package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzafu {
    zzafu() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzaft zzaft = (zzaft) obj;
        zzafs zzafs = (zzafs) obj2;
        if (zzaft.isEmpty()) {
            return 0;
        }
        Iterator it = zzaft.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzaft) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzaft zzaft = (zzaft) obj;
        zzaft zzaft2 = (zzaft) obj2;
        if (!zzaft2.isEmpty()) {
            if (!zzaft.zze()) {
                zzaft = zzaft.zzb();
            }
            zzaft.zzd(zzaft2);
        }
        return zzaft;
    }
}
