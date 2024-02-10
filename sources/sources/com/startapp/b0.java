package com.startapp;

import android.content.SharedPreferences;

/* compiled from: Sta */
public class b0 {
    public final Object a = new Object();
    public final SharedPreferences b;
    public volatile String c;
    public volatile String d;

    public b0(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    public boolean a() {
        boolean contains;
        synchronized (this.a) {
            contains = this.b.contains("2696a7f502faed4b");
        }
        return contains;
    }
}
