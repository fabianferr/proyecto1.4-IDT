package com.startapp;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.apache.http.client.cache.HeaderConstants;

/* compiled from: Sta */
public class z5 {

    /* compiled from: Sta */
    public static class a {
        public String a;
        public String b;
        public String c;
        public Map<String, List<String>> d;
        public long e;
        public long f;
        public long g;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0082, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
        r3 = r9;
        r5 = r11;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0088, code lost:
        r11 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8, byte[] r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11, boolean r12) throws com.startapp.sdk.common.SDKException {
        /*
            java.lang.String r5 = "application/json"
            r6 = 0
            r7 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            java.net.HttpURLConnection r10 = a(r0, r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            if (r9 == 0) goto L_0x0028
            int r11 = r9.length     // Catch:{ IOException -> 0x008b, all -> 0x0087 }
            if (r11 <= 0) goto L_0x0028
            java.io.OutputStream r11 = r10.getOutputStream()     // Catch:{ all -> 0x0022 }
            r11.write(r9)     // Catch:{ all -> 0x0020 }
            r11.flush()     // Catch:{ all -> 0x0020 }
            com.startapp.a0.a((java.io.Closeable) r11)     // Catch:{ IOException -> 0x008b, all -> 0x0087 }
            goto L_0x0028
        L_0x0020:
            r9 = move-exception
            goto L_0x0024
        L_0x0022:
            r9 = move-exception
            r11 = r6
        L_0x0024:
            com.startapp.a0.a((java.io.Closeable) r11)     // Catch:{ IOException -> 0x008b, all -> 0x0087 }
            throw r9     // Catch:{ IOException -> 0x008b, all -> 0x0087 }
        L_0x0028:
            int r9 = r10.getResponseCode()     // Catch:{ IOException -> 0x008b, all -> 0x0087 }
            r11 = 200(0xc8, float:2.8E-43)
            if (r9 != r11) goto L_0x0066
            java.io.InputStream r11 = r10.getInputStream()     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            if (r11 == 0) goto L_0x005f
            java.io.StringWriter r12 = new java.io.StringWriter     // Catch:{ IOException -> 0x005b }
            r12.<init>()     // Catch:{ IOException -> 0x005b }
            r0 = 1024(0x400, float:1.435E-42)
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x005b }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005b }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r11, r3)     // Catch:{ IOException -> 0x005b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x005b }
        L_0x004b:
            int r2 = r1.read(r0)     // Catch:{ IOException -> 0x005b }
            r3 = -1
            if (r2 == r3) goto L_0x0056
            r12.write(r0, r7, r2)     // Catch:{ IOException -> 0x005b }
            goto L_0x004b
        L_0x0056:
            java.lang.String r6 = r12.toString()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r12 = move-exception
            r3 = r9
            r5 = r12
            goto L_0x0097
        L_0x005f:
            com.startapp.a0.a((java.io.Closeable) r11)
            r10.disconnect()
            return r6
        L_0x0066:
            android.net.Uri r11 = android.net.Uri.parse(r8)     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            android.net.Uri$Builder r11 = r11.buildUpon()     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            android.net.Uri$Builder r11 = r11.query(r6)     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            android.net.Uri r2 = r11.build()     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            com.startapp.sdk.common.SDKException r11 = new com.startapp.sdk.common.SDKException     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            java.lang.String r1 = "POST"
            r4 = 0
            r5 = 0
            r0 = r11
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
            throw r11     // Catch:{ IOException -> 0x0082, all -> 0x0087 }
        L_0x0082:
            r11 = move-exception
            r3 = r9
            r5 = r11
            r11 = r6
            goto L_0x0097
        L_0x0087:
            r8 = move-exception
            r11 = r6
        L_0x0089:
            r6 = r10
            goto L_0x00b3
        L_0x008b:
            r9 = move-exception
            r5 = r9
            r11 = r6
            goto L_0x0096
        L_0x008f:
            r8 = move-exception
            r11 = r6
            goto L_0x00b3
        L_0x0092:
            r9 = move-exception
            r5 = r9
            r10 = r6
            r11 = r10
        L_0x0096:
            r3 = 0
        L_0x0097:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x00b1 }
            android.net.Uri$Builder r8 = r8.buildUpon()     // Catch:{ all -> 0x00b1 }
            android.net.Uri$Builder r8 = r8.query(r6)     // Catch:{ all -> 0x00b1 }
            android.net.Uri r2 = r8.build()     // Catch:{ all -> 0x00b1 }
            com.startapp.sdk.common.SDKException r8 = new com.startapp.sdk.common.SDKException     // Catch:{ all -> 0x00b1 }
            java.lang.String r1 = "POST"
            r4 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b1 }
            throw r8     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r8 = move-exception
            goto L_0x0089
        L_0x00b3:
            com.startapp.a0.a((java.io.Closeable) r11)
            if (r6 == 0) goto L_0x00bb
            r6.disconnect()
        L_0x00bb:
            goto L_0x00bd
        L_0x00bc:
            throw r8
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.z5.a(java.lang.String, byte[], java.util.Map, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        r3 = r10;
        r5 = r11;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x000c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.z5.a a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10, boolean r11) throws com.startapp.sdk.common.SDKException {
        /*
            r1 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            java.net.HttpURLConnection r9 = a(r0, r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
            int r10 = r9.getResponseCode()     // Catch:{ IOException -> 0x0092, all -> 0x008e }
            r11 = 200(0xc8, float:2.8E-43)
            if (r10 != r11) goto L_0x006d
            java.net.CookieManager r11 = com.startapp.v1.a     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            if (r11 == 0) goto L_0x0023
            java.net.URI r0 = java.net.URI.create(r8)     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            java.util.Map r1 = r9.getHeaderFields()     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            r11.put(r0, r1)     // Catch:{ IOException -> 0x0089, all -> 0x008e }
        L_0x0023:
            java.io.InputStream r11 = r9.getInputStream()     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            com.startapp.z5$a r0 = new com.startapp.z5$a     // Catch:{ IOException -> 0x0069 }
            r0.<init>()     // Catch:{ IOException -> 0x0069 }
            r0.a = r8     // Catch:{ IOException -> 0x0069 }
            java.lang.String r1 = r9.getContentType()     // Catch:{ IOException -> 0x0069 }
            r0.c = r1     // Catch:{ IOException -> 0x0069 }
            java.util.Map r1 = r9.getHeaderFields()     // Catch:{ IOException -> 0x0069 }
            r0.d = r1     // Catch:{ IOException -> 0x0069 }
            if (r11 == 0) goto L_0x0062
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch:{ IOException -> 0x0069 }
            r1.<init>()     // Catch:{ IOException -> 0x0069 }
            r2 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0069 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0069 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0069 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0069 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0069 }
        L_0x0051:
            int r4 = r3.read(r2)     // Catch:{ IOException -> 0x0069 }
            r5 = -1
            if (r4 == r5) goto L_0x005c
            r1.write(r2, r7, r4)     // Catch:{ IOException -> 0x0069 }
            goto L_0x0051
        L_0x005c:
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0069 }
            r0.b = r1     // Catch:{ IOException -> 0x0069 }
        L_0x0062:
            com.startapp.a0.a((java.io.Closeable) r11)
            r9.disconnect()
            return r0
        L_0x0069:
            r0 = move-exception
            r3 = r10
            r5 = r0
            goto L_0x009e
        L_0x006d:
            android.net.Uri r11 = android.net.Uri.parse(r8)     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            android.net.Uri$Builder r11 = r11.buildUpon()     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            android.net.Uri$Builder r11 = r11.query(r6)     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            android.net.Uri r2 = r11.build()     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            com.startapp.sdk.common.SDKException r11 = new com.startapp.sdk.common.SDKException     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            java.lang.String r1 = "GET"
            r4 = 1
            r5 = 0
            r0 = r11
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x0089, all -> 0x008e }
            throw r11     // Catch:{ IOException -> 0x0089, all -> 0x008e }
        L_0x0089:
            r11 = move-exception
            r3 = r10
            r5 = r11
            r11 = r6
            goto L_0x009e
        L_0x008e:
            r8 = move-exception
            r11 = r6
        L_0x0090:
            r6 = r9
            goto L_0x00ba
        L_0x0092:
            r11 = move-exception
            r5 = r11
            r11 = r6
            goto L_0x009d
        L_0x0096:
            r8 = move-exception
            r11 = r6
            goto L_0x00ba
        L_0x0099:
            r11 = move-exception
            r5 = r11
            r9 = r6
            r11 = r9
        L_0x009d:
            r3 = 0
        L_0x009e:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x00b8 }
            android.net.Uri$Builder r8 = r8.buildUpon()     // Catch:{ all -> 0x00b8 }
            android.net.Uri$Builder r8 = r8.query(r6)     // Catch:{ all -> 0x00b8 }
            android.net.Uri r2 = r8.build()     // Catch:{ all -> 0x00b8 }
            com.startapp.sdk.common.SDKException r8 = new com.startapp.sdk.common.SDKException     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = "GET"
            r4 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b8 }
            throw r8     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r8 = move-exception
            goto L_0x0090
        L_0x00ba:
            com.startapp.a0.a((java.io.Closeable) r11)
            if (r6 == 0) goto L_0x00c2
            r6.disconnect()
        L_0x00c2:
            goto L_0x00c4
        L_0x00c3:
            throw r8
        L_0x00c4:
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.z5.a(java.lang.String, java.util.Map, java.lang.String, boolean):com.startapp.z5$a");
    }

    public static HttpURLConnection a(String str, byte[] bArr, Map<String, String> map, String str2, boolean z, String str3) throws IOException {
        Map<String, List<String>> map2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.addRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        CookieManager cookieManager = v1.a;
        if (cookieManager != null && (map2 = cookieManager.get(URI.create(str), httpURLConnection.getRequestProperties())) != null && map2.size() > 0 && map2.get("Cookie").size() > 0) {
            httpURLConnection.addRequestProperty("Cookie", TextUtils.join("=", map2.get("Cookie")));
        }
        if (str2 != null && str2.length() > 0) {
            httpURLConnection.addRequestProperty("User-Agent", str2);
        }
        httpURLConnection.setRequestProperty("Accept", "application/json;text/html;text/plain");
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setConnectTimeout(10000);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            if (str3 != null) {
                httpURLConnection.setRequestProperty("Content-Type", str3);
            }
            if (z) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
        } else {
            httpURLConnection.setRequestMethod("GET");
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                if (!(str4 == null || str5 == null)) {
                    httpURLConnection.setRequestProperty(str4, str5);
                }
            }
        }
        return httpURLConnection;
    }

    public static String a(Context context) {
        int i;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "e101";
        }
        if (Build.VERSION.SDK_INT < 30) {
            i = telephonyManager.getNetworkType();
        } else {
            i = telephonyManager.getDataNetworkType();
        }
        return Integer.toString(i);
    }
}
