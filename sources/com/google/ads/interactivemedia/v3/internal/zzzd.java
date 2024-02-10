package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzzd {
    public static final zzzd zzb;

    static {
        zzzd zzzd = null;
        if (zzyo.zza()) {
            try {
                zzzd = new zzza(AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class}));
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzzd == null) {
            zzzd = new zzzb();
        }
        zzb = zzzd;
    }

    /* synthetic */ zzzd(zzzc zzzc) {
    }

    public abstract boolean zza(AccessibleObject accessibleObject, Object obj);
}
