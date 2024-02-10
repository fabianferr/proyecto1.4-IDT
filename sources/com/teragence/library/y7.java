package com.teragence.library;

import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.facebook.internal.ServerProtocol;

public class y7 {
    public Object a;
    public Object b;
    public v8[] c;
    public v8[] d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;

    public y7(int i2) {
        String str;
        String str2;
        this.e = i2;
        if (i2 == 100) {
            this.h = "http://www.w3.org/1999/XMLSchema-instance";
            str = "http://www.w3.org/1999/XMLSchema";
        } else {
            this.h = "http://www.w3.org/2001/XMLSchema-instance";
            str = "http://www.w3.org/2001/XMLSchema";
        }
        this.i = str;
        if (i2 < 120) {
            this.g = "http://schemas.xmlsoap.org/soap/encoding/";
            str2 = "http://schemas.xmlsoap.org/soap/envelope/";
        } else {
            this.g = "http://www.w3.org/2003/05/soap-encoding";
            str2 = "http://www.w3.org/2003/05/soap-envelope";
        }
        this.f = str2;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        return lowerCase.equals("1") || lowerCase.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    public void a(x8 x8Var) {
        x8Var.i();
        x8Var.a(2, this.f, "Envelope");
        x8Var.a(this.f, "encodingStyle");
        x8Var.i();
        if (x8Var.l() == 2 && x8Var.k().equals(this.f) && x8Var.n().equals("Header")) {
            c(x8Var);
            x8Var.a(3, this.f, "Header");
            x8Var.i();
        }
        x8Var.a(2, this.f, "Body");
        x8Var.a(this.f, "encodingStyle");
        b(x8Var);
        x8Var.a(3, this.f, "Body");
        x8Var.i();
        x8Var.a(3, this.f, "Envelope");
    }

    public void a(z8 z8Var) {
        z8Var.a(CmcdHeadersFactory.OBJECT_TYPE_INIT_SEGMENT, this.h);
        z8Var.a("d", this.i);
        z8Var.a("c", this.g);
        z8Var.a("v", this.f);
        z8Var.b(this.f, "Envelope");
        z8Var.b(this.f, "Header");
        c(z8Var);
        z8Var.c(this.f, "Header");
        z8Var.b(this.f, "Body");
        b(z8Var);
        z8Var.c(this.f, "Body");
        z8Var.c(this.f, "Envelope");
    }

    public void a(Object obj) {
        this.b = obj;
    }

    public void b(x8 x8Var) {
        throw null;
    }

    public void b(z8 z8Var) {
        throw null;
    }

    public void c(x8 x8Var) {
        x8Var.i();
        w8 w8Var = new w8();
        w8Var.a(x8Var);
        int i2 = 0;
        for (int i3 = 0; i3 < w8Var.a(); i3++) {
            if (w8Var.b(i3) != null) {
                i2++;
            }
        }
        this.c = new v8[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < w8Var.a(); i5++) {
            v8 b2 = w8Var.b(i5);
            if (b2 != null) {
                this.c[i4] = b2;
                i4++;
            }
        }
    }

    public void c(z8 z8Var) {
        if (this.d != null) {
            int i2 = 0;
            while (true) {
                v8[] v8VarArr = this.d;
                if (i2 < v8VarArr.length) {
                    v8VarArr[i2].b(z8Var);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
