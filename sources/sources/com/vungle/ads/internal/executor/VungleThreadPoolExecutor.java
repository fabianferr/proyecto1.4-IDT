package com.vungle.ads.internal.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\u0016H\u0016¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "execute", "", "command", "fail", "submit", "Ljava/util/concurrent/Future;", "task", "T", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "Ljava/util/concurrent/Callable;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleThreadPoolExecutor.kt */
public final class VungleThreadPoolExecutor extends ThreadPoolExecutor {
    public VungleThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    public void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError unused) {
        }
    }

    public final void execute(Runnable runnable, Runnable runnable2) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError unused) {
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    public Future<?> submit(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        try {
            Future<?> submit = super.submit(runnable);
            Intrinsics.checkNotNullExpressionValue(submit, "{\n            super.submit(task)\n        }");
            return submit;
        } catch (OutOfMemoryError unused) {
            return new FutureResult<>((Future) null);
        }
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        try {
            Future<T> submit = super.submit(runnable, t);
            Intrinsics.checkNotNullExpressionValue(submit, "{\n            super.submit(task, result)\n        }");
            return submit;
        } catch (OutOfMemoryError unused) {
            return new FutureResult<>((Future) null);
        }
    }

    public final Future<?> submit(Runnable runnable, Runnable runnable2) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        try {
            Future<?> submit = super.submit(runnable);
            Intrinsics.checkNotNullExpressionValue(submit, "{\n            super.submit(task)\n        }");
            return submit;
        } catch (OutOfMemoryError unused) {
            if (runnable2 != null) {
                runnable2.run();
            }
            return new FutureResult<>((Future) null);
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "task");
        try {
            Future<T> submit = super.submit(callable);
            Intrinsics.checkNotNullExpressionValue(submit, "{\n            super.submit(task)\n        }");
            return submit;
        } catch (OutOfMemoryError unused) {
            return new FutureResult<>((Future) null);
        }
    }
}
