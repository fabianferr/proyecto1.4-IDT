package com.startapp;

import android.net.ConnectivityManager;

/* compiled from: Sta */
public class s1 implements ConnectivityManager.OnNetworkActiveListener {
    public final /* synthetic */ t1 a;

    public s1(t1 t1Var) {
        this.a = t1Var;
    }

    public void onNetworkActive() {
        t1 t1Var = this.a;
        synchronized (t1Var.c) {
            for (i2<Void> a2 : t1Var.c) {
                a2.a();
            }
        }
    }
}
