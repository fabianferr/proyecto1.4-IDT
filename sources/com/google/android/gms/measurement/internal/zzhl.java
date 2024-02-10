package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhl implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    zzhl(zzid zzid, long j) {
        this.zzb = zzid;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
