package com.bytedance.sdk.component.adexpress.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.a.c.a;
import com.bytedance.sdk.component.utils.e;
import java.io.File;

/* compiled from: Version */
public class f {
    private static a a;

    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            java.lang.String r0 = "Version"
            java.lang.String r1 = "old version read success: "
            r2 = 0
            java.io.File r3 = com.bytedance.sdk.component.adexpress.a.b.c.f()     // Catch:{ all -> 0x0075 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = "temp_pkg_info.json"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0075 }
            long r5 = r4.length()     // Catch:{ all -> 0x0075 }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0075 }
            long r5 = r3.longValue()     // Catch:{ all -> 0x0075 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x006a
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x006a
            boolean r5 = r4.isFile()     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x006a
            int r3 = r3.intValue()     // Catch:{ all -> 0x0075 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0075 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0075 }
            r5.<init>(r4)     // Catch:{ all -> 0x0075 }
            r5.read(r3)     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "utf-8"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0067 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0067 }
            r3.<init>(r2)     // Catch:{ all -> 0x0067 }
            com.bytedance.sdk.component.adexpress.a.c.a r2 = com.bytedance.sdk.component.adexpress.a.c.a.a((org.json.JSONObject) r3)     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0065
            a = r2     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r2.<init>(r1)     // Catch:{ all -> 0x0067 }
            com.bytedance.sdk.component.adexpress.a.c.a r1 = a     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0067 }
            r2.append(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0067 }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0067 }
        L_0x0065:
            r2 = r5
            goto L_0x006f
        L_0x0067:
            r1 = move-exception
            r2 = r5
            goto L_0x0076
        L_0x006a:
            java.lang.String r1 = "version pkg json file does not exist"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0075 }
        L_0x006f:
            if (r2 == 0) goto L_0x007e
        L_0x0071:
            r2.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x007e
        L_0x0075:
            r1 = move-exception
        L_0x0076:
            java.lang.String r3 = "version init error"
            com.bytedance.sdk.component.utils.l.c(r0, r3, r1)     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x007e
            goto L_0x0071
        L_0x007e:
            return
        L_0x007f:
            r0 = move-exception
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            goto L_0x0087
        L_0x0086:
            throw r0
        L_0x0087:
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.f.a():void");
    }

    public static synchronized a b() {
        a aVar;
        synchronized (f.class) {
            aVar = a;
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (f.class) {
            if (aVar != null) {
                if (aVar.f()) {
                    a = aVar;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[SYNTHETIC, Splitter:B:29:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c() {
        /*
            com.bytedance.sdk.component.adexpress.a.c.a r0 = a
            java.lang.String r1 = "Version"
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "version save error1"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            return
        L_0x000c:
            java.lang.String r0 = r0.g()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x001c
            java.lang.String r0 = "version save error2"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            return
        L_0x001c:
            java.io.File r2 = com.bytedance.sdk.component.adexpress.a.b.c.f()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "temp_pkg_info.json"
            r3.<init>(r2, r4)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r5 = ".tmp"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.<init>(r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x0046
            r2.delete()
        L_0x0046:
            r4 = 0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0068 }
            r5.<init>(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = "utf-8"
            byte[] r0 = r0.getBytes(r4)     // Catch:{ all -> 0x0065 }
            r5.write(r0)     // Catch:{ all -> 0x0065 }
            boolean r0 = r3.exists()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x005e
            r3.delete()     // Catch:{ all -> 0x0065 }
        L_0x005e:
            r2.renameTo(r3)     // Catch:{ all -> 0x0065 }
            r5.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0073
        L_0x0065:
            r0 = move-exception
            r4 = r5
            goto L_0x0069
        L_0x0068:
            r0 = move-exception
        L_0x0069:
            java.lang.String r2 = "version save error3"
            com.bytedance.sdk.component.utils.l.c(r1, r2, r0)     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0073
            r4.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            return
        L_0x0074:
            r0 = move-exception
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ IOException -> 0x007a }
        L_0x007a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.f.c():void");
    }

    public static a.C0043a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().e() != null && b().f()) {
            for (a.C0043a next : b().e()) {
                if (next.a() != null && next.a().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean b(String str) {
        try {
            if (b() != null) {
                if (!TextUtils.isEmpty(b().b())) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    String b = b().b();
                    String[] split = str.split("\\.");
                    String[] split2 = b.split("\\.");
                    int min = Math.min(split.length, split2.length);
                    int i = 0;
                    while (i < min) {
                        int length = split[i].length() - split2[i].length();
                        if (length == 0) {
                            int compareTo = split[i].compareTo(split2[i]);
                            if (compareTo > 0) {
                                return true;
                            }
                            if (compareTo < 0) {
                                return false;
                            }
                            if (i != min - 1) {
                                i++;
                            } else if (split.length > split2.length) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (length > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        a b = b();
        if (b != null) {
            File f = c.f();
            try {
                new File(f, "temp_pkg_info.json").delete();
            } catch (Throwable unused) {
            }
            if (b.e() != null) {
                for (a.C0043a a2 : b.e()) {
                    try {
                        new File(f, e.a(a2.a())).delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
            a = null;
        }
    }
}
