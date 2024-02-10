package com.bytedance.sdk.openadsdk.b.d.b;

import com.bykv.vk.openvk.component.video.api.c.a;
import com.bytedance.sdk.component.utils.l;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* compiled from: PlayErrorModel */
public class n implements c {
    private long a;
    private long b;
    private final int c;
    private final int d;
    private final String e;

    public n(a aVar) {
        this.c = aVar.a();
        this.d = aVar.b();
        this.e = aVar.c();
    }

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
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.c);
                jSONObject.put("extra_error_code", this.d);
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, this.e);
            } catch (Throwable th) {
                l.e("PlayErrorModel", th.getMessage());
            }
        }
    }
}
