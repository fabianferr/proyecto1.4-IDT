package com.ironsource.mediationsdk.events;

import com.ironsource.environment.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class f extends a {
    private final String d = "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    private final String e = "super.dwh.mediation_events";
    private final String f = "table";
    private final String g = "data";

    f(int i) {
        this.b = i;
    }

    public final String a(ArrayList<a> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.a = jSONObject;
        try {
            JSONArray jSONArray = new JSONArray();
            if (!arrayList.isEmpty()) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject a = a(it.next());
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
            }
            jSONObject2.put("table", "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
            return jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String b() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    public final String c() {
        return "ironbeast";
    }
}
