package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.e;
import com.facebook.internal.security.CertificateUtil;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class o {
    private final String a = "TaskManager";
    /* access modifiers changed from: private */
    public final m b;
    /* access modifiers changed from: private */
    public final u c;
    private final ScheduledThreadPoolExecutor d;
    /* access modifiers changed from: private */
    public final ScheduledThreadPoolExecutor e;
    private final List<c> f = new ArrayList(5);
    private final Object g = new Object();
    private boolean h;

    public enum a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    private class b implements ThreadFactory {
        private final String b;

        b(String str) {
            this.b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.b + CertificateUtil.DELIMITER + Utils.shortenKey(o.this.b.z()));
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (u.a()) {
                        o.this.c.b("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }

    private static class c implements Runnable {
        private final m a;
        private final String b;
        private final u c;
        /* access modifiers changed from: private */
        public final a d;
        /* access modifiers changed from: private */
        public final a e;

        c(m mVar, a aVar, a aVar2) {
            this.a = mVar;
            this.c = mVar.A();
            this.b = aVar.e();
            this.d = aVar;
            this.e = aVar2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = " queue finished task "
                com.applovin.impl.sdk.utils.g.a()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.m r1 = r6.a     // Catch:{ all -> 0x004a }
                boolean r1 = r1.c()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0035
                com.applovin.impl.sdk.f.a r1 = r6.d     // Catch:{ all -> 0x004a }
                boolean r1 = r1.g()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0016
                goto L_0x0035
            L_0x0016:
                boolean r1 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0025
                com.applovin.impl.sdk.u r1 = r6.c     // Catch:{ all -> 0x004a }
                java.lang.String r2 = r6.b     // Catch:{ all -> 0x004a }
                java.lang.String r3 = "Task re-scheduled..."
                r1.c(r2, r3)     // Catch:{ all -> 0x004a }
            L_0x0025:
                com.applovin.impl.sdk.m r1 = r6.a     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.f.o r1 = r1.S()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.f.a r2 = r6.d     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.f.o$a r3 = r6.e     // Catch:{ all -> 0x004a }
                r4 = 2000(0x7d0, double:9.88E-321)
                r1.a((com.applovin.impl.sdk.f.a) r2, (com.applovin.impl.sdk.f.o.a) r3, (long) r4)     // Catch:{ all -> 0x004a }
                goto L_0x003a
            L_0x0035:
                com.applovin.impl.sdk.f.a r1 = r6.d     // Catch:{ all -> 0x004a }
                r1.run()     // Catch:{ all -> 0x004a }
            L_0x003a:
                boolean r1 = com.applovin.impl.sdk.u.a()
                if (r1 == 0) goto L_0x0081
                com.applovin.impl.sdk.u r1 = r6.c
                java.lang.String r2 = r6.b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                goto L_0x0069
            L_0x004a:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0082 }
                if (r2 == 0) goto L_0x005a
                com.applovin.impl.sdk.u r2 = r6.c     // Catch:{ all -> 0x0082 }
                java.lang.String r3 = r6.b     // Catch:{ all -> 0x0082 }
                java.lang.String r4 = "Task failed execution"
                r2.b(r3, r4, r1)     // Catch:{ all -> 0x0082 }
            L_0x005a:
                boolean r1 = com.applovin.impl.sdk.u.a()
                if (r1 == 0) goto L_0x0081
                com.applovin.impl.sdk.u r1 = r6.c
                java.lang.String r2 = r6.b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
            L_0x0069:
                com.applovin.impl.sdk.f.o$a r4 = r6.e
                r3.append(r4)
                r3.append(r0)
                com.applovin.impl.sdk.f.a r0 = r6.d
                java.lang.String r0 = r0.e()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1.c(r2, r0)
            L_0x0081:
                return
            L_0x0082:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.u.a()
                if (r2 == 0) goto L_0x00aa
                com.applovin.impl.sdk.u r2 = r6.c
                java.lang.String r3 = r6.b
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.applovin.impl.sdk.f.o$a r5 = r6.e
                r4.append(r5)
                r4.append(r0)
                com.applovin.impl.sdk.f.a r0 = r6.d
                java.lang.String r0 = r0.e()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.c(r3, r0)
            L_0x00aa:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.f.o.c.run():void");
        }
    }

    public o(m mVar) {
        this.b = mVar;
        this.c = mVar.A();
        this.d = a("auxiliary_operations", ((Integer) mVar.a(com.applovin.impl.sdk.d.b.ce)).intValue());
        this.e = a("shared_thread_pool", ((Integer) mVar.a(com.applovin.impl.sdk.d.b.ak)).intValue());
    }

    private ScheduledThreadPoolExecutor a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new b(str));
    }

    private void a(final Runnable runnable, long j, boolean z) {
        if (j <= 0) {
            this.e.submit(runnable);
        } else if (z) {
            e.a(j, this.b, new Runnable() {
                public void run() {
                    o.this.e.execute(runnable);
                }
            });
        } else {
            this.e.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    private boolean a(c cVar) {
        if (cVar.d.g()) {
            return false;
        }
        synchronized (this.g) {
            if (this.h) {
                return false;
            }
            this.f.add(cVar);
            return true;
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                if (u.a()) {
                    this.c.b(aVar.e(), "Task failed execution", th);
                }
            }
        } else if (u.a()) {
            this.c.e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    public void a(a aVar, a aVar2) {
        a(aVar, aVar2, 0);
    }

    public void a(a aVar, a aVar2, long j) {
        a(aVar, aVar2, j, false);
    }

    public void a(a aVar, a aVar2, long j, boolean z) {
        if (aVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            throw new IllegalArgumentException("Invalid delay (millis) specified: " + j);
        } else if (!a(new c(this.b, aVar, aVar2))) {
            a((Runnable) aVar, j, z);
        } else if (u.a()) {
            this.c.c(aVar.e(), "Task execution delayed until after init");
        }
    }

    public void a(Runnable runnable) {
        this.d.submit(runnable);
    }

    public boolean a() {
        return this.h;
    }

    public Executor b() {
        return this.e;
    }

    public void c() {
        synchronized (this.g) {
            this.h = false;
        }
    }

    public void d() {
        synchronized (this.g) {
            this.h = true;
            for (c next : this.f) {
                a(next.d, next.e);
            }
            this.f.clear();
        }
    }
}
