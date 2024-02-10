package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.same.d.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StaticDataPoll */
public class d {
    public static Map<String, Long> a = new HashMap();
    public static Map<String, List<a>> b = new HashMap();
    public static Map<String, List<a>> c = new HashMap();
    public static Map<String, List<a>> d = new HashMap();
    public static Map<String, List<a>> e = new HashMap();
    public static Map<String, List<a>> f = new HashMap();
    public static Map<String, List<a>> g = new HashMap();
    public static Map<String, List<a>> h = new HashMap();
    public static Map<String, List<a>> i = new HashMap();
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, b>> j = null;
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> k = null;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> l = null;
    private static final String m = "d";

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<a>> d2 = d(str2);
        if (campaignEx != null && d2 != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    a aVar = new a(campaignEx.getId(), campaignEx.getRequestIdNotice());
                    if (d2.containsKey(str)) {
                        List list = d2.get(str);
                        if (list != null && list.size() == 20) {
                            list.remove(0);
                        }
                        if (list != null) {
                            list.add(aVar);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    d2.put(str, arrayList);
                }
            } catch (Throwable th) {
                aa.b(m, th.getMessage(), th);
            }
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<a>> map;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            map = d(str2);
        } else if (c.containsKey(str)) {
            map = c;
        } else if (d.containsKey(str)) {
            map = d;
        } else if (e.containsKey(str)) {
            map = e;
        } else if (f.containsKey(str)) {
            map = f;
        } else if (g.containsKey(str)) {
            map = g;
        } else if (h.containsKey(str)) {
            map = h;
        } else {
            map = i.containsKey(str) ? i : null;
        }
        if (map != null) {
            try {
                if (ak.b(str) && map.containsKey(str) && (list = map.get(str)) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", ((a) list.get(i2)).a());
                        jSONObject.put("1", ((a) list.get(i2)).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static void a(String str, String str2, String str3, long j2, long j3, long j4) {
        if (j == null) {
            j = new ConcurrentHashMap<>();
        }
        try {
            if (j.containsKey(str)) {
                Map map = j.get(str);
                if (map != null) {
                    b bVar = (b) map.get(str2);
                    if (bVar == null) {
                        b bVar2 = new b();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        bVar2.a((List<String>) arrayList);
                        bVar2.a(j2);
                        bVar2.b(j3);
                        bVar2.c(j4);
                        map.put(str2, bVar2);
                    } else if (bVar.c() != null) {
                        bVar.a(j2);
                        bVar.b(j3);
                        bVar.c(j4);
                        bVar.c().add(str3);
                    }
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                b bVar3 = new b();
                bVar3.a((List<String>) arrayList2);
                bVar3.a(j2);
                bVar3.b(j3);
                bVar3.c(j4);
                concurrentHashMap.put(str2, bVar3);
                j.put(str, concurrentHashMap);
            }
        } catch (Throwable th) {
            aa.d(m, th.getMessage());
        }
    }

    public static void b(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = j) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            j.remove(str);
            return;
        }
        Map map = j.get(str);
        if (map != null && map.containsKey(str2)) {
            map.remove(str2);
        }
    }

    public static ConcurrentHashMap<String, b> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> concurrentHashMap = j;
        if (concurrentHashMap == null) {
            f a2 = f.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            if (a2 != null) {
                a2.d(str, "");
                j = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, String str2, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        int size;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (k == null) {
                k = new ConcurrentHashMap<>();
            }
            try {
                if (k.containsKey(str)) {
                    copyOnWriteArrayList = k.get(str);
                    copyOnWriteArrayList.add(str2);
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    copyOnWriteArrayList2.add(str2);
                    k.put(str, copyOnWriteArrayList2);
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                }
                if (copyOnWriteArrayList != null && (size = copyOnWriteArrayList.size() - i2) >= 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        copyOnWriteArrayList.remove(i3);
                    }
                }
            } catch (Exception e2) {
                aa.a(m, e2.getMessage());
            }
        }
    }

    public static void b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = k) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = k.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            copyOnWriteArrayList.remove(0);
        }
    }

    public static String c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = k) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = k.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            return (String) copyOnWriteArrayList.get(0);
        }
        return "";
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (l == null) {
                    l = new ConcurrentHashMap<>();
                }
                if (!l.containsKey(str)) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str2, str3);
                    l.put(str, concurrentHashMap);
                } else if (l.get(str) == null) {
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap2.put(str2, str3);
                    l.put(str, concurrentHashMap2);
                }
            } catch (Exception e2) {
                aa.a(m, e2.getMessage());
            }
        }
    }

    public static c c(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        c cVar = new c();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = l;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = l.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                cVar.b(1);
                cVar.c((String) concurrentHashMap.get(str2));
            }
        } catch (Exception e2) {
            aa.a(m, e2.getMessage());
        }
        return cVar;
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = l;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = l.get(str2)) != null && concurrentHashMap.containsKey(str2)) {
                    concurrentHashMap.remove(str2);
                }
            } catch (Exception e2) {
                aa.a(m, e2.getMessage());
            }
        }
    }

    private static Map<String, List<a>> d(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                    c2 = 1;
                    break;
                }
                break;
            case -934326481:
                if (str.equals(com.wortise.ads.events.modules.c.EXTRA_REWARD)) {
                    c2 = 2;
                    break;
                }
                break;
            case -895866265:
                if (str.equals("splash")) {
                    c2 = 3;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c2 = 4;
                    break;
                }
                break;
            case 604727084:
                if (str.equals(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE)) {
                    c2 = 5;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return g;
            case 1:
                return c;
            case 2:
                return d;
            case 3:
                return h;
            case 4:
                return i;
            case 5:
                return f;
            case 6:
                return e;
            default:
                return null;
        }
    }
}
