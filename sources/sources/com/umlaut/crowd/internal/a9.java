package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public class a9 {
    SelectionKey a;
    b9 b;
    r9 c;
    int d = 0;
    int e = 0;

    a9(b9 b9Var, SelectionKey selectionKey, r9 r9Var) throws IOException {
        this.a = selectionKey;
        this.b = b9Var;
        this.c = r9Var;
        a(selectionKey.interestOps());
    }

    public SelectionKey a(int i) throws IOException {
        int i2 = i | 1;
        if ((i2 & 8) > 0 && this.c.c().isConnected()) {
            this.c.d();
        }
        if (!this.c.a(false)) {
            i2 |= 4;
        }
        this.d = i;
        this.a.interestOps(i2);
        return this.a;
    }

    public void b() {
        this.b.a(this);
        this.a.cancel();
        this.e = 0;
        this.d = 0;
    }

    public r9 c() throws IOException {
        return this.c;
    }

    public r9 d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public final boolean f() throws IOException {
        return this.a.isValid() && (this.e & 16) != 0;
    }

    public final boolean g() throws IOException {
        return this.a.isValid() && (this.e & 8) != 0;
    }

    public final boolean h() throws IOException {
        return this.a.isValid() && (this.e & 1) != 0;
    }

    public boolean i() {
        return this.a.isValid();
    }

    public final boolean j() throws IOException {
        return this.a.isValid() && (this.e & 4) != 0;
    }

    public int k() throws IOException {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return (this.e & this.d) != 0;
    }

    /* access modifiers changed from: package-private */
    public void m() throws IOException {
        int i = (!this.a.isValid() || !this.a.isAcceptable()) ? 0 : 16;
        if (this.a.isValid() && this.a.isConnectable() && this.c.c().finishConnect()) {
            if (this.c.d()) {
                i |= 8;
            } else {
                this.a.interestOps(5);
            }
        }
        if (this.c.c().isConnected()) {
            if (!this.c.a() && this.c.d()) {
                i |= 8;
            }
            if (this.a.isValid() && this.a.isReadable()) {
                int b2 = this.c.b(true);
                if (b2 == -1) {
                    throw new IOException("Cannot read from EOF Stream");
                } else if (this.c.a() && b2 > 0) {
                    i |= 1;
                }
            }
            if (this.a.isValid()) {
                if (this.a.isWritable()) {
                    if (this.c.a() && this.c.a(false)) {
                        i |= 4;
                        if ((this.d & 4) == 0 && (this.a.interestOps() & 4) != 0) {
                            this.a.interestOps(this.a.interestOps() & -5);
                        }
                    }
                } else if (!this.c.a(false)) {
                    this.a.interestOps(this.a.interestOps() | 4);
                }
            }
            this.e = i;
        }
    }

    public Object a(Object obj) {
        return this.a.attach(obj);
    }

    public final Object a() {
        return this.a.attachment();
    }
}
