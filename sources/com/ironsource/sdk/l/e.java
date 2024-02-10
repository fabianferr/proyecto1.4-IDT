package com.ironsource.sdk.l;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

final class e implements Callable<b> {
    private final a a;
    private final String b;
    private long c;

    e(a aVar, String str, long j) {
        this.a = aVar;
        this.b = str;
        this.c = j;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0129 A[SYNTHETIC, Splitter:B:102:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0131 A[Catch:{ all -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0140 A[SYNTHETIC, Splitter:B:114:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0148 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f A[SYNTHETIC, Splitter:B:18:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097 A[Catch:{ all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a0 A[SYNTHETIC, Splitter:B:39:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c1 A[Catch:{ all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ca A[SYNTHETIC, Splitter:B:54:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4 A[SYNTHETIC, Splitter:B:65:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ec A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fb A[SYNTHETIC, Splitter:B:78:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0103 A[Catch:{ all -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112 A[SYNTHETIC, Splitter:B:90:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011a A[Catch:{ all -> 0x0116 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.sdk.l.b a(java.lang.String r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            java.lang.String r0 = "FileWorkerThread"
            com.ironsource.sdk.l.b r1 = new com.ironsource.sdk.l.b
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L_0x0014
            r1.a = r7
            r7 = 1007(0x3ef, float:1.411E-42)
            r1.b = r7
            return r1
        L_0x0014:
            r2 = 0
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x013d, URISyntaxException -> 0x0126, SocketTimeoutException -> 0x010f, FileNotFoundException -> 0x00f8, Exception -> 0x00b5, Error -> 0x0089, all -> 0x0086 }
            r4.<init>(r7)     // Catch:{ MalformedURLException -> 0x013d, URISyntaxException -> 0x0126, SocketTimeoutException -> 0x010f, FileNotFoundException -> 0x00f8, Exception -> 0x00b5, Error -> 0x0089, all -> 0x0086 }
            r4.toURI()     // Catch:{ MalformedURLException -> 0x013d, URISyntaxException -> 0x0126, SocketTimeoutException -> 0x010f, FileNotFoundException -> 0x00f8, Exception -> 0x00b5, Error -> 0x0089, all -> 0x0086 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ MalformedURLException -> 0x013d, URISyntaxException -> 0x0126, SocketTimeoutException -> 0x010f, FileNotFoundException -> 0x00f8, Exception -> 0x00b5, Error -> 0x0089, all -> 0x0086 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ MalformedURLException -> 0x013d, URISyntaxException -> 0x0126, SocketTimeoutException -> 0x010f, FileNotFoundException -> 0x00f8, Exception -> 0x00b5, Error -> 0x0089, all -> 0x0086 }
            java.lang.String r5 = "GET"
            r4.setRequestMethod(r5)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r4.setConnectTimeout(r9)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r4.setReadTimeout(r10)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r4.connect()     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            int r3 = r4.getResponseCode()     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r9 = 200(0xc8, float:2.8E-43)
            if (r3 < r9) goto L_0x004a
            r9 = 400(0x190, float:5.6E-43)
            if (r3 < r9) goto L_0x003f
            goto L_0x004a
        L_0x003f:
            java.io.InputStream r2 = r4.getInputStream()     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            byte[] r8 = a(r2)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r1.c = r8     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            goto L_0x006d
        L_0x004a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            java.lang.String r10 = " RESPONSE CODE: "
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r9.append(r3)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            java.lang.String r10 = " URL: "
            r9.append(r10)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r9.append(r7)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            java.lang.String r10 = " ATTEMPT: "
            r9.append(r10)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r9.append(r8)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            java.lang.String r8 = r9.toString()     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            com.ironsource.sdk.utils.Logger.i(r0, r8)     // Catch:{ MalformedURLException -> 0x013e, URISyntaxException -> 0x0127, SocketTimeoutException -> 0x0110, FileNotFoundException -> 0x00f9, Exception -> 0x0082, Error -> 0x007e, all -> 0x007b }
            r3 = 1011(0x3f3, float:1.417E-42)
        L_0x006d:
            if (r2 == 0) goto L_0x0075
            r2.close()     // Catch:{ all -> 0x0073 }
            goto L_0x0075
        L_0x0073:
            r8 = move-exception
            goto L_0x00ac
        L_0x0075:
            if (r4 == 0) goto L_0x00af
            r4.disconnect()     // Catch:{ all -> 0x0073 }
            goto L_0x00af
        L_0x007b:
            r8 = move-exception
            goto L_0x00e2
        L_0x007e:
            r8 = move-exception
            r9 = r2
            r2 = r4
            goto L_0x008b
        L_0x0082:
            r8 = move-exception
            r9 = r2
            r2 = r4
            goto L_0x00b7
        L_0x0086:
            r8 = move-exception
            r4 = r2
            goto L_0x00e2
        L_0x0089:
            r8 = move-exception
            r9 = r2
        L_0x008b:
            r3 = 1019(0x3fb, float:1.428E-42)
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x00df }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00df }
            if (r10 != 0) goto L_0x009e
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00df }
            com.ironsource.sdk.utils.Logger.i(r0, r8)     // Catch:{ all -> 0x00df }
        L_0x009e:
            if (r9 == 0) goto L_0x00a6
            r9.close()     // Catch:{ all -> 0x00a4 }
            goto L_0x00a6
        L_0x00a4:
            r8 = move-exception
            goto L_0x00ac
        L_0x00a6:
            if (r2 == 0) goto L_0x00af
            r2.disconnect()     // Catch:{ all -> 0x00a4 }
            goto L_0x00af
        L_0x00ac:
            r8.printStackTrace()
        L_0x00af:
            r1.a = r7
            r1.b = r3
            goto L_0x0155
        L_0x00b5:
            r8 = move-exception
            r9 = r2
        L_0x00b7:
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x00df }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00df }
            if (r10 != 0) goto L_0x00c8
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00df }
            com.ironsource.sdk.utils.Logger.i(r0, r8)     // Catch:{ all -> 0x00df }
        L_0x00c8:
            if (r9 == 0) goto L_0x00d0
            r9.close()     // Catch:{ all -> 0x00ce }
            goto L_0x00d0
        L_0x00ce:
            r8 = move-exception
            goto L_0x00d6
        L_0x00d0:
            if (r2 == 0) goto L_0x00d9
            r2.disconnect()     // Catch:{ all -> 0x00ce }
            goto L_0x00d9
        L_0x00d6:
            r8.printStackTrace()
        L_0x00d9:
            r1.a = r7
            r7 = 1009(0x3f1, float:1.414E-42)
            goto L_0x0153
        L_0x00df:
            r8 = move-exception
            r4 = r2
            r2 = r9
        L_0x00e2:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ all -> 0x00e8 }
            goto L_0x00ea
        L_0x00e8:
            r9 = move-exception
            goto L_0x00f0
        L_0x00ea:
            if (r4 == 0) goto L_0x00f3
            r4.disconnect()     // Catch:{ all -> 0x00e8 }
            goto L_0x00f3
        L_0x00f0:
            r9.printStackTrace()
        L_0x00f3:
            r1.a = r7
            r1.b = r3
            throw r8
        L_0x00f8:
            r4 = r2
        L_0x00f9:
            if (r2 == 0) goto L_0x0101
            r2.close()     // Catch:{ all -> 0x00ff }
            goto L_0x0101
        L_0x00ff:
            r8 = move-exception
            goto L_0x0107
        L_0x0101:
            if (r4 == 0) goto L_0x010a
            r4.disconnect()     // Catch:{ all -> 0x00ff }
            goto L_0x010a
        L_0x0107:
            r8.printStackTrace()
        L_0x010a:
            r1.a = r7
            r7 = 1018(0x3fa, float:1.427E-42)
            goto L_0x0153
        L_0x010f:
            r4 = r2
        L_0x0110:
            if (r2 == 0) goto L_0x0118
            r2.close()     // Catch:{ all -> 0x0116 }
            goto L_0x0118
        L_0x0116:
            r8 = move-exception
            goto L_0x011e
        L_0x0118:
            if (r4 == 0) goto L_0x0121
            r4.disconnect()     // Catch:{ all -> 0x0116 }
            goto L_0x0121
        L_0x011e:
            r8.printStackTrace()
        L_0x0121:
            r1.a = r7
            r7 = 1008(0x3f0, float:1.413E-42)
            goto L_0x0153
        L_0x0126:
            r4 = r2
        L_0x0127:
            if (r2 == 0) goto L_0x012f
            r2.close()     // Catch:{ all -> 0x012d }
            goto L_0x012f
        L_0x012d:
            r8 = move-exception
            goto L_0x0135
        L_0x012f:
            if (r4 == 0) goto L_0x0138
            r4.disconnect()     // Catch:{ all -> 0x012d }
            goto L_0x0138
        L_0x0135:
            r8.printStackTrace()
        L_0x0138:
            r1.a = r7
            r7 = 1010(0x3f2, float:1.415E-42)
            goto L_0x0153
        L_0x013d:
            r4 = r2
        L_0x013e:
            if (r2 == 0) goto L_0x0146
            r2.close()     // Catch:{ all -> 0x0144 }
            goto L_0x0146
        L_0x0144:
            r8 = move-exception
            goto L_0x014c
        L_0x0146:
            if (r4 == 0) goto L_0x014f
            r4.disconnect()     // Catch:{ all -> 0x0144 }
            goto L_0x014f
        L_0x014c:
            r8.printStackTrace()
        L_0x014f:
            r1.a = r7
            r7 = 1004(0x3ec, float:1.407E-42)
        L_0x0153:
            r1.b = r7
        L_0x0155:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.l.e.a(java.lang.String, int, int, int):com.ironsource.sdk.l.b");
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r1 = a(r9.a.b, r2, r9.a.c, r9.a.d);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.sdk.l.b call() {
        /*
            r9 = this;
            java.lang.String r0 = "FileWorkerThread"
            long r1 = r9.c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x000e
            r1 = 1
            r9.c = r1
        L_0x000e:
            r1 = 0
            r2 = 0
        L_0x0010:
            long r3 = (long) r2
            long r5 = r9.c
            r7 = 1009(0x3f1, float:1.414E-42)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0034
            com.ironsource.sdk.l.a r1 = r9.a
            java.lang.String r1 = r1.b
            com.ironsource.sdk.l.a r3 = r9.a
            int r3 = r3.c
            com.ironsource.sdk.l.a r4 = r9.a
            int r4 = r4.d
            com.ironsource.sdk.l.b r1 = r9.a(r1, r2, r3, r4)
            int r3 = r1.b
            r4 = 1008(0x3f0, float:1.413E-42)
            if (r3 == r4) goto L_0x0031
            if (r3 != r7) goto L_0x0034
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0034:
            if (r1 == 0) goto L_0x00c4
            byte[] r2 = r1.c
            if (r2 == 0) goto L_0x00c4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.b
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            com.ironsource.sdk.l.a r3 = r9.a
            com.ironsource.sdk.h.c r3 = r3.a
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.ironsource.sdk.l.a r4 = r9.a
            java.lang.String r4 = r4.e
            r3.append(r4)
            java.lang.String r4 = java.io.File.separator
            r3.append(r4)
            java.lang.String r4 = "tmp_"
            r3.append(r4)
            com.ironsource.sdk.l.a r4 = r9.a
            com.ironsource.sdk.h.c r4 = r4.a
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            byte[] r4 = r1.c     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x00ab, Error -> 0x0096 }
            int r4 = com.ironsource.sdk.utils.IronSourceStorageUtils.saveFile(r4, r3)     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x00ab, Error -> 0x0096 }
            if (r4 != 0) goto L_0x008b
            r2 = 1006(0x3ee, float:1.41E-42)
            r1.b = r2     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x00ab, Error -> 0x0096 }
            goto L_0x00c4
        L_0x008b:
            boolean r2 = com.ironsource.sdk.utils.IronSourceStorageUtils.renameFile(r3, r2)     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x00ab, Error -> 0x0096 }
            if (r2 != 0) goto L_0x00c4
            r2 = 1014(0x3f6, float:1.421E-42)
            r1.b = r2     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x00ab, Error -> 0x0096 }
            goto L_0x00c4
        L_0x0096:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00a8
            java.lang.String r2 = r2.getMessage()
            com.ironsource.sdk.utils.Logger.i(r0, r2)
        L_0x00a8:
            r0 = 1019(0x3fb, float:1.428E-42)
            goto L_0x00c2
        L_0x00ab:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00bd
            java.lang.String r2 = r2.getMessage()
            com.ironsource.sdk.utils.Logger.i(r0, r2)
        L_0x00bd:
            r1.b = r7
            goto L_0x00c4
        L_0x00c0:
            r0 = 1018(0x3fa, float:1.427E-42)
        L_0x00c2:
            r1.b = r0
        L_0x00c4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.l.e.call():com.ironsource.sdk.l.b");
    }
}
