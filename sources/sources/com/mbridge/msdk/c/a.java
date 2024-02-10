package com.mbridge.msdk.c;

import com.mbridge.msdk.foundation.same.net.g.d;
import org.json.JSONObject;

/* compiled from: BCP */
public final class a {
    private String a;
    private String b;
    private int c;
    private int d = 0;
    private int e = 1;
    private int f = 0;
    private int g = 0;
    private int h = 0;

    public final int a() {
        return this.h;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final int h() {
        return this.g;
    }

    public static a a(String str) {
        a aVar;
        Exception e2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.a = jSONObject.optString("http_domain", d.a().b);
                aVar.b = jSONObject.optString("tcp_domain", d.a().i);
                aVar.c = jSONObject.optInt("tcp_port", d.a().m);
                aVar.d = jSONObject.optInt("type", 0);
                int i = 1;
                int optInt = jSONObject.optInt("batch_size", 1);
                if (optInt >= 1) {
                    i = optInt;
                }
                aVar.e = i;
                aVar.f = jSONObject.optInt("duration", 0);
                aVar.g = jSONObject.optInt("disable", 0);
                aVar.h = jSONObject.optInt("e_t_l", 0);
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
                return aVar;
            }
        } catch (Exception e4) {
            e2 = e4;
            aVar = null;
            e2.printStackTrace();
            return aVar;
        }
        return aVar;
    }
}
