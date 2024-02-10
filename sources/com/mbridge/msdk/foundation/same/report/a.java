package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonDeviceInfo */
public final class a {
    public static JSONObject a() {
        JSONObject jSONObject;
        try {
            jSONObject = q.a(b.d().g()).b();
        } catch (Exception e) {
            aa.b("CommonDeviceInfo", "getCommonProperty error", e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b("b");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                jSONObject.put("b", com.mbridge.msdk.foundation.same.a.l);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                jSONObject.put("c", com.mbridge.msdk.foundation.same.a.m);
            }
            jSONObject.put("open", com.mbridge.msdk.foundation.same.a.v);
            String a = Aa.a();
            if (a == null) {
                a = "";
            }
            jSONObject.put("channel", a);
            jSONObject.put("band_width", com.mbridge.msdk.foundation.same.net.a.a().e());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            e b = f.a().b(b.d().h());
            if (b == null) {
                b = f.a().b();
            }
            JSONObject a2 = a(b);
            if (a2 != null) {
                String jSONObject2 = a2.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    String a3 = u.a(jSONObject2);
                    if (!TextUtils.isEmpty(a3)) {
                        jSONObject.put("dvi", a3);
                    }
                }
            }
            jSONObject.put("app_id", b.d().h());
            jSONObject.put("m_sdk", "msdk");
            jSONObject.put("lqswt", String.valueOf(1));
            String str = "UNKNOWN";
            if (b != null) {
                str = b.aH();
                jSONObject.put("a_stid", b.c());
            }
            jSONObject.put("country_code", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(e eVar) {
        try {
            return q.a(b.d().g(), eVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
