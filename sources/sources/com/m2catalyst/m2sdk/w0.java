package com.m2catalyst.m2sdk;

import android.os.Build;
import com.facebook.internal.security.CertificateUtil;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: Connection */
public final class w0 {
    public static final String g;
    public static final String h;
    public Socket a;
    public final String b;
    public final int c;
    public final int d = 0;
    public PrintStream e = null;
    public InputStreamReader f = null;

    static {
        StringBuilder sb = new StringBuilder("Speedtest-Android/1.2.3 (SDK ");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        sb.append("; ");
        sb.append(Build.PRODUCT);
        sb.append("; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(")");
        g = sb.toString();
        h = i >= 21 ? Locale.getDefault().toLanguageTag() : null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4 A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w0(java.lang.String r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            java.lang.String r0 = "http:"
            r7.<init>()
            r1 = 0
            r7.d = r1
            r2 = 0
            r7.e = r2
            r7.f = r2
            java.util.Locale r2 = java.util.Locale.getDefault()
            r2.toString()
            java.lang.String r2 = "http://"
            boolean r2 = r8.startsWith(r2)
            r3 = 1
            if (r2 == 0) goto L_0x0038
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x0030 }
            r0.<init>(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r0.getHost()     // Catch:{ all -> 0x0030 }
            r7.b = r8     // Catch:{ all -> 0x0030 }
            int r8 = r0.getPort()     // Catch:{ all -> 0x0030 }
            r7.c = r8     // Catch:{ all -> 0x0030 }
            r8 = 1
            goto L_0x007b
        L_0x0030:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed URL (HTTP)"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.String r2 = "https://"
            boolean r2 = r8.startsWith(r2)
            if (r2 == 0) goto L_0x005c
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x0054 }
            r0.<init>(r8)     // Catch:{ all -> 0x0054 }
            java.lang.String r8 = r0.getHost()     // Catch:{ all -> 0x0054 }
            r7.b = r8     // Catch:{ all -> 0x0054 }
            int r8 = r0.getPort()     // Catch:{ all -> 0x0054 }
            r7.c = r8     // Catch:{ all -> 0x0054 }
            r8 = 0
        L_0x0052:
            r1 = 1
            goto L_0x007b
        L_0x0054:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed URL (HTTPS)"
            r8.<init>(r9)
            throw r8
        L_0x005c:
            java.lang.String r1 = "//"
            boolean r1 = r8.startsWith(r1)
            if (r1 == 0) goto L_0x0117
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r0.concat(r8)     // Catch:{ all -> 0x010f }
            r1.<init>(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r1.getHost()     // Catch:{ all -> 0x010f }
            r7.b = r8     // Catch:{ all -> 0x010f }
            int r8 = r1.getPort()     // Catch:{ all -> 0x010f }
            r7.c = r8     // Catch:{ all -> 0x010f }
            r8 = 1
            goto L_0x0052
        L_0x007b:
            r0 = -1
            if (r1 == 0) goto L_0x00b0
            javax.net.SocketFactory r1 = javax.net.ssl.SSLSocketFactory.getDefault()     // Catch:{ all -> 0x00b0 }
            java.net.Socket r1 = r1.createSocket()     // Catch:{ all -> 0x00b0 }
            r7.a = r1     // Catch:{ all -> 0x00b0 }
            r2 = 443(0x1bb, float:6.21E-43)
            if (r9 <= 0) goto L_0x009d
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = r7.b     // Catch:{ all -> 0x00b0 }
            int r6 = r7.c     // Catch:{ all -> 0x00b0 }
            if (r6 != r0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r2 = r6
        L_0x0096:
            r4.<init>(r5, r2)     // Catch:{ all -> 0x00b0 }
            r1.connect(r4, r9)     // Catch:{ all -> 0x00b0 }
            goto L_0x00ad
        L_0x009d:
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = r7.b     // Catch:{ all -> 0x00b0 }
            int r6 = r7.c     // Catch:{ all -> 0x00b0 }
            if (r6 != r0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r2 = r6
        L_0x00a7:
            r4.<init>(r5, r2)     // Catch:{ all -> 0x00b0 }
            r1.connect(r4)     // Catch:{ all -> 0x00b0 }
        L_0x00ad:
            r1 = 2
            r7.d = r1     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            int r1 = r7.d     // Catch:{ all -> 0x00e8 }
            if (r1 != 0) goto L_0x00e9
            if (r8 == 0) goto L_0x00e9
            javax.net.SocketFactory r8 = javax.net.SocketFactory.getDefault()     // Catch:{ all -> 0x00e8 }
            java.net.Socket r8 = r8.createSocket()     // Catch:{ all -> 0x00e8 }
            r7.a = r8     // Catch:{ all -> 0x00e8 }
            r1 = 80
            if (r9 <= 0) goto L_0x00d5
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = r7.b     // Catch:{ all -> 0x00e8 }
            int r5 = r7.c     // Catch:{ all -> 0x00e8 }
            if (r5 != r0) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r1 = r5
        L_0x00ce:
            r2.<init>(r4, r1)     // Catch:{ all -> 0x00e8 }
            r8.connect(r2, r9)     // Catch:{ all -> 0x00e8 }
            goto L_0x00e5
        L_0x00d5:
            java.net.InetSocketAddress r9 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r7.b     // Catch:{ all -> 0x00e8 }
            int r4 = r7.c     // Catch:{ all -> 0x00e8 }
            if (r4 != r0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r1 = r4
        L_0x00df:
            r9.<init>(r2, r1)     // Catch:{ all -> 0x00e8 }
            r8.connect(r9)     // Catch:{ all -> 0x00e8 }
        L_0x00e5:
            r7.d = r3     // Catch:{ all -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
        L_0x00e9:
            int r8 = r7.d
            if (r8 == 0) goto L_0x0107
            if (r10 <= 0) goto L_0x00f6
            java.net.Socket r8 = r7.a     // Catch:{ all -> 0x00f5 }
            r8.setSoTimeout(r10)     // Catch:{ all -> 0x00f5 }
            goto L_0x00f6
        L_0x00f5:
        L_0x00f6:
            if (r11 <= 0) goto L_0x00ff
            java.net.Socket r8 = r7.a     // Catch:{ all -> 0x00fe }
            r8.setReceiveBufferSize(r11)     // Catch:{ all -> 0x00fe }
            goto L_0x00ff
        L_0x00fe:
        L_0x00ff:
            if (r12 <= 0) goto L_0x0106
            java.net.Socket r8 = r7.a     // Catch:{ all -> 0x0106 }
            r8.setSendBufferSize(r12)     // Catch:{ all -> 0x0106 }
        L_0x0106:
            return
        L_0x0107:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Failed to connect"
            r8.<init>(r9)
            throw r8
        L_0x010f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed URL (HTTP/HTTPS)"
            r8.<init>(r9)
            throw r8
        L_0x0117:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed URL (Unknown or unspecified protocol)"
            r8.<init>(r9)
            goto L_0x0120
        L_0x011f:
            throw r8
        L_0x0120:
            goto L_0x011f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.w0.<init>(java.lang.String, int, int, int, int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:7|8|9|(2:10|11)|14|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "\r\n"
            java.lang.String r1 = "Accept-Language: "
            java.lang.String r2 = "User-Agent: "
            java.lang.String r3 = "Host: "
            java.lang.String r4 = "/"
            java.lang.String r5 = "GET "
            boolean r6 = r11.startsWith(r4)     // Catch:{ all -> 0x0093 }
            if (r6 != 0) goto L_0x0016
            java.lang.String r11 = r4.concat(r11)     // Catch:{ all -> 0x0093 }
        L_0x0016:
            java.io.PrintStream r4 = r10.e     // Catch:{ all -> 0x0093 }
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.io.PrintStream r6 = new java.io.PrintStream     // Catch:{ all -> 0x002f }
            java.net.Socket r7 = r10.a     // Catch:{ all -> 0x0024 }
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ all -> 0x0024 }
            goto L_0x0025
        L_0x0024:
            r7 = r4
        L_0x0025:
            java.lang.String r8 = "utf-8"
            r9 = 0
            r6.<init>(r7, r9, r8)     // Catch:{ all -> 0x002f }
            r10.e = r6     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            r10.e = r4     // Catch:{ all -> 0x0093 }
        L_0x0031:
            java.io.PrintStream r4 = r10.e     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r6.append(r11)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = " HTTP/1.1\r\n"
            r6.append(r11)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x0093 }
            r4.print(r11)     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r11.<init>(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = r10.b     // Catch:{ all -> 0x0093 }
            r11.append(r3)     // Catch:{ all -> 0x0093 }
            r11.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0093 }
            r4.print(r11)     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r11.<init>(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = g     // Catch:{ all -> 0x0093 }
            r11.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0093 }
            r4.print(r11)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = "Connection: keep-alive\r\n"
            r4.print(r11)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = "Accept-Encoding: identity\r\n"
            r4.print(r11)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = h     // Catch:{ all -> 0x0093 }
            if (r11 == 0) goto L_0x008c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>(r1)     // Catch:{ all -> 0x0093 }
            r2.append(r11)     // Catch:{ all -> 0x0093 }
            r2.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x0093 }
            r4.print(r11)     // Catch:{ all -> 0x0093 }
        L_0x008c:
            r4.print(r0)     // Catch:{ all -> 0x0093 }
            r4.flush()     // Catch:{ all -> 0x0093 }
            return
        L_0x0093:
            java.lang.Exception r11 = new java.lang.Exception
            java.lang.String r0 = "Failed to send GET request"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.w0.a(java.lang.String):void");
    }

    public final HashMap<String, String> b() {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            String c2 = c();
            if (c2.contains("200 OK")) {
                while (true) {
                    String c3 = c();
                    if (c3.trim().isEmpty()) {
                        return hashMap;
                    }
                    if (c3.contains(CertificateUtil.DELIMITER)) {
                        hashMap.put(c3.substring(0, c3.indexOf(CertificateUtil.DELIMITER)).trim().toLowerCase(), c3.substring(c3.indexOf(CertificateUtil.DELIMITER) + 1).trim());
                    }
                }
            } else {
                throw new Exception("Did not receive an HTTP 200 (" + c2.trim() + ")");
            }
        } catch (Throwable th) {
            throw new Exception("Failed to get response headers (" + th + ")");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|7|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c() {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStreamReader r1 = r5.f     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x001a
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0018 }
            java.net.Socket r2 = r5.a     // Catch:{ all -> 0x000e }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ all -> 0x000e }
            goto L_0x000f
        L_0x000e:
            r2 = r0
        L_0x000f:
            java.lang.String r3 = "utf-8"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0018 }
            r5.f = r1     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r5.f = r0     // Catch:{ all -> 0x0035 }
        L_0x001a:
            java.io.InputStreamReader r1 = r5.f     // Catch:{ all -> 0x0035 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0035 }
            r2.<init>()     // Catch:{ all -> 0x0035 }
        L_0x0021:
            int r3 = r1.read()     // Catch:{ all -> 0x0035 }
            r4 = -1
            if (r3 != r4) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            char r4 = (char) r3     // Catch:{ all -> 0x0035 }
            r2.append(r4)     // Catch:{ all -> 0x0035 }
            r4 = 10
            if (r3 != r4) goto L_0x0021
        L_0x0031:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0035 }
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.w0.c():java.lang.String");
    }

