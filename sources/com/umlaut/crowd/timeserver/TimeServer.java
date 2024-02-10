package com.umlaut.crowd.timeserver;

import android.os.SystemClock;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.ub;
import com.umlaut.crowd.internal.vb;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class TimeServer {
    /* access modifiers changed from: private */
    public static final String l = "TimeServer";
    private static final boolean m = false;
    private static final int n = 10000;
    private static final int o = 30000;
    private static final int p = 60000;
    private static final long q = 1640991600000L;
    private static final long r = 3468524400000L;
    /* access modifiers changed from: private */
    public final AtomicBoolean a = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean b = false;
    private boolean c = false;
    /* access modifiers changed from: private */
    public long d = -30000;
    /* access modifiers changed from: private */
    public long e = -1;
    /* access modifiers changed from: private */
    public long f = -1;
    private long g = -60000;
    private long h = -1;
    /* access modifiers changed from: private */
    public final a i = new a();
    /* access modifiers changed from: private */
    public final String j = InsightCore.getInsightConfig().R0();
    private final long k = InsightCore.getInsightConfig().T0();

    private class b implements Runnable {
        private b() {
        }

        public void run() {
            try {
                if (TimeServer.this.i.a(TimeServer.this.j, 10000)) {
                    long a2 = TimeServer.this.i.a();
                    if (a2 > TimeServer.q && a2 < TimeServer.r) {
                        TimeServer timeServer = TimeServer.this;
                        long unused = timeServer.e = timeServer.i.b();
                        long unused2 = TimeServer.this.f = a2;
                        boolean unused3 = TimeServer.this.b = true;
                    }
                } else {
                    Log.v(TimeServer.l, "Syncing TimeServer failed");
                    long unused4 = TimeServer.this.d = SystemClock.elapsedRealtime();
                }
            } catch (Exception unused5) {
            }
            TimeServer.this.a.set(false);
        }
    }

    public TimeServer() {
        b();
    }

    private long d() {
        if (this.c && this.g > this.e) {
            if (SystemClock.elapsedRealtime() - this.e > this.k) {
                b();
            }
            return this.h + (SystemClock.elapsedRealtime() - this.g);
        } else if (this.b) {
            if (SystemClock.elapsedRealtime() - this.e > this.k) {
                b();
            }
            return this.f + (SystemClock.elapsedRealtime() - this.e);
        } else {
            b();
            return System.currentTimeMillis();
        }
    }

    public static long getTimeInMillis() {
        return InsightCore.getTimeServer().d();
    }

    public static ub getTimeInfo() {
        return InsightCore.getTimeServer().c();
    }

    private void b() {
        if (InsightCore.getInsightConfig().S0() && SystemClock.elapsedRealtime() - this.d > 30000 && this.a.compareAndSet(false, true)) {
            ThreadManager.getInstance().getCachedThreadPool().execute(new b());
        }
    }

    private ub c() {
        long j2;
        ub ubVar = new ub();
        boolean z = this.b;
        ubVar.IsSynced = z || this.c;
        if (this.c && this.g > this.e) {
            j2 = this.h + (SystemClock.elapsedRealtime() - this.g);
            ubVar.DeviceDriftMillis = System.currentTimeMillis() - j2;
            ubVar.MillisSinceLastSync = j2 - this.h;
            ubVar.TimeSource = vb.GPS;
            if (SystemClock.elapsedRealtime() - this.e > this.k) {
                b();
            }
        } else if (z) {
            if (SystemClock.elapsedRealtime() - this.e > this.k) {
                b();
            }
            j2 = this.f + (SystemClock.elapsedRealtime() - this.e);
            ubVar.DeviceDriftMillis = System.currentTimeMillis() - j2;
            ubVar.MillisSinceLastSync = j2 - this.f;
            ubVar.TimeSource = vb.NTP;
        } else {
            b();
            j2 = System.currentTimeMillis();
            ubVar.TimeSource = vb.Device;
        }
        ubVar.setMillis(j2);
        return ubVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(long r6, long r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.g     // Catch:{ all -> 0x0049 }
            long r0 = r8 - r0
            r2 = 60000(0xea60, double:2.9644E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0015
            java.lang.String r6 = l     // Catch:{ all -> 0x0049 }
            java.lang.String r7 = "onGpsSync: update too quick"
            android.util.Log.d(r6, r7)     // Catch:{ all -> 0x0049 }
            monitor-exit(r5)
            return
        L_0x0015:
            r0 = 1640991600000(0x17e12b8ad80, double:8.10757574674E-312)
            r2 = 1
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x002f
            r0 = 3468524400000(0x327942a2d80, double:1.713678747802E-311)
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x002f
            r5.h = r6     // Catch:{ all -> 0x0049 }
            r5.g = r8     // Catch:{ all -> 0x0049 }
            r5.c = r2     // Catch:{ all -> 0x0049 }
            goto L_0x0047
        L_0x002f:
            boolean r0 = r5.b     // Catch:{ all -> 0x0049 }
            if (r0 != 0) goto L_0x0047
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0041
            if (r3 >= 0) goto L_0x0041
            r0 = 619315200000(0x9032100000, double:3.059823642673E-312)
            long r6 = r6 + r0
        L_0x0041:
            r5.h = r6     // Catch:{ all -> 0x0049 }
            r5.g = r8     // Catch:{ all -> 0x0049 }
            r5.c = r2     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r5)
            return
        L_0x0049:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.timeserver.TimeServer.a(long, long):void");
    }
}
