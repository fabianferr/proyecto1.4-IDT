package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.y;
import com.applovin.impl.sdk.z;

public class b implements z.a {
    private final m a;
    private final d b;
    private final z c;
    private final y d;
    private final a.C0011a e;

    public b(d dVar, a.C0011a aVar, m mVar) {
        this.a = mVar;
        this.b = dVar;
        this.e = aVar;
        this.d = new y(dVar.u(), mVar);
        z zVar = new z(dVar.u(), mVar, this);
        this.c = zVar;
        zVar.a((e) dVar);
        if (u.a()) {
            u A = mVar.A();
            A.b("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    private void a(long j) {
        if (this.b.y().compareAndSet(false, true)) {
            if (u.a()) {
                this.a.A().b("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.a.E().processViewabilityAdImpressionPostback(this.b, j, this.e);
        }
    }

    public void a() {
        this.c.a();
    }

    public void b() {
        if (u.a()) {
            this.a.A().b("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.b.x().compareAndSet(false, true)) {
            if (u.a()) {
                this.a.A().b("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            this.a.E().processRawAdImpressionPostback(this.b, this.e);
        }
    }

    public d c() {
        return this.b;
    }

    public void onLogVisibilityImpression() {
        a(this.d.a(this.b));
    }
}
