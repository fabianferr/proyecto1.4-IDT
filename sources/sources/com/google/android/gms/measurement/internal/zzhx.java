package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhx implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzid zzg;

    zzhx(zzid zzid, zzai zzai, long j, int i, long j2, boolean z, zzai zzai2) {
        this.zzg = zzid;
        this.zza = zzai;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzai2;
    }

    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzid.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzoz.zzc();
        if (this.zzg.zzs.zzf().zzs((String) null, zzeb.zzas)) {
            zzid.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
