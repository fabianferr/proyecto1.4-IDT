package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzji implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzac zzc;
    final /* synthetic */ zzac zzd;
    final /* synthetic */ zzjs zze;

    zzji(zzjs zzjs, boolean z, zzq zzq, boolean z2, zzac zzac, zzac zzac2) {
        this.zze = zzjs;
        this.zza = zzq;
        this.zzb = z2;
        this.zzc = zzac;
        this.zzd = zzac2;
    }

    public final void run() {
        zzac zzac;
        zzjs zzjs = this.zze;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjs zzjs2 = this.zze;
        if (this.zzb) {
            zzac = null;
        } else {
            zzac = this.zzc;
        }
        zzjs2.zzD(zzh, zzac, this.zza);
        this.zze.zzQ();
    }
}
