package com.apm.insight.nativecrash;

import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.c;
import com.apm.insight.runtime.o;

public class b {
    public static int a() {
        return 6;
    }

    private static void a(String str, String str2, String str3) {
        for (ICrashCallback next : o.a().d()) {
            try {
                if (next instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) next).a(CrashType.NATIVE, str, str3, str2);
                } else {
                    next.onCrash(CrashType.NATIVE, str, (Thread) null);
                }
            } catch (Throwable th) {
                c.a().a("NPTH_CATCH", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c A[Catch:{ all -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = "main"
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0022
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            java.lang.Thread r6 = r6.getThread()
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)
            return r6
        L_0x0022:
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.ThreadGroup r0 = r0.getThreadGroup()
            int r2 = r0.activeCount()
            int r3 = r2 / 2
            int r2 = r2 + r3
            java.lang.Thread[] r2 = new java.lang.Thread[r2]
            int r0 = r0.enumerate(r2)
            r3 = 0
        L_0x003c:
            if (r3 >= r0) goto L_0x006a
            r4 = r2[r3]
            java.lang.String r4 = r4.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0067
            boolean r5 = r4.equals(r6)
            if (r5 != 0) goto L_0x005c
            boolean r5 = r4.startsWith(r6)
            if (r5 != 0) goto L_0x005c
            boolean r4 = r4.endsWith(r6)
            if (r4 == 0) goto L_0x0067
        L_0x005c:
            r6 = r2[r3]
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)
            return r6
        L_0x0067:
            int r3 = r3 + 1
            goto L_0x003c
        L_0x006a:
            java.util.Map r0 = java.lang.Thread.getAllStackTraces()     // Catch:{ all -> 0x00a9 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00a9 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a9 }
        L_0x0076:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a9 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00a9 }
            java.lang.Thread r3 = (java.lang.Thread) r3     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00a9 }
            boolean r4 = r3.equals(r6)     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x009e
            boolean r4 = r3.startsWith(r6)     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x009e
            boolean r3 = r3.endsWith(r6)     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0076
        L_0x009e:
            java.lang.Object r6 = r2.getValue()     // Catch:{ all -> 0x00a9 }
            java.lang.StackTraceElement[] r6 = (java.lang.StackTraceElement[]) r6     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)     // Catch:{ all -> 0x00a9 }
            return r6
        L_0x00a9:
            r6 = move-exception
            com.apm.insight.d r0 = com.apm.insight.c.a()
            java.lang.String r2 = "NPTH_CATCH"
            r0.a((java.lang.String) r2, (java.lang.Throwable) r6)
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onNativeCrash(final java.lang.String r11) {
        /*
            java.lang.String r0 = "crash_cost"
            java.lang.String r1 = ""
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "[onNativeCrash] enter"
            com.apm.insight.l.q.a((java.lang.Object) r4)
            r4 = 0
            com.apm.insight.k.b r5 = com.apm.insight.k.b.a()     // Catch:{ all -> 0x00ab }
            r5.b()     // Catch:{ all -> 0x00ab }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00ab }
            java.io.File r6 = com.apm.insight.l.o.a()     // Catch:{ all -> 0x00ab }
            java.lang.String r7 = com.apm.insight.i.f()     // Catch:{ all -> 0x00ab }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00ab }
            java.io.File r5 = com.apm.insight.l.o.e((java.io.File) r5)     // Catch:{ all -> 0x00ab }
            com.apm.insight.runtime.a.f r6 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x00ab }
            com.apm.insight.CrashType r7 = com.apm.insight.CrashType.NATIVE     // Catch:{ all -> 0x00ab }
            com.apm.insight.nativecrash.b$1 r8 = new com.apm.insight.nativecrash.b$1     // Catch:{ all -> 0x00ab }
            r8.<init>(r11, r5, r2)     // Catch:{ all -> 0x00ab }
            r9 = 1
            com.apm.insight.entity.a r6 = r6.a(r7, r4, r8, r9)     // Catch:{ all -> 0x00ab }
            org.json.JSONObject r7 = r6.h()     // Catch:{ all -> 0x00ab }
            if (r7 == 0) goto L_0x007f
            int r8 = r7.length()     // Catch:{ all -> 0x00ab }
            if (r8 == 0) goto L_0x007f
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ab }
            long r2 = r8 - r2
            java.lang.String r10 = "java_end"
            r7.put(r10, r8)     // Catch:{ all -> 0x005e }
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x005e }
            r6.b((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ all -> 0x005e }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r8
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x005e }
            r6.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x005e }
        L_0x005e:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
            r2.<init>()     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ all -> 0x00ab }
            r2.append(r3)     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = ".tmp"
            r2.append(r3)     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ab }
            r0.<init>(r2)     // Catch:{ all -> 0x00ab }
            r2 = 0
            com.apm.insight.l.i.a((java.io.File) r0, (org.json.JSONObject) r7, (boolean) r2)     // Catch:{ all -> 0x00ab }
            r0.renameTo(r5)     // Catch:{ all -> 0x00ab }
        L_0x007f:
            com.apm.insight.runtime.c r0 = com.apm.insight.runtime.o.a()     // Catch:{ all -> 0x00e4 }
            java.util.List r0 = r0.d()     // Catch:{ all -> 0x00e4 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00e7
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00e4 }
            java.io.File r2 = com.apm.insight.l.o.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = com.apm.insight.i.f()     // Catch:{ all -> 0x00e4 }
            r0.<init>(r2, r3)     // Catch:{ all -> 0x00e4 }
            com.apm.insight.nativecrash.e r2 = new com.apm.insight.nativecrash.e     // Catch:{ all -> 0x00e4 }
            r2.<init>(r0)     // Catch:{ all -> 0x00e4 }
            r2.b(r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = r2.c()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x00e4 }
            goto L_0x00e0
        L_0x00ab:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = "NPTH_CATCH"
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x00e8 }
            com.apm.insight.runtime.c r0 = com.apm.insight.runtime.o.a()     // Catch:{ all -> 0x00e4 }
            java.util.List r0 = r0.d()     // Catch:{ all -> 0x00e4 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00e7
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00e4 }
            java.io.File r2 = com.apm.insight.l.o.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = com.apm.insight.i.f()     // Catch:{ all -> 0x00e4 }
            r0.<init>(r2, r3)     // Catch:{ all -> 0x00e4 }
            com.apm.insight.nativecrash.e r2 = new com.apm.insight.nativecrash.e     // Catch:{ all -> 0x00e4 }
            r2.<init>(r0)     // Catch:{ all -> 0x00e4 }
            r2.b(r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = r2.c()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x00e4 }
        L_0x00e0:
            a(r0, r2, r11)     // Catch:{ all -> 0x00e4 }
            goto L_0x00e7
        L_0x00e4:
            a(r1, r4, r11)
        L_0x00e7:
            return
        L_0x00e8:
            r0 = move-exception
            com.apm.insight.runtime.c r2 = com.apm.insight.runtime.o.a()     // Catch:{ all -> 0x0118 }
            java.util.List r2 = r2.d()     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0118 }
            if (r2 != 0) goto L_0x011b
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0118 }
            java.io.File r3 = com.apm.insight.l.o.a()     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = com.apm.insight.i.f()     // Catch:{ all -> 0x0118 }
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0118 }
            com.apm.insight.nativecrash.e r3 = new com.apm.insight.nativecrash.e     // Catch:{ all -> 0x0118 }
            r3.<init>(r2)     // Catch:{ all -> 0x0118 }
            r3.b(r2)     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r3.c()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r3.a()     // Catch:{ all -> 0x0118 }
            a(r2, r3, r11)     // Catch:{ all -> 0x0118 }
            goto L_0x011b
        L_0x0118:
            a(r1, r4, r11)
        L_0x011b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.onNativeCrash(java.lang.String):void");
    }
}
