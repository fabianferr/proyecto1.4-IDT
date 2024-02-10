package com.startapp.sdk.ads.video;

import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

/* compiled from: Sta */
public class d {
    public boolean a = true;
    public VideoPlayerInterface.a b = null;
    public String c = null;

    /* compiled from: Sta */
    public interface a {
        void a(String str);
    }

    /* compiled from: Sta */
    public static class b {
        public static final d a = new d();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0114 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0117 */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013e A[SYNTHETIC, Splitter:B:82:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0149 A[Catch:{ all -> 0x0142 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.content.Context r21, java.net.URL r22, java.lang.String r23, com.startapp.sdk.ads.video.d.a r24) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r23
            r3 = r24
            java.lang.String r4 = ".temp"
            java.lang.String r5 = r22.toString()
            r1.c = r5
            r5 = 1
            r1.a = r5
            r6 = 0
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.h     // Catch:{ all -> 0x0137 }
            com.startapp.sdk.adsbase.VideoConfig r7 = r7.G()     // Catch:{ all -> 0x0137 }
            int r7 = r7.j()     // Catch:{ all -> 0x0137 }
            java.lang.String r8 = com.startapp.sdk.ads.video.VideoUtil.a((android.content.Context) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0137 }
            r9.<init>(r8)     // Catch:{ all -> 0x0137 }
            boolean r10 = r9.exists()     // Catch:{ all -> 0x0137 }
            if (r10 == 0) goto L_0x0032
            r1.c = r6
            java.util.Map<android.app.Activity, java.lang.Integer> r0 = com.startapp.k9.a
            return r8
        L_0x0032:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r10.<init>()     // Catch:{ all -> 0x0137 }
            r10.append(r2)     // Catch:{ all -> 0x0137 }
            r10.append(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x0137 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r10.<init>()     // Catch:{ all -> 0x0137 }
            r10.append(r8)     // Catch:{ all -> 0x0137 }
            r10.append(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x0137 }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0137 }
            java.lang.String r11 = com.startapp.sdk.ads.video.VideoUtil.a((android.content.Context) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            r10.<init>(r11)     // Catch:{ all -> 0x0137 }
            java.net.URLConnection r11 = r22.openConnection()     // Catch:{ all -> 0x0133 }
            r11.connect()     // Catch:{ all -> 0x0133 }
            int r12 = r11.getContentLength()     // Catch:{ all -> 0x0133 }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ all -> 0x0133 }
            java.io.DataInputStream r13 = new java.io.DataInputStream     // Catch:{ all -> 0x0131 }
            r13.<init>(r11)     // Catch:{ all -> 0x0131 }
            r14 = 4096(0x1000, float:5.74E-42)
            byte[] r14 = new byte[r14]     // Catch:{ all -> 0x012e }
            r15 = 0
            java.io.FileOutputStream r2 = r0.openFileOutput(r2, r15)     // Catch:{ all -> 0x012e }
            r0 = 0
            r16 = 0
            r17 = 0
        L_0x007b:
            int r5 = r13.read(r14)     // Catch:{ all -> 0x011e }
            if (r5 <= 0) goto L_0x00d2
            boolean r6 = r1.a     // Catch:{ all -> 0x011e }
            if (r6 == 0) goto L_0x00d2
            r2.write(r14, r15, r5)     // Catch:{ all -> 0x011e }
            int r0 = r0 + r5
            double r5 = (double) r0
            r18 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r18
            r18 = r14
            double r14 = (double) r12
            java.lang.Double.isNaN(r14)
            double r5 = r5 / r14
            int r5 = (int) r5
            if (r5 < r7) goto L_0x00cd
            if (r16 != 0) goto L_0x00b2
            if (r3 == 0) goto L_0x00b2
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x011e }
            android.os.Looper r14 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x011e }
            r6.<init>(r14)     // Catch:{ all -> 0x011e }
            com.startapp.sdk.ads.video.c r14 = new com.startapp.sdk.ads.video.c     // Catch:{ all -> 0x011e }
            r14.<init>(r1, r3, r4)     // Catch:{ all -> 0x011e }
            r6.post(r14)     // Catch:{ all -> 0x011e }
            r16 = 1
        L_0x00b2:
            int r6 = r17 + 1
            if (r5 < r6) goto L_0x00cd
            com.startapp.sdk.ads.video.player.VideoPlayerInterface$a r6 = r1.b     // Catch:{ all -> 0x011e }
            if (r6 == 0) goto L_0x00cb
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x011e }
            android.os.Looper r14 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x011e }
            r6.<init>(r14)     // Catch:{ all -> 0x011e }
            com.startapp.o6 r14 = new com.startapp.o6     // Catch:{ all -> 0x011e }
            r14.<init>(r1, r5)     // Catch:{ all -> 0x011e }
            r6.post(r14)     // Catch:{ all -> 0x011e }
        L_0x00cb:
            r17 = r5
        L_0x00cd:
            r14 = r18
            r6 = 0
            r15 = 0
            goto L_0x007b
        L_0x00d2:
            boolean r0 = r1.a     // Catch:{ all -> 0x011e }
            if (r0 != 0) goto L_0x00ea
            if (r5 <= 0) goto L_0x00ea
            r10.delete()     // Catch:{ all -> 0x011e }
            java.lang.String r0 = "downloadInterrupted"
            r3 = 0
            r1.c = r3
            com.startapp.k9.a((java.io.Closeable) r11)
            com.startapp.k9.a((java.io.Closeable) r13)
            com.startapp.k9.a((java.io.Closeable) r2)
            return r0
        L_0x00ea:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0115, all -> 0x010b }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0115, all -> 0x010b }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0116, all -> 0x0109 }
            r4.<init>(r9)     // Catch:{ Exception -> 0x0116, all -> 0x0109 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0117, all -> 0x0107 }
        L_0x00f8:
            int r5 = r3.read(r0)     // Catch:{ Exception -> 0x0117, all -> 0x0107 }
            if (r5 <= 0) goto L_0x0103
            r6 = 0
            r4.write(r0, r6, r5)     // Catch:{ Exception -> 0x0117, all -> 0x0107 }
            goto L_0x00f8
        L_0x0103:
            r3.close()     // Catch:{ Exception -> 0x0120 }
            goto L_0x011a
        L_0x0107:
            r0 = move-exception
            goto L_0x010e
        L_0x0109:
            r0 = move-exception
            goto L_0x010d
        L_0x010b:
            r0 = move-exception
            r3 = 0
        L_0x010d:
            r4 = 0
        L_0x010e:
            r3.close()     // Catch:{ Exception -> 0x0114 }
            r4.close()     // Catch:{ Exception -> 0x0114 }
        L_0x0114:
            throw r0     // Catch:{ all -> 0x011e }
        L_0x0115:
            r3 = 0
        L_0x0116:
            r4 = 0
        L_0x0117:
            r3.close()     // Catch:{ Exception -> 0x0120 }
        L_0x011a:
            r4.close()     // Catch:{ Exception -> 0x0120 }
            goto L_0x0120
        L_0x011e:
            r0 = move-exception
            goto L_0x013c
        L_0x0120:
            r3 = 0
            r1.c = r3
            com.startapp.k9.a((java.io.Closeable) r11)
            com.startapp.k9.a((java.io.Closeable) r13)
            com.startapp.k9.a((java.io.Closeable) r2)
            r6 = r8
            goto L_0x015e
        L_0x012e:
            r0 = move-exception
            r2 = 0
            goto L_0x013c
        L_0x0131:
            r0 = move-exception
            goto L_0x0135
        L_0x0133:
            r0 = move-exception
            r11 = 0
        L_0x0135:
            r2 = 0
            goto L_0x013b
        L_0x0137:
            r0 = move-exception
            r2 = 0
            r10 = 0
            r11 = 0
        L_0x013b:
            r13 = 0
        L_0x013c:
            if (r10 == 0) goto L_0x0145
            r10.delete()     // Catch:{ all -> 0x0142 }
            goto L_0x0145
        L_0x0142:
            r0 = move-exception
            r3 = 0
            goto L_0x015f
        L_0x0145:
            boolean r3 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0142 }
            if (r3 != 0) goto L_0x0151
            boolean r3 = r0 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x0142 }
            if (r3 == 0) goto L_0x014e
            goto L_0x0151
        L_0x014e:
            com.startapp.i3.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0142 }
        L_0x0151:
            r3 = 0
            r1.c = r3
            com.startapp.k9.a((java.io.Closeable) r11)
            com.startapp.k9.a((java.io.Closeable) r13)
            com.startapp.k9.a((java.io.Closeable) r2)
            r6 = r3
        L_0x015e:
            return r6
        L_0x015f:
            r1.c = r3
            com.startapp.k9.a((java.io.Closeable) r11)
            com.startapp.k9.a((java.io.Closeable) r13)
            com.startapp.k9.a((java.io.Closeable) r2)
            goto L_0x016c
        L_0x016b:
            throw r0
        L_0x016c:
            goto L_0x016b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.d.a(android.content.Context, java.net.URL, java.lang.String, com.startapp.sdk.ads.video.d$a):java.lang.String");
    }
}
