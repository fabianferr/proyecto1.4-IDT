package com.m2catalyst.m2sdk.logger;

import com.facebook.share.internal.ShareInternalUtility;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/ZipUtils;", "", "outputDirectory", "Ljava/io/File;", "zipFileName", "", "(Ljava/io/File;Ljava/lang/String;)V", "compress", "", "file", "deleteBadZipFiles", "", "directory", "getMaxIterationCount", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZipUtils.kt */
public final class ZipUtils {
    private final File outputDirectory;
    private final String zipFileName;

    public ZipUtils(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "outputDirectory");
        Intrinsics.checkNotNullParameter(str, "zipFileName");
        this.outputDirectory = file;
        this.zipFileName = str;
    }

    private final void deleteBadZipFiles(File file) {
        File[] listFiles;
        try {
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new ZipUtils$$ExternalSyntheticLambda0())) != null) {
                if (!(listFiles.length == 0)) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "zipFile.name");
                        if (StringsKt.split$default((CharSequence) name, new String[]{".zip"}, false, 0, 6, (Object) null).size() >= 3) {
                            String name2 = file2.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "zipFile.name");
                            if (StringsKt.contains$default((CharSequence) name2, (CharSequence) "temp", false, 2, (Object) null)) {
                                file2.delete();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            M2SDKLogger.Companion.e("ZipUtils", "Delete bad log files crashed: " + th.getMessage(), new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean deleteBadZipFiles$lambda$8(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return StringsKt.endsWith$default(str, ".zip", false, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r0.isDebug() == true) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int getMaxIterationCount() {
        /*
            r2 = this;
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.j
            if (r0 != 0) goto L_0x000b
            com.m2catalyst.m2sdk.r2 r0 = new com.m2catalyst.m2sdk.r2
            r0.<init>()
            com.m2catalyst.m2sdk.r2.j = r0
        L_0x000b:
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.m2catalyst.m2sdk.configuration.M2Configuration r0 = r0.g
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isDebug()
            r1 = 1
            if (r0 != r1) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r0 = 21
            goto L_0x0024
        L_0x0022:
            r0 = 11
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.ZipUtils.getMaxIterationCount():int");
    }

    /* JADX INFO: finally extract failed */
    public final boolean compress(File file) {
        ZipUtils zipUtils;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        InputStream inputStream;
        Throwable th5;
        File file2 = file;
        Intrinsics.checkNotNullParameter(file2, ShareInternalUtility.STAGING_PARAM);
        try {
            File file3 = new File(this.outputDirectory, this.zipFileName);
            Ref.IntRef intRef = new Ref.IntRef();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            int i = 2;
            if (file3.exists()) {
                try {
                    String str = this.zipFileName;
                    File createTempFile = File.createTempFile("temp_" + str, ".zip", this.outputDirectory);
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            th = new ZipFile(file3);
                            try {
                                ZipFile zipFile = (ZipFile) th;
                                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                                Intrinsics.checkNotNullExpressionValue(entries, "existingZipFile.entries()");
                                Iterator<T> it = CollectionsKt.iterator(entries);
                                while (it.hasNext()) {
                                    ZipEntry zipEntry = (ZipEntry) it.next();
                                    String name = zipEntry.getName();
                                    Intrinsics.checkNotNullExpressionValue(name, "entry.name");
                                    Iterator<T> it2 = it;
                                    if (StringsKt.contains$default((CharSequence) name, (CharSequence) "count_index_identifier", false, i, (Object) null)) {
                                        String name2 = zipEntry.getName();
                                        Intrinsics.checkNotNullExpressionValue(name2, "entry.name");
                                        int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) name2, new String[]{"."}, false, 0, 6, (Object) null).get(1)) + 1;
                                        intRef.element = parseInt;
                                        if (parseInt < 0) {
                                            intRef.element = 0;
                                        }
                                        int i2 = intRef.element;
                                        zipOutputStream.putNextEntry(new ZipEntry("count_index_identifier." + i2 + ".info"));
                                        inputStream = zipFile.getInputStream(zipEntry);
                                        try {
                                            Intrinsics.checkNotNullExpressionValue(inputStream, "input");
                                            ByteStreamsKt.copyTo$default(inputStream, zipOutputStream, 0, 2, (Object) null);
                                            CloseableKt.closeFinally(inputStream, (Throwable) null);
                                            zipOutputStream.closeEntry();
                                        } catch (Throwable th6) {
                                            Throwable th7 = th6;
                                            CloseableKt.closeFinally(inputStream, th5);
                                            throw th7;
                                        }
                                    } else if (zipFile.size() < getMaxIterationCount() || !booleanRef.element) {
                                        zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
                                        inputStream = zipFile.getInputStream(zipEntry);
                                        Intrinsics.checkNotNullExpressionValue(inputStream, "input");
                                        ByteStreamsKt.copyTo$default(inputStream, zipOutputStream, 0, 2, (Object) null);
                                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                                        zipOutputStream.closeEntry();
                                    } else {
                                        booleanRef.element = false;
                                    }
                                    i = 2;
                                    it = it2;
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(th, (Throwable) null);
                                int i3 = intRef.element;
                                String name3 = file.getName();
                                zipOutputStream.putNextEntry(new ZipEntry(i3 + "_" + name3));
                                FileInputStream fileInputStream = new FileInputStream(file2);
                                try {
                                    ByteStreamsKt.copyTo$default(fileInputStream, zipOutputStream, 0, 2, (Object) null);
                                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                                    zipOutputStream.closeEntry();
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(zipOutputStream, (Throwable) null);
                                    Unit unit3 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                    file3.delete();
                                    createTempFile.renameTo(file3);
                                } catch (Throwable th8) {
                                    Throwable th9 = th8;
                                    CloseableKt.closeFinally(fileInputStream, th4);
                                    throw th9;
                                }
                            } catch (Throwable th10) {
                                Throwable th11 = th10;
                                try {
                                    throw th11;
                                } catch (Throwable th12) {
                                    Throwable th13 = th12;
                                    CloseableKt.closeFinally(th, th11);
                                    throw th13;
                                }
                            }
                        } finally {
                            Closeable closeable = th;
                            try {
                            } catch (Throwable th14) {
                                Throwable th15 = th14;
                                CloseableKt.closeFinally(zipOutputStream, closeable);
                                throw th15;
                            }
                        }
                    } finally {
                        Throwable th16 = th;
                        try {
                        } catch (Throwable th17) {
                            Throwable th18 = th17;
                            CloseableKt.closeFinally(fileOutputStream, th16);
                            throw th18;
                        }
                    }
                } catch (Throwable th19) {
                    th = th19;
                    zipUtils = this;
                }
            } else {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                try {
                    ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                    try {
                        zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        try {
                            ByteStreamsKt.copyTo$default(fileInputStream2, zipOutputStream2, 0, 2, (Object) null);
                            CloseableKt.closeFinally(fileInputStream2, (Throwable) null);
                            zipOutputStream2.putNextEntry(new ZipEntry("count_index_identifier.0.info"));
                            zipOutputStream2.closeEntry();
                            Unit unit4 = Unit.INSTANCE;
                            CloseableKt.closeFinally(zipOutputStream2, (Throwable) null);
                            Unit unit5 = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream2, (Throwable) null);
                        } catch (Throwable th20) {
                            Throwable th21 = th20;
                            try {
                                CloseableKt.closeFinally(fileInputStream2, th3);
                                throw th21;
                            } catch (Throwable th22) {
                                th = th22;
                                th2 = th;
                                try {
                                    throw th2;
                                } catch (Throwable th23) {
                                    th = th23;
                                    th = th;
                                    try {
                                        throw th;
                                    } catch (Throwable th24) {
                                        th = th24;
                                        try {
                                            M2SDKLogger.Companion.e("ZipUtils", String.valueOf(th.getMessage()), new String[0]);
                                            th.printStackTrace();
                                            return false;
                                        } finally {
                                            zipUtils.deleteBadZipFiles(zipUtils.outputDirectory);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th25) {
                        th = th25;
                        zipUtils = this;
                        th2 = th;
                        throw th2;
                    }
                } catch (Throwable th26) {
                    th = th26;
                    zipUtils = this;
                    th = th;
                    throw th;
                }
            }
            deleteBadZipFiles(this.outputDirectory);
            return true;
        } catch (Throwable th27) {
            th = th27;
            zipUtils = this;
            M2SDKLogger.Companion.e("ZipUtils", String.valueOf(th.getMessage()), new String[0]);
            th.printStackTrace();
            return false;
        }
    }
}
