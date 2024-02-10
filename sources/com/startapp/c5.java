package com.startapp;

/* compiled from: Sta */
public class c5 implements Runnable {
    public final /* synthetic */ b5 a;

    public c5(b5 b5Var) {
        this.a = b5Var;
    }

    public void run() {
        b5 b5Var = this.a;
        b5Var.getClass();
        try {
            b5Var.d();
        } catch (Throwable th) {
            i3.a(th);
        }
    }
}
