package com.vungle.ads.internal.util;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vungle/ads/internal/util/UnzipUtility;", "", "()V", "BUFFER_SIZE", "", "TAG", "", "kotlin.jvm.PlatformType", "extractFile", "", "zipIn", "Ljava/io/InputStream;", "filePath", "unzip", "", "Ljava/io/File;", "zipFilePath", "destDirectory", "filter", "Lcom/vungle/ads/internal/util/UnzipUtility$Filter;", "validateFilename", "filename", "intendedDir", "Filter", "ZipSecurityException", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UnzipUtility.kt */
public final class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    public static final UnzipUtility INSTANCE = new UnzipUtility();
    private static final String TAG = UnzipUtility.class.getCanonicalName();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/util/UnzipUtility$Filter;", "", "matches", "", "extractPath", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UnzipUtility.kt */
    public interface Filter {
        boolean matches(String str);
    }

    public final List<File> unzip(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str2, "destDirectory");
        return unzip$default(this, str, str2, (Filter) null, 4, (Object) null);
    }

    private UnzipUtility() {
    }

    public static /* synthetic */ List unzip$default(UnzipUtility unzipUtility, String str, String str2, Filter filter, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            filter = null;
        }
        return unzipUtility.unzip(str, str2, filter);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A[SYNTHETIC, Splitter:B:37:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.io.File> unzip(java.lang.String r6, java.lang.String r7, com.vungle.ads.internal.util.UnzipUtility.Filter r8) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "destDirectory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0013
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            if (r0 != 0) goto L_0x00b0
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            if (r6 == 0) goto L_0x00a8
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            boolean r1 = r6.exists()
            if (r1 != 0) goto L_0x002f
            r6.mkdirs()
        L_0x002f:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ all -> 0x00a1 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a1 }
            java.util.Enumeration r0 = r2.entries()     // Catch:{ all -> 0x009e }
        L_0x0040:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x009e }
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r3.<init>()     // Catch:{ all -> 0x009e }
            r3.append(r7)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x009e }
            r3.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = r1.getName()     // Catch:{ all -> 0x009e }
            r3.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x009e }
            if (r8 == 0) goto L_0x006c
            boolean r4 = r8.matches(r3)     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x0040
        L_0x006c:
            r5.validateFilename(r3, r7)     // Catch:{ all -> 0x009e }
            boolean r4 = r1.isDirectory()     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x0084
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x009e }
            r1.<init>(r3)     // Catch:{ all -> 0x009e }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x009e }
            if (r3 != 0) goto L_0x0040
            r1.mkdirs()     // Catch:{ all -> 0x009e }
            goto L_0x0040
        L_0x0084:
            java.io.InputStream r1 = r2.getInputStream(r1)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "zipFile.getInputStream(entry)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ all -> 0x009e }
            r5.extractFile(r1, r3)     // Catch:{ all -> 0x009e }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x009e }
            r1.<init>(r3)     // Catch:{ all -> 0x009e }
            r6.add(r1)     // Catch:{ all -> 0x009e }
            goto L_0x0040
        L_0x009a:
            r2.close()     // Catch:{ IOException -> 0x009d }
        L_0x009d:
            return r6
        L_0x009e:
            r6 = move-exception
            r1 = r2
            goto L_0x00a2
        L_0x00a1:
            r6 = move-exception
        L_0x00a2:
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ IOException -> 0x00a7 }
        L_0x00a7:
            throw r6
        L_0x00a8:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "File does not exist"
            r6.<init>(r7)
            throw r6
        L_0x00b0:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Path is empty"
            r6.<init>(r7)
            goto L_0x00b9
        L_0x00b8:
            throw r6
        L_0x00b9:
            goto L_0x00b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.UnzipUtility.unzip(java.lang.String, java.lang.String, com.vungle.ads.internal.util.UnzipUtility$Filter):java.util.List");
    }

    public final void extractFile(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(inputStream, "zipIn");
        File file = new File(str);
        FileUtility.delete(file);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream2.write(bArr, 0, read);
                        } else {
                            FileUtility.INSTANCE.closeQuietly(inputStream);
                            FileUtility.INSTANCE.closeQuietly(bufferedOutputStream2);
                            FileUtility.INSTANCE.closeQuietly(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    FileUtility.INSTANCE.closeQuietly(inputStream);
                    FileUtility.INSTANCE.closeQuietly(bufferedOutputStream);
                    FileUtility.INSTANCE.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileUtility.INSTANCE.closeQuietly(inputStream);
                FileUtility.INSTANCE.closeQuietly(bufferedOutputStream);
                FileUtility.INSTANCE.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtility.INSTANCE.closeQuietly(inputStream);
            FileUtility.INSTANCE.closeQuietly(bufferedOutputStream);
            FileUtility.INSTANCE.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private final String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalPath2 = new File(str2).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "canonicalPath");
        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "canonicalID");
        if (StringsKt.startsWith$default(canonicalPath, canonicalPath2, false, 2, (Object) null)) {
            return canonicalPath;
        }
        Log.e(TAG, "File is outside extraction target directory.");
        throw new ZipSecurityException("File is outside extraction target directory.");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/util/UnzipUtility$ZipSecurityException;", "Ljava/io/IOException;", "message", "", "(Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UnzipUtility.kt */
    public static final class ZipSecurityException extends IOException {
        public ZipSecurityException(String str) {
            super(str);
        }
    }
}
