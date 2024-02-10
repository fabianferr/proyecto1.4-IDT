package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabo implements zzxj {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzxi zzb;

    zzabo(Class cls, zzxi zzxi) {
        this.zza = cls;
        this.zzb = zzxi;
    }

    public final String toString() {
        String name = this.zza.getName();
        String obj = this.zzb.toString();
        return "Factory[typeHierarchy=" + name + ",adapter=" + obj + "]";
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Class zzc = zzact.zzc();
        if (!this.zza.isAssignableFrom(zzc)) {
            return null;
        }
        return new zzabn(this, zzc);
    }
}
