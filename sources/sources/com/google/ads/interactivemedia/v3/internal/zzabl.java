package com.google.ads.interactivemedia.v3.internal;

import org.slf4j.Marker;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabl implements zzxj {
    final /* synthetic */ Class zza;
    final /* synthetic */ Class zzb;
    final /* synthetic */ zzxi zzc;

    zzabl(Class cls, Class cls2, zzxi zzxi) {
        this.zza = cls;
        this.zzb = cls2;
        this.zzc = zzxi;
    }

    public final String toString() {
        String name = this.zzb.getName();
        String name2 = this.zza.getName();
        String obj = this.zzc.toString();
        return "Factory[type=" + name + Marker.ANY_NON_NULL_MARKER + name2 + ",adapter=" + obj + "]";
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Class zzc2 = zzact.zzc();
        if (zzc2 == this.zza || zzc2 == this.zzb) {
            return this.zzc;
        }
        return null;
    }
}
