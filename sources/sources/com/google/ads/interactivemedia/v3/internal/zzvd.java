package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzvd extends zzvk {
    @SafeVarargs
    public static zzvc zza(zzvq... zzvqArr) {
        return new zzvc(false, zzso.zzl(zzvqArr), (zzvb) null);
    }

    public static Object zzb(Future future, Class cls) throws Exception {
        return zzvi.zza(zzvh.zza, future, cls);
    }

    public static Object zzc(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        if (future.isDone()) {
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return obj;
        }
        throw new IllegalStateException(zzro.zzb("Future was expected to be done: %s", future));
    }

    public static void zzd(zzvq zzvq, zzuz zzuz, Executor executor) {
        zzuz.getClass();
        zzvq.zzm(new zzva(zzvq, zzuz), executor);
    }
}
