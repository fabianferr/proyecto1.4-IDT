package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjp implements Runnable {
    final /* synthetic */ zzjr zza;

    zzjp(zzjr zzjr) {
        this.zza = zzjr;
    }

    public final void run() {
        zzjs zzjs = this.zza.zza;
        Context zzau = zzjs.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjs.zzo(zzjs, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
