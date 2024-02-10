package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzfs implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfv zza;
    private final String zzb;

    public zzfs(zzfv zzfv, String str) {
        this.zza = zzfv;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzs.zzay().zzd().zzb(this.zzb, th);
    }
}
