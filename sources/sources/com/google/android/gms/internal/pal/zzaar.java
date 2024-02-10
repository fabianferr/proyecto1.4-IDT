package com.google.android.gms.internal.pal;

import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzaar implements zzzh {
    final /* synthetic */ Class zza;
    final /* synthetic */ Class zzb;
    final /* synthetic */ zzzg zzc;

    zzaar(Class cls, Class cls2, zzzg zzzg) {
        this.zza = cls;
        this.zzb = cls2;
        this.zzc = zzzg;
    }

    public final String toString() {
        return "Factory[type=" + this.zza.getName() + Marker.ANY_NON_NULL_MARKER + this.zzb.getName() + ",adapter=" + this.zzc + "]";
    }
}
