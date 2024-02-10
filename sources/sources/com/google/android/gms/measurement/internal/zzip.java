package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzip implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzis zzb;

    zzip(zzis zzis, long j) {
        this.zzb = zzis;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
