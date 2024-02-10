package com.mbridge.msdk.c;

import com.mbridge.msdk.foundation.same.net.g.d;
import org.json.JSONObject;

/* compiled from: EventLibMonitorSetting */
public final class b {
    private String a;
    private String b;
    private int c;
    private int d = 0;
    private int e = 1;
    private int f = 30;
    private int g = 0;
    private int h = 1;
    private int i = 0;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public static b a(String str) {
        b bVar;
        Exception e2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar = new b();
            try {
                bVar.a = jSONObject.optString("h_d", d.a().c);
                bVar.b = jSONObject.optString("t_d", d.a().k);
                bVar.c = jSONObject.optInt("t_p", d.a().o);
                bVar.d = jSONObject.optInt("type", 1);
                bVar.f = jSONObject.optInt("d_t", 30);
                bVar.g = jSONObject.optInt("d_a", 0);
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            bVar = null;
            e2.printStackTrace();
            return bVar;
        }
        return bVar;
    }
}
