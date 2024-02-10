package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabk implements zzxj {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzxi zzb;

    zzabk(Class cls, zzxi zzxi) {
        this.zza = cls;
        this.zzb = zzxi;
    }

    public final String toString() {
        String name = this.zza.getName();
        String obj = this.zzb.toString();
        return "Factory[type=" + name + ",adapter=" + obj + "]";
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        if (zzact.zzc() == this.zza) {
            return this.zzb;
        }
        return null;
    }
}
