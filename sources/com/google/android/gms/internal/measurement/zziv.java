package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zziv implements Comparator {
    zziv() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjd zzjd2 = (zzjd) obj2;
        zziu zziu = new zziu(zzjd);
        zziu zziu2 = new zziu(zzjd2);
        while (zziu.hasNext() && zziu2.hasNext()) {
            int compareTo = Integer.valueOf(zziu.zza() & 255).compareTo(Integer.valueOf(zziu2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzjd.zzd()).compareTo(Integer.valueOf(zzjd2.zzd()));
    }
}
