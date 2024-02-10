package com.startapp;

/* compiled from: Sta */
public class ya implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ wa b;

    public ya(wa waVar, String str) {
        this.b = waVar;
        this.a = str;
    }

    public void run() {
        this.b.f = this.a;
    }
}
