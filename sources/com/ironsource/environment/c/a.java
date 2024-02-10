package com.ironsource.environment.c;

import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private int a;
    private long b;
    private JSONObject c;

    /* renamed from: com.ironsource.environment.c.a$a  reason: collision with other inner class name */
    public enum C0105a {
        REWARDED_VIDEO,
        INTERSTITIAL,
        OFFERWALL,
        BANNER,
        NATIVE_AD
    }

    public a(int i, long j, JSONObject jSONObject) {
        this.a = i;
        this.b = j;
        this.c = jSONObject;
    }

    public a(int i, JSONObject jSONObject) {
        this.b = -1;
        this.a = i;
        this.b = System.currentTimeMillis();
        if (jSONObject == null) {
            this.c = new JSONObject();
        } else {
            this.c = jSONObject;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c.toString();
    }

    public JSONObject d() {
        return this.c;
    }

    public String toString() {
        return ("{\"eventId\":" + a() + ",\"timestamp\":" + b() + "," + c().substring(1) + "}").replace(",", "\n");
    }
}
