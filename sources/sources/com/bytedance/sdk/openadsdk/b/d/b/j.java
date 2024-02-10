package com.bytedance.sdk.openadsdk.b.d.b;

import com.bytedance.sdk.component.utils.l;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* compiled from: LoadVideoErrorModel */
public class j implements c {
    private String a;
    private long b;
    private long c;
    private int d;
    private String e;
    private String f;

    public void a(String str) {
        this.a = str;
    }

    public void a(long j) {
        this.b = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("preload_url", this.a);
                jSONObject.put("preload_size", this.b);
                jSONObject.put("load_time", this.c);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.d);
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, this.e);
                jSONObject.put("error_message_server", this.f);
            } catch (Throwable th) {
                l.e("LoadVideoErrorModel", th.getMessage());
            }
        }
    }
}
