package com.bytedance.sdk.openadsdk.utils;

import java.util.ArrayList;
import java.util.List;

/* compiled from: InitChecker */
public class k {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.o.a()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r1 = com.bytedance.sdk.component.utils.l.d()
            if (r1 != 0) goto L_0x000e
            return
        L_0x000e:
            java.lang.String r1 = "The pangolin sdk access, the environment is debug, the initial configuration detection starts"
            java.lang.String r2 = "TTAdSdk-InitChecker"
            com.bytedance.sdk.component.utils.l.e(r2, r1)
            java.lang.String r1 = r0.getPackageName()
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r4)     // Catch:{ all -> 0x0084 }
            java.lang.String[] r0 = r0.requestedPermissions     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x007e
            int r1 = r0.length     // Catch:{ all -> 0x0084 }
            if (r1 <= 0) goto L_0x007e
            java.util.List r1 = b()     // Catch:{ all -> 0x0084 }
            int r4 = r0.length     // Catch:{ all -> 0x0084 }
            r6 = 0
            r7 = 0
        L_0x0038:
            if (r7 >= r4) goto L_0x0044
            r8 = r0[r7]     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x0041
            r1.remove(r8)     // Catch:{ all -> 0x0084 }
        L_0x0041:
            int r7 = r7 + 1
            goto L_0x0038
        L_0x0044:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0050
            java.lang.String r0 = "AndroidManifest.xml permissions configuration is normal"
            com.bytedance.sdk.component.utils.l.e(r2, r0)     // Catch:{ all -> 0x0084 }
            goto L_0x008a
        L_0x0050:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0084 }
        L_0x0054:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x008a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r4.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r5 = "    May be missing permissions："
            r4.append(r5)     // Catch:{ all -> 0x007b }
            r4.append(r1)     // Catch:{ all -> 0x007b }
            java.lang.String r1 = "，Please refer to the access documentation"
            r4.append(r1)     // Catch:{ all -> 0x007b }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x007b }
            com.bytedance.sdk.component.utils.l.e(r2, r1)     // Catch:{ all -> 0x007b }
            r5 = 0
            goto L_0x0054
        L_0x007b:
            r0 = move-exception
            r5 = 0
            goto L_0x0085
        L_0x007e:
            java.lang.String r0 = "The uses-permission configuration in AndroidManifest.xml is missing, please refer to the access documentation"
            com.bytedance.sdk.component.utils.l.e(r2, r0)     // Catch:{ all -> 0x0084 }
            goto L_0x008a
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            java.lang.String r1 = "The usage-permission configuration error in AndroidManifest.xml, please refer to the access documentation"
            com.bytedance.sdk.component.utils.l.c(r2, r1, r0)
        L_0x008a:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00b9 }
            r1 = 23
            if (r0 < r1) goto L_0x0092
            if (r3 >= r1) goto L_0x00bf
        L_0x0092:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r0.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = "No adaptation required for dynamic permissions：target="
            r0.append(r4)     // Catch:{ all -> 0x00b9 }
            r0.append(r3)     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = "&phone="
            r0.append(r3)     // Catch:{ all -> 0x00b9 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00b9 }
            r0.append(r3)     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = ", require="
            r0.append(r3)     // Catch:{ all -> 0x00b9 }
            r0.append(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b9 }
            com.bytedance.sdk.component.utils.l.e(r2, r0)     // Catch:{ all -> 0x00b9 }
            goto L_0x00bf
        L_0x00b9:
            r0 = move-exception
            java.lang.String r1 = "The dynamic permission is abnormal. Please check and read the access document in detail： "
            com.bytedance.sdk.component.utils.l.c(r2, r1, r0)
        L_0x00bf:
            if (r5 != 0) goto L_0x00c6
            java.lang.String r0 = "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion"
            com.bytedance.sdk.component.utils.l.e(r2, r0)
        L_0x00c6:
            java.lang.String r0 = "End of pangolin sdk initial configuration test"
            com.bytedance.sdk.component.utils.l.e(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.k.a():void");
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
