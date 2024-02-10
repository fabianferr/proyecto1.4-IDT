package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.b;
import com.apm.insight.runtime.p;

public class c {
    /* access modifiers changed from: private */
    public static long b;
    /* access modifiers changed from: private */
    public final b a;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public final Runnable d;

    c(b bVar) {
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                if (!c.this.c) {
                    c.this.a.d();
                    long unused = c.b = SystemClock.uptimeMillis();
                    boolean a2 = f.a();
                    p.b().a(c.this.d, 500);
                    b.a(c.b);
                }
            }
        };
        this.d = r0;
        this.a = bVar;
        p.b().a((Runnable) r0, 5000);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - b <= 15000;
    }

    public void a() {
        if (!this.c) {
            p.b().a(this.d, 5000);
        }
    }

    public void b() {
        this.c = true;
    }
}
