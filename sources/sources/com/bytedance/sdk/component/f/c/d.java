package com.bytedance.sdk.component.f.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.d.b;
import com.bytedance.sdk.component.f.d.c;
import java.util.HashMap;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TNCConfigHandler */
public class d {
    private static final Object d = new Object();
    private Context a;
    private c b = new c();
    private boolean c;
    private int e;

    public d(Context context, boolean z, int i) {
        this.a = context;
        this.c = z;
        this.e = i;
    }

    private c b(JSONObject jSONObject) {
        try {
            c cVar = new c();
            boolean z = true;
            if (jSONObject.has("local_enable")) {
                cVar.a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                if (jSONObject.getInt("probe_enable") == 0) {
                    z = false;
                }
                cVar.b = z;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                cVar.c = hashMap;
            } else {
                cVar.c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next)) {
                            if (!TextUtils.isEmpty(string2)) {
                                hashMap2.put(next, string2);
                            }
                        }
                    }
                }
                cVar.d = hashMap2;
            } else {
                cVar.d = null;
            }
            cVar.e = jSONObject.optInt("req_to_cnt", cVar.e);
            cVar.f = jSONObject.optInt("req_to_api_cnt", cVar.f);
            cVar.g = jSONObject.optInt("req_to_ip_cnt", cVar.g);
            cVar.h = jSONObject.optInt("req_err_cnt", cVar.h);
            cVar.i = jSONObject.optInt("req_err_api_cnt", cVar.i);
            cVar.j = jSONObject.optInt("req_err_ip_cnt", cVar.j);
            cVar.k = jSONObject.optInt("update_interval", cVar.k);
            cVar.l = jSONObject.optInt("update_random_range", cVar.l);
            cVar.m = jSONObject.optString("http_code_black", cVar.m);
            return cVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        switch(r1) {
            case 55: goto L_0x000f;
            case 56: goto L_0x0026;
            case 57: goto L_0x0026;
            default: goto L_0x000e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r2 = r2.toCharArray();
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0 >= r2.length) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r2[r0] = (char) (r2[r0] ^ r0);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return new java.lang.String(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d1699434667873dc(java.lang.String r2) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            switch(r0) {
                case 72: goto L_0x0026;
                case 73: goto L_0x0008;
                case 74: goto L_0x000b;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x002b
        L_0x0008:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0026;
                case 96: goto L_0x0026;
                default: goto L_0x000b;
            }
        L_0x000b:
            switch(r1) {
                case 55: goto L_0x000f;
                case 56: goto L_0x0026;
                case 57: goto L_0x0026;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0000
        L_0x000f:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L_0x0014:
            int r1 = r2.length
            if (r0 >= r1) goto L_0x0020
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0020:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L_0x0026:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x002b:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.d.d1699434667873dc(java.lang.String):java.lang.String");
    }

    public void a() {
        if (this.c) {
            String string = this.a.getSharedPreferences(g.a().a(this.e).a(), 0).getString("tnc_config_str", (String) null);
            if (TextUtils.isEmpty(string)) {
                b.b("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                c b2 = b(new JSONObject(string));
                if (b2 != null) {
                    this.b = b2;
                }
                StringBuilder sb = new StringBuilder("loadLocalConfig: ");
                sb.append(b2 == null ? AbstractJsonLexerKt.NULL : b2.toString());
                b.b("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                b.b("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00be A[Catch:{ all -> 0x015d, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[Catch:{ all -> 0x015d, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00de A[Catch:{ all -> 0x015d, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e1 A[Catch:{ all -> 0x015d, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0127 A[SYNTHETIC, Splitter:B:55:0x0127] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r10) {
        /*
            r9 = this;
            boolean r0 = r9.c
            if (r0 != 0) goto L_0x000c
            java.lang.String r10 = "TNCConfigHandler"
            java.lang.String r0 = "handleConfigChanged: no mainProc"
            com.bytedance.sdk.component.f.d.b.b(r10, r0)
            return
        L_0x000c:
            com.bytedance.sdk.component.f.c.g r0 = com.bytedance.sdk.component.f.c.g.a()
            int r1 = r9.e
            com.bytedance.sdk.component.f.c.e r0 = r0.a(r1)
            r0.e()
            java.lang.String r0 = ""
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ttnet_url_dispatcher_enabled"
            int r3 = r10.optInt(r3, r2)     // Catch:{ all -> 0x015d }
            if (r3 <= 0) goto L_0x0027
            r3 = 1
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            java.lang.String r4 = "ttnet_dispatch_actions"
            org.json.JSONArray r4 = r10.optJSONArray(r4)     // Catch:{ all -> 0x015d }
            com.bytedance.sdk.component.f.c.g r5 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ all -> 0x015d }
            int r6 = r9.e     // Catch:{ all -> 0x015d }
            com.bytedance.sdk.component.f.c.e r5 = r5.a(r6)     // Catch:{ all -> 0x015d }
            boolean r5 = r5.c()     // Catch:{ all -> 0x015d }
            if (r5 == 0) goto L_0x00a9
            if (r3 == 0) goto L_0x00a9
            if (r4 == 0) goto L_0x00a9
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x015d }
            r3.<init>()     // Catch:{ all -> 0x015d }
            r5 = 0
        L_0x0048:
            int r6 = r4.length()     // Catch:{ all -> 0x015d }
            if (r5 >= r6) goto L_0x0076
            java.lang.Object r6 = r4.get(r5)     // Catch:{ all -> 0x015d }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ all -> 0x015d }
            java.lang.String r7 = "param"
            org.json.JSONObject r6 = r6.getJSONObject(r7)     // Catch:{ all -> 0x015d }
            java.lang.String r7 = "service_name"
            java.lang.String r8 = ""
            java.lang.String r7 = r6.optString(r7, r8)     // Catch:{ all -> 0x015d }
            java.lang.String r8 = "idc_selection"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x015d }
            if (r7 == 0) goto L_0x0073
            java.lang.String r7 = "strategy_info"
            org.json.JSONObject r6 = r6.getJSONObject(r7)     // Catch:{ all -> 0x015d }
            r3.add(r6)     // Catch:{ all -> 0x015d }
        L_0x0073:
            int r5 = r5 + 1
            goto L_0x0048
        L_0x0076:
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x015d }
            if (r4 != 0) goto L_0x00a9
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x015d }
            r4.<init>()     // Catch:{ all -> 0x015d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x015d }
        L_0x0085:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x015d }
            if (r5 == 0) goto L_0x00aa
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x015d }
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ all -> 0x015d }
            java.util.Iterator r6 = r5.keys()     // Catch:{ all -> 0x015d }
        L_0x0095:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x015d }
            if (r7 == 0) goto L_0x0085
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x015d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x015d }
            java.lang.String r8 = r5.getString(r7)     // Catch:{ all -> 0x015d }
            r4.put(r7, r8)     // Catch:{ all -> 0x015d }
            goto L_0x0095
        L_0x00a9:
            r4 = 0
        L_0x00aa:
            java.lang.String r3 = "tnc_config"
            org.json.JSONObject r10 = r10.optJSONObject(r3)     // Catch:{ all -> 0x015d }
            if (r10 != 0) goto L_0x00bc
            if (r4 != 0) goto L_0x00bc
            java.lang.String r3 = "TNCConfigHandler"
            java.lang.String r4 = " tnc host_replace_map config is null"
            com.bytedance.sdk.component.f.d.b.a(r3, r4)     // Catch:{ all -> 0x015d }
            goto L_0x00ce
        L_0x00bc:
            if (r10 != 0) goto L_0x00c9
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x015d }
            r10.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r3 = "host_replace_map"
        L_0x00c5:
            r10.put(r3, r4)     // Catch:{ all -> 0x015d }
            goto L_0x00ce
        L_0x00c9:
            if (r4 == 0) goto L_0x00ce
            java.lang.String r3 = "host_replace_map"
            goto L_0x00c5
        L_0x00ce:
            com.bytedance.sdk.component.f.c.c r3 = r9.b(r10)     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r4.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r5 = "handleConfigChanged, newConfig: "
            r4.append(r5)     // Catch:{ all -> 0x015d }
            if (r3 != 0) goto L_0x00e1
            java.lang.String r5 = "null"
            goto L_0x00e5
        L_0x00e1:
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x015d }
        L_0x00e5:
            java.lang.String r6 = "TNCConfigHandler"
            r4.append(r5)     // Catch:{ all -> 0x015d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015d }
            com.bytedance.sdk.component.f.d.b.b(r6, r4)     // Catch:{ all -> 0x015d }
            if (r3 != 0) goto L_0x0127
            java.lang.Object r4 = d
            monitor-enter(r4)
            android.content.Context r10 = r9.a     // Catch:{ all -> 0x0124 }
            com.bytedance.sdk.component.f.c.g r0 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ all -> 0x0124 }
            int r3 = r9.e     // Catch:{ all -> 0x0124 }
            com.bytedance.sdk.component.f.c.e r0 = r0.a(r3)     // Catch:{ all -> 0x0124 }
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x0124 }
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r0, r2)     // Catch:{ all -> 0x0124 }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x0124 }
            java.lang.String r0 = "tnc_config_str"
            java.lang.String r2 = ""
            android.content.SharedPreferences$Editor r10 = r10.putString(r0, r2)     // Catch:{ all -> 0x0124 }
            r10.apply()     // Catch:{ all -> 0x0124 }
            android.content.Context r10 = r9.a     // Catch:{ all -> 0x0124 }
            java.lang.String r0 = ""
            int r2 = r9.e     // Catch:{ all -> 0x0124 }
            com.bytedance.sdk.component.f.d.c.a(r10, r1, r0, r2)     // Catch:{ all -> 0x0124 }
            monitor-exit(r4)     // Catch:{ all -> 0x0124 }
            return
        L_0x0124:
            r10 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0124 }
            throw r10
        L_0x0127:
            r9.b = r3     // Catch:{ all -> 0x015d }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x015d }
            java.lang.Object r3 = d
            monitor-enter(r3)
            android.content.Context r0 = r9.a     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.f.c.g r4 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ all -> 0x015a }
            int r5 = r9.e     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.f.c.e r4 = r4.a(r5)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.a()     // Catch:{ all -> 0x015a }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r2)     // Catch:{ all -> 0x015a }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x015a }
            java.lang.String r2 = "tnc_config_str"
            android.content.SharedPreferences$Editor r0 = r0.putString(r2, r10)     // Catch:{ all -> 0x015a }
            r0.apply()     // Catch:{ all -> 0x015a }
            android.content.Context r0 = r9.a     // Catch:{ all -> 0x015a }
            int r2 = r9.e     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.f.d.c.a(r0, r1, r10, r2)     // Catch:{ all -> 0x015a }
            monitor-exit(r3)     // Catch:{ all -> 0x015a }
            goto L_0x0198
        L_0x015a:
            r10 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x015a }
            throw r10
        L_0x015d:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x019c }
            com.bytedance.sdk.component.f.c.c r10 = new com.bytedance.sdk.component.f.c.c     // Catch:{ all -> 0x019c }
            r10.<init>()     // Catch:{ all -> 0x019c }
            r9.b = r10     // Catch:{ all -> 0x019c }
            java.lang.Object r10 = d
            monitor-enter(r10)
            android.content.Context r0 = r9.a     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.c.g r3 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ all -> 0x0199 }
            int r4 = r9.e     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.c.e r3 = r3.a(r4)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.a()     // Catch:{ all -> 0x0199 }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r2)     // Catch:{ all -> 0x0199 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "tnc_config_str"
            java.lang.String r3 = ""
            android.content.SharedPreferences$Editor r0 = r0.putString(r2, r3)     // Catch:{ all -> 0x0199 }
            r0.apply()     // Catch:{ all -> 0x0199 }
            android.content.Context r0 = r9.a     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = ""
            int r3 = r9.e     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.d.c.a(r0, r1, r2, r3)     // Catch:{ all -> 0x0199 }
            monitor-exit(r10)     // Catch:{ all -> 0x0199 }
        L_0x0198:
            return
        L_0x0199:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0199 }
            throw r0
        L_0x019c:
            r10 = move-exception
            java.lang.Object r3 = d
            monitor-enter(r3)
            android.content.Context r4 = r9.a     // Catch:{ all -> 0x01ca }
            com.bytedance.sdk.component.f.c.g r5 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ all -> 0x01ca }
            int r6 = r9.e     // Catch:{ all -> 0x01ca }
            com.bytedance.sdk.component.f.c.e r5 = r5.a(r6)     // Catch:{ all -> 0x01ca }
            java.lang.String r5 = r5.a()     // Catch:{ all -> 0x01ca }
            android.content.SharedPreferences r2 = r4.getSharedPreferences(r5, r2)     // Catch:{ all -> 0x01ca }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ all -> 0x01ca }
            java.lang.String r4 = "tnc_config_str"
            android.content.SharedPreferences$Editor r2 = r2.putString(r4, r0)     // Catch:{ all -> 0x01ca }
            r2.apply()     // Catch:{ all -> 0x01ca }
            android.content.Context r2 = r9.a     // Catch:{ all -> 0x01ca }
            int r4 = r9.e     // Catch:{ all -> 0x01ca }
            com.bytedance.sdk.component.f.d.c.a(r2, r1, r0, r4)     // Catch:{ all -> 0x01ca }
            monitor-exit(r3)     // Catch:{ all -> 0x01ca }
            throw r10
        L_0x01ca:
            r10 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01ca }
            goto L_0x01ce
        L_0x01cd:
            throw r10
        L_0x01ce:
            goto L_0x01cd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.d.a(org.json.JSONObject):void");
    }

    public void b() {
        try {
            String a2 = c.a(this.a, 1, this.e);
            if (TextUtils.isEmpty(a2)) {
                b.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            c b2 = b(new JSONObject(a2));
            StringBuilder sb = new StringBuilder("loadLocalConfigForOtherProcess, config: ");
            sb.append(b2 == null ? AbstractJsonLexerKt.NULL : b2.toString());
            b.b("TNCConfigHandler", sb.toString());
            if (b2 != null) {
                this.b = b2;
            }
        } catch (Throwable th) {
            b.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public c c() {
        return this.b;
    }
}
