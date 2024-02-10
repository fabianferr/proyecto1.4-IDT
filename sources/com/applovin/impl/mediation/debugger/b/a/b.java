package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    private final d a;
    private final e b;
    private final List<e> c;

    public b(JSONObject jSONObject, MaxAdFormat maxAdFormat, com.applovin.impl.mediation.debugger.b.b.b bVar, m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.b = new e(jSONObject2, mVar);
        } else {
            this.b = null;
        }
        this.a = new d(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, bVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.c = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject3 != null) {
                this.c.add(new e(jSONObject3, mVar));
            }
        }
    }

    public d a() {
        return this.a;
    }

    public e b() {
        return this.b;
    }

    public boolean c() {
        return this.b != null;
    }

    public List<e> d() {
        return this.c;
    }
}
