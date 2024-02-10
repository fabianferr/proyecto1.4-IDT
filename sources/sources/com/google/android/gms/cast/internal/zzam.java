package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzam implements zzat {
    final /* synthetic */ zzat zza;
    final /* synthetic */ zzaq zzb;

    zzam(zzaq zzaq, zzat zzat) {
        this.zzb = zzaq;
        this.zza = zzat;
    }

    public final void zza(long j, int i, Object obj) {
        if (this.zza != null) {
            if (i == 2001) {
                zzaq zzaq = this.zzb;
                zzaq.zza.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(zzaq.zzz));
                this.zzb.zzy.zzl();
                i = 2001;
            }
            this.zza.zza(j, i, obj);
        }
    }

    public final void zzb(long j) {
        zzat zzat = this.zza;
        if (zzat != null) {
            zzat.zzb(j);
        }
    }
}
