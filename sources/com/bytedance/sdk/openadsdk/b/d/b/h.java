package com.bytedance.sdk.openadsdk.b.d.b;

import com.bytedance.sdk.component.utils.l;
import org.json.JSONObject;

/* compiled from: FeedPlayModel */
public class h implements c {
    private long a;
    private long b;
    private int c;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("video_start_duration", this.a);
                jSONObject.put("video_cache_size", this.b);
                jSONObject.put("is_auto_play", this.c);
            } catch (Throwable th) {
                l.e("FeedPlayModel", th.getMessage());
            }
        }
    }
}
