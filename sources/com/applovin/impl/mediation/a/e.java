package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends a {
    protected e(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, m mVar) {
        super(map, jSONObject, jSONObject2, gVar, mVar);
    }

    public int C() {
        MaxAdFormat format = getFormat();
        b bVar = format == MaxAdFormat.BANNER ? b.bK : format == MaxAdFormat.MREC ? b.bM : format == MaxAdFormat.LEADER ? b.bO : format == MaxAdFormat.NATIVE ? b.bQ : null;
        if (bVar != null) {
            return b("viewability_min_width", ((Integer) this.b.a(bVar)).intValue());
        }
        return 0;
    }

    public int D() {
        MaxAdFormat format = getFormat();
        b bVar = format == MaxAdFormat.BANNER ? b.bL : format == MaxAdFormat.MREC ? b.bN : format == MaxAdFormat.LEADER ? b.bP : format == MaxAdFormat.NATIVE ? b.bR : null;
        if (bVar != null) {
            return b("viewability_min_height", ((Integer) this.b.a(bVar)).intValue());
        }
        return 0;
    }

    public float E() {
        return a("viewability_min_alpha", ((Float) this.b.a(a.bS)).floatValue() / 100.0f);
    }

    public int F() {
        return b("viewability_min_pixels", -1);
    }

    public float G() {
        return a("viewability_min_percentage_dp", -1.0f);
    }

    public float H() {
        return a("viewability_min_percentage_pixels", -1.0f);
    }

    public boolean I() {
        return F() >= 0 || G() >= 0.0f || H() >= 0.0f;
    }

    public long J() {
        return b("viewability_timer_min_visible_ms", ((Long) this.b.a(a.bT)).longValue());
    }
}
