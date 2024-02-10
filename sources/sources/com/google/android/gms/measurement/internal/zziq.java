package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zziq implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzis zzc;

    zziq(zzis zzis, zzik zzik, long j) {
        this.zzc = zzis;
        this.zza = zzik;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzis zzis = this.zzc;
        zzis.zza = null;
        zzis.zzs.zzt().zzG((zzik) null);
    }
}
