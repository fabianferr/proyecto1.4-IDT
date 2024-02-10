package com.mbridge.msdk.foundation.same.report.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.e;
import com.mbridge.msdk.foundation.same.f.b;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AnrMonitorManager */
public final class c {
    /* access modifiers changed from: private */
    public static long a;
    private static long b;

    public static void a() {
        if (!c()) {
            aa.a("AnrMonitorManager", "anr monitor is not available");
            return;
        }
        try {
            b.a().a(b(), new a()).start();
        } catch (Exception e) {
            aa.b("AnrMonitorManager", "start anr monitor failed", e);
        }
    }

    private static int b() {
        try {
            int a2 = ac.a().a("anr_check_timeout", 5000);
            if (a2 <= 0) {
                return 5000;
            }
            return a2;
        } catch (Exception e) {
            aa.b("AnrMonitorManager", "get anr check timeout failed", e);
            return 5000;
        }
    }

    private static boolean c() {
        try {
            return ac.a().a("anr_monitor_available", false);
        } catch (Exception e) {
            aa.b("AnrMonitorManager", "get anr monitor available failed", e);
            return false;
        }
    }

    /* compiled from: AnrMonitorManager */
    private static final class a implements a {
        public final void a(final String str, final StackTraceElement[] stackTraceElementArr) {
            if (MBridgeConstans.DEBUG) {
                aa.a("AnrMonitorManager", "onAnrHappened: " + str);
            }
            if (!c.d(str)) {
                aa.a("AnrMonitorManager", "onAnrHappened: can track false");
                return;
            }
            long unused = c.a = System.currentTimeMillis();
            b.b().execute(new Runnable() {
                public final void run() {
                    String str = str;
                    StackTraceElement[] stackTraceElementArr = stackTraceElementArr;
                    try {
                        boolean z = false;
                        if (ac.a().a("metrics", "e_t_l", ac.a().a("e_t_l", 0)) == 1) {
                            z = true;
                        }
                        if (z) {
                            c.a(str, stackTraceElementArr);
                            return;
                        }
                        new p(com.mbridge.msdk.foundation.controller.b.d().g()).a("key=m_anr_report&exception=" + c.c(str) + "&crash_first_index_from_mtg=" + c.a(stackTraceElementArr), (File) null);
                    } catch (Exception e) {
                        aa.b("AnrMonitorManager", "handler anr failed", e);
                    }
                }
            });
        }

        public final void a() {
            if (MBridgeConstans.DEBUG) {
                aa.a("AnrMonitorManager", "onNotAnrHappened");
            }
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject c(String str) throws JSONException {
        JSONObject a2 = d.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        a2.put("crashinfo", str);
        return a2;
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        return c(stackTraceElementArr) ? "1" : "0";
    }

    /* access modifiers changed from: private */
    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String next : d.b(d.b())) {
                if (!TextUtils.isEmpty(next)) {
                    if (str.contains(next)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059 A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(java.lang.StackTraceElement[] r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x007d
            int r1 = r6.length
            if (r1 != 0) goto L_0x0008
            goto L_0x007d
        L_0x0008:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0071 }
            r1.<init>()     // Catch:{ Exception -> 0x0071 }
            int r2 = r6.length     // Catch:{ Exception -> 0x0071 }
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x005f
            r4 = r6[r3]     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x005c
            java.lang.String r5 = r4.toString()     // Catch:{ Exception -> 0x0071 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0020
            goto L_0x005c
        L_0x0020:
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0071 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x002b
            goto L_0x0054
        L_0x002b:
            java.lang.String r5 = "com.android"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "com.google"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "java.lang"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "android.os"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "android.app"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r5 = 0
            goto L_0x0057
        L_0x0056:
            r5 = 1
        L_0x0057:
            if (r5 != 0) goto L_0x005c
            r1.add(r4)     // Catch:{ Exception -> 0x0071 }
        L_0x005c:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x005f:
            int r6 = r1.size()     // Catch:{ Exception -> 0x0071 }
            if (r6 != 0) goto L_0x0066
            return r0
        L_0x0066:
            java.lang.Object r6 = r1.get(r0)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0071 }
            boolean r6 = d(r6)     // Catch:{ Exception -> 0x0071 }
            return r6
        L_0x0071:
            r6 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x007d
            java.lang.String r1 = "AnrMonitorManager"
            java.lang.String r2 = "isMBridgeFirst exception"
            com.mbridge.msdk.foundation.tools.aa.b(r1, r2, r6)
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.b.c.c(java.lang.StackTraceElement[]):boolean");
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        if (!(stackTraceElementArr == null || stackTraceElementArr.length == 0)) {
            try {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\r\n");
                    }
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    static /* synthetic */ void a(String str, StackTraceElement[] stackTraceElementArr) throws JSONException {
        try {
            JSONObject c = c(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", c.toString());
            jSONObject.put("crash_first_index_from_mtg", a(stackTraceElementArr));
            e eVar = new e("m_anr_report");
            eVar.a(jSONObject);
            eVar.a(h.b());
            eVar.a(0);
            eVar.b(1);
            m.a().d().a(eVar);
        } catch (JSONException e) {
            aa.b("AnrMonitorManager", "reportANRByEventLibrary anr failed", e);
        }
    }
}
