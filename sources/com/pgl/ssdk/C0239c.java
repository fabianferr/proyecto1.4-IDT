package com.pgl.ssdk;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.pgl.ssdk.c  reason: case insensitive filesystem */
public class C0239c {
    private static final FileFilter a = new C0238b();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        if (r1 == null) goto L_0x0029;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001d A[SYNTHETIC, Splitter:B:15:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0015 }
            r2.<init>(r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0013 }
            r2.close()     // Catch:{ all -> 0x0024 }
            goto L_0x0024
        L_0x0013:
            goto L_0x001b
        L_0x0015:
            r2 = r0
            goto L_0x001b
        L_0x0018:
            r2 = r0
            r1 = r2
        L_0x001b:
            if (r2 == 0) goto L_0x0022
            r2.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            if (r1 == 0) goto L_0x0029
        L_0x0024:
            r1.close()     // Catch:{ all -> 0x0028 }
            goto L_0x0029
        L_0x0028:
        L_0x0029:
            if (r0 != 0) goto L_0x002e
            java.lang.String r2 = "0"
            goto L_0x0032
        L_0x002e:
            java.lang.String r2 = r0.trim()
        L_0x0032:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.C0239c.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (r2 == null) goto L_0x0053;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[SYNTHETIC, Splitter:B:25:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap a() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch:{ all -> 0x0045 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0043 }
            r3.<init>(r2)     // Catch:{ all -> 0x0043 }
        L_0x0012:
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x001c
            r3.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0050
        L_0x001c:
            java.lang.String r4 = ":"
            r5 = 2
            java.lang.String[] r1 = r1.split(r4, r5)     // Catch:{ all -> 0x0040 }
            int r4 = r1.length     // Catch:{ all -> 0x0040 }
            if (r4 >= r5) goto L_0x0027
            goto L_0x0012
        L_0x0027:
            r4 = 0
            r4 = r1[r4]     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x0040 }
            r5 = 1
            r1 = r1[r5]     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0040 }
            java.lang.Object r5 = r0.get(r4)     // Catch:{ all -> 0x0040 }
            if (r5 == 0) goto L_0x003c
            goto L_0x0012
        L_0x003c:
            r0.put(r4, r1)     // Catch:{ all -> 0x0040 }
            goto L_0x0012
        L_0x0040:
            r1 = r3
            goto L_0x0047
        L_0x0043:
            goto L_0x0047
        L_0x0045:
            r2 = r1
        L_0x0047:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ all -> 0x004d }
            goto L_0x004e
        L_0x004d:
        L_0x004e:
            if (r2 == 0) goto L_0x0053
        L_0x0050:
            r2.close()     // Catch:{ all -> 0x0053 }
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.C0239c.a():java.util.HashMap");
    }

    public static String b() {
        int i;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap a2 = a();
            try {
                i = new File("/sys/devices/system/cpu/").listFiles(a).length;
            } catch (Throwable unused) {
                i = -1;
            }
            jSONObject.put("core", i);
            String str2 = null;
            try {
                str = (String) a2.get("Hardware");
            } catch (Throwable unused2) {
                str = null;
            }
            String str3 = "";
            jSONObject.put("hw", str == null ? str3 : str.trim());
            jSONObject.put(AppLovinMediationProvider.MAX, a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put("min", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            try {
                str2 = (String) a2.get("Features");
            } catch (Throwable unused3) {
            }
            if (str2 != null) {
                str3 = str2.trim();
            }
            jSONObject.put("ft", str3);
        } catch (Throwable unused4) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? JsonUtils.EMPTY_JSON : jSONObject2.trim();
    }
}
