package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzadj implements Comparator {
    zzadj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzadr zzadr = (zzadr) obj;
        zzadr zzadr2 = (zzadr) obj2;
        zzadm zzr = zzadr.iterator();
        zzadm zzr2 = zzadr2.iterator();
        while (zzr.hasNext() && zzr2.hasNext()) {
            int compareTo = Integer.valueOf(zzr.zza() & 255).compareTo(Integer.valueOf(zzr2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzadr.zzd()).compareTo(Integer.valueOf(zzadr2.zzd()));
    }
}
