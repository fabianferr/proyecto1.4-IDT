package com.mbridge.msdk.e.a;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: NetworkDispatcher */
public final class i extends Thread {
    private final BlockingQueue<m<?>> a;
    private final h b;
    private final a c;
    private final q d;
    private volatile boolean e = false;

    public i(BlockingQueue<m<?>> blockingQueue, h hVar, a aVar, q qVar) {
        this.a = blockingQueue;
        this.b = hVar;
        this.c = aVar;
        this.d = qVar;
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    public final void run() {
        m take;
        Process.setThreadPriority(10);
        while (true) {
            try {
                take = this.a.take();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                take.a(3);
                try {
                    if (take.l()) {
                        take.a("network-discard-cancelled");
                        take.u();
                    } else {
                        TrafficStats.setThreadStatsTag(take.g());
                        k a2 = this.b.a(take);
                        if (!a2.e || !take.t()) {
                            o a3 = take.a(a2);
                            if (take.o() && a3.b != null) {
                                this.c.a(take.i(), a3.b);
                            }
                            take.s();
                            this.d.a((m<?>) take, (o<?>) a3);
                            take.a((o<?>) a3);
                        } else {
                            take.a("not-modified");
                            take.u();
                        }
                    }
                } catch (u e2) {
                    e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.a((m<?>) take, e2);
                    take.u();
                } catch (Exception e3) {
                    v.a(e3, "Unhandled exception %s", e3.toString());
                    u uVar = new u((Throwable) e3);
                    uVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.a((m<?>) take, uVar);
                    take.u();
                }
                take.a(4);
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            } catch (Throwable th) {
                take.a(4);
                throw th;
            }
        }
    }
}
