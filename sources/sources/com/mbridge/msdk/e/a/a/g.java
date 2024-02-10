package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.m;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack */
public final class g extends a {
    private final b a;
    private final SSLSocketFactory b;

    /* compiled from: HurlStack */
    public interface b extends k {
    }

    public g() {
        this((b) null);
    }

    private g(b bVar) {
        this(bVar, (SSLSocketFactory) null);
    }

    private g(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.a = bVar;
        this.b = sSLSocketFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.e.a.a.f a(com.mbridge.msdk.e.a.m<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r7.f()
            if (r0 != 0) goto L_0x0052
            java.lang.String r0 = r7.h()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0013
            java.lang.String r0 = ""
            goto L_0x0056
        L_0x0013:
            byte[] r1 = r7.n()
            if (r1 == 0) goto L_0x0056
            int r2 = r1.length
            if (r2 != 0) goto L_0x001d
            goto L_0x0056
        L_0x001d:
            java.lang.String r2 = "?"
            boolean r3 = r0.endsWith(r2)
            if (r3 == 0) goto L_0x003a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0056
        L_0x003a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L_0x0056
        L_0x0052:
            java.lang.String r0 = r7.h()
        L_0x0056:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.c()
            r1.putAll(r8)
            com.mbridge.msdk.e.a.a.g$b r8 = r6.a
            if (r8 == 0) goto L_0x0085
            java.lang.String r8 = r8.a(r0)
            if (r8 == 0) goto L_0x0071
            r0 = r8
            goto L_0x0085
        L_0x0071:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "URL blocked by rewriter: "
            r8.<init>(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0085:
            java.net.URL r8 = new java.net.URL
            r8.<init>(r0)
            java.net.URLConnection r0 = r8.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r0.setInstanceFollowRedirects(r2)
            int r2 = r7.r()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r4 = "https"
            java.lang.String r8 = r8.getProtocol()
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L_0x00bf
            javax.net.ssl.SSLSocketFactory r8 = r6.b
            if (r8 == 0) goto L_0x00bf
            r4 = r0
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4
            r4.setSSLSocketFactory(r8)
        L_0x00bf:
            java.util.Set r8 = r1.keySet()     // Catch:{ all -> 0x017c }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x017c }
        L_0x00c7:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x00dd
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x017c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x017c }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x017c }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x017c }
            goto L_0x00c7
        L_0x00dd:
            int r8 = r7.f()     // Catch:{ all -> 0x017c }
            switch(r8) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0112;
                case 2: goto L_0x0109;
                case 3: goto L_0x0103;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00f7;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e8;
                default: goto L_0x00e4;
            }     // Catch:{ all -> 0x017c }
        L_0x00e4:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x017c }
            goto L_0x0176
        L_0x00e8:
            java.lang.String r8 = "PATCH"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.e.a.m<?>) r7)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x00f1:
            java.lang.String r8 = "TRACE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x00f7:
            java.lang.String r8 = "OPTIONS"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x00fd:
            java.lang.String r8 = "HEAD"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x0103:
            java.lang.String r8 = "DELETE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x0109:
            java.lang.String r8 = "PUT"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.e.a.m<?>) r7)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x0112:
            java.lang.String r8 = "POST"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.e.a.m<?>) r7)     // Catch:{ all -> 0x017c }
            goto L_0x0120
        L_0x011b:
            java.lang.String r8 = "GET"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x017c }
        L_0x0120:
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x017c }
            r1 = -1
            if (r8 == r1) goto L_0x016e
            int r7 = r7.f()     // Catch:{ all -> 0x017c }
            r1 = 4
            if (r7 == r1) goto L_0x0140
            r7 = 100
            if (r7 > r8) goto L_0x0136
            r7 = 200(0xc8, float:2.8E-43)
            if (r8 < r7) goto L_0x0140
        L_0x0136:
            r7 = 204(0xcc, float:2.86E-43)
            if (r8 == r7) goto L_0x0140
            r7 = 304(0x130, float:4.26E-43)
            if (r8 == r7) goto L_0x0140
            r7 = 1
            goto L_0x0141
        L_0x0140:
            r7 = 0
        L_0x0141:
            if (r7 != 0) goto L_0x0154
            com.mbridge.msdk.e.a.a.f r7 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x017c }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x017c }
            java.util.List r1 = a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x017c }
            r7.<init>(r8, r1)     // Catch:{ all -> 0x017c }
            r0.disconnect()
            return r7
        L_0x0154:
            com.mbridge.msdk.e.a.a.f r7 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x016b }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x016b }
            java.util.List r1 = a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x016b }
            int r2 = r0.getContentLength()     // Catch:{ all -> 0x016b }
            com.mbridge.msdk.e.a.a.g$a r4 = new com.mbridge.msdk.e.a.a.g$a     // Catch:{ all -> 0x016b }
            r4.<init>(r0)     // Catch:{ all -> 0x016b }
            r7.<init>(r8, r1, r2, r4)     // Catch:{ all -> 0x016b }
            return r7
        L_0x016b:
            r7 = move-exception
            r2 = 1
            goto L_0x017d
        L_0x016e:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x017c }
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)     // Catch:{ all -> 0x017c }
            throw r7     // Catch:{ all -> 0x017c }
        L_0x0176:
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)     // Catch:{ all -> 0x017c }
            throw r7     // Catch:{ all -> 0x017c }
        L_0x017c:
            r7 = move-exception
        L_0x017d:
            if (r2 != 0) goto L_0x0182
            r0.disconnect()
        L_0x0182:
            goto L_0x0184
        L_0x0183:
            throw r7
        L_0x0184:
            goto L_0x0183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.a.a.g.a(com.mbridge.msdk.e.a.m, java.util.Map):com.mbridge.msdk.e.a.a.f");
    }

    private static List<com.mbridge.msdk.e.a.g> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String gVar : (List) next.getValue()) {
                    arrayList.add(new com.mbridge.msdk.e.a.g((String) next.getKey(), gVar));
                }
            }
        }
        return arrayList;
    }

    /* compiled from: HurlStack */
    static class a extends FilterInputStream {
        private final HttpURLConnection a;

        a(HttpURLConnection httpURLConnection) {
            super(g.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        public final void close() throws IOException {
            super.close();
            this.a.disconnect();
        }
    }

    /* access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private void a(HttpURLConnection httpURLConnection, m<?> mVar) throws IOException {
        byte[] n = mVar.n();
        if (n != null) {
            a(httpURLConnection, mVar, n);
        }
    }

    private void a(HttpURLConnection httpURLConnection, m<?> mVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", mVar.m());
        }
        int length = bArr.length;
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
