package com.startapp;

import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class i3 {
    public final j3 a;
    public final long b;
    public String c;
    public String d;
    public String e;
    public Object f;
    public String g;
    public Long h;
    public String i;
    public boolean j;
    public String k;

    public i3(j3 j3Var) {
        if (j3Var != j3.f) {
            this.a = j3Var;
        } else {
            this.a = j3.e;
        }
        j3 j3Var2 = this.a;
        if (j3Var2 == j3.e || j3Var2 == j3.d) {
            this.i = k9.a(k9.a(0));
        }
        this.b = 0;
    }

    public void a() {
        try {
            ComponentLocator componentLocator = (ComponentLocator) ComponentLocator.N.a;
            if (componentLocator != null) {
                componentLocator.n().a(this, (n3) null);
            }
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return super.toString();
    }

    public void a(n3 n3Var) {
        try {
            ComponentLocator componentLocator = (ComponentLocator) ComponentLocator.N.a;
            if (componentLocator != null) {
                componentLocator.n().a(this, (n3) null);
            } else {
                n3Var.a(this, 3);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th) {
        try {
            new i3(th).a();
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th, j3 j3Var) {
        try {
            new i3(th, j3Var).a();
        } catch (Throwable unused) {
        }
    }

    public i3(Throwable th) {
        this.a = j3.f;
        this.e = k9.b(th);
        this.d = k9.a(k9.a(th));
        this.i = k9.a(k9.a(1));
        this.b = 0;
    }

    public i3(Throwable th, j3 j3Var) {
        boolean z = j3Var == j3.g;
        this.a = j3Var;
        this.e = k9.b(th);
        this.d = k9.a(k9.a(th));
        this.i = z ? th.getClass().getName() : k9.a(k9.a(1));
        this.b = 0;
    }

    public i3(j3 j3Var, long j2) {
        this.a = j3Var;
        this.b = j2;
    }
}
