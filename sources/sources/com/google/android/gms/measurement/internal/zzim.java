package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzim implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzik zzb;
    final /* synthetic */ zzik zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzis zze;

    zzim(zzis zzis, Bundle bundle, zzik zzik, zzik zzik2, long j) {
        this.zze = zzis;
        this.zza = bundle;
        this.zzb = zzik;
        this.zzc = zzik2;
        this.zzd = j;
    }

    public final void run() {
        zzis.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
