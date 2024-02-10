package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: UnZipUtils */
public final class k {
    private static byte[] a = {80, 75, 3, 4};
    private static byte[] b = {80, 75, 5, 6};

    /* JADX WARNING: type inference failed for: r4v5, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x00ad, all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d5 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.InputStream r8, java.lang.String r9, java.lang.String r10) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x010a }
            r1.<init>(r9)     // Catch:{ all -> 0x010a }
            java.lang.String r9 = r1.getCanonicalPath()     // Catch:{ all -> 0x010a }
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x010a }
            r1.<init>(r8)     // Catch:{ all -> 0x010a }
            r2 = 0
            r3 = 0
        L_0x0011:
            java.util.zip.ZipEntry r4 = r1.getNextEntry()     // Catch:{ all -> 0x0107 }
            if (r4 == 0) goto L_0x00d8
            java.lang.String r3 = r4.getName()     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = "__MACOSX/"
            boolean r5 = r3.startsWith(r5)     // Catch:{ all -> 0x0107 }
            r6 = 1
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = ".DS_Store"
            boolean r5 = r3.equals(r5)     // Catch:{ all -> 0x0107 }
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = "../"
            boolean r5 = r3.contains(r5)     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r5 = 0
            goto L_0x0038
        L_0x0037:
            r5 = 1
        L_0x0038:
            if (r5 != 0) goto L_0x00d5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>()     // Catch:{ all -> 0x0107 }
            r5.append(r10)     // Catch:{ all -> 0x0107 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ all -> 0x0107 }
            r5.append(r7)     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0107 }
            boolean r5 = r3.startsWith(r5)     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x00c5
            boolean r4 = r4.isDirectory()     // Catch:{ all -> 0x0107 }
            if (r4 == 0) goto L_0x0086
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0107 }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = r4.getCanonicalPath()     // Catch:{ all -> 0x0107 }
            boolean r5 = r5.startsWith(r9)     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x006a
            r4.mkdirs()     // Catch:{ all -> 0x0107 }
            goto L_0x00d5
        L_0x006a:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            java.lang.String r0 = "directory traversal, dir:"
            r9.<init>(r0)     // Catch:{ all -> 0x0107 }
            r9.append(r3)     // Catch:{ all -> 0x0107 }
            java.lang.String r0 = ", channel:"
            r9.append(r0)     // Catch:{ all -> 0x0107 }
            r9.append(r10)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0107 }
            r8.<init>(r9)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x0086:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0107 }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0107 }
            boolean r5 = r4.startsWith(r9)     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x00b5
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0107 }
            r3.<init>(r4)     // Catch:{ all -> 0x0107 }
            java.io.File r4 = r3.getParentFile()     // Catch:{ all -> 0x0107 }
            r4.mkdirs()     // Catch:{ all -> 0x0107 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b0 }
            r4.<init>(r3)     // Catch:{ all -> 0x00b0 }
            com.bykv.vk.openvk.preload.geckox.utils.c.a(r1, r4)     // Catch:{ all -> 0x00ad }
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r4)     // Catch:{ all -> 0x0107 }
            goto L_0x00d5
        L_0x00ad:
            r8 = move-exception
            r0 = r4
            goto L_0x00b1
        L_0x00b0:
            r8 = move-exception
        L_0x00b1:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r0)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x00b5:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = "directory traversal, file name:"
            java.lang.String r10 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.concat(r10)     // Catch:{ all -> 0x0107 }
            r8.<init>(r9)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x00c5:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = "the zip package outermost folder is not named by channel channel:"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.concat(r10)     // Catch:{ all -> 0x0107 }
            r8.<init>(r9)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x00d5:
            r3 = 1
            goto L_0x0011
        L_0x00d8:
            if (r3 != 0) goto L_0x0103
            r8.reset()     // Catch:{ all -> 0x0107 }
            boolean r8 = a(r8)     // Catch:{ all -> 0x0107 }
            if (r8 != 0) goto L_0x00f3
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = "not zip file  channel:"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.concat(r10)     // Catch:{ all -> 0x0107 }
            r8.<init>(r9)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x00f3:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = "unzip file: channel:"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.concat(r10)     // Catch:{ all -> 0x0107 }
            r8.<init>(r9)     // Catch:{ all -> 0x0107 }
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x0103:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r1)
            return
        L_0x0107:
            r8 = move-exception
            r0 = r1
            goto L_0x010b
        L_0x010a:
            r8 = move-exception
        L_0x010b:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r0)
            goto L_0x0110
        L_0x010f:
            throw r8
        L_0x0110:
            goto L_0x010f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.utils.k.a(java.io.InputStream, java.lang.String, java.lang.String):void");
    }

    private static boolean a(InputStream inputStream) throws Exception {
        try {
            byte[] bArr = new byte[4];
            boolean z = false;
            if (inputStream.read(bArr, 0, 4) == 4) {
                if (Arrays.equals(a, bArr) || Arrays.equals(b, bArr)) {
                    z = true;
                }
                return z;
            }
            CloseableUtils.close((Closeable) inputStream);
            return false;
        } finally {
            CloseableUtils.close((Closeable) inputStream);
        }
    }
}
