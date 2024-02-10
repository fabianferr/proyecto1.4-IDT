package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import java.util.Map;

public class c {
    private final m a;
    private final u b;
    private final Object c = new Object();
    private final Map<d, w> d = CollectionUtils.map();
    private final Map<d, w> e = CollectionUtils.map();

    c(m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        for (d next : d.f()) {
            this.d.put(next, new w());
            this.e.put(next, new w());
        }
    }

    private w d(d dVar) {
        w wVar;
        synchronized (this.c) {
            wVar = this.d.get(dVar);
            if (wVar == null) {
                wVar = new w();
                this.d.put(dVar, wVar);
            }
        }
        return wVar;
    }

    private w e(d dVar) {
        w wVar;
        synchronized (this.c) {
            wVar = this.e.get(dVar);
            if (wVar == null) {
                wVar = new w();
                this.e.put(dVar, wVar);
            }
        }
        return wVar;
    }

    private w f(d dVar) {
        synchronized (this.c) {
            w e2 = e(dVar);
            if (e2.a() > 0) {
                return e2;
            }
            w d2 = d(dVar);
            return d2;
        }
    }

    public AppLovinAdImpl a(d dVar) {
        f fVar;
        StringBuilder sb;
        synchronized (this.c) {
            w d2 = d(dVar);
            if (d2.a() > 0) {
                e(dVar).a(d2.c());
                fVar = new f(dVar, this.a);
            } else {
                fVar = null;
            }
        }
        if (u.a()) {
            u uVar = this.b;
            if (fVar == null) {
                sb = new StringBuilder("Unable to retrieve ad of zone ");
            }
            sb.append(dVar);
            sb.append("...");
            uVar.b("AdPreloadManager", sb.toString());
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.c) {
            d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public AppLovinAdImpl b(d dVar) {
        AppLovinAdImpl c2;
        synchronized (this.c) {
            c2 = f(dVar).c();
        }
        return c2;
    }

    public AppLovinAdBase c(d dVar) {
        AppLovinAdImpl d2;
        synchronized (this.c) {
            d2 = f(dVar).d();
        }
        return d2;
    }
}
