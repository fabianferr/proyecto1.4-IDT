package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzlg {
    zzlg() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzlf zzlf = (zzlf) obj;
        zzle zzle = (zzle) obj2;
        if (zzlf.isEmpty()) {
            return 0;
        }
        Iterator it = zzlf.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzlf zzlf = (zzlf) obj;
        zzlf zzlf2 = (zzlf) obj2;
        if (!zzlf2.isEmpty()) {
            if (!zzlf.zze()) {
                zzlf = zzlf.zzb();
            }
            zzlf.zzd(zzlf2);
        }
        return zzlf;
    }
}
