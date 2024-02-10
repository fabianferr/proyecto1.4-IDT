package com.apm.insight.d;

import com.apm.insight.CrashType;
import com.apm.insight.g;
import com.apm.insight.i;
import com.apm.insight.k.d;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.p;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static void a(String str) {
        a(str, (Map<? extends String, ? extends String>) null, (Map<String, String>) null, (g) null);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, g gVar) {
        a(str, map, map2, (Map<String, String>) null, gVar);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, g gVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final String str2 = str;
            final Map<? extends String, ? extends String> map4 = map;
            final Map<String, String> map5 = map2;
            final Map<String, String> map6 = map3;
            final g gVar2 = gVar;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    boolean z;
                    try {
                        com.apm.insight.entity.a a2 = f.a().a(CrashType.DART, com.apm.insight.entity.a.a(currentTimeMillis, i.g(), str2));
                        if (map4 != null) {
                            JSONObject optJSONObject = a2.h().optJSONObject("custom");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject, (Map<? extends String, ? extends String>) map4);
                            a2.a("custom", (Object) optJSONObject);
                        }
                        if (map5 != null) {
                            JSONObject optJSONObject2 = a2.h().optJSONObject("custom_long");
                            if (optJSONObject2 == null) {
                                optJSONObject2 = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject2, (Map<? extends String, ? extends String>) map5);
                            a2.a("custom_long", (Object) optJSONObject2);
                        }
                        if (map6 != null) {
                            JSONObject optJSONObject3 = a2.h().optJSONObject(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
                            if (optJSONObject3 == null) {
                                optJSONObject3 = new JSONObject();
                                a2.a(ShareConstants.WEB_DIALOG_PARAM_FILTERS, (Object) optJSONObject3);
                            }
                            com.apm.insight.entity.a.a(optJSONObject3, (Map<? extends String, ? extends String>) map6);
                        }
                        z = d.a().a(currentTimeMillis, a2.h());
                    } catch (Throwable unused) {
                        z = false;
                    }
                    g gVar = gVar2;
                    if (gVar != null) {
                        try {
                            gVar.a(z);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
