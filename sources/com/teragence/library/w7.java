package com.teragence.library;

import android.net.ConnectivityManager;

public class w7 {
    private final ConnectivityManager a;

    private w7(ConnectivityManager connectivityManager) {
        this.a = connectivityManager;
    }

    public static w7 a(ConnectivityManager connectivityManager) {
        return new w7(connectivityManager);
    }

    public int a(int i, String str) {
        return this.a.startUsingNetworkFeature(i, str);
    }

    public boolean a(int i, int i2) {
        return this.a.requestRouteToHost(i, i2);
    }
}
