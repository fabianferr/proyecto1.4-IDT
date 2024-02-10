package com.applovin.impl.sdk.f;

import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.sdk.AppLovinAdLoadListener;

class x extends a {
    /* access modifiers changed from: private */
    public final e a;
    /* access modifiers changed from: private */
    public final AppLovinAdLoadListener c;

    x(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskResolveVastWrapper", mVar);
        this.c = appLovinAdLoadListener;
        this.a = eVar;
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        if (u.a()) {
            d("Failed to resolve VAST wrapper due to error code " + i);
        }
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        l.a(this.a, this.c, i == -1001 ? f.TIMED_OUT : f.GENERAL_WRAPPER_ERROR, i, this.b);
    }

    public void run() {
        String a2 = l.a(this.a);
        if (StringUtils.isValidString(a2)) {
            if (u.a()) {
                a("Resolving VAST ad with depth " + this.a.a() + " at " + a2);
            }
            try {
                this.b.S().a((a) new u<r>(c.a(this.b).a(a2).b("GET").a(r.a).a(((Integer) this.b.a(b.eq)).intValue()).b(((Integer) this.b.a(b.er)).intValue()).c(false).a(), this.b) {
                    public void a(int i, String str, r rVar) {
                        if (u.a()) {
                            d("Unable to resolve VAST wrapper. Server returned " + i);
                        }
                        x.this.a(i);
                    }

                    public void a(r rVar, int i) {
                        this.b.S().a((a) r.a(rVar, x.this.a, x.this.c, x.this.b));
                    }
                });
            } catch (Throwable th) {
                if (u.a()) {
                    a("Unable to resolve VAST wrapper", th);
                }
            }
        } else {
            if (u.a()) {
                d("Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
        }
    }
}
