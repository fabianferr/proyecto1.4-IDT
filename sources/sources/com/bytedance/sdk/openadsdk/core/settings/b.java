package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdSlotSettings */
public class b {
    private static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public static void a(boolean z) {
        String str;
        File b = b();
        if (!b.exists()) {
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                str = a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            } else {
                str = y.a("tt_sdk_settings", o.a()).a("ad_slot_conf", (String) null);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap<String, a> b2 = b(new JSONArray(str));
                    if (!b2.isEmpty()) {
                        ConcurrentHashMap<String, a> concurrentHashMap = a;
                        concurrentHashMap.clear();
                        concurrentHashMap.putAll(b2);
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            try {
                HashMap<String, a> b3 = b(new JSONArray(new String(f.d(b))));
                if (!b3.isEmpty()) {
                    for (Map.Entry next : b3.entrySet()) {
                        String str2 = (String) next.getKey();
                        a aVar = (a) next.getValue();
                        if (!aVar.G || z) {
                            a.put(str2, aVar);
                        } else {
                            a aVar2 = a.get(str2);
                            if (aVar2 != null) {
                                aVar2.N = aVar.M;
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    private static HashMap<String, a> b(JSONArray jSONArray) {
        HashMap<String, a> hashMap = new HashMap<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                a a2 = a(jSONArray.getJSONObject(i));
                if (a2 != null) {
                    hashMap.put(a2.a, a2);
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    private static File b() {
        return new File(o.a().getFilesDir(), "tt_ads_conf");
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject);
    }

    public static a a(String str) {
        a aVar = a.get(str);
        return aVar == null ? b(str) : aVar;
    }

    private static a b(String str) {
        return new a(str, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.json.JSONArray r5) {
        /*
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = b()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r0.getParent()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.getName()
            r3.append(r4)
            java.lang.String r4 = ".tmp"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            r2 = 0
            boolean r3 = r1.exists()     // Catch:{ Exception -> 0x0062 }
            if (r3 == 0) goto L_0x002f
            r1.delete()     // Catch:{ Exception -> 0x0062 }
        L_0x002f:
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ Exception -> 0x0062 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            r3.write(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            r1.renameTo(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            java.lang.String r0 = "tt_sdk_settings"
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            com.bytedance.sdk.openadsdk.utils.y r0 = com.bytedance.sdk.openadsdk.utils.y.a((java.lang.String) r0, (android.content.Context) r2)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            java.lang.String r2 = "ad_slot_conf"
            r0.a(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0056
            r1.delete()
        L_0x0056:
            com.bytedance.sdk.openadsdk.utils.h.a(r3)
            goto L_0x0076
        L_0x005a:
            r5 = move-exception
            r2 = r3
            goto L_0x00ba
        L_0x005d:
            r0 = move-exception
            r2 = r3
            goto L_0x0063
        L_0x0060:
            r5 = move-exception
            goto L_0x00ba
        L_0x0062:
            r0 = move-exception
        L_0x0063:
            java.lang.String r3 = "SdkSettings.AdSlot"
            java.lang.String r4 = "saveAdSlotToLocal: "
            android.util.Log.e(r3, r4, r0)     // Catch:{ all -> 0x0060 }
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0073
            r1.delete()
        L_0x0073:
            com.bytedance.sdk.openadsdk.utils.h.a(r2)
        L_0x0076:
            java.util.HashMap r5 = b((org.json.JSONArray) r5)
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x00b9
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0088:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00b9
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            com.bytedance.sdk.openadsdk.core.settings.a r0 = (com.bytedance.sdk.openadsdk.core.settings.a) r0
            boolean r2 = r0.G
            if (r2 == 0) goto L_0x00b3
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bytedance.sdk.openadsdk.core.settings.a> r2 = a
            java.lang.Object r1 = r2.get(r1)
            com.bytedance.sdk.openadsdk.core.settings.a r1 = (com.bytedance.sdk.openadsdk.core.settings.a) r1
            if (r1 == 0) goto L_0x0088
            java.lang.String r0 = r0.M
            r1.N = r0
            goto L_0x0088
        L_0x00b3:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bytedance.sdk.openadsdk.core.settings.a> r2 = a
            r2.put(r1, r0)
            goto L_0x0088
        L_0x00b9:
            return
        L_0x00ba:
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x00c3
            r1.delete()
        L_0x00c3:
            com.bytedance.sdk.openadsdk.utils.h.a(r2)
            goto L_0x00c8
        L_0x00c7:
            throw r5
        L_0x00c8:
            goto L_0x00c7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.b.a(org.json.JSONArray):void");
    }

    public static void a() {
        File b = b();
        if (b.exists()) {
            b.delete();
        }
    }
}
