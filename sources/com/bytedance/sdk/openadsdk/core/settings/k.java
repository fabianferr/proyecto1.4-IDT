package com.bytedance.sdk.openadsdk.core.settings;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SdkSwitch */
public class k {
    private static final AtomicInteger a = new AtomicInteger(1);

    public static boolean a() {
        return a.get() == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void a(int r5) {
        /*
            java.lang.String r0 = "SdkSwitch"
            r1 = 1
            if (r5 == r1) goto L_0x0009
            r2 = 2
            if (r5 == r2) goto L_0x0009
            return
        L_0x0009:
            r2 = 0
            java.util.concurrent.atomic.AtomicInteger r3 = a     // Catch:{ all -> 0x001a }
            int r4 = r3.get()     // Catch:{ all -> 0x001a }
            if (r4 == r5) goto L_0x0018
            r3.set(r5)     // Catch:{ all -> 0x0016 }
            goto L_0x0023
        L_0x0016:
            r5 = move-exception
            goto L_0x001c
        L_0x0018:
            r1 = 0
            goto L_0x0023
        L_0x001a:
            r5 = move-exception
            r1 = 0
        L_0x001c:
            java.lang.String r5 = r5.getMessage()
            com.bytedance.sdk.component.utils.l.e(r0, r5)
        L_0x0023:
            if (r1 == 0) goto L_0x0047
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "switch status changed: "
            r5.<init>(r1)
            boolean r1 = a()
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
            boolean r5 = a()
            if (r5 == 0) goto L_0x0044
            com.bytedance.sdk.openadsdk.b.a.d.b()
            goto L_0x0047
        L_0x0044:
            com.bytedance.sdk.openadsdk.b.a.d.c()
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.k.a(int):void");
    }
}
