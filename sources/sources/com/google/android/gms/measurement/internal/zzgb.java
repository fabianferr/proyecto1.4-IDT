package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgb implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzgq zzb;

    zzgb(zzgq zzgq, zzac zzac) {
        this.zzb = zzgq;
        this.zza = zzac;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzN(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
