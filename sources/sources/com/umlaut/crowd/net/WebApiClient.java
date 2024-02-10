package com.umlaut.crowd.net;

import com.umlaut.crowd.internal.vd;
import java.io.IOException;

public abstract class WebApiClient {
    private static final String a = "WebApiClient";
    private static final int b = 10000;

    public enum RequestMethod {
        POST,
        GET,
        PUT,
        DELETE
    }

    public static WebApiResponse sendJsonRequest(RequestMethod requestMethod, String str) throws IOException {
        return sendJsonRequest(requestMethod, str, (Object) null);
    }

    public static WebApiResponse sendJsonRequest(RequestMethod requestMethod, String str, Object obj) throws IOException {
        return sendJsonRequest(requestMethod, str, obj, new vd[]{new vd("Content-Type", "application/json; charset=UTF-8"), new vd("Accept", "application/json")});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        r3 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        android.util.Log.d(a, "read response body: " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ee, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ef, code lost:
        r3 = r10;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0120, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0121, code lost:
        android.util.Log.d(a, "outputStream.close: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0138, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0139, code lost:
        android.util.Log.d(a, " bufferedReader.close: " + r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[SYNTHETIC, Splitter:B:37:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC, Splitter:B:42:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[ExcHandler: all (th java.lang.Throwable), PHI: r8 
      PHI: (r8v13 java.io.BufferedReader) = (r8v18 java.io.BufferedReader), (r8v18 java.io.BufferedReader), (r8v21 java.io.BufferedReader) binds: [B:34:0x009a, B:35:?, B:27:0x008a] A[DONT_GENERATE, DONT_INLINE], Splitter:B:27:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee A[ExcHandler: all (th java.lang.Throwable), PHI: r10 
      PHI: (r10v14 java.io.OutputStream) = (r10v16 java.io.OutputStream), (r10v16 java.io.OutputStream), (r10v16 java.io.OutputStream), (r10v16 java.io.OutputStream), (r10v24 java.io.OutputStream), (r10v24 java.io.OutputStream) binds: [B:23:0x0076, B:24:?, B:25:0x007c, B:26:?, B:13:0x005a, B:14:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:13:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c A[SYNTHETIC, Splitter:B:62:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0134 A[SYNTHETIC, Splitter:B:67:0x0134] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.net.WebApiResponse sendJsonRequest(com.umlaut.crowd.net.WebApiClient.RequestMethod r8, java.lang.String r9, java.lang.Object r10, com.umlaut.crowd.internal.vd[] r11) throws java.io.IOException {
        /*
            com.umlaut.crowd.net.WebApiResponse r0 = new com.umlaut.crowd.net.WebApiResponse
            r0.<init>()
            com.umlaut.crowd.IC r1 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r1 = r1.v0()
            r2 = 10000(0x2710, float:1.4013E-41)
            java.net.HttpURLConnection r9 = com.umlaut.crowd.internal.j3.a((java.lang.String) r9, (int) r2, (boolean) r1)
            java.lang.String r1 = r8.toString()
            r9.setRequestMethod(r1)
            if (r11 == 0) goto L_0x002c
            int r1 = r11.length
            r3 = 0
        L_0x001e:
            if (r3 >= r1) goto L_0x002c
            r4 = r11[r3]
            java.lang.String r5 = r4.a
            java.lang.String r4 = r4.b
            r9.setRequestProperty(r5, r4)
            int r3 = r3 + 1
            goto L_0x001e
        L_0x002c:
            r9.setConnectTimeout(r2)
            r9.setReadTimeout(r2)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = " bufferedReader.close: "
            java.lang.String r2 = "outputStream.close: "
            r3 = 0
            if (r10 == 0) goto L_0x0075
            com.umlaut.crowd.net.WebApiClient$RequestMethod r4 = com.umlaut.crowd.net.WebApiClient.RequestMethod.GET     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            boolean r4 = r8.equals(r4)     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            if (r4 != 0) goto L_0x0065
            com.umlaut.crowd.net.WebApiClient$RequestMethod r4 = com.umlaut.crowd.net.WebApiClient.RequestMethod.DELETE     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            boolean r8 = r8.equals(r4)     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            if (r8 != 0) goto L_0x0065
            r8 = 1
            r9.setDoOutput(r8)     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            java.lang.String r8 = com.umlaut.crowd.utils.JsonUtils.toJson(r10)     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            java.io.OutputStream r10 = r9.getOutputStream()     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x00f3, all -> 0x00ee }
            r10.write(r8)     // Catch:{ Exception -> 0x00f3, all -> 0x00ee }
            r10.flush()     // Catch:{ Exception -> 0x00f3, all -> 0x00ee }
            goto L_0x0076
        L_0x0065:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            java.lang.String r10 = "GET and DELETE does not support a body"
            r8.<init>(r10)     // Catch:{ Exception -> 0x0071, all -> 0x006d }
            throw r8     // Catch:{ Exception -> 0x0071, all -> 0x006d }
        L_0x006d:
            r8 = move-exception
            r10 = r3
            goto L_0x0117
        L_0x0071:
            r8 = move-exception
            r10 = r3
            goto L_0x00f4
        L_0x0075:
            r10 = r3
        L_0x0076:
            int r8 = r9.getResponseCode()     // Catch:{ Exception -> 0x00f3, all -> 0x00ee }
            r0.responseCode = r8     // Catch:{ Exception -> 0x00f3, all -> 0x00ee }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0096, all -> 0x00ee }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0096, all -> 0x00ee }
            java.io.InputStream r5 = r9.getInputStream()     // Catch:{ Exception -> 0x0096, all -> 0x00ee }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0096, all -> 0x00ee }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0096, all -> 0x00ee }
        L_0x008a:
            java.lang.String r3 = r8.readLine()     // Catch:{ Exception -> 0x0094, all -> 0x00ea }
            if (r3 == 0) goto L_0x00b0
            r11.append(r3)     // Catch:{ Exception -> 0x0094, all -> 0x00ea }
            goto L_0x008a
        L_0x0094:
            r3 = move-exception
            goto L_0x009a
        L_0x0096:
            r8 = move-exception
            r7 = r3
            r3 = r8
            r8 = r7
        L_0x009a:
            java.lang.String r4 = a     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            r5.<init>()     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            java.lang.String r6 = "read response body: "
            r5.append(r6)     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            r5.append(r3)     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
            android.util.Log.d(r4, r3)     // Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        L_0x00b0:
            if (r10 == 0) goto L_0x00c8
            r10.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c8
        L_0x00b6:
            r10 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            android.util.Log.d(r3, r10)
        L_0x00c8:
            if (r8 == 0) goto L_0x00e0
            r8.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00e0
        L_0x00ce:
            r8 = move-exception
            java.lang.String r10 = a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.d(r10, r8)
        L_0x00e0:
            r9.disconnect()
            java.lang.String r8 = r11.toString()
            r0.content = r8
            return r0
        L_0x00ea:
            r11 = move-exception
            goto L_0x011a
        L_0x00ec:
            r11 = move-exception
            goto L_0x00f6
        L_0x00ee:
            r8 = move-exception
            r7 = r3
            r3 = r10
            r10 = r7
            goto L_0x0117
        L_0x00f3:
            r8 = move-exception
        L_0x00f4:
            r11 = r8
            r8 = r3
        L_0x00f6:
            r3 = r10
            java.lang.String r10 = a     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r0.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "sendJsonRequest: "
            r0.append(r4)     // Catch:{ all -> 0x0113 }
            r0.append(r11)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0113 }
            android.util.Log.d(r10, r0)     // Catch:{ all -> 0x0113 }
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0113 }
            r10.<init>(r11)     // Catch:{ all -> 0x0113 }
            throw r10     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0117:
            r11 = r8
            r8 = r10
            r10 = r3
        L_0x011a:
            if (r10 == 0) goto L_0x0132
            r10.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0132
        L_0x0120:
            r10 = move-exception
            java.lang.String r0 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            android.util.Log.d(r0, r10)
        L_0x0132:
            if (r8 == 0) goto L_0x014a
            r8.close()     // Catch:{ IOException -> 0x0138 }
            goto L_0x014a
        L_0x0138:
            r8 = move-exception
            java.lang.String r10 = a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.util.Log.d(r10, r8)
        L_0x014a:
            r9.disconnect()
            goto L_0x014f
        L_0x014e:
            throw r11
        L_0x014f:
            goto L_0x014e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.net.WebApiClient.sendJsonRequest(com.umlaut.crowd.net.WebApiClient$RequestMethod, java.lang.String, java.lang.Object, com.umlaut.crowd.internal.vd[]):com.umlaut.crowd.net.WebApiResponse");
    }
}
