package com.mbridge.msdk.foundation.download.utils;

public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    /* JADX WARNING: Removed duplicated region for block: B:113:0x015f A[SYNTHETIC, Splitter:B:113:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016d A[SYNTHETIC, Splitter:B:118:0x016d] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x017e A[SYNTHETIC, Splitter:B:124:0x017e] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018c A[SYNTHETIC, Splitter:B:129:0x018c] */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int unzip(java.lang.String r14, java.lang.String r15) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "../"
            java.lang.String r1 = ".."
            java.lang.String r2 = "UnzipUtility"
            r3 = -1
            if (r14 == 0) goto L_0x0199
            if (r15 != 0) goto L_0x000d
            goto L_0x0199
        L_0x000d:
            java.lang.String r4 = "/"
            boolean r5 = r15.endsWith(r4)
            if (r5 != 0) goto L_0x0024
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r15)
            r5.append(r4)
            java.lang.String r15 = r5.toString()
        L_0x0024:
            java.io.File r4 = new java.io.File
            r4.<init>(r14)
            boolean r14 = r4.exists()
            if (r14 != 0) goto L_0x0031
            r14 = 1
            return r14
        L_0x0031:
            r14 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0154, all -> 0x0151 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0154, all -> 0x0151 }
            java.util.Enumeration r4 = r5.entries()     // Catch:{ IOException -> 0x0154, all -> 0x0151 }
            r6 = r14
        L_0x003c:
            boolean r7 = r4.hasMoreElements()     // Catch:{ IOException -> 0x014f }
            r8 = 0
            if (r7 == 0) goto L_0x012f
            java.lang.Object r7 = r4.nextElement()     // Catch:{ IOException -> 0x014f }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ IOException -> 0x014f }
            r9 = 2
            if (r7 != 0) goto L_0x0069
            if (r14 == 0) goto L_0x005a
            r14.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x005a
        L_0x0052:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x005a:
            if (r6 == 0) goto L_0x0068
            r6.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0068:
            return r9
        L_0x0069:
            java.lang.String r10 = r7.getName()     // Catch:{ IOException -> 0x014f }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x014f }
            if (r11 != 0) goto L_0x0112
            boolean r11 = r10.startsWith(r1)     // Catch:{ IOException -> 0x014f }
            if (r11 != 0) goto L_0x0112
            boolean r11 = r10.startsWith(r0)     // Catch:{ IOException -> 0x014f }
            if (r11 == 0) goto L_0x0081
            goto L_0x0112
        L_0x0081:
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x014f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014f }
            r12.<init>()     // Catch:{ IOException -> 0x014f }
            r12.append(r15)     // Catch:{ IOException -> 0x014f }
            r12.append(r10)     // Catch:{ IOException -> 0x014f }
            java.lang.String r10 = r12.toString()     // Catch:{ IOException -> 0x014f }
            r11.<init>(r10)     // Catch:{ IOException -> 0x014f }
            java.lang.String r10 = r11.getCanonicalPath()     // Catch:{ IOException -> 0x009a }
            goto L_0x009c
        L_0x009a:
            java.lang.String r10 = ""
        L_0x009c:
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x014f }
            if (r12 != 0) goto L_0x00f5
            boolean r12 = r10.startsWith(r15)     // Catch:{ IOException -> 0x014f }
            if (r12 == 0) goto L_0x00f5
            boolean r12 = r10.startsWith(r1)     // Catch:{ IOException -> 0x014f }
            if (r12 != 0) goto L_0x00f5
            boolean r10 = r10.startsWith(r0)     // Catch:{ IOException -> 0x014f }
            if (r10 == 0) goto L_0x00b5
            goto L_0x00f5
        L_0x00b5:
            boolean r9 = r7.isDirectory()     // Catch:{ IOException -> 0x014f }
            if (r9 == 0) goto L_0x00c0
            r11.mkdirs()     // Catch:{ IOException -> 0x014f }
            goto L_0x003c
        L_0x00c0:
            java.io.File r9 = r11.getParentFile()     // Catch:{ IOException -> 0x014f }
            boolean r9 = r9.exists()     // Catch:{ IOException -> 0x014f }
            if (r9 != 0) goto L_0x00d1
            java.io.File r9 = r11.getParentFile()     // Catch:{ IOException -> 0x014f }
            r9.mkdirs()     // Catch:{ IOException -> 0x014f }
        L_0x00d1:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x014f }
            r9.<init>(r11)     // Catch:{ IOException -> 0x014f }
            java.io.InputStream r14 = r5.getInputStream(r7)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r6]     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
        L_0x00de:
            int r10 = r14.read(r7, r8, r6)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            if (r10 == r3) goto L_0x00eb
            r9.write(r7, r8, r10)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r9.flush()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            goto L_0x00de
        L_0x00eb:
            r6 = r9
            goto L_0x003c
        L_0x00ee:
            r15 = move-exception
            r6 = r9
            goto L_0x017c
        L_0x00f2:
            r15 = move-exception
            r6 = r9
            goto L_0x0156
        L_0x00f5:
            if (r14 == 0) goto L_0x0103
            r14.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x0103
        L_0x00fb:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0103:
            if (r6 == 0) goto L_0x0111
            r6.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0111
        L_0x0109:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0111:
            return r9
        L_0x0112:
            if (r14 == 0) goto L_0x0120
            r14.close()     // Catch:{ IOException -> 0x0118 }
            goto L_0x0120
        L_0x0118:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0120:
            if (r6 == 0) goto L_0x012e
            r6.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012e
        L_0x0126:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x012e:
            return r9
        L_0x012f:
            r5.close()     // Catch:{ IOException -> 0x014f }
            if (r14 == 0) goto L_0x0140
            r14.close()     // Catch:{ IOException -> 0x0138 }
            goto L_0x0140
        L_0x0138:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0140:
            if (r6 == 0) goto L_0x014e
            r6.close()     // Catch:{ IOException -> 0x0146 }
            goto L_0x014e
        L_0x0146:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x014e:
            return r8
        L_0x014f:
            r15 = move-exception
            goto L_0x0156
        L_0x0151:
            r15 = move-exception
            r6 = r14
            goto L_0x017c
        L_0x0154:
            r15 = move-exception
            r6 = r14
        L_0x0156:
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x017b }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r15)     // Catch:{ all -> 0x017b }
            if (r14 == 0) goto L_0x016b
            r14.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x016b
        L_0x0163:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x016b:
            if (r6 == 0) goto L_0x0179
            r6.close()     // Catch:{ IOException -> 0x0171 }
            goto L_0x0179
        L_0x0171:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0179:
            r14 = 3
            return r14
        L_0x017b:
            r15 = move-exception
        L_0x017c:
            if (r14 == 0) goto L_0x018a
            r14.close()     // Catch:{ IOException -> 0x0182 }
            goto L_0x018a
        L_0x0182:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x018a:
            if (r6 == 0) goto L_0x0198
            r6.close()     // Catch:{ IOException -> 0x0190 }
            goto L_0x0198
        L_0x0190:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r2, r14)
        L_0x0198:
            throw r15
        L_0x0199:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.unzip(java.lang.String, java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void extractFile(java.util.zip.ZipInputStream r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            java.io.File r5 = r0.getParentFile()
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0016
            java.io.File r5 = r0.getParentFile()
            r5.mkdirs()
        L_0x0016:
            r5 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x003d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x003d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003d }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
        L_0x0025:
            int r0 = r4.read(r5)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r2 = -1
            if (r0 == r2) goto L_0x0031
            r2 = 0
            r1.write(r5, r2, r0)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            goto L_0x0025
        L_0x0031:
            r1.close()
            return
        L_0x0035:
            r4 = move-exception
            r5 = r1
            goto L_0x0044
        L_0x0038:
            r4 = move-exception
            r5 = r1
            goto L_0x003e
        L_0x003b:
            r4 = move-exception
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003b }
            r0.<init>(r4)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            r5.close()
        L_0x0049:
            goto L_0x004b
        L_0x004a:
            throw r4
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.extractFile(java.util.zip.ZipInputStream, java.lang.String):void");
    }
}
