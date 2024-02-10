package com.startapp;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class f8 {
    public static final f8 b = new f8(new JSONObject());
    public final JSONObject a;

    public f8() {
        this(new JSONObject());
    }

    public final void a(int i, Object obj) {
        try {
            this.a.put(String.valueOf(i), obj);
        } catch (JSONException unused) {
        }
    }

    public final String b(int i) {
        Object opt = this.a.opt(String.valueOf(i));
        if (opt != null) {
            return opt.toString();
        }
        return null;
    }

    public f8(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public final int a(int i) {
        Object opt = this.a.opt(String.valueOf(i));
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        return 0;
    }
}
