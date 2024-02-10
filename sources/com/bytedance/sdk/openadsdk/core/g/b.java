package com.bytedance.sdk.openadsdk.core.g;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.g.c.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastIcon */
public class b extends c {
    private long j;
    private long k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i, int i2, long j2, long j3, a.C0066a aVar, a.b bVar, String str, List<c> list, List<c> list2, String str2) {
        super(i, i2, aVar, bVar, str, list, list2, str2);
        this.j = j2;
        this.k = j3;
        this.i = "icon_click";
    }

    public static b a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        c b = c.b(jSONObject);
        if (b == null) {
            return null;
        }
        long optLong = jSONObject2.optLong(TypedValues.CycleType.S_WAVE_OFFSET, -1);
        long optLong2 = jSONObject2.optLong("duration", -1);
        return new b(b.a, b.b, optLong, optLong2, b.c, b.d, b.e, b.f, b.g, b.h);
    }

    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (a != null) {
            a.put(TypedValues.CycleType.S_WAVE_OFFSET, this.j);
            a.put("duration", this.k);
        }
        return a;
    }
}
