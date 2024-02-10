package com.bytedance.sdk.component.g;

import com.bytedance.sdk.component.g.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TTExecutor */
public class f extends e {
    public static final int a = Runtime.getRuntime().availableProcessors();
    public static c b;
    public static int c = 120;
    public static boolean d = true;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;
    private static volatile ThreadPoolExecutor g;
    private static volatile ThreadPoolExecutor h;
    private static volatile ThreadPoolExecutor i;
    private static volatile ThreadPoolExecutor j;
    private static volatile ScheduledExecutorService k;

    public static ExecutorService b() {
        if (e == null) {
            synchronized (f.class) {
                if (e == null) {
                    e = new a.C0056a().a("init").a(0).b(10).a(5).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new SynchronousQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(10, "init")).a();
                }
            }
        }
        return e;
    }

    public static void a(h hVar) {
        if (e == null) {
            b();
        }
        if (hVar != null && e != null) {
            e.execute(hVar);
        }
    }

    public static ExecutorService c() {
        return a(10);
    }

    public static ExecutorService a(int i2) {
        if (f == null) {
            synchronized (f.class) {
                if (f == null) {
                    f = new a.C0056a().a("io").a(2).b(i2).a(20).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new LinkedBlockingQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(i2, "io")).a();
                    f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f;
    }

    public static void b(h hVar) {
        if (f == null) {
            c();
        }
        if (f != null) {
            f.execute(hVar);
        }
    }

    public static void a(h hVar, int i2) {
        b(hVar);
    }

    public static void a(h hVar, int i2, int i3) {
        if (f == null) {
            a(i3);
        }
        if (hVar != null && f != null) {
            hVar.setPriority(i2);
            f.execute(hVar);
        }
    }

    public static ExecutorService d() {
        if (h == null) {
            synchronized (f.class) {
                if (h == null) {
                    h = new a.C0056a().a("log").b(10).a(4).a(20).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(10, "log")).a();
                    h.allowCoreThreadTimeOut(true);
                }
            }
        }
        return h;
    }

    public static void c(h hVar) {
        if (h == null) {
            d();
        }
        if (hVar != null && h != null) {
            h.execute(hVar);
        }
    }

    public static void b(h hVar, int i2) {
        if (hVar != null) {
            hVar.setPriority(i2);
        }
        c(hVar);
    }

    public static ExecutorService e() {
        if (j == null) {
            synchronized (f.class) {
                if (j == null) {
                    j = new a.C0056a().a("aidl").b(10).a(2).a(30).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(10, "aidl")).a();
                    j.allowCoreThreadTimeOut(true);
                }
            }
        }
        return j;
    }

    public static void d(h hVar) {
        if (j == null) {
            e();
        }
        if (hVar != null && j != null) {
            j.execute(hVar);
        }
    }

    public static void c(h hVar, int i2) {
        if (hVar != null) {
            hVar.setPriority(i2);
        }
        d(hVar);
    }

    public static ScheduledExecutorService f() {
        if (k == null) {
            synchronized (f.class) {
                if (k == null) {
                    k = Executors.newSingleThreadScheduledExecutor(a().createThreadFactory(5, "scheduled"));
                }
            }
        }
        return k;
    }

    public static boolean g() {
        return d;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static RejectedExecutionHandler h() {
        return new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c i() {
        return b;
    }

    public static void a(c cVar) {
        b = cVar;
    }

    public static ExecutorService b(int i2) {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new a.C0056a().a("ad").a(2).b(i2).a(20).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new LinkedBlockingQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(i2, "ad")).a();
                    g.allowCoreThreadTimeOut(true);
                }
            }
        }
        return g;
    }

    public static void e(h hVar) {
        if (g == null) {
            b(5);
        }
        if (hVar != null && g != null) {
            g.execute(hVar);
        }
    }

    public static ExecutorService j() {
        if (i == null) {
            synchronized (f.class) {
                if (i == null) {
                    i = new a.C0056a().a("computation").a(3).b(10).a(20).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue()).a(h()).a((ThreadFactory) a().createThreadFactory(10, "computation")).a();
                    i.allowCoreThreadTimeOut(true);
                }
            }
        }
        return i;
    }

    public static void c(int i2) {
        c = i2;
    }
}
