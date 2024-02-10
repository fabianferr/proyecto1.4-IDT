package com.pgl.ssdk;

import java.util.ArrayList;
import java.util.List;

public class p {
    private static List a = new ArrayList();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r12v27, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0159, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0021 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028 A[Catch:{ all -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A[Catch:{ all -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[SYNTHETIC, Splitter:B:30:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x014a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014c A[SYNTHETIC, Splitter:B:80:0x014c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "Library entry not found:"
            java.lang.String r1 = "lib/"
            java.lang.String r2 = "lib/"
            java.lang.Class<com.pgl.ssdk.p> r3 = com.pgl.ssdk.p.class
            monitor-enter(r3)
            java.util.List r4 = a     // Catch:{ all -> 0x0167 }
            boolean r4 = r4.contains(r13)     // Catch:{ all -> 0x0167 }
            r5 = 1
            if (r4 == 0) goto L_0x0014
            monitor-exit(r3)
            return r5
        L_0x0014:
            r4 = 0
            java.lang.System.loadLibrary(r13)     // Catch:{ UnsatisfiedLinkError -> 0x0021, all -> 0x001f }
            java.util.List r6 = a     // Catch:{ UnsatisfiedLinkError -> 0x0021, all -> 0x001f }
            r6.add(r13)     // Catch:{ UnsatisfiedLinkError -> 0x0021, all -> 0x001f }
            goto L_0x0158
        L_0x001f:
            monitor-exit(r3)
            return r4
        L_0x0021:
            java.lang.String r6 = java.lang.System.mapLibraryName(r13)     // Catch:{ all -> 0x0167 }
            r7 = 0
            if (r12 == 0) goto L_0x004d
            java.io.File r8 = r12.getFilesDir()     // Catch:{ all -> 0x0167 }
            if (r8 != 0) goto L_0x002f
            goto L_0x004d
        L_0x002f:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0167 }
            java.io.File r9 = r12.getFilesDir()     // Catch:{ all -> 0x0167 }
            java.lang.String r10 = "libso"
            r8.<init>(r9, r10)     // Catch:{ all -> 0x0167 }
            boolean r9 = r8.exists()     // Catch:{ all -> 0x0167 }
            if (r9 != 0) goto L_0x004e
            java.lang.String r9 = r8.getAbsolutePath()     // Catch:{ all -> 0x0167 }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0167 }
            r10.<init>(r9)     // Catch:{ all -> 0x0167 }
            r10.mkdirs()     // Catch:{ all -> 0x0167 }
            goto L_0x004e
        L_0x004d:
            r8 = r7
        L_0x004e:
            if (r8 == 0) goto L_0x0056
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0167 }
            r9.<init>(r8, r6)     // Catch:{ all -> 0x0167 }
            goto L_0x0057
        L_0x0056:
            r9 = r7
        L_0x0057:
            if (r9 != 0) goto L_0x005b
            monitor-exit(r3)
            return r4
        L_0x005b:
            boolean r6 = r9.exists()     // Catch:{ all -> 0x0167 }
            if (r6 == 0) goto L_0x0064
            r9.delete()     // Catch:{ all -> 0x0167 }
        L_0x0064:
            android.content.pm.ApplicationInfo r12 = r12.getApplicationInfo()     // Catch:{ all -> 0x0136 }
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0136 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0136 }
            java.lang.String r12 = r12.sourceDir     // Catch:{ all -> 0x0136 }
            r8.<init>(r12)     // Catch:{ all -> 0x0136 }
            r6.<init>(r8, r5)     // Catch:{ all -> 0x0136 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r12.<init>(r2)     // Catch:{ all -> 0x012f }
            java.lang.String r2 = android.os.Build.CPU_ABI     // Catch:{ all -> 0x012f }
            r12.append(r2)     // Catch:{ all -> 0x012f }
            java.lang.String r2 = "/"
            r12.append(r2)     // Catch:{ all -> 0x012f }
            java.lang.String r2 = java.lang.System.mapLibraryName(r13)     // Catch:{ all -> 0x012f }
            r12.append(r2)     // Catch:{ all -> 0x012f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x012f }
            java.util.zip.ZipEntry r12 = r6.getEntry(r12)     // Catch:{ all -> 0x012f }
            if (r12 != 0) goto L_0x00e2
            java.lang.String r12 = android.os.Build.CPU_ABI     // Catch:{ all -> 0x012f }
            r2 = 45
            int r12 = r12.indexOf(r2)     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r2.<init>(r1)     // Catch:{ all -> 0x012f }
            java.lang.String r1 = android.os.Build.CPU_ABI     // Catch:{ all -> 0x012f }
            if (r12 <= 0) goto L_0x00a6
            goto L_0x00ac
        L_0x00a6:
            java.lang.String r12 = android.os.Build.CPU_ABI     // Catch:{ all -> 0x012f }
            int r12 = r12.length()     // Catch:{ all -> 0x012f }
        L_0x00ac:
            java.lang.String r12 = r1.substring(r4, r12)     // Catch:{ all -> 0x012f }
            r2.append(r12)     // Catch:{ all -> 0x012f }
            java.lang.String r12 = "/"
            r2.append(r12)     // Catch:{ all -> 0x012f }
            java.lang.String r12 = java.lang.System.mapLibraryName(r13)     // Catch:{ all -> 0x012f }
            r2.append(r12)     // Catch:{ all -> 0x012f }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x012f }
            java.util.zip.ZipEntry r1 = r6.getEntry(r12)     // Catch:{ all -> 0x012f }
            if (r1 != 0) goto L_0x00e1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r1.<init>(r0)     // Catch:{ all -> 0x012f }
            r1.append(r12)     // Catch:{ all -> 0x012f }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x012f }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r7)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r7)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.util.zip.ZipFile) r6)     // Catch:{ all -> 0x0167 }
            r7 = r12
            goto L_0x0148
        L_0x00e1:
            r12 = r1
        L_0x00e2:
            r9.createNewFile()     // Catch:{ all -> 0x012f }
            java.io.InputStream r12 = r6.getInputStream(r12)     // Catch:{ all -> 0x012f }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x012a }
            r0.<init>(r9)     // Catch:{ all -> 0x012a }
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0128 }
        L_0x00f2:
            int r2 = r12.read(r1)     // Catch:{ all -> 0x0128 }
            if (r2 <= 0) goto L_0x00fc
            r0.write(r1, r4, r2)     // Catch:{ all -> 0x0128 }
            goto L_0x00f2
        L_0x00fc:
            java.lang.String r1 = r9.getAbsolutePath()     // Catch:{ all -> 0x0128 }
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0128 }
            r8 = 493(0x1ed, float:6.91E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0128 }
            r2[r4] = r8     // Catch:{ all -> 0x0128 }
            r8 = -1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0128 }
            r2[r5] = r10     // Catch:{ all -> 0x0128 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0128 }
            r10 = 2
            r2[r10] = r8     // Catch:{ all -> 0x0128 }
            java.lang.String r8 = "android.os.FileUtils"
            com.pgl.ssdk.o.a((java.lang.String) r8, (java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0128 }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r0)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r12)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.util.zip.ZipFile) r6)     // Catch:{ all -> 0x0167 }
            goto L_0x0148
        L_0x0128:
            r1 = move-exception
            goto L_0x0134
        L_0x012a:
            r0 = move-exception
            r11 = r0
            r0 = r12
            r12 = r11
            goto L_0x0131
        L_0x012f:
            r12 = move-exception
            r0 = r7
        L_0x0131:
            r1 = r12
            r12 = r0
            r0 = r7
        L_0x0134:
            r7 = r6
            goto L_0x013a
        L_0x0136:
            r12 = move-exception
            r1 = r12
            r12 = r7
            r0 = r12
        L_0x013a:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x015c }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r0)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r12)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.util.zip.ZipFile) r7)     // Catch:{ all -> 0x0167 }
            r7 = r1
        L_0x0148:
            if (r7 == 0) goto L_0x014c
            monitor-exit(r3)
            return r4
        L_0x014c:
            java.lang.String r12 = r9.getAbsolutePath()     // Catch:{ all -> 0x015a }
            java.lang.System.load(r12)     // Catch:{ all -> 0x015a }
            java.util.List r12 = a     // Catch:{ all -> 0x015a }
            r12.add(r13)     // Catch:{ all -> 0x015a }
        L_0x0158:
            monitor-exit(r3)
            return r5
        L_0x015a:
            monitor-exit(r3)
            return r4
        L_0x015c:
            r13 = move-exception
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r0)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.io.Closeable) r12)     // Catch:{ all -> 0x0167 }
            com.pgl.ssdk.C0237a.a((java.util.zip.ZipFile) r7)     // Catch:{ all -> 0x0167 }
            throw r13     // Catch:{ all -> 0x0167 }
        L_0x0167:
            r12 = move-exception
            monitor-exit(r3)
            goto L_0x016b
        L_0x016a:
            throw r12
        L_0x016b:
            goto L_0x016a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.p.a(android.content.Context, java.lang.String):boolean");
    }
}
