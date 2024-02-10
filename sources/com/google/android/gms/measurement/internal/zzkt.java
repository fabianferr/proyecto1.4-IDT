package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzkt implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb = "_err";
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzku zzd;

    zzkt(zzku zzku, String str, String str2, Bundle bundle) {
        this.zzd = zzku;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zzd.zza.zzF((zzaw) Preconditions.checkNotNull(this.zzd.zza.zzv().zzz(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzav().currentTimeMillis(), false, true)), this.zza);
    }
}
