package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.j6;
import com.m2catalyst.m2sdk.l6;

/* compiled from: PingStream */
public abstract class r4 {
    public final String a;
    public final String b;
    public int c = 10;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public w0 h = null;
    public s4 i;
    public final String j = "attempt-restart";
    public final i2 k;

    /* compiled from: PingStream */
    public class a extends Thread {

        /* renamed from: com.m2catalyst.m2sdk.r4$a$a  reason: collision with other inner class name */
        /* compiled from: PingStream */
        public class C0126a extends s4 {
            public C0126a(w0 w0Var, String str) {
                super(w0Var, str);
            }

            public final boolean a(long j) {
                double d2;
                double d3;
                l6.d dVar = (l6.d) r4.this;
                dVar.n++;
                double d4 = (double) j;
                Double.isNaN(d4);
                double d5 = d4 / 1000000.0d;
                if (d5 < dVar.l) {
                    dVar.l = d5;
                }
                l6 l6Var = dVar.p;
                l6Var.g = dVar.l;
                double d6 = dVar.m;
                if (d6 == -1.0d) {
                    l6Var.h = 0.0d;
                } else {
                    double abs = Math.abs(d5 - d6);
                    l6 l6Var2 = dVar.p;
                    double d7 = l6Var2.h;
                    if (abs > d7) {
                        d3 = d7 * 0.3d;
                        d2 = 0.7d;
                    } else {
                        d3 = d7 * 0.8d;
                        d2 = 0.2d;
                    }
                    l6Var2.h = (abs * d2) + d3;
                }
                dVar.m = d5;
                double d8 = (double) dVar.n;
                l6 l6Var3 = dVar.p;
                double d9 = (double) l6Var3.b.y;
                Double.isNaN(d8);
                Double.isNaN(d9);
                double d10 = d8 / d9;
                double d11 = l6Var3.g;
                double d12 = l6Var3.h;
                double d13 = 1.0d;
                if (d10 <= 1.0d) {
                    d13 = d10;
                }
                ((j6.a) l6Var3).o.onPingJitterUpdate(d11, d12, d13);
                boolean z = !dVar.p.d;
                r4 r4Var = r4.this;
                int i = r4Var.c - 1;
                r4Var.c = i;
                if (i > 0 && z) {
                    return true;
                }
                r4Var.getClass();
                return false;
            }
        }

        public a() {
        }

        public final void run() {
            r4 r4Var = r4.this;
            s4 s4Var = r4Var.i;
            if (s4Var != null) {
                s4Var.c = true;
            }
            if (r4Var.c > 0) {
                try {
                    r4 r4Var2 = r4.this;
                    r4Var.h = new w0(r4Var2.a, r4Var2.d, r4Var2.e, r4Var2.f, r4Var2.g);
                    r4.this.getClass();
                    r4 r4Var3 = r4.this;
                    r4Var3.i = new C0126a(r4Var3.h, r4Var3.b);
                    return;
                } catch (Throwable unused) {
                }
            } else {
                return;
            }
            if (r4.this.j.equals("must-restart")) {
                Thread.sleep(100);
                r4.this.a();
            }
            r4 r4Var4 = r4.this;
            String th = th.toString();
            l6.d dVar = (l6.d) r4Var4;
            i2 i2Var = dVar.p.j;
            i2Var.a("Ping: FAILED (took " + (System.currentTimeMillis() - dVar.o) + "ms)");
            dVar.p.a();
            dVar.p.a(th);
            return;
            r4.this.a();
        }
    }

    public r4(String str, String str2, int i2, String str3, int i3, int i4, int i5, int i6, i2 i2Var) {
        this.a = str;
        this.b = str2;
        this.c = i2 < 1 ? 1 : i2;
        this.j = str3;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.k = i2Var;
        a();
    }

    public final void a() {
        w0 w0Var = this.h;
        if (w0Var != null) {
            try {
                w0Var.a();
            } catch (Throwable unused) {
            }
        }
        new a().start();
    }
}
