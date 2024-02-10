package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzvw {
    public static zzvr zza(ExecutorService executorService) {
        zzvr zzvr;
        if (executorService instanceof zzvr) {
            return (zzvr) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzvr = new zzvv((ScheduledExecutorService) executorService);
        } else {
            zzvr = new zzvs(executorService);
        }
        return zzvr;
    }

    public static Executor zzb() {
        return zzus.INSTANCE;
    }
}
