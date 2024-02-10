package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: ResourceUtil */
public final class t {
    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e) {
                aa.d("ResourceUtil", "Resource error:" + e.getMessage());
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        com.mbridge.msdk.foundation.tools.aa.d("ResourceUtil", "Resource not found resName:" + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        com.mbridge.msdk.foundation.tools.aa.d("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "ResourceUtil"
            java.lang.String r1 = "MBSDKContext.getInstance() is null resName:"
            r2 = -1
            java.lang.String r3 = ""
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = r4.b()     // Catch:{ Exception -> 0x0010 }
            goto L_0x001f
        L_0x0010:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e }
            r4.<init>(r1)     // Catch:{ Exception -> 0x003e }
            r4.append(r6)     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x003e }
            com.mbridge.msdk.foundation.tools.aa.d(r0, r1)     // Catch:{ Exception -> 0x003e }
        L_0x001f:
            boolean r1 = com.mbridge.msdk.foundation.tools.ak.a(r3)     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x002b
            if (r5 == 0) goto L_0x002b
            java.lang.String r3 = r5.getPackageName()     // Catch:{ Exception -> 0x003e }
        L_0x002b:
            boolean r1 = com.mbridge.msdk.foundation.tools.ak.a(r3)     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x0032
            return r2
        L_0x0032:
            if (r5 == 0) goto L_0x003d
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x003e }
            int r5 = r5.getIdentifier(r6, r7, r3)     // Catch:{ Exception -> 0x003e }
            return r5
        L_0x003d:
            return r2
        L_0x003e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Resource not found resName:"
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t.a(android.content.Context, java.lang.String, java.lang.String):int");
    }
}
