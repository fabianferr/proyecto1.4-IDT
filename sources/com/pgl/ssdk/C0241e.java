package com.pgl.ssdk;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.pgl.ssdk.e  reason: case insensitive filesystem */
public class C0241e {
    public static int a;
    public static int b;
    public static int c;

    private static void a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            a = point.x;
            b = point.y;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r2) {
        /*
            a(r2)     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0006
            goto L_0x0019
        L_0x0006:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x0019 }
            r0.<init>()     // Catch:{ all -> 0x0019 }
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ all -> 0x0019 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x0019 }
            float r1 = r0.density     // Catch:{ all -> 0x0019 }
            int r0 = r0.densityDpi     // Catch:{ all -> 0x0019 }
            c = r0     // Catch:{ all -> 0x0019 }
        L_0x0019:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x0028 }
            r0.<init>()     // Catch:{ all -> 0x0028 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x0028 }
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch:{ all -> 0x0028 }
            float r2 = r2.xdpi     // Catch:{ all -> 0x0028 }
        L_0x0028:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = ""
            r2.<init>(r0)
            int r0 = c
            r2.append(r0)
            java.lang.String r0 = "[<!>]"
            r2.append(r0)
            int r1 = a
            r2.append(r1)
            java.lang.String r1 = ","
            r2.append(r1)
            int r1 = b
            r2.append(r1)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.C0241e.b(android.content.Context):java.lang.String");
    }
}
