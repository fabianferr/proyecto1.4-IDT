package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhy implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzid zzf;

    zzhy(zzid zzid, zzai zzai, int i, long j, boolean z, zzai zzai2) {
        this.zzf = zzid;
        this.zza = zzai;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzai2;
    }

    public final void run() {
        this.zzf.zzV(this.zza);
        zzid.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzoz.zzc();
        if (this.zzf.zzs.zzf().zzs((String) null, zzeb.zzas)) {
            zzid.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
