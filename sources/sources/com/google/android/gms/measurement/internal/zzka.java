package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzka implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzki zzb;

    zzka(zzki zzki, long j) {
        this.zzb = zzki;
        this.zza = j;
    }

    public final void run() {
        zzki.zzl(this.zzb, this.zza);
    }
}
