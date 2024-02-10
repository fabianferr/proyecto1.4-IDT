package com.bytedance.sdk.component.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TTThreadFactory */
public class i implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    protected final ThreadGroup a;
    protected final String b;
    protected int c;
    private final AtomicInteger d;

    public i(String str) {
        this(5, str);
    }

    public i(int i, String str) {
        this.d = new AtomicInteger(1);
        this.c = i;
        this.a = new ThreadGroup(THREAD_GROUP_NAME_PRE + str);
        this.b = THREAD_NAME_PRE + str;
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.a;
        Thread a2 = a(threadGroup, runnable, this.b + this.d.getAndIncrement());
        if (a2.isDaemon()) {
            a2.setDaemon(false);
        }
        int i = this.c;
        if (i > 10 || i < 1) {
            this.c = 5;
        }
        a2.setPriority(this.c);
        return a2;
    }

    /* access modifiers changed from: protected */
    public Thread a(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }
}
