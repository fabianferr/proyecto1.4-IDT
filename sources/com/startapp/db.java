package com.startapp;

import java.util.ArrayList;

/* compiled from: Sta */
public class db {
    public static db c = new db();
    public final ArrayList<fb> a = new ArrayList<>();
    public final ArrayList<fb> b = new ArrayList<>();

    public static db a() {
        return c;
    }

    public void a(fb fbVar) {
        this.a.add(fbVar);
    }

    public boolean b() {
        return this.b.size() > 0;
    }
}
