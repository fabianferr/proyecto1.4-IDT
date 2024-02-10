package com.bytedance.sdk.component.utils;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* compiled from: FileUtils */
public class f {
    public static File a(Context context, boolean z, String str, String str2) {
        String b = b(context);
        if (z) {
            str = a(context) + "-" + str;
        }
        if (b != null && !b.endsWith(File.separator)) {
            b = b + File.separator;
        }
        String str3 = b + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File a(Context context, boolean z, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z) {
            str = a(context) + "-" + str;
        }
        if (absolutePath != null && !absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String b(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a((AnonymousClass1) null));
        return asList;
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            l.e("splashLoadAd", "update file modify time");
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                e(file);
                if (file.lastModified() < currentTimeMillis) {
                    l.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void c(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            c(file2);
                        } else {
                            try {
                                file2.delete();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(java.io.File r6) throws java.io.IOException {
        /*
            long r0 = r6.length()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000e
            f(r6)
            return
        L_0x000e:
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x002d }
            java.lang.String r4 = "rwd"
            r3.<init>(r6, r4)     // Catch:{ all -> 0x002d }
            r4 = 1
            long r0 = r0 - r4
            r3.seek(r0)     // Catch:{ all -> 0x002a }
            byte r6 = r3.readByte()     // Catch:{ all -> 0x002a }
            r3.seek(r0)     // Catch:{ all -> 0x002a }
            r3.write(r6)     // Catch:{ all -> 0x002a }
            r3.close()
            goto L_0x0033
        L_0x002a:
            r2 = r3
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.e(java.io.File):void");
    }

    private static void f(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    /* compiled from: FileUtils */
    private static final class a implements Comparator<File> {
        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        if (r2 != null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] d(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x004e
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L_0x004e
            boolean r1 = r7.exists()
            if (r1 == 0) goto L_0x004e
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L_0x004e
            long r1 = r7.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            long r1 = r7.length()     // Catch:{ all -> 0x0049 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0049 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0049 }
            r2.<init>(r7)     // Catch:{ all -> 0x0049 }
            int r7 = r1.intValue()     // Catch:{ all -> 0x0047 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0047 }
            int r3 = r2.read(r7)     // Catch:{ all -> 0x0047 }
            long r3 = (long) r3     // Catch:{ all -> 0x0047 }
            long r5 = r1.longValue()     // Catch:{ all -> 0x0047 }
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0043
            r2.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            return r7
        L_0x0043:
            r2.close()     // Catch:{ all -> 0x004e }
            goto L_0x004e
        L_0x0047:
            goto L_0x004b
        L_0x0049:
            r2 = r0
        L_0x004b:
            if (r2 == 0) goto L_0x004e
            goto L_0x0043
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.d(java.io.File):byte[]");
    }

    /* renamed from: com.bytedance.sdk.component.utils.f$1  reason: invalid class name */
    /* compiled from: FileUtils */
    static class AnonymousClass1 implements Comparator<File> {
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file2.lastModified() - file.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            return lastModified < 0 ? -1 : 1;
        }
    }

    public static String a(Context context) {
        String a2 = r.a(context);
        return a2.contains(CertificateUtil.DELIMITER) ? a2.replace(CertificateUtil.DELIMITER, "-") : a2;
    }
}
