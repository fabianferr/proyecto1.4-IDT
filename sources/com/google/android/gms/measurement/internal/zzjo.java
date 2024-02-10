package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjo implements Runnable {
    final /* synthetic */ zzee zza;
    final /* synthetic */ zzjr zzb;

    zzjo(zzjr zzjr, zzee zzee) {
        this.zzb = zzjr;
        this.zza = zzee;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzay().zzc().zza("Connected to remote service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
