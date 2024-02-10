package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzvc {
    private final zzso zza;

    /* synthetic */ zzvc(boolean z, zzso zzso, zzvb zzvb) {
        this.zza = zzso;
    }

    public final zzvq zza(Callable callable, Executor executor) {
        return new zzur(this.zza, false, executor, callable);
    }
}
