package com.umlaut.crowd.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class i9 {
    private static final String a = "i9";
    private static final boolean b = false;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[SYNTHETIC, Splitter:B:15:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[SYNTHETIC, Splitter:B:22:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] a(java.lang.String r5) {
        /*
            java.lang.String r0 = "cat: "
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0031 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0031 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0031 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004b, all -> 0x0031 }
            java.lang.String[] r1 = a((java.io.BufferedInputStream) r3)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r3.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x0064
        L_0x0018:
            r5 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            android.util.Log.d(r2, r5)
            goto L_0x0064
        L_0x002b:
            r5 = move-exception
            r2 = r3
            goto L_0x0032
        L_0x002e:
            r2 = r3
            goto L_0x004c
        L_0x0031:
            r5 = move-exception
        L_0x0032:
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x004a
        L_0x0038:
            r1 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            android.util.Log.d(r2, r0)
        L_0x004a:
            throw r5
        L_0x004b:
        L_0x004c:
            if (r2 == 0) goto L_0x0064
            r2.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0064
        L_0x0052:
            r5 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            android.util.Log.d(r2, r5)
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.i9.a(java.lang.String):java.lang.String[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[SYNTHETIC, Splitter:B:29:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC, Splitter:B:38:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a7 A[SYNTHETIC, Splitter:B:43:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] b(java.lang.String r5) {
        /*
            java.lang.String r0 = "shellResult: "
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x008b, all -> 0x0054 }
            java.lang.Process r5 = r3.exec(r5)     // Catch:{ Exception -> 0x008b, all -> 0x0054 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.String[] r1 = a((java.io.BufferedInputStream) r3)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r3.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0031
        L_0x001f:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.d(r3, r2)
        L_0x0031:
            r5.waitFor()     // Catch:{ InterruptedException -> 0x0036 }
            goto L_0x00bd
        L_0x0036:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            android.util.Log.d(r3, r0)
            goto L_0x00bd
        L_0x004a:
            r1 = move-exception
            r2 = r3
            goto L_0x0057
        L_0x004d:
            r2 = r3
            goto L_0x008d
        L_0x0050:
            r1 = move-exception
            goto L_0x0057
        L_0x0052:
            goto L_0x008d
        L_0x0054:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L_0x0057:
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x006f
        L_0x005d:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.d(r3, r2)
        L_0x006f:
            if (r5 == 0) goto L_0x008a
            r5.waitFor()     // Catch:{ InterruptedException -> 0x0075 }
            goto L_0x0087
        L_0x0075:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            android.util.Log.d(r3, r0)
        L_0x0087:
            r5.destroy()
        L_0x008a:
            throw r1
        L_0x008b:
            r5 = r2
        L_0x008d:
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x00a5
        L_0x0093:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.d(r3, r2)
        L_0x00a5:
            if (r5 == 0) goto L_0x00c0
            r5.waitFor()     // Catch:{ InterruptedException -> 0x00ab }
            goto L_0x00bd
        L_0x00ab:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            android.util.Log.d(r3, r0)
        L_0x00bd:
            r5.destroy()
        L_0x00c0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.i9.b(java.lang.String):java.lang.String[]");
    }

    private static String[] a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString("UTF-8").split("\n");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
