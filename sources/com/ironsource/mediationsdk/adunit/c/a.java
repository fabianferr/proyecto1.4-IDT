package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.lifecycle.d;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.S;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Timer;
import java.util.TimerTask;

public final class a {
    final com.ironsource.mediationsdk.adunit.c.c.a a;
    final S b;
    final com.ironsource.lifecycle.a.a c = new com.ironsource.lifecycle.a.a(new Runnable() {
        public final void run() {
            a.this.b.d();
        }
    }, d.a(), new C0224n());
    private Timer d;

    public a(com.ironsource.mediationsdk.adunit.c.c.a aVar, S s) {
        this.a = aVar;
        this.b = s;
    }

    private void c() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    public final void a() {
        if (this.a.b()) {
            IronLog.INTERNAL.verbose();
            a(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        c();
        Timer timer = new Timer();
        this.d = timer;
        timer.schedule(new TimerTask() {
            public final void run() {
                a.this.b.d();
            }
        }, j);
    }

    public final void b() {
        if (this.a.a == a.C0109a.MANUAL_WITH_AUTOMATIC_RELOAD && this.a.d > 0) {
            IronLog.INTERNAL.verbose();
            this.c.a(this.a.d);
        }
    }
}
