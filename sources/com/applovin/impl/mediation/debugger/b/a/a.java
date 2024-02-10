package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements Comparable<a> {
    private final String a;
    private final String b;
    private final MaxAdFormat c;
    private final c d;
    private final List<c> e;

    public a(JSONObject jSONObject, Map<String, b> map, m mVar) {
        this.a = JsonUtils.getString(jSONObject, "name", "");
        this.b = JsonUtils.getString(jSONObject, "display_name", "");
        this.c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", (String) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.e = new ArrayList(jSONArray.length());
        c cVar = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                c cVar2 = new c(jSONObject2, map, this.c, mVar);
                this.e.add(cVar2);
                if (cVar == null && cVar2.c()) {
                    cVar = cVar2;
                }
            }
        }
        this.d = cVar;
    }

    private c g() {
        if (!this.e.isEmpty()) {
            return this.e.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        return this.b.compareToIgnoreCase(aVar.b);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        MaxAdFormat maxAdFormat = this.c;
        return maxAdFormat != null ? maxAdFormat.getLabel() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public MaxAdFormat d() {
        return this.c;
    }

    public c e() {
        c cVar = this.d;
        return cVar != null ? cVar : g();
    }

    public String f() {
        return "\n---------- " + this.b + " ----------\nIdentifier - " + this.a + "\nFormat     - " + c();
    }
}
