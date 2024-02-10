package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final /* synthetic */ class zzjw implements Runnable {
    public final /* synthetic */ zzjz zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzeo zzc;
    public final /* synthetic */ Intent zzd;

    public /* synthetic */ zzjw(zzjz zzjz, int i, zzeo zzeo, Intent intent) {
        this.zza = zzjz;
        this.zzb = i;
        this.zzc = zzeo;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
