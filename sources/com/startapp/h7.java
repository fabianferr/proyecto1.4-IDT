package com.startapp;

/* compiled from: Sta */
public class h7 implements Runnable {
    public final /* synthetic */ g7 a;

    public h7(g7 g7Var) {
        this.a = g7Var;
    }

    public void run() {
        try {
            this.a.c();
        } catch (Throwable th) {
            i3.a(th);
        }
    }
}
