package com.umlaut.crowd.internal;

import android.content.Context;
import com.umlaut.crowd.CCS;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class sc {
    private static final String a = "sc";
    private static final boolean b = false;
    private static final String c = "truststore.bin";
    private static final String d = "truststore.bin.sig";
    private static final int e = 10000;

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00ce */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r7) {
        /*
            r0 = 0
            com.umlaut.crowd.IC r1 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ IOException -> 0x00ce }
            java.lang.String r1 = r1.e0()     // Catch:{ IOException -> 0x00ce }
            java.lang.String r2 = "[PROJECTID]"
            com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ IOException -> 0x00ce }
            java.lang.String r3 = r3.f1()     // Catch:{ IOException -> 0x00ce }
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ IOException -> 0x00ce }
            com.umlaut.crowd.IC r2 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ IOException -> 0x00ce }
            boolean r2 = r2.v0()     // Catch:{ IOException -> 0x00ce }
            r3 = 10000(0x2710, float:1.4013E-41)
            java.net.HttpURLConnection r0 = com.umlaut.crowd.internal.j3.a((java.lang.String) r1, (int) r3, (boolean) r2)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ IOException -> 0x00ce }
            r0.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00ce }
            r0.setReadTimeout(r3)     // Catch:{ IOException -> 0x00ce }
            com.umlaut.crowd.IS r1 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ IOException -> 0x00ce }
            long r1 = r1.I()     // Catch:{ IOException -> 0x00ce }
            java.lang.String r1 = com.umlaut.crowd.internal.i1.b((long) r1)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r2 = "If-Modified-Since"
            r0.setRequestProperty(r2, r1)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r1 = "Connection"
            java.lang.String r2 = "close"
            r0.setRequestProperty(r1, r2)     // Catch:{ IOException -> 0x00ce }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x00ce }
            r2 = 304(0x130, float:4.26E-43)
            if (r1 != r2) goto L_0x005c
            com.umlaut.crowd.IS r1 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ IOException -> 0x00ce }
            long r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ IOException -> 0x00ce }
            r1.h((long) r2)     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d3
        L_0x005c:
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x00ce }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x00d3
            long r1 = r0.getLastModified()     // Catch:{ IOException -> 0x00ce }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x00ce }
            java.io.File r4 = e(r7)     // Catch:{ all -> 0x00c7 }
            a((java.io.InputStream) r3, (java.io.File) r4)     // Catch:{ all -> 0x00c7 }
            r3.close()     // Catch:{ IOException -> 0x00ce }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00ce }
            java.io.File r4 = e(r7)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r5 = "truststore.bin"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x00ce }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00ce }
            java.io.File r5 = e(r7)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r6 = "truststore.bin.sig"
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00ce }
            boolean r3 = a((java.io.File) r3, (java.io.File) r4)     // Catch:{ IOException -> 0x00ce }
            if (r3 == 0) goto L_0x00bf
            boolean r3 = f(r7)     // Catch:{ IOException -> 0x00ce }
            if (r3 == 0) goto L_0x00b7
            boolean r3 = g(r7)     // Catch:{ IOException -> 0x00ce }
            if (r3 == 0) goto L_0x00b7
            com.umlaut.crowd.IS r3 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ IOException -> 0x00ce }
            long r4 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ IOException -> 0x00ce }
            r3.h((long) r4)     // Catch:{ IOException -> 0x00ce }
            com.umlaut.crowd.IS r3 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ IOException -> 0x00ce }
            r3.l((long) r1)     // Catch:{ IOException -> 0x00ce }
            r0.disconnect()
            r7 = 1
            return r7
        L_0x00b7:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x00ce }
            java.lang.String r2 = "Moving of cached files failed."
            r1.<init>(r2)     // Catch:{ IOException -> 0x00ce }
            throw r1     // Catch:{ IOException -> 0x00ce }
        L_0x00bf:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x00ce }
            java.lang.String r2 = "Verification of downloaded truststore failed"
            r1.<init>(r2)     // Catch:{ IOException -> 0x00ce }
            throw r1     // Catch:{ IOException -> 0x00ce }
        L_0x00c7:
            r1 = move-exception
            r3.close()     // Catch:{ IOException -> 0x00ce }
            throw r1     // Catch:{ IOException -> 0x00ce }
        L_0x00cc:
            r7 = move-exception
            goto L_0x00d8
        L_0x00ce:
            b(r7)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00d6
        L_0x00d3:
            r0.disconnect()
        L_0x00d6:
            r7 = 0
            return r7
        L_0x00d8:
            if (r0 == 0) goto L_0x00dd
            r0.disconnect()
        L_0x00dd:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.sc.a(android.content.Context):boolean");
    }

    private static void b(Context context) {
        File file = new File(e(context), c);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(e(context), d);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public static File c(Context context) {
        File file = new File(context.getFilesDir() + CCS.c);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, c);
    }

    public static File d(Context context) {
        File file = new File(context.getFilesDir() + CCS.c);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, d);
    }

    private static File e(Context context) {
        File file = new File(context.getCacheDir() + CCS.c, "truststoreunzip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static boolean f(Context context) throws IOException {
        return new File(e(context), c).renameTo(c(context));
    }

    private static boolean g(Context context) throws IOException {
        return new File(e(context), d).renameTo(d(context));
    }

    private static void a(InputStream inputStream, File file) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    return;
                }
                if (nextEntry.isDirectory()) {
                    File file2 = new File(file, nextEntry.getName());
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        throw new IOException("Incorrect directory path detected");
                    } else if (!file2.isDirectory()) {
                        file2.mkdirs();
                    }
                } else {
                    File file3 = new File(file, nextEntry.getName());
                    if (file3.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        while (true) {
                            int read = zipInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(read);
                        }
                        zipInputStream.closeEntry();
                        fileOutputStream.close();
                    } else {
                        throw new IOException("Incorrect file path detected");
                    }
                }
            } finally {
                zipInputStream.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007a A[SYNTHETIC, Splitter:B:34:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[SYNTHETIC, Splitter:B:39:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091 A[SYNTHETIC, Splitter:B:47:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b A[SYNTHETIC, Splitter:B:52:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r6, java.io.File r7) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008d, all -> 0x0076 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x008d, all -> 0x0076 }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            r7.<init>()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            r3 = 512(0x200, float:7.175E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            int r4 = r2.read(r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
        L_0x0014:
            r5 = -1
            if (r4 == r5) goto L_0x001f
            r7.write(r3, r0, r4)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            int r4 = r2.read(r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            goto L_0x0014
        L_0x001f:
            r7.flush()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            byte[] r7 = r7.toByteArray()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r6.<init>()     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            int r1 = r4.read(r3)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
        L_0x0034:
            if (r1 == r5) goto L_0x003e
            r6.write(r3, r0, r1)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            int r1 = r4.read(r3)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            goto L_0x0034
        L_0x003e:
            r6.flush()     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            byte[] r6 = r6.toByteArray()     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            java.lang.String r1 = "SHA256withRSA"
            java.security.Signature r1 = java.security.Signature.getInstance(r1)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            java.security.PublicKey r3 = com.umlaut.crowd.InsightCore.getPublicKey()     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r1.initVerify(r3)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r1.update(r6)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            boolean r6 = r1.verify(r7)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r2.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0061:
            r4.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0069:
            return r6
        L_0x006a:
            r6 = move-exception
            goto L_0x0070
        L_0x006c:
            goto L_0x0074
        L_0x006e:
            r6 = move-exception
            r4 = r1
        L_0x0070:
            r1 = r2
            goto L_0x0078
        L_0x0072:
            r4 = r1
        L_0x0074:
            r1 = r2
            goto L_0x008f
        L_0x0076:
            r6 = move-exception
            r4 = r1
        L_0x0078:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0082:
            if (r4 == 0) goto L_0x008c
            r4.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008c:
            throw r6
        L_0x008d:
            r4 = r1
        L_0x008f:
            if (r1 == 0) goto L_0x0099
            r1.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0099:
            if (r4 == 0) goto L_0x00a3
            r4.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.sc.a(java.io.File, java.io.File):boolean");
    }
}
