package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.j6;
import java.io.PrintStream;
import java.util.Locale;

/* compiled from: SpeedtestWorker */
public abstract class l6 extends Thread {
    public final r6 a;
    public final k6 b;
    public final o6 c;
    public boolean d = false;
    public double e = -1.0d;
    public double f = -1.0d;
    public double g = -1.0d;
    public double h = -1.0d;
    public String i = "";
    public final i2 j = new i2();
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    /* compiled from: SpeedtestWorker */
    public class a extends t1 {
        public final /* synthetic */ long e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(w0 w0Var, String str, boolean z, String str2, long j) {
            super(w0Var, str, z, str2);
            this.e = j;
        }
    }

    /* compiled from: SpeedtestWorker */
    public class b extends p1 {
        public final /* synthetic */ long o;
        public final /* synthetic */ l6 p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l6 l6Var, String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, i2 i2Var, long j) {
            super(str, str2, i, str3, i2, i3, i4, i5, i2Var);
            this.p = l6Var;
            this.o = j;
        }
    }

    /* compiled from: SpeedtestWorker */
    public class c extends z6 {
        public final /* synthetic */ long o;
        public final /* synthetic */ l6 p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(l6 l6Var, String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, i2 i2Var, long j) {
            super(str, str2, i, str3, i2, i3, i4, i5, i2Var);
            this.p = l6Var;
            this.o = j;
        }
    }

    /* compiled from: SpeedtestWorker */
    public class d extends r4 {
        public double l = Double.MAX_VALUE;
        public double m = -1.0d;
        public int n = 0;
        public final /* synthetic */ long o;
        public final /* synthetic */ l6 p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(l6 l6Var, String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, i2 i2Var, long j) {
            super(str, str2, i, str3, i2, i3, i4, i5, i2Var);
            this.p = l6Var;
            this.o = j;
        }
    }

    /* compiled from: SpeedtestWorker */
    public class e extends n6 {
        public e(w0 w0Var, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            super(w0Var, str, str2, str3, str4, str5, str6, str7, str8, str9);
        }

        public final void a(String str) {
            if (str.startsWith("id")) {
                l6 l6Var = l6.this;
                String str2 = str.split(" ")[1];
                j6.a aVar = (j6.a) l6Var;
                j6 j6Var = j6.this;
                String a = j6.a(j6Var, j6Var.c);
                if (a != null) {
                    a = String.format(a, new Object[]{str2});
                }
                aVar.o.onTestIDReceived(str2, a);
            }
        }
    }

    public l6(r6 r6Var, k6 k6Var, o6 o6Var) {
        this.a = r6Var;
        this.b = k6Var == null ? new k6() : k6Var;
        this.c = o6Var == null ? new o6() : o6Var;
        start();
    }

    public final void a() {
        if (!this.d) {
            this.j.a("Manually aborted");
            this.d = true;
        }
    }

    public abstract void a(String str);

    public final void b() {
        q1 q1Var;
        boolean z;
        long j2;
        j6.a aVar;
        double d2;
        if (!this.l) {
            this.l = true;
            long currentTimeMillis = System.currentTimeMillis();
            j6.a aVar2 = (j6.a) this;
            aVar2.o.onDownloadUpdate(0.0d, 0.0d);
            int i2 = this.b.c;
            p1[] p1VarArr = new p1[i2];
            int i3 = 0;
            while (i3 < i2) {
                String str = this.a.a;
                k6 k6Var = this.b;
                int i4 = i3;
                p1[] p1VarArr2 = p1VarArr;
                j6.a aVar3 = aVar2;
                int i5 = i2;
                p1VarArr2[i4] = new b(this, str, "garbage", k6Var.a, k6Var.u, k6Var.i, k6Var.j, k6Var.o, k6Var.p, this.j, currentTimeMillis);
                try {
                    Thread.sleep((long) this.b.e);
                } catch (Throwable unused) {
                }
                i3 = i4 + 1;
                i2 = i5;
                p1VarArr = p1VarArr2;
                aVar2 = aVar3;
            }
            p1[] p1VarArr3 = p1VarArr;
            j6.a aVar4 = aVar2;
            int i6 = i2;
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (true) {
                double currentTimeMillis3 = (double) (System.currentTimeMillis() - currentTimeMillis2);
                if (z2 || currentTimeMillis3 < this.b.g * 1000.0d) {
                    if (this.d) {
                        break;
                    }
                    double d3 = (double) j4;
                    Double.isNaN(currentTimeMillis3);
                    Double.isNaN(d3);
                    if (currentTimeMillis3 + d3 >= ((double) (this.b.v * 1000))) {
                        break;
                    }
                    if (z2) {
                        int i7 = 0;
                        long j5 = 0;
                        while (i7 < i6) {
                            p1 p1Var = p1VarArr3[i7];
                            j5 += p1Var.l + p1Var.k;
                            i7++;
                            currentTimeMillis2 = currentTimeMillis2;
                            z2 = z2;
                        }
                        j2 = currentTimeMillis2;
                        z = z2;
                        double d4 = (double) j5;
                        double d5 = 100.0d;
                        if (currentTimeMillis3 >= 100.0d) {
                            d5 = currentTimeMillis3;
                        }
                        Double.isNaN(d4);
                        double d6 = d4 / (d5 / 1000.0d);
                        k6 k6Var2 = this.b;
                        if (k6Var2.x) {
                            double d7 = (2.5d * d6) / 100000.0d;
                            if (d7 > 200.0d) {
                                d7 = 200.0d;
                            }
                            Double.isNaN(d3);
                            j4 = (long) (d3 + d7);
                        }
                        double d8 = (double) j4;
                        Double.isNaN(currentTimeMillis3);
                        Double.isNaN(d8);
                        double d9 = currentTimeMillis3 + d8;
                        double d10 = (double) (k6Var2.v * 1000);
                        Double.isNaN(d10);
                        double d11 = d9 / d10;
                        double d12 = ((d6 * 8.0d) * k6Var2.A) / (k6Var2.D ? 1048576.0d : 1000000.0d);
                        this.e = d12;
                        if (d11 > 1.0d) {
                            aVar = aVar4;
                            d2 = 1.0d;
                        } else {
                            d2 = d11;
                            aVar = aVar4;
                        }
                        aVar.o.onDownloadUpdate(d12, d2);
                    } else {
                        j2 = currentTimeMillis2;
                        z = z2;
                        aVar = aVar4;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Throwable unused2) {
                    }
                    aVar4 = aVar;
                    currentTimeMillis2 = j2;
                    z2 = z;
                    j3 = 0;
                } else {
                    for (int i8 = 0; i8 < i6; i8++) {
                        p1 p1Var2 = p1VarArr3[i8];
                        p1Var2.l = j3;
                        p1Var2.k = j3;
                        q1 q1Var2 = p1Var2.i;
                        if (q1Var2 != null) {
                            q1Var2.e = true;
                        }
                    }
                    currentTimeMillis2 = System.currentTimeMillis();
                    z2 = true;
                }
            }
            j6.a aVar5 = aVar4;
            for (int i9 = 0; i9 < i6; i9++) {
                p1 p1Var3 = p1VarArr3[i9];
                p1Var3.m = true;
                q1 q1Var3 = p1Var3.i;
                if (q1Var3 != null) {
                    q1Var3.d = true;
                }
            }
            for (int i10 = 0; i10 < i6; i10++) {
                p1 p1Var4 = p1VarArr3[i10];
                while (true) {
                    q1Var = p1Var4.i;
                    if (q1Var != null) {
                        break;
                    }
                    try {
                        Thread.sleep(0, 100);
                    } catch (Throwable unused3) {
                    }
                }
                try {
                    q1Var.join();
                } catch (Throwable unused4) {
                }
            }
            if (!this.d) {
                this.j.a("Download: " + this.e + " (took " + (System.currentTimeMillis() - currentTimeMillis) + "ms)");
                aVar5.o.onDownloadUpdate(this.e, 1.0d);
            }
        }
    }

    public final void c() {
        if (!this.k) {
            this.k = true;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                String str = this.a.a;
                k6 k6Var = this.b;
                w0 w0Var = new w0(str, k6Var.m, k6Var.n, -1, -1);
                this.a.getClass();
                k6 k6Var2 = this.b;
                a aVar = new a(w0Var, "getIP", k6Var2.B, k6Var2.C, currentTimeMillis);
                while (aVar.isAlive()) {
                    try {
                        Thread.sleep(0, 100);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th) {
                if (this.b.u.equals("fail")) {
                    a();
                    a(th.toString());
                }
            }
        }
    }

    public final void d() {
        s4 s4Var;
        if (!this.n) {
            this.n = true;
            long currentTimeMillis = System.currentTimeMillis();
            j6.a aVar = (j6.a) this;
            aVar.o.onPingJitterUpdate(0.0d, 0.0d, 0.0d);
            String str = this.a.a;
            k6 k6Var = this.b;
            int i2 = k6Var.y;
            String str2 = k6Var.u;
            int i3 = k6Var.m;
            int i4 = k6Var.n;
            int i5 = k6Var.s;
            int i6 = k6Var.t;
            i2 i2Var = this.j;
            j6.a aVar2 = aVar;
            d dVar = r0;
            d dVar2 = new d(this, str, "empty", i2, str2, i3, i4, i5, i6, i2Var, currentTimeMillis);
            while (true) {
                s4Var = dVar.i;
                if (s4Var == null) {
                    try {
                        Thread.sleep(0, 100);
                    } catch (Throwable unused) {
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable unused2) {
                    }
                }
            }
            s4Var.join();
            if (!this.d) {
                i2 i2Var2 = this.j;
                i2Var2.a("Ping: " + this.g + " " + this.h + " (took " + (System.currentTimeMillis() - currentTimeMillis) + "ms)");
                aVar2.o.onPingJitterUpdate(this.g, this.h, 1.0d);
            }
        }
    }

    public final void e() {
        String format;
        String format2;
        String format3;
        String format4;
        String str;
        if (!this.c.a.equals("disabled")) {
            if (!this.d || !this.c.a.equals("basic")) {
                try {
                    w0 w0Var = new w0(this.c.b, -1, -1, -1, -1);
                    o6 o6Var = this.c;
                    String str2 = o6Var.c;
                    String str3 = o6Var.a;
                    String str4 = this.i;
                    String str5 = this.b.z;
                    double d2 = this.e;
                    if (d2 == -1.0d) {
                        format = "";
                    } else {
                        format = String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(d2)});
                    }
                    String str6 = format;
                    double d3 = this.f;
                    if (d3 == -1.0d) {
                        format2 = "";
                    } else {
                        format2 = String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(d3)});
                    }
                    String str7 = format2;
                    double d4 = this.g;
                    if (d4 == -1.0d) {
                        format3 = "";
                    } else {
                        format3 = String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(d4)});
                    }
                    String str8 = format3;
                    double d5 = this.h;
                    if (d5 == -1.0d) {
                        format4 = "";
                    } else {
                        format4 = String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(d5)});
                    }
                    String str9 = format4;
                    i2 i2Var = this.j;
                    synchronized (i2Var) {
                        str = i2Var.a;
                    }
                    e eVar = new e(w0Var, str2, str3, str4, str5, str6, str7, str8, str9, str);
                    eVar.join();
                } catch (Throwable th) {
                    PrintStream printStream = System.err;
                    printStream.println("Failed to send telemetry: " + th.toString());
                    th.printStackTrace(System.err);
                }
            }
        }
    }

    public final void f() {
        a7 a7Var;
        boolean z;
        long j2;
        j6.a aVar;
        double d2;
        if (!this.m) {
            this.m = true;
            long currentTimeMillis = System.currentTimeMillis();
            j6.a aVar2 = (j6.a) this;
            aVar2.o.onUploadUpdate(0.0d, 0.0d);
            int i2 = this.b.d;
            z6[] z6VarArr = new z6[i2];
            int i3 = 0;
            while (i3 < i2) {
                String str = this.a.a;
                k6 k6Var = this.b;
                int i4 = i3;
                z6[] z6VarArr2 = z6VarArr;
                j6.a aVar3 = aVar2;
                int i5 = i2;
                z6VarArr2[i4] = new c(this, str, "empty", k6Var.b, k6Var.u, k6Var.k, k6Var.l, k6Var.q, k6Var.r, this.j, currentTimeMillis);
                try {
                    Thread.sleep((long) this.b.f);
                } catch (Throwable unused) {
                }
                i3 = i4 + 1;
                i2 = i5;
                z6VarArr = z6VarArr2;
                aVar2 = aVar3;
            }
            z6[] z6VarArr3 = z6VarArr;
            j6.a aVar4 = aVar2;
            int i6 = i2;
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (true) {
                double currentTimeMillis3 = (double) (System.currentTimeMillis() - currentTimeMillis2);
                if (z2 || currentTimeMillis3 < this.b.h * 1000.0d) {
                    if (this.d) {
                        break;
                    }
                    double d3 = (double) j4;
                    Double.isNaN(currentTimeMillis3);
                    Double.isNaN(d3);
                    if (currentTimeMillis3 + d3 >= ((double) (this.b.w * 1000))) {
                        break;
                    }
                    if (z2) {
                        int i7 = 0;
                        long j5 = 0;
                        while (i7 < i6) {
                            z6 z6Var = z6VarArr3[i7];
                            j5 += z6Var.l + z6Var.k;
                            i7++;
                            currentTimeMillis2 = currentTimeMillis2;
                            z2 = z2;
                        }
                        j2 = currentTimeMillis2;
                        z = z2;
                        double d4 = (double) j5;
                        double d5 = 100.0d;
                        if (currentTimeMillis3 >= 100.0d) {
                            d5 = currentTimeMillis3;
                        }
                        Double.isNaN(d4);
                        double d6 = d4 / (d5 / 1000.0d);
                        k6 k6Var2 = this.b;
                        if (k6Var2.x) {
                            double d7 = (2.5d * d6) / 100000.0d;
                            if (d7 > 200.0d) {
                                d7 = 200.0d;
                            }
                            Double.isNaN(d3);
                            j4 = (long) (d3 + d7);
                        }
                        double d8 = (double) j4;
                        Double.isNaN(currentTimeMillis3);
                        Double.isNaN(d8);
                        double d9 = currentTimeMillis3 + d8;
                        double d10 = (double) (k6Var2.w * 1000);
                        Double.isNaN(d10);
                        double d11 = d9 / d10;
                        double d12 = ((d6 * 8.0d) * k6Var2.A) / (k6Var2.D ? 1048576.0d : 1000000.0d);
                        this.f = d12;
                        if (d11 > 1.0d) {
                            aVar = aVar4;
                            d2 = 1.0d;
                        } else {
                            d2 = d11;
                            aVar = aVar4;
                        }
                        aVar.o.onUploadUpdate(d12, d2);
                    } else {
                        j2 = currentTimeMillis2;
                        z = z2;
                        aVar = aVar4;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Throwable unused2) {
                    }
                    aVar4 = aVar;
                    currentTimeMillis2 = j2;
                    z2 = z;
                    j3 = 0;
                } else {
                    for (int i8 = 0; i8 < i6; i8++) {
                        z6 z6Var2 = z6VarArr3[i8];
                        z6Var2.l = j3;
                        z6Var2.k = j3;
                        a7 a7Var2 = z6Var2.i;
                        if (a7Var2 != null) {
                            a7Var2.d = true;
                        }
                    }
                    currentTimeMillis2 = System.currentTimeMillis();
                    z2 = true;
                }
            }
            j6.a aVar5 = aVar4;
            for (int i9 = 0; i9 < i6; i9++) {
                z6 z6Var3 = z6VarArr3[i9];
                z6Var3.m = true;
                a7 a7Var3 = z6Var3.i;
                if (a7Var3 != null) {
                    a7Var3.c = true;
                }
            }
            for (int i10 = 0; i10 < i6; i10++) {
                z6 z6Var4 = z6VarArr3[i10];
                while (true) {
                    a7Var = z6Var4.i;
                    if (a7Var != null) {
                        break;
                    }
                    try {
                        Thread.sleep(0, 100);
                    } catch (Throwable unused3) {
                    }
                }
                try {
                    a7Var.join();
                } catch (Throwable unused4) {
                }
            }
            if (!this.d) {
                this.j.a("Upload: " + this.f + " (took " + (System.currentTimeMillis() - currentTimeMillis) + "ms)");
                aVar5.o.onUploadUpdate(this.f, 1.0d);
            }
        }
    }

    public final void run() {
        this.j.a("Test started");
        try {
            char[] charArray = this.b.E.toCharArray();
            int length = charArray.length;
            int i2 = 0;
            while (i2 < length) {
                char c2 = charArray[i2];
                if (!this.d) {
                    if (c2 == '_') {
                        try {
                            Thread.sleep(1000);
                        } catch (Throwable unused) {
                        }
                    }
                    if (c2 == 'I') {
                        c();
                    }
                    if (c2 == 'D') {
                        b();
                    }
                    if (c2 == 'U') {
                        f();
                    }
                    if (c2 == 'P') {
                        d();
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            a(th.toString());
        }
        try {
            e();
        } catch (Throwable unused2) {
        }
        j6.a aVar = (j6.a) this;
        synchronized (j6.this.e) {
            j6.this.d = 5;
        }
        aVar.o.onEnd();
    }
}
