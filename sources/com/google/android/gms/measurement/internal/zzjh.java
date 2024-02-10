package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjh implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaw zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjs zze;

    zzjh(zzjs zzjs, boolean z, zzq zzq, boolean z2, zzaw zzaw, String str) {
        this.zze = zzjs;
        this.zza = zzq;
        this.zzb = z2;
        this.zzc = zzaw;
        this.zzd = str;
    }

    public final void run() {
        zzaw zzaw;
        zzjs zzjs = this.zze;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjs zzjs2 = this.zze;
        if (this.zzb) {
            zzaw = null;
        } else {
            zzaw = this.zzc;
        }
        zzjs2.zzD(zzh, zzaw, this.zza);
        this.zze.zzQ();
    }
}
