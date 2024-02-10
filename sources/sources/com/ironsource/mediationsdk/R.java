package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.utils.c;
import java.util.Timer;
import java.util.TimerTask;

public final class R {
    S a;
    private c b;
    private Timer c = null;

    public R(c cVar, S s) {
        this.b = cVar;
        this.a = s;
    }

    private void d() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public final synchronized void a() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new TimerTask() {
            public final void run() {
                R.this.a.d();
            }
        }, this.b.i);
    }

    public final void b() {
        synchronized (this) {
            d();
        }
        this.a.d();
    }

    public final synchronized void c() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new TimerTask() {
            public final void run() {
                R.this.a.d();
            }
        }, this.b.h);
    }
}
