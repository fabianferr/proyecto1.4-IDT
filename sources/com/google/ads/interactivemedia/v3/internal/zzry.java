package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzry extends zzrs {
    final Object zza;
    int zzb;
    final /* synthetic */ zzsh zzc;

    zzry(zzsh zzsh, int i) {
        this.zzc = zzsh;
        this.zza = zzsh.zza[i];
        this.zzb = i;
    }

    public final Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        zza();
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return this.zzc.zzb[i];
    }

    public final Object setValue(Object obj) {
        zza();
        int i = this.zzb;
        if (i == -1) {
            this.zzc.zzg(this.zza, obj, false);
            return null;
        }
        Object obj2 = this.zzc.zzb[i];
        if (zzri.zza(obj2, obj)) {
            return obj;
        }
        this.zzc.zzw(this.zzb, obj, false);
        return obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        int i = this.zzb;
        if (i != -1) {
            zzsh zzsh = this.zzc;
            if (i <= zzsh.zzc && zzri.zza(zzsh.zza[i], this.zza)) {
                return;
            }
        }
        zzsh zzsh2 = this.zzc;
        Object obj = this.zza;
        this.zzb = zzsh2.zzc(obj, zzsi.zzc(obj));
    }
}