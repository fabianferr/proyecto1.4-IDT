package com.bytedance.sdk.openadsdk.b.d.b;

import com.bytedance.sdk.component.utils.l;
import org.json.JSONObject;

/* compiled from: LoadVideoCancelModel */
public class i implements c {
    private final String a;
    private final long b;

    public i(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("preload_url", this.a);
                jSONObject.put("preload_size", this.b);
            } catch (Throwable th) {
                l.e("LoadVideoCancelModel", th.getMessage());
            }
        }
    }
}