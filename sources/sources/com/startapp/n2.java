package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class n2 extends v0 {
    public final e e;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ h1 a;

        public a(h1 h1Var) {
            this.a = h1Var;
        }

        public void run() {
            this.a.c();
            n2.this.b.a(this.a.b());
        }
    }

    public n2(Context context, e eVar, g6 g6Var) {
        super(context, g6Var);
        this.e = eVar;
    }

    public void a() {
        try {
            long millis = TimeUnit.SECONDS.toMillis((long) MetaData.k.i().c());
            h1 h1Var = new h1(this.a, this.b);
            this.c.postDelayed(new a(h1Var), millis);
            h1Var.a(b());
        } catch (Throwable th) {
            i3.a(th);
            this.b.a((Object) null);
        }
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.e.getLong("lastBtDiscoveringTime", 0) >= ((long) MetaData.k.i().a()) * 60000;
        if (z) {
            e.a a2 = this.e.edit();
            a2.a("lastBtDiscoveringTime", Long.valueOf(currentTimeMillis));
            a2.a.putLong("lastBtDiscoveringTime", currentTimeMillis);
            a2.apply();
        }
        return z;
    }
}
