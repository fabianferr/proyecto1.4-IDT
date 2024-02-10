package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.cast.MediaTrack;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.b.a;
import com.mbridge.msdk.c.b.b;
import com.mbridge.msdk.foundation.same.net.h.c;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingRequestController */
public class g {
    /* access modifiers changed from: private */
    public static final String a = "g";

    public final void a(final Context context, final String str, final String str2) {
        if (context != null) {
            d dVar = new d();
            dVar.a("app_id", str);
            dVar.a(MediaTrack.ROLE_SIGN, SameMD5.getMD5(str + str2));
            try {
                String aL = f.a().g(str).aL();
                if (TextUtils.isEmpty(aL)) {
                    aL = "";
                }
                dVar.a("vtag", aL);
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
            if (com.mbridge.msdk.foundation.same.net.g.d.a().M) {
                dVar.a("st_net", com.mbridge.msdk.foundation.same.net.g.d.a().q + "");
            }
            AnonymousClass1 r0 = new c() {
                public final void a(JSONObject jSONObject) {
                    try {
                        String a2 = g.this.b();
                        int i = com.mbridge.msdk.foundation.same.net.g.d.a().q;
                        if (af.a(jSONObject)) {
                            if (jSONObject.optInt("vtag_status", 0) == 1) {
                                String c2 = f.a().c(str);
                                if (!TextUtils.isEmpty(c2)) {
                                    try {
                                        jSONObject = f.a().a(new JSONObject(c2), jSONObject);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            jSONObject.put("current_time", System.currentTimeMillis());
                            if (com.mbridge.msdk.foundation.same.net.g.d.a().p) {
                                if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                    jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.g.d.a().f);
                                }
                            } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                                jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.g.d.a().e);
                            }
                            f.a().b(str, jSONObject.toString());
                            com.mbridge.msdk.foundation.same.net.g.d.a().c();
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                a.a().a(context, jSONObject.optString("mraid_js"));
                            }
                            if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                                b.a().a(context, jSONObject.optString("web_env_url"));
                            }
                            g.a(g.this, context, str);
                        } else {
                            f.a().f(str);
                        }
                        g.a(g.this, 1, i, "", a2);
                        g.b(g.this);
                    } catch (Exception e2) {
                        aa.d(g.a, e2.getMessage());
                    }
                }

                public final void a(String str) {
                    g.a(g.this, 2, com.mbridge.msdk.foundation.same.net.g.d.a().q, str, g.this.b());
                    if (!com.mbridge.msdk.foundation.same.net.g.d.a().p) {
                        com.mbridge.msdk.foundation.same.net.g.d.a().K++;
                    } else {
                        com.mbridge.msdk.foundation.same.net.g.d.a().L++;
                    }
                    g.this.b(context, str, str2);
                    g.b(g.this);
                    aa.d(g.a, "get app setting error" + str);
                }
            };
            com.mbridge.msdk.c.a.c cVar = new com.mbridge.msdk.c.a.c(context);
            String str3 = com.mbridge.msdk.foundation.same.net.g.d.a().x;
            try {
                if (com.mbridge.msdk.foundation.same.net.g.d.a().p && com.mbridge.msdk.foundation.same.net.g.d.a().M && com.mbridge.msdk.foundation.same.net.g.d.a().L < com.mbridge.msdk.foundation.same.net.g.d.a().O.size()) {
                    String str4 = com.mbridge.msdk.foundation.same.net.g.d.a().O.get(com.mbridge.msdk.foundation.same.net.g.d.a().L);
                    if (!TextUtils.isEmpty(str4) && (str4.startsWith("http") || str4.startsWith(ProxyConfig.MATCH_HTTPS))) {
                        str3 = str4 + "/setting";
                    }
                }
            } catch (Throwable th2) {
                aa.d(a, th2.getMessage());
            }
            cVar.get(1, str3, dVar, r0);
        }
    }

    /* access modifiers changed from: private */
    public void b(final Context context, final String str, final String str2) {
        if (!com.mbridge.msdk.foundation.same.net.g.d.a().d()) {
            try {
                if (!com.mbridge.msdk.foundation.same.net.g.d.a().M) {
                    com.mbridge.msdk.foundation.same.net.g.d.a().M = true;
                    if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts").longValue() + 86400000) {
                        String b = com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host");
                        if (!TextUtils.isEmpty(b)) {
                            for (String str3 : b.split("\n")) {
                                if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.a().N.contains(str3.trim())) {
                                    com.mbridge.msdk.foundation.same.net.g.d.a().N.add(str3.trim());
                                    com.mbridge.msdk.foundation.same.net.g.d.a().O.add(str3.trim());
                                }
                            }
                            b(context, str, str2);
                            return;
                        }
                    }
                    new com.mbridge.msdk.foundation.same.net.h.b(context.getApplicationContext()).get(0, com.mbridge.msdk.foundation.same.net.g.d.a().J, new d(), new com.mbridge.msdk.foundation.same.net.c.a() {
                        public final void a(String str) {
                            aa.a(g.a, "fetch CNDSettingHost success, content = " + str);
                            if (!TextUtils.isEmpty(str)) {
                                com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                                com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str);
                                for (String str2 : str.split("\n")) {
                                    if (!TextUtils.isEmpty(str2.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.a().N.contains(str2.trim())) {
                                        com.mbridge.msdk.foundation.same.net.g.d.a().N.add(str2.trim());
                                        com.mbridge.msdk.foundation.same.net.g.d.a().O.add(str2.trim());
                                    }
                                }
                                g.this.b(context, str, str2);
                            }
                        }

                        public final void b(String str) {
                            com.mbridge.msdk.foundation.same.net.g.d.a().M = false;
                            String a2 = g.a;
                            aa.a(a2, "fetch CNDSettingHost failed, errorCode = " + str);
                        }
                    });
                }
            } catch (Throwable th) {
                com.mbridge.msdk.foundation.same.net.g.d.a().M = false;
                aa.d(a, th.getMessage());
            }
        } else {
            a(context, str, str2);
        }
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
            str2 = com.mbridge.msdk.foundation.controller.b.d().j();
        }
        if (f.a().a(str3, str) && f.a().a(str, 2, str3)) {
            d dVar = new d();
            String str4 = "[" + str3 + "]";
            dVar.a("unit_ids", str4);
            dVar.a("app_id", str);
            dVar.a(MediaTrack.ROLE_SIGN, SameMD5.getMD5(str + str2));
            try {
                String y = f.a().c(str, str4).y();
                if (TextUtils.isEmpty(y)) {
                    y = "";
                }
                dVar.a("vtag", y);
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
            new com.mbridge.msdk.c.a.c(context).get(1, com.mbridge.msdk.foundation.same.net.g.d.a().x, dVar, new c() {
                public final void a(JSONObject jSONObject) {
                    try {
                        if (af.a(jSONObject)) {
                            String optString = jSONObject.optString("vtag", "");
                            String optString2 = jSONObject.optString("rid", "");
                            JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                if (jSONObject.optInt("vtag_status", 0) == 1) {
                                    f.a();
                                    String str = str;
                                    String str2 = str3;
                                    String b2 = com.mbridge.msdk.foundation.a.a.a.a().b(str + "_" + str2);
                                    if (!TextUtils.isEmpty(b2)) {
                                        try {
                                            optJSONObject = f.a().a(new JSONObject(b2), optJSONObject);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                optJSONObject.put("current_time", System.currentTimeMillis());
                                optJSONObject.put("vtag", optString);
                                optJSONObject.put("rid", optString2);
                                f.a().a(str, str3, optJSONObject.toString());
                            }
                        } else {
                            f.a().g(str, str3);
                        }
                        g.a(g.this, 1, "");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                public final void a(String str) {
                    g.a(g.this, 2, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String b() {
        String str = com.mbridge.msdk.foundation.same.net.g.d.a().p ? com.mbridge.msdk.foundation.same.net.g.d.a().C : com.mbridge.msdk.foundation.same.net.g.d.a().x;
        try {
            if (!com.mbridge.msdk.foundation.same.net.g.d.a().p || !com.mbridge.msdk.foundation.same.net.g.d.a().M || com.mbridge.msdk.foundation.same.net.g.d.a().L >= com.mbridge.msdk.foundation.same.net.g.d.a().O.size()) {
                return str;
            }
            String str2 = com.mbridge.msdk.foundation.same.net.g.d.a().O.get(com.mbridge.msdk.foundation.same.net.g.d.a().L);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (!str2.startsWith("http") && !str2.startsWith(ProxyConfig.MATCH_HTTPS)) {
                return str;
            }
            return str2 + "/setting";
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
            return str;
        }
    }

    static /* synthetic */ void a(g gVar, Context context, String str) {
        e b;
        f a2 = f.a();
        if (!(a2 == null || (b = a2.b(str)) == null)) {
            MBridgeConstans.OMID_JS_SERVICE_URL = b.ax();
            MBridgeConstans.OMID_JS_H5_URL = b.aw();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    static /* synthetic */ void a(g gVar, int i, int i2, String str, String str2) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, i2, 0, str, str2);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void b(g gVar) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a();
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void a(g gVar, int i, String str) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, com.mbridge.msdk.foundation.same.net.g.d.a().q, 1, str, com.mbridge.msdk.foundation.same.net.g.d.a().p ? com.mbridge.msdk.foundation.same.net.g.d.a().C : com.mbridge.msdk.foundation.same.net.g.d.a().x);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }
}
