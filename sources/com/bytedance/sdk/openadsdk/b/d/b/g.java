package com.bytedance.sdk.openadsdk.b.d.b;

import com.bytedance.sdk.component.utils.l;
import org.json.JSONObject;

/* compiled from: FeedPauseModel */
public class g implements c {
    private long a;
    private long b;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("buffers_time", this.a);
                jSONObject.put("total_duration", this.b);
            } catch (Throwable th) {
                l.e("FeedPauseModel", th.getMessage());
            }
        }
    }
}
