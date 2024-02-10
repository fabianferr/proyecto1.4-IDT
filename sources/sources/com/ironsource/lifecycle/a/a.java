package com.ironsource.lifecycle.a;

import android.util.Log;
import com.ironsource.lifecycle.c;
import com.ironsource.lifecycle.d;
import com.ironsource.mediationsdk.C0224n;
import java.util.Timer;
import java.util.TimerTask;

public class a {
    private static final String a = "a";
    /* access modifiers changed from: private */
    public final d b;
    /* access modifiers changed from: private */
    public final Runnable c;
    /* access modifiers changed from: private */
    public final C0224n d;
    private final Object e = new Object();
    private Timer f;
    /* access modifiers changed from: private */
    public final c g = new c() {
        public final void a() {
            a.this.d.c(System.currentTimeMillis());
            a aVar = a.this;
            aVar.b(aVar.d.b());
        }

        public final void b() {
            a.this.d.b(System.currentTimeMillis());
            a.this.b();
        }
    };

    public a(Runnable runnable, d dVar, C0224n nVar) {
        this.c = runnable;
        this.b = dVar;
        this.d = nVar;
    }

    /* access modifiers changed from: private */
    public void b() {
        synchronized (this.e) {
            Timer timer = this.f;
            if (timer != null) {
                timer.cancel();
                this.f = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(long j) {
        synchronized (this.e) {
            b();
            Timer timer = new Timer();
            this.f = timer;
            timer.schedule(new TimerTask() {
                public final void run() {
                    a.this.b.b(a.this.g);
                    a.this.d.c();
                    a.this.c.run();
                }
            }, j);
        }
    }

    public final void a() {
        b();
        this.b.b(this.g);
        this.d.c();
    }

    public final void a(long j) {
        if (j < 0) {
            Log.d(a, "cannot start timer with delay < 0");
            return;
        }
        this.b.a(this.g);
        this.d.a(j);
        if (this.b.b()) {
            this.d.b(System.currentTimeMillis());
        } else {
            b(j);
        }
    }
}
