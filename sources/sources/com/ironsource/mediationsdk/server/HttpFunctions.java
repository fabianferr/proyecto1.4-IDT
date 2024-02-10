package com.ironsource.mediationsdk.server;

import com.ironsource.mediationsdk.z;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";
    private static final ExecutorService a = Executors.newSingleThreadExecutor();

    public static String getStringFromURL(String str) {
        return getStringFromURL(str, (z.a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringFromURL(java.lang.String r4, com.ironsource.mediationsdk.z.a r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x008b, all -> 0x007e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x008b, all -> 0x007e }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x008b, all -> 0x007e }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x008b, all -> 0x007e }
            r1 = 15000(0x3a98, float:2.102E-41)
            r4.setReadTimeout(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r4.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            java.lang.String r1 = "GET"
            r4.setRequestMethod(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r1 = 1
            r4.setDoInput(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r4.connect()     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            int r1 = r4.getResponseCode()     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 != r2) goto L_0x0035
            if (r5 == 0) goto L_0x002f
            java.lang.String r1 = "Bad Request - 400"
            r5.a(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
        L_0x002f:
            if (r4 == 0) goto L_0x0034
            r4.disconnect()
        L_0x0034:
            return r0
        L_0x0035:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            java.io.InputStream r2 = r4.getInputStream()     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            r1.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x006e }
        L_0x0048:
            java.lang.String r2 = r5.readLine()     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            if (r2 == 0) goto L_0x0052
            r1.append(r2)     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            goto L_0x0048
        L_0x0052:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0074, all -> 0x006e }
            if (r2 == 0) goto L_0x0065
            if (r4 == 0) goto L_0x0061
            r4.disconnect()
        L_0x0061:
            r5.close()
            return r0
        L_0x0065:
            if (r4 == 0) goto L_0x006a
            r4.disconnect()
        L_0x006a:
            r5.close()
            return r1
        L_0x006e:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r5
            r5 = r3
            goto L_0x0080
        L_0x0074:
            goto L_0x008e
        L_0x0076:
            r5 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0080
        L_0x007b:
            r5 = r0
            goto L_0x008e
        L_0x007e:
            r5 = move-exception
            r4 = r0
        L_0x0080:
            if (r0 == 0) goto L_0x0085
            r0.disconnect()
        L_0x0085:
            if (r4 == 0) goto L_0x008a
            r4.close()
        L_0x008a:
            throw r5
        L_0x008b:
            r4 = r0
            r5 = r4
        L_0x008e:
            if (r4 == 0) goto L_0x0093
            r4.disconnect()
        L_0x0093:
            if (r5 == 0) goto L_0x0098
            r5.close()
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.getStringFromURL(java.lang.String, com.ironsource.mediationsdk.z$a):java.lang.String");
    }

    public static void sendPostRequest(String str, String str2, a aVar) {
        sendPostRequestWithAutho(str, str2, (String) null, (String) null, aVar);
    }

    public static void sendPostRequestWithAutho(String str, String str2, String str3, String str4, a aVar) {
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = str2;
        final a aVar2 = aVar;
        a.submit(new Runnable() {
            /* JADX WARNING: type inference failed for: r1v0, types: [java.io.OutputStream, java.net.HttpURLConnection, java.lang.Throwable] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3 A[SYNTHETIC, Splitter:B:35:0x00b3] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4 A[SYNTHETIC, Splitter:B:43:0x00c4] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x00ce  */
            /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r8 = this;
                    r0 = 0
                    r1 = 0
                    java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    java.lang.String r3 = r2     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    if (r3 == 0) goto L_0x001c
                    java.lang.String r4 = r4     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    if (r4 != 0) goto L_0x0012
                    goto L_0x001c
                L_0x0012:
                    java.lang.String r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.getBase64Auth(r3, r4)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    java.lang.String r3 = "Authorization"
                    r1.setRequestProperty(r3, r2)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    throw r1     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                L_0x001c:
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                    r3 = 15000(0x3a98, float:2.102E-41)
                    r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x008a }
                    r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x008a }
                    java.lang.String r3 = "POST"
                    r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x008a }
                    r3 = 1
                    r2.setDoInput(r3)     // Catch:{ Exception -> 0x008a }
                    r2.setDoOutput(r3)     // Catch:{ Exception -> 0x008a }
                    java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ Exception -> 0x008a }
                    java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x008a }
                    java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x008a }
                    java.lang.String r6 = "UTF-8"
                    r5.<init>(r1, r6)     // Catch:{ Exception -> 0x008a }
                    r4.<init>(r5)     // Catch:{ Exception -> 0x008a }
                    java.lang.String r5 = r5     // Catch:{ Exception -> 0x008a }
                    r4.write(r5)     // Catch:{ Exception -> 0x008a }
                    r4.flush()     // Catch:{ Exception -> 0x008a }
                    r4.close()     // Catch:{ Exception -> 0x008a }
                    int r4 = r2.getResponseCode()     // Catch:{ Exception -> 0x008a }
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r4 != r5) goto L_0x005a
                    goto L_0x005b
                L_0x005a:
                    r3 = 0
                L_0x005b:
                    if (r3 != 0) goto L_0x0075
                    com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x008a }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008a }
                    java.lang.String r7 = "invalid response code "
                    r6.<init>(r7)     // Catch:{ Exception -> 0x008a }
                    r6.append(r4)     // Catch:{ Exception -> 0x008a }
                    java.lang.String r4 = " sending request"
                    r6.append(r4)     // Catch:{ Exception -> 0x008a }
                    java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x008a }
                    r5.error(r4)     // Catch:{ Exception -> 0x008a }
                L_0x0075:
                    com.ironsource.mediationsdk.server.a r4 = r6     // Catch:{ Exception -> 0x008a }
                    r4.a(r3)     // Catch:{ Exception -> 0x008a }
                    if (r1 == 0) goto L_0x0084
                    r1.close()     // Catch:{ IOException -> 0x0080 }
                    goto L_0x0084
                L_0x0080:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0084:
                    if (r2 == 0) goto L_0x00c0
                    r2.disconnect()
                    return
                L_0x008a:
                    r3 = move-exception
                    goto L_0x0092
                L_0x008c:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x00c2
                L_0x008f:
                    r2 = move-exception
                    r3 = r2
                    r2 = r1
                L_0x0092:
                    r3.printStackTrace()     // Catch:{ all -> 0x00c1 }
                    com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00c1 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
                    java.lang.String r6 = "exception while sending request "
                    r5.<init>(r6)     // Catch:{ all -> 0x00c1 }
                    java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c1 }
                    r5.append(r3)     // Catch:{ all -> 0x00c1 }
                    java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00c1 }
                    r4.error(r3)     // Catch:{ all -> 0x00c1 }
                    com.ironsource.mediationsdk.server.a r3 = r6     // Catch:{ all -> 0x00c1 }
                    r3.a(r0)     // Catch:{ all -> 0x00c1 }
                    if (r1 == 0) goto L_0x00bb
                    r1.close()     // Catch:{ IOException -> 0x00b7 }
                    goto L_0x00bb
                L_0x00b7:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x00bb:
                    if (r2 == 0) goto L_0x00c0
                    r2.disconnect()
                L_0x00c0:
                    return
                L_0x00c1:
                    r0 = move-exception
                L_0x00c2:
                    if (r1 == 0) goto L_0x00cc
                    r1.close()     // Catch:{ IOException -> 0x00c8 }
                    goto L_0x00cc
                L_0x00c8:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x00cc:
                    if (r2 == 0) goto L_0x00d1
                    r2.disconnect()
                L_0x00d1:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.AnonymousClass1.run():void");
            }
        });
    }
}
