package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.c;

/* compiled from: CpuUtils */
public class f {
    public static int a() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static int a(Context context) {
        return c.a(context).b("cpu_count", 0);
    }

    public static int b(Context context) {
        return c.a(context).b("cpu_max_frequency", 0);
    }

    public static int c(Context context) {
        return c.a(context).b("cpu_min_frequency", 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[SYNTHETIC, Splitter:B:27:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A[Catch:{ Exception -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x0076
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r4.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ all -> 0x004e }
            r4.append(r7)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004e }
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0048 }
            r1.<init>(r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0043 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0043 }
            if (r4 != 0) goto L_0x0038
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0043 }
            if (r2 <= r0) goto L_0x0038
            r0 = r2
        L_0x0038:
            r1.close()     // Catch:{ Exception -> 0x003f }
            r3.close()     // Catch:{ Exception -> 0x003f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            r2 = r1
            r1 = r3
            goto L_0x0003
        L_0x0043:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x0052
        L_0x0048:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0052:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x006a }
            com.bytedance.sdk.component.utils.l.e(r4, r2)     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ Exception -> 0x0061 }
            goto L_0x0063
        L_0x0061:
            goto L_0x0068
        L_0x0063:
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0068:
            r2 = r3
            goto L_0x0003
        L_0x006a:
            r7 = move-exception
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0070:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            throw r7
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.f.a(int):int");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060 A[SYNTHETIC, Splitter:B:28:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068 A[Catch:{ Exception -> 0x0064 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x0079
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "/cpufreq/cpuinfo_min_freq"
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x004b }
            r1.<init>(r3)     // Catch:{ all -> 0x004b }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0046 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x003b
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0046 }
            if (r2 >= r0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            if (r0 != 0) goto L_0x003b
        L_0x003a:
            r0 = r2
        L_0x003b:
            r1.close()     // Catch:{ Exception -> 0x0042 }
            r3.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            r2 = r1
            r1 = r3
            goto L_0x0003
        L_0x0046:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x0055
        L_0x004b:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0055:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x006d }
            com.bytedance.sdk.component.utils.l.e(r4, r2)     // Catch:{ all -> 0x006d }
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            goto L_0x006b
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ Exception -> 0x0064 }
        L_0x006b:
            r2 = r3
            goto L_0x0003
        L_0x006d:
            r7 = move-exception
            if (r3 == 0) goto L_0x0073
            r3.close()     // Catch:{ Exception -> 0x0078 }
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ Exception -> 0x0078 }
        L_0x0078:
            throw r7
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.f.b(int):int");
    }
}
