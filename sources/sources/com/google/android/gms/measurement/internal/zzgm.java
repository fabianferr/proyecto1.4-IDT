package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgm implements Runnable {
    final /* synthetic */ zzlc zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    zzgm(zzgq zzgq, zzlc zzlc, zzq zzq) {
        this.zzc = zzgq;
        this.zza = zzlc;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzP(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzW(this.zza, this.zzb);
        }
    }
}
