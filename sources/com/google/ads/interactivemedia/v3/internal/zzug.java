package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzug extends AbstractExecutorService implements zzvr {
    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzvz.zzp(runnable, obj);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (zzvq) super.submit(runnable);
    }

    public final zzvq zza(Callable callable) {
        return (zzvq) super.submit(callable);
    }

    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzvz(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzvq) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (zzvq) super.submit(callable);
    }
}
