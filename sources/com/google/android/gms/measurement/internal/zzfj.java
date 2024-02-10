package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final /* synthetic */ class zzfj implements Callable {
    public final /* synthetic */ zzfp zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfj(zzfp zzfp, String str) {
        this.zza = zzfp;
        this.zzb = str;
    }

    public final Object call() {
        return new zzn("internal.remoteConfig", new zzfo(this.zza, this.zzb));
    }
}
