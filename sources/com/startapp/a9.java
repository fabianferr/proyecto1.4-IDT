package com.startapp;

import com.startapp.sdk.jobs.b;

/* compiled from: Sta */
public class a9 implements Runnable {
    public final /* synthetic */ b.a a;
    public final /* synthetic */ b b;
    public final /* synthetic */ z8 c;

    public a9(z8 z8Var, b.a aVar, b bVar) {
        this.c = z8Var;
        this.a = aVar;
        this.b = bVar;
    }

    public void run() {
        try {
            this.c.j.run();
        } finally {
            this.a.a(this.b, false);
        }
    }
}
