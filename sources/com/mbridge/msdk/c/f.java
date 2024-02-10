package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingManager */
public class f {
    public static final String a = "f";
    private static f b;
    private static HashMap<String, h> c = new HashMap<>();
    private static volatile e d = null;

    private f() {
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f();
            }
            fVar = b;
        }
        return fVar;
    }

    public final boolean a(String str) {
        e b2 = b(str);
        if (b2 == null) {
            return true;
        }
        return b2.Z() + (b2.Y() * 1000) <= System.currentTimeMillis();
    }

    public final boolean a(String str, int i, String str2) {
        try {
            Context g = b.d().g();
            String str3 = str + "_" + i + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            long longValue = ((Long) ai.b(g, str3, 0L)).longValue();
            e b2 = b(str);
            if (b2 == null) {
                b2 = a().b();
            } else {
                j = longValue;
            }
            if (j + (b2.S() * 1000) > currentTimeMillis) {
                return false;
            }
            ai.a(g, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        e b2 = b(str2);
        if (a(str2) && a(str2, 1, str)) {
            new g().a(b.d().g(), str2, b.d().j());
        }
        h e = e(str2, str);
        if (!(b2 == null || e == null)) {
            if (e.u() + (b2.U() * 1000) > System.currentTimeMillis()) {
                return false;
            }
        }
        return true;
    }

    public final void b(String str, String str2) {
        a.a().a(str, str2);
        d = e.c(str2);
        if (d != null) {
            d.ai();
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!"unitSetting".equals(next) || !jSONObject.has("unitSetting")) {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } else {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final e b(String str) {
        if (d == null) {
            try {
                String b2 = a.a().b(str);
                if (!TextUtils.isEmpty(b2)) {
                    JSONObject jSONObject = new JSONObject(b2);
                    if (jSONObject.has("b")) {
                        jSONObject.remove("b");
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    d = e.c(jSONObject.toString());
                    if (d != null) {
                        d.ai();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public final String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            String b2 = a.a().b(str);
            return b2 == null ? "" : b2;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static void a(Context context, String str) {
        FastKV fastKV;
        c.a();
        Map<String, Object> map = null;
        try {
            fastKV = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
        } catch (Exception unused) {
            fastKV = null;
        }
        if (fastKV != null) {
            try {
                map = fastKV.getAll();
            } catch (Exception unused2) {
            }
            if (map != null) {
                try {
                    for (String next : map.keySet()) {
                        if (next.startsWith(str + "_")) {
                            c.put(next, h.b((String) map.get(next)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                Map<String, ?> all = context.getSharedPreferences("mbridge", 0).getAll();
                for (String next2 : all.keySet()) {
                    if (next2.startsWith(str + "_")) {
                        c.put(next2, h.b((String) all.get(next2)));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final h c(String str, String str2) {
        h e = e(str, str2);
        return e == null ? h.l() : e;
    }

    public final h e(String str, String str2) {
        h h = h(str, str2);
        if (h != null && h.j() == 0) {
            h.c(1);
        }
        return h;
    }

    private h h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = b.d().h();
        }
        String str3 = str + "_" + str2;
        if (c.containsKey(str3)) {
            return c.get(str3);
        }
        h hVar = null;
        try {
            hVar = h.b(a.a().b(str3));
            c.put(str3, hVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hVar;
    }

    public final h f(String str, String str2) {
        return h(str, str2);
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        a.a().a(str4, str3);
        c.put(str4, h.b(str3));
    }

    public final String d(String str) {
        a a2 = a.a();
        return a2.b("ivreward_" + str);
    }

    public final void e(String str) {
        a a2 = a.a();
        a2.c("ivreward_" + str);
    }

    public final void f(String str) {
        try {
            String c2 = c(str);
            if (!TextUtils.isEmpty(c2)) {
                JSONObject jSONObject = new JSONObject(c2);
                jSONObject.put("current_time", System.currentTimeMillis());
                b(str, jSONObject.toString());
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final void g(String str, String str2) {
        try {
            a a2 = a.a();
            String b2 = a2.b(str + "_" + str2);
            if (!TextUtils.isEmpty(b2)) {
                JSONObject jSONObject = new JSONObject(b2);
                jSONObject.put("current_time", System.currentTimeMillis());
                a(str, str2, jSONObject.toString());
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final e b() {
        e eVar = new e();
        eVar.r(1);
        eVar.e(true);
        eVar.c(3600);
        eVar.d(0);
        eVar.d(false);
        eVar.c(false);
        eVar.a(7200);
        eVar.b("<mvpackage>mbridge</mvpackage>");
        eVar.p(1);
        eVar.b(1800);
        eVar.q(259200);
        eVar.e(10);
        eVar.k(1);
        eVar.j(1);
        eVar.l(1);
        eVar.m(0);
        eVar.n(1);
        eVar.o(-1);
        eVar.c(0);
        eVar.e(com.mbridge.msdk.c.a.b.a);
        eVar.d(com.mbridge.msdk.c.a.b.b);
        eVar.b(120);
        eVar.f(false);
        eVar.t(0);
        eVar.u(120);
        eVar.v(1);
        eVar.g(com.mbridge.msdk.foundation.same.a.x);
        eVar.f(com.mbridge.msdk.foundation.same.a.A);
        eVar.e(com.mbridge.msdk.foundation.same.a.z);
        eVar.a(10);
        eVar.h(com.mbridge.msdk.foundation.same.a.B);
        eVar.d(10);
        eVar.x(0);
        eVar.w(0);
        eVar.a("");
        eVar.y(1);
        eVar.b(false);
        eVar.s(1);
        eVar.a(true);
        return eVar;
    }

    public final e g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return b();
            }
            e b2 = b(str);
            if (b2 == null) {
                return b();
            }
            return b2;
        } catch (Exception unused) {
            return b();
        }
    }

    public final h d(String str, String str2) {
        h h = h(str, str2);
        return h == null ? h.l() : h;
    }
}
