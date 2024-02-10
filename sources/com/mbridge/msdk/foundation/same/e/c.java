package com.mbridge.msdk.foundation.same.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoaderThreadPool */
public final class c {
    private static volatile ThreadPoolExecutor a;

    private static int a(int i, String str) {
        try {
            int a2 = ac.a().a(str, i);
            if (a2 <= 0) {
                return i;
            }
            return a2;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return i;
            }
            aa.d("CommonTaskLoaderThreadPool", e.getMessage());
            return i;
        }
    }

    public static ThreadPoolExecutor a() {
        if (a == null) {
            int a2 = a(10, "c_t_l_t_p_c");
            int a3 = a(50, "c_t_l_t_p_m");
            int a4 = a(5, "c_t_l_t_p_t");
            int i = a3 < a2 ? a2 : a3;
            try {
                if (MBridgeConstans.DEBUG) {
                    aa.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + a2 + " max " + i + " timeout " + a4);
                }
                a = new ThreadPoolExecutor(a2, i, (long) a4, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("mb-task-loader-thread");
                        return thread;
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e);
                }
            }
        }
        if (a == null) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 5, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-task-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        a.allowCoreThreadTimeOut(true);
        return a;
    }
}
