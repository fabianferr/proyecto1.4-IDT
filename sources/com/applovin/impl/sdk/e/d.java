package com.applovin.impl.sdk.e;

import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.g;

public class d {
    private final m a;
    private final g b;
    private final c.a c;
    private final Object d = new Object();
    private final long e;
    private long f;
    private long g;
    private long h;

    public d(AppLovinAdImpl appLovinAdImpl, m mVar) {
        if (appLovinAdImpl == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (mVar != null) {
            this.a = mVar;
            this.b = mVar.T();
            c.a a2 = mVar.ac().a(appLovinAdImpl);
            this.c = a2;
            a2.a(b.a, (long) appLovinAdImpl.getSource().ordinal()).a();
            this.e = appLovinAdImpl.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void a(long j, AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.b, j).a();
        }
    }

    public static void a(AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.c, appLovinAdBase.getFetchLatencyMillis()).a(b.d, appLovinAdBase.getFetchResponseSize()).a();
        }
    }

    private void a(b bVar) {
        synchronized (this.d) {
            if (this.f > 0) {
                this.c.a(bVar, System.currentTimeMillis() - this.f).a();
            }
        }
    }

    public static void a(e eVar, AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null && eVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.e, eVar.c()).a(b.f, eVar.d()).a(b.t, eVar.g()).a(b.u, eVar.h()).a(b.v, eVar.b() ? 1 : 0).a();
        }
    }

    public void a() {
        long a2 = this.b.a(f.b);
        this.c.a(b.j, a2).a(b.i, this.b.a(f.e));
        synchronized (this.d) {
            long j = 0;
            if (this.e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f = currentTimeMillis;
                long O = currentTimeMillis - this.a.O();
                long j2 = this.f - this.e;
                Activity a3 = this.a.af().a();
                if (g.f() && a3 != null && a3.isInMultiWindowMode()) {
                    j = 1;
                }
                this.c.a(b.h, O).a(b.g, j2).a(b.w, j);
            }
        }
        this.c.a();
    }

    public void a(long j) {
        this.c.a(b.q, j).a();
    }

    public void b() {
        synchronized (this.d) {
            if (this.g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.g = currentTimeMillis;
                long j = this.f;
                if (j > 0) {
                    this.c.a(b.m, currentTimeMillis - j).a();
                }
            }
        }
    }

    public void b(long j) {
        this.c.a(b.p, j).a();
    }

    public void c() {
        a(b.k);
    }

    public void c(long j) {
        this.c.a(b.r, j).a();
    }

    public void d() {
        a(b.n);
    }

    public void d(long j) {
        synchronized (this.d) {
            if (this.h < 1) {
                this.h = j;
                this.c.a(b.s, j).a();
            }
        }
    }

    public void e() {
        a(b.o);
    }

    public void f() {
        a(b.l);
    }

    public void g() {
        this.c.a(b.x).a();
    }
}
