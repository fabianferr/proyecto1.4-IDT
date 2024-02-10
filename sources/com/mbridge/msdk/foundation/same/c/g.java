package com.mbridge.msdk.foundation.same.c;

import com.mbridge.msdk.foundation.tools.ac;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ImageLoaderController */
public final class g {
    private static AtomicBoolean a;
    private static AtomicBoolean b;
    private static ThreadPoolExecutor c;

    public static boolean a() {
        if (a == null) {
            a = new AtomicBoolean(ac.a().a("u_i_l_l_n", true));
        }
        AtomicBoolean atomicBoolean = a;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        if (b == null) {
            b = new AtomicBoolean(ac.a().a("u_i_l_l_b_d", false));
        }
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            return false;
        }
        return true;
    }

    public static ThreadPoolExecutor c() {
        if (c == null) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            c = new ThreadPoolExecutor(availableProcessors, availableProcessors, 5, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-image-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        c.allowCoreThreadTimeOut(true);
        return c;
    }
}
