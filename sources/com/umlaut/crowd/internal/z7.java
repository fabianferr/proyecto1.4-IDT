package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.format.Formatter;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class z7 {
    private static final boolean f = false;
    private static final String g = "z7";
    private static final int h = 5000;
    private static final int i = 5000;
    private static final int j = 1900;
    private static final String k = "\r\n";
    private static final String l = "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 1\r\nST: urn:schemas-upnp-org:device:InternetGatewayDevice:1\r\n\r\n";
    private long a = 0;
    /* access modifiers changed from: private */
    public b b = new b();
    /* access modifiers changed from: private */
    public final AtomicBoolean c = new AtomicBoolean(false);
    private final long d = InsightCore.getInsightConfig().k2();
    private long e = 0;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            b bVar = new b();
            if (!this.a.isEmpty()) {
                bVar = z7.this.d(this.a);
                if (Build.VERSION.SDK_INT < 30) {
                    String b2 = z7.this.b(this.a);
                    if (!b2.isEmpty()) {
                        bVar.b = b2;
                    }
                }
                synchronized (z7.this) {
                    b unused = z7.this.b = bVar;
                }
            }
            if (this.a.isEmpty() || !bVar.a) {
                z7.a(z7.this);
            }
            z7.this.c.set(false);
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public boolean a = false;
        public String b = "";
        public String c = "";
        public String d = "";
        public String e = "";
    }

    public void c() {
        synchronized (this) {
            this.b = new b();
        }
        this.a = 0;
        this.e = 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.internal.z7.b d(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]
            com.umlaut.crowd.internal.z7$b r2 = new com.umlaut.crowd.internal.z7$b
            r2.<init>()
            java.lang.String r3 = "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 1\r\nST: urn:schemas-upnp-org:device:InternetGatewayDevice:1\r\n\r\n"
            byte[] r3 = r3.getBytes()
            r4 = 0
            java.net.DatagramSocket r5 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x007e }
            r5.<init>()     // Catch:{ Exception -> 0x007e }
            r4 = 5000(0x1388, float:7.006E-42)
            r5.setSoTimeout(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.net.DatagramPacket r4 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            int r6 = r3.length     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r7 = "239.255.255.250"
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r7)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r8 = 1900(0x76c, float:2.662E-42)
            r4.<init>(r3, r6, r7, r8)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r5.send(r4)     // Catch:{ IOException -> 0x002c }
            goto L_0x0034
        L_0x002c:
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r5.send(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
        L_0x0034:
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
        L_0x0038:
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r6.<init>(r1, r0)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r5.receive(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            byte[] r6 = r6.getData()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r6 = 0
            r8 = 12
            java.lang.String r6 = r7.substring(r6, r8)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r8 = "HTTP/1.1 200"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r6 == 0) goto L_0x0068
            boolean r6 = r7.contains(r12)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r6 == 0) goto L_0x0068
            java.lang.String r12 = com.umlaut.crowd.internal.hd.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            com.umlaut.crowd.internal.z7$b r12 = r11.c(r12)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r2 = r12
            goto L_0x0073
        L_0x0068:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            long r6 = r6 - r3
            r8 = 5000(0x1388, double:2.4703E-320)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0038
        L_0x0073:
            r5.close()
            goto L_0x009a
        L_0x0077:
            r12 = move-exception
            goto L_0x009c
        L_0x0079:
            r12 = move-exception
            r4 = r5
            goto L_0x007f
        L_0x007c:
            r12 = move-exception
            goto L_0x009b
        L_0x007e:
            r12 = move-exception
        L_0x007f:
            java.lang.String r0 = g     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r1.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "gatewayOverUPnP: "
            r1.append(r3)     // Catch:{ all -> 0x007c }
            r1.append(r12)     // Catch:{ all -> 0x007c }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x007c }
            android.util.Log.i(r0, r12)     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x009a
            r4.close()
        L_0x009a:
            return r2
        L_0x009b:
            r5 = r4
        L_0x009c:
            if (r5 == 0) goto L_0x00a1
            r5.close()
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r12
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.z7.d(java.lang.String):com.umlaut.crowd.internal.z7$b");
    }

    static /* synthetic */ long a(z7 z7Var) {
        long j2 = z7Var.a;
        z7Var.a = 1 + j2;
        return j2;
    }

    public boolean b() {
        return this.b.a;
    }

    /* access modifiers changed from: private */
    public String b(String str) {
        if (!str.isEmpty()) {
            for (String str2 : i9.b("ip neighbor")) {
                if (str2.startsWith(str + " ")) {
                    String[] split = str2.split(" ");
                    if (split.length >= 6 && split[3].equals("lladdr")) {
                        return split[4];
                    }
                }
            }
        }
        return "";
    }

    public static String a(WifiManager wifiManager, ConnectivityManager connectivityManager, Context context) {
        Network activeNetwork;
        LinkProperties linkProperties;
        DhcpInfo dhcpInfo;
        int i2;
        if (wifiManager != null && context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != -1 && (dhcpInfo = wifiManager.getDhcpInfo()) != null && (i2 = dhcpInfo.gateway) != 0) {
            return Formatter.formatIpAddress(i2);
        }
        if (!(connectivityManager == null || Build.VERSION.SDK_INT < 23 || context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1 || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null || linkProperties.getRoutes() == null || linkProperties.getRoutes().size() <= 0)) {
            for (RouteInfo next : linkProperties.getRoutes()) {
                try {
                    if (next.isDefaultRoute() && next.getGateway() != null) {
                        return next.getGateway().getHostAddress();
                    }
                } catch (NoSuchFieldError unused) {
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e0 A[SYNTHETIC, Splitter:B:45:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ec A[SYNTHETIC, Splitter:B:51:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f2 A[SYNTHETIC, Splitter:B:56:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fe A[SYNTHETIC, Splitter:B:62:0x00fe] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.umlaut.crowd.internal.z7.b c(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "\r\n"
            com.umlaut.crowd.internal.z7$b r1 = new com.umlaut.crowd.internal.z7$b
            r1.<init>()
            if (r10 == 0) goto L_0x0102
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L_0x0011
            goto L_0x0102
        L_0x0011:
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            r3.<init>(r10)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            java.net.Socket r10 = new java.net.Socket     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            java.lang.String r4 = r3.getHost()     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            int r5 = r3.getPort()     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            r10.<init>(r4, r5)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
            r4 = 0
            r10.setKeepAlive(r4)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r5 = 5000(0x1388, float:7.006E-42)
            r10.setSoTimeout(r5)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            java.io.OutputStream r6 = r10.getOutputStream()     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b7 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b7 }
            java.io.InputStream r8 = r10.getInputStream()     // Catch:{ Exception -> 0x00b7 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b7 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = "GET "
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r2 = r3.getPath()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r2 = " HTTP/1.0"
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r2 = "HOST: "
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r2 = r3.getHost()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r2 = "Connection: close"
            r5.print(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.print(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.flush()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r0.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r2 = 1
            r3 = 1
        L_0x007c:
            java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r7 == 0) goto L_0x0091
            if (r3 == 0) goto L_0x008c
            java.lang.String r8 = ""
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r8 == 0) goto L_0x007c
        L_0x008c:
            r0.append(r7)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r3 = 0
            goto L_0x007c
        L_0x0091:
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            com.umlaut.crowd.internal.z7$b r1 = com.umlaut.crowd.internal.hd.a((java.io.InputStream) r3)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            boolean unused = r1.a = r2     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r6.close()     // Catch:{ IOException -> 0x00a8 }
        L_0x00a8:
            r5.close()
            r10.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x00ef
        L_0x00af:
            r0 = move-exception
            r2 = r6
            goto L_0x00f0
        L_0x00b2:
            r0 = move-exception
            r2 = r6
            goto L_0x00c8
        L_0x00b5:
            r0 = move-exception
            goto L_0x00f0
        L_0x00b7:
            r0 = move-exception
            goto L_0x00c8
        L_0x00b9:
            r0 = move-exception
            r5 = r2
            goto L_0x00f0
        L_0x00bc:
            r0 = move-exception
            r5 = r2
            goto L_0x00c8
        L_0x00bf:
            r10 = move-exception
            r0 = r10
            r10 = r2
            r5 = r10
            goto L_0x00f0
        L_0x00c4:
            r10 = move-exception
            r0 = r10
            r10 = r2
            r5 = r10
        L_0x00c8:
            java.lang.String r3 = g     // Catch:{ all -> 0x00b5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r4.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = "parseRouterData: "
            r4.append(r6)     // Catch:{ all -> 0x00b5 }
            r4.append(r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00b5 }
            android.util.Log.i(r3, r0)     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00e5
        L_0x00e4:
        L_0x00e5:
            if (r5 == 0) goto L_0x00ea
            r5.close()
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            return r1
        L_0x00f0:
            if (r2 == 0) goto L_0x00f7
            r2.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
        L_0x00f7:
            if (r5 == 0) goto L_0x00fc
            r5.close()
        L_0x00fc:
            if (r10 == 0) goto L_0x0101
            r10.close()     // Catch:{ IOException -> 0x0101 }
        L_0x0101:
            throw r0
        L_0x0102:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.z7.c(java.lang.String):com.umlaut.crowd.internal.z7$b");
    }

    public b a() {
        return this.b;
    }

    public void a(String str) {
        long pow = ((long) Math.pow((double) this.a, 2.0d)) * 5000;
        if (!this.b.a && this.d > 0 && SystemClock.elapsedRealtime() - this.e >= this.d + pow && this.c.compareAndSet(false, true)) {
            ThreadManager.getInstance().getCachedThreadPool().execute(new a(str));
            this.e = SystemClock.elapsedRealtime();
        }
    }
}
