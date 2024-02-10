package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.l6;

/* compiled from: UploadStream */
public abstract class z6 {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public w0 h = null;
    public a7 i;
    public final String j = "attempt-restart";
    public long k = 0;
    public long l = 0;
    public boolean m = false;
    public final i2 n;

    /* compiled from: UploadStream */
    public class a extends Thread {

        /* renamed from: com.m2catalyst.m2sdk.z6$a$a  reason: collision with other inner class name */
        /* compiled from: UploadStream */
        public class C0128a extends a7 {
            public C0128a(w0 w0Var, String str, int i) {
                super(w0Var, str, i);
            }
        }

        public a() {
        }

        public final void run() {
            w0 w0Var = z6.this.h;
            if (w0Var != null) {
                try {
                    w0Var.a();
                } catch (Throwable unused) {
                }
            }
            z6 z6Var = z6.this;
            a7 a7Var = z6Var.i;
            if (a7Var != null) {
                a7Var.c = true;
            }
            z6Var.k = 0;
            try {
                z6 z6Var2 = z6.this;
                z6Var.h = new w0(z6Var2.a, z6Var2.d, z6Var2.e, z6Var2.f, z6Var2.g);
                z6 z6Var3 = z6.this;
                if (z6Var3.m) {
                    try {
                        z6Var3.h.a();
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                } else {
                    z6Var3.i = new C0128a(z6Var3.h, z6Var3.b, z6Var3.c);
                    return;
                }
            } catch (Throwable unused3) {
            }
            if (z6.this.j.equals("must-restart")) {
                Thread.sleep(100);
                z6.this.a();
            }
            z6 z6Var4 = z6.this;
            String th = th.toString();
            l6.c cVar = (l6.c) z6Var4;
            i2 i2Var = cVar.p.j;
            i2Var.a("Upload: FAILED (took " + (System.currentTimeMillis() - cVar.o) + "ms)");
            cVar.p.a();
            cVar.p.a(th);
            return;
            z6.this.a();
        }
    }

    public z6(String str, String str2, int i2, String str3, int i3, int i4, int i5, int i6, i2 i2Var) {
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
