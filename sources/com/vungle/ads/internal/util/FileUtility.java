package com.vungle.ads.internal.util;

import android.os.Build;
import android.util.Log;
import android.webkit.URLUtil;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0019H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0019H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0012\u0010'\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0007J&\u0010'\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020 2\n\u0010(\u001a\u00060)j\u0002`*H\u0002J$\u0010+\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\n\u0010(\u001a\u00060)j\u0002`*H\u0002J\u001d\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u0010\u001b\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u001a\u00101\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000103H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Lcom/vungle/ads/internal/util/FileUtility;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "allowedClasses", "", "Ljava/lang/Class;", "getAllowedClasses$vungle_ads_release$annotations", "getAllowedClasses$vungle_ads_release", "()Ljava/util/List;", "<set-?>", "Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "objectInputStreamProvider", "getObjectInputStreamProvider", "()Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "setObjectInputStreamProvider", "(Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;)V", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "delete", "f", "Ljava/io/File;", "deleteAndLogIfFailed", "file", "deleteContents", "folder", "getIndentString", "indent", "", "guessFileName", "url", "ext", "isValidUrl", "", "httpUrl", "printDirectoryTree", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "printFile", "readSerializable", "T", "(Ljava/io/File;)Ljava/lang/Object;", "size", "", "writeSerializable", "serializable", "Ljava/io/Serializable;", "ObjectInputStreamProvider", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileUtility.kt */
public final class FileUtility {
    public static final FileUtility INSTANCE = new FileUtility();
    private static final String TAG = "FileUtility";
    private static final List<Class<?>> allowedClasses = CollectionsKt.listOf(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);
    private static ObjectInputStreamProvider objectInputStreamProvider = new FileUtility$$ExternalSyntheticLambda0();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "", "provideObjectInputStream", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FileUtility.kt */
    public interface ObjectInputStreamProvider {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }

    @JvmStatic
    public static final void printDirectoryTree(File file) {
    }

    private FileUtility() {
    }

    public final ObjectInputStreamProvider getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    public final void setObjectInputStreamProvider(ObjectInputStreamProvider objectInputStreamProvider2) {
        Intrinsics.checkNotNullParameter(objectInputStreamProvider2, "<set-?>");
        objectInputStreamProvider = objectInputStreamProvider2;
    }

