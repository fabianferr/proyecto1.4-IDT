package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgi implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    zzgi(zzgq zzgq, zzq zzq) {
        this.zzb = zzgq;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzkz zzc = this.zzb.zza;
        zzq zzq = this.zza;
        zzc.zzaz().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzq.zza);
        zzai zzb2 = zzai.zzb(zzq.zzv);
        zzai zzh = zzc.zzh(zzq.zza);
        zzc.zzay().zzj().zzc("Setting consent, package, consent", zzq.zza, zzb2);
        zzc.zzV(zzq.zza, zzb2);
        if (zzb2.zzk(zzh)) {
            zzc.zzQ(zzq);
        }
    }
}
