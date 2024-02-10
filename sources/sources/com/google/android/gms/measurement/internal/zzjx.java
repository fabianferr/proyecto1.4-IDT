package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzjx implements Runnable {
    final /* synthetic */ zzkz zza;
    final /* synthetic */ Runnable zzb;

    zzjx(zzjz zzjz, zzkz zzkz, Runnable runnable) {
        this.zza = zzkz;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
