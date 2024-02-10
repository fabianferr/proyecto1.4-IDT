package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.a.b;
import com.apm.insight.a.c;
import com.apm.insight.b.d;
import com.apm.insight.d.a;
import com.apm.insight.e;
import com.apm.insight.f;
import com.apm.insight.g;
import com.apm.insight.i;
import com.apm.insight.k.h;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

public class o {
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static c f = new c();
    /* access modifiers changed from: private */
    public static volatile boolean g = false;
    private static boolean h = false;

    public static c a() {
        return f;
    }

    public static void a(long j) {
        NativeImpl.a(j);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0094=Splitter:B:43:0x0094, B:25:0x003e=Splitter:B:25:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.app.Application r4, android.content.Context r5, boolean r6, boolean r7, boolean r8, boolean r9, long r10) {
        /*
            java.lang.String r10 = "Npth.init takes "
            java.lang.Class<com.apm.insight.runtime.o> r11 = com.apm.insight.runtime.o.class
            monitor-enter(r11)
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x009c }
            boolean r2 = a     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r11)
            return
        L_0x000f:
            r2 = 1
            a = r2     // Catch:{ all -> 0x009c }
            if (r5 == 0) goto L_0x0094
            if (r4 == 0) goto L_0x0094
            com.apm.insight.i.a((android.app.Application) r4, (android.content.Context) r5)     // Catch:{ all -> 0x009c }
            boolean r3 = com.apm.insight.i.t()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x003a
            boolean r3 = a((android.content.Context) r4)     // Catch:{ all -> 0x009c }
            if (r3 != 0) goto L_0x0031
            boolean r4 = b((android.content.Context) r4)     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0031
            boolean r4 = q()     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x003a
        L_0x0031:
            java.lang.String r4 = "apminsight"
            java.lang.String r5 = "Inner npth checked."
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x009c }
            monitor-exit(r11)
            return
        L_0x003a:
            if (r6 != 0) goto L_0x003e
            if (r7 == 0) goto L_0x0058
        L_0x003e:
            com.apm.insight.g.a r4 = com.apm.insight.g.a.a()     // Catch:{ all -> 0x009c }
            if (r7 == 0) goto L_0x004c
            com.apm.insight.i.b r7 = new com.apm.insight.i.b     // Catch:{ all -> 0x009c }
            r7.<init>(r5)     // Catch:{ all -> 0x009c }
            r4.a((com.apm.insight.g.c) r7)     // Catch:{ all -> 0x009c }
        L_0x004c:
            if (r6 == 0) goto L_0x0056
            com.apm.insight.g.d r6 = new com.apm.insight.g.d     // Catch:{ all -> 0x009c }
            r6.<init>(r5)     // Catch:{ all -> 0x009c }
            r4.b((com.apm.insight.g.c) r6)     // Catch:{ all -> 0x009c }
        L_0x0056:
            b = r2     // Catch:{ all -> 0x009c }
        L_0x0058:
            com.apm.insight.nativecrash.NativeImpl.a()     // Catch:{ all -> 0x009c }
            if (r8 == 0) goto L_0x0067
            boolean r4 = com.apm.insight.nativecrash.NativeImpl.a((android.content.Context) r5)     // Catch:{ all -> 0x009c }
            d = r4     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0067
            e = r2     // Catch:{ all -> 0x009c }
        L_0x0067:
            android.os.Looper r4 = android.os.Looper.myLooper()     // Catch:{ all -> 0x009c }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x009c }
            if (r4 != r5) goto L_0x0076
            g = r2     // Catch:{ all -> 0x009c }
            com.apm.insight.nativecrash.NativeImpl.h()     // Catch:{ all -> 0x009c }
        L_0x0076:
            g(r9)     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r4.<init>(r10)     // Catch:{ all -> 0x009c }
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x009c }
            long r5 = r5 - r0
            r4.append(r5)     // Catch:{ all -> 0x009c }
            java.lang.String r5 = " ms."
            r4.append(r5)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009c }
            com.apm.insight.l.q.a((java.lang.Object) r4)     // Catch:{ all -> 0x009c }
            monitor-exit(r11)
            return
        L_0x0094:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009c }
            java.lang.String r5 = "context or Application must be not null."
            r4.<init>(r5)     // Catch:{ all -> 0x009c }
            throw r4     // Catch:{ all -> 0x009c }
        L_0x009c:
            r4 = move-exception
            monitor-exit(r11)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.a(android.app.Application, android.content.Context, boolean, boolean, boolean, boolean, long):void");
    }

    public static synchronized void a(Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        String str;
        Application application;
        synchronized (o.class) {
            if (i.h() != null) {
                application = i.h();
            } else if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                try {
                    application = (Application) context.getApplicationContext();
                    if (application == null) {
                        throw new IllegalArgumentException(str);
                    } else if (application.getBaseContext() != null) {
                        context = application.getBaseContext();
                    }
                } finally {
                    str = "Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.";
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                }
            }
            a(application, context, z, z2, z3, z4, j);
        }
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        a().a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        a().a(iOOMCallback);
    }

    public static void a(IOOMCallback iOOMCallback, CrashType crashType) {
        a().b(iOOMCallback);
    }

    public static void a(e eVar) {
        i.i().setEncryptImpl(eVar);
    }

    public static void a(h hVar) {
        com.apm.insight.k.e.a(hVar);
    }

    public static void a(j jVar) {
        k.a(jVar);
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.a(str);
        }
    }

    public static void a(String str, b bVar, c cVar) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            com.apm.insight.a.a.a().a(str, bVar, cVar);
        }
    }

    public static void a(final String str, final f fVar) {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                if (com.apm.insight.l.a.b(i.g())) {
                    d.a(str, fVar);
                }
            }
        });
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, g gVar) {
        if (!TextUtils.isEmpty(str)) {
            a.a(str, map, map2, gVar);
        }
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, g gVar) {
        if (!TextUtils.isEmpty(str)) {
            a.a(str, map, map2, map3, gVar);
        }
    }

    @Deprecated
    public static void a(Throwable th) {
        if (i.i().isReportErrorEnable()) {
            com.apm.insight.g.a.a(th);
        }
    }

    public static void a(boolean z) {
        i.b(z);
    }

    private static boolean a(Context context) {
        try {
            return new File(com.apm.insight.l.o.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(long j) {
        NativeImpl.b(j);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        a().b(iCrashCallback, crashType);
    }

    @Deprecated
    public static void b(String str) {
        if (i.i().isReportErrorEnable()) {
            com.apm.insight.g.a.c(str);
        }
    }

    public static void b(boolean z) {
        i.c(z);
    }

    public static boolean b() {
        return b;
    }

    private static boolean b(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libnpth.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(long j) {
        NativeImpl.c(j);
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void c(boolean z) {
        i.d(z);
    }

    public static boolean c() {
        return c;
    }

    public static void d(boolean z) {
        i.e(z);
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return a;
    }

    public static void f() {
        if (a && !b) {
            Context g2 = i.g();
            com.apm.insight.g.a a2 = com.apm.insight.g.a.a();
            a2.a((com.apm.insight.g.c) new com.apm.insight.i.b(g2));
            a2.b((com.apm.insight.g.c) new com.apm.insight.g.d(g2));
        }
    }

    public static void g() {
        if (a) {
            com.apm.insight.b.g.a(i.g()).c();
            c = true;
        }
    }

    private static void g(final boolean z) {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                if (!o.g) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            boolean unused = o.g = true;
                            NativeImpl.h();
                        }
                    });
                }
                o.h(z);
            }
        }, 0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(boolean r3) {
        /*
            android.content.Context r0 = com.apm.insight.i.g()
            com.apm.insight.runtime.a.f.a()
            com.apm.insight.runtime.m.a()
            java.lang.String r1 = "Npth.initAsync-createCallbackThread"
            com.apm.insight.k.a(r1)
            int r1 = com.apm.insight.nativecrash.NativeImpl.b()
            com.apm.insight.k.a()
            com.apm.insight.nativecrash.NativeImpl.c()
            boolean r2 = e
            if (r2 == 0) goto L_0x0027
            com.apm.insight.d r1 = com.apm.insight.c.a()
            java.lang.String r2 = "NativeLibraryLoad faild"
        L_0x0023:
            r1.a((java.lang.String) r2)
            goto L_0x0030
        L_0x0027:
            if (r1 >= 0) goto L_0x0030
            com.apm.insight.d r1 = com.apm.insight.c.a()
            java.lang.String r2 = "createCallbackThread faild"
            goto L_0x0023
        L_0x0030:
            java.lang.String r1 = "Npth.initAsync-NpthDataManager"
            com.apm.insight.k.a(r1)
            com.apm.insight.e.a r1 = com.apm.insight.e.a.a()
            r1.a((android.content.Context) r0)
            com.apm.insight.k.a()
            com.apm.insight.c.a()
            java.lang.String r1 = "Npth.initAsync-LaunchScanner"
            com.apm.insight.k.a(r1)
            com.apm.insight.k.i.a(r0)
            com.apm.insight.k.a()
            if (r3 == 0) goto L_0x0060
            java.lang.String r1 = "Npth.initAsync-CrashANRHandler"
            com.apm.insight.k.a(r1)
            com.apm.insight.b.g r0 = com.apm.insight.b.g.a(r0)
            r0.c()
            com.apm.insight.k.a()
            c = r3
        L_0x0060:
            java.lang.String r3 = "Npth.initAsync-EventUploadQueue"
            com.apm.insight.k.a(r3)
            com.apm.insight.k.g r3 = com.apm.insight.k.g.a()
            r3.b()
            com.apm.insight.k.a()
            java.lang.String r3 = "Npth.initAsync-BlockMonitor"
            com.apm.insight.k.a(r3)
            com.apm.insight.k.a()
            java.lang.String r3 = "Npth.initAsync-OriginExceptionMonitor"
            com.apm.insight.k.a(r3)
            com.apm.insight.k.a()
            com.apm.insight.nativecrash.NativeImpl.f()
            com.apm.insight.j.a()
            com.apm.insight.k.k.d()
            com.apm.insight.nativecrash.NativeImpl.j()
            java.lang.String r3 = "afterNpthInitAsync"
            java.lang.String r0 = "noValue"
            com.apm.insight.runtime.r.a((java.lang.String) r3, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.h(boolean):void");
    }

    public static boolean h() {
        if (a && !d) {
            boolean a2 = NativeImpl.a(i.g());
            d = a2;
            if (!a2) {
                e = true;
            }
        }
        return d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (a) {
            com.apm.insight.b.g.a(i.g()).d();
            c = false;
        }
    }

    public static boolean k() {
        return com.apm.insight.g.a.b() || NativeImpl.d();
    }

    public static boolean l() {
        return com.apm.insight.g.a.c() || NativeImpl.d();
    }

    public static boolean m() {
        return com.apm.insight.g.a.b();
    }

    public static boolean n() {
        return h;
    }

    public static void o() {
        h = true;
    }

    private static boolean q() {
        return false;
    }
}
