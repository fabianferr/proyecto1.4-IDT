package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: DefaultDecorate */
public final class e implements d {
    public final d a(b bVar) throws Exception {
        if (bVar == null) {
            return null;
        }
        Context g = bVar.d() == null ? b.d().g() : bVar.d();
        String g2 = bVar.g();
        String e = bVar.e();
        String f = bVar.f();
        try {
            String a = a(a(bVar, g, e, g2));
            bVar.a(a);
            if (TextUtils.isEmpty(a)) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CommonReport", "decorate report data is null");
                }
                return null;
            }
            d a2 = q.a(g);
            a2.a("data", URLEncoder.encode(a, "utf-8"));
            if (TextUtils.isEmpty(e)) {
                e = b.d().h();
            }
            a2.a("app_id", e);
            a2.a("m_sdk", "msdk");
            a2.a("r_stid", f);
            if (!TextUtils.isEmpty(g2)) {
                a2.a(MBridgeConstans.PROPERTIES_UNIT_ID, g2);
            }
            return a2;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d("CommonReport", "decorate report data error: " + e2.getMessage());
            }
            return null;
        }
    }

    private Map<String, String> a(b bVar, Context context, String str, String str2) {
        if (bVar == null) {
            return null;
        }
        Map<String, String> m = bVar.m();
        if (m == null) {
            m = new HashMap<>();
        }
        if (!TextUtils.isEmpty(bVar.h())) {
            m.put("adtp", bVar.h());
        }
        if (!TextUtils.isEmpty(str2)) {
            m.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            String str3 = b.c.get(str2);
            if (TextUtils.isEmpty(str)) {
                str = b.d().h();
            }
            h e = f.a().e(str, str2);
            if (e != null && !TextUtils.isEmpty(e.b())) {
                m.put("us_rid", e.b());
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            m.put("u_stid", str3);
        }
        com.mbridge.msdk.c.e b = f.a().b(str);
        if (b == null) {
            b = f.a().b();
        }
        if (!TextUtils.isEmpty(b.k())) {
            m.put("as_rid", b.k());
        }
        try {
            String i = bVar.i();
            String l = b.l();
            JSONArray w = b.w();
            if (w != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= w.length()) {
                        break;
                    } else if (i.equals(w.getString(i2))) {
                        l = "1.0";
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (!TextUtils.isEmpty(l)) {
                m.put("log_rate", l);
            } else {
                m.put("log_rate", "-1");
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        String i3 = bVar.i();
        if (!TextUtils.isEmpty(i3)) {
            m.put("key", i3);
        }
        if (context != null) {
            m.put("network_type", String.valueOf(w.r(context)));
            m.put("network_available", String.valueOf(af.d(context)));
        }
        if (bVar.o()) {
            m.put("duration", String.valueOf(bVar.n()));
        }
        return m;
    }

    private String a(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            if (map.containsKey(CampaignEx.JSON_KEY_CAMPAIGN_UNITID) && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                map.remove(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            }
            StringBuilder sb = new StringBuilder();
            try {
                int i = 0;
                for (String next : map.keySet()) {
                    if (!TextUtils.isEmpty(next)) {
                        String str = map.get(next);
                        if (i == 0) {
                            sb.append(next);
                            sb.append("=");
                            if (str == null) {
                                str = "";
                            }
                            sb.append(str);
                        } else {
                            sb.append("&");
                            sb.append(next);
                            sb.append("=");
                            if (str == null) {
                                str = "";
                            }
                            sb.append(str);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CommonReport", e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }
}
