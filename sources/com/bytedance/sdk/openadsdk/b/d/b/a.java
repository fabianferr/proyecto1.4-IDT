package com.bytedance.sdk.openadsdk.b.d.b;

import com.bytedance.sdk.openadsdk.b.d.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import org.json.JSONObject;

/* compiled from: BaseEventModel */
public class a<T extends c> {
    private q a;
    private String b;
    private JSONObject c;
    private T d;
    private boolean e = false;

    public a(q qVar, String str, JSONObject jSONObject, T t) {
        this.a = qVar;
        this.b = str;
        this.c = jSONObject;
        this.d = t;
    }

    public q a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public JSONObject c() {
        if (this.c == null) {
            this.c = new JSONObject();
        }
        return this.c;
    }

    public T d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
