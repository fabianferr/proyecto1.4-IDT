package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.e;
import com.mbridge.msdk.e.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import org.json.JSONObject;

/* compiled from: EventLibraryCommon */
public class h {
    /* access modifiers changed from: private */
    public static final String a = "h";

    public static f a() {
        return new f() {
            public final boolean a(e eVar) throws Exception {
                return h.a(eVar);
            }
        };
    }

    public static com.mbridge.msdk.e.h b() {
        return new com.mbridge.msdk.e.h() {
            public final JSONObject a(e eVar) {
                String str = "";
                if (eVar == null) {
                    return null;
                }
                JSONObject d = eVar.d();
                if (d == null) {
                    d = new JSONObject();
                }
                try {
                    d.put("key", eVar.a());
                    Context g = b.d().g();
                    int r = w.r(g);
                    if (!d.has("network_type")) {
                        d.put("network_type", r);
                        d.put("network_str", w.a(g, r));
                    }
                    if (!d.has("st")) {
                        d.put("st", System.currentTimeMillis());
                    }
                    String optString = d.optString(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    if (!TextUtils.isEmpty(optString)) {
                        String str2 = b.c.get(optString);
                        if (str2 != null) {
                            str = str2;
                        }
                        d.put("u_stid", str);
                    }
                    if (!TextUtils.isEmpty(a.l) && !d.has("b")) {
                        d.put("b", a.l);
                    }
                    if (!TextUtils.isEmpty(a.m) && !d.has("c")) {
                        d.put("c", a.m);
                    }
                } catch (Exception e) {
                    aa.d(h.a, e.getMessage());
                }
                return d;
            }
        };
    }

    public static JSONObject c() {
        return a.a();
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.remove("model");
                jSONObject.remove("brand");
                jSONObject.remove("screen_size");
                jSONObject.remove("sub_ip");
                jSONObject.remove("network_type");
                jSONObject.remove("useragent");
                jSONObject.remove("ua");
                jSONObject.remove("language");
                jSONObject.remove("network_str");
                jSONObject.remove(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC);
                jSONObject.remove(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC);
                jSONObject.remove("os_version");
                jSONObject.remove("gp_version");
                jSONObject.remove("country_code");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                jSONObject.remove(d.f);
                jSONObject.remove(d.g);
                jSONObject.remove("power_rate");
                jSONObject.remove("charging");
                jSONObject.remove("timezone");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.remove("gaid");
                jSONObject.remove("gaid2");
                jSONObject.remove("oaid");
                jSONObject.remove("az_aid_info");
            }
        }
    }

    static /* synthetic */ boolean a(e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        String a2 = eVar.a();
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        com.mbridge.msdk.c.e b = com.mbridge.msdk.c.f.a().b(b.d().h());
        if (b == null) {
            return true;
        }
        return g.a(b, a2);
    }
}
