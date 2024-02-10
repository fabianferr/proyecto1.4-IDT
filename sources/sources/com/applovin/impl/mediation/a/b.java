package com.applovin.impl.mediation.a;

import android.view.View;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public class b extends e {
    private b(b bVar, g gVar) {
        super(bVar.V(), bVar.L(), bVar.K(), gVar, bVar.b);
    }

    public b(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
    }

    public boolean A() {
        return b("proe", (Boolean) this.b.a(a.I)).booleanValue();
    }

    public long B() {
        return Utils.parseColor(b("bg_color", (String) null));
    }

    public a a(g gVar) {
        return new b(this, gVar);
    }

    public int u() {
        int b = b("ad_view_width", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public int v() {
        int b = b("ad_view_height", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public View w() {
        if (!e() || this.a == null) {
            return null;
        }
        return this.a.a();
    }

    public long x() {
        return b("viewability_imp_delay_ms", ((Long) this.b.a(com.applovin.impl.sdk.d.b.bJ)).longValue());
    }

    public boolean y() {
        return z() >= 0;
    }

    public long z() {
        long b = b("ad_refresh_ms", -1);
        return b >= 0 ? b : a("ad_refresh_ms", ((Long) this.b.a(a.l)).longValue());
    }
}
