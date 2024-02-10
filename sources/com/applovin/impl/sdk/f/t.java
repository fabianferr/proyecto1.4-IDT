package com.applovin.impl.sdk.f;

import com.applovin.impl.a.a;
import com.applovin.impl.a.c;
import com.applovin.impl.a.d;
import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.i;
import com.applovin.impl.a.j;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.r;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

class t extends a {
    private final e a;
    private final AppLovinAdLoadListener c;

    t(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskRenderVastAd", mVar);
        this.c = appLovinAdLoadListener;
        this.a = eVar;
    }

    public void run() {
        if (u.a()) {
            a("Rendering VAST ad...");
        }
        int size = this.a.b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        i iVar = null;
        com.applovin.impl.a.m mVar = null;
        d dVar = null;
        c cVar = null;
        String str2 = str;
        for (r next : this.a.b()) {
            r c2 = next.c(l.a(next) ? "Wrapper" : "InLine");
            if (c2 != null) {
                r c3 = c2.c("AdSystem");
                if (c3 != null) {
                    iVar = i.a(c3, iVar, this.b);
                }
                str = l.a(c2, "AdTitle", str);
                str2 = l.a(c2, "Description", str2);
                l.a(c2.a("Impression"), (Set<j>) hashSet, this.a, this.b);
                r b = c2.b("ViewableImpression");
                if (b != null) {
                    l.a(b.a("Viewable"), (Set<j>) hashSet, this.a, this.b);
                }
                r c4 = c2.c("AdVerifications");
                if (c4 != null) {
                    cVar = c.a(c4, cVar, this.a, this.b);
                }
                l.a(c2.a("Error"), (Set<j>) hashSet2, this.a, this.b);
                r b2 = c2.b("Creatives");
                if (b2 != null) {
                    for (r next2 : b2.d()) {
                        r b3 = next2.b("Linear");
                        if (b3 != null) {
                            mVar = com.applovin.impl.a.m.a(b3, mVar, this.a, this.b);
                        } else {
                            r c5 = next2.c("CompanionAds");
                            if (c5 != null) {
                                r c6 = c5.c("Companion");
                                if (c6 != null) {
                                    dVar = d.a(c6, dVar, this.a, this.b);
                                }
                            } else if (u.a()) {
                                d("Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else if (u.a()) {
                d("Did not find wrapper or inline response for node: " + next);
            }
        }
        a a2 = new a.C0006a().a(this.b).a(this.a.c()).b(this.a.d()).a(this.a.e()).a(this.a.f()).a(str).b(str2).a(iVar).a(mVar).a(dVar).a(cVar).a((Set<j>) hashSet).a(cVar).b((Set<j>) hashSet2).a();
        f a3 = l.a(a2);
        if (a3 == null) {
            if (u.a()) {
                a("Finished rendering VAST ad: " + a2);
            }
            a2.o().b();
            e eVar = new e(a2, this.b, this.c);
            o.a aVar = o.a.CACHING_OTHER;
            if (((Boolean) this.b.a(b.bk)).booleanValue()) {
                if (a2.getType() == AppLovinAdType.REGULAR) {
                    aVar = o.a.CACHING_INTERSTITIAL;
                } else if (a2.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = o.a.CACHING_INCENTIVIZED;
                }
            }
            this.b.S().a((a) eVar, aVar);
            return;
        }
        l.a(this.a, this.c, a3, -6, this.b);
    }
}
