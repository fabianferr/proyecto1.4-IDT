package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzkp implements Runnable {
    final /* synthetic */ zzla zza;
    final /* synthetic */ zzkz zzb;

    zzkp(zzkz zzkz, zzla zzla) {
        this.zzb = zzkz;
        this.zza = zzla;
    }

    public final void run() {
        zzkz.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
