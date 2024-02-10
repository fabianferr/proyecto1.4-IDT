package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzr implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ int zzb;

    zzr(zzv zzv, zzw zzw, int i) {
        this.zza = zzw;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzj.onApplicationDisconnected(this.zzb);
    }
}
