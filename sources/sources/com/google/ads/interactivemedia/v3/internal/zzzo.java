package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzo implements zzxj {
    private final zzyl zza;

    public zzzo(zzyl zzyl) {
        this.zza = zzyl;
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Type zzd = zzact.zzd();
        Class zzc = zzact.zzc();
        if (!Collection.class.isAssignableFrom(zzc)) {
            return null;
        }
        Type zzd2 = zzxr.zzd(zzd, zzc);
        return new zzzn(zzwm, zzd2, zzwm.zza(zzact.zzb(zzd2)), this.zza.zza(zzact));
    }
}
