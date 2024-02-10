package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzqt extends zzqq implements ScheduledExecutorService, zzqp {
    final ScheduledExecutorService zza;

    zzqt(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzqw zzn = zzqw.zzn(runnable, (Object) null);
        return new zzqr(zzn, this.zza.schedule(zzn, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzqs zzqs = new zzqs(runnable);
        return new zzqr(zzqs, this.zza.scheduleAtFixedRate(zzqs, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzqs zzqs = new zzqs(runnable);
        return new zzqr(zzqs, this.zza.scheduleWithFixedDelay(zzqs, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzqw zzqw = new zzqw(callable);
        return new zzqr(zzqw, this.zza.schedule(zzqw, j, timeUnit));
    }
}
