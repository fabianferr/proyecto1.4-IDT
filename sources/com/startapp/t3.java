package com.startapp;

/* compiled from: Sta */
public abstract class t3 implements Runnable, Comparable<t3> {
    public final i3 a;
    public final k3 b;
    public final n3 c;
    public final Exception d = new Exception();

    public t3(i3 i3Var, k3 k3Var, n3 n3Var) {
        this.a = i3Var;
        this.b = k3Var;
        this.c = n3Var;
    }

    public abstract int a() throws Exception;

    public int compareTo(Object obj) {
        return ((t3) obj).b.c - this.b.c;
    }

    public final void run() {
        n3 n3Var;
        int i = 0;
        try {
            i = a();
            n3Var = this.c;
            if (n3Var == null) {
                return;
            }
        } catch (OutOfMemoryError unused) {
            if (this.c != null) {
                this.c.a(this.a, 0);
                return;
            }
            return;
        } catch (Throwable th) {
            n3 n3Var2 = this.c;
            if (n3Var2 != null) {
                n3Var2.a(this.a, 0);
            }
            throw th;
        }
        n3Var.a(this.a, i);
    }

    public Throwable a(Throwable th) {
        th.addSuppressed(this.d);
        return th;
    }
}
