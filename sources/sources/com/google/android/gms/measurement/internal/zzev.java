package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzev implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzew zzb;

    zzev(zzew zzew, boolean z) {
        this.zzb = zzew;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
