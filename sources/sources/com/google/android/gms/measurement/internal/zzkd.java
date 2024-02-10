package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzkd implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzke zzc;

    zzkd(zzke zzke, long j, long j2) {
        this.zzc = zzke;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new zzkc(this));
    }
}
