package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzao implements Runnable {
    final /* synthetic */ zzgt zza;
    final /* synthetic */ zzap zzb;

    zzao(zzap zzap, zzgt zzgt) {
        this.zzb = zzap;
        this.zza = zzgt;
    }

    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
