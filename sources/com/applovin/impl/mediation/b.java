package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.sdk.m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

public class b implements a.C0010a, c.a {
    private final a a;
    private final c b;
    /* access modifiers changed from: private */
    public final MaxAdListener c;

    public b(m mVar, MaxAdListener maxAdListener) {
        this.c = maxAdListener;
        this.a = new a(mVar);
        this.b = new c(mVar, this);
    }

    public void a(final com.applovin.impl.mediation.a.c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                b.this.c.onAdHidden(cVar);
            }
        }, cVar.x());
    }

    public void a(MaxAd maxAd) {
        this.b.a();
        this.a.a();
    }

    public void b(com.applovin.impl.mediation.a.c cVar) {
        long v = cVar.v();
        if (v >= 0) {
            this.b.a(cVar, v);
        }
        if (cVar.w()) {
            this.a.a(cVar, this);
        }
    }

    public void c(com.applovin.impl.mediation.a.c cVar) {
        this.c.onAdHidden(cVar);
    }
}
