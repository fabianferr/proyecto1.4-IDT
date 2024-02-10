package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.lang.Thread;

/* compiled from: TTCrashHandler */
public class x implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    public static x a() {
        return new x();
    }

    private x() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void b() {
        Context a2 = o.a();
        if (a2 != null) {
            try {
                File file = new File(a2.getFilesDir(), "TTCache");
                file.mkdirs();
                this.b = file.getPath();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncaughtException(java.lang.Thread r4, java.lang.Throwable r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ all -> 0x0023 }
            r2.<init>(r1)     // Catch:{ all -> 0x0023 }
            r5.printStackTrace(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0024
            java.lang.Class<com.bytedance.sdk.openadsdk.AdSlot> r2 = com.bytedance.sdk.openadsdk.AdSlot.class
            java.lang.Package r2 = r2.getPackage()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0023 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002a
            r3.a(r4, r5)
        L_0x002a:
            com.bytedance.sdk.component.g.f.a((boolean) r0)
            java.lang.Thread$UncaughtExceptionHandler r0 = r3.a
            if (r0 == 0) goto L_0x0036
            if (r0 == r3) goto L_0x0036
            r0.uncaughtException(r4, r5)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.x.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f6 A[SYNTHETIC, Splitter:B:55:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010c A[SYNTHETIC, Splitter:B:68:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.Thread r20, java.lang.Throwable r21) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = ", "
            java.lang.String r2 = "0"
            java.lang.String r3 = "TTCrashHandler"
            java.lang.String r4 = "=="
            r5 = 0
            java.lang.String r6 = r1.b     // Catch:{ all -> 0x0103 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0103 }
            if (r6 == 0) goto L_0x0016
            r19.b()     // Catch:{ all -> 0x0103 }
        L_0x0016:
            java.lang.String r6 = r1.b     // Catch:{ all -> 0x0103 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0103 }
            if (r6 == 0) goto L_0x001f
            return
        L_0x001f:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = r1.b     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = "tt_crash_count.properties"
            r6.<init>(r7, r8)     // Catch:{ all -> 0x0103 }
            boolean r7 = r6.exists()     // Catch:{ all -> 0x0103 }
            java.lang.String r8 = "tt_crash_info"
            java.lang.String r9 = "crash_last_time"
            java.lang.String r10 = "crash_count"
            r11 = 1
            if (r7 == 0) goto L_0x00d0
            boolean r7 = r6.isFile()     // Catch:{ all -> 0x0103 }
            if (r7 == 0) goto L_0x00d0
            boolean r7 = r6.canRead()     // Catch:{ all -> 0x0103 }
            if (r7 == 0) goto L_0x00d0
            java.util.Properties r7 = new java.util.Properties     // Catch:{ all -> 0x0103 }
            r7.<init>()     // Catch:{ all -> 0x0103 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ all -> 0x0103 }
            r12.<init>(r6)     // Catch:{ all -> 0x0103 }
            r7.load(r12)     // Catch:{ all -> 0x00cc }
            java.lang.String r13 = r7.getProperty(r10, r2)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = r7.getProperty(r9, r2)     // Catch:{ all -> 0x00cc }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x00cc }
            int r13 = r13.intValue()     // Catch:{ all -> 0x00cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00cc }
            long r14 = r2.longValue()     // Catch:{ all -> 0x00cc }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cc }
            long r16 = r16 - r14
            r14 = 300000(0x493e0, double:1.482197E-318)
            r2 = 0
            int r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r18 >= 0) goto L_0x0077
            int r13 = r13 + r11
            r14 = 0
            goto L_0x0079
        L_0x0077:
            r13 = 1
            r14 = 1
        L_0x0079:
            r15 = 3
            if (r13 < r15) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r11 = 0
        L_0x007e:
            if (r11 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r2 = r13
        L_0x0082:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r13.<init>(r4)     // Catch:{ all -> 0x00cc }
            r13.append(r2)     // Catch:{ all -> 0x00cc }
            r13.append(r0)     // Catch:{ all -> 0x00cc }
            r13.append(r11)     // Catch:{ all -> 0x00cc }
            r13.append(r0)     // Catch:{ all -> 0x00cc }
            r13.append(r14)     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x00cc }
            com.bytedance.sdk.component.utils.l.e(r3, r0)     // Catch:{ all -> 0x00cc }
            if (r11 == 0) goto L_0x00a5
            r6.delete()     // Catch:{ all -> 0x00a3 }
            goto L_0x00c2
        L_0x00a3:
            goto L_0x00c2
        L_0x00a5:
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00cc }
            r7.setProperty(r10, r0)     // Catch:{ all -> 0x00cc }
            if (r14 == 0) goto L_0x00b9
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x00cc }
            r7.setProperty(r9, r0)     // Catch:{ all -> 0x00cc }
        L_0x00b9:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00cc }
            r2.<init>(r6)     // Catch:{ all -> 0x00cc }
            r7.store(r2, r8)     // Catch:{ all -> 0x00ca }
            r5 = r2
        L_0x00c2:
            if (r11 == 0) goto L_0x00c7
            r19.c()     // Catch:{ all -> 0x00cc }
        L_0x00c7:
            r2 = r5
            r5 = r12
            goto L_0x00f4
        L_0x00ca:
            r0 = move-exception
            goto L_0x00ce
        L_0x00cc:
            r0 = move-exception
            r2 = r5
        L_0x00ce:
            r5 = r12
            goto L_0x0105
        L_0x00d0:
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x0103 }
            r0.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0103 }
            r0.setProperty(r10, r2)     // Catch:{ all -> 0x0103 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0103 }
            r0.setProperty(r9, r2)     // Catch:{ all -> 0x0103 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0103 }
            r2.<init>(r6)     // Catch:{ all -> 0x0103 }
            r0.store(r2, r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = "==first"
            com.bytedance.sdk.component.utils.l.e(r3, r0)     // Catch:{ all -> 0x0101 }
        L_0x00f4:
            if (r5 == 0) goto L_0x00fb
            r5.close()     // Catch:{ all -> 0x00fa }
            goto L_0x00fb
        L_0x00fa:
        L_0x00fb:
            if (r2 == 0) goto L_0x0114
        L_0x00fd:
            r2.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0114
        L_0x0101:
            r0 = move-exception
            goto L_0x0105
        L_0x0103:
            r0 = move-exception
            r2 = r5
        L_0x0105:
            java.lang.String r4 = "crash count error"
            com.bytedance.sdk.component.utils.l.c(r3, r4, r0)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0111
            r5.close()     // Catch:{ all -> 0x0110 }
            goto L_0x0111
        L_0x0110:
        L_0x0111:
            if (r2 == 0) goto L_0x0114
            goto L_0x00fd
        L_0x0114:
            return
        L_0x0115:
            r0 = move-exception
            if (r5 == 0) goto L_0x011d
            r5.close()     // Catch:{ all -> 0x011c }
            goto L_0x011d
        L_0x011c:
        L_0x011d:
            if (r2 == 0) goto L_0x0122
            r2.close()     // Catch:{ all -> 0x0122 }
        L_0x0122:
            goto L_0x0124
        L_0x0123:
            throw r0
        L_0x0124:
            goto L_0x0123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.x.a(java.lang.Thread, java.lang.Throwable):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(1:4)|5|7|8|(1:10)|11|12|13|14|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r7 = this;
            java.lang.String r0 = "a"
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = "com.bytedance.sdk.openadsdk.TTC2Proxy"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x001e }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch:{ all -> 0x001e }
            java.lang.reflect.Method r4 = com.bytedance.sdk.component.utils.w.a(r4, r0, r5)     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x001e
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x001e }
            android.content.Context r6 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ all -> 0x001e }
            r5[r2] = r6     // Catch:{ all -> 0x001e }
            r4.invoke(r1, r5)     // Catch:{ all -> 0x001e }
        L_0x001e:
            java.lang.String r4 = "com.bytedance.sdk.openadsdk.TTC3Proxy"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x0037 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch:{ all -> 0x0037 }
            java.lang.reflect.Method r0 = com.bytedance.sdk.component.utils.w.a(r4, r0, r5)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0037
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0037 }
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ all -> 0x0037 }
            r3[r2] = r4     // Catch:{ all -> 0x0037 }
            r0.invoke(r1, r3)     // Catch:{ all -> 0x0037 }
        L_0x0037:
            com.bytedance.sdk.openadsdk.core.settings.e r0 = com.bytedance.sdk.openadsdk.core.settings.o.ai()     // Catch:{ all -> 0x003e }
            r0.a()     // Catch:{ all -> 0x003e }
        L_0x003e:
            com.bytedance.sdk.component.adexpress.a.b.a.b()     // Catch:{ all -> 0x0041 }
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.x.c():void");
    }
}
