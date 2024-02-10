package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends a {
    private final com.applovin.impl.adview.activity.a.b s = new com.applovin.impl.adview.activity.a.b(this.a, this.e, this.b);
    private e t;
    private long u;
    /* access modifiers changed from: private */
    public AtomicBoolean v = new AtomicBoolean();

    public b(com.applovin.impl.sdk.ad.e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
    }

    private long c() {
        if (!(this.a instanceof a)) {
            return 0;
        }
        float l = ((a) this.a).l();
        if (l <= 0.0f) {
            l = (float) this.a.t();
        }
        double secondsToMillisLong = (double) Utils.secondsToMillisLong(l);
        double R = (double) this.a.R();
        Double.isNaN(R);
        Double.isNaN(secondsToMillisLong);
        return (long) (secondsToMillisLong * (R / 100.0d));
    }

    public void a() {
    }

    public void a(long j) {
    }

    public void a(ViewGroup viewGroup) {
        this.s.a(this.g, this.f, viewGroup);
        a(false);
        this.f.renderAd(this.a);
        a("javascript:al_onPoststitialShow();", (long) this.a.S());
        if (t()) {
            long c = c();
            this.u = c;
            if (c > 0) {
                if (u.a()) {
                    u uVar = this.c;
                    uVar.b("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.u + "ms...");
                }
                this.t = e.a(this.u, this.b, new Runnable() {
                    public void run() {
                        if (u.a()) {
                            b.this.c.b("AppLovinFullscreenActivity", "Marking ad as fully watched");
                        }
                        b.this.v.set(true);
                    }
                });
            }
        }
        if (this.g != null) {
            if (this.a.t() >= 0) {
                a(this.g, this.a.t(), new Runnable() {
                    public void run() {
                        b.this.i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.g.setVisibility(0);
            }
        }
        u();
        this.b.S().a((com.applovin.impl.sdk.f.a) new z(this.b, new Runnable() {
            public void run() {
                if (b.this.g != null) {
                    b.this.a.o().a((View) b.this.f, (List<d>) Collections.singletonList(new d(b.this.g, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
                } else {
                    b.this.a.o().a((View) b.this.f);
                }
            }
        }), o.a.MAIN, TimeUnit.SECONDS.toMillis(1));
        super.b(Utils.isVideoMutedInitially(this.b));
    }

    public void b() {
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
    }

    public void h() {
        m();
        e eVar = this.t;
        if (eVar != null) {
            eVar.a();
            this.t = null;
        }
        super.h();
    }

    /* access modifiers changed from: protected */
    public void m() {
        e eVar;
        boolean r = r();
        int i = 100;
        if (t()) {
            if (!r && (eVar = this.t) != null) {
                double b = (double) (this.u - eVar.b());
                double d = (double) this.u;
                Double.isNaN(b);
                Double.isNaN(d);
                i = (int) Math.min(100.0d, (b / d) * 100.0d);
            }
            if (u.a()) {
                u uVar = this.c;
                uVar.b("AppLovinFullscreenActivity", "Ad engaged at " + i + "%");
            }
        }
        super.a(i, false, r, -2);
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        if (t()) {
            return this.v.get();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j;
        long millis;
        long j2 = 0;
        if (this.a.ad() >= 0 || this.a.ae() >= 0) {
            int i = (this.a.ad() > 0 ? 1 : (this.a.ad() == 0 ? 0 : -1));
            com.applovin.impl.sdk.ad.e eVar = this.a;
            if (i >= 0) {
                j = eVar.ad();
            } else {
                if (eVar.af()) {
                    int l = (int) ((a) this.a).l();
                    if (l > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) l);
                    } else {
                        int t2 = (int) this.a.t();
                        if (t2 > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) t2);
                        }
                    }
                    j2 = 0 + millis;
                }
                double d = (double) j2;
                double ae = (double) this.a.ae();
                Double.isNaN(ae);
                Double.isNaN(d);
                j = (long) (d * (ae / 100.0d));
            }
            b(j);
        }
    }
}
