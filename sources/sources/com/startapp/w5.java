package com.startapp;

/* compiled from: Sta */
public class w5 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ v5 d;

    public w5(v5 v5Var, String str, String str2, long j) {
        this.d = v5Var;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public void run() {
        v5 v5Var = this.d;
        String str = this.a;
        String str2 = this.b;
        long j = this.c;
        v5Var.getClass();
        try {
            v5Var.b.a(str, str2, System.currentTimeMillis(), j);
        } catch (Throwable th) {
            if (v5Var.a(1)) {
                i3.a(th);
            }
        }
    }
}
