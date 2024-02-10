package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.videocommon.download.f;
import com.mbridge.msdk.videocommon.download.h;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: H5DownLoadManager */
public class g {
    private static g c;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<String> a;
    private ConcurrentMap<String, b> b;
    private k d;
    /* access modifiers changed from: private */
    public h e;
    private boolean f = false;
    private final String g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private final String h = "down_type";

    /* compiled from: H5DownLoadManager */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, boolean z);
    }

    /* compiled from: H5DownLoadManager */
    public interface b extends a {
    }

    /* compiled from: H5DownLoadManager */
    public interface c {
        void a();

        void a(String str);

        void a(String str, byte[] bArr, String str2);
    }

    /* compiled from: H5DownLoadManager */
    public interface d extends a {
    }

    private g() {
        try {
            this.d = k.a();
            this.e = h.a.a;
            this.a = new CopyOnWriteArrayList<>();
            this.b = new ConcurrentHashMap();
            e b2 = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (b2 != null) {
                this.f = b2.i(1);
            }
        } catch (Throwable th) {
            aa.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (c == null) {
                c = new g();
            }
            gVar = c;
        }
        return gVar;
    }

    public final String a(String str) {
        k kVar = this.d;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }

    public final void a(final String str, final a aVar) {
        if (!this.f) {
            try {
                aa.d("H5DownLoadManager", "download url:" + str);
                if (!this.a.contains(str)) {
                    this.a.add(str);
                    f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() {
                        public final void b() {
                        }

                        public final void a() {
                            if (!TextUtils.isEmpty(g.this.e.b(str))) {
                                g.this.a.remove(str);
                                a aVar = aVar;
                                if (aVar != null) {
                                    aVar.a(str, "", true);
                                    return;
                                }
                                return;
                            }
                            e.a(str, new c() {
                                public final void a() {
                                }

                                public final void a(String str, byte[] bArr, String str2) {
                                    try {
                                        g.this.a.remove(str2);
                                        if (bArr != null && bArr.length > 0) {
                                            if (g.this.e.a(str2, bArr)) {
                                                if (aVar != null) {
                                                    aVar.a(str2, "", false);
                                                }
                                            } else if (aVar != null) {
                                                aVar.a(str2, "save file failed");
                                            }
                                        }
                                    } catch (Exception e) {
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (aVar != null) {
                                            aVar.a(str2, e.getMessage());
                                        }
                                    }
                                }

                                public final void a(String str) {
                                    try {
                                        g.this.a.remove(str);
                                        if (aVar != null) {
                                            aVar.a(str, str);
                                        }
                                    } catch (Exception e) {
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (aVar != null) {
                                            aVar.a(str, str);
                                        }
                                    }
                                }
                            }, true);
                        }
                    });
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (!TextUtils.isEmpty(str)) {
            try {
                new URL(str);
                String md5 = SameMD5.getMD5(al.b(str));
                MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str, md5 + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withReadTimeout(30000).withConnectTimeout(20000).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + "/").withDownloadStateListener(new OnDownloadStateListener() {
                    public final void onCancelDownload(DownloadMessage downloadMessage) {
                    }

                    public final void onDownloadStart(DownloadMessage downloadMessage) {
                    }

                    public final void onDownloadComplete(DownloadMessage downloadMessage) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a(str, "", false);
                        }
                    }

                    public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a(str, downloadError.getException().getMessage());
                        }
                    }
                }).build().start();
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.a("zip url is unlawful", str);
                }
            }
        } else if (aVar != null) {
            aVar.a("zip url is null", str);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0171 */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bc A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01cd A[Catch:{ Exception -> 0x01f1 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:92:0x01c7=Splitter:B:92:0x01c7, B:83:0x019b=Splitter:B:83:0x019b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map<java.lang.String, java.lang.String> r20, java.lang.String r21, com.mbridge.msdk.videocommon.download.g.a r22) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r8 = r21
            r9 = r22
            java.lang.String r2 = "/"
            java.lang.String r3 = "h3c"
            java.lang.String r4 = ".zip"
            java.util.regex.Pattern r5 = android.util.Patterns.WEB_URL     // Catch:{ Exception -> 0x01f4 }
            java.util.regex.Matcher r5 = r5.matcher(r8)     // Catch:{ Exception -> 0x01f4 }
            boolean r5 = r5.matches()     // Catch:{ Exception -> 0x01f4 }
            if (r5 != 0) goto L_0x0025
            boolean r5 = android.webkit.URLUtil.isValidUrl(r21)     // Catch:{ Exception -> 0x01f4 }
            if (r5 == 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            r2 = r8
            r3 = r9
            goto L_0x01fa
        L_0x0025:
            android.net.Uri r5 = android.net.Uri.parse(r21)     // Catch:{ Exception -> 0x01f4 }
            java.lang.String r5 = r5.getPath()     // Catch:{ Exception -> 0x01f4 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01f4 }
            if (r6 != 0) goto L_0x0021
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ Exception -> 0x01f4 }
            boolean r5 = r5.endsWith(r4)     // Catch:{ Exception -> 0x01f4 }
            if (r5 == 0) goto L_0x01ec
            r10 = r9
            com.mbridge.msdk.videocommon.download.g$d r10 = (com.mbridge.msdk.videocommon.download.g.d) r10     // Catch:{ Exception -> 0x01e7 }
            boolean r5 = r1.f     // Catch:{ Exception -> 0x01e7 }
            java.lang.String r12 = "down_type"
            java.lang.String r13 = "local_rid"
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0151
            boolean r5 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01e7 }
            if (r5 == 0) goto L_0x005a
            if (r10 == 0) goto L_0x01f1
            java.lang.String r0 = "zip url is null"
            r10.a(r8, r0)     // Catch:{ Exception -> 0x01f4 }
            goto L_0x01f1
        L_0x005a:
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x013f }
            r5.<init>(r8)     // Catch:{ Exception -> 0x013f }
            r5 = 0
            if (r0 == 0) goto L_0x00a3
            boolean r7 = r0.containsKey(r13)     // Catch:{ Exception -> 0x01f4 }
            if (r7 == 0) goto L_0x006f
            java.lang.Object r7 = r0.get(r13)     // Catch:{ Exception -> 0x01f4 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x01f4 }
            goto L_0x0070
        L_0x006f:
            r7 = r6
        L_0x0070:
            boolean r14 = r0.containsKey(r12)     // Catch:{ Exception -> 0x01f4 }
            if (r14 == 0) goto L_0x007c
            java.lang.Object r6 = r0.get(r12)     // Catch:{ Exception -> 0x01f4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01f4 }
        L_0x007c:
            boolean r14 = r0.containsKey(r3)     // Catch:{ Exception -> 0x01f4 }
            if (r14 == 0) goto L_0x00a0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x01f4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01f4 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0096 }
            if (r3 != 0) goto L_0x0092
            int r5 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0096 }
        L_0x0092:
            r0 = r5
            r15 = r6
            r14 = r7
            goto L_0x00a6
        L_0x0096:
            r0 = move-exception
            java.lang.String r3 = "H5DownLoadManager"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x01f4 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x01f4 }
        L_0x00a0:
            r15 = r6
            r14 = r7
            goto L_0x00a5
        L_0x00a3:
            r14 = r6
            r15 = r14
        L_0x00a5:
            r0 = 0
        L_0x00a6:
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES     // Catch:{ Exception -> 0x014c }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.b(r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.al.b(r21)     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r5)     // Catch:{ Exception -> 0x014c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r6.<init>()     // Catch:{ Exception -> 0x014c }
            r6.append(r3)     // Catch:{ Exception -> 0x014c }
            r6.append(r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r7 = r6.toString()     // Catch:{ Exception -> 0x014c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r6.<init>()     // Catch:{ Exception -> 0x014c }
            r6.append(r3)     // Catch:{ Exception -> 0x014c }
            r6.append(r2)     // Catch:{ Exception -> 0x014c }
            r6.append(r5)     // Catch:{ Exception -> 0x014c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.DownloadMessage r3 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x014c }
            java.lang.Object r16 = new java.lang.Object     // Catch:{ Exception -> 0x014c }
            r16.<init>()     // Catch:{ Exception -> 0x014c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r2.<init>()     // Catch:{ Exception -> 0x014c }
            r2.append(r5)     // Catch:{ Exception -> 0x014c }
            r2.append(r4)     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x014c }
            r17 = 100
            com.mbridge.msdk.foundation.download.DownloadResourceType r18 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP     // Catch:{ Exception -> 0x014c }
            r2 = r3
            r4 = r3
            r3 = r16
            r11 = r4
            r4 = r21
            r9 = r6
            r6 = r17
            r8 = r7
            r7 = r18
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x014c }
            r11.setUseCronetDownload(r0)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.MBDownloadManager r0 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.download(r11)     // Catch:{ Exception -> 0x014c }
            r2 = 30000(0x7530, double:1.4822E-319)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withReadTimeout((long) r2)     // Catch:{ Exception -> 0x014c }
            r2 = 20000(0x4e20, double:9.8813E-320)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withConnectTimeout((long) r2)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.DownloadPriority r2 = com.mbridge.msdk.foundation.download.DownloadPriority.HIGH     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withDownloadPriority(r2)     // Catch:{ Exception -> 0x014c }
            r2 = 1
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withHttpRetryCounter(r2)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withDirectoryPathInternal(r8)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.with(r13, r14)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.with(r12, r15)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.videocommon.download.g$1 r2 = new com.mbridge.msdk.videocommon.download.g$1     // Catch:{ Exception -> 0x014c }
            r2.<init>(r9, r10)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withDownloadStateListener(r2)     // Catch:{ Exception -> 0x014c }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r0.build()     // Catch:{ Exception -> 0x014c }
            r0.start()     // Catch:{ Exception -> 0x014c }
            goto L_0x01f1
        L_0x013f:
            if (r10 == 0) goto L_0x01f1
            java.lang.String r0 = "zip url is unlawful"
            r2 = r21
            r10.a(r2, r0)     // Catch:{ Exception -> 0x01e5 }
            goto L_0x01f1
        L_0x014c:
            r0 = move-exception
            r2 = r21
            goto L_0x01e9
        L_0x0151:
            r2 = r8
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x01e5 }
            r3.<init>()     // Catch:{ Exception -> 0x01e5 }
            if (r0 == 0) goto L_0x0170
            int r4 = r20.size()     // Catch:{ Exception -> 0x0170 }
            if (r4 <= 0) goto L_0x0170
            java.lang.Object r4 = r0.get(r13)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0170 }
            java.lang.String r5 = "type"
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x0171 }
            r3.put(r5, r0)     // Catch:{ Exception -> 0x0171 }
            goto L_0x0171
        L_0x0170:
            r4 = r6
        L_0x0171:
            com.mbridge.msdk.videocommon.download.k r0 = r1.d     // Catch:{ Exception -> 0x01d5 }
            java.lang.String r0 = r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x01d5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01d5 }
            java.lang.String r5 = "2000153"
            java.lang.String r7 = "cache"
            if (r0 == 0) goto L_0x01bc
            java.lang.String r0 = "2"
            r3.put(r7, r0)     // Catch:{ Exception -> 0x01d5 }
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r0 = r1.b     // Catch:{ Exception -> 0x01d5 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ Exception -> 0x01d5 }
            if (r0 == 0) goto L_0x01a9
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r0 = r1.b     // Catch:{ Exception -> 0x01d5 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x01d5 }
            com.mbridge.msdk.videocommon.download.b r0 = (com.mbridge.msdk.videocommon.download.b) r0     // Catch:{ Exception -> 0x01d5 }
            if (r0 == 0) goto L_0x019b
            r0.a((com.mbridge.msdk.videocommon.download.g.d) r10)     // Catch:{ Exception -> 0x01d5 }
        L_0x019b:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01f1 }
            if (r0 != 0) goto L_0x01f1
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x01f1 }
            r0.a((java.lang.String) r5, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x01f1 }
            goto L_0x01f1
        L_0x01a9:
            com.mbridge.msdk.videocommon.download.b r0 = new com.mbridge.msdk.videocommon.download.b     // Catch:{ Exception -> 0x01d5 }
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r6 = r1.b     // Catch:{ Exception -> 0x01d5 }
            com.mbridge.msdk.videocommon.download.k r7 = r1.d     // Catch:{ Exception -> 0x01d5 }
            r0.<init>(r6, r7, r10, r2)     // Catch:{ Exception -> 0x01d5 }
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r6 = r1.b     // Catch:{ Exception -> 0x01d5 }
            r6.put(r2, r0)     // Catch:{ Exception -> 0x01d5 }
            r6 = 1
            com.mbridge.msdk.videocommon.download.e.a(r2, r0, r6)     // Catch:{ Exception -> 0x01d5 }
            goto L_0x01c7
        L_0x01bc:
            java.lang.String r0 = "1"
            r3.put(r7, r0)     // Catch:{ Exception -> 0x01d5 }
            if (r10 == 0) goto L_0x01c7
            r7 = 1
            r10.a(r2, r6, r7)     // Catch:{ Exception -> 0x01d5 }
        L_0x01c7:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01f1 }
            if (r0 != 0) goto L_0x01f1
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x01f1 }
            r0.a((java.lang.String) r5, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x01f1 }
            goto L_0x01f1
        L_0x01d5:
            r0 = move-exception
            if (r10 == 0) goto L_0x01dd
            java.lang.String r3 = "downloadzip failed"
            r10.a(r2, r3)     // Catch:{ Exception -> 0x01e5 }
        L_0x01dd:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01e5 }
            if (r3 == 0) goto L_0x01f1
            r0.printStackTrace()     // Catch:{ Exception -> 0x01e5 }
            goto L_0x01f1
        L_0x01e5:
            r0 = move-exception
            goto L_0x01e9
        L_0x01e7:
            r0 = move-exception
            r2 = r8
        L_0x01e9:
            r3 = r22
            goto L_0x01f7
        L_0x01ec:
            r2 = r8
            r3 = r9
            r1.a(r2, r3)     // Catch:{ Exception -> 0x01f2 }
        L_0x01f1:
            return
        L_0x01f2:
            r0 = move-exception
            goto L_0x01f7
        L_0x01f4:
            r0 = move-exception
            r2 = r8
            r3 = r9
        L_0x01f7:
            r0.printStackTrace()
        L_0x01fa:
            if (r3 == 0) goto L_0x0201
            java.lang.String r0 = "The URL does not contain a path "
            r3.a(r2, r0)
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.g.a(java.util.Map, java.lang.String, com.mbridge.msdk.videocommon.download.g$a):void");
    }

    public final String b(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return a(str);
                }
                h hVar = this.e;
                if (hVar != null) {
                    return hVar.a(str);
                }
                return str;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }
}
