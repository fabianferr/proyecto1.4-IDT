package com.startapp;

import java.io.File;

/* compiled from: Sta */
public class v6 {
    public static t6 a;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r11) {
        /*
            android.content.Context r0 = com.startapp.h0.a(r11)
            if (r0 == 0) goto L_0x0007
            r11 = r0
        L_0x0007:
            com.startapp.t6 r0 = a
            if (r0 != 0) goto L_0x0012
            com.startapp.t6 r0 = new com.startapp.t6
            r0.<init>(r11)
            a = r0
        L_0x0012:
            com.startapp.t6 r0 = a
            r0.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String[] r2 = com.startapp.u6.a
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.addAll(r2)
            boolean r1 = r0.a((java.util.List<java.lang.String>) r1)
            java.lang.String r2 = "test-keys"
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0081
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String[] r5 = com.startapp.u6.b
            java.util.List r5 = java.util.Arrays.asList(r5)
            r1.addAll(r5)
            boolean r1 = r0.a((java.util.List<java.lang.String>) r1)
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "su"
            boolean r1 = r0.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "busybox"
            boolean r1 = r0.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x0081
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x0081
            boolean r1 = r0.b()
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = android.os.Build.TAGS
            if (r1 == 0) goto L_0x006d
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            if (r1 != 0) goto L_0x0081
            boolean r1 = r0.c()
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "magisk"
            boolean r0 = r0.a((java.lang.String) r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r0 = 0
            goto L_0x0082
        L_0x0081:
            r0 = 1
        L_0x0082:
            if (r0 != 0) goto L_0x00e0
            java.lang.String r0 = android.os.Build.TAGS
            if (r0 == 0) goto L_0x0090
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0090
            r0 = 1
            goto L_0x0091
        L_0x0090:
            r0 = 0
        L_0x0091:
            if (r0 != 0) goto L_0x00e0
            boolean r0 = a()
            if (r0 != 0) goto L_0x00e0
            boolean r0 = a()
            if (r0 != 0) goto L_0x00e0
            boolean r0 = b()
            if (r0 != 0) goto L_0x00e0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00b1 }
            java.lang.String r1 = "/system/app/Superuser.apk"
            r0.<init>(r1)     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x00b1 }
            goto L_0x00b3
        L_0x00b1:
            r0 = 0
        L_0x00b3:
            if (r0 != 0) goto L_0x00e0
            java.lang.String r5 = "com.noshufou.android.su"
            java.lang.String r6 = "com.thirdparty.superuser"
            java.lang.String r7 = "eu.chainfire.supersu"
            java.lang.String r8 = "com.koushikdutta.superuser"
            java.lang.String r9 = "com.zachspong.temprootremovejb"
            java.lang.String r10 = "com.ramdroid.appquarantine"
            java.lang.String[] r0 = new java.lang.String[]{r5, r6, r7, r8, r9, r10}
            r1 = 0
        L_0x00c6:
            r2 = 6
            if (r1 >= r2) goto L_0x00dd
            r2 = r0[r1]
            android.content.pm.PackageManager r5 = r11.getPackageManager()
            r5.getPackageInfo(r2, r4)     // Catch:{ all -> 0x00d4 }
            r2 = 1
            goto L_0x00d6
        L_0x00d4:
            r2 = 0
        L_0x00d6:
            if (r2 == 0) goto L_0x00da
            r11 = 1
            goto L_0x00de
        L_0x00da:
            int r1 = r1 + 1
            goto L_0x00c6
        L_0x00dd:
            r11 = 0
        L_0x00de:
            if (r11 == 0) goto L_0x00e1
        L_0x00e0:
            r3 = 1
        L_0x00e1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.v6.a(android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "/system/xbin/which"
            java.lang.String r3 = "su"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x002d }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x002d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002b }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x002b }
            r3.<init>(r4)     // Catch:{ all -> 0x002b }
            r2.<init>(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0027
            r0 = 1
        L_0x0027:
            r1.destroy()
            return r0
        L_0x002b:
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.destroy()
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.v6.b():boolean");
    }

    public static boolean a() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }
}
