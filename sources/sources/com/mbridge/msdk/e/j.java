package com.mbridge.msdk.e;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorManager */
final class j {
    private final Executor a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeTrackThread");
        }
    }, new ThreadPoolExecutor.DiscardPolicy());
    private final Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeTrackDatabaseThread");
        }
    }, new ThreadPoolExecutor.DiscardPolicy());

    public j() {
    }

    public final void a(Runnable runnable) {
        this.a.execute(new a(runnable));
    }

    public final void b(Runnable runnable) {
        this.b.execute(new a(runnable));
    }

    /* compiled from: ExecutorManager */
    private static final class a implements Runnable {
        private final Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public final void run() {
            if (!y.a((Object) this.a)) {
                try {
                    this.a.run();
                } catch (Exception e) {
                    if (a.a) {
                        Log.e("TrackManager", "execute error", e);
                    }
                }
            }
        }
    }
}
