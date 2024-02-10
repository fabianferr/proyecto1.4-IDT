package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzqd extends AbstractExecutorService implements zzqp {
    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzqw.zzn(runnable, obj);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzqw(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (ListenableFuture) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (ListenableFuture) super.submit(callable);
    }
}
