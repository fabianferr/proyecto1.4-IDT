package com.startapp;

import android.app.Application;
import android.content.Context;

/* compiled from: Sta */
public class h0 {
    public static volatile Application a;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:27|28|29|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0099 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context a(android.content.Context r10) {
        /*
            java.lang.String r0 = "Application"
            android.app.Application r1 = a
            if (r1 != 0) goto L_0x00a3
            boolean r2 = r10 instanceof android.app.Application     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0013
            r1 = r10
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0010 }
            a = r1     // Catch:{ all -> 0x0010 }
            goto L_0x0011
        L_0x0010:
        L_0x0011:
            r1 = r10
            goto L_0x002d
        L_0x0013:
            boolean r2 = r10 instanceof android.content.ContextWrapper     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0025
            r2 = r10
            android.content.ContextWrapper r2 = (android.content.ContextWrapper) r2     // Catch:{ all -> 0x002c }
            android.content.Context r2 = r2.getBaseContext()     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x002d
            android.content.Context r1 = a(r2)     // Catch:{ all -> 0x002c }
            goto L_0x002d
        L_0x0025:
            if (r10 == 0) goto L_0x002d
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ all -> 0x002c }
            goto L_0x002d
        L_0x002c:
        L_0x002d:
            if (r1 != 0) goto L_0x00a3
            android.app.Application r1 = a
            if (r1 != 0) goto L_0x00a0
            java.lang.Class<com.startapp.h0> r2 = com.startapp.h0.class
            monitor-enter(r2)
            android.app.Application r1 = a     // Catch:{ all -> 0x009d }
            if (r1 != 0) goto L_0x009b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r3.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.Class<android.app.Activity> r4 = android.app.Activity.class
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0099 }
            r3.append(r4)     // Catch:{ all -> 0x0099 }
            java.lang.Class<java.lang.Thread> r4 = java.lang.Thread.class
            java.lang.String r4 = "Thread"
            r3.append(r4)     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0099 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0099 }
            r5 = 7
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0099 }
            r6 = 99
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0099 }
            r6 = 117(0x75, float:1.64E-43)
            r8 = 1
            r5[r8] = r6     // Catch:{ all -> 0x0099 }
            r6 = 2
            r9 = 114(0x72, float:1.6E-43)
            r5[r6] = r9     // Catch:{ all -> 0x0099 }
            r6 = 3
            r5[r6] = r9     // Catch:{ all -> 0x0099 }
            r6 = 4
            r9 = 101(0x65, float:1.42E-43)
            r5[r6] = r9     // Catch:{ all -> 0x0099 }
            r6 = 5
            r9 = 110(0x6e, float:1.54E-43)
            r5[r6] = r9     // Catch:{ all -> 0x0099 }
            r6 = 6
            r9 = 116(0x74, float:1.63E-43)
            r5[r6] = r9     // Catch:{ all -> 0x0099 }
            r4.<init>(r5)     // Catch:{ all -> 0x0099 }
            java.lang.Class<android.app.Application> r5 = android.app.Application.class
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x0099 }
            java.lang.Class[] r4 = new java.lang.Class[r7]     // Catch:{ all -> 0x0099 }
            java.lang.reflect.Method r0 = r3.getDeclaredMethod(r0, r4)     // Catch:{ all -> 0x0099 }
            r0.setAccessible(r8)     // Catch:{ all -> 0x0099 }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ all -> 0x0099 }
            r4 = 0
            java.lang.Object r0 = r0.invoke(r4, r3)     // Catch:{ all -> 0x0099 }
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0099 }
            r1 = r0
        L_0x0099:
            a = r1     // Catch:{ all -> 0x009d }
        L_0x009b:
            monitor-exit(r2)     // Catch:{ all -> 0x009d }
            goto L_0x00a0
        L_0x009d:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009d }
            throw r10
        L_0x00a0:
            if (r1 != 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r10 = r1
        L_0x00a4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h0.a(android.content.Context):android.content.Context");
    }

    public static Context b(Context context) {
        Context a2 = a(context);
        return a2 != null ? a2 : context;
    }
}
