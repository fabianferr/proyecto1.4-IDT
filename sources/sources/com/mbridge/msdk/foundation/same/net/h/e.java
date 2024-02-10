package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.text.TextUtils;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import org.json.JSONObject;

/* compiled from: CommonRequestParamsForAdd */
public final class e {
    private static String a = "";
    private static String b = "";

    public static void a(d dVar, Context context) {
        if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", w.x() + "");
            dVar.a("has_wx", w.f(context) + "");
            dVar.a("integrated_wx", w.g() + "");
            dVar.a("opensdk_ver", w.h() + "");
            dVar.a("wx_api_ver", w.c(b.d().i()) + "");
            dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(b.d().g()));
            dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(b.d().g()));
            String u = w.u();
            if (!TextUtils.isEmpty(u)) {
                dVar.a("hardware", u);
            }
            a.a();
            String str = "1";
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                dVar.a("dnt", str);
            }
            String str2 = d.h;
            dVar.a(str2, a.a().e() + "");
            dVar.a("adid_limit", w.b() + "");
            if (!a.h()) {
                str = "0";
            }
            dVar.a("adid_limit_dev", str);
        }
        if (a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            String str3 = d.f;
            dVar.a(str3, ad.b() + "");
            String str4 = d.g;
            dVar.a(str4, ad.a() + "");
            dVar.a(d.d, w.s());
        }
        dVar.a("pkg_source", w.a(w.o(context), context));
        if (b.d().l() != null) {
            dVar.a("web_env", b.d().l().toString());
        }
        dVar.a("http_req", "2");
        a(dVar, true);
        g(dVar);
        f(dVar);
        com.mbridge.msdk.c.e b2 = f.a().b(b.d().h());
        if (b2 == null) {
            b2 = f.a().b();
        }
        if (b2.aG() == 1) {
            dVar.a("gdpr_consent", a.a().f() + "");
        } else if (b2.aB()) {
            dVar.a("gdpr_consent", a.a().f() + "");
        }
        String i = a.a().i();
        if (!TextUtils.isEmpty(i)) {
            dVar.a("tc_string", i);
        }
        h(dVar);
        i(dVar);
    }

    public static void a(d dVar) {
        dVar.a("api_version", com.mbridge.msdk.foundation.same.a.a);
    }

    public static void b(d dVar) {
        dVar.a("dyview_type", com.mbridge.msdk.foundation.same.a.b);
    }

    public static void c(d dVar) {
        if (w.y() != 0) {
            dVar.a("tun", w.y() + "");
        }
    }

    public static void d(d dVar) {
        if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", w.x() + "");
            dVar.a("has_wx", w.f(b.d().g()) + "");
            dVar.a("integrated_wx", w.g() + "");
            dVar.a("opensdk_ver", w.h() + "");
            dVar.a("wx_api_ver", w.c(b.d().i()) + "");
            dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(b.d().g()));
            dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(b.d().g()));
            String u = w.u();
            if (!TextUtils.isEmpty(u)) {
                dVar.a("hardware", u);
            }
            dVar.a("adid_limit", w.b() + "");
            dVar.a("adid_limit_dev", a.h() ? "1" : "0");
        }
        if (a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            dVar.a(d.d, w.s());
        }
        a(dVar, false);
        g(dVar);
        f(dVar);
        h(dVar);
        i(dVar);
    }

    private static void f(d dVar) {
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b("b");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                dVar.a("b", com.mbridge.msdk.foundation.same.a.l);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                dVar.a("c", com.mbridge.msdk.foundation.same.a.m);
            }
        } catch (Exception e) {
            aa.d("CommonRequestParamsForAdd", e.getMessage());
        }
    }

    private static void g(d dVar) {
        int w = w.w();
        if (w != -1) {
            dVar.a("unknown_source", w + "");
        }
    }

    private static void a(d dVar, boolean z) {
        com.mbridge.msdk.c.e b2 = f.a().b(b.d().h());
        if (b2 != null) {
            if (!TextUtils.isEmpty(b2.c()) && z) {
                dVar.a("a_stid", b2.c());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("dmt", w.v() + "");
                    jSONObject.put("dmf", w.t());
                    jSONObject.put("adid_limit", w.b() + "");
                    jSONObject.put("adid_limit_dev", a.h() ? "1" : "0");
                }
                if (b2.I() == 1 && !TextUtils.isEmpty(w.e()) && a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    jSONObject.put("az_aid_info", w.e());
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    if (!jSONObject.equals(a)) {
                        b = u.a(jSONObject.toString());
                    }
                    if (!TextUtils.isEmpty(b)) {
                        dVar.a("dvi", b);
                    }
                }
            } catch (Exception e) {
                aa.d("CommonRequestParamsForAdd", e.getMessage());
            }
        }
    }

    private static void h(d dVar) {
        String d = w.d();
        if (!TextUtils.isEmpty(d)) {
            dVar.a("az_aid_info", d);
        }
    }

    private static void i(d dVar) {
        String str = com.mbridge.msdk.f.b.a;
        if (!TextUtils.isEmpty(str)) {
            dVar.a("cronet_env", str);
        }
    }

    public static void e(d dVar) {
        if (dVar != null) {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("model");
                dVar.a("brand");
                dVar.a("screen_size");
                dVar.a("sub_ip");
                dVar.a("network_type");
                dVar.a("useragent");
                dVar.a("ua");
                dVar.a("language");
                dVar.a("network_str");
                dVar.a("os_version");
                dVar.a("country_code");
                dVar.a("cronet_env");
                dVar.a("adid_limit");
                dVar.a("adid_limit_dev");
            }
            if (!a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                dVar.a(d.f);
                dVar.a(d.g);
                dVar.a("power_rate");
                dVar.a("charging");
                dVar.a("timezone");
            }
            if (!a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                dVar.a("gaid");
                dVar.a("gaid2");
                dVar.a("az_aid_info");
            }
        }
    }
}
