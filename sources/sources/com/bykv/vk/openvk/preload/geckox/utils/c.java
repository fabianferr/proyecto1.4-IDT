package com.bykv.vk.openvk.preload.geckox.utils;

import android.os.Process;
import com.bykv.vk.openvk.preload.geckox.h.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileUtils */
public final class c {
    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        b.a("gecko-debug-tag", "delete file，pid:", Integer.valueOf(Process.myPid()), ", thread:", Thread.currentThread().toString(), ", file:" + file.getAbsolutePath());
        return c(file);
    }

    private static boolean c(File file) {
        boolean z;
        File[] listFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            z = true;
        } else {
            z = true;
            for (File c : listFiles) {
                z = z && c(c);
            }
        }
        if (!z || !file.delete()) {
            return false;
        }
        return true;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                return;
            }
        }
    }

    public static boolean b(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!b(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A[SYNTHETIC, Splitter:B:20:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0033 A[SYNTHETIC, Splitter:B:24:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r4) {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0029 }
            r1.<init>()     // Catch:{ all -> 0x0029 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0029 }
            r3.<init>(r4)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ all -> 0x0029 }
        L_0x0010:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x001a
            r1.append(r3)     // Catch:{ all -> 0x002a }
            goto L_0x0010
        L_0x001a:
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x002a }
            r2.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0023
        L_0x0022:
        L_0x0023:
            if (r4 == 0) goto L_0x0028
            r4.close()     // Catch:{ all -> 0x0028 }
        L_0x0028:
            return r0
        L_0x0029:
            r2 = r0
        L_0x002a:
            if (r2 == 0) goto L_0x0031
            r2.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0031
        L_0x0030:
        L_0x0031:
            if (r4 == 0) goto L_0x0036
            r4.close()     // Catch:{ all -> 0x0036 }
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.utils.c.a(java.io.InputStream):java.lang.String");
    }
}