    public final void a(String str, boolean z, String str2, long j) {
        OutputStream outputStream;
        String str3 = str;
        long j2 = j;
        try {
            if (!str3.startsWith("/")) {
                str3 = "/".concat(str3);
            }
            if (this.e == null) {
                try {
                    outputStream = this.a.getOutputStream();
                } catch (Throwable unused) {
                    outputStream = null;
                }
                this.e = new PrintStream(outputStream, false, "utf-8");
            }
        } catch (Throwable unused2) {
            throw new Exception("Failed to send POST request");
        }
        PrintStream printStream = this.e;
        printStream.print("POST " + str3 + " HTTP/1.1\r\n");
        printStream.print("Host: " + this.b + "\r\n");
        printStream.print("User-Agent: " + g + "\r\n");
        StringBuilder sb = new StringBuilder("Connection: ");
        sb.append(z ? "keep-alive" : "close");
        sb.append("\r\n");
        printStream.print(sb.toString());
        printStream.print("Accept-Encoding: identity\r\n");
        String str4 = h;
        if (str4 != null) {
            printStream.print("Accept-Language: " + str4 + "\r\n");
        }
        printStream.print("Content-Type: " + str2 + "\r\n");
        printStream.print("Content-Encoding: identity\r\n");
        if (j2 >= 0) {
            printStream.print("Content-Length: " + j2 + "\r\n");
        }
        printStream.print("\r\n");
        printStream.flush();
    }

    public final void a() {
        try {
            this.a.close();
        } catch (Throwable unused) {
        }
        this.a = null;
    }
}
