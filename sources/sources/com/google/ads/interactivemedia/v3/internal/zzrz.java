package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzrz extends zzrs {
    final zzsh zza;
    final Object zzb;
    int zzc;

    zzrz(zzsh zzsh, int i) {
        this.zza = zzsh;
        this.zzb = zzsh.zzb[i];
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i != -1) {
            zzsh zzsh = this.zza;
            if (i <= zzsh.zzc && zzri.zza(this.zzb, zzsh.zzb[i])) {
                return;
            }
        }
        zzsh zzsh2 = this.zza;
        Object obj = this.zzb;
        this.zzc = zzsh2.zzd(obj, zzsi.zzc(obj));
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return this.zza.zza[i];
    }

    public final Object setValue(Object obj) {
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.zzh(this.zzb, obj, false);
            return null;
        }
        Object obj2 = this.zza.zza[i];
        if (zzri.zza(obj2, obj)) {
            return obj;
        }
        this.zza.zzv(this.zzc, obj, false);
        return obj2;
    }
}
