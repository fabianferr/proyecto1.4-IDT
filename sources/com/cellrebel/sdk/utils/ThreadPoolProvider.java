package com.cellrebel.sdk.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProvider {
    private static final ThreadPoolProvider c = new ThreadPoolProvider();
    private static final int d = Runtime.getRuntime().availableProcessors();
    private static final TimeUnit e = TimeUnit.SECONDS;
    private final ExecutorService a;
    private final ScheduledExecutorService b;

    private ThreadPoolProvider() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        int i = d;
        this.a = new ThreadPoolExecutor(i, i * 2, 5, e, linkedBlockingQueue);
        this.b = new ScheduledThreadPoolExecutor(i);
    }

    public static ThreadPoolProvider a() {
        return c;
    }

    public void a(Callable<String> callable) {
        this.b.submit(callable);
    }

    public void b(Callable<String> callable) {
        this.a.submit(callable);
    }
}
