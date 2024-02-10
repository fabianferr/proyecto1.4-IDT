package com.bytedance.sdk.component.e.a.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.e.a.b.a.a;
import com.bytedance.sdk.component.e.a.b.c.c;
import com.bytedance.sdk.component.e.a.c.b;
import com.bytedance.sdk.component.e.a.e.e;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LogThreadCenter */
public class d {
    public static final d a = new d();
    public static final a d = new a();
    public static final AtomicLong e = new AtomicLong(0);
    public static final AtomicLong f = new AtomicLong(0);
    public static final long g = System.currentTimeMillis();
    public static long h = 0;
    public volatile boolean b = false;
    public volatile boolean c = false;
    private volatile c i;
    private volatile Handler j;
    private final Comparator<com.bytedance.sdk.component.e.a.d.a> k;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> l;

    public PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> a() {
        return this.l;
    }

    private d() {
        AnonymousClass1 r0 = new Comparator<com.bytedance.sdk.component.e.a.d.a>() {
            /* renamed from: a */
            public int compare(com.bytedance.sdk.component.e.a.d.a aVar, com.bytedance.sdk.component.e.a.d.a aVar2) {
                return d.this.a(aVar, aVar2);
            }
        };
        this.k = r0;
        this.l = new PriorityBlockingQueue<>(8, r0);
    }

    /* access modifiers changed from: private */
    public int a(com.bytedance.sdk.component.e.a.d.a aVar, com.bytedance.sdk.component.e.a.d.a aVar2) {
        long j2;
        long j3;
        long j4;
        long j5;
        if (aVar == null) {
            return aVar2 == null ? 0 : -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        if (aVar.e() != aVar2.e()) {
            return aVar.e() - aVar2.e();
        }
        if (aVar.a() != null) {
            j3 = aVar.a().a();
            j2 = aVar.a().b();
        } else {
            j3 = 0;
            j2 = 0;
        }
        if (aVar2.a() != null) {
            j5 = aVar2.a().a();
            j4 = aVar2.a().b();
        } else {
            j4 = 0;
            j5 = 0;
        }
        if (j3 == 0 || j5 == 0) {
            return 0;
        }
        long j6 = j3 - j5;
        if (Math.abs(j6) > 2147483647L) {
            return 0;
        }
        if (j6 != 0) {
            return (int) j6;
        }
        if (j2 == 0 || j4 == 0) {
            return 0;
        }
        return (int) (j2 - j4);
    }

    public void b() {
        d();
        e();
    }

    public void a(Handler handler) {
        this.j = handler;
    }

    public synchronized void c() {
        if (this.i != null && this.i.isAlive()) {
            if (this.j != null) {
                this.j.removeCallbacksAndMessages((Object) null);
            }
            this.i.a(false);
            this.i.quitSafely();
            this.i = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d() {
        /*
            r3 = this;
            java.lang.String r0 = "LogThread state:"
            monitor-enter(r3)
            r1 = 0
            com.bytedance.sdk.component.e.a.b.c.c r2 = r3.i     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0027
            com.bytedance.sdk.component.e.a.b.c.c r2 = r3.i     // Catch:{ all -> 0x0045 }
            boolean r2 = r2.isAlive()     // Catch:{ all -> 0x0045 }
            if (r2 != 0) goto L_0x0011
            goto L_0x0027
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r2.<init>(r0)     // Catch:{ all -> 0x0045 }
            com.bytedance.sdk.component.e.a.b.c.c r0 = r3.i     // Catch:{ all -> 0x0045 }
            java.lang.Thread$State r0 = r0.getState()     // Catch:{ all -> 0x0045 }
            r2.append(r0)     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0045 }
            com.bytedance.sdk.component.e.a.c.c.a(r0)     // Catch:{ all -> 0x0045 }
            goto L_0x0043
        L_0x0027:
            boolean r0 = com.bytedance.sdk.component.e.a.b.b()     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = "--start LogThread--"
            com.bytedance.sdk.component.e.a.c.c.a(r0)     // Catch:{ all -> 0x0045 }
            com.bytedance.sdk.component.e.a.b.c.c r0 = new com.bytedance.sdk.component.e.a.b.c.c     // Catch:{ all -> 0x0045 }
            java.util.concurrent.PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> r2 = r3.l     // Catch:{ all -> 0x0045 }
            r0.<init>(r2)     // Catch:{ all -> 0x0045 }
            r3.i = r0     // Catch:{ all -> 0x0045 }
            com.bytedance.sdk.component.e.a.b.c.c r0 = r3.i     // Catch:{ all -> 0x0045 }
            r0.start()     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0043:
            monitor-exit(r3)
            return r1
        L_0x0045:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x004f }
            com.bytedance.sdk.component.e.a.c.c.d(r0)     // Catch:{ all -> 0x004f }
            monitor-exit(r3)
            return r1
        L_0x004f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.d.d():boolean");
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        d();
        f m = i.e().m();
        c cVar = this.i;
        if (cVar != null) {
            a(m, aVar);
            cVar.a(aVar, aVar.e() == 4);
        }
    }

    private void a(f fVar, com.bytedance.sdk.component.e.a.d.a aVar) {
        if (fVar != null) {
            try {
                if (fVar.h()) {
                    final long b2 = (aVar == null || aVar.a() == null) ? 0 : aVar.a().b();
                    if (b2 == 1) {
                        h = System.currentTimeMillis();
                    }
                    AtomicLong aa = d.aa();
                    b.a(aa, 1);
                    if (aa.get() != 200) {
                        return;
                    }
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        Executor e2 = fVar.e();
                        if (e2 == null) {
                            e2 = fVar.f();
                        }
                        if (e2 != null) {
                            final f fVar2 = fVar;
                            e2.execute(new e("report") {
                                public void run() {
                                    d.this.a(fVar2, b2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.component.e.a.c.c.a("==> monitor upload index1:" + b2);
                    a(fVar, b2);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(f fVar, long j2) {
        c cVar = this.i;
        if (fVar != null && cVar != null) {
            a aVar = d;
            cVar.a(fVar.a(aVar.b(j2)), true);
            aVar.P();
        }
    }

    public void e() {
        b.a(d.H(), 1);
        com.bytedance.sdk.component.e.a.c.c.c("flushMemoryAndDB()");
        final c cVar = this.i;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f m = i.e().m();
            if (m != null) {
                Executor e2 = m.e();
                if (e2 == null) {
                    e2 = m.f();
                }
                if (e2 != null) {
                    e2.execute(new e("flush") {
                        public void run() {
                            c cVar = cVar;
                            if (cVar != null) {
                                cVar.c(2);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            com.bytedance.sdk.component.e.a.c.c.c("discard flush");
        } else if (cVar != null) {
            cVar.c(2);
        }
    }
}
