package com.applovin.impl.mediation.a;

import android.os.SystemClock;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class c extends a {
    private final AtomicReference<com.applovin.impl.sdk.c.c> c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;

    private c(c cVar, g gVar) {
        super(cVar.V(), cVar.L(), cVar.K(), gVar, cVar.b);
        this.e = new AtomicBoolean();
        this.c = cVar.c;
        this.d = cVar.d;
    }

    public c(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
        this.e = new AtomicBoolean();
        this.c = new AtomicReference<>();
        this.d = new AtomicBoolean();
    }

    public long A() {
        return b("ahdm", ((Long) this.b.a(a.w)).longValue());
    }

    public boolean B() {
        return b("susaode", (Boolean) this.b.a(a.v)).booleanValue();
    }

    public String C() {
        return b("bcode", "");
    }

    public String D() {
        return a("mcode", "");
    }

    public boolean E() {
        return this.d.get();
    }

    public void F() {
        this.d.set(true);
    }

    public com.applovin.impl.sdk.c.c G() {
        return this.c.getAndSet((Object) null);
    }

    public AtomicBoolean H() {
        return this.e;
    }

    public a a(g gVar) {
        return new c(this, gVar);
    }

    public void a(com.applovin.impl.sdk.c.c cVar) {
        this.c.set(cVar);
    }

    public long u() {
        long b = b("ad_expiration_ms", -1);
        return b >= 0 ? b : a("ad_expiration_ms", ((Long) this.b.a(a.C)).longValue());
    }

    public long v() {
        long b = b("ad_hidden_timeout_ms", -1);
        return b >= 0 ? b : a("ad_hidden_timeout_ms", ((Long) this.b.a(a.F)).longValue());
    }

    public boolean w() {
        if (b("schedule_ad_hidden_on_ad_dismiss", (Boolean) false).booleanValue()) {
            return true;
        }
        return a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.b.a(a.G)).booleanValue();
    }

    public long x() {
        long b = b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        return b >= 0 ? b : a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.b.a(a.H)).longValue());
    }

    public long y() {
        if (q() > 0) {
            return SystemClock.elapsedRealtime() - q();
        }
        return -1;
    }

    public long z() {
        long b = b("fullscreen_display_delay_ms", -1);
        return b >= 0 ? b : ((Long) this.b.a(a.u)).longValue();
    }
}
