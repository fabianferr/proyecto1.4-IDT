package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjn implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjr zzb;

    zzjn(zzjr zzjr, ComponentName componentName) {
        this.zzb = zzjr;
        this.zza = componentName;
    }

    public final void run() {
        zzjs.zzo(this.zzb.zza, this.zza);
    }
}
