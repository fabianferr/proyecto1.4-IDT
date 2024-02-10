package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzzl implements zzxj {
    zzzl() {
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Type type;
        Type zzd = zzact.zzd();
        boolean z = zzd instanceof GenericArrayType;
        if (!z && (!(zzd instanceof Class) || !((Class) zzd).isArray())) {
            return null;
        }
        if (z) {
            type = ((GenericArrayType) zzd).getGenericComponentType();
        } else {
            type = ((Class) zzd).getComponentType();
        }
        return new zzzm(zzwm, zzwm.zza(zzact.zzb(type)), zzxr.zza(type));
    }
}
