package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzt implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ zza zzb;

    zzt(zzv zzv, zzw zzw, zza zza2) {
        this.zza = zzw;
        this.zzb = zza2;
    }

    public final void run() {
        zzw.zzH(this.zza, this.zzb);
    }
}
