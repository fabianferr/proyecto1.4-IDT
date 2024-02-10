package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RomUtils */
public class t {
    public static boolean a = false;
    public static boolean b = false;
    private static final CharSequence c = "amigo";
    private static final CharSequence d = "funtouch";
    private static String e = null;
    private static int f = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, String> g = new ConcurrentHashMap<>();

    public static String a() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String a2 = h.a("sdk_local_rom_info", 604800000);
        e = a2;
        if (TextUtils.isEmpty(a2)) {
            String v = v();
            e = v;
            h.a("sdk_local_rom_info", v);
        }
        return e;
    }

    private static String v() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (g()) {
            return f();
        }
        if (h()) {
            return i();
        }
        if (d()) {
            return c();
        }
        String j = j();
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return Build.DISPLAY;
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    a = true;
                    b = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            b = true;
        }
        return a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(d);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(c);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (!k()) {
            return "";
        }
        return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (!e()) {
            return "";
        }
        return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                String d2 = d("ro.smartisan.version");
                return "smartisan_" + d2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        if (f == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String g2 = ac.g("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(g2)) {
                f = 0;
            } else {
                f = 1;
            }
        }
        if (f == 1) {
            return true;
        }
        return false;
    }

    public static String s() {
        if (!r()) {
            return "";
        }
        String g2 = ac.g("ro.build.version.kllkrom");
        return "coloros_" + d(g2) + "_" + Build.DISPLAY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (android.os.Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean t() {
        /*
            r0 = 0
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "huawei"
            if (r1 != 0) goto L_0x0017
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002b
        L_0x0017:
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.t.t():boolean");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Process} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[SYNTHETIC, Splitter:B:21:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A[SYNTHETIC, Splitter:B:39:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r9) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "ToolUtils"
            java.lang.String r2 = "Unable to read sysprop "
            java.lang.String r3 = "getprop "
            java.lang.String r4 = ""
            r5 = 0
            java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            r7.<init>(r3)     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            r7.append(r9)     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            java.lang.String r3 = r7.toString()     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            java.lang.Process r3 = r6.exec(r3)     // Catch:{ IllegalThreadStateException -> 0x006c, all -> 0x0045 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IllegalThreadStateException -> 0x0042, all -> 0x0045 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IllegalThreadStateException -> 0x0042, all -> 0x0045 }
            java.io.InputStream r8 = r3.getInputStream()     // Catch:{ IllegalThreadStateException -> 0x0042, all -> 0x0045 }
            r7.<init>(r8)     // Catch:{ IllegalThreadStateException -> 0x0042, all -> 0x0045 }
            r8 = 1024(0x400, float:1.435E-42)
            r6.<init>(r7, r8)     // Catch:{ IllegalThreadStateException -> 0x0042, all -> 0x0045 }
            java.lang.String r4 = r6.readLine()     // Catch:{ IllegalThreadStateException -> 0x0043, all -> 0x003f }
            r3.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0043, all -> 0x003f }
            r6.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0077
        L_0x003a:
            r9 = move-exception
            com.bytedance.sdk.component.utils.l.c(r1, r0, r9)
            goto L_0x0077
        L_0x003f:
            r3 = move-exception
            r5 = r6
            goto L_0x0046
        L_0x0042:
            r6 = r5
        L_0x0043:
            r5 = r3
            goto L_0x006d
        L_0x0045:
            r3 = move-exception
        L_0x0046:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r6.<init>(r2)     // Catch:{ all -> 0x0060 }
            r6.append(r9)     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0060 }
            com.bytedance.sdk.component.utils.l.c(r1, r9, r3)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r9 = move-exception
            com.bytedance.sdk.component.utils.l.c(r1, r0, r9)
        L_0x005f:
            return r4
        L_0x0060:
            r9 = move-exception
            if (r5 == 0) goto L_0x006b
            r5.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r2 = move-exception
            com.bytedance.sdk.component.utils.l.c(r1, r0, r2)
        L_0x006b:
            throw r9
        L_0x006c:
            r6 = r5
        L_0x006d:
            r5.destroy()     // Catch:{ all -> 0x0071 }
            goto L_0x0072
        L_0x0071:
        L_0x0072:
            if (r6 == 0) goto L_0x0077
            r6.close()     // Catch:{ IOException -> 0x003a }
        L_0x0077:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.t.c(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.String r3 = "getSystemPropertyTask() called with: propName = ["
            r1[r2] = r3
            r2 = 1
            r1[r2] = r4
            java.lang.String r2 = "]"
            r3 = 2
            r1[r3] = r2
            java.lang.String r2 = "RomUtils"
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r2, (java.lang.Object[]) r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = g
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0022
            return r1
        L_0x0022:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0049
            com.bytedance.sdk.openadsdk.utils.t$a r1 = new com.bytedance.sdk.openadsdk.utils.t$a     // Catch:{ all -> 0x0048 }
            r1.<init>(r4)     // Catch:{ all -> 0x0048 }
            com.bytedance.sdk.component.g.g r4 = new com.bytedance.sdk.component.g.g     // Catch:{ all -> 0x0048 }
            r2 = 5
            r4.<init>(r1, r2, r3)     // Catch:{ all -> 0x0048 }
            com.bytedance.sdk.openadsdk.utils.t$1 r1 = new com.bytedance.sdk.openadsdk.utils.t$1     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "_getSystemPropertyTask"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0048 }
            com.bytedance.sdk.openadsdk.utils.aa.b(r1)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0048 }
            r2 = 1
            java.lang.Object r4 = r4.get(r2, r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0048:
        L_0x0049:
            r4 = r0
        L_0x004a:
            if (r4 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r0 = r4
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.t.d(java.lang.String):java.lang.String");
    }

    /* compiled from: RomUtils */
    public static class a implements Callable<String> {
        private final String a;

        public a(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public String call() throws Exception {
            String str = (String) t.g.get(this.a);
            if (str != null) {
                return str;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String b = t.c(this.a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            l.b("RomUtils", "property:" + b + ", use time :" + currentTimeMillis2);
            if (b != null) {
                t.g.put(this.a, b);
            }
            return b;
        }
    }
}
