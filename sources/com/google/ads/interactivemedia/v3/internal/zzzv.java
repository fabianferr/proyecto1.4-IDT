package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzv implements zzxj {
    private final zzyl zza;

    public zzzv(zzyl zzyl, boolean z) {
        this.zza = zzyl;
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        zzxi zzxi;
        Type zzd = zzact.zzd();
        Class zzc = zzact.zzc();
        if (!Map.class.isAssignableFrom(zzc)) {
            return null;
        }
        Type[] zzh = zzxr.zzh(zzd, zzc);
        Type type = zzh[0];
        if (type == Boolean.TYPE || type == Boolean.class) {
            zzxi = zzaby.zzf;
        } else {
            zzxi = zzwm.zza(zzact.zzb(type));
        }
        zzxi zza2 = zzwm.zza(zzact.zzb(zzh[1]));
        zzyz zza3 = this.zza.zza(zzact);
        return new zzzu(this, zzwm, zzh[0], zzxi, zzh[1], zza2, zza3);
    }
}
