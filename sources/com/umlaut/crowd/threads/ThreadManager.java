package com.umlaut.crowd.threads;

import android.os.Build;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
    /* access modifiers changed from: private */
    public static final String d = "ThreadManager";
    public static final int e = Math.max(Runtime.getRuntime().availableProcessors(), 1);
    private final ScheduledThreadPoolExecutor a;
    private final ThreadPoolExecutor b;
    private final ExecutorService c;

    private static final class b {
        static final ThreadManager a = new ThreadManager();

        private b() {
        }
    }

    private static final class c implements ThreadFactory {
        private final ThreadFactory a;

        class a implements Thread.UncaughtExceptionHandler {
            a() {
            }

            public void uncaughtException(Thread thread, Throwable th) {
                Log.e(ThreadManager.d, "uncaughtException: ", th);
                if ((Build.VERSION.SDK_INT != 29 || !(th instanceof NullPointerException) || th.getStackTrace() == null || th.getStackTrace().length <= 0 || !th.getStackTrace()[0].toString().contains("android.telephony.TelephonyManager") || th.getMessage() == null || !th.getMessage().contains("on a null object reference")) && thread != null && thread.getThreadGroup() != null) {
                    thread.getThreadGroup().uncaughtException(thread, th);
                }
            }
        }

        private c() {
            this.a = Executors.defaultThreadFactory();
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.a.newThread(runnable);
            newThread.setUncaughtExceptionHandler(new a());
            return newThread;
        }
    }

    public static ThreadManager getInstance() {
        return b.a;
    }

    public ExecutorService getCachedThreadPool() {
        return this.c;
    }

    public ThreadPoolExecutor getIOThreadExecutor() {
        return this.b;
    }

    public ScheduledExecutorService getSingleThreadScheduledExecutor() {
        return this.a;
    }

    private ThreadManager() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.a = scheduledThreadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.b = new ThreadPoolExecutor(0, 1, 60, timeUnit, new LinkedBlockingQueue());
        this.c = Executors.newCachedThreadPool(new c());
        scheduledThreadPoolExecutor.setKeepAliveTime(60, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
