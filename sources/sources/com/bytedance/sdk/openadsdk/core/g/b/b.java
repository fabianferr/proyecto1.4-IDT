package com.bytedance.sdk.openadsdk.core.g.b;

import com.bytedance.sdk.openadsdk.core.g.b.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastFractionalProgressTracker */
public class b extends c implements Comparable<b> {
    private final float a;

    private b(float f, String str, c.C0065c cVar, Boolean bool) {
        super(str, cVar, bool);
        this.a = f;
    }

    public boolean a(float f) {
        return this.a <= f && !e();
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        float f = this.a;
        float f2 = bVar.a;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }

    public void h_() {
        super.h_();
    }

    /* compiled from: VastFractionalProgressTracker */
    public static class a {
        private final String a;
        private final float b;
        private c.C0065c c = c.C0065c.TRACKING_URL;
        private boolean d = false;

        public a(String str, float f) {
            this.a = str;
            this.b = f;
        }

        public b a() {
            return new b(this.b, this.a, this.c, Boolean.valueOf(this.d));
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", c());
        jSONObject.put("trackingFraction", (double) this.a);
        return jSONObject;
    }
}
