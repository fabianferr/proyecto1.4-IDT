package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.util.Timer;
import java.util.TimerTask;

public class o {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public Timer b;
    private long c;
    private long d;
    /* access modifiers changed from: private */
    public final Runnable e;
    private long f;
    /* access modifiers changed from: private */
    public final Object g = new Object();

    private o(m mVar, Runnable runnable) {
        this.a = mVar;
        this.e = runnable;
    }

    public static o a(long j, m mVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        } else if (runnable != null) {
            o oVar = new o(mVar, runnable);
            oVar.c = System.currentTimeMillis();
            oVar.d = j;
            try {
                Timer timer = new Timer();
                oVar.b = timer;
                timer.schedule(oVar.e(), j);
            } catch (OutOfMemoryError e2) {
                if (u.a()) {
                    mVar.A().b("Timer", "Failed to create timer due to OOM error", e2);
                }
            }
            return oVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    private TimerTask e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.e     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r1 = r1.g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0048
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.m r2 = r2.a     // Catch:{ all -> 0x004c }
                    if (r2 == 0) goto L_0x003b
                    boolean r2 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x004c }
                    if (r2 == 0) goto L_0x003b
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.m r2 = r2.a     // Catch:{ all -> 0x004c }
                    com.applovin.impl.sdk.u r2 = r2.A()     // Catch:{ all -> 0x004c }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.b(r3, r4, r1)     // Catch:{ all -> 0x004c }
                L_0x003b:
                    com.applovin.impl.sdk.utils.o r1 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r1 = r1.g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x0049 }
                    java.util.Timer unused = r2.b = r0     // Catch:{ all -> 0x0049 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                L_0x0048:
                    return
                L_0x0049:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                    throw r0
                L_0x004c:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.o r2 = com.applovin.impl.sdk.utils.o.this
                    java.lang.Object r2 = r2.g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.o r3 = com.applovin.impl.sdk.utils.o.this     // Catch:{ all -> 0x005b }
                    java.util.Timer unused = r3.b = r0     // Catch:{ all -> 0x005b }
                    monitor-exit(r2)     // Catch:{ all -> 0x005b }
                    throw r1
                L_0x005b:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x005b }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.o.AnonymousClass1.run():void");
            }
        };
    }

    public long a() {
        if (this.b == null) {
            return this.d - this.f;
        }
        return this.d - (System.currentTimeMillis() - this.c);
    }

    public void b() {
        synchronized (this.g) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f = Math.max(1, System.currentTimeMillis() - this.c);
                } catch (Throwable th) {
                    this.b = null;
                    throw th;
                }
                this.b = null;
            }
        }
    }

    public void c() {
        synchronized (this.g) {
            long j = this.f;
            if (j > 0) {
                try {
                    long j2 = this.d - j;
                    this.d = j2;
                    if (j2 < 0) {
                        this.d = 0;
                    }
                    Timer timer = new Timer();
                    this.b = timer;
                    timer.schedule(e(), this.d);
                    this.c = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.f = 0;
                    throw th;
                }
                this.f = 0;
            }
        }
    }

    public void d() {
        synchronized (this.g) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.b = null;
                } catch (Throwable th) {
                    this.b = null;
                    this.f = 0;
                    throw th;
                }
                this.f = 0;
            }
        }
    }
}
