package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzvz extends zzuu implements RunnableFuture {
    @CheckForNull
    private volatile zzvp zza;

    zzvz(Callable callable) {
        this.zza = new zzvy(this, callable);
    }

    static zzvz zzp(Runnable runnable, Object obj) {
        return new zzvz(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzvp zzvp = this.zza;
        if (zzvp != null) {
            zzvp.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzvp zzvp = this.zza;
        if (zzvp == null) {
            return super.zza();
        }
        String obj = zzvp.toString();
        return "task=[" + obj + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzvp zzvp;
        if (zzo() && (zzvp = this.zza) != null) {
            zzvp.zzh();
        }
        this.zza = null;
    }
}
