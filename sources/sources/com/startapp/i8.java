package com.startapp;

import com.startapp.k8;

/* compiled from: Sta */
public class i8 implements Runnable {
    public final /* synthetic */ k8 a;

    public i8(k8 k8Var) {
        this.a = k8Var;
    }

    public void run() {
        k8 k8Var = this.a;
        k8Var.getClass();
        try {
            if (k8Var.a() != null) {
                if (k8Var.f == null) {
                    k8.c a2 = k8Var.a((Class<?>) null);
                    k8Var.f = a2;
                    if (a2 != null) {
                        a2.a();
                    }
                }
            }
        } catch (Throwable th) {
            if (k8Var.a(1)) {
                i3.a(th);
            }
        }
    }
}
