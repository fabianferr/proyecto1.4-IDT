package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.mbridge.msdk.foundation.same.b.b;
import com.mbridge.msdk.foundation.same.b.d;
import com.mbridge.msdk.foundation.same.b.e;
import java.io.File;
import java.util.UUID;

/* compiled from: SameSDCardTool */
public final class ad {
    static boolean a = false;
    static String b = "";
    public static char[] c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};
    private static boolean d = false;
    private static int e = -1;
    private static int f = -1;
    private static int g = -1;
    private static int h = -1;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2) {
        /*
            boolean r0 = d
            if (r0 != 0) goto L_0x0047
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
            r0.<init>()     // Catch:{ Exception -> 0x0026 }
            java.io.File r1 = r2.getFilesDir()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0026 }
            r0.append(r1)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0026 }
            r0.append(r1)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0026 }
            b = r0     // Catch:{ Exception -> 0x0026 }
            r0 = 0
            a = r0     // Catch:{ Exception -> 0x0026 }
            b(r2)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0044
        L_0x0026:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r0.<init>()     // Catch:{ Exception -> 0x0044 }
            java.io.File r1 = r2.getFilesDir()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0044 }
            r0.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0044 }
            r0.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0044 }
            b = r0     // Catch:{ Exception -> 0x0044 }
            b(r2)     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            r2 = 1
            d = r2
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.a(android.content.Context):void");
    }

    private static void b(Context context) {
        e.a((b) new d(c(context)));
        e.a().b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        if ((d() > 31457280) == false) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r7) {
        /*
            r0 = 0
            java.io.File r1 = r7.getExternalFilesDir(r0)     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0014
            java.io.File r1 = a((java.io.File) r1)     // Catch:{ all -> 0x000c }
            goto L_0x0015
        L_0x000c:
            r1 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.mbridge.msdk.foundation.tools.aa.b(r2, r3, r1)
        L_0x0014:
            r1 = r0
        L_0x0015:
            boolean r2 = a
            if (r2 == 0) goto L_0x0069
            if (r1 != 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "Android"
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "data"
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = r7.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.io.File r1 = a((java.io.File) r2)
        L_0x0058:
            long r2 = d()
            r4 = 31457280(0x1e00000, double:1.55419614E-316)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0065
            r2 = 1
            goto L_0x0066
        L_0x0065:
            r2 = 0
        L_0x0066:
            if (r2 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            if (r0 == 0) goto L_0x0072
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x007a
        L_0x0072:
            java.io.File r7 = r7.getFilesDir()
            java.io.File r0 = r7.getAbsoluteFile()
        L_0x007a:
            java.lang.String r7 = r0.getAbsolutePath()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.c(android.content.Context):java.lang.String");
    }

    private static File a(File file) {
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    private static boolean c() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            aa.d("", "hasSDCard is failed");
            return false;
        }
    }

    public static int a() {
        try {
            Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
            long longValue = ((Long) ai.b(g2, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f == -1) {
                f = Long.valueOf((d() / 1000) / 1000).intValue();
                ai.a(g2, "freeExternalSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            aa.b("SameSDCardTool", th.getMessage(), th);
        }
        return f;
    }

    private static long d() {
        if (c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static int b() {
        if (e == -1) {
            try {
                e = new Long((e() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                aa.b("SameSDCardTool", th.getMessage(), th);
            }
        }
        return e;
    }

    private static long e() {
        if (c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }
}
