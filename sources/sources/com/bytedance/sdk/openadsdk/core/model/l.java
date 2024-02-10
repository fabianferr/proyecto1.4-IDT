package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DspStyle */
public class l {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public l(JSONObject jSONObject) {
        this.a = jSONObject.optInt("auto_click", 0);
        this.b = jSONObject.optInt("close_jump_probability", 0);
        this.c = jSONObject.optInt("skip_jump_probability", 0);
        this.d = jSONObject.optInt("hidden_bar", 0);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        int i = this.b;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public int c() {
        int i = this.c;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public boolean d() {
        return this.d == 1;
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.a;
            if (i == 1) {
                jSONObject.put("auto_click", i);
            }
            int i2 = this.b;
            if (i2 > 0 && i2 <= 100) {
                jSONObject.put("close_jump_probability", i2);
            }
            int i3 = this.c;
            if (i3 > 0 && i3 <= 100) {
                jSONObject.put("skip_jump_probability", i3);
            }
            if (this.d == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean a(q qVar) {
        if (qVar == null || !qVar.at() || qVar.aH() == null) {
            return false;
        }
        return qVar.aH().d();
    }
}
