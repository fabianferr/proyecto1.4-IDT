package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final /* synthetic */ class zzfl implements Callable {
    public final /* synthetic */ zzfp zza;

    public /* synthetic */ zzfl(zzfp zzfp) {
        this.zza = zzfp;
    }

    public final Object call() {
        return new zzt(this.zza.zze);
    }
}
