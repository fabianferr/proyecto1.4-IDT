package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private final String a;
    private final boolean b;
    private final List<b> c;
    private final List<b> d;
    private boolean e = false;

    c(JSONObject jSONObject, Map<String, b> map, MaxAdFormat maxAdFormat, m mVar) {
        this.a = JsonUtils.getString(jSONObject, "name", "");
        this.b = JsonUtils.getBoolean(jSONObject, "default", false).booleanValue();
        JSONObject jSONObject2 = jSONObject;
        Map<String, b> map2 = map;
        MaxAdFormat maxAdFormat2 = maxAdFormat;
        m mVar2 = mVar;
        this.c = a("bidders", jSONObject2, map2, maxAdFormat2, mVar2);
        this.d = a("waterfall", jSONObject2, map2, maxAdFormat2, mVar2);
    }

    private List<b> a(String str, JSONObject jSONObject, Map<String, b> map, MaxAdFormat maxAdFormat, m mVar) {
        b bVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (!(jSONObject2 == null || (bVar = map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) == null)) {
                if (bVar.z()) {
                    this.e = true;
                }
                arrayList.add(new b(jSONObject2, maxAdFormat, bVar, mVar));
            }
        }
        return arrayList;
    }

    public List<b> a() {
        return this.c;
    }

    public List<b> b() {
        return this.d;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.e;
    }
}
