package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgn implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgq zzb;

    zzgn(zzgq zzgq, String str) {
        this.zzb = zzgq;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzA();
        return this.zzb.zza.zzi().zzu(this.zza);
    }
}
