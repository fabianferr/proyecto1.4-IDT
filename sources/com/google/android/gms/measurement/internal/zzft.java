package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzft extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzfv zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzft(zzfv zzfv, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzb = zzfv;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfv.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfv.zzs.zzay().zzd().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzft zzft = (zzft) obj;
        boolean z = this.zza;
        if (z != zzft.zza) {
            return !z ? 1 : -1;
        }
        long j = this.zzc;
        long j2 = zzft.zzc;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzb.zzs.zzay().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzs.zzay().zzd().zzb(this.zzd, th);
        if ((th instanceof zzfr) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzft(zzfv zzfv, Callable callable, boolean z, String str) {
        super(callable);
        this.zzb = zzfv;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfv.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfv.zzs.zzay().zzd().zza("Tasks index overflow");
        }
    }
}
