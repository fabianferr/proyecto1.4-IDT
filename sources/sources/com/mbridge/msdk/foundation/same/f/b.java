package com.mbridge.msdk.foundation.same.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public final class b {
    public static ThreadPoolExecutor a;
    private static ThreadPoolExecutor b;
    private static ThreadPoolExecutor c;
    private static ThreadPoolExecutor d;
    private static Handler e;
    private static ThreadPoolExecutor f;
    private static ThreadPoolExecutor g;
    private static ThreadPoolExecutor h;

    public static ThreadPoolExecutor a() {
        if (a == null) {
            a = new ThreadPoolExecutor(5, 15, 15, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("CommonThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return a;
    }

    public static ThreadPoolExecutor b() {
        if (b == null) {
            b = new ThreadPoolExecutor(5, 15, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("ReportThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return b;
    }

    public static ThreadPoolExecutor c() {
        if (c == null) {
            c = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("NwtThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return c;
    }

    public static ThreadPoolExecutor d() {
        if (d == null) {
            d = new ThreadPoolExecutor(2, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("BitmapThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return d;
    }

    public static ThreadPoolExecutor e() {
        if (f == null) {
            AnonymousClass5 r8 = new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("mb-image-download-tread");
                    return newThread;
                }
            };
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f = new ThreadPoolExecutor(availableProcessors, availableProcessors, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), r8, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f;
    }

    public static ThreadPoolExecutor f() {
        if (g == null) {
            AnonymousClass6 r8 = new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("mb-image-download-tread");
                    return newThread;
                }
            };
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            g = new ThreadPoolExecutor(availableProcessors, availableProcessors, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), r8, new ThreadPoolExecutor.DiscardPolicy());
        }
        return g;
    }

    public static ThreadPoolExecutor g() {
        if (h == null) {
            AnonymousClass7 r8 = new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("rv-load-tread");
                    return thread;
                }
            };
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            h = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), r8, new ThreadPoolExecutor.DiscardPolicy());
        }
        return h;
    }

    public static Handler h() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    /* compiled from: ThreadPoolUtils */
    private static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }
}
