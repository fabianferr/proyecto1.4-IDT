package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.l6;
import com.m2catalyst.m2sdk.p1;
import java.io.InputStream;

/* compiled from: Downloader */
public abstract class q1 extends Thread {
    public final w0 a;
    public final String b;
    public final int c;
    public boolean d = false;
    public boolean e = false;
    public long f = 0;

    public q1(w0 w0Var, String str, int i) {
        this.a = w0Var;
        this.b = str;
        this.c = i < 1 ? 1 : i;
        start();
    }

    public final void run() {
        p1.a.C0125a aVar;
        InputStream inputStream;
        String str = "?";
        try {
            String str2 = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            if (str2.contains(str)) {
                str = "&";
            }
            sb.append(str);
            sb.append("ckSize=");
            sb.append(this.c);
            String sb2 = sb.toString();
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) (this.c * 1048576);
            long j2 = j / 4;
            w0 w0Var = this.a;
            w0Var.getClass();
            try {
                inputStream = w0Var.a.getInputStream();
            } catch (Throwable unused) {
                inputStream = null;
            }
            byte[] bArr = new byte[16384];
            long j3 = 0;
            while (true) {
                if (this.d) {
                    break;
                }
                if (j3 <= j2) {
                    this.a.a(sb2);
                    j3 += j;
                }
                if (this.d) {
                    break;
                }
                int read = inputStream.read(bArr);
                if (this.d) {
                    break;
                }
                long j4 = (long) read;
                j3 -= j4;
                if (this.e) {
                    this.f = 0;
                    this.e = false;
                }
                this.f += j4;
                if (System.currentTimeMillis() - currentTimeMillis > 200) {
                    currentTimeMillis = System.currentTimeMillis();
                    p1.this.k = this.f;
                }
            }
            this.a.a();
            return;
        } catch (Throwable unused2) {
        }
        String th = th.toString();
        aVar = (p1.a.C0125a) this;
        i2 i2Var = p1.this.n;
        if (i2Var != null) {
            i2Var.a("A downloader died");
        }
        if (p1.this.j.equals("fail")) {
            l6.b bVar = (l6.b) p1.this;
            bVar.p.j.a("Download: FAILED (took " + (System.currentTimeMillis() - bVar.o) + "ms)");
            bVar.p.a();
            bVar.p.a(th);
            return;
        } else if (p1.this.j.equals("attempt-restart") || p1.this.j.equals("must-restart")) {
            p1 p1Var = p1.this;
            p1Var.l += p1Var.k;
            Thread.sleep(100);
            p1.this.a();
        } else {
            return;
        }
        p1.this.a();
    }
}
