package com.bytedance.sdk.component.g;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ADThreadPoolExecutor */
class a extends ThreadPoolExecutor {
    private String a;

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.a = str;
    }

    private void a(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            a(runnable, e);
        } catch (Throwable th) {
            a(runnable, th);
        }
    }

    private void a(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        a(runnable, (Throwable) outOfMemoryError);
    }

    private void a(Runnable runnable, Throwable th) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                l.c("", "try exc failed", th2);
            }
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i) {
        if (getCorePoolSize() != i && blockingQueue != null && blockingQueue.size() <= 0) {
            try {
                setCorePoolSize(i);
                l.b("ADThreadPoolExecutor", "reduceCoreThreadSize: reduce poolType =  ", this.a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e) {
                l.c("ADThreadPoolExecutor", e.getMessage());
            }
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i, int i2) {
        if (getCorePoolSize() != i && blockingQueue != null && blockingQueue.size() >= i2) {
            try {
                setCorePoolSize(i);
                l.b("ADThreadPoolExecutor", "increaseCoreThreadSize: increase poolType =  ", this.a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e) {
                l.c("ADThreadPoolExecutor", e.getMessage());
            }
        }
    }

    public void execute(final Runnable runnable) {
        BlockingQueue queue;
        if (runnable instanceof h) {
            a(new b((h) runnable, this));
        } else {
            a(new b(new h("unknown") {
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (f.g() && !TextUtils.isEmpty(this.a) && (queue = getQueue()) != null) {
            String str = this.a;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 3366:
                    if (str.equals("io")) {
                        c = 0;
                        break;
                    }
                    break;
                case 107332:
                    if (str.equals("log")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2993840:
                    if (str.equals("aidl")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a(queue, f.a + 2, getCorePoolSize() * 2);
                    return;
                case 1:
                    a(queue, 8, 8);
                    return;
                case 2:
                    a(queue, 5, 5);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue queue;
        super.afterExecute(runnable, th);
        if (f.g() && !TextUtils.isEmpty(this.a) && (queue = getQueue()) != null) {
            String str = this.a;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 3366:
                    if (str.equals("io")) {
                        c = 0;
                        break;
                    }
                    break;
                case 107332:
                    if (str.equals("log")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2993840:
                    if (str.equals("aidl")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a((BlockingQueue<Runnable>) queue, 2);
                    return;
                case 1:
                    a((BlockingQueue<Runnable>) queue, 4);
                    return;
                case 2:
                    a((BlockingQueue<Runnable>) queue, 2);
                    return;
                default:
                    return;
            }
        }
    }

    public List<Runnable> shutdownNow() {
        if ("io".equals(this.a) || "aidl".equals(this.a)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    public void shutdown() {
        if (!"io".equals(this.a) && !"aidl".equals(this.a)) {
            super.shutdown();
        }
    }

    public String a() {
        return this.a;
    }

    /* renamed from: com.bytedance.sdk.component.g.a$a  reason: collision with other inner class name */
    /* compiled from: ADThreadPoolExecutor */
    public static class C0056a {
        private String a = "io";
        private int b = 1;
        private long c = 30;
        private TimeUnit d = TimeUnit.SECONDS;
        private int e = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> f = null;
        private ThreadFactory g = null;
        private RejectedExecutionHandler h;
        private int i = 5;

        public C0056a a(String str) {
            this.a = str;
            return this;
        }

        public C0056a a(int i2) {
            this.b = i2;
            return this;
        }

        public C0056a a(long j) {
            this.c = j;
            return this;
        }

        public C0056a a(TimeUnit timeUnit) {
            this.d = timeUnit;
            return this;
        }

        public C0056a a(BlockingQueue<Runnable> blockingQueue) {
            this.f = blockingQueue;
            return this;
        }

        public C0056a a(ThreadFactory threadFactory) {
            this.g = threadFactory;
            return this;
        }

        public C0056a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.h = rejectedExecutionHandler;
            return this;
        }

        public C0056a b(int i2) {
            this.i = i2;
            return this;
        }

        public a a() {
            if (this.g == null) {
                this.g = e.a().createThreadFactory(this.i, this.a);
            }
            if (this.h == null) {
                this.h = f.h();
            }
            if (this.f == null) {
                this.f = new LinkedBlockingQueue();
            }
            return new a(this.a, this.b, this.e, this.c, this.d, this.f, this.g, this.h);
        }
    }
}
