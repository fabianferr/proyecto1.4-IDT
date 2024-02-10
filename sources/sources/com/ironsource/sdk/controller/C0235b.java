package com.ironsource.sdk.controller;

import java.util.ArrayList;

/* renamed from: com.ironsource.sdk.controller.b  reason: case insensitive filesystem */
public final class C0235b {
    private int a = a.a;
    private ArrayList b = new ArrayList();
    private String c;

    /* renamed from: com.ironsource.sdk.controller.b$a */
    enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;

        static {
            c = new int[]{1, 2};
        }
    }

    public C0235b(String str) {
        this.c = str;
    }

    public final synchronized void a() {
        this.a = a.b;
    }

    public final synchronized void a(Runnable runnable) {
        if (this.a != a.b) {
            this.b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public final synchronized void b() {
        this.a = a.a;
    }

    public final synchronized void c() {
        Object[] array = this.b.toArray();
        for (int i = 0; i < array.length; i++) {
            ((Runnable) array[i]).run();
            array[i] = null;
        }
        this.b.clear();
    }
}
