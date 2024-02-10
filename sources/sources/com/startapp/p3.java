package com.startapp;

/* compiled from: Sta */
public class p3 implements Runnable {
    public final /* synthetic */ i3 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ o3 d;

    public p3(o3 o3Var, i3 i3Var, int i, long j) {
        this.d = o3Var;
        this.a = i3Var;
        this.b = i;
        this.c = j;
    }

    public void run() {
        try {
            this.d.a(this.a, this.b, this.c);
        } catch (Throwable unused) {
        }
    }
}
