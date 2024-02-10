package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    zzhh(zzid zzid, long j) {
        this.zzb = zzid;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzm().zzf.zzb(this.zza);
        this.zzb.zzs.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
