package com.mbridge.msdk.videocommon.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.videocommon.download.f;
import com.mbridge.msdk.videocommon.download.g;

/* compiled from: DownLoadUtils */
public final class e {
    public static void a(final String str, final g.c cVar, final boolean z) {
        try {
            if (!ak.a(str)) {
                if (URLUtil.isNetworkUrl(str)) {
                    f.a.a.a(new a() {
                        public final void b() {
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
                            r5 = e;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
                            r7 = null;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
                            r0 = th;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
                            r2 = e;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
                            r5 = null;
                            r7 = null;
                         */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Removed duplicated region for block: B:102:0x015f A[SYNTHETIC, Splitter:B:102:0x015f] */
                        /* JADX WARNING: Removed duplicated region for block: B:107:0x0167 A[Catch:{ Exception -> 0x0163 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 r6 
                          PHI: (r1v17 java.io.InputStream) = (r1v14 java.io.InputStream), (r1v14 java.io.InputStream), (r1v18 java.io.InputStream), (r1v18 java.io.InputStream) binds: [B:39:0x0099, B:40:?, B:11:0x004a, B:18:0x005f] A[DONT_GENERATE, DONT_INLINE]
                          PHI: (r6v12 java.io.ByteArrayOutputStream) = (r6v9 java.io.ByteArrayOutputStream), (r6v9 java.io.ByteArrayOutputStream), (r6v16 java.io.ByteArrayOutputStream), (r6v16 java.io.ByteArrayOutputStream) binds: [B:39:0x0099, B:40:?, B:11:0x004a, B:18:0x005f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004a] */
                        /* JADX WARNING: Removed duplicated region for block: B:59:0x00e1 A[SYNTHETIC, Splitter:B:59:0x00e1] */
                        /* JADX WARNING: Removed duplicated region for block: B:64:0x00e9 A[Catch:{ Exception -> 0x00e5 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:68:0x00f7 A[SYNTHETIC, Splitter:B:68:0x00f7] */
                        /* JADX WARNING: Removed duplicated region for block: B:84:0x0120 A[Catch:{ all -> 0x0108 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:87:0x012a A[Catch:{ all -> 0x0108 }] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void a() {
                            /*
                                r12 = this;
                                java.lang.String r0 = "DownLoadUtils"
                                java.lang.String r1 = "responseCode is "
                                java.lang.String r2 = "response code "
                                r3 = 0
                                r4 = 0
                                com.mbridge.msdk.videocommon.download.g$c r5 = r3     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                if (r5 == 0) goto L_0x000f
                                r5.a()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                            L_0x000f:
                                java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.lang.String r6 = r2     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r5.<init>(r6)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r6 = 30000(0x7530, float:4.2039E-41)
                                r5.setReadTimeout(r6)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r6 = 20000(0x4e20, float:2.8026E-41)
                                r5.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                int r6 = r5.getResponseCode()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r7.<init>(r2)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r7.append(r6)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r2 = 200(0xc8, float:2.8E-43)
                                if (r6 != r2) goto L_0x0088
                                java.io.InputStream r1 = r5.getInputStream()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r2 = 6144(0x1800, float:8.61E-42)
                                byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0080, all -> 0x007b }
                                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0080, all -> 0x007b }
                                r6.<init>()     // Catch:{ Exception -> 0x0080, all -> 0x007b }
                            L_0x004a:
                                int r7 = r1.read(r2)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
                                r8 = -1
                                if (r7 == r8) goto L_0x0055
                                r6.write(r2, r4, r7)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
                                goto L_0x004a
                            L_0x0055:
                                byte[] r2 = r6.toByteArray()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
                                if (r2 == 0) goto L_0x006f
                                byte[] r2 = r6.toByteArray()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
                                boolean r7 = r4     // Catch:{ Exception -> 0x006b, all -> 0x0075 }
                                if (r7 != 0) goto L_0x0069
                                java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x006b, all -> 0x0075 }
                                r7.<init>(r2)     // Catch:{ Exception -> 0x006b, all -> 0x0075 }
                                goto L_0x0071
                            L_0x0069:
                                r7 = r3
                                goto L_0x0071
                            L_0x006b:
                                r5 = move-exception
                                r7 = r3
                                goto L_0x00b5
                            L_0x006f:
                                r2 = r3
                                r7 = r2
                            L_0x0071:
                                java.lang.String r8 = ""
                                r9 = 1
                                goto L_0x0099
                            L_0x0075:
                                r0 = move-exception
                                goto L_0x007d
                            L_0x0077:
                                r2 = move-exception
                                r5 = r3
                                r7 = r5
                                goto L_0x0084
                            L_0x007b:
                                r0 = move-exception
                                r6 = r3
                            L_0x007d:
                                r3 = r1
                                goto L_0x015d
                            L_0x0080:
                                r2 = move-exception
                                r5 = r3
                                r6 = r5
                                r7 = r6
                            L_0x0084:
                                r11 = r2
                                r2 = r1
                                r1 = r11
                                goto L_0x00c3
                            L_0x0088:
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r2.<init>(r1)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r2.append(r6)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
                                r1 = r3
                                r2 = r1
                                r6 = r2
                                r7 = r6
                                r9 = 0
                            L_0x0099:
                                r5.disconnect()     // Catch:{ Exception -> 0x00b4, all -> 0x0075 }
                                if (r1 == 0) goto L_0x00a4
                                r1.close()     // Catch:{ Exception -> 0x00a2 }
                                goto L_0x00a4
                            L_0x00a2:
                                r0 = move-exception
                                goto L_0x00aa
                            L_0x00a4:
                                if (r6 == 0) goto L_0x00b2
                                r6.close()     // Catch:{ Exception -> 0x00a2 }
                                goto L_0x00b2
                            L_0x00aa:
                                r0.printStackTrace()
                                java.lang.String r8 = r0.getMessage()
                                goto L_0x00f5
                            L_0x00b2:
                                r4 = r9
                                goto L_0x00f5
                            L_0x00b4:
                                r5 = move-exception
                            L_0x00b5:
                                r11 = r2
                                r2 = r1
                                r1 = r5
                                r5 = r11
                                goto L_0x00c3
                            L_0x00ba:
                                r0 = move-exception
                                r6 = r3
                                goto L_0x015d
                            L_0x00be:
                                r1 = move-exception
                                r2 = r3
                                r5 = r2
                                r6 = r5
                                r7 = r6
                            L_0x00c3:
                                java.lang.String r8 = r1.getMessage()     // Catch:{ all -> 0x015b }
                                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
                                r9.<init>()     // Catch:{ all -> 0x015b }
                                java.lang.String r10 = "getStringFromUrl failed "
                                r9.append(r10)     // Catch:{ all -> 0x015b }
                                java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x015b }
                                r9.append(r1)     // Catch:{ all -> 0x015b }
                                java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x015b }
                                com.mbridge.msdk.foundation.tools.aa.d(r0, r1)     // Catch:{ all -> 0x015b }
                                if (r2 == 0) goto L_0x00e7
                                r2.close()     // Catch:{ Exception -> 0x00e5 }
                                goto L_0x00e7
                            L_0x00e5:
                                r0 = move-exception
                                goto L_0x00ed
                            L_0x00e7:
                                if (r6 == 0) goto L_0x00f4
                                r6.close()     // Catch:{ Exception -> 0x00e5 }
                                goto L_0x00f4
                            L_0x00ed:
                                r0.printStackTrace()
                                java.lang.String r8 = r0.getMessage()
                            L_0x00f4:
                                r2 = r5
                            L_0x00f5:
                                if (r4 == 0) goto L_0x010a
                                boolean r0 = r4     // Catch:{ all -> 0x0108 }
                                if (r0 == 0) goto L_0x010a
                                if (r2 == 0) goto L_0x010a
                                int r0 = r2.length     // Catch:{ all -> 0x0108 }
                                if (r0 <= 0) goto L_0x010a
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x0108 }
                                java.lang.String r1 = r2     // Catch:{ all -> 0x0108 }
                                r0.a(r3, r2, r1)     // Catch:{ all -> 0x0108 }
                                goto L_0x015a
                            L_0x0108:
                                r0 = move-exception
                                goto L_0x0143
                            L_0x010a:
                                if (r4 == 0) goto L_0x012a
                                boolean r0 = com.mbridge.msdk.foundation.tools.ak.b(r7)     // Catch:{ all -> 0x0108 }
                                if (r0 == 0) goto L_0x012a
                                int r0 = r7.length()     // Catch:{ all -> 0x0108 }
                                if (r0 <= 0) goto L_0x012a
                                java.lang.String r0 = "<mbridgeloadend></mbridgeloadend>"
                                boolean r0 = r7.contains(r0)     // Catch:{ all -> 0x0108 }
                                if (r0 == 0) goto L_0x012a
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x0108 }
                                if (r0 == 0) goto L_0x015a
                                java.lang.String r1 = r2     // Catch:{ all -> 0x0108 }
                                r0.a(r7, r2, r1)     // Catch:{ all -> 0x0108 }
                                goto L_0x015a
                            L_0x012a:
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x0108 }
                                if (r0 == 0) goto L_0x015a
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
                                r1.<init>()     // Catch:{ all -> 0x0108 }
                                java.lang.String r2 = "content write failed:"
                                r1.append(r2)     // Catch:{ all -> 0x0108 }
                                r1.append(r8)     // Catch:{ all -> 0x0108 }
                                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0108 }
                                r0.a(r1)     // Catch:{ all -> 0x0108 }
                                goto L_0x015a
                            L_0x0143:
                                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                                if (r1 == 0) goto L_0x014a
                                r0.printStackTrace()
                            L_0x014a:
                                com.mbridge.msdk.videocommon.download.g$c r1 = r3
                                if (r1 == 0) goto L_0x015a
                                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0156 }
                                r1.a(r0)     // Catch:{ Exception -> 0x0156 }
                                goto L_0x015a
                            L_0x0156:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x015a:
                                return
                            L_0x015b:
                                r0 = move-exception
                                r3 = r2
                            L_0x015d:
                                if (r3 == 0) goto L_0x0165
                                r3.close()     // Catch:{ Exception -> 0x0163 }
                                goto L_0x0165
                            L_0x0163:
                                r1 = move-exception
                                goto L_0x016b
                            L_0x0165:
                                if (r6 == 0) goto L_0x0171
                                r6.close()     // Catch:{ Exception -> 0x0163 }
                                goto L_0x0171
                            L_0x016b:
                                r1.printStackTrace()
                                r1.getMessage()
                            L_0x0171:
                                goto L_0x0173
                            L_0x0172:
                                throw r0
                            L_0x0173:
                                goto L_0x0172
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.e.AnonymousClass1.a():void");
                        }
                    });
                    return;
                }
            }
            if (cVar != null) {
                cVar.a("url is error");
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
