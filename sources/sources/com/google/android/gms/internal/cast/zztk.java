package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zztk {
    zztk() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zztj zztj = (zztj) obj;
        zzti zzti = (zzti) obj2;
        if (zztj.isEmpty()) {
            return 0;
        }
        Iterator it = zztj.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }
}
