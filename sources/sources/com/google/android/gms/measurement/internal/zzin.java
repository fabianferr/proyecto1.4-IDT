package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzin implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ zzik zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzis zze;

    zzin(zzis zzis, zzik zzik, zzik zzik2, long j, boolean z) {
        this.zze = zzis;
        this.zza = zzik;
        this.zzb = zzik2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
