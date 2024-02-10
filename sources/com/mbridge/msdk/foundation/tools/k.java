package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DynamicViewResourceManager */
public final class k {
    static final List<String> a;

    /* compiled from: DynamicViewResourceManager */
    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            if (TextUtils.isEmpty(substring)) {
                return "";
            }
            String replace = substring.replace(".zip", "");
            List<String> list = a;
            if (list == null || list.contains(replace)) {
                return "";
            }
            return replace;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00de A[SYNTHETIC, Splitter:B:57:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016d A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r22, java.lang.String r23, java.lang.String r24, com.mbridge.msdk.foundation.tools.k.a r25, com.mbridge.msdk.foundation.entity.CampaignEx r26) {
        /*
            r1 = r22
            java.lang.String r0 = ""
            java.lang.String r2 = "start download path： "
            boolean r3 = android.text.TextUtils.isEmpty(r24)
            if (r3 == 0) goto L_0x000e
            return
        L_0x000e:
            java.lang.String r3 = b(r22, r23, r24)     // Catch:{ Exception -> 0x0014 }
            r7 = r3
            goto L_0x0015
        L_0x0014:
            r7 = r0
        L_0x0015:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.mbridge.msdk.foundation.same.b.c r4 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML
            java.lang.String r4 = com.mbridge.msdk.foundation.same.b.e.b(r4)
            r3.append(r4)
            java.lang.String r4 = java.io.File.separator
            r3.append(r4)
            java.lang.String r9 = r3.toString()
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x003a }
            if (r4 != 0) goto L_0x003b
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x003a }
            r4.<init>(r9, r7)     // Catch:{ Exception -> 0x003a }
            r3 = r4
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r3 == 0) goto L_0x0043
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x0063
        L_0x0043:
            java.lang.String r3 = ".xml"
            java.lang.String r3 = r7.replace(r3, r0)
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            java.lang.String r6 = java.io.File.separator
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3, r7)
            r3 = r4
        L_0x0063:
            if (r3 == 0) goto L_0x0072
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0070 }
            if (r4 == 0) goto L_0x0072
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0073
        L_0x0070:
            r6 = r0
            goto L_0x0074
        L_0x0072:
            r3 = r0
        L_0x0073:
            r6 = r3
        L_0x0074:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = "2"
            java.lang.String r10 = "1"
            java.lang.String r5 = "type"
            r8 = 1
            if (r1 == 0) goto L_0x0095
            if (r1 == r8) goto L_0x0091
            r11 = 2
            if (r1 == r11) goto L_0x0089
            goto L_0x0098
        L_0x0089:
            java.lang.String r11 = "3"
            r3.put(r5, r11)     // Catch:{ Exception -> 0x008f }
            goto L_0x0098
        L_0x008f:
            goto L_0x0098
        L_0x0091:
            r3.put(r5, r4)     // Catch:{ Exception -> 0x008f }
            goto L_0x0098
        L_0x0095:
            r3.put(r5, r10)     // Catch:{ Exception -> 0x008f }
        L_0x0098:
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r14 = "cache"
            java.lang.String r15 = "DynamicViewResourceManager"
            java.lang.String r13 = "2000153"
            if (r5 != 0) goto L_0x00de
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x00de
            if (r25 == 0) goto L_0x00dd
            r8 = 0
            r9 = 1
            r4 = r25
            r5 = r24
            r4.a(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00bf
        L_0x00b6:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r15, r0)
        L_0x00bf:
            r3.put(r14, r10)     // Catch:{ Exception -> 0x00dd }
            if (r26 == 0) goto L_0x00dd
            if (r1 != 0) goto L_0x00d2
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r1 = r26.getCurrentLRid()     // Catch:{ Exception -> 0x00dd }
            r0.b(r13, r1, r3)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00dd
        L_0x00d2:
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r1 = r26.getCurrentLRid()     // Catch:{ Exception -> 0x00dd }
            r0.a((java.lang.String) r13, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x00dd }
        L_0x00dd:
            return
        L_0x00de:
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x015f }
            r5 = r24
            r1.<init>(r5)     // Catch:{ Exception -> 0x015f }
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x015f }
            r6 = 47
            int r6 = r1.lastIndexOf(r6)     // Catch:{ Exception -> 0x015f }
            int r6 = r6 + r8
            java.lang.String r10 = r1.substring(r6)     // Catch:{ Exception -> 0x015f }
            java.lang.String r1 = ".zip"
            java.lang.String r0 = r10.replace(r1, r0)     // Catch:{ Exception -> 0x015f }
            java.lang.String r1 = "test_zip_download "
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015f }
            r6.<init>(r2)     // Catch:{ Exception -> 0x015f }
            r6.append(r9)     // Catch:{ Exception -> 0x015f }
            r6.append(r10)     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.DownloadMessage r1 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x015f }
            java.lang.Object r17 = new java.lang.Object     // Catch:{ Exception -> 0x015f }
            r17.<init>()     // Catch:{ Exception -> 0x015f }
            r20 = 100
            com.mbridge.msdk.foundation.download.DownloadResourceType r21 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x015f }
            r16 = r1
            r18 = r24
            r19 = r10
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.MBDownloadManager r2 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r1 = r2.download(r1)     // Catch:{ Exception -> 0x015f }
            r6 = 30000(0x7530, double:1.4822E-319)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r1 = r1.withReadTimeout((long) r6)     // Catch:{ Exception -> 0x015f }
            r6 = 20000(0x4e20, double:9.8813E-320)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r1 = r1.withConnectTimeout((long) r6)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.DownloadPriority r2 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r1 = r1.withDownloadPriority(r2)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r1 = r1.withHttpRetryCounter(r8)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r1 = r1.withDirectoryPathInternal(r9)     // Catch:{ Exception -> 0x015f }
            com.mbridge.msdk.foundation.tools.k$1 r2 = new com.mbridge.msdk.foundation.tools.k$1     // Catch:{ Exception -> 0x015f }
            r8 = r2
            r11 = r25
            r12 = r24
            r5 = r13
            r13 = r0
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x015d }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r1.withDownloadStateListener(r2)     // Catch:{ Exception -> 0x015d }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r0.build()     // Catch:{ Exception -> 0x015d }
            r0.start()     // Catch:{ Exception -> 0x015d }
            goto L_0x0168
        L_0x015d:
            r0 = move-exception
            goto L_0x0161
        L_0x015f:
            r0 = move-exception
            r5 = r13
        L_0x0161:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r15, r0)
        L_0x0168:
            r3.put(r14, r4)     // Catch:{ Exception -> 0x0178 }
            if (r26 == 0) goto L_0x0178
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r1 = r26.getCurrentLRid()     // Catch:{ Exception -> 0x0178 }
            r0.a((java.lang.String) r5, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x0178 }
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.k.a(int, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.k$a, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    public static String a(int i, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = b(i, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        String str4 = e.b(c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(str4, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str4 + File.separator + str3.replace(".xml", ""), str3);
        }
        if (file != null) {
            return file.getPath();
        }
        return "";
    }

    private static String b(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            String path = new URL(str2).getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            if (!TextUtils.isEmpty(substring)) {
                return substring.replace(".zip", "");
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC, Splitter:B:16:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            android.net.Uri r0 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "natmp"
            java.lang.String r0 = r0.getQueryParameter(r2)     // Catch:{ all -> 0x0022 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r0 = b(r11)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r0 = r1
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0030
            return r1
        L_0x0030:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            r2.<init>()     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.b(r3)     // Catch:{ Exception -> 0x00b5 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x00b5 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b5 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00b5 }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00b5 }
            boolean r0 = r3.isFile()     // Catch:{ Exception -> 0x00b5 }
            if (r0 == 0) goto L_0x005d
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00b5 }
            if (r0 == 0) goto L_0x005d
            java.lang.String r11 = r3.getPath()     // Catch:{ Exception -> 0x00b5 }
            return r11
        L_0x005d:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00b5 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x00b5 }
            r3 = 47
            int r3 = r0.lastIndexOf(r3)     // Catch:{ Exception -> 0x00b5 }
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r0 = r0.substring(r3)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.DownloadMessage r3 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x00b5 }
            r6.<init>()     // Catch:{ Exception -> 0x00b5 }
            r9 = 100
            com.mbridge.msdk.foundation.download.DownloadResourceType r10 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x00b5 }
            r5 = r3
            r7 = r11
            r8 = r0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.MBDownloadManager r11 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.download(r3)     // Catch:{ Exception -> 0x00b5 }
            r5 = 30000(0x7530, double:1.4822E-319)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withReadTimeout((long) r5)     // Catch:{ Exception -> 0x00b5 }
            r5 = 20000(0x4e20, double:9.8813E-320)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withConnectTimeout((long) r5)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.DownloadPriority r3 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadPriority(r3)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withHttpRetryCounter(r4)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDirectoryPathInternal(r2)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.tools.k$2 r3 = new com.mbridge.msdk.foundation.tools.k$2     // Catch:{ Exception -> 0x00b5 }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadStateListener(r3)     // Catch:{ Exception -> 0x00b5 }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r11 = r11.build()     // Catch:{ Exception -> 0x00b5 }
            r11.start()     // Catch:{ Exception -> 0x00b5 }
        L_0x00b5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.k.a(java.lang.String):java.lang.String");
    }
}
