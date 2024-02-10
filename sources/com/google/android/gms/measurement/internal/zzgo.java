package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgo implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    zzgo(zzgq zzgq, zzq zzq) {
        this.zzb = zzgq;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzL(this.zza);
    }
}
