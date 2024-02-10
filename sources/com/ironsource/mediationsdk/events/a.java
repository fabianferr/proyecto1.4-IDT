package com.ironsource.mediationsdk.events;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a {
    JSONObject a;
    int b;
    String c;
    private final String d = "eventId";
    private final String e = CampaignEx.JSON_KEY_TIMESTAMP;
    private final String f = "InterstitialEvents";
    private final String g = "events";
    private final String h = "events";

    a() {
    }

    static JSONObject a(com.ironsource.environment.c.a aVar) {
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(aVar.c()) ? new JSONObject(aVar.c()) : new JSONObject();
            jSONObject.put("eventId", aVar.a());
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, aVar.b());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return TextUtils.isEmpty(this.c) ? b() : this.c;
    }

    public abstract String a(ArrayList<com.ironsource.environment.c.a> arrayList, JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public final String a(JSONArray jSONArray) {
        try {
            if (this.a == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.a.toString());
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, IronSourceUtils.getTimestamp());
            jSONObject.put(this.b != 2 ? "events" : "InterstitialEvents", jSONArray);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public abstract String b();

    public abstract String c();
}
