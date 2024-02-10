package com.ironsource.mediationsdk;

import com.ironsource.lifecycle.f;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ironsource.mediationsdk.r  reason: case insensitive filesystem */
public final class C0228r {
    C0212b a;
    private Runnable b = new Runnable() {
        public final void run() {
            IronLog.INTERNAL.verbose("loaded ads are expired");
            if (C0228r.this.a != null) {
                C0228r.this.a.a();
            }
        }
    };
    private int c;
    private f d;

    public C0228r(int i, C0212b bVar) {
        this.a = bVar;
        this.c = i;
    }

    private boolean b() {
        return this.c > 0;
    }

    public final void a() {
        if (b() && this.d != null) {
            IronLog.INTERNAL.verbose("canceling expiration timer");
            this.d.c();
            this.d = null;
        }
    }

    public final void a(long j) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis((long) this.c) - Math.max(0, 0);
            if (millis > 0) {
                a();
                this.d = new f(millis, this.b, true);
                Calendar instance = Calendar.getInstance();
                instance.add(14, (int) millis);
                IronLog ironLog = IronLog.INTERNAL;
                StringBuilder sb = new StringBuilder("loaded ads will expire on: ");
                sb.append(instance.getTime());
                sb.append(" in ");
                double d2 = (double) millis;
                Double.isNaN(d2);
                sb.append(String.format("%.2f", new Object[]{Double.valueOf((d2 / 1000.0d) / 60.0d)}));
                sb.append(" minutes");
                ironLog.verbose(sb.toString());
                return;
            }
            IronLog.INTERNAL.verbose("no delay - onAdExpired called");
            this.a.a();
        }
    }
}