    /* access modifiers changed from: private */
    /* renamed from: objectInputStreamProvider$lambda-0  reason: not valid java name */
    public static final ObjectInputStream m2333objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new SafeObjectInputStream(inputStream, allowedClasses);
    }

    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    private final void printDirectoryTree(File file, int i, StringBuilder sb) {
        if (file != null) {
            if (file.isDirectory()) {
                sb.append(getIndentString(i));
                sb.append("+--");
                sb.append(file.getName());
                sb.append("/\n");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            printDirectoryTree(file2, i + 1, sb);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(file2, ShareInternalUtility.STAGING_PARAM);
                            printFile(file2, i + 1, sb);
                        }
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("folder is not a Directory".toString());
        }
    }

    private final void printFile(File file, int i, StringBuilder sb) {
        sb.append(getIndentString(i));
        sb.append("+--");
        sb.append(file.getName());
        sb.append(10);
    }

    private final String getIndentString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("|  ");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @JvmStatic
    public static final void delete(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                deleteContents(file);
            }
            if (!file.delete()) {
                String str = TAG;
                Log.d(str, "Failed to delete file: " + file);
            }
        }
    }

    @JvmStatic
    public static final void deleteContents(File file) {
        Intrinsics.checkNotNullParameter(file, "folder");
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete(delete);
            }
        }
    }

    @JvmStatic
    public static final void deleteAndLogIfFailed(File file) {
        Intrinsics.checkNotNullParameter(file, ShareInternalUtility.STAGING_PARAM);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else if (!file.delete()) {
                String str = TAG;
                Log.e(str, "Cannot delete " + file.getName());
            }
        } catch (IOException e) {
            String str2 = TAG;
            Log.e(str2, "Cannot delete " + file.getName(), e);
        }
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final void writeSerializable(File file, Serializable serializable) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(file, ShareInternalUtility.STAGING_PARAM);
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        objectOutputStream2.reset();
                        FileUtility fileUtility = INSTANCE;
                        fileUtility.closeQuietly(objectOutputStream2);
                        fileUtility.closeQuietly(fileOutputStream);
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        try {
                            Log.e(TAG, "IOIOException", e);
                            FileUtility fileUtility2 = INSTANCE;
                            fileUtility2.closeQuietly(objectOutputStream);
                            fileUtility2.closeQuietly(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            FileUtility fileUtility3 = INSTANCE;
                            fileUtility3.closeQuietly(objectOutputStream);
                            fileUtility3.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        FileUtility fileUtility32 = INSTANCE;
                        fileUtility32.closeQuietly(objectOutputStream);
                        fileUtility32.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, "IOIOException", e);
                    FileUtility fileUtility22 = INSTANCE;
                    fileUtility22.closeQuietly(objectOutputStream);
                    fileUtility22.closeQuietly(fileOutputStream);
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                Log.e(TAG, "IOIOException", e);
                FileUtility fileUtility222 = INSTANCE;
                fileUtility222.closeQuietly(objectOutputStream);
                fileUtility222.closeQuietly(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                FileUtility fileUtility322 = INSTANCE;
                fileUtility322.closeQuietly(objectOutputStream);
                fileUtility322.closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T readSerializable(java.io.File r6) {
        /*
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x004d, Exception -> 0x0040, all -> 0x003d }
            r0.<init>(r6)     // Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x004d, Exception -> 0x0040, all -> 0x003d }
            com.vungle.ads.internal.util.FileUtility r2 = INSTANCE     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, Exception -> 0x0034, all -> 0x0032 }
            com.vungle.ads.internal.util.FileUtility$ObjectInputStreamProvider r3 = objectInputStreamProvider     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, Exception -> 0x0034, all -> 0x0032 }
            r4 = r0
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, Exception -> 0x0034, all -> 0x0032 }
            java.io.ObjectInputStream r3 = r3.provideObjectInputStream(r4)     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, Exception -> 0x0034, all -> 0x0032 }
            java.lang.Object r6 = r3.readObject()     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e, Exception -> 0x002c }
            java.io.Closeable r3 = (java.io.Closeable) r3
            r2.closeQuietly(r3)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2.closeQuietly(r0)
            return r6
        L_0x002c:
            r2 = move-exception
            goto L_0x0043
        L_0x002e:
            r2 = move-exception
            goto L_0x0050
        L_0x0030:
            r2 = move-exception
            goto L_0x005d
        L_0x0032:
            r6 = move-exception
            goto L_0x0078
        L_0x0034:
            r2 = move-exception
            r3 = r1
            goto L_0x0043
        L_0x0037:
            r2 = move-exception
            r3 = r1
            goto L_0x0050
        L_0x003a:
            r2 = move-exception
            r3 = r1
            goto L_0x005d
        L_0x003d:
            r6 = move-exception
            r0 = r1
            goto L_0x0078
        L_0x0040:
            r2 = move-exception
            r0 = r1
            r3 = r0
        L_0x0043:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "cannot read serializable"
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0076 }
            android.util.Log.e(r4, r5, r2)     // Catch:{ all -> 0x0076 }
            goto L_0x0066
        L_0x004d:
            r2 = move-exception
            r0 = r1
            r3 = r0
        L_0x0050:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "ClassNotFoundException"
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0076 }
            android.util.Log.e(r4, r5, r2)     // Catch:{ all -> 0x0076 }
            goto L_0x0066
        L_0x005a:
            r2 = move-exception
            r0 = r1
            r3 = r0
        L_0x005d:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "IOIOException"
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0076 }
            android.util.Log.e(r4, r5, r2)     // Catch:{ all -> 0x0076 }
        L_0x0066:
            com.vungle.ads.internal.util.FileUtility r2 = INSTANCE
            java.io.Closeable r3 = (java.io.Closeable) r3
            r2.closeQuietly(r3)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2.closeQuietly(r0)
            delete(r6)     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            return r1
        L_0x0076:
            r6 = move-exception
            r1 = r3
        L_0x0078:
            com.vungle.ads.internal.util.FileUtility r2 = INSTANCE
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2.closeQuietly(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2.closeQuietly(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.FileUtility.readSerializable(java.io.File):java.lang.Object");
    }

    public final boolean isValidUrl(String str) {
        CharSequence charSequence = str;
        return !(charSequence == null || charSequence.length() == 0) && HttpUrl.Companion.parse(str) != null;
    }

    public final long size(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (!(listFiles.length == 0)) {
                for (File size : listFiles) {
                    j += size(size);
                }
            }
        }
        return j;
    }

    public final String guessFileName(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        String guessFileName = URLUtil.guessFileName(str, (String) null, str2);
        Intrinsics.checkNotNullExpressionValue(guessFileName, "guessFileName(url, null, ext)");
        return guessFileName;
    }
}
