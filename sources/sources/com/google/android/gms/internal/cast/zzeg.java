package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzeg extends zzei {
    private final Handler zza;

    public zzeg(Looper looper) {
        this.zza = new Handler(looper);
    }

    public final void zza(zzef zzef) {
        this.zza.postDelayed(zzef.zzc(), 0);
    }
}
