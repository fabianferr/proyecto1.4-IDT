package com.appnext.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n {
    private static volatile n dA;
    private static int dw = Runtime.getRuntime().availableProcessors();
    private static final TimeUnit dy = TimeUnit.SECONDS;
    private final BlockingQueue<Runnable> dx = new LinkedBlockingQueue();
    private ThreadPoolExecutor dz = ((ThreadPoolExecutor) Executors.newCachedThreadPool());

    public static n aa() {
        if (dA == null) {
            synchronized (j.class) {
                if (dA == null) {
                    dA = new n();
                }
            }
        }
        return dA;
    }

    public final void a(Runnable runnable) {
        if (runnable != null) {
            this.dz.execute(runnable);
        }
    }
}
