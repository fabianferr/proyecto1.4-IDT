package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzvv extends zzvs implements ScheduledExecutorService, zzvr {
    final ScheduledExecutorService zza;

    zzvv(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzvz zzp = zzvz.zzp(runnable, (Object) null);
        return new zzvt(zzp, this.zza.schedule(zzp, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzvu zzvu = new zzvu(runnable);
        return new zzvt(zzvu, this.zza.scheduleAtFixedRate(zzvu, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzvu zzvu = new zzvu(runnable);
        return new zzvt(zzvu, this.zza.scheduleWithFixedDelay(zzvu, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzvz zzvz = new zzvz(callable);
        return new zzvt(zzvz, this.zza.schedule(zzvz, j, timeUnit));
    }
}
