package com.vungle.ads.internal.executor;

import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002:\u0001\u0013B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000bJ \u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/vungle/ads/internal/executor/FutureResult;", "T", "Ljava/util/concurrent/Future;", "future", "(Ljava/util/concurrent/Future;)V", "getFuture", "()Ljava/util/concurrent/Future;", "cancel", "", "mayInterruptIfRunning", "get", "()Ljava/lang/Object;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FutureResult.kt */
public final class FutureResult<T> implements Future<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = "FutureResult";
    private final Future<T> future;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/executor/FutureResult$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FutureResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return FutureResult.TAG;
        }
    }

    public FutureResult(Future<T> future2) {
        this.future = future2;
    }

    public final Future<T> getFuture() {
        return this.future;
    }

    public boolean cancel(boolean z) {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.cancel(z);
        }
        return false;
    }

    public boolean isCancelled() {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.isCancelled();
        }
        return false;
    }

    public boolean isDone() {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.isDone();
        }
        return false;
    }

    public T get() {
        try {
            Future<T> future2 = this.future;
            if (future2 != null) {
                return future2.get();
            }
            return null;
        } catch (InterruptedException unused) {
            String str = TAG;
            Log.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        }
    }

    public T get(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        try {
            Future<T> future2 = this.future;
            if (future2 != null) {
                return future2.get(j, timeUnit);
            }
            return null;
        } catch (InterruptedException unused) {
            String str = TAG;
            Log.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        } catch (TimeoutException unused2) {
            String str2 = TAG;
            Log.w(str2, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }
}
