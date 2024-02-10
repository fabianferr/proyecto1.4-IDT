package com.google.android.gms.internal.cast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzqu {
    public static zzqp zza(ExecutorService executorService) {
        zzqp zzqp;
        if (executorService instanceof zzqp) {
            return (zzqp) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzqp = new zzqt((ScheduledExecutorService) executorService);
        } else {
            zzqp = new zzqq(executorService);
        }
        return zzqp;
    }
}
