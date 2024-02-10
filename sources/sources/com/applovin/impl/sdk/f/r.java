package com.applovin.impl.sdk.f;

import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.s;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public abstract class r extends a {
    private final AppLovinAdLoadListener a;
    private final a c;

    private static final class a extends e {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, m mVar) {
            super(jSONObject, jSONObject2, bVar, mVar);
        }

        /* access modifiers changed from: package-private */
        public void a(com.applovin.impl.sdk.utils.r rVar) {
            if (rVar != null) {
                this.a.add(rVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    private static final class b extends r {
        private final String a;

        b(String str, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.a = str;
        }

        public void run() {
            a(e(this.a));
        }
    }

    private static final class c extends r {
        private final JSONObject a;

        c(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.a = eVar.c();
        }

        public void run() {
            f fVar;
            if (u.a()) {
                a("Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.a, "xml", (String) null);
            if (!StringUtils.isValidString(string)) {
                if (u.a()) {
                    d("No VAST response received.");
                }
                fVar = f.NO_WRAPPER_RESPONSE;
            } else if (string.length() < ((Integer) this.b.a(com.applovin.impl.sdk.d.b.ek)).intValue()) {
                a(e(string));
                return;
            } else {
                if (u.a()) {
                    d("VAST response is over max length");
                }
                fVar = f.XML_PARSING;
            }
            a(fVar);
        }
    }

    private static final class d extends r {
        private final com.applovin.impl.sdk.utils.r a;

        d(com.applovin.impl.sdk.utils.r rVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            if (rVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (eVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.a = rVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            if (u.a()) {
                a("Processing VAST Wrapper response...");
            }
            a(this.a);
        }
    }

    r(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessVastResponse", mVar);
        if (eVar != null) {
            this.a = appLovinAdLoadListener;
            this.c = (a) eVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    public static r a(com.applovin.impl.sdk.utils.r rVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new d(rVar, eVar, appLovinAdLoadListener, mVar);
    }

    public static r a(String str, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new b(str, new a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    public static r a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new c(new a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        if (u.a()) {
            d("Failed to process VAST response due to VAST error code " + fVar);
        }
        l.a((e) this.c, this.a, fVar, -6, this.b);
    }

    /* access modifiers changed from: package-private */
    public void a(com.applovin.impl.sdk.utils.r rVar) {
        f fVar;
        a aVar;
        int a2 = this.c.a();
        if (u.a()) {
            a("Finished parsing XML at depth " + a2);
        }
        this.c.a(rVar);
        if (l.a(rVar)) {
            int intValue = ((Integer) this.b.a(com.applovin.impl.sdk.d.b.el)).intValue();
            if (a2 < intValue) {
                if (u.a()) {
                    a("VAST response is wrapper. Resolving...");
                }
                aVar = new x(this.c, this.a, this.b);
            } else {
                if (u.a()) {
                    d("Reached beyond max wrapper depth of " + intValue);
                }
                fVar = f.WRAPPER_LIMIT_REACHED;
                a(fVar);
                return;
            }
        } else if (l.b(rVar)) {
            if (u.a()) {
                a("VAST response is inline. Rendering ad...");
            }
            aVar = new t(this.c, this.a, this.b);
        } else {
            if (u.a()) {
                d("VAST response is an error");
            }
            fVar = f.NO_WRAPPER_RESPONSE;
            a(fVar);
            return;
        }
        this.b.S().a(aVar);
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.utils.r e(String str) {
        try {
            return s.a(str, this.b);
        } catch (Throwable th) {
            if (u.a()) {
                a("Failed to process VAST response", th);
            }
            a(f.XML_PARSING);
            return null;
        }
    }
}
