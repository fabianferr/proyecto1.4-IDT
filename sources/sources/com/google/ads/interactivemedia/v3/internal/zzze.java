package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzze {
    public static boolean zza(AccessibleObject accessibleObject, Object obj) {
        return zzzd.zzb.zza(accessibleObject, obj);
    }

    public static boolean zzb(Class cls) {
        return zzf(cls.getName());
    }

    public static boolean zzc(Class cls) {
        String name = cls.getName();
        return zzf(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static boolean zzd(Class cls) {
        return zzg(cls.getName());
    }

    public static int zze(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int zza = ((zzxe) it.next()).zza(cls);
            if (zza != 2) {
                return zza;
            }
        }
        return 1;
    }

    private static boolean zzf(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || zzg(str);
    }

    private static boolean zzg(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}
