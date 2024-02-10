package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzvt extends zzux implements ScheduledFuture, zzvq {
    private final ScheduledFuture zza;

    public zzvt(zzvq zzvq, ScheduledFuture scheduledFuture) {
        super(zzvq);
        this.zza = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = zzb().cancel(z);
        if (cancel) {
            this.zza.cancel(z);
        }
        return cancel;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zza.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
