package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.l6;

/* compiled from: DownloadStream */
public abstract class p1 {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public w0 h = null;
    public q1 i;
    public final String j = "attempt-restart";
    public long k = 0;
    public long l = 0;
    public boolean m = false;
    public final i2 n;

    /* compiled from: DownloadStream */
    public class a extends Thread {

        /* renamed from: com.m2catalyst.m2sdk.p1$a$a  reason: collision with other inner class name */
        /* compiled from: DownloadStream */
        public class C0125a extends q1 {
            public C0125a(w0 w0Var, String str, int i) {
                super(w0Var, str, i);
            }
        }

        public a() {
        }

        public final void run() {
            w0 w0Var = p1.this.h;
            if (w0Var != null) {
                try {
                    w0Var.a();
                } catch (Throwable unused) {
                }
            }
            p1 p1Var = p1.this;
            q1 q1Var = p1Var.i;
            if (q1Var != null) {
                q1Var.d = true;
            }
            p1Var.k = 0;
            try {
                p1 p1Var2 = p1.this;
                p1Var.h = new w0(p1Var2.a, p1Var2.d, p1Var2.e, p1Var2.f, p1Var2.g);
                p1 p1Var3 = p1.this;
                if (p1Var3.m) {
                    try {
                        p1Var3.h.a();
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                } else {
                    p1Var3.i = new C0125a(p1Var3.h, p1Var3.b, p1Var3.c);
                    return;
                }
            } catch (Throwable unused3) {
            }
            if (p1.this.j.equals("must-restart")) {
                Thread.sleep(100);
                p1.this.a();
            }
            p1 p1Var4 = p1.this;
            String th = th.toString();
            l6.b bVar = (l6.b) p1Var4;
            i2 i2Var = bVar.p.j;
            i2Var.a("Download: FAILED (took " + (System.currentTimeMillis() - bVar.o) + "ms)");
            bVar.p.a();
            bVar.p.a(th);
            return;
            p1.this.a();
        }
    }

    public p1(String str, String str2, int i2, String str3, int i3, int i4, int i5, int i6, i2 i2Var) {
        this.a = str;
        this.b = str2;
        this.c = i2;
        this.j = str3;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.n = i2Var;
        a();
    }

    public final void a() {
        if (!this.m) {
            new a().start();
        }
    }
}
