package com.applovin.impl.sdk.f;

import android.net.Uri;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinAdLoadListener;

public class d extends c {
    private final a c;
    private boolean d;
    private boolean e;

    public d(a aVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, mVar, appLovinAdLoadListener);
        this.c = aVar;
    }

    private void j() {
        if (u.a()) {
            a("Caching HTML resources...");
        }
        String a = a(this.c.b(), this.c.I(), (e) this.c);
        if (this.c.q() && this.c.isOpenMeasurementEnabled()) {
            a = this.b.al().a(a);
        }
        this.c.a(a);
        this.c.a(true);
        if (u.a()) {
            a("Finish caching non-video resources for ad #" + this.c.getAdIdNumber());
            u A = this.b.A();
            String e2 = e();
            A.a(e2, "Ad updated with cachedHTML = " + this.c.b());
        }
    }

    private void k() {
        Uri e2;
        if (!b() && (e2 = e(this.c.i())) != null) {
            if (this.c.aK()) {
                this.c.a(this.c.b().replaceFirst(this.c.e(), e2.toString()));
                if (u.a()) {
                    a("Replaced video URL with cached video URI in HTML for web video ad");
                }
            }
            this.c.g();
            this.c.a(e2);
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void run() {
        super.run();
        boolean f = this.c.f();
        boolean z = this.e;
        if (f || z) {
            if (u.a()) {
                a("Begin caching for streaming ad #" + this.c.getAdIdNumber() + "...");
            }
            c();
            if (f) {
                if (this.d) {
                    i();
                }
                j();
                if (!this.d) {
                    i();
                }
                k();
            } else {
                i();
                j();
            }
        } else {
            if (u.a()) {
                a("Begin processing for non-streaming ad #" + this.c.getAdIdNumber() + "...");
            }
            c();
            j();
            k();
            i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.c.getCreatedAtMillis();
        com.applovin.impl.sdk.e.d.a(this.c, this.b);
        com.applovin.impl.sdk.e.d.a(currentTimeMillis, (AppLovinAdBase) this.c, this.b);
        a((AppLovinAdBase) this.c);
        a();
    }
}
