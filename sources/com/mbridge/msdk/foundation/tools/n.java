package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: FastKVConfig */
public final class n {
    static FastKV.b a = new FastKV.b() {
        public final void a(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                aa.b("FastKVConfig", str + " " + str2);
            }
        }

        public final void a(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                aa.a("FastKVConfig", str, exc);
            }
        }

        public final void b(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                aa.b("FastKVConfig", str, exc);
            }
        }
    };
    static volatile Executor b;

    private n() {
    }

    static Executor a() {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        public final Thread newThread(Runnable runnable) {
                            return new Thread(runnable, "mb-sp-handler");
                        }
                    }, new ThreadPoolExecutor.DiscardPolicy());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    b = threadPoolExecutor;
                }
            }
        }
        return b;
    }
}
