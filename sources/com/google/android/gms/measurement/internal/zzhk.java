package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhk implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzid zzc;

    zzhk(zzid zzid, AtomicReference atomicReference, boolean z) {
        this.zzc = zzid;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzs.zzt().zzx(this.zza, this.zzb);
    }
}
