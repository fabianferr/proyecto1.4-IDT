package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.a;
import com.mbridge.msdk.e.a.a.g;
import com.mbridge.msdk.e.d;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.v;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONObject;

/* compiled from: MetricsReportUtil */
public class m {
    private static volatile m a;
    private String b = "";
    private ConcurrentHashMap<String, Map<String, String>> c = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, c> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, String>> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, Map<String, String>>> f = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, String>> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, e>> h = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();
    private Executor j = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("mb-common-report-thread");
            return newThread;
        }
    });
    private volatile com.mbridge.msdk.e.m k;

    private b.a c(String str, String str2) {
        String str3;
        String str4;
        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.c;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str2)) {
            return null;
        }
        Map map = this.c.get(str2);
        if (map != null) {
            hashMap.putAll(map);
            str4 = (String) map.get(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            str3 = (String) map.get("adtp");
        } else {
            str4 = null;
            str3 = null;
        }
        return b(str, str2, "", str4, str3, hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.same.report.b.a b(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.Map<java.lang.String, java.lang.String> r20) {
        /*
            r14 = this;
            r1 = r14
            r0 = r15
            r2 = r16
            r3 = r20
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r4 = r4.g()
            boolean r5 = android.text.TextUtils.isEmpty(r15)
            r6 = 0
            if (r5 != 0) goto L_0x00db
            if (r4 != 0) goto L_0x0019
            goto L_0x00db
        L_0x0019:
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r5 = r5.h()     // Catch:{ Exception -> 0x00cc }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x00cc }
            r7.<init>()     // Catch:{ Exception -> 0x00cc }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r10 = "ts"
            java.lang.String r11 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00cc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x00cc }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x00cc }
            r10.<init>()     // Catch:{ Exception -> 0x00cc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r11 = r1.e     // Catch:{ Exception -> 0x00cc }
            if (r11 == 0) goto L_0x0043
            java.lang.Object r10 = r11.get(r2)     // Catch:{ Exception -> 0x00cc }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x00cc }
        L_0x0043:
            if (r10 == 0) goto L_0x004b
            int r11 = r10.size()     // Catch:{ Exception -> 0x00cc }
            if (r11 != 0) goto L_0x0055
        L_0x004b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r11 = r1.g     // Catch:{ Exception -> 0x00cc }
            if (r11 == 0) goto L_0x0055
            java.lang.Object r10 = r11.get(r2)     // Catch:{ Exception -> 0x00cc }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x00cc }
        L_0x0055:
            java.lang.String r11 = ""
            java.lang.String r12 = "lrid"
            if (r10 == 0) goto L_0x006e
            int r13 = r10.size()     // Catch:{ Exception -> 0x00cc }
            if (r13 <= 0) goto L_0x006e
            boolean r13 = r10.containsKey(r12)     // Catch:{ Exception -> 0x00cc }
            if (r13 == 0) goto L_0x006e
            java.lang.Object r10 = r10.get(r12)     // Catch:{ Exception -> 0x00cc }
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x00cc }
        L_0x006e:
            boolean r10 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x00cc }
            if (r10 == 0) goto L_0x007a
            r7.put(r12, r2)     // Catch:{ Exception -> 0x00cc }
        L_0x0077:
            r2 = r17
            goto L_0x0093
        L_0x007a:
            java.lang.String r10 = "2000125"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x00cc }
            if (r10 != 0) goto L_0x008f
            java.lang.String r10 = "2000126"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x00cc }
            if (r10 == 0) goto L_0x008b
            goto L_0x008f
        L_0x008b:
            r7.put(r12, r11)     // Catch:{ Exception -> 0x00cc }
            goto L_0x0077
        L_0x008f:
            r7.put(r12, r2)     // Catch:{ Exception -> 0x00cc }
            goto L_0x0077
        L_0x0093:
            com.mbridge.msdk.foundation.same.report.b$a r2 = com.mbridge.msdk.foundation.same.report.b.a(r15, r2)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r2 = r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x00cc }
            r4 = r18
            com.mbridge.msdk.foundation.same.report.b$a r2 = r2.d((java.lang.String) r4)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r2 = r2.b((java.lang.String) r5)     // Catch:{ Exception -> 0x00cc }
            r4 = r19
            com.mbridge.msdk.foundation.same.report.b$a r2 = r2.e((java.lang.String) r4)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r2.a((java.lang.String) r15)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = r1.b     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r0.c((java.lang.String) r2)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r0.b((long) r8)     // Catch:{ Exception -> 0x00cc }
            java.util.concurrent.Executor r2 = r1.j     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r0.a((java.util.concurrent.Executor) r2)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r7)     // Catch:{ Exception -> 0x00cc }
            com.mbridge.msdk.foundation.same.report.b$a r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x00cc }
            if (r0 != 0) goto L_0x00ca
            return r6
        L_0x00ca:
            r6 = r0
            goto L_0x00d6
        L_0x00cc:
            r0 = move-exception
            java.lang.String r2 = "MetricsReportUtil"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r2, (java.lang.String) r0)
        L_0x00d6:
            if (r6 == 0) goto L_0x00db
            r6.a((java.util.Map<java.lang.String, java.lang.String>) r3)
        L_0x00db:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.m.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.mbridge.msdk.foundation.same.report.b$a");
    }

    private void a(String str, String str2, Map<String, String> map, boolean z) {
        a(str, str2, map, z, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[SYNTHETIC, Splitter:B:22:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054 A[SYNTHETIC, Splitter:B:28:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009a A[SYNTHETIC, Splitter:B:42:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00dc A[Catch:{ Exception -> 0x01e0 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dd A[Catch:{ Exception -> 0x01e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, boolean r12, int r13) {
        /*
            r8 = this;
            java.lang.String r0 = "2000047"
            java.lang.String r1 = "bid_tk"
            java.lang.String r2 = "2000126"
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L_0x0010
            r8.b((java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            return
        L_0x0010:
            if (r11 != 0) goto L_0x0017
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
        L_0x0017:
            r3 = 1
            if (r13 == r3) goto L_0x002d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r13 = r8.g     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0040
            boolean r13 = r13.containsKey(r10)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0040
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r13 = r8.g     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r13 = r13.get(r10)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x01e0 }
            goto L_0x0041
        L_0x002d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r13 = r8.e     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0040
            boolean r13 = r13.containsKey(r10)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0040
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r13 = r8.e     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r13 = r13.get(r10)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x01e0 }
            goto L_0x0041
        L_0x0040:
            r13 = 0
        L_0x0041:
            java.lang.String r4 = "2000125"
            if (r13 == 0) goto L_0x004e
            boolean r5 = r9.equals(r4)     // Catch:{ Exception -> 0x01e0 }
            if (r5 != 0) goto L_0x004e
            r11.putAll(r13)     // Catch:{ Exception -> 0x01e0 }
        L_0x004e:
            boolean r13 = r9.equals(r2)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x008e
            boolean r13 = r11.containsKey(r1)     // Catch:{ Exception -> 0x008a }
            java.lang.String r5 = ""
            if (r13 == 0) goto L_0x0063
            java.lang.Object r13 = r11.get(r1)     // Catch:{ Exception -> 0x008a }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x008a }
            goto L_0x0064
        L_0x0063:
            r13 = r5
        L_0x0064:
            java.lang.String r13 = com.mbridge.msdk.foundation.same.net.g.a(r13)     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = "dns_ty"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008a }
            r6.<init>()     // Catch:{ Exception -> 0x008a }
            com.mbridge.msdk.c.c r7 = com.mbridge.msdk.c.c.a()     // Catch:{ Exception -> 0x008a }
            int r7 = r7.e(r13)     // Catch:{ Exception -> 0x008a }
            r6.append(r7)     // Catch:{ Exception -> 0x008a }
            r6.append(r5)     // Catch:{ Exception -> 0x008a }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x008a }
            r11.put(r1, r5)     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = "dns_hs"
            r11.put(r1, r13)     // Catch:{ Exception -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r13 = move-exception
            r13.printStackTrace()     // Catch:{ Exception -> 0x01e0 }
        L_0x008e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>>> r13 = r8.f     // Catch:{ Exception -> 0x01e0 }
            boolean r13 = r13.containsKey(r10)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r1 = "2000048"
            java.lang.String r5 = "2000127"
            if (r13 == 0) goto L_0x00d6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>>> r13 = r8.f     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r13 = r13.get(r10)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x00d6
            boolean r6 = r13.containsKey(r5)     // Catch:{ Exception -> 0x01e0 }
            if (r6 != 0) goto L_0x00b8
            boolean r6 = r13.containsKey(r1)     // Catch:{ Exception -> 0x01e0 }
            if (r6 != 0) goto L_0x00b8
            java.lang.String r6 = "2000152"
            boolean r6 = r13.containsKey(r6)     // Catch:{ Exception -> 0x01e0 }
            if (r6 == 0) goto L_0x00c3
        L_0x00b8:
            java.lang.Object r6 = r13.get(r9)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x01e0 }
            if (r6 == 0) goto L_0x00c3
            r11.putAll(r6)     // Catch:{ Exception -> 0x01e0 }
        L_0x00c3:
            java.lang.String r6 = "0"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x00d6
            boolean r6 = r13.isEmpty()     // Catch:{ Exception -> 0x01e0 }
            if (r6 != 0) goto L_0x00d6
            r11.putAll(r13)     // Catch:{ Exception -> 0x01e0 }
        L_0x00d6:
            com.mbridge.msdk.foundation.same.report.b$a r13 = r8.c(r9, r10)     // Catch:{ Exception -> 0x01e0 }
            if (r13 != 0) goto L_0x00dd
            return
        L_0x00dd:
            r13.a((java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ Exception -> 0x01e0 }
            boolean r11 = r9.equals(r5)     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x0106
            java.lang.String r11 = "2000128"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x0106
            java.lang.String r11 = "2000129"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x0106
            java.lang.String r11 = "2000130"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x0106
            java.lang.String r11 = "2000137"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x01e0 }
            if (r11 == 0) goto L_0x011d
        L_0x0106:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r11 = r8.e     // Catch:{ Exception -> 0x01e0 }
            boolean r11 = r11.containsKey(r10)     // Catch:{ Exception -> 0x01e0 }
            if (r11 == 0) goto L_0x011d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r11 = r8.e     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ Exception -> 0x01e0 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x011d
            if (r11 == 0) goto L_0x011d
            r13.a((java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ Exception -> 0x01e0 }
        L_0x011d:
            r13.b((boolean) r12)     // Catch:{ Exception -> 0x01e0 }
            boolean r11 = r9.equals(r0)     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x012c
            boolean r11 = r9.equals(r1)     // Catch:{ Exception -> 0x01e0 }
            if (r11 == 0) goto L_0x012f
        L_0x012c:
            r13.a((boolean) r3)     // Catch:{ Exception -> 0x01e0 }
        L_0x012f:
            com.mbridge.msdk.foundation.same.report.b r11 = r13.a()     // Catch:{ Exception -> 0x01e0 }
            if (r11 != 0) goto L_0x0136
            return
        L_0x0136:
            boolean r12 = r9.equals(r5)     // Catch:{ Exception -> 0x01e0 }
            if (r12 == 0) goto L_0x013f
            r8.a((java.lang.String) r10, (com.mbridge.msdk.foundation.same.report.b) r11)     // Catch:{ Exception -> 0x01e0 }
        L_0x013f:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.report.c> r12 = r8.d     // Catch:{ Exception -> 0x01e0 }
            if (r12 == 0) goto L_0x01d1
            boolean r12 = r12.containsKey(r10)     // Catch:{ Exception -> 0x01e0 }
            if (r12 == 0) goto L_0x01d1
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.report.c> r12 = r8.d     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r12 = r12.get(r10)     // Catch:{ Exception -> 0x01e0 }
            com.mbridge.msdk.foundation.same.report.c r12 = (com.mbridge.msdk.foundation.same.report.c) r12     // Catch:{ Exception -> 0x01e0 }
            if (r12 == 0) goto L_0x01d4
            boolean r13 = r9.equals(r4)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r6 = "2000123"
            r7 = 0
            if (r13 == 0) goto L_0x0165
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r6, r7, r7)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x0165:
            boolean r13 = r9.equals(r2)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0173
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r4, r7, r3)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x0173:
            boolean r13 = r9.equals(r5)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x0181
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r6, r7, r7)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x0181:
            java.lang.String r13 = "2000133"
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r2 = "2000154"
            if (r13 == 0) goto L_0x0193
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r2, r7, r3)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x0193:
            boolean r13 = r9.equals(r0)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x01a1
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r6, r7, r3)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x01a1:
            boolean r13 = r9.equals(r1)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x01af
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r6, r7, r3)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x01af:
            boolean r13 = r9.equals(r2)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x01bd
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r5, r7, r7)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x01bd:
            java.lang.String r13 = "2000155"
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x01e0 }
            if (r13 == 0) goto L_0x01cd
            com.mbridge.msdk.foundation.same.report.b r11 = r12.a(r11, r2, r7, r3)     // Catch:{ Exception -> 0x01e0 }
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x01cd:
            r11.b()     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01d4
        L_0x01d1:
            r11.b()     // Catch:{ Exception -> 0x01e0 }
        L_0x01d4:
            java.lang.String r11 = "2000151"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x01e0 }
            if (r9 == 0) goto L_0x01ea
            r8.b((java.lang.String) r10)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01ea
        L_0x01e0:
            r9 = move-exception
            java.lang.String r10 = "MetricsReportUtil"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r10, (java.lang.String) r9)
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.m.a(java.lang.String, java.lang.String, java.util.Map, boolean, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[Catch:{ Exception -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "unit_id"
            if (r10 == 0) goto L_0x0045
            boolean r1 = r10.containsKey(r0)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r10.get(r0)     // Catch:{ Exception -> 0x0041 }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x002e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = r8.i     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x002e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = r8.i     // Catch:{ Exception -> 0x0041 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0041 }
            r6 = r1
            goto L_0x002f
        L_0x002e:
            r6 = r2
        L_0x002f:
            boolean r1 = r8.d(r6, r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x0045
            r10.remove(r0)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = ""
            r2 = r8
            r3 = r9
            r7 = r10
            r2.b(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.m.b(java.lang.String, java.util.Map):void");
    }

    private boolean a(String str) {
        String str2;
        try {
            ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.c;
            if (concurrentHashMap == null) {
                return false;
            }
            if (!concurrentHashMap.containsKey(str)) {
                return false;
            }
            Map map = this.c.get(str);
            if (map != null) {
                str2 = (String) map.get("adtp");
                return d(str2, "");
            }
            str2 = "";
            return d(str2, "");
        } catch (Exception e2) {
            aa.d("MetricsReportUtil", e2.getMessage());
        }
    }

    private boolean d(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && (str2.equals("bid") || str2.equals("buyer_id") || str2.equals("roas") || str2.equals("InitSDK") || str2.equals("CronetEnv"))) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt == 94 || parseInt == 279 || parseInt == 287 || parseInt == 288 || parseInt == 295) {
                return ac.a().a("r_l_b_m_t_r_i", true);
            }
            if (parseInt != 296) {
                return false;
            }
            return ac.a().a("r_l_b_m_t_b", false);
        } catch (Exception e2) {
            aa.d("MetricsReportUtil", e2.getMessage());
            return false;
        }
    }

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
        hashMap.put("adtp", str3);
        hashMap.put(CampaignEx.JSON_KEY_HB, str4);
        hashMap.put("bid_tk", str5);
        if (this.c == null) {
            this.c = new ConcurrentHashMap<>();
        }
        this.c.put(str, hashMap);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Map map2;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        ConcurrentHashMap<String, String> concurrentHashMap = this.i;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str9, str10);
        }
        if (TextUtils.isEmpty(str2)) {
            b(str, str3, str4, str5, map);
        } else if (d(str10, str8)) {
            HashMap hashMap = map == null ? new HashMap() : map;
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str9);
                hashMap2.put("adtp", str10);
                if (hashMap != null) {
                    if (!hashMap.containsKey(CampaignEx.JSON_KEY_HB) || hashMap.get(CampaignEx.JSON_KEY_HB) == null) {
                        hashMap2.put(CampaignEx.JSON_KEY_HB, "0");
                    } else {
                        hashMap2.put(CampaignEx.JSON_KEY_HB, hashMap.get(CampaignEx.JSON_KEY_HB));
                    }
                    if (hashMap.containsKey("bid_tk") && hashMap.get("bid_tk") != null) {
                        hashMap2.put("bid_tk", hashMap.get("bid_tk"));
                    }
                }
                this.c.put(str2, hashMap2);
                b.a b2 = b(str, str2, str3, str4, str5, hashMap);
                if (b2 == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.g;
                    if (!(concurrentHashMap2 == null || concurrentHashMap2.size() <= 0 || !this.g.containsKey(str2) || hashMap == null || (map2 = this.g.get(str2)) == null)) {
                        hashMap.putAll(map2);
                    }
                    if (hashMap != null && hashMap.size() > 0) {
                        b2.a(hashMap);
                    }
                    if (str.equals("2000123")) {
                        b2.a(true);
                    }
                    b a2 = b2.a();
                    if (a2 != null) {
                        if (str.equals("2000123") && !TextUtils.isEmpty(str3)) {
                            a(str2, a2);
                            if (str8.equals("auto_load") || str8.equals("self_load")) {
                                return;
                            }
                        }
                        a2.b();
                    }
                }
            } catch (Exception e2) {
                aa.a("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
        if (!TextUtils.isEmpty(str) && g2 != null) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Exception e2) {
                    aa.a("MetricsReportUtil", e2.getMessage());
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            map.put("ts", String.valueOf(currentTimeMillis));
            b.a a2 = b.a(str, str2).a(g2).d(str3).b(com.mbridge.msdk.foundation.controller.b.d().h()).e(str4).a(false).b(currentTimeMillis).a(this.j);
            if (a2 != null) {
                a2.a(map);
                b a3 = a2.a();
                if (a3 != null) {
                    a3.b();
                }
            }
        }
    }

    public final void b(String str, String str2, String str3, String str4, Map<String, String> map) {
        Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
        if (!TextUtils.isEmpty(str) && g2 != null && d(str4, str2)) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Exception e2) {
                    aa.a("MetricsReportUtil", e2.getMessage());
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            map.put("ts", String.valueOf(currentTimeMillis));
            b.a a2 = b.a(str, str2).a(g2).d(str3).b(com.mbridge.msdk.foundation.controller.b.d().h()).e(str4).a(false).b(currentTimeMillis).a(this.j);
            if (a2 != null) {
                a2.a(map);
                b a3 = a2.a();
                if (a3 != null) {
                    a3.b();
                }
            }
        }
    }

    public final void a(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            b(str, map);
        } else if (a(str2)) {
            a(str, str2, map, false);
        }
    }

    public final void a(String str, List<CampaignEx> list, Map<String, String> map) {
        CampaignEx campaignEx;
        if (list != null && list.size() != 0 && (campaignEx = list.get(0)) != null) {
            if (d(campaignEx.getAdType() + "", "")) {
                try {
                    Map<String, String> a2 = a(list);
                    if (list.size() > 1) {
                        this.e.put(campaignEx.getCurrentLRid(), a2);
                    } else {
                        this.g.put(campaignEx.getCurrentLRid(), a2);
                    }
                    if (a2 != null) {
                        map.putAll(a2);
                    }
                    if (TextUtils.isEmpty(campaignEx.getCurrentLRid())) {
                        String campaignUnitId = campaignEx.getCampaignUnitId();
                        b(str, "", campaignUnitId, campaignEx.getAdType() + "", map);
                        return;
                    }
                    a(str, campaignEx.getCurrentLRid(), map, false, 1);
                } catch (Exception e2) {
                    aa.a("MetricsReportUtil", e2.getMessage());
                }
            }
        }
    }

    public final void a(String str, CampaignEx campaignEx, Map<String, String> map) {
        if (campaignEx != null) {
            if (d(campaignEx.getAdType() + "", "")) {
                if (map != null) {
                    try {
                        if (map.containsKey("update")) {
                            a(campaignEx);
                            map.remove("update");
                        }
                    } catch (Exception e2) {
                        aa.a("MetricsReportUtil", e2.getMessage());
                        return;
                    }
                }
                if (TextUtils.isEmpty(campaignEx.getCurrentLRid())) {
                    String campaignUnitId = campaignEx.getCampaignUnitId();
                    b(str, "", campaignUnitId, campaignEx.getAdType() + "", map);
                    return;
                }
                a(str, campaignEx.getCurrentLRid(), map, false);
            }
        }
    }

    public final void b(String str, String str2, Map<String, String> map) {
        try {
            if (TextUtils.isEmpty(str2)) {
                b(str, map);
            } else if (a(str2)) {
                a(str, str2, map, false, 1);
            }
        } catch (Exception e2) {
            aa.d("MetricsReportUtil", e2.getMessage());
        }
    }

    public final void a(String str, MBridgeIds mBridgeIds, Map<String, String> map) {
        if (mBridgeIds == null || TextUtils.isEmpty(mBridgeIds.getLocalRequestId())) {
            b(str, map);
        } else if (a(mBridgeIds.getLocalRequestId())) {
            a(str, mBridgeIds.getLocalRequestId(), map, false);
        }
    }

    public final Map<String, String> a(List<CampaignEx> list) {
        String str = CampaignEx.JSON_KEY_EC_TEMP_ID;
        String str2 = "endcard_crid";
        String str3 = "video_crid";
        String str4 = "vtid";
        String str5 = "crid";
        HashMap hashMap = new HashMap();
        try {
            for (CampaignEx next : list) {
                if (next != null) {
                    hashMap.put("rid", next.getRequestId() + "");
                    if (next.getMof_tplid() != 0) {
                        hashMap.put("stid", next.getMof_tplid() + "");
                    }
                    CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                    if (rewardTemplateMode != null) {
                        if (rewardTemplateMode.b() != 0) {
                            if (hashMap.containsKey(str4)) {
                                hashMap.put(str4, ((String) hashMap.get(str4)) + "," + rewardTemplateMode.b());
                            } else {
                                hashMap.put(str4, rewardTemplateMode.b() + "");
                            }
                        }
                    }
                    if (next.getCreativeId() != 0) {
                        if (hashMap.containsKey(str5)) {
                            hashMap.put(str5, ((String) hashMap.get(str5)) + "," + next.getCreativeId());
                        } else {
                            hashMap.put(str5, next.getCreativeId() + "");
                        }
                    }
                    if (next.getVidCrtvId() != 0) {
                        if (hashMap.containsKey(str3)) {
                            hashMap.put(str3, ((String) hashMap.get(str3)) + "," + next.getVidCrtvId());
                        } else {
                            hashMap.put(str3, next.getVidCrtvId() + "");
                        }
                    }
                    if (next.getEcCrtvId() != 0) {
                        if (hashMap.containsKey(str2)) {
                            hashMap.put(str2, ((String) hashMap.get(str2)) + "," + next.getEcCrtvId());
                        } else {
                            hashMap.put(str2, next.getEcCrtvId() + "");
                        }
                    }
                    if (next.getEcTemplateId() != 0) {
                        if (hashMap.containsKey(str)) {
                            hashMap.put(str, ((String) hashMap.get(str)) + "," + next.getEcTemplateId());
                        } else {
                            hashMap.put(str, next.getEcTemplateId() + "");
                        }
                    }
                    String str6 = str;
                    String str7 = str2;
                    String str8 = "1";
                    String str9 = str3;
                    String str10 = str4;
                    String str11 = str5;
                    if (next.isDynamicView()) {
                        if (!TextUtils.isEmpty(next.getMof_template_url())) {
                            hashMap.put("sdyv", str8);
                        }
                        if (hashMap.containsKey("vdyv")) {
                            hashMap.put("vdyv", ((String) hashMap.get("vdyv")) + ",1");
                        } else {
                            hashMap.put("vdyv", str8);
                        }
                        boolean j2 = af.j(next.getendcard_url());
                        if (hashMap.containsKey("edyv")) {
                            if (j2) {
                                hashMap.put("edyv", ((String) hashMap.get("edyv")) + ",2");
                            } else {
                                hashMap.put("edyv", ((String) hashMap.get("edyv")) + ",1");
                            }
                        } else if (j2) {
                            hashMap.put("edyv", "2");
                        } else {
                            hashMap.put("edyv", str8);
                        }
                    } else {
                        if (!TextUtils.isEmpty(next.getMof_template_url())) {
                            hashMap.put("sdyv", "2");
                        }
                        if (hashMap.containsKey("vdyv")) {
                            hashMap.put("vdyv", ((String) hashMap.get("vdyv")) + ",2");
                        } else {
                            hashMap.put("vdyv", "2");
                        }
                        if (hashMap.containsKey("edyv")) {
                            hashMap.put("edyv", ((String) hashMap.get("edyv")) + ",2");
                        } else {
                            hashMap.put("edyv", "2");
                        }
                    }
                    if (!TextUtils.isEmpty(next.getExt_data())) {
                        JSONObject jSONObject = new JSONObject(next.getExt_data());
                        if (hashMap.containsKey("dspid")) {
                            hashMap.put("dspid", ((String) hashMap.get("dspid")) + "," + jSONObject.optString("par_dspid"));
                        } else {
                            hashMap.put("dspid", jSONObject.optString("par_dspid"));
                        }
                    }
                    if (next.getPlayable_ads_without_video() == 2) {
                        if (hashMap.containsKey("only_ec")) {
                            hashMap.put("only_ec", ((String) hashMap.get("only_ec")) + ",2");
                        } else {
                            hashMap.put("only_ec", "2");
                        }
                    } else if (hashMap.containsKey("only_ec")) {
                        hashMap.put("only_ec", ((String) hashMap.get("only_ec")) + ",1");
                    } else {
                        hashMap.put("only_ec", str8);
                    }
                    if (!TextUtils.isEmpty(next.getExpIds())) {
                        hashMap.put(CampaignEx.URL_KEY_EXP_IDS, next.getExpIds());
                    }
                    if (hashMap.containsKey(CmcdConfiguration.KEY_CONTENT_ID)) {
                        hashMap.put(CmcdConfiguration.KEY_CONTENT_ID, ((String) hashMap.get(CmcdConfiguration.KEY_CONTENT_ID)) + "," + next.getId());
                    } else {
                        hashMap.put(CmcdConfiguration.KEY_CONTENT_ID, next.getId());
                    }
                    if (hashMap.containsKey("rid_n")) {
                        hashMap.put("rid_n", ((String) hashMap.get("rid_n")) + "," + next.getRequestIdNotice());
                    } else {
                        hashMap.put("rid_n", next.getRequestIdNotice());
                    }
                    hashMap.put("bid_tk", next.getBidToken() + "");
                    if (!next.isBidCampaign()) {
                        str8 = "0";
                    }
                    hashMap.put(CampaignEx.JSON_KEY_HB, str8);
                    hashMap.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, next.getAdSpaceT() + "");
                    hashMap.put("n_rid", next.getNRid());
                    hashMap.put("n_lrid", next.getNLRid());
                    hashMap.put("lrid", next.getLocalRequestId());
                    if (com.mbridge.msdk.foundation.controller.b.c != null) {
                        String str12 = com.mbridge.msdk.foundation.controller.b.c.get(next.getCampaignUnitId());
                        if (!TextUtils.isEmpty(str12)) {
                            hashMap.put("u_stid", str12);
                        }
                    }
                    str = str6;
                    str2 = str7;
                    str3 = str9;
                    str4 = str10;
                    str5 = str11;
                }
            }
        } catch (Exception e2) {
            aa.a("MetricsReportUtil", e2.getMessage());
        }
        return hashMap;
    }

    public final void a(String str, Map<String, String> map) {
        if (map != null && map.containsKey("r_stid")) {
            this.b = map.get("r_stid");
            map.remove("r_stid");
        }
        c(str, "0", map);
    }

    public final void c(String str, String str2, Map<String, String> map) {
        Map map2;
        if (a(str) && !TextUtils.isEmpty(str)) {
            try {
                ConcurrentHashMap<String, Map<String, Map<String, String>>> concurrentHashMap = this.f;
                if (concurrentHashMap != null) {
                    if (concurrentHashMap.containsKey(str)) {
                        map2 = this.f.get(str);
                        if (map2 == null) {
                            map2 = new HashMap();
                        }
                    } else {
                        map2 = new HashMap();
                    }
                    map2.put(str2, map);
                    this.f.put(str, map2);
                }
            } catch (Exception e2) {
                aa.a("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        Map map;
        if (campaignEx != null) {
            try {
                b(campaignEx);
                if (d(campaignEx.getAdType() + "", "")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(campaignEx);
                    Map<String, String> a2 = a((List<CampaignEx>) arrayList);
                    if (!this.g.containsKey(campaignEx.getCurrentLRid()) || (map = this.g.get(campaignEx.getCurrentLRid())) == null || map.size() <= 0) {
                        this.g.put(campaignEx.getCurrentLRid(), a2);
                        return;
                    }
                    map.putAll(a2);
                    this.g.put(campaignEx.getCurrentLRid(), map);
                }
            } catch (Exception e2) {
                aa.d("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    public final void b(List<CampaignEx> list) {
        Map map;
        if (list != null && list.size() != 0) {
            try {
                CampaignEx campaignEx = list.get(0);
                String currentLRid = campaignEx != null ? campaignEx.getCurrentLRid() : "";
                b(campaignEx);
                if (a(currentLRid)) {
                    Map<String, String> a2 = a(list);
                    if (!this.e.containsKey(currentLRid) || (map = this.e.get(currentLRid)) == null || map.size() <= 0) {
                        this.e.put(currentLRid, a2);
                        return;
                    }
                    map.putAll(a2);
                    this.e.put(currentLRid, map);
                }
            } catch (Exception e2) {
                aa.d("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getCurrentLRid())) {
                    ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.c;
                    if (concurrentHashMap != null && !concurrentHashMap.containsKey(campaignEx.getCurrentLRid())) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
                        hashMap.put("adtp", campaignEx.getAdType() + "");
                        hashMap.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? "1" : "0");
                        if (!TextUtils.isEmpty(campaignEx.getBidToken())) {
                            hashMap.put("bid_tk", campaignEx.getBidToken());
                        }
                        this.c.put(campaignEx.getCurrentLRid(), hashMap);
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(n nVar, CampaignEx campaignEx) {
        b a2;
        if (nVar != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_RESULT, nVar.D() + "");
                String str = "0";
                if (!TextUtils.isEmpty(nVar.y())) {
                    if (!nVar.y().equals(str)) {
                        hashMap.put("duration", nVar.y() + "");
                    }
                }
                if (!TextUtils.isEmpty(nVar.n())) {
                    hashMap.put("rus_rid", nVar.n() + "");
                }
                if (!TextUtils.isEmpty(nVar.m())) {
                    hashMap.put("rs_rid", nVar.m() + "");
                }
                hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, nVar.x() + "");
                hashMap.put(CampaignEx.ENDCARD_URL, nVar.g());
                hashMap.put("network_type", nVar.A() + "");
                hashMap.put("network_str", nVar.B());
                hashMap.put("rid_n", nVar.q());
                hashMap.put(CmcdConfiguration.KEY_CONTENT_ID, nVar.s() + "");
                if (nVar.t().equals("2000022")) {
                    hashMap.put(CampaignEx.JSON_KEY_IMAGE_URL, nVar.e());
                    hashMap.put("template_url", nVar.j());
                    hashMap.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, nVar.v() + "");
                    hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, nVar.z() + "");
                    hashMap.put(CampaignEx.JSON_KEY_VIDEO_URL, nVar.f());
                } else if (nVar.t().equals("2000043")) {
                    hashMap.put("mraid_type", nVar.k() + "");
                    hashMap.put("type", nVar.h() + "");
                } else if (nVar.t().equals("2000045")) {
                    hashMap.put("type", nVar.d() + "");
                    if (nVar.d() == 1 || nVar.d() == 2) {
                        hashMap.remove("duration");
                    }
                }
                if (!TextUtils.isEmpty(nVar.o())) {
                    hashMap.put("response_header_info", URLEncoder.encode(nVar.o(), "utf-8"));
                }
                String t = nVar.t();
                try {
                    String currentLRid = campaignEx.getCurrentLRid();
                    String campaignUnitId = campaignEx.getCampaignUnitId();
                    int adType = campaignEx.getAdType();
                    if (campaignEx.isBidCampaign()) {
                        str = "1";
                    }
                    hashMap.put(CampaignEx.JSON_KEY_HB, str);
                    hashMap.put("bid_tk", campaignEx.getBidToken());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(campaignEx);
                    Map<String, String> a3 = a((List<CampaignEx>) arrayList);
                    if (a3 != null) {
                        hashMap.putAll(a3);
                    }
                    b.a b2 = b(t, currentLRid, "", campaignUnitId, adType + "", hashMap);
                    if (b2 != null && (a2 = b2.a()) != null) {
                        a2.b();
                    }
                } catch (Exception e2) {
                    aa.d("MetricsReportUtil", e2.getMessage());
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final e a(String str, String str2) {
        Map map;
        if (TextUtils.isEmpty(str)) {
            str = "unknown_unit_id";
        }
        ConcurrentHashMap<String, Map<String, e>> concurrentHashMap = this.h;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str) || (map = this.h.get(str)) == null || !map.containsKey(str2)) {
            return null;
        }
        return (e) map.get(str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0405, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0406, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0179, code lost:
        r8 = r7.h.get(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03dd A[Catch:{ Exception -> 0x04b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r22, java.lang.String r23, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r24, java.lang.String r25, java.lang.String r26) {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r1 = r24
            r2 = r26
            java.lang.String r8 = "MetricsReportUtil"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r5 = "reason"
            java.lang.String r6 = "type"
            java.lang.String r9 = "cid"
            java.lang.String r10 = ""
            if (r1 == 0) goto L_0x0145
            java.util.Iterator r11 = r24.iterator()
        L_0x001e:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0145
            java.lang.Object r12 = r11.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = (com.mbridge.msdk.foundation.entity.CampaignEx) r12
            if (r12 != 0) goto L_0x002d
            goto L_0x001e
        L_0x002d:
            java.lang.Object r13 = r3.get(r9)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r14 = ","
            if (r13 == 0) goto L_0x0043
            java.lang.String r13 = r12.getId()
            r3.put(r9, r13)
            goto L_0x0062
        L_0x0043:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.Object r15 = r3.get(r9)
            java.lang.String r15 = (java.lang.String) r15
            r13.append(r15)
            r13.append(r14)
            java.lang.String r15 = r12.getId()
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r3.put(r9, r13)
        L_0x0062:
            java.lang.String r13 = "rtins_type"
            java.lang.Object r15 = r3.get(r13)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0087
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            int r4 = r12.getRtinsType()
            r15.append(r4)
            r15.append(r10)
            java.lang.String r4 = r15.toString()
            r3.put(r13, r4)
            goto L_0x00a6
        L_0x0087:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Object r15 = r3.get(r13)
            java.lang.String r15 = (java.lang.String) r15
            r4.append(r15)
            r4.append(r14)
            int r15 = r12.getRtinsType()
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            r3.put(r13, r4)
        L_0x00a6:
            java.lang.String r4 = "rid_n"
            java.lang.Object r13 = r3.get(r4)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x00bc
            java.lang.String r13 = r12.getRequestIdNotice()
            r3.put(r4, r13)
            goto L_0x00db
        L_0x00bc:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.Object r15 = r3.get(r4)
            java.lang.String r15 = (java.lang.String) r15
            r13.append(r15)
            r13.append(r14)
            java.lang.String r15 = r12.getRequestIdNotice()
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r3.put(r4, r13)
        L_0x00db:
            java.lang.String r4 = "video_size"
            java.lang.Object r13 = r3.get(r4)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0101
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r12.getVideoSize()
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            r3.put(r4, r13)
            goto L_0x0120
        L_0x0101:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.Object r15 = r3.get(r4)
            java.lang.String r15 = (java.lang.String) r15
            r13.append(r15)
            r13.append(r14)
            int r14 = r12.getVideoSize()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r3.put(r4, r13)
        L_0x0120:
            int r4 = r12.getErrTypeByDefaultAd()
            r13 = -1
            if (r4 == r13) goto L_0x0132
            int r4 = r12.getErrTypeByDefaultAd()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.put(r6, r4)
        L_0x0132:
            java.lang.String r4 = r12.getErrReasonByDefaultAd()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x001e
            java.lang.String r4 = r12.getErrReasonByDefaultAd()
            r3.put(r5, r4)
            goto L_0x001e
        L_0x0145:
            java.lang.String r4 = "2000047"
            boolean r4 = r4.equals(r0)     // Catch:{ Exception -> 0x04b6 }
            java.lang.String r11 = "dyview"
            java.lang.String r12 = "0"
            java.lang.String r14 = "unit_id"
            java.lang.String r15 = "network_type"
            java.lang.String r16 = "1"
            java.lang.String r13 = "hb"
            r17 = r12
            r18 = 0
            if (r4 == 0) goto L_0x040b
            boolean r4 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x04b6 }
            java.lang.String r12 = "unknown_unit_id"
            if (r4 == 0) goto L_0x016b
            r19 = r8
            r4 = r12
            goto L_0x016f
        L_0x016b:
            r4 = r25
            r19 = r8
        L_0x016f:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.e>> r8 = r7.h     // Catch:{ Exception -> 0x0405 }
            if (r8 == 0) goto L_0x0191
            boolean r8 = r8.containsKey(r4)     // Catch:{ Exception -> 0x0405 }
            if (r8 == 0) goto L_0x0191
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.e>> r8 = r7.h     // Catch:{ Exception -> 0x0405 }
            java.lang.Object r8 = r8.get(r4)     // Catch:{ Exception -> 0x0405 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x0405 }
            if (r8 == 0) goto L_0x0191
            boolean r20 = r8.containsKey(r2)     // Catch:{ Exception -> 0x0405 }
            if (r20 == 0) goto L_0x0191
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0405 }
            com.mbridge.msdk.foundation.entity.e r2 = (com.mbridge.msdk.foundation.entity.e) r2     // Catch:{ Exception -> 0x0405 }
            r8 = r2
            goto L_0x0193
        L_0x0191:
            r8 = r18
        L_0x0193:
            boolean r2 = r12.equals(r4)     // Catch:{ Exception -> 0x0405 }
            if (r2 == 0) goto L_0x019b
            r12 = r10
            goto L_0x019c
        L_0x019b:
            r12 = r4
        L_0x019c:
            boolean r2 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0405 }
            if (r2 == 0) goto L_0x01a5
            r2 = r7
            goto L_0x04c0
        L_0x01a5:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x03a0 }
            r4.<init>()     // Catch:{ Exception -> 0x03a0 }
            if (r8 == 0) goto L_0x0247
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r2.<init>()     // Catch:{ Exception -> 0x039c }
            int r0 = r8.d()     // Catch:{ Exception -> 0x039c }
            r2.append(r0)     // Catch:{ Exception -> 0x039c }
            r2.append(r10)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x039c }
            r4.put(r6, r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r8.e()     // Catch:{ Exception -> 0x039c }
            r4.put(r5, r0)     // Catch:{ Exception -> 0x039c }
            int r0 = r8.f()     // Catch:{ Exception -> 0x039c }
            if (r0 == 0) goto L_0x01e7
            java.lang.String r0 = "code"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r2.<init>()     // Catch:{ Exception -> 0x039c }
            int r7 = r8.f()     // Catch:{ Exception -> 0x039c }
            r2.append(r7)     // Catch:{ Exception -> 0x039c }
            r2.append(r10)     // Catch:{ Exception -> 0x039c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x039c }
            r4.put(r0, r2)     // Catch:{ Exception -> 0x039c }
        L_0x01e7:
            int r0 = r8.b()     // Catch:{ Exception -> 0x039c }
            r2 = -1
            if (r0 == r2) goto L_0x021d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r0.<init>()     // Catch:{ Exception -> 0x039c }
            int r2 = r8.b()     // Catch:{ Exception -> 0x039c }
            r0.append(r2)     // Catch:{ Exception -> 0x039c }
            r0.append(r10)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x039c }
            r4.put(r6, r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = "type_d"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r2.<init>()     // Catch:{ Exception -> 0x039c }
            int r6 = r8.d()     // Catch:{ Exception -> 0x039c }
            r2.append(r6)     // Catch:{ Exception -> 0x039c }
            r2.append(r10)     // Catch:{ Exception -> 0x039c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x039c }
            r4.put(r0, r2)     // Catch:{ Exception -> 0x039c }
        L_0x021d:
            java.lang.String r0 = r8.c()     // Catch:{ Exception -> 0x039c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x039c }
            if (r0 != 0) goto L_0x0237
            java.lang.String r0 = r8.c()     // Catch:{ Exception -> 0x039c }
            r4.put(r5, r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = "reason_d"
            java.lang.String r2 = r8.e()     // Catch:{ Exception -> 0x039c }
            r4.put(r0, r2)     // Catch:{ Exception -> 0x039c }
        L_0x0237:
            java.lang.String r0 = "from_cache"
            boolean r2 = r8.a()     // Catch:{ Exception -> 0x039c }
            if (r2 == 0) goto L_0x0242
            r2 = r16
            goto L_0x0244
        L_0x0242:
            java.lang.String r2 = "2"
        L_0x0244:
            r4.put(r0, r2)     // Catch:{ Exception -> 0x039c }
        L_0x0247:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x039c }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x039c }
            if (r0 == 0) goto L_0x0269
            java.lang.String r2 = "network_available"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r5.<init>()     // Catch:{ Exception -> 0x039c }
            boolean r6 = com.mbridge.msdk.foundation.tools.af.d((android.content.Context) r0)     // Catch:{ Exception -> 0x039c }
            r5.append(r6)     // Catch:{ Exception -> 0x039c }
            r5.append(r10)     // Catch:{ Exception -> 0x039c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x039c }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x039c }
        L_0x0269:
            if (r1 == 0) goto L_0x027f
            int r2 = r24.size()     // Catch:{ Exception -> 0x039c }
            if (r2 <= 0) goto L_0x027f
            r2 = 0
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Exception -> 0x039c }
            r18 = r2
            com.mbridge.msdk.foundation.entity.CampaignEx r18 = (com.mbridge.msdk.foundation.entity.CampaignEx) r18     // Catch:{ Exception -> 0x039c }
            int r1 = r24.size()     // Catch:{ Exception -> 0x039c }
            goto L_0x0280
        L_0x027f:
            r1 = 0
        L_0x0280:
            java.lang.String r2 = "adtp"
            java.lang.String r5 = "isBid"
            if (r18 == 0) goto L_0x02f6
            java.lang.String r6 = r18.getCurrentLRid()     // Catch:{ Exception -> 0x039c }
            java.lang.String r7 = r18.getId()     // Catch:{ Exception -> 0x02f0 }
            r4.put(r9, r7)     // Catch:{ Exception -> 0x02f0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f0 }
            r7.<init>()     // Catch:{ Exception -> 0x02f0 }
            int r9 = r18.getAdType()     // Catch:{ Exception -> 0x02f0 }
            r7.append(r9)     // Catch:{ Exception -> 0x02f0 }
            r7.append(r10)     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x02f0 }
            r4.put(r2, r7)     // Catch:{ Exception -> 0x02f0 }
            boolean r7 = r18.isBidCampaign()     // Catch:{ Exception -> 0x02f0 }
            if (r7 == 0) goto L_0x02b0
            r7 = r16
            goto L_0x02b2
        L_0x02b0:
            r7 = r17
        L_0x02b2:
            r4.put(r13, r7)     // Catch:{ Exception -> 0x02f0 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r7 = r18.getRewardTemplateMode()     // Catch:{ Exception -> 0x02f0 }
            if (r7 == 0) goto L_0x02ee
            java.lang.String r7 = r18.getMof_template_url()     // Catch:{ Exception -> 0x02f0 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x02f0 }
            if (r7 != 0) goto L_0x02ce
            java.lang.String r7 = r18.getMof_template_url()     // Catch:{ Exception -> 0x02f0 }
            int r7 = com.mbridge.msdk.foundation.tools.af.l((java.lang.String) r7)     // Catch:{ Exception -> 0x02f0 }
            goto L_0x02da
        L_0x02ce:
            com.mbridge.msdk.foundation.entity.CampaignEx$c r7 = r18.getRewardTemplateMode()     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r7 = r7.e()     // Catch:{ Exception -> 0x02f0 }
            int r7 = com.mbridge.msdk.foundation.tools.af.l((java.lang.String) r7)     // Catch:{ Exception -> 0x02f0 }
        L_0x02da:
            if (r7 == 0) goto L_0x02ee
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f0 }
            r9.<init>()     // Catch:{ Exception -> 0x02f0 }
            r9.append(r7)     // Catch:{ Exception -> 0x02f0 }
            r9.append(r10)     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x02f0 }
            r4.put(r11, r7)     // Catch:{ Exception -> 0x02f0 }
        L_0x02ee:
            r7 = r6
            goto L_0x0305
        L_0x02f0:
            r0 = move-exception
            r2 = r21
            r7 = r6
            goto L_0x03a4
        L_0x02f6:
            boolean r6 = r3.isEmpty()     // Catch:{ Exception -> 0x039c }
            if (r6 != 0) goto L_0x0303
            java.lang.Object r6 = r3.get(r5)     // Catch:{ Exception -> 0x039c }
            r4.put(r13, r6)     // Catch:{ Exception -> 0x039c }
        L_0x0303:
            r7 = r23
        L_0x0305:
            r3.remove(r5)     // Catch:{ Exception -> 0x0398 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0398 }
            r5.<init>()     // Catch:{ Exception -> 0x0398 }
            int r0 = com.mbridge.msdk.foundation.tools.w.r(r0)     // Catch:{ Exception -> 0x0398 }
            r5.append(r0)     // Catch:{ Exception -> 0x0398 }
            r5.append(r10)     // Catch:{ Exception -> 0x0398 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0398 }
            r4.put(r15, r0)     // Catch:{ Exception -> 0x0398 }
            r4.put(r14, r12)     // Catch:{ Exception -> 0x0398 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0398 }
            if (r0 != 0) goto L_0x0335
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.mbridge.msdk.foundation.controller.b.c     // Catch:{ Exception -> 0x0398 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x0398 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0398 }
            java.lang.String r5 = "u_stid"
            r4.put(r5, r0)     // Catch:{ Exception -> 0x0398 }
        L_0x0335:
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0398 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0398 }
            if (r0 != 0) goto L_0x0344
            java.lang.String r0 = "b"
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0398 }
            r4.put(r0, r5)     // Catch:{ Exception -> 0x0398 }
        L_0x0344:
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0398 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0398 }
            if (r0 != 0) goto L_0x0353
            java.lang.String r0 = "c"
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0398 }
            r4.put(r0, r5)     // Catch:{ Exception -> 0x0398 }
        L_0x0353:
            r4.putAll(r3)     // Catch:{ Exception -> 0x0398 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0398 }
            if (r0 == 0) goto L_0x0380
            if (r8 == 0) goto L_0x0370
            java.util.Map r0 = r8.g()     // Catch:{ Exception -> 0x0398 }
            if (r0 == 0) goto L_0x0370
            java.util.Map r0 = r8.g()     // Catch:{ Exception -> 0x0398 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0398 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0398 }
            r5 = r0
            goto L_0x0371
        L_0x0370:
            r5 = r10
        L_0x0371:
            java.lang.String r3 = "load fail"
            r1 = r21
            r2 = r22
            r0 = r4
            r4 = r12
            r6 = r0
            r1.b(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0398 }
            r2 = r21
            goto L_0x0393
        L_0x0380:
            r0 = r4
            r2 = 1
            if (r1 <= r2) goto L_0x038c
            r2 = r21
            r4 = r22
            r2.b(r4, r7, r0)     // Catch:{ Exception -> 0x0396 }
            goto L_0x0393
        L_0x038c:
            r2 = r21
            r4 = r22
            r2.a((java.lang.String) r4, (java.lang.String) r7, (java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x0396 }
        L_0x0393:
            r5 = r19
            goto L_0x03ad
        L_0x0396:
            r0 = move-exception
            goto L_0x03a4
        L_0x0398:
            r0 = move-exception
            r2 = r21
            goto L_0x03a4
        L_0x039c:
            r0 = move-exception
            r2 = r21
            goto L_0x03a2
        L_0x03a0:
            r0 = move-exception
            r2 = r7
        L_0x03a2:
            r7 = r23
        L_0x03a4:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0403 }
            r5 = r19
            com.mbridge.msdk.foundation.tools.aa.d(r5, r0)     // Catch:{ Exception -> 0x04b4 }
        L_0x03ad:
            if (r8 == 0) goto L_0x04c0
            java.lang.String r0 = r8.e()     // Catch:{ Exception -> 0x04b4 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04b4 }
            if (r0 != 0) goto L_0x04c0
            java.lang.String r0 = r8.e()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r1 = "current unit is loading"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x04b4 }
            if (r0 != 0) goto L_0x04c0
            java.lang.String r0 = r8.e()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r1 = "checkOverCap failed"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x04b4 }
            if (r0 != 0) goto L_0x04c0
            java.lang.String r0 = r8.e()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r1 = "bidToken is empty"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x04b4 }
            if (r0 != 0) goto L_0x04c0
            r2.b((java.lang.String) r7)     // Catch:{ Exception -> 0x04b4 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x04b4 }
            if (r0 == 0) goto L_0x03e8
            goto L_0x04c0
        L_0x03e8:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.e>> r0 = r2.h     // Catch:{ Exception -> 0x03f9 }
            if (r0 == 0) goto L_0x04c0
            boolean r0 = r0.containsKey(r12)     // Catch:{ Exception -> 0x03f9 }
            if (r0 == 0) goto L_0x04c0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.e>> r0 = r2.h     // Catch:{ Exception -> 0x03f9 }
            r0.remove(r12)     // Catch:{ Exception -> 0x03f9 }
            goto L_0x04c0
        L_0x03f9:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x04b4 }
            com.mbridge.msdk.foundation.tools.aa.d(r5, r0)     // Catch:{ Exception -> 0x04b4 }
            goto L_0x04c0
        L_0x0403:
            r0 = move-exception
            goto L_0x0407
        L_0x0405:
            r0 = move-exception
            r2 = r7
        L_0x0407:
            r5 = r19
            goto L_0x04b9
        L_0x040b:
            r4 = r0
            r2 = r7
            r5 = r8
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x04b4 }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x04b4 }
            if (r0 == 0) goto L_0x04c0
            if (r1 == 0) goto L_0x04c0
            boolean r6 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x04b4 }
            if (r6 == 0) goto L_0x0422
            goto L_0x04c0
        L_0x0422:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ab }
            r6.<init>()     // Catch:{ Exception -> 0x04ab }
            int r0 = com.mbridge.msdk.foundation.tools.w.r(r0)     // Catch:{ Exception -> 0x04ab }
            r6.append(r0)     // Catch:{ Exception -> 0x04ab }
            r6.append(r10)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x04ab }
            r3.put(r15, r0)     // Catch:{ Exception -> 0x04ab }
            r0 = r25
            r3.put(r14, r0)     // Catch:{ Exception -> 0x04ab }
            if (r1 == 0) goto L_0x044e
            int r0 = r24.size()     // Catch:{ Exception -> 0x04ab }
            if (r0 <= 0) goto L_0x044e
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x04ab }
            r18 = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r18 = (com.mbridge.msdk.foundation.entity.CampaignEx) r18     // Catch:{ Exception -> 0x04ab }
        L_0x044e:
            if (r18 == 0) goto L_0x049c
            java.lang.String r0 = r18.getCurrentLRid()     // Catch:{ Exception -> 0x04ab }
            boolean r6 = r18.isBidCampaign()     // Catch:{ Exception -> 0x04ab }
            if (r6 == 0) goto L_0x045d
            r12 = r16
            goto L_0x045f
        L_0x045d:
            r12 = r17
        L_0x045f:
            r3.put(r13, r12)     // Catch:{ Exception -> 0x04ab }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r6 = r18.getRewardTemplateMode()     // Catch:{ Exception -> 0x04ab }
            if (r6 == 0) goto L_0x049b
            java.lang.String r6 = r18.getMof_template_url()     // Catch:{ Exception -> 0x04ab }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x04ab }
            if (r6 != 0) goto L_0x047b
            java.lang.String r6 = r18.getMof_template_url()     // Catch:{ Exception -> 0x04ab }
            int r6 = com.mbridge.msdk.foundation.tools.af.l((java.lang.String) r6)     // Catch:{ Exception -> 0x04ab }
            goto L_0x0487
        L_0x047b:
            com.mbridge.msdk.foundation.entity.CampaignEx$c r6 = r18.getRewardTemplateMode()     // Catch:{ Exception -> 0x04ab }
            java.lang.String r6 = r6.e()     // Catch:{ Exception -> 0x04ab }
            int r6 = com.mbridge.msdk.foundation.tools.af.l((java.lang.String) r6)     // Catch:{ Exception -> 0x04ab }
        L_0x0487:
            if (r6 == 0) goto L_0x049b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ab }
            r7.<init>()     // Catch:{ Exception -> 0x04ab }
            r7.append(r6)     // Catch:{ Exception -> 0x04ab }
            r7.append(r10)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x04ab }
            r3.put(r11, r6)     // Catch:{ Exception -> 0x04ab }
        L_0x049b:
            r10 = r0
        L_0x049c:
            int r0 = r24.size()     // Catch:{ Exception -> 0x04ab }
            r1 = 1
            if (r0 <= r1) goto L_0x04a7
            r2.b(r4, r10, r3)     // Catch:{ Exception -> 0x04ab }
            goto L_0x04c0
        L_0x04a7:
            r2.a((java.lang.String) r4, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x04ab }
            goto L_0x04c0
        L_0x04ab:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x04b4 }
            com.mbridge.msdk.foundation.tools.aa.d(r5, r0)     // Catch:{ Exception -> 0x04b4 }
            goto L_0x04c0
        L_0x04b4:
            r0 = move-exception
            goto L_0x04b9
        L_0x04b6:
            r0 = move-exception
            r2 = r7
            r5 = r8
        L_0x04b9:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r5, r0)
        L_0x04c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.m.a(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String):void");
    }

    public final e b(String str, String str2) {
        Map map;
        ConcurrentHashMap<String, Map<String, e>> concurrentHashMap = this.h;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str) || (map = this.h.get(str)) == null || !map.containsKey(str2)) {
            return null;
        }
        return (e) map.get(str2);
    }

    public final void a(String str, e eVar) {
        if (eVar != null) {
            if (TextUtils.isEmpty(str)) {
                str = "unknown_unit_id";
            }
            if (this.h == null) {
                this.h = new ConcurrentHashMap<>();
            }
            String e2 = eVar.e();
            if (!TextUtils.isEmpty(e2)) {
                if (!this.h.containsKey(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(e2, eVar);
                    this.h.put(str, hashMap);
                    return;
                }
                Map map = this.h.get(str);
                if (map == null) {
                    map = new HashMap();
                }
                if (map.size() >= 200) {
                    map.clear();
                }
                map.put(e2, eVar);
            }
        }
    }

    private void a(String str, b bVar) {
        if (this.d.containsKey(str)) {
            c cVar = this.d.get(str);
            if (cVar != null) {
                cVar.a(bVar);
                return;
            }
            return;
        }
        c cVar2 = new c();
        cVar2.a(bVar);
        this.d.put(str, cVar2);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ConcurrentHashMap<String, Map<String, Map<String, String>>> concurrentHashMap = this.f;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                    this.f.remove(str);
                }
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.c;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str)) {
                    this.c.remove(str);
                }
                ConcurrentHashMap<String, c> concurrentHashMap3 = this.d;
                if (concurrentHashMap3 != null && concurrentHashMap3.containsKey(str)) {
                    this.d.remove(str);
                }
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap4 = this.e;
                if (concurrentHashMap4 != null && concurrentHashMap4.containsKey(str)) {
                    this.e.remove(str);
                }
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap5 = this.g;
                if (concurrentHashMap5 != null && concurrentHashMap5.containsKey(str)) {
                    this.g.remove(str);
                }
            } catch (Exception e2) {
                aa.d("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    public final void b() {
        if (this.k != null) {
            this.k.e();
        }
    }

    public final void c() {
        boolean z = false;
        if (ac.a().a("metrics", "e_t_l", ac.a().a("e_t_l", 0)) == 1) {
            z = true;
        }
        if (z) {
            d().e();
        }
    }

    public final com.mbridge.msdk.e.m d() {
        if (this.k == null) {
            this.k = com.mbridge.msdk.e.m.a("mtg_sdk", com.mbridge.msdk.foundation.controller.b.d().g(), e());
            this.k.a(h.c());
            this.k.a();
        }
        return this.k;
    }

    private w e() {
        o oVar;
        int a2 = ac.a().a("metrics", "t_m_e_t", ac.a().a("t_m_e_t", 604800000));
        int a3 = ac.a().a("metrics", "t_m_e_s", ac.a().a("t_m_e_s", 50));
        int a4 = ac.a().a("metrics", "t_m_r_c", ac.a().a("t_m_r_c", 50));
        int a5 = ac.a().a("metrics", "t_m_t", ac.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS));
        int a6 = ac.a().a("metrics", "t_m_r_t_s", ac.a().a("t_m_r_t_s", 2));
        int a7 = ac.a().a("metrics", "t_r_t", ac.a().a("t_r_t", 0));
        if (!(a7 == 0 || a7 == 1)) {
            a7 = 0;
        }
        try {
            w.a a8 = new w.a().e(a2).a(a3).d(a4).b(a5).c(a6).a((d) new i()).a(h.a()).a((v) new u());
            if (a7 == 1) {
                oVar = new o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.g.d.a().h, com.mbridge.msdk.foundation.same.net.g.d.a().l);
            } else {
                oVar = new o(new g(), DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS, 0);
            }
            w.a a9 = a8.a(a7, oVar);
            a.a = MBridgeConstans.DEBUG;
            return a9.a();
        } catch (Exception e2) {
            aa.d("EventLibraryReport", "configTrackManager error: " + e2.getMessage());
            return null;
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, int i2) {
        com.mbridge.msdk.e.m d2 = a().d();
        if (d2 != null) {
            if (!d2.a("2000105")) {
                aa.a("MetricsReportUtil", "reportClickImpException can not track");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(str2)) {
                    jSONObject.put("url", "");
                } else {
                    jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
                }
                jSONObject.put("type", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("rid", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("rid_n", str4);
                }
                try {
                    long[] f2 = d2.f();
                    jSONObject.put("track_time", f2[0]);
                    jSONObject.put("track_count", f2[1]);
                    jSONObject.put("session_id", d2.b());
                } catch (Exception unused) {
                }
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_REASON, URLEncoder.encode(str, "utf-8"));
                com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("2000105");
                eVar.a(jSONObject);
                eVar.b(0);
                eVar.a(0);
                eVar.a(h.b());
                d2.a(eVar);
            } catch (Exception e2) {
                aa.d("MetricsReportUtil", e2.getMessage());
            }
        }
    }

    public final void a(CampaignEx campaignEx, Context context, String str, String str2, boolean z, String str3, String str4, long j2, String str5) {
        int a2;
        com.mbridge.msdk.e.m d2 = a().d();
        if (d2 != null) {
            if (!d2.a("2000078")) {
                aa.a("MetricsReportUtil", "report78ByTrackManager can not track");
            } else if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    if (campaignEx != null) {
                        jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, campaignEx.getId());
                        jSONObject.put("adtp", campaignEx.getAdType());
                    }
                    if (z) {
                        jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
                    } else {
                        jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("rid", str3);
                    } else if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getRequestId())) {
                        jSONObject.put("rid", campaignEx.getRequestId());
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject.put("rid_n", str4);
                    } else if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getRequestIdNotice())) {
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    }
                    jSONObject.put("during", j2);
                    jSONObject.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
                    jSONObject.put("r_stid", str5);
                    try {
                        long[] f2 = d2.f();
                        jSONObject.put("track_time", f2[0]);
                        jSONObject.put("track_count", f2[1]);
                        jSONObject.put("session_id", d2.b());
                    } catch (Exception unused) {
                    }
                    if (campaignEx != null) {
                        if (!(campaignEx.getRewardTemplateMode() == null || (a2 = c.a(campaignEx, campaignEx.getRewardTemplateMode().e())) == -1)) {
                            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, a2);
                        }
                    }
                    com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("2000078");
                    eVar.a(jSONObject);
                    eVar.a(0);
                    eVar.b(0);
                    eVar.a(h.b());
                    d2.a(eVar);
                } catch (Exception e2) {
                    aa.d("MetricsReportUtil", "reportEntryLoadFailedMessage error:" + e2.getMessage());
                }
            }
        }
    }
}
